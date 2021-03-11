package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class EntityWarGeneral extends EntityDivineMerchant {
	
	public EntityWarGeneral(EntityType<? extends CreatureEntity> type, World worldIn) {
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
	    //return GUIHandler.DATTICON_GUI_ID;
		return 5;
	}
	
	protected String[] getChatMessages() {
        return new String[] {
        		"message.general.blade",
                "message.general.merik",
                "message.general.weapons"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.dungeonTokens, 17), new ItemStack(ItemRegistry.meteorMash, 1), ItemRegistry.meteorMash.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(ItemRegistry.starlight, 1), ItemRegistry.starlight.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.dungeonTokens, 20), new ItemStack(ItemRegistry.staffOfStarlight, 1), ItemRegistry.staffOfStarlight.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(ItemRegistry.arcaniteBlaster, 1), ItemRegistry.arcaniteBlaster.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 30), new ItemStack(ItemRegistry.arcaniteBlade, 1), ItemRegistry.arcaniteBlade.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(ItemRegistry.generalsStaff, 1), ItemRegistry.generalsStaff.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ItemRegistry.vemosHelmet, 1), ItemRegistry.vemosHelmet.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ItemRegistry.vemosChestplate, 1), ItemRegistry.vemosChestplate.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ItemRegistry.vemosLeggings, 1), ItemRegistry.vemosLeggings.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ItemRegistry.vemosBoots, 1), ItemRegistry.vemosBoots.getMaxDamage(), 1, 1));
		return offers;
	}
}

