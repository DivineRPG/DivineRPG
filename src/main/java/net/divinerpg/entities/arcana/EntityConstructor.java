package net.divinerpg.entities.arcana;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityConstructor extends EntityDivineRPGMob {
	
    private int angerLevel;
    private float moveSpeed = 0.23F;
    
    public EntityConstructor(World par1World) {
        super(par1World);
        this.setSize(0.5F, 1.0F);
        addAttackingAI();
        this.angerLevel = 0;
        this.stepHeight = 1.0F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.constructorHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.constructorDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.constructorSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.constructorFollowRange);
    }

    @Override
    public void onLivingUpdate() {
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
        }

        if (!this.worldObj.isRemote && this.isEntityAlive()) {
            if (this.entityToAttack != null) {
                if (this.entityToAttack instanceof EntityPlayer && this.angerLevel < 3) {
                    this.moveStrafing = this.moveForward = 0.0F;
                    this.moveSpeed = 0.0F;
                }
            }
        }
        super.onLivingUpdate();
    }
 
    @Override
    protected String getLivingSound() {
        return null;
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.constructorHurt.getPrefixedName();
    }
 
    @Override
    protected String getDeathSound() {
        return null;
    }
    
    @Override
    public void dropFewItems(boolean beenHit, int lootingLevel) {
        if(this.rand.nextBoolean())return;
        switch (this.rand.nextInt(4)) {
            case 0:
                this.dropItem(ArcanaItems.degradedKey, 1);break;
            case 1:
                this.dropItem(ArcanaItems.sludgeKey, 1);break;
            case 2:
                this.dropItem(ArcanaItems.ancientKey, 1);break;
            case 3:
                this.dropItem(ArcanaItems.soulKey, 1);break;
            }
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        this.worldObj.playSoundAtEntity(this, Sounds.constructorPunch.getPrefixedName(), 1.0F, 1.0F);
        return super.attackEntityAsMob(par1Entity);
    }

	@Override
	public String mobName() {
		return "Dungeon Constructor";
	}
}