package divinerpg.entities.projectile.magic;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class DivineMagicProjectile extends DivineThrowableProjectile {
    public DivineMagicProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage) {super(entityType, level, damage);}
    @Override public DamageSource getDamageSource(EntityHitResult result) {return damageSources().indirectMagic(this, getOwner());}
}