package xczl.xczltools;

import net.fabricmc.api.ModInitializer;
import xczl.xczltools.Item.ModItem;
import xczl.xczltools.Item.ModItemGroup;

public class Xczltools implements ModInitializer {
    /**
     * Runs the mod initializer.
     */

    public static final String MODID = "xczltools";

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroup();
        ModItem.addItemsToItemGroup();
    }
}
