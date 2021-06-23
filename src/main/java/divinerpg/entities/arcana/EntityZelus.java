package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityZelus extends EntityDivineMerchant {

	public EntityZelus(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

	public String[] getChatMessages() {
        return new String[] {
        		"message.zelus.fine",
                "message.zelus.minions",
                "message.zelus.flower",
                "message.zelus.plants"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.fyracryxEgg, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.seimerEgg, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.paratikuEgg, 1), random.nextInt(7), 5),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.golemOfRejuvenationEgg, 1), random.nextInt(7), 5)
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}

}
