package xczl.xczltools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import xczl.xczltools.Item.SuperTool;
import xczl.xczltools.Item.SuperToolMaterial;

public class Xczltools implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
//    public static final Block STONE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static final ToolItem TEMP_TOOL = new SuperTool(SuperToolMaterial.INSTANCE, new Item.Settings());
    private static final ItemGroup TEMP_GROUP = FabricItemGroup.builder(new Identifier("xczltools", "xczl_group"))
            .icon(() -> new ItemStack(TEMP_TOOL))
            .build();

    @Override
    public void onInitialize() {
//        Registry.register(Registries.BLOCK, new Identifier("xczltools","stone_block"),STONE_BLOCK);
//        Registry.register(Registries.ITEM, new Identifier("xczltools","stone_block"),new BlockItem(STONE_BLOCK,new FabricItemSettings()));

        Registry.register(Registries.ITEM, new Identifier("xczltools","temp_tool"),TEMP_TOOL);
        ItemGroupEvents.modifyEntriesEvent(TEMP_GROUP).register(content  ->{
            content.add(TEMP_TOOL);
//            content.add(STONE_BLOCK);
        });
    }
}
