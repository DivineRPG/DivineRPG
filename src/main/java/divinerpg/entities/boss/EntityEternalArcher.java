package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import net.minecraft.util.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

public class EntityEternalArcher extends EntityDivineBoss {

    private int armSelected;
    private int abilityTick;

    public EntityEternalArcher(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        xpReward = 250;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 4.5F;
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 80));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getTarget() != null) {
            this.getLookControl().setLookAt(this.getTarget().getX(),
                    this.getTarget().getY() + (double) this.getTarget().getEyeHeight(),
                    this.getTarget().getZ(), 10.0F, 5);
        }

        if (this.getTarget() == null || this.random.nextInt(200) == 0) {
            this.setTarget(this.level.getNearestPlayer(this, 48D));
        }
        if (this.getTarget() != null && ((this.getTarget() instanceof Player
                && ((Player) this.getTarget()).isCreative())
                || !this.getTarget().isAlive())) {
            this.setTarget(null);
        }
        if (this.abilityTick > 0)
            this.abilityTick--;
        if (this.abilityTick == 0) {
            if (this.armSelected < 5)
                this.armSelected++;
            else if (this.armSelected == 5)
                this.armSelected = 0;
            this.abilityTick = 400;
        }

        if (this.abilityTick % 20 == 0 && this.getTarget() != null && !this.level.isClientSide && getTarget() != null) {

            if (isAlive() && getTarget() != null) {
                EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, ArrowType.getArrowFromId(ArrowType.ETERNAL_ARCHER_FLAME_ARROW.ordinal() + armSelected), this, getTarget(), 1.6F, 3.0F);
                double d0 = getTarget().getX() - this.getX();
                double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
                double d2 = getTarget().getZ() - this.getZ();
                double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                this.level.addFreshEntity(projectile);
            }

        }
    }


    public int getSelectedArm() {
        return this.armSelected;
    }

}
