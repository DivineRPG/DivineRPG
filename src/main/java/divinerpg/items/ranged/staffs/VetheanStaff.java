package divinerpg.items.ranged.staffs;

import divinerpg.entities.projectile.magic.EntityBouncingProjectile;
import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class VetheanStaff extends ItemRangedWeapon {
    float damage;
    public VetheanStaff(int arcanaUse, float damage) {
        super(EntityRegistry.BOUNCING_PROJECTILE::value);
        arcanaConsumedUse = arcanaUse;
        this.damage = damage;
        sound = SoundRegistry.STAFF.get();
        tooltips.add(LocalizeUtils.arcanaDam((int)damage));
        tooltips.add(LocalizeUtils.bouncingShots());
    }
    protected VetheanStaff(Supplier<EntityType<? extends Projectile>> projectileType, int arcanaUse, float damage) {
        super(projectileType);
        arcanaConsumedUse = arcanaUse;
        this.damage = damage;
        sound = SoundRegistry.STAFF.get();
        tooltips.add(LocalizeUtils.arcanaDam((int)damage));
        tooltips.add(LocalizeUtils.bouncingShots());
    }
    @Override protected EntityBouncingProjectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        EntityBouncingProjectile p = (EntityBouncingProjectile) super.createProjectile(level, shooter, weapon, ammo, isCrit);
        p.baseDamage = damage;
        return p;
    }
}