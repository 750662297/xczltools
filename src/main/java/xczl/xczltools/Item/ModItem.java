package xczl.xczltools.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.Tools.SuperTool;
import xczl.xczltools.Item.Tools.SuperToolMaterial;
import xczl.xczltools.Xczltools;

import java.util.Vector;

public class ModItem {
    private static final Vector<Item> vec=new Vector<Item>();

    public static final Item TEMP_TOOL = ModItem.registerItem("temp_tool", new SuperTool(SuperToolMaterial.INSTANCE, new FabricItemSettings()));

//    public static final Item CROP_ITEM = ModItem.registerItem("crop_item",new AliasedBlockItem(ModBlock.CROP_BLOCK,new FabricItemSettings()));
    public static final Item CROP_ITEM = ModItem.registerItem("crop_item",new AliasedBlockItem(ModBlock.CROP_BLOCK,new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).build())));

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