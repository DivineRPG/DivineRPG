package net.divinerpg.entities.iceika;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityWorkshopTinkerer extends EntityDivineRPGVillager {

	public EntityWorkshopTinkerer(World var1)  {
		super(var1);
		this.setSize(1.0F, 2.0F);
	}

	@Override
	public void interact(Util api, EntityPlayer p) {
		switch(this.rand.nextInt(4)) {
		case 0:
			p.addChatMessage(api.addChatMessage("Tinkerer: Hohoho."));
			break;
		case 1:
			p.addChatMessage(api.addChatMessage("Tinkerer: It's cold outside."));
			break;
		case 2:
			p.addChatMessage(api.addChatMessage("Tinkerer: It's cold inside."));
			break;
		case 3:
			p.addChatMessage(api.addChatMessage("Tinkerer: Burr!"));
			break;
		}
	}
	
	@Override
	public boolean interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			interact(new Util(), var1);
			var1.openGui(DivineRPG.instance, guiID(), this.worldObj, getEntityId(), 0, 0);
			var1.triggerAchievement(DivineRPGAchievements.lilTinkerin);
			return true;
		} else {
			return super.interact(var1);
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.tinker;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 1, 1), new ItemStack(VanillaItemsWeapons.shuriken, 16, 0), new ItemStack(IceikaItems.snowflakeShuriken, 16, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 4, 1), new ItemStack(VanillaItemsWeapons.serenadeStriker, 1, 0), new ItemStack(IceikaItems.serenadeOfIce, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 7, 1), new ItemStack(VanillaItemsWeapons.slimeSword, 1, 0), new ItemStack(IceikaItems.glacierSword, 1, 0)));
		//list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 12, 1), new ItemStack(VanillaItemsWeapons.shadowBow, 1, 0),new ItemStack(IceikaItems.icicleBow, 1, 0)));
		//list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 12, 1), new ItemStack(VanillaItemsWeapons.crabClawCannon, 1, 0),new ItemStack(IceikaItems.frostClawCannon, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 12, 1), new ItemStack(VanillaItemsWeapons.frostCannon, 1, 0),new ItemStack(IceikaItems.fractiteCannon, 1, 0)));
		//list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 15, 1),new ItemStack(VanillaItemsWeapons.frostSword, 1, 0), new ItemStack(IceikaItems.frostKingSword, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 18, 1), new ItemStack(IceikaItems.soundOfMusic, 1, 0), new ItemStack(IceikaItems.soundOfCarols, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 25, 1), new ItemStack(VanillaItemsWeapons.enderSword, 1, 0), new ItemStack(IceikaItems.enderice, 1, 0)));
		//list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 30, 1), new ItemStack(VanillaItemsWeapons.bluefirebow, 1, 0), new ItemStack(IceikaItems.snowStormBow, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 45, 1), new ItemStack(VanillaItemsWeapons.bedrockMaul, 1, 0), new ItemStack(IceikaItems.frozenMaul, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 40, 1), new ItemStack(VanillaItemsWeapons.divineSword, 1, 0), new ItemStack(IceikaItems.icineSword, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(IceikaItems.snowflake, 15, 1), new ItemStack(VanillaItemsWeapons.sandslash, 1, 0), new ItemStack(IceikaItems.snowSlash, 1, 0)));
	}

	@Override
	public String mobName() {
		return "Workshop Tinkerer";
	}
}