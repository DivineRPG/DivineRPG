package divinerpg.items.ranged;

import divinerpg.items.ranged.bows.*;
import divinerpg.network.payload.AccurateSetMotionPacket;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.Utils;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.sounds.SoundEvents.ARROW_SHOOT;
import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemBow extends BowItem {
    public final int useDuration;
    public final Integer nameColor;
    public final Supplier<Item> infinityArrow;
    public final float speedScale;
    public ItemBow(Properties properties, int uses, int useDuration, float speedScale, Supplier<Item> infinityArrow, Integer nameColor) {
        super((uses == 0 ? properties.stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true)) : properties.durability(uses)));
        this.useDuration = useDuration;
        this.nameColor = nameColor;
        this.infinityArrow = infinityArrow;
        this.speedScale = speedScale;
    }
    @Override public int getUseDuration(ItemStack stack, LivingEntity entity) {return useDuration;}
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();
        InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);
        if(ret != null) return ret;
        else if(infinityArrow == null && !player.hasInfiniteMaterials() && !flag) return InteractionResultHolder.fail(itemstack);
        else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }
    @Override public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if(infinityArrow != null && (itemstack.isEmpty() || itemstack.is(infinityArrow.get()))) itemstack = new ItemStack(infinityArrow.get());
            if(itemstack.isEmpty()) return;
            int i = EventHooks.onArrowLoose(stack, level, player, (getUseDuration(stack, entityLiving) - timeLeft) * 72000 / useDuration, true);
            if(i < 0) return;
            float f = getPowerForTime(i);
            if(f >= .1F) {
                List<ItemStack> list = draw(stack, itemstack, player);
                if(level instanceof ServerLevel serverlevel && !list.isEmpty()) shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f * 3F * speedScale, 1, f == 1, null);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), ARROW_SHOOT, PLAYERS, 1, 1 / (level.getRandom().nextFloat() * .4F + 1.2F) + f * .5F);
                player.awardStat(ITEM_USED.get(this));
            }
        }
    }
    @Override protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable LivingEntity target) {
        float f = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0F);
        float f1 = projectileItems.size() == 1 ? 0F : 2F * f / (projectileItems.size() - 1);
        float f2 = ((projectileItems.size() - 1) % 2) * f1 / 2F;
        float f3 = 1F;
        for(int i = 0; i < projectileItems.size(); ++i) {
            ItemStack itemstack = projectileItems.get(i);
            if(!itemstack.isEmpty()) {
                float f4 = f2 + f3 * ((i + 1) >> 1) * f1;
                f3 = -f3;
                Projectile projectile = createProjectile(level, shooter, weapon, itemstack, isCrit);
                shootProjectile(shooter, projectile, i, velocity, inaccuracy, f4, target);
                level.addFreshEntity(projectile);
                PacketDistributor.sendToPlayersTrackingEntity(projectile, new AccurateSetMotionPacket(projectile.getId(), projectile.getDeltaMovement()));
                weapon.hurtAndBreak(getDurabilityUse(itemstack), shooter, LivingEntity.getSlotForHand(hand));
                if(weapon.isEmpty()) break;
            }
        }
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(infinityArrow == null ? Items.ARROW : infinityArrow.get());
    }
    @Override public boolean isEnchantable(ItemStack stack) {return true;}
    @Override public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && (stack.has(DataComponents.MAX_DAMAGE) || !(enchantment.is(Enchantments.MENDING) || enchantment.is(Enchantments.UNBREAKING)));
    }
    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return stack.has(DataComponents.MAX_DAMAGE) || !(Utils.hasStoredEnchantment(Enchantments.MENDING, book) || Utils.hasStoredEnchantment(Enchantments.UNBREAKING, book));
    }
    public static void addEffect(Arrow arrow, MobEffectInstance instance) {
        ItemStack stack = arrow.getPickupItemStackOrigin();
        PotionContents contents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        Iterable<MobEffectInstance> contentsit = contents.getAllEffects();
        for(MobEffectInstance c : contentsit) if(c.is(instance.getEffect())) return;
        stack.set(DataComponents.POTION_CONTENTS, contents.withEffectAdded(instance));
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        float speed = 72000F / useDuration;
        tooltip.add(LocalizeUtils.shootingPower(speedScale));
        if(speed > 1) tooltip.add(LocalizeUtils.bowFasterPull(speed));
        if(speed < 1) tooltip.add(LocalizeUtils.bowSlowerPull(1 / speed));
        if(this instanceof EnderBow) tooltip.add(LocalizeUtils.teleportAttached());
        if(this instanceof InfernoBow) tooltip.add(LocalizeUtils.burningShots());
        PotionContents potioncontents = stack.get(DataComponents.POTION_CONTENTS);
        if(!(this instanceof ShadowBow) && potioncontents != null) potioncontents.addPotionTooltip(tooltip::add, 1, context.tickRate());
        if(infinityArrow != null) tooltip.add(LocalizeUtils.infiniteAmmo());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
    @Override public Component getName(ItemStack pStack) {
        return nameColor != null ? ((MutableComponent) super.getName(pStack)).withColor(nameColor) : super.getName(pStack);
    }
}