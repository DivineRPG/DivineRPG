package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityDungeonPrisoner extends EntityDivineMob {
    public EntityDungeonPrisoner(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.dungeonPrisonerHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.dungeonPrisonerDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.dungeonPrisonerSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.dungeonPrisonerFollowRange);
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
    public boolean attackEntityAsMob(Entity entity) {
        EntityDungeonDemon demon = new EntityDungeonDemon( null, this.world);
        this.playSound(SoundRegistry.DUNGEON_PRISONER_CHANGE, 1, 1);
        demon.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
        this.world.addEntity(demon);
        this.setDead();
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUNGEON_PRISONER;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUNGEON_PRISONER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUNGEON_PRISONER_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_DUNGEON_PRISONER;
    }
}