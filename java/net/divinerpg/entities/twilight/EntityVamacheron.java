package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityVamacheron extends EntityDivineRPGBoss {

	private int waitTick;

	public EntityVamacheron(World var1) {
		super(var1);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.vamacheronHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.vamacheronDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.vamacheronSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.vamacheronFollowRange);
	}

	@Override
	protected Item getDropItem() {
		return TwilightItemsWeapons.haliteBlade;
	}

	@Override
	public void dropFewItems(boolean par1, int par2) {
		this.dropItem(this.getDropItem(), 1);
	}

	@Override
	public String mobName() {
		return "Vamacheron";
	}

	@Override
	public String name() {
		return "Vamacheron";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}