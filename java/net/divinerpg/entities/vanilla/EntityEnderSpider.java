package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.vethea.EntityTwins;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class EntityEnderSpider extends EntityEnderman {
	
	public EntityEnderSpider(World var1) {
		super(var1);
		this.setSize(0.9F, 0.9F);
		this.experienceValue = 20;
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.enderSpiderHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.enderSpiderDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.enderSpiderSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.enderSpiderFollowRange);
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.hellSpider);
	}
 
	@Override
	protected Item getDropItem() {
		return VanillaItemsOther.enderShard;
	}
 
	@Override
	protected void dropFewItems(boolean var1, int var2) {   
		this.dropItem(VanillaItemsOther.enderShard, 1);
	}
}