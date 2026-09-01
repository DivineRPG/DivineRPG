package divinerpg.items.ranged;

import divinerpg.items.ranged.bows.EnderBow;
import divinerpg.items.ranged.bows.InfernoBow;
import divinerpg.network.payload.AccurateSetMotionPacket;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.ToolStats;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.minecraft.sounds.SoundEvents.ARROW_SHOOT;
import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.stats.Stats.ITEM_USED;

public class ItemBow extends BowItem {
    public final int useDuration;
    public final Integer nameColor;
    public final Supplier<Item> infinityArrow;
    public final float speedScale;
    private final ToolStats toolStats;

    public ItemBow(ToolStats toolStats, Properties properties, Supplier<Item> infinityArrow, Integer nameColor) {
        super(toolStats.getMaterial().durability() == 0 ? properties.stacksTo(1).enchantable(toolStats.getMaterial().enchantmentValue()).repairable(toolStats.getMaterial().repairItems()).component(DataComponents.UNBREAKABLE, Unit.INSTANCE) : properties.durability(toolStats.getMaterial().durability()).enchantable(toolStats.getMaterial().enchantmentValue()).repairable(toolStats.getMaterial().repairItems()));
        this.useDuration = (int) toolStats.getMaterial().speed();
        this.nameColor = nameColor;
        this.infinityArrow = infinityArrow;
        this.speedScale = 72000.0F / (this.useDuration == 0 ? 72000.0F : (float)this.useDuration);
        this.toolStats = toolStats;
    }

    @Override public int getUseDuration(ItemStack stack, LivingEntity entity) { return useDuration; }
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();
        InteractionResult ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);
        if(ret != null) return ret;
        else if(infinityArrow == null && !player.hasInfiniteMaterials() && !flag) return InteractionResult.FAIL;
        else {
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int remainingTime) {
        if(entity instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if(infinityArrow != null && (itemstack.isEmpty() || itemstack.is(infinityArrow.get()))) itemstack = new ItemStack(infinityArrow.get());
            if(itemstack.isEmpty()) return false;
            int i = EventHooks.onArrowLoose(stack, level, player, (getUseDuration(stack, entity) - remainingTime) * 72000 / useDuration, true);
            if(i < 0) return false;
            float f = getPowerForTime(i);
            if(f >= .1F) {
                List<ItemStack> list = draw(stack, itemstack, player);
                if(level instanceof ServerLevel serverlevel && !list.isEmpty()) shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f * 3F * speedScale, 1, f == 1, null);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), ARROW_SHOOT, PLAYERS, 1, 1 / (level.getRandom().nextFloat() * .4F + 1.2F) + f * .5F);
                player.awardStat(ITEM_USED.get(this));
            }
            return true;
        }
        return false;
    }
    @Override protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable LivingEntity target) {
        float f = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0);
        float f1 = projectileItems.size() == 1 ? 0 : 2 * f / (projectileItems.size() - 1);
        float f2 = ((projectileItems.size() - 1) % 2) * f1 / 2;
        float f3 = 1;
        for(int i = 0; i < projectileItems.size(); ++i) {
            ItemStack itemstack = projectileItems.get(i);
            if(!itemstack.isEmpty()) {
                float f4 = f2 + f3 * ((i + 1) >> 1) * f1;
                f3 = -f3;
                Projectile projectile = createProjectile(level, shooter, weapon, itemstack, isCrit);
                shootProjectile(shooter, projectile, i, velocity, inaccuracy, f4, target);
                level.addFreshEntity(projectile);
                PacketDistributor.sendToPlayersTrackingEntity(projectile, new AccurateSetMotionPacket(projectile.getId(), projectile.getDeltaMovement()));
                weapon.hurtAndBreak(getDurabilityUse(itemstack), shooter, hand);
                if(weapon.isEmpty()) break;
            }
        }
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(infinityArrow == null ? Items.ARROW : infinityArrow.get());
    }
    public static void addEffect(Arrow arrow, MobEffectInstance instance) {
        ItemStack stack = arrow.getPickupItemStackOrigin();
        PotionContents contents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        Iterable<MobEffectInstance> contentsit = contents.getAllEffects();
        for(MobEffectInstance c : contentsit) if(c.is(instance.getEffect())) return;
        stack.set(DataComponents.POTION_CONTENTS, contents.withEffectAdded(instance));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        float speed = 72000F / useDuration;
        builder.accept(LocalizeUtils.shootingPower(speedScale));
        if (speed > 1) builder.accept(LocalizeUtils.bowFasterPull(speed));
        if (speed < 1) builder.accept(LocalizeUtils.bowSlowerPull(1 / speed));
        if (this instanceof EnderBow) builder.accept(LocalizeUtils.teleportAttached());
        if (this instanceof InfernoBow) builder.accept(LocalizeUtils.burningShots());

        PotionContents potioncontents = stack.get(DataComponents.POTION_CONTENTS);
        if (potioncontents != null && potioncontents.hasEffects()) {
            builder.accept(LocalizeUtils.inflict());
            for (MobEffectInstance effect : potioncontents.getAllEffects()) {
                Holder<MobEffect> mobEffect = effect.getEffect();
                int amplifier = effect.getAmplifier();
                MutableComponent line = PotionContents.getPotionDescription(mobEffect, amplifier);
                if (mobEffect.is(MobEffects.BLINDNESS)) {
                    line.withStyle(ChatFormatting.BLACK);
                } else if (mobEffect.is(MobEffects.SLOWNESS)) {
                    line.withStyle(ChatFormatting.DARK_AQUA);
                } else if (mobEffect.is(MobEffects.POISON)) {
                    line.withStyle(ChatFormatting.DARK_GREEN);
                } else {
                    line.withStyle(mobEffect.value().getCategory().getTooltipFormatting());
                }

                builder.accept(line);
            }
        }

        if (infinityArrow != null) builder.accept(LocalizeUtils.infiniteAmmo());
        super.appendHoverText(stack, context, display, builder, tooltipFlag);
    }

    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}