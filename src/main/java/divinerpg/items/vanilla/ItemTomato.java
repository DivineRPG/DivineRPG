package divinerpg.items.vanilla;

import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModFood;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.FoodList;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemTomato extends ItemModFood {
    public ItemTomato() {super(FoodList.TOMATO);}
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(player.isShiftKeyDown()) {
            world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, .5F, .4F / (player.getRandom().nextFloat() * .4F + .8F));
            if(!player.isCreative()) stack.shrink(1);
            if(!world.isClientSide) {
                EntityShooterBullet bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, BulletType.TOMATO_SHOT);
                bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, 1);
                world.addFreshEntity(bullet);
            } player.awardStat(Stats.ITEM_USED.get(this));
            if(!player.isCreative()) stack.shrink(1);
            return InteractionResultHolder.success(stack);
        } else if(player.canEat(stack.getFoodProperties(player).canAlwaysEat())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(stack);
        } else return super.use(world, player, hand);
    }
}