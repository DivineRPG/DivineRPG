package divinerpg.items.ranged.shooter;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.CANNON_SHOT;
import static divinerpg.registries.ItemRegistry.acid;
import static divinerpg.registries.SoundRegistry.BLITZ;
import static divinerpg.registries.TagRegistry.AMMO_VETHEAN_CANNON;

public class VetheanCannon extends ItemRangedWeapon {
    final float damage;
    public VetheanCannon(Properties properties, float damage) {
        super(properties, AMMO_VETHEAN_CANNON, acid::toStack, CANNON_SHOT::value);
        sound = BLITZ.get();
        arcanaConsumedUse = 10;
        this.damage = damage;
        tooltips.add(LocalizeUtils.rangedDam((int)(damage * 3.3F)));
    }
    @Override protected DivineThrowableProjectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        DivineThrowableProjectile p = (DivineThrowableProjectile) super.createProjectile(level, shooter, weapon, ammo, isCrit);
        p.baseDamage = damage;
        return p;
    }
}