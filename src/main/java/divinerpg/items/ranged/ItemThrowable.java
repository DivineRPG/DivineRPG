package divinerpg.items.ranged;

import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.items.vanilla.ItemTomato;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ItemThrowable extends ItemRangedWeapon {
    public final float damage;
    public ItemThrowable(float damage) {
        this(EntityRegistry.THROWN_ITEM::value, damage);
        power = 2;
        infinite = false;
    }
    public ItemThrowable(Supplier<EntityType<? extends Projectile>> projectileType, float damage) {
        super(new Properties().stacksTo(32), projectileType);
        this.damage = damage;
        power = 2;
        infinite = false;
    }
    public ItemThrowable(Properties properties, Supplier<EntityType<? extends Projectile>> projectileType, float damage) {
        super(properties, projectileType);
        this.damage = damage;
        power = 2;
        infinite = false;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return projectileWeaponItem;
    }
    @Override protected DivineThrownItem createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        DivineThrownItem projectile = ((DivineThrownItem) super.createProjectile(level, shooter, weapon, ammo, isCrit));
        projectile.setItem(weapon);
        projectile.setOwner(shooter);
        projectile.setPos(shooter.getEyePosition());
        if(shooter instanceof Player player && player.isCreative()) projectile.canPickup = false;
        return projectile;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        if(!(this instanceof ItemTomato)) tooltip.add(LocalizeUtils.rangedDam((int)damage));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}