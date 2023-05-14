package xczl.xczltools.Item.Blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xczl.xczltools.Item.ModBlock;

import java.util.List;

public class TempStorageBlock extends BlockWithEntity implements BlockEntityProvider {
    public TempStorageBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TempStorageBlockEntity(pos,state);
    }

    @Override
    public ActionResult  onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult){
        if(world.isClient){
            return ActionResult.SUCCESS;
        }

        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

        if(!player.getStackInHand(hand).isEmpty()){
            // 检查第一个打开的槽位是什么，并从玩家手中放入物品
            int i=0;
            for(;i<blockEntity.size()-1 ;i++)
            {
                if(!blockEntity.getStack(i).isEmpty())
                {
                    continue;
                }

                blockEntity.setStack(i,player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
                break;
            }

            if(i == blockEntity.size()-1 && player.getStackInHand(hand).getCount() !=0)
            {
                // 如果物品栏是满的，我们输出其内容
                System.out.println("The slots is not empty");
            }
        }
        else {
            // 如果玩家没有持有任何东西，我们依次将方块实体中的物品给予玩家
            for(int i=blockEntity.size() - 1;i>=0;i--)
            {
                if(blockEntity.getStack(i).isEmpty())
                {
                    continue;
                }

                player.getInventory().offerOrDrop(blockEntity.getStack(i));
                blockEntity.removeStack(i);
                break;
            }
        }

        return ActionResult.SUCCESS;
    }

    //更改方块实体刻
    @Override
    public BlockRenderType getRenderType(BlockState state){
        // 由于继承了BlockWithEntity，这个默认为INVISIBLE，所以我们需要更改它！
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlock.TEMP_BLOCK_ENTITY, (world1, pos, state1, be) -> TempStorageBlockEntity.tick(world,pos,state,be));
    }
}
