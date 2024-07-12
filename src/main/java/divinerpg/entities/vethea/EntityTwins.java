package divinerpg.entities.vethea;

import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.*;

public class EntityTwins extends EntityDuo implements RangedAttackMob {
    public EntityTwins(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(2, new RangedAttackGoal(this, 0.25F, 5, 64.0F));
    }
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float par2) {
        if (isAlive() && getTarget() != null && !level().isClientSide && (isFast || abilityCoolDown % 4 == 0)) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level(), ArrowType.DARVEN_ARROW, this, entity, 1.6F, 1.2F);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }
}