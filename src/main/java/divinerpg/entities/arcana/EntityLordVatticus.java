package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityLordVatticus extends EntityDivineMerchant {
	
	public EntityLordVatticus(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
        		"message.vatticus.discover",
                "message.vatticus.feel",
                "message.vatticus.magic",
                "message.vatticus.noend",
                "message.vatticus.strength"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 1), new ItemStack(Items.BLUE_DYE, 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(Items.EXPERIENCE_BOTTLE, 12), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(Blocks.SOUL_SAND, 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(ItemRegistry.weakArcanaPotion, 2), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 4), new ItemStack(ItemRegistry.strongArcanaPotion, 2), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 1), new ItemStack(Items.BLAZE_ROD, 2), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(Items.NETHER_WART, 8), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.wizardsBook, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 3), new ItemStack(Blocks.ENCHANTING_TABLE, 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}

}
