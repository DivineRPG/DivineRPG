package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public abstract class EntityDivineMob extends MonsterEntity {
    public EntityDivineMob(EntityType<? extends MobEntity> type, World worldIn) {
        super((EntityType<? extends MonsterEntity>) type, worldIn);
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.27D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    if(!needsSpecialAI()){
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }
    }
    public boolean needsSpecialAI() {
        return false;
    }

    protected void addAttackingAI() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }
}
