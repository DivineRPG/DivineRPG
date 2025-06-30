package divinerpg.entities.projectile.bullet;

import divinerpg.entities.boss.EntityKitra;
import divinerpg.entities.projectile.DivineThrowableProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class BoneFragment extends DivineThrowableProjectile {
    public BoneFragment(EntityType<? extends DivineThrowableProjectile> entityType, Level level) {
        super(entityType, level);
        baseDamage = 6;
    }
    @Override public void onHitEntity(EntityHitResult result) {
        if(!(result.getEntity() instanceof EntityKitra)) super.onHitEntity(result);
    }
    @Override public boolean isInWater() {
        noPhysics = super.isInWater();
        return false;
    }
}