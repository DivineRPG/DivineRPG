package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.twilight.projectile.EntityTwilightDemonShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityTwilightDemon extends EntityDivineRPGBoss {
	
	int shooting;

	public EntityTwilightDemon(World var1) {
		super(var1);
		this.setSize(2.0F, 4.0F);
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F, 50));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.twilightDemonFollowRange);
	}

	@Override
	public int getTotalArmorValue() {
		return 10;
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.insect);
	}

	@Override
	protected String getHurtSound() {
		return getLivingSound();
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.ticksExisted%160==0) this.shooting=100;
		this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 40D);
		if(this.entityToAttack != null && !this.worldObj.isRemote && this.shooting>0) {
			double tx = this.entityToAttack.posX - this.posX;
	        double ty = this.entityToAttack.boundingBox.minY - this.posY-2;
	        double tz = this.entityToAttack.posZ - this.posZ;
			double angle = Math.atan(-(tx)/(tz));
			EntityTwilightDemonShot e = new EntityTwilightDemonShot(this.worldObj, this);
			e.posZ += Math.sin(angle);
			e.posX += Math.cos(angle);
			e.setThrowableHeading(tx-Math.cos(angle), ty, tz-Math.sin(angle), 1.6f, 0);
			this.worldObj.spawnEntityInWorld(e);
			
			EntityTwilightDemonShot e1 = new EntityTwilightDemonShot(this.worldObj, this);
			e1.posZ -= Math.sin(angle);
			e1.posX -= Math.cos(angle);
			e1.setThrowableHeading(tx+Math.cos(angle), ty, tz+Math.sin(angle), 1.6f, 0);
			this.worldObj.spawnEntityInWorld(e1);
		}
		if(this.shooting>0)this.shooting--;
	}

	@Override
	public void dropFewItems(boolean par1, int par2)  {
		switch(this.rand.nextInt(2)) {
			case 0: this.dropItem(TwilightItemsWeapons.haliteBlitz, 1);break;
			case 1: this.dropItem(TwilightItemsWeapons.haliteBow, 1);
		}
		if(this.rand.nextInt(2) == 0)this.dropItem(Item.getItemFromBlock(VanillaBlocks.twilightDemonStatue), 1);
	}

	@Override
	public String mobName() {
		return "Twilight Demon";
	}

	@Override
	public String name() {
		return "Twilight Demon";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}