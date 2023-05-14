package xczl.xczltools.Item.Blocks.chest;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.system.Pointer;
import xczl.xczltools.Item.Blocks.ImplementedInventory;
import xczl.xczltools.Item.ModBlock;

public class TempChestBlockEntity extends  LootableContainerBlockEntity {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INVERTORY_SIZE,ItemStack.EMPTY);

    private static final int INVERTORY_SIZE = 78;


    public TempChestBlockEntity(BlockPos blockPos, BlockState blockState){
        super(ModBlock.TEMP_CHEST_BLOCK_ENTITY_TYPE,blockPos,blockState);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new TempChestScreenHandler(syncId,playerInventory, this);
    }

    @Override
    public int size() {
        return INVERTORY_SIZE;
    }

    @Override
    public void readNbt(NbtCompound nbt){
//        super.readNbt(nbt);
//        Inventories.readNbt(nbt,this.inventory);
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inventory);
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt){
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }
}
