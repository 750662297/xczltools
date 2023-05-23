package xczl.xczltools.Item.Tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import xczl.xczltools.Item.ModItemGroup;
import xczl.xczltools.Item.seeds.CustomCropBlock;
import xczl.xczltools.Xczltools;

import java.util.function.Supplier;

public class SuperToolMaterial implements ToolMaterial {

    public static final SuperToolMaterial WOOD_INSTANCE = new SuperToolMaterial(ToolMaterials.WOOD);
    public static final SuperToolMaterial STONE_INSTANCE = new SuperToolMaterial(ToolMaterials.STONE);
    public static final SuperToolMaterial IRON_INSTANCE = new SuperToolMaterial(ToolMaterials.IRON);
    public static final SuperToolMaterial GOLD_INSTANCE = new SuperToolMaterial(ToolMaterials.GOLD);
    public static final SuperToolMaterial DIAMOND_INSTANCE = new SuperToolMaterial(ToolMaterials.DIAMOND);
    public static final SuperToolMaterial NETHERITE_INSTANCE = new SuperToolMaterial(ToolMaterials.NETHERITE);
    public static final SuperToolMaterial TEMP_INSTANCE = new SuperToolMaterial();

    protected SuperToolMaterial(ToolMaterial material) {
        if (material == ToolMaterials.WOOD) {
            //木制
            miningLevel = 1;
            itemDurability = 500;
            miningSpeed = 10.0F;
            attackDamage = 9.0F;
            enchantability = 15;

            Supplier<Ingredient> repair = () -> Ingredient.fromTag(ItemTags.PLANKS);
            repairIngredient = new Lazy<Ingredient>(repair);

        }
        if (material == ToolMaterials.STONE) {
            //石制
            miningLevel = 2;
            itemDurability = 2000;
            miningSpeed = 15.0F;
            attackDamage = 11.0F;
            enchantability = 5;

            Supplier<Ingredient> repair = () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
            repairIngredient = new Lazy<Ingredient>(repair);
        }
        if (material == ToolMaterials.IRON) {
            //铁制
            miningLevel = 3;
            itemDurability = 10000;
            miningSpeed = 25.0F;
            attackDamage = 19.0F;
            enchantability = 14;

            Supplier<Ingredient> repair = () -> Ingredient.ofItems(Items.IRON_INGOT);
            repairIngredient = new Lazy<Ingredient>(repair);
        }
        if (material == ToolMaterials.GOLD) {
            //金制
            miningLevel = 4;
            itemDurability = 2000;
            miningSpeed = 50.0F;
            attackDamage = 29.0F;
            enchantability = 22;

            Supplier<Ingredient> repair = () -> Ingredient.ofItems(Items.GOLD_INGOT);
            repairIngredient = new Lazy<Ingredient>(repair);
        }
        if (material == ToolMaterials.DIAMOND) {
            //钻石
            miningLevel = 4;
            itemDurability = 50000;
            miningSpeed = 37.0F;
            attackDamage = 49.0F;
            enchantability = 10;

            Supplier<Ingredient> repair = () -> Ingredient.ofItems(Items.DIAMOND);
            repairIngredient = new Lazy<Ingredient>(repair);
        }
        if (material == ToolMaterials.NETHERITE) {
            //下界合金
            miningLevel = 4;
            itemDurability = 100000;
            miningSpeed = 40.0F;
            attackDamage = 79.0F;
            enchantability = 15;

            Supplier<Ingredient> repair = () -> Ingredient.ofItems(Items.NETHERITE_INGOT);
            repairIngredient = new Lazy<Ingredient>(repair);
        }
    }

    protected SuperToolMaterial()
    {
        miningLevel = 4;
        itemDurability = 200000;
        miningSpeed = 50.0F;
        attackDamage = 99.0F;
        enchantability = 22;

        Supplier<Ingredient> repair = () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
        repairIngredient = new Lazy<Ingredient>(repair);
    }

    private int miningLevel;
    private int itemDurability;
    private float miningSpeed;
    private float attackDamage;
    private int enchantability;

    private Lazy<Ingredient> repairIngredient;



    //耐久
    @Override
    public int getDurability()
    {
        return itemDurability;
    }

    //挖掘速度
    @Override
    public float getMiningSpeedMultiplier()
    {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage()
    {
        return attackDamage;
    }

    //挖掘等级
    @Override
    public int getMiningLevel()
    {
        return miningLevel;
    }

    //附魔等级
    @Override
    public int getEnchantability()
    {
        return enchantability;
    }

    //修复材料
    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }



}
