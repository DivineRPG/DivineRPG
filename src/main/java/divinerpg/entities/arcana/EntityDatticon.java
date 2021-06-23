package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityDatticon extends EntityDivineMerchant {

	public EntityDatticon(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
                "message.datticon.merik",
                "message.datticon.furnace",
                "message.datticon.science",
                "message.datticon.plugged",
                "message.datticon.redstone"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(BlockRegistry.starBridge, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteTubes, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniteLadder, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(BlockRegistry.moltenFurnace, 16), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(BlockRegistry.greenlightFurnace, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(BlockRegistry.oceanfireFurnace, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(BlockRegistry.moonlightFurnace, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(BlockRegistry.whitefireFurnace, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 9), new ItemStack(BlockRegistry.demonFurnace, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(BlockRegistry.elevantium, 9), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(BlockRegistry.acceleron, 3), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(ItemRegistry.kormaHelmet, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.kormaChestplate, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.kormaLeggings, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(ItemRegistry.kormaBoots, 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}

}
