package net.divinerpg.entities.arcana;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWarGeneral extends EntityDivineRPGVillager {
	
	private static final String[] MESSAGE = {"message.general.weapons", "message.general.1", "message.general.2"};

	public EntityWarGeneral(World w) {
		super(w);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void extraInteract(EntityPlayer p) {
		p.addChatMessage(Util.getChatComponent("War General: " + MessageLocalizer.normal(MESSAGE[this.rand.nextInt(3)])));
	}

	@Override
	public int guiID() {
		return GuiHandler.warGeneral;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 6), new ItemStack(ArcanaItems.divineAccumulator)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.dungeonTokens, 17), new ItemStack(ArcanaItems.meteorMash)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 18), new ItemStack(ArcanaItems.arcaniteBlaster)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 30), new ItemStack(ArcanaItems.arcaniteBlade)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 18), new ItemStack(ArcanaItems.generalsStaff)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 7), new ItemStack(ArcanaItems.reflector, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 7), new ItemStack(ArcanaItems.attractor, 1, 0)));
	}

	@Override
	public String mobName() {
		return "War General";
	}
}