package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;

import static divinerpg.registries.SoundRegistry.HEAL;
import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.core.particles.ParticleTypes.HEART;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.effect.MobEffects.REGENERATION;

public class ItemSerenadeOfInfusion extends ItemMod {
	protected int effectSec;
    public ItemSerenadeOfInfusion() {
        super(new Properties().durability(15).component(POTION_CONTENTS, PotionContents.EMPTY.withEffectAdded(new MobEffectInstance(REGENERATION, 4 * 20, 2))));
        cooldown = 20;
        effectSec = 4;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            player.addEffect(new MobEffectInstance(REGENERATION, effectSec * 20, 2, true, false));
            player.playSound(HEAL.get(), 1, 1);
            player.awardStat(ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, cooldown);
            return InteractionResultHolder.success(stack);
        } return super.use(level, player, hand);
    }
    @Override public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if(!(entity instanceof ServerPlayer) && !(entity instanceof Monster) && !(entity instanceof NeutralMob mob && mob.isAngry()) && entity.getHealth() < entity.getMaxHealth() && !player.getCooldowns().isOnCooldown(this)) {
            if(!player.isCreative()) stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            entity.addEffect(new MobEffectInstance(REGENERATION, effectSec * 20, 2, true, false));
            entity.playSound(HEAL.get(), 1, 1);
            for(int i = 0; i < 7; ++i) {
                double d0 = entity.getRandom().nextGaussian() * .02;
                double d1 = entity.getRandom().nextGaussian() * .02;
                double d2 = entity.getRandom().nextGaussian() * .02;
                entity.level().addParticle(HEART, entity.getRandomX(1), entity.getRandomY() + .5, entity.getRandomZ(1), d0, d1, d2);
            } player.awardStat(ITEM_USED.get(this));
            player.getCooldowns().addCooldown(this, cooldown);
            return InteractionResult.SUCCESS;
        } return super.interactLivingEntity(stack, player, entity, hand);
    }
}