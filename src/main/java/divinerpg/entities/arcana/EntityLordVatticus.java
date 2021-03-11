package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityLordVatticus extends EntityDivineMerchant {
	
	public EntityLordVatticus(EntityType<? extends CreatureEntity> type, World worldIn) {
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
	    //return GUIHandler.LORD_VATTICUS_GUI_ID;
		return 5;
	}
	
	protected String[] getChatMessages() {
        return new String[] {
        		"message.vatticus.discover",
                "message.vatticus.feel",
                "message.vatticus.magic",
                "message.vatticus.noend",
                "message.vatticus.strength"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 1), new ItemStack(Items.BLUE_DYE, 8), Items.BLUE_DYE.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(Items.EXPERIENCE_BOTTLE, 12), Items.EXPERIENCE_BOTTLE.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(Blocks.SOUL_SAND, 8), Blocks.SOUL_SAND.asItem().getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 2), new ItemStack(ItemRegistry.weakArcanaPotion, 2), ItemRegistry.weakArcanaPotion.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 4), new ItemStack(ItemRegistry.strongArcanaPotion, 2), ItemRegistry.strongArcanaPotion.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 1), new ItemStack(Items.BLAZE_ROD, 2), Items.BLAZE_ROD.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(Items.NETHER_WART, 8), Items.NETHER_WART.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.wizardsBook, 1), ItemRegistry.wizardsBook.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.collector, 3), new ItemStack(Blocks.ENCHANTING_TABLE, 1), Blocks.ENCHANTING_TABLE.asItem().getMaxDamage(), 1, 1));
		return offers;
	}
}
