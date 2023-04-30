package xczl.xczltools.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import xczl.xczltools.Item.ModBlock;
import xczl.xczltools.Item.Tools.SuperToolMaterial;


@Environment(EnvType.CLIENT)
public class XczltoolsClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlock.CROP_BLOCK);
    }
}
