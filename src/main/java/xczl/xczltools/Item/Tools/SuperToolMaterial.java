package xczl.xczltools.Item.Tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.ModItemGroup;
import xczl.xczltools.Item.seeds.CustomCropBlock;
import xczl.xczltools.Xczltools;

public class SuperToolMaterial implements ToolMaterial {

    public static final SuperToolMaterial INSTANCE = new SuperToolMaterial();

    //耐久
    @Override
    public int getDurability()
    {
        return 10000;
    }

    //挖掘速度
    @Override
    public float getMiningSpeedMultiplier()
    {
        return 50.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 0.0F;
    }

    //挖掘等级
    @Override
    public int getMiningLevel()
    {
        return 4;
    }

    //附魔等级
    @Override
    public int getEnchantability()
    {
        return 22;
    }

    //修复材料
    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(Items.STONE);
    }



}
