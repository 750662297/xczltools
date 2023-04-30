package xczl.xczltools.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.Tools.SuperToolMaterial;
import xczl.xczltools.Xczltools;

public class ModItemGroup {
    public static ItemGroup ModGroup;

    public static void registerItemGroup(){
        ModGroup = FabricItemGroup.builder(new Identifier(Xczltools.MODID,"xczl_group"))
                .icon(() -> new ItemStack(ModItem.TEMP_TOOL)).build();
    }
}
