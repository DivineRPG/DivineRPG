package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.twilight.projectile.EntitySoulFiendProjectile;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySoulFiend extends EntityDivineRPGBoss {

	public EntitySoulFiend(World var1) {
		super(var1); 
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.soulFiendHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.soulFiendDamage);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.soulFiendSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.soulFiendFollowRange);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1);
	}

	@Override
	public int getTotalArmorValue() {
		return 10;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(!this.worldObj.isRemote && this.ticksExisted % 300 == 0) {
			for(int i = 0; i<4; i++) {
				EntitySoulFiendProjectile e = new EntitySoulFiendProjectile(this.worldObj, this);
				e.setThrowableHeading(this.rand.nextDouble()-this.rand.nextDouble(), -0.25, this.rand.nextDouble()-this.rand.nextDouble(), 0.5f, 12);
				this.worldObj.spawnEntityInWorld(e);
			}
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity e) {
		if(super.attackEntityAsMob(e)) {
			if(e instanceof EntityPlayer) {
				((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.confusion.id, 12 * 20, 0));
				((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.blindness.id, 12 * 20, 0));
			}
			e.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 2.5, 0.4D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 2.5);
			this.motionX *= 0.6D;
			this.motionZ *= 0.6D;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void dropFewItems(boolean par1, int par2) {
		this.dropItem(TwilightItemsWeapons.haliteSlicer, 200);
		if(this.rand.nextInt(2) == 0)this.dropItem(Item.getItemFromBlock(VanillaBlocks.soulFiendStatue), 1);
	}

	@Override
	public String mobName() {
		return "Soul Fiend";
	}

	@Override
	public String name() {
		return "Soul Fiend";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}