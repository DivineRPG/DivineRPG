package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class DungeonPrisoner extends EntityDivineRPGMob {
	
    public DungeonPrisoner(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.dungeonPrisonerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.dungeonPrisonerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.dungeonPrisonerFollowRange);
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        DungeonDemon var4 = new DungeonDemon(this.world);
        this.playSound(ModSounds.DUNGEON_PRISONER_CHANGE, 1, 1);
        var4.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.world.spawnEntity(var4);
        this.setDead();
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DUNGEON_PRISONER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.DUNGEON_PRISONER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DUNGEON_PRISONER_HURT;
    }
    
    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(ModItems.collector, 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }

}