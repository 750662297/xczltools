package xczl.xczltools.Item.seeds;

import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import xczl.xczltools.Item.ModItem;

public class CustomCropBlock extends CropBlock {

    public static final IntProperty AGE = Properties.AGE_3;

    @Override
    public int getMaxAge(){
        return 3;
    }

    @Override
    public IntProperty getAgeProperty(){
        return AGE;
    }

    public CustomCropBlock(Settings settings) {
        super(settings);
        this. setDefaultState(this.getStateManager().getDefaultState().with(AGE,0));
    }

    public ItemConvertible getSeedItem(){
        return ModItem.TEMP_SEED;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(AGE);
    }

}
