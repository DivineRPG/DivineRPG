package net.divinerpg.entities.twilight;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityEpiphite extends EntityPeacefulUntilAttacked {
	
    public EntityEpiphite(World var1) {
        super(var1);
        this.setSize(0.8F, 1.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 40;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.epiphiteHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.epiphiteDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.epiphiteSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.epiphiteFollowRange);
    }
 
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.growl);
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }
 
    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }
 
    @Override
    protected void dropFewItems(boolean beenHit, int lootingLevel) {
        super.dropFewItems(beenHit, lootingLevel);
        if(this.rand.nextInt(2) == 0) this.dropItem(TwilightItemsOther.wildwoodSoul, 1+lootingLevel);
        this.dropItem(ItemsFood.magicMeat, 1);
    }
    
    @Override
    public boolean attackEntityAsMob(Entity e) {
    	if(this.rand.nextInt(5)==0)this.worldObj.spawnEntityInWorld(new EntityLightningBolt(this.worldObj, e.posX, e.posY, e.posZ));
    	return super.attackEntityAsMob(e);
    }

    @Override
	public String mobName() {
		return "Epiphite";
	}
}