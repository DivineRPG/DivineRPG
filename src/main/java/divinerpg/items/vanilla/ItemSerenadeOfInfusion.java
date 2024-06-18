package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemSerenadeOfInfusion extends ItemMod {
	int effectSec;
    public ItemSerenadeOfInfusion() {
        super(new Properties().durability(15));
        cooldown = 20;
        effectSec = 4;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 2, true, false));
            player.playSound(SoundRegistry.HEAL.get(), 1, 1);
            player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, cooldown);
            return InteractionResultHolder.success(stack);
        } return super.use(level, player, hand);
    }
    @Override public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if(!(entity instanceof ServerPlayer) && !(entity instanceof Monster) && entity.getHealth() < entity.getMaxHealth() && !player.getCooldowns().isOnCooldown(this)) {
            if(!player.isCreative()) stack.hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(hand));
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, effectSec * 20, 2, true, false));
            entity.playSound(SoundRegistry.HEAL.get(), 1, 1);
            for(int i = 0; i < 7; ++i) {
                double d0 = entity.random.nextGaussian() * .02;
                double d1 = entity.random.nextGaussian() * .02;
                double d2 = entity.random.nextGaussian() * .02;
                entity.level().addParticle(ParticleTypes.HEART, entity.getRandomX(1), entity.getRandomY() + .5, entity.getRandomZ(1), d0, d1, d2);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, cooldown);
            return InteractionResult.SUCCESS;
        } return super.interactLivingEntity(stack, player, entity, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.healthRegen(effectSec));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}