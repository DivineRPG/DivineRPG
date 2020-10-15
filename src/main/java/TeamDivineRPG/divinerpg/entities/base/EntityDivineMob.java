package TeamDivineRPG.divinerpg.entities.base;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityDivineMob extends MobEntity {
    public EntityDivineMob(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);

    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233819_b_, 20.0D).func_233815_a_(Attributes.field_233821_d_, 0.27F);
    }

    protected void addBasicAI() {
//        this.tasks.addTask(0, new EntityAISwimming(this));
//        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
//        this.tasks.addTask(6, new EntityAILookIdle(this));
//        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
//        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    }

    protected void addAttackingAI() {
//        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return (this.world.getDifficulty() != Difficulty.PEACEFUL) && !this.isInDaylight();
    }

}
