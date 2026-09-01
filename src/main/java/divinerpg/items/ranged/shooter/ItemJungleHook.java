package divinerpg.items.ranged.shooter;

import divinerpg.entities.projectile.Hook;
import divinerpg.items.ranged.ItemRangedWeapon;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import static divinerpg.registries.AttachmentRegistry.HOOKED;
import static divinerpg.registries.EntityRegistry.HOOK;
import static divinerpg.registries.TagRegistry.AMMO_ROPE;

public class ItemJungleHook extends ItemRangedWeapon {
    public ItemJungleHook(Properties properties){super(properties.durability(100), AMMO_ROPE, Items.LEAD::getDefaultInstance, HOOK::value);}
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(stack.getDamageValue() >= stack.getMaxDamage() - 1) {
            stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
            return InteractionResult.CONSUME;
        } if(HOOKED.get(player)) {
            player.startUsingItem(hand);
            return InteractionResult.PASS;
        } return super.use(level, player, hand);
    }
    @Override public ItemUseAnimation getUseAnimation(ItemStack stack) {return ItemUseAnimation.BLOCK;}

    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Hook hook = (Hook) super.createProjectile(level, shooter, weapon, ammo, isCrit);
        hook.infinite = infinite || weapon.getEnchantmentLevel(level.holderOrThrow(Enchantments.INFINITY)) > 0 || (shooter instanceof Player p && p.isCreative());
        return hook;
    }
}