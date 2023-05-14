package xczl.xczltools.Item.Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xczl.xczltools.Item.ModBlock;

public class TempStorageBlockEntity extends BlockEntity implements ImplementedInventory{
    static private final DefaultedList<ItemStack> items = DefaultedList.ofSize(20,ItemStack.EMPTY);

    public TempStorageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlock.TEMP_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems(){
        return items;
    }

    //反序列化方块实体
    @Override
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        Inventories.readNbt(nbt,items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }

    //将服务器数据同步到客户端
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public static void tick(World world, BlockPos pos, BlockState state, TempStorageBlockEntity be){

    }
}
