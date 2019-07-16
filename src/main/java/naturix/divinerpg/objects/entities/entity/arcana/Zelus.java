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

public class Zelus extends EntityDivineRPGVillager {

	public Zelus(World var1) {
		super(var1);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
	}
	//FIXME - Zelus gui
//	@Override
//	public int guiID() {
//		return GuiHandler.zelus;
//	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 1), new ItemStack(ModItems.fyracryxSpawner, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2, 1), new ItemStack(ModItems.seimerSpawner, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3, 1), new ItemStack(ModItems.paratikuSpawner, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5, 1), new ItemStack(ModItems.golemSpawner, 1, 0)));
	}

	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void extraInteract(EntityPlayer var1) {
		switch (this.rand.nextInt(4)) {
		case 0:
			var1.sendMessage(Utils.getChatComponent("Zelus: Have you seen Leorna lately? She's looking mighty fine as far as I can tell."));
			break;
		case 1:
			var1.sendMessage(Utils.getChatComponent("Zelus: My minions will overun any world."));
			break;
		case 2:
			var1.sendMessage(Utils.getChatComponent("Zelus: I'm thinking of giving Leorna a flower, she won't find it too fancy though."));
			break;
		case 3:
			var1.sendMessage(Utils.getChatComponent("Zelus: I've always wondered, does Leorna like plants because she almost is one?"));
			break;
		}
	}
}