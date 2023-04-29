package xczl.xczltools.Item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

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
        return 20F;
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
