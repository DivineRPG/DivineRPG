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
        this.maxUpStep = 1.0F;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.9F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.constructorHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.constructorDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.constructorSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.constructorFollowRange);
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        //TODO - set arcana canSpawn
//        return level.dimension() == KeyRegistry.ARCANA_WORLD;
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    
    @Override
    public void tick() {
        if (this.getTarget() != null) {
            this.lookAt(this.getTarget(), 100.0F, 100.0F);
        }

        if (!this.level.isClientSide && this.isAlive()) {
            if (this.getTarget() != null) {
                if (this.getTarget() instanceof PlayerEntity && this.angerLevel < 3) {
                    this.moveDist = 0.0F;
                }
            }
        }
        super.tick();
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
    public boolean doHurtTarget(Entity par1Entity) {
        par1Entity.playSound(SoundRegistry.CONSTRUCTOR_PUNCH, 1, 1);
        return super.doHurtTarget(par1Entity);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_DUNGEON_CONSTRUCTOR;
    }
}
