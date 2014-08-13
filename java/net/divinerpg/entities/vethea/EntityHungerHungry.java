package net.divinerpg.entities.vethea;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

public class EntityHungerHungry extends EntityDivineRPGVillager {

	public EntityHungerHungry(World var1) {
		super(var1);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void interact(Util api, EntityPlayer var2) {
		switch (this.rand.nextInt(4)) {
		case 0:
			var2.addChatMessage(api.addChatMessage("The Hunger: Mmm. I'm hungry."));
			break;
		case 1:
			var2.addChatMessage(api.addChatMessage("The Hunger: Can you come a little closer?"));
			break;
		case 2:
			var2.addChatMessage(api.addChatMessage("The Hunger: You need to fatten yourself up."));
			break;
		case 3:
			var2.addChatMessage(api.addChatMessage("The Hunger: Let's go out to dinner. You'll be cooking."));
			break;
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.hunger;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaItems.dreamCarrot, 2, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.dreamMelon, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.dreamPie, 5, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 10, 0), new ItemStack(VetheaItems.dreamCake, 8, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.diskTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.cannonTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.backswordTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.hammerTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.bowTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.staffTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.clawTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.degradedTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.dreamBricks1, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.dreamBricks2, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.smoothGlass, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 4, 0), new ItemStack(VetheaBlocks.firelight, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 4, 0), new ItemStack(Blocks.chest, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.dirtyPearls, 2, 0), new ItemStack(VetheaItems.teakerArrow, 32, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.cleanPearls, 1, 0), new ItemStack(VetheaItems.dreamSweets, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.cleanPearls, 5, 0), new ItemStack(VetheaItems.finishedTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.cleanPearls, 2, 0), new ItemStack(VetheaItems.darvenArrow, 32, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.cleanPearls, 4, 0), new ItemStack(VetheaItems.pardimalArrow, 32, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.cleanPearls, 6, 0), new ItemStack(VetheaItems.karosArrow, 32, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.polishedPearls, 20, 0), new ItemStack(VetheaItems.dreamFlint, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.polishedPearls, 5, 0), new ItemStack(VetheaItems.glisteningTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.polishedPearls, 5, 0), new ItemStack(VetheaItems.demonizedTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.shinyPearls, 40, 0), new ItemStack(VetheaItems.moonClock, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.shinyPearls, 1, 0), new ItemStack(VetheaItems.dreamSours, 4, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.shinyPearls, 5, 0), new ItemStack(VetheaItems.tormentedTemplate, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(VetheaItems.shinyPearls, 5, 0), new ItemStack(Items.bed, 1, 0)));
	}

	@Override
	public String mobName() {
		return "Hunger Hungry";
	}
}