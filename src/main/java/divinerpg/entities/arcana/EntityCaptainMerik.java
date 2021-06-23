package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;


public class EntityCaptainMerik extends EntityDivineMerchant {

	public EntityCaptainMerik(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
                "message.merik.battles",
                "message.merik.datticon",
                "message.merik.hurry",
                "message.merik.phoenix",
                "message.merik.sword"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.stormSword, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.ghostbane, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.shadowSaber, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.arcaniumSaber, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.captainsSparkler, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(ItemRegistry.firefly, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeonTokens, 15), new ItemStack(ItemRegistry.meriksMissile, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeonTokens, 30), new ItemStack(ItemRegistry.liviciaSword, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(ItemRegistry.laVekor, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(ItemRegistry.grenade, 10), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaHelmet, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaChestplate, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaLeggings, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaBoots, 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}

}
