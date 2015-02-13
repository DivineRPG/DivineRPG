package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJungleDramcryx extends EntityDivineRPGMob {
	
	public EntityJungleDramcryx(World par1World) {
		super(par1World);
		addAttackingAI();
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleDramcryxHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleDramcryxDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleDramcryxSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleDramcryxFollowRange);
	}
	
	@Override
	public void onDeath(DamageSource d) {
		super.onDeath(d);
		if (d.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)d.getEntity();
			player.triggerAchievement(DivineRPGAchievements.dramcryxDeath);
		}
	}
	
	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.dramcryx);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.dramcryxHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.dramcryxHurt);
	}

	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.jungleShards;
	}

	@Override
	public String mobName() {
		return "Jungle Dramcryx";
	}
}