package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityZelus extends EntityDivineMerchant {
	
	public EntityZelus(EntityType<? extends CreatureEntity> type, World worldIn) {
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
        		"message.zelus.fine",
                "message.zelus.minions",
                "message.zelus.flower",
                "message.zelus.plants"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.fyracryxEgg, 1), ItemRegistry.fyracryxEgg.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.seimerEgg, 1), ItemRegistry.seimerEgg.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.paratikuEgg, 1), ItemRegistry.paratikuEgg.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.golemOfRejuvenationEgg, 1), ItemRegistry.golemOfRejuvenationEgg.getMaxDamage(), 1, 1));
		return offers;
	}
}
