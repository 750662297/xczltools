package xczl.xczltools.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.seeds.CustomCropBlock;
import xczl.xczltools.Xczltools;

public class ModBlock {
    public static final Block CROP_BLOCK = ModBlock.registerBlock("crop_block",new CustomCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT).breakInstantly().nonOpaque()),ModItemGroup.ModGroup,false);

    public static void block(){

    }

    private static Block registerBlock(String name, Block entry,ItemGroup group, boolean isAddToGroup){
        if(isAddToGroup)
        {
            registerBlockItem(name,entry, group);
        }

        return Registry.register(Registries.BLOCK, new Identifier(Xczltools.MODID,name),entry);
    }

    private static void registerBlockItem(String name, Block entry, ItemGroup group){
        Item item = Registry.register(Registries.ITEM, new Identifier(Xczltools.MODID,name), new BlockItem(entry, new Item.Settings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(output -> output.add(item));
    }


}
