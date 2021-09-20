package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class EntityEternalArcher extends EntityDivineBoss {

    private int armSelected;
    private int abilityTick;

    public EntityEternalArcher(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward = 250;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 4.5F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.eternalArcherHealth).add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.eternalArcherSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.eternalArcherFollowRange);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 80));
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
        if (this.getTarget() != null && ((this.getTarget() instanceof PlayerEntity
                && ((PlayerEntity) this.getTarget()).isCreative())
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

        if (this.abilityTick % 30 == 0 && this.getTarget() != null && !this.level.isClientSide) {
            this.level.addFreshEntity(new EntityDivineArrow(EntityRegistry.ARROW_SHOT, this.level,
                    ArrowType.getArrowFromId(ArrowType.ETERNAL_ARCHER_FLAME_ARROW.ordinal() + this.armSelected), this,
                    this.getTarget(), 1.6F, 5.0F));
        }
    }


    public int getSelectedArm() {
        return this.armSelected;
    }

}
