package xczl.xczltools.Item;


import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.tools.Tool;

//public class SuperTool extends MiningToolItem {
//    public SuperTool(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
//        super(material, attackDamage, attackSpeed, settings);
//    }
//}
public class SuperTool extends SwordItem
{

    private TagKey<Block> effectiveBlocks;
    private float miningSpeed;

    private static float speed(){return 4;};
    public SuperTool(ToolMaterial material, Settings settings) {
        super(material,100,speed(),settings);
//        super(material, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return getMaterial().getMiningSpeedMultiplier();
//        return 7.0f;
//        return state.isIn(this.effectiveBlocks) ? this.miningSpeed : 1.0f;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0f) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
//        int i = this.getMaterial().getMiningLevel();
//        if (i < MiningLevels.DIAMOND && state.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
//            return false;
//        }
//        if (i < MiningLevels.IRON && state.isIn(BlockTags.NEEDS_IRON_TOOL)) {
//            return false;
//        }
//        if (i < MiningLevels.STONE && state.isIn(BlockTags.NEEDS_STONE_TOOL)) {
//            return false;
//        }
//        return state.isIn(this.effectiveBlocks);

        return true;
    }

}
