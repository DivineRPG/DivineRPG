package divinerpg.items.ranged.bows;

import divinerpg.items.ranged.ItemBow;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static divinerpg.registries.ItemRegistry.inferno_arrow;
import static divinerpg.util.RarityList.INFERNO;
import static java.lang.Integer.MAX_VALUE;
import static net.minecraft.sounds.SoundEvents.*;
import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.item.enchantment.Enchantments.FLAME;

public class InfernoBow extends ItemBow {
    public InfernoBow() {super(new Properties().fireResistant().component(DataComponentRegistry.weaponAbility, 0).component(DataComponentRegistry.weaponPower, 1F), 0, 72000, 1, inferno_arrow, INFERNO);}
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        arrow.igniteForTicks(MAX_VALUE >> 1);
        return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(inferno_arrow.get());
    }
    @Override public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return super.supportsEnchantment(stack, enchantment) && !enchantment.is(FLAME);
    }
    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return super.isBookEnchantable(stack, book) && !Utils.hasStoredEnchantment(FLAME, book);
    }
    @Override public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int timeLeft) {
        int i;
        if(living instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if(infinityArrow != null && (itemstack.isEmpty() || itemstack.is(infinityArrow.get()))) itemstack = new ItemStack(infinityArrow.get());
            if(itemstack.isEmpty()) return;
            i = EventHooks.onArrowLoose(stack, level, player, (getUseDuration(stack, player) - timeLeft) * 72000 / useDuration, true);
            player.getCooldowns().addCooldown(this, 60);
        } else i = (getUseDuration(stack, living) - timeLeft) * 72000 / useDuration;
        if(i < 0) return;
        float f = getPowerForTime(i);
        if(f >= .1F) {
            stack.set(DataComponentRegistry.weaponAbility, 9);
            stack.set(DataComponentRegistry.weaponPower, f);
        }
    }
    @Override public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(isSelected && (level.getGameTime() & 1L) == 0 && level instanceof ServerLevel server) {
            int cooldown = stack.get(DataComponentRegistry.weaponAbility);
            if(cooldown > 0) {
                stack.set(DataComponentRegistry.weaponAbility, cooldown - 1);
                float f = stack.get(DataComponentRegistry.weaponPower);
                if(entity instanceof Player player) {
                    ItemStack itemstack = player.getProjectile(stack);
                    if(infinityArrow != null && (itemstack.isEmpty() || itemstack.is(infinityArrow.get()))) itemstack = new ItemStack(infinityArrow.get());
                    if(itemstack.isEmpty()) return;
                    List<ItemStack> list = draw(stack, itemstack, player);
                    if(!list.isEmpty()) shoot(server, player, player.getUsedItemHand(), stack, list, f * 3F * speedScale, 1, f == 1, null);
                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundRegistry.INFERNO_BOW_SHOOT.get(), PLAYERS, 1, 1 / (level.getRandom().nextFloat() * .4F + 1.2F) + f * .5F);
                    player.awardStat(ITEM_USED.get(this));
                } else if(entity instanceof LivingEntity living) {
                    shoot(server, living, living.getUsedItemHand(), stack, List.of(new ItemStack(inferno_arrow.get())), f * 3F * speedScale, 1, f == 1, living instanceof Mob mob ? mob.getTarget() : null);
                    living.playSound(SoundRegistry.INFERNO_BOW_SHOOT.get(), 1, 1 / (level.getRandom().nextFloat() * .4F + .8F));
                }
            }
        }
    }
    @Override public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if(remainingUseDuration == useDuration) {
            level.playSound(null, entity.getX(), entity.getEyeY(), entity.getZ(), CAMPFIRE_CRACKLE, entity.getSoundSource(), 1, 1);
            level.playSound(null, entity.getX(), entity.getEyeY(), entity.getZ(), SoundRegistry.INFERNO_BOW_CHARGE.get(), entity.getSoundSource(), 1, 1);
        }
    }
}