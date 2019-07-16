package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class WarGeneral extends EntityDivineRPGVillager {
	
	private static final String[] MESSAGE = {"message.general.weapons", "message.general.1", "message.general.2"};

	public WarGeneral(World w) {
		super(w);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
	}

	@Override
	public void extraInteract(EntityPlayer p) {
		p.sendMessage(Utils.getChatComponent("War General: " + MessageLocalizer.normal(MESSAGE[this.rand.nextInt(3)])));
	}

	//FIXME - War General GUI
//	@Override
//	public int guiID() {
//		return GuiHandler.warGeneral;
//	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 6), new ItemStack(ModItems.divineAccumulator)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 17), new ItemStack(ModItems.meteorMash)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 18), new ItemStack(ModItems.arcaniteBlaster)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 30), new ItemStack(ModItems.arcaniteBlade)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 18), new ItemStack(ModItems.generalsStaff)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(ModItems.arcaniumReflector, 1, 0)));
		list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(ModItems.arcaniumAttractor, 1, 0)));
	}

}