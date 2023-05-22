package xczl.xczltools.Item;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.Tools.SuperTool;
import xczl.xczltools.Item.Tools.SuperToolMaterial;
import xczl.xczltools.Item.foods.TestFood;
import xczl.xczltools.Xczltools;

import java.util.Vector;

public class ModItem {
    private static final Vector<Item> vec=new Vector<Item>();

    //super tools部分
    public static final Item WOOD_TOOL = ModItem.registerItem("wooden_tool", new SuperTool(SuperToolMaterial.WOOD_INSTANCE, new FabricItemSettings()));
    public static final Item STONE_TOOL = ModItem.registerItem("stone_tool", new SuperTool(SuperToolMaterial.STONE_INSTANCE, new FabricItemSettings()));
    public static final Item IRON_TOOL = ModItem.registerItem("iron_tool", new SuperTool(SuperToolMaterial.IRON_INSTANCE, new FabricItemSettings()));
    public static final Item GOLD_TOOL = ModItem.registerItem("golden_tool", new SuperTool(SuperToolMaterial.GOLD_INSTANCE, new FabricItemSettings()));
    public static final Item DIAMOND_TOOL = ModItem.registerItem("diamond_tool", new SuperTool(SuperToolMaterial.DIAMOND_INSTANCE, new FabricItemSettings()));
    public static final Item NETHERITE_TOOL = ModItem.registerItem("netherite_tool", new SuperTool(SuperToolMaterial.NETHERITE_INSTANCE, new FabricItemSettings()));
    public static final Item TEMP_TOOL = ModItem.registerItem("temp_tool", new SuperTool(SuperToolMaterial.TEMP_INSTANCE, new FabricItemSettings()));

    public static final Item TEMP_ITEM = ModItem.registerItem("temp_item",new TestFood(new FabricItemSettings()));

    public static final Item TEMP_SEED = ModItem.registerItem("temp_seed",new AliasedBlockItem(ModBlock.CROP_BLOCK,new FabricItemSettings()));

    public static final Item temp_item = ModItem.registerItem("temp_storage_block",new BlockItem(ModBlock.TEMP_BLOCK,new FabricItemSettings()));

    public static final Item temp_chest_item = ModItem.registerItem("temp_chest",new BlockItem(ModBlock.TEMP_CHEST_BLOCK, new FabricItemSettings()));
    public static void  item(){

    }

    private static Item registerItem(String name, Item item){
        Item temp= Registry.register(Registries.ITEM, new Identifier(Xczltools.MODID,name),item);
        vec.add(temp);
        return temp;
    }

    public static void addItemsToItemGroup(){
        for(Item i: vec)
        {
            addItemToItemGroup(ModItemGroup.ModGroup,i);
        }

//        Registry.register(Registries.ITEM, new Identifier(Xczltools.MODID, "temp_block"), new BlockItem(ModBlock.TEMP_BLOCK, new FabricItemSettings()));
    }

    public static void addItemToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(content  ->{
            content.add(item);
        });
    }
}