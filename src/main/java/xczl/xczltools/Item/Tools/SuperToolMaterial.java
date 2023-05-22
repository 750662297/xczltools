package xczl.xczltools.Item.Tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xczl.xczltools.Item.ModItemGroup;
import xczl.xczltools.Item.seeds.CustomCropBlock;
import xczl.xczltools.Xczltools;

public class SuperToolMaterial implements ToolMaterial {

    public static final SuperToolMaterial WOOD_INSTANCE = new SuperToolMaterial(MapColor.OAK_TAN);
    public static final SuperToolMaterial STONE_INSTANCE = new SuperToolMaterial(MapColor.STONE_GRAY);
    public static final SuperToolMaterial IRON_INSTANCE = new SuperToolMaterial(MapColor.IRON_GRAY);
    public static final SuperToolMaterial GOLD_INSTANCE = new SuperToolMaterial(MapColor.GOLD);
    public static final SuperToolMaterial DIAMOND_INSTANCE = new SuperToolMaterial(MapColor.DIAMOND_BLUE);
    public static final SuperToolMaterial NETHERITE_INSTANCE = new SuperToolMaterial(MapColor.BROWN);
    public static final SuperToolMaterial TEMP_INSTANCE = new SuperToolMaterial(MapColor.WATER_BLUE);

    protected SuperToolMaterial(MapColor color)
    {
        if(color == MapColor.OAK_TAN)
        {
            //木制
        }
        if(color == MapColor.STONE_GRAY)
        {
            //石制
        }
        if(color == MapColor.IRON_GRAY)
        {
            //铁制
        }
        if(color == MapColor.GOLD)
        {
            //金制
        }
        if(color == MapColor.DIAMOND_BLUE)
        {
            //钻石
        }
        if(color == MapColor.BROWN)
        {
            //下界合金
        }
        if(color == MapColor.WATER_BLUE)
        {
            //原临时工具
        }
    }
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
