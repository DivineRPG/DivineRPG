package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityLeorna extends EntityDivineMerchant {
	
	public EntityLeorna(EntityType<? extends CreatureEntity> type, World worldIn) {
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
	    //return GUIHandler.LEORNA_GUI_ID;
		return 5;
	}
	
	protected String[] getChatMessages() {
        return new String[] {
        		"message.leorna.hitchak",
                "message.leorna.lamona",
                "message.leorna.nature",
                "message.leorna.plants",
                "message.leorna.zelus"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(ItemRegistry.eucalyptusRootSeeds, 1), ItemRegistry.eucalyptusRootSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.marsineSeeds, 1), ItemRegistry.marsineSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.firestockSeeds, 1), ItemRegistry.firestockSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.pinflySeeds, 1), ItemRegistry.pinflySeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(ItemRegistry.aquamarineSeeds, 1), ItemRegistry.aquamarineSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.hitchakSeeds, 1), ItemRegistry.hitchakSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.veiloSeeds, 1), ItemRegistry.veiloSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 9), new ItemStack(ItemRegistry.lamonaSeeds, 1), ItemRegistry.lamonaSeeds.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteDirt, 16), BlockRegistry.arcaniteDirt.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteGrass, 16), BlockRegistry.arcaniteGrass.asItem().getMaxDamage(), 1, 1));
		return offers;
	}
}
