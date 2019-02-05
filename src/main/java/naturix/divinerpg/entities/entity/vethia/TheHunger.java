package naturix.divinerpg.entities.entity.vethia;

import naturix.divinerpg.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class TheHunger extends EntityDivineRPGVillager {

    public TheHunger(World worldIn) {
		super(worldIn);
	}

    @Override
	public void extraInteract(EntityPlayer player) {
    	switch (this.rand.nextInt(4)) {
		case 0:
			player.sendMessage(Utils.getChatComponent("The Hunger: Mmm. I'm hungry."));
			break;
		case 1:
			player.sendMessage(Utils.getChatComponent("The Hunger: Can you come a little closer?"));
			break;
		case 2:
			player.sendMessage(Utils.getChatComponent("The Hunger: You need to fatten yourself up."));
			break;
		case 3:
			player.sendMessage(Utils.getChatComponent("The Hunger: Let's go out to dinner. You'll be cooking."));
			break;
    	}
	}
	
	@Override
	public int guiID() {
		//return GuiHandler.hunger;
		return 2;
	}
	
	@Override
	public void addRecipies(MerchantRecipeList recipes) {
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(VetheaItems.dreamCarrot, 2, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.dreamMelon, 4, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.dreamPie, 5, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 10, 0), new ItemStack(VetheaItems.dreamCake, 8, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.barredDoor, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.diskTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.cannonTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.backswordTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.hammerTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.bowTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.staffTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(VetheaItems.clawTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 5, 0), new ItemStack(VetheaItems.degradedTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.lightDreamBricks, 16, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.darkDreamBricks, 16, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.redDreamBricks, 16, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 2, 0), new ItemStack(VetheaBlocks.dreamDirt, 64, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(VetheaBlocks.smoothGlass, 16, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 4, 0), new ItemStack(VetheaBlocks.firelight, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 4, 0), new ItemStack(Blocks.chest, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.dirtyPearls, 2, 0), new ItemStack(VetheaItems.teakerArrow, 32, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.cleanPearls, 1, 0), new ItemStack(VetheaItems.dreamSweets, 4, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.cleanPearls, 5, 0), new ItemStack(VetheaItems.finishedTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.cleanPearls, 2, 0), new ItemStack(VetheaItems.darvenArrow, 32, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.cleanPearls, 4, 0), new ItemStack(VetheaItems.pardimalArrow, 32, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.cleanPearls, 6, 0), new ItemStack(VetheaItems.karosArrow, 32, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.cleanPearls, 15, 0), new ItemStack(VetheaItems.minersAmulet, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.polishedPearls, 20, 0), new ItemStack(VetheaItems.dreamFlint, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.polishedPearls, 5, 0), new ItemStack(VetheaItems.glisteningTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.polishedPearls, 5, 0), new ItemStack(VetheaItems.demonizedTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.shinyPearls, 40, 0), new ItemStack(VetheaItems.moonClock, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.shinyPearls, 25, 0), new ItemStack(VetheaItems.heivaBelt, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.shinyPearls, 1, 0), new ItemStack(VetheaItems.dreamSours, 4, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.shinyPearls, 5, 0), new ItemStack(VetheaItems.tormentedTemplate, 1, 0)));
		//recipes.add(new InfiniteTrade(new ItemStack(ModItems.rockChunks, 25, 0), new ItemStack(VetheaItems.karosRockmaul, 1, 0)));
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D;
	}
}
