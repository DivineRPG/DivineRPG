package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.divinerpg.entities.twilight.projectile.EntityEternalArcherArrow;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
		this.experienceValue = 250;
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.eternalArcherHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.eternalArcherSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.eternalArcherFollowRange);
    }
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.entityToAttack != null) this.getLookHelper().setLookPosition(this.entityToAttack.posX, this.entityToAttack.posY + (double)this.entityToAttack.getEyeHeight(), this.entityToAttack.posZ, 10.0F, 5);
		
		if(this.entityToAttack == null || this.rand.nextInt(200) == 0) this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, 48);
		if(this.entityToAttack != null && ((this.entityToAttack instanceof EntityPlayer && ((EntityPlayer)this.entityToAttack).capabilities.isCreativeMode) || this.entityToAttack.isDead)) this.entityToAttack = null;
		if(this.abilityTick > 0) this.abilityTick--;
		if(this.abilityTick == 0) {
			if(this.armSelected < 5) this.armSelected++;
			else if(this.armSelected == 5) this.armSelected = 0;
			this.abilityTick = 400;
		}
		
		if(this.abilityTick%30 == 0 && this.entityToAttack != null && !this.worldObj.isRemote) {
			this.worldObj.spawnEntityInWorld(new EntityEternalArcherArrow(this.worldObj, this, (EntityLivingBase)this.entityToAttack, this.armSelected));
		}
	}
	
	@Override
	public void dropFewItems(boolean beenHit, int lootingLevel) {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(TwilightItemsArmor.haliteBoots, 1);
			break;
		case 1:
			this.dropItem(TwilightItemsArmor.haliteHelmet, 1);
		}
		if(this.rand.nextInt(2) == 0)this.dropItem(Item.getItemFromBlock(VanillaBlocks.eternalArcherStatue), 1);
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