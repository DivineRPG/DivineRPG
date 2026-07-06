package net.divinerpg.items.vanilla;

import net.divinerpg.items.base.ItemMod;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

import static net.divinerpg.registries.SoundRegistry.HEAL;
import static net.minecraft.core.particles.ParticleTypes.HEART;
import static net.minecraft.stats.Stats.ITEM_USED;

public class ItemHealingStone extends ItemMod {
    int healAmount;

    public ItemHealingStone(Properties properties) {
        super(properties);
        healAmount = 20;
        cooldown = 50;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            stack.consume(1, player);
            player.heal(healAmount);
            player.playSound(HEAL.get(), 1, 1);
            player.awardStat(ITEM_USED.get(this));
            player.getCooldowns().addCooldown(stack, cooldown);
            return InteractionResult.SUCCESS;
        } return super.use(level, player, hand);
    }
    @Override public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if(!(entity instanceof ServerPlayer) && !(entity instanceof Monster) && !(entity instanceof NeutralMob mob && mob.isAngry()) && entity.getHealth() < entity.getMaxHealth() && !player.getCooldowns().isOnCooldown(stack)) {
            stack.consume(1, player);
            entity.heal(healAmount);
            entity.playSound(HEAL.get(), 1, 1);
            for(int i = 0; i < 7; ++i) {
                double d0 = entity.getRandom().nextGaussian() * .02;
                double d1 = entity.getRandom().nextGaussian() * .02;
                double d2 = entity.getRandom().nextGaussian() * .02;
                entity.level().addParticle(HEART, entity.getRandomX(1), entity.getRandomY() + .5, entity.getRandomZ(1), d0, d1, d2);
            } player.awardStat(ITEM_USED.get(this));
            player.getCooldowns().addCooldown(stack, cooldown);
            return InteractionResult.SUCCESS;
        } return super.interactLivingEntity(stack, player, entity, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
//        tooltip.add(LocalizeUtils.healthHeal(healAmount / 2));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}