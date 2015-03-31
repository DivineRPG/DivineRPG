package net.divinerpg.entities.arcana;

import net.divinerpg.client.GuiHandler;
import net.divinerpg.entities.base.EntityDivineRPGVillager;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityCaptianMerik extends EntityDivineRPGVillager {

	public EntityCaptianMerik(World Util) {
		super(Util);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public void extraInteract(EntityPlayer var2) {
		switch (this.rand.nextInt(5)) {
		case 0:
			var2.addChatMessage(Util.getChatComponent("Captian Merik: Like my sword? You should."));
			break;
		case 1:
			var2.addChatMessage(Util.getChatComponent("Captian Merik: Datticon thinks I'm stealing his technology for my weapons, my technology is beyond his."));
			break;
		case 2:
			var2.addChatMessage(Util.getChatComponent("Captian Merik: Hurry up, I've got work to do."));
			break;
		case 3:
			var2.addChatMessage(Util.getChatComponent("Captian Merik: I've been in more battles than this dungeon has creatures."));
			break;
		case 4:
			var2.addChatMessage(Util.getChatComponent("Captian Merik: If you see the phoenix, let me know, it's just another day for me."));
			break;
		}
	}

	@Override
	public int guiID() {
		return GuiHandler.captainMerik;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 5, 1), new ItemStack(ArcanaItems.stormSword, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 12, 1), new ItemStack(ArcanaItems.enderScepter, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 20, 1), new ItemStack(ArcanaItems.wraithbane, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 1), new ItemStack(ArcanaItems.shadowSword, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 4, 1), new ItemStack(ArcanaItems.starlight, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 8, 1), new ItemStack(ArcanaItems.arcaniumSaber, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 20, 1), new ItemStack(ArcanaItems.captainsSparkler, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 12, 1), new ItemStack(ArcanaItems.firefly, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.dungeonTokens, 20, 1), new ItemStack(ArcanaItems.staffStarlight, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.dungeonTokens, 15, 1), new ItemStack(ArcanaItems.meriksMissile, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.dungeonTokens, 30, 1), new ItemStack(ArcanaItems.liviciaSword, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 6, 1), new ItemStack(ArcanaItems.laVekor, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 1, 1), new ItemStack(ArcanaItems.grenade, 10, 0)));
	}

	@Override
	public String mobName() {
		return "Captain Merik";
	}
}