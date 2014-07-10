package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRoamer extends EntityDivineRPGMob {
	
    public EntityRoamer(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.roamerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.roamerDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.roamerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.roamerFollowRange);
    }

    @Override
	protected void dropFewItems(boolean var1, int var2) {
		this.dropItem(ArcanaItems.collector, 1);
	}

    @Override
	protected float getSoundVolume() {
		return 0.3F;
	}
	
	@Override
	protected String getLivingSound() {
	    return Sounds.roamer.getPrefixedName();
	}

	@Override
	protected String getHurtSound() {
	    return Sounds.roamerHurt.getPrefixedName();
	}

	@Override
	protected String getDeathSound() {
	    return getHurtSound();
	}

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

	@Override
	public String mobName() {
		return "Roamer";
	}
}
