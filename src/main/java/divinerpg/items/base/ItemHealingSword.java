package divinerpg.items.base;

import java.util.List;

import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

public class ItemHealingSword extends ItemModSword {
	public float healAmount;
    public ItemHealingSword(Tier material, float heals) {
        super(material);
        healAmount = heals;
        cooldown = 3;
    }
    @Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker.getHealth() < attacker.getMaxHealth()) {
            attacker.heal(healAmount);
            attacker.level().playSound(null, attacker.blockPosition(), SoundRegistry.HEAL.get(), SoundSource.PLAYERS, 1, 1);
        } return super.hurtEnemy(stack, target, attacker);
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
            player.heal(healAmount);
            if(player.isOnFire() && this == ItemRegistry.frossivence.get()) player.clearFire();
            player.playSound(SoundRegistry.HEAL.get(), 1, 1);
            player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, cooldown);
            return InteractionResultHolder.success(stack);
        } return super.use(level, player, hand);
    }
    @Override public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if(!(entity instanceof ServerPlayer) && !(entity instanceof Monster) && entity.getHealth() < entity.getMaxHealth() && !player.getCooldowns().isOnCooldown(this)) {
            if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
            entity.heal(healAmount);
            if(entity.isOnFire() && this == ItemRegistry.frossivence.get()) entity.extinguishFire();
            entity.playSound(SoundRegistry.HEAL.get(), 1, 1);
            for(int i = 0; i < 7; ++i) {
                double d0 = entity.random.nextGaussian() * .02;
                double d1 = entity.random.nextGaussian() * .02;
                double d2 = entity.random.nextGaussian() * .02;
                entity.level().addParticle(ParticleTypes.HEART, entity.getRandomX(1), entity.getRandomY() + .5, entity.getRandomZ(1), d0, d1, d2);
            } player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, cooldown);
            return InteractionResult.SUCCESS;
        } return super.interactLivingEntity(stack, player, entity, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.healthHeal(healAmount / 2));
    	super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}