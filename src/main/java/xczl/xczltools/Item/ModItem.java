package xczl.xczltools.Item;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

    public static final Item TEMP_TOOL = ModItem.registerItem("temp_tool", new SuperTool(SuperToolMaterial.INSTANCE, new FabricItemSettings()));

    public static final Item TEMP_ITEM = ModItem.registerItem("temp_item",new TestFood(new FabricItemSettings()));

    public static final Item TEMP_SEED = ModItem.registerItem("temp_seed",new AliasedBlockItem(ModBlock.CROP_BLOCK,new FabricItemSettings()));

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
    }

    public static void addItemToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(content  ->{
            content.add(item);
        });
    }
}