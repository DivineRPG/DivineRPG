package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import java.util.function.Consumer;

import static divinerpg.registries.SoundRegistry.HEAL;
import static net.minecraft.core.particles.ParticleTypes.HEART;
import static net.minecraft.stats.Stats.ITEM_USED;

public class ItemSerenadeOfHealth extends ItemMod {
    int healAmount;
    public ItemSerenadeOfHealth(Properties properties) {
        super(properties.durability(7).stacksTo(1));
        healAmount = 20;
        cooldown = 40;
    }
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) stack.hurtAndBreak(1, player, hand);
            player.heal(healAmount);
            player.playSound(HEAL.get(), 1, 1);
            player.awardStat(ITEM_USED.get(this));
            player.getCooldowns().addCooldown(stack, cooldown);
            return InteractionResult.SUCCESS;
        } return super.use(level, player, hand);
    }
    @Override public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if(!(entity instanceof ServerPlayer) && !(entity instanceof Monster) && !(entity instanceof NeutralMob mob && mob.isAngry()) && entity.getHealth() < entity.getMaxHealth() && !player.getCooldowns().isOnCooldown(stack)) {
            if(!player.isCreative()) stack.hurtAndBreak(1, player, hand);
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
        builder.accept(LocalizeUtils.healthHeal(healAmount/2));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }

}