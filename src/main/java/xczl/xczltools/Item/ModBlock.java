package xczl.xczltools.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.Blocks.TempStorageBlock;
import xczl.xczltools.Item.Blocks.TempStorageBlockEntity;
import xczl.xczltools.Item.seeds.CustomCropBlock;
import xczl.xczltools.Xczltools;

public class ModBlock {
    public static final Block TEMP_BLOCK = ModBlock.registerBlock("temp_storage_block",new TempStorageBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f)),ModItemGroup.ModGroup,false);
    public static final BlockEntityType<TempStorageBlockEntity> TEMP_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Xczltools.MODID,"temp_storage_block_entity"),
            FabricBlockEntityTypeBuilder.create(TempStorageBlockEntity::new,TEMP_BLOCK).build());


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
