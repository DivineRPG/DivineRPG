package net.divinerpg.entities.arcana;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityZelus extends EntityDivineRPGVillager {

	public EntityZelus(World var1) {
		super(var1);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	@Override
	public int guiID() {
		return GuiHandler.zelus;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 1), new ItemStack(ArcanaItems.fyracryxSpawner, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 2, 1), new ItemStack(ArcanaItems.seimerSpawner, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 3, 1), new ItemStack(ArcanaItems.paratikuSpawner, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ArcanaItems.arcanium, 5, 1), new ItemStack(ArcanaItems.golemSpawner, 1, 0)));
	}

	@Override
	public String mobName() {
		return "Zelus";
	}

	@Override
	public void interact(Util api, EntityPlayer var1) {
		switch (this.rand.nextInt(4)) {
		case 0:
			var1.addChatMessage(Util.addChatMessage("Zelus: Have you seen Leorna lately? She's looking mighty fine as far as I can tell."));
			break;
		case 1:
			var1.addChatMessage(Util.addChatMessage("Zelus: My minions will overun any world."));
			break;
		case 2:
			var1.addChatMessage(Util.addChatMessage("Zelus: I'm thinking of giving Leorna a flower, she won't find it too fancy though."));
			break;
		case 3:
			var1.addChatMessage(Util.addChatMessage("Zelus: I've always wondered, does Leorna like plants because she almost is one?"));
			break;
		}
	}
}