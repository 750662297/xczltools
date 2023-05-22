package xczl.xczltools.Item.Blocks.chest;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class TempChestBlock extends BlockWithEntity {
//    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
//    protected static final VoxelShape DOUBLE_NORTH_SHAPE = Block.createCuboidShape(1.0, 0.0, 0.0, 15.0, 14.0, 15.0);
//    protected static final VoxelShape DOUBLE_SOUTH_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 14.0, 16.0);
//    protected static final VoxelShape DOUBLE_WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 1.0, 15.0, 14.0, 15.0);
//    protected static final VoxelShape DOUBLE_EAST_SHAPE = Block.createCuboidShape(1.0, 1.0, 0.0, 15.0, 14.0, 15.0);
    protected static final VoxelShape DEFAULT_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 14.0, 15.0);

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

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        Direction dir = state.get(FACING);
//        switch (dir) {
//            default: {
//                return DOUBLE_NORTH_SHAPE;
//            }
//            case SOUTH: {
//                return DOUBLE_SOUTH_SHAPE;
//            }
//            case WEST: {
//                return DOUBLE_WEST_SHAPE;
//            }
//            case EAST:
//        }
        return DEFAULT_SHAPE;
    }

    //暂时注释放置时朝向的代码
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(Properties.HORIZONTAL_FACING);
//    }
//
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return super.getPlacementState(ctx).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
//    }
}
