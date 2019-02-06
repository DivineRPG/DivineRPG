package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.objects.entities.entity.InfiniteTrade;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class WorkshopMerchant extends EntityDivineRPGVillager {

private static final String[] MESSAGE = {"message.merchant.ho", "message.merchant.out", "message.merchant.in", "message.merchant.burr"};

	public WorkshopMerchant(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public void extraInteract(EntityPlayer player) {
		player.sendMessage(Utils.getChatComponent("Merchant: " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
	}
	
	@Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if(!this.world.isRemote) {
			extraInteract(player);
			player.openGui(DivineRPG.instance, guiID(), this.world, getEntityId(), 0, 0);
			//player.triggerAchievement(DivineRPGAchievements.lilGift);
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}
	
	@Override
	public int guiID() {
		//return GuiHandler.merchant;
		return 0;
	}
	
	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaCap, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaTunic, 1, 0)));
		list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaPants, 1, 0)));
		//list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaBoots, 1, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.eggNog, 2, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.chocolateLog, 5, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.peppermints, 15, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaItems.fruitCake, 3, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 20), new ItemStack(IceikaItems.icicleBane, 1, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.greenXmasLights, 16, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.redXmasLights, 16, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.blueXmasLights, 16, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.yellowXmasLights, 16, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.purpleXmasLights, 16, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 3), new ItemStack(IceikaBlocks.presentBox, 1)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 0)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 1)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 2)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 3)));
		//list.add(new InfiniteTrade(new ItemStack(IceikaItems.snowflake, 1), new ItemStack(IceikaBlocks.candyCane, 4, 4)));
	}
}

