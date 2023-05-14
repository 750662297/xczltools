package xczl.xczltools.Item.Blocks.chest;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class TempChestBlock extends BlockWithEntity {
    public TempChestBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TempChestBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType( BlockState state){
        return BlockRenderType.MODEL;
    }

//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack){
//        if(itemStack.hasCustomName()){
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if(blockEntity instanceof TempChestBlockEntity){
//                ((TempChestBlockEntity)blockEntity).setCustomName(itemStack.getName());
//            }
//        }
//    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world,pos);

            if(screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    //让方块被破坏时物品全部掉落
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved){
        if(state.getBlock()!=newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof TempChestBlockEntity){
                ItemScatterer.spawn(world, pos, (TempChestBlockEntity)blockEntity);

                world.updateComparators(pos,this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state){
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos){
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}
