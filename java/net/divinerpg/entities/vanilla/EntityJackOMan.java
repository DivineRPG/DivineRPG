package net.divinerpg.entities.vanilla;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.client.GuiHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

public class EntityJackOMan extends EntityDivineRPGVillager {
    
    public EntityJackOMan(World var1) {
		super(var1);
	}

	private static final ItemStack defaultHeldItem = new ItemStack(VanillaItemsWeapons.scythe, 1);

	@Override
	public ItemStack getHeldItem() {
		return defaultHeldItem;
	}

    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.jackOMan);
    }
 
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.jackOMan);
    }
 
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.jackOMan);
    }

	@Override
	public void interact(Util api, EntityPlayer p) {
		if(!this.worldObj.isRemote) {
            switch(this.rand.nextInt(4)) {
        	case 0:
        		p.addChatMessage(Util.addChatMessage("Jack'O Man: BOO!"));
        		break;
        	case 1:
        		p.addChatMessage(Util.addChatMessage("Jack'O Man: I seem to have lost my head."));
        		break;
        	case 2:
        		p.addChatMessage(Util.addChatMessage("Jack'O Man: HURAH!"));
        		break;
        	case 3:
        		p.addChatMessage(Util.addChatMessage("Jack'O Man: Have you seen my head?"));
        		break;
        	}            
		}
	}
	
	@Override
	public boolean interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			interact(new Util(), var1);
			var1.openGui(DivineRPG.instance, guiID(), this.worldObj, getEntityId(), 0, 0);
			var1.triggerAchievement(DivineRPGAchievements.halloweenSpirit);
			return true;
		} else {
			return super.interact(var1);
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.jackOMan;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManBody)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManLegs)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.pumpkin, 50), new ItemStack(Items.ender_eye, 10), new ItemStack(VanillaItemsArmor.jackOManBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 3, 1), new ItemStack(VanillaItemsArmor.witherReaperHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 5, 1), new ItemStack(VanillaItemsArmor.witherReaperBody)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 4, 1), new ItemStack(VanillaItemsArmor.witherReaperLegs)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 2, 1), new ItemStack(VanillaItemsArmor.witherReaperBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.skull, 6, 1), new ItemStack(Items.ender_eye, 60), new ItemStack(VanillaItemsWeapons.scythe)));
	}

	@Override
	public String mobName() {
		return "Jack 'O' Man";
	}
}