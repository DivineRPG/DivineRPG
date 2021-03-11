package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityDatticon extends EntityDivineMerchant {
	
	public EntityDatticon(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }
	
	@Override
	protected void onVillagerTrade(MerchantOffer offer) {
		
	}

	@Override
	protected void populateTradeData() {
		
	}
	
	@Override
	protected int getGuiId() {
	    //return GUIHandler.DATTICON_GUI_ID;
		return 5;
	}
	
	protected String[] getChatMessages() {
        return new String[] {
                "message.datticon.merik",
                "message.datticon.furnace",
                "message.datticon.science",
                "message.datticon.plugged",
                "message.datticon.redstone"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(BlockRegistry.starBridge, 16), BlockRegistry.starBridge.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteTubes, 16), BlockRegistry.arcaniteTubes.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteLadder, 1), BlockRegistry.arcaniteLadder.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(BlockRegistry.moltenFurnace, 16), BlockRegistry.moltenFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(BlockRegistry.greenlightFurnace, 1), BlockRegistry.greenlightFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(BlockRegistry.oceanfireFurnace, 1), BlockRegistry.oceanfireFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(BlockRegistry.moonlightFurnace, 1), BlockRegistry.moonlightFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(BlockRegistry.whitefireFurnace, 1), BlockRegistry.whitefireFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 9), new ItemStack(BlockRegistry.demonFurnace, 1), BlockRegistry.demonFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(BlockRegistry.elevantium, 9), BlockRegistry.elevantium.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(BlockRegistry.acceleron, 3), BlockRegistry.acceleron.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(ItemRegistry.kormaHelmet, 1), ItemRegistry.kormaHelmet.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.kormaChestplate, 1), ItemRegistry.kormaChestplate.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.kormaLeggings, 1), ItemRegistry.kormaLeggings.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(ItemRegistry.kormaBoots, 1), ItemRegistry.kormaBoots.getMaxDamage(), 1, 1));
		return offers;
	}
}
