package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityDungeonConstructor extends EntityDivineMob {
    
	private int angerLevel;
	
	public EntityDungeonConstructor(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.angerLevel = 0;
        this.stepHeight = 1.0F;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.9F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.constructorHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.constructorDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.constructorSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.constructorFollowRange);
    }
    
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    
    @Override
    public void livingTick() {
        if (this.getAttackTarget() != null) {
            this.faceEntity(this.getAttackTarget(), 100.0F, 100.0F);
        }

        if (!this.world.isRemote && this.isAlive()) {
            if (this.getAttackTarget() != null) {
                if (this.getAttackTarget() instanceof PlayerEntity && this.angerLevel < 3) {
                    this.moveStrafing = this.moveForward = 0.0F;
                }
            }
        }
        super.livingTick();
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CONSTRUCTOR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CONSTRUCTOR_HURT;
    }
    
    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        par1Entity.playSound(SoundRegistry.CONSTRUCTOR_PUNCH, 1, 1);
        return super.attackEntityAsMob(par1Entity);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DUNGEON_CONSTRUCTOR;
    }
}
