package xczl.xczltools.Item.foods;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class TestFood extends Item {
    private static final FoodComponent Test = new FoodComponent.Builder().alwaysEdible().hunger(20).build();

    public TestFood(Settings settings) {
        super(settings.food(Test));
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity player = (PlayerEntity) user;
        player.setHealth(20);
        return user.eatFood(world, stack);
    }
}
