package divinerpg.items.ranged.shooter;

import divinerpg.attachments.Arcana;
import divinerpg.items.ranged.ItemRangedWeapon;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class Shotgun extends ItemRangedWeapon {
    public final int projectileCount;
    public Shotgun(@Nullable TagKey<Item> ammoType, Supplier<ItemStack> defaultItem, Supplier<EntityType<? extends Projectile>> projectileType, int uses, int cooldown, int projectileCount) {
        super(ammoType, defaultItem, projectileType, uses);
        this.cooldown = cooldown;
        this.projectileCount = projectileCount;
    }
    public Shotgun(Supplier<EntityType<? extends Projectile>> projectileType, int uses, int cooldown, int projectileCount) {
        super(null, () -> new ItemStack(Items.ARROW, projectileCount), projectileType, uses);
        this.cooldown = cooldown;
        this.projectileCount = projectileCount;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ItemStack ammo = findAmmo(player);
        if(ammo != null && !ammo.isEmpty() && ammo.getCount() > 0 && Arcana.getAmount(player) >= arcanaConsumedUse) {
            int count = Math.min(ammo.getCount(), projectileCount);
            if(!level.isClientSide) {
                for(int i = 0; i < count; i++) shoot((ServerLevel) level, player, player.getUsedItemHand(), stack, List.of(ammo), power, 10F, false, null);
                if(arcanaConsumedUse > 0) Arcana.modifyAmount(player, -arcanaConsumedUse);
            } if(!player.isCreative() && stack.getEnchantmentLevel(level.holderOrThrow(Enchantments.INFINITY)) < 1) ammo.consume(count, player);
            if(cooldown > 0) player.getCooldowns().addCooldown(this, cooldown);
            player.awardStat(Stats.ITEM_USED.get(this));
            player.playSound(sound != null ? sound : SoundEvents.ARROW_SHOOT, 1, 1);
            return InteractionResultHolder.consume(stack);
        } return InteractionResultHolder.pass(stack);
    }
}