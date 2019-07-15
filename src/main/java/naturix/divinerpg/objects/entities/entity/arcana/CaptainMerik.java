package naturix.divinerpg.objects.entities.entity.arcana;

import moze_intel.projecte.utils.GuiHandler;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class CaptainMerik extends EntityDivineRPGVillager {

	public CaptainMerik(World Util) {
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
			var2.sendMessage(Utils.getChatComponent("Captian Merik: Like my sword? You should."));
			break;
		case 1:
			var2.sendMessage(Utils.getChatComponent("Captian Merik: Datticon thinks I'm stealing his technology for my weapons, my technology is beyond his."));
			break;
		case 2:
			var2.sendMessage(Utils.getChatComponent("Captian Merik: Hurry up, I've got work to do."));
			break;
		case 3:
			var2.sendMessage(Utils.getChatComponent("Captian Merik: I've been in more battles than this dungeon has creatures."));
			break;
		case 4:
			var2.sendMessage(Utils.getChatComponent("Captian Merik: If you see the phoenix, let me know, it's just another day for me."));
			break;
		}
	}
//FIXME - Meriks GUI
//	@Override
//	public int guiID() {
//		return GuiHandler.captainMerik;
//	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5, 1), new ItemStack(ModItems.stormSword, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 12, 1), new ItemStack(ModItems.enderScepter, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 20, 1), new ItemStack(ModItems.ghostbane, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 1), new ItemStack(ModItems.shadowSword, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4, 1), new ItemStack(ModItems.starlight, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8, 1), new ItemStack(ModItems.arcaniumSaber, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 20, 1), new ItemStack(ModItems.captainsSparkler, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 12, 1), new ItemStack(ModItems.firefly, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 20, 1), new ItemStack(ModItems.staffStarlight, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 15, 1), new ItemStack(ModItems.meriksMissile, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 30, 1), new ItemStack(ModItems.liviciaSword, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 6, 1), new ItemStack(ModItems.laVekor, 1, 0)));
		var2.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1, 1), new ItemStack(ModItems.grenade, 10, 0)));
	}

}