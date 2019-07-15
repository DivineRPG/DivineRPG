package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class Datticon extends EntityDivineRPGVillager {

	public Datticon(World Util) {
		super(Util);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
	}

	@Override
	public void extraInteract(EntityPlayer var2) {
		switch (this.rand.nextInt(5)) {
		case 0:
			var2.sendMessage(Utils.getChatComponent("Datticon: Keep an eye on Merik, he's stealing my technology."));
			break;
		case 1:
			var2.sendMessage(Utils.getChatComponent("Datticon: Do you need something hotter than hell? I've come up with this new furnace."));
			break;
		case 2:
			var2.sendMessage(Utils.getChatComponent("Datticon: Those other fools think it's all magic, I use science!"));
			break;
		case 3:
			var2.sendMessage(Utils.getChatComponent("Datticon: That doesn't need to be plugged in."));
			break;
		case 4:
			var2.sendMessage(Utils.getChatComponent("Datticon: I tried using redstone, but it's primitive."));
			break;
		}
	}
//FIXME - Datticon gui
//	@Override
//	public int guiID() {
//		return GuiHandler.datticon;
//	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		//FIXME - Add after furnaces are in
		//var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1, 0), new ItemStack(ModItems.arcaniumBucket, 1, 0)));
//		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5, 0), new ItemStack(ModBlocks.arcaniteRails, 8, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 0), new ItemStack(ModBlocks.starBridge, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3, 0), new ItemStack(ModBlocks.arcaniteTubes, 16, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 0), new ItemStack(ModBlocks.moltenFurnace, 1, 0)));
//		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3, 0), new ItemStack(ModBlocks.greenlightFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4, 0), new ItemStack(ModBlocks.oceanfireFurnace, 1, 0)));
//		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5, 0), new ItemStack(ModBlocks.moonlightFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7, 0), new ItemStack(ModBlocks.whitefireFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 9, 0), new ItemStack(ModBlocks.demonFurnace, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3, 0), new ItemStack(ModBlocks.elevantium, 9, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3, 0), new ItemStack(ModBlocks.acceleron, 3, 0)));
	}


}