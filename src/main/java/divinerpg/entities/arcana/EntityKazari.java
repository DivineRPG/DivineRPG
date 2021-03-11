package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityKazari extends EntityDivineMerchant {
	
	public EntityKazari(EntityType<? extends CreatureEntity> type, World worldIn) {
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
	    //return GUIHandler.KAZARI_GUI_ID;
		return 5;
	}
	
	protected String[] getChatMessages() {
        return new String[] {
        		"message.kazari.1",
                "message.kazari.2",
                "message.kazari.3",
                "message.kazari.4",
                "message.kazari.5",
                "message.kazari.6",
                "message.kazari.7",
                "message.kazari.8"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.ancientKey, 1), ItemRegistry.ancientKey.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.degradedKey, 1), ItemRegistry.degradedKey.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.soulKey, 1), ItemRegistry.soulKey.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.sludgeKey, 1), ItemRegistry.sludgeKey.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientBricksBreakable, 16), BlockRegistry.starBridge.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientStoneBreakable, 16), BlockRegistry.arcaniteTubes.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientTileBreakable, 16), BlockRegistry.arcaniteLadder.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniumMetalBreakable, 16), BlockRegistry.moltenFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniumPowerBreakable, 4), BlockRegistry.greenlightFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.degradedBricksBreakable, 16), BlockRegistry.oceanfireFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.dungeonLampBreakable, 4), BlockRegistry.moonlightFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.soulSludgeBreakable, 16), BlockRegistry.whitefireFurnace.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.soulStoneBreakable, 16), BlockRegistry.demonFurnace.asItem().getMaxDamage(), 1, 1));
		return offers;
	}
}
