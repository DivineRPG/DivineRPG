package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.entities.vanilla.projectile.EntityDivineArrow;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityEternalArcher extends EntityDivineRPGBoss{
	
	private int armSelected;
	private int abilityTick;

	public EntityEternalArcher(World world) {
		super(world);
		this.setSize(3, 5);
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 80));
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.eternalArcherHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.eternalArcherSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.eternalArcherFollowRange);
    }
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.entityToAttack == null || this.rand.nextInt(200) == 0) this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 48);
		if(this.entityToAttack != null && ((this.entityToAttack instanceof EntityPlayer && ((EntityPlayer)this.entityToAttack).capabilities.isCreativeMode) || this.entityToAttack.isDead)) this.entityToAttack = null;
		if(this.abilityTick > 0) this.abilityTick--;
		if(this.abilityTick == 0) {
			if(this.armSelected < 5) this.armSelected++;
			else if(this.armSelected == 5) this.armSelected = 0;
			this.abilityTick = 400;
		}
		
		if(this.abilityTick%40 == 0 && this.entityToAttack != null && !this.worldObj.isRemote) {
			this.worldObj.spawnEntityInWorld(new EntityDivineArrow(this.worldObj, this, (EntityLivingBase)this.entityToAttack, 1.6f, 12, 23, "furyArrow"));
		}
	}
	
	public int getSelectedArm() {
		return this.armSelected;
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(TwilightItemsWeapons.haliteBow);
	}

	@Override
	public String name() {
		return "Eternal Archer";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}

	@Override
	public String mobName() {
		return "Eternal Archer";
	}

}