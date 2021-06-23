package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityWarGeneral extends EntityDivineMerchant {

	public EntityWarGeneral(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
        		"message.general.blade",
                "message.general.merik",
                "message.general.weapons"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeonTokens, 17), new ItemStack(ItemRegistry.meteorMash, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(ItemRegistry.starlight, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dungeonTokens, 20), new ItemStack(ItemRegistry.staffOfStarlight, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(ItemRegistry.arcaniteBlaster, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 30), new ItemStack(ItemRegistry.arcaniteBlade, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(ItemRegistry.generalsStaff, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ItemRegistry.vemosHelmet, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ItemRegistry.vemosLeggings, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.vemosLeggings, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.vemosBoots, 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}
}

