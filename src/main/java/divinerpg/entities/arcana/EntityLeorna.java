package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityLeorna extends EntityDivineMerchant {
	
	public EntityLeorna(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
        		"message.leorna.hitchak",
                "message.leorna.lamona",
                "message.leorna.nature",
                "message.leorna.plants",
                "message.leorna.zelus"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(ItemRegistry.eucalyptusRootSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.marsineSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.firestockSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.pinflySeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(ItemRegistry.aquamarineSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.hitchakSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.veiloSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 9), new ItemStack(ItemRegistry.lamonaSeeds, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteDirt, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteGrass, 16), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}

}
