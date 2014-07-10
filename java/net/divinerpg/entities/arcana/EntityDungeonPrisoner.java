package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityDungeonPrisoner extends EntityDivineRPGMob {
	
    public EntityDungeonPrisoner(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.dungeonPrisonerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.dungeonPrisonerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.dungeonPrisonerFollowRange);
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        EntityDungeonDemon var4 = new EntityDungeonDemon(this.worldObj);
        this.worldObj.playSoundAtEntity(this, Sounds.dungeonChange.getPrefixedName(), 1.0F, 1.0F);
        var4.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        this.worldObj.spawnEntityInWorld(var4);
        this.setDead();
        return true;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.dungeonPrisoner.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.dungeonHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return Sounds.dungeonHurt.getPrefixedName();
    }
    
    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(ArcanaItems.collector, 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

	@Override
	public String mobName() {
		return "Dungeon Prisoner";
	}
}