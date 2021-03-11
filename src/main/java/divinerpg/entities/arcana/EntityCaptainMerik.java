package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.ItemRegistry;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.world.*;

public class EntityCaptainMerik extends EntityDivineMerchant {
	public EntityCaptainMerik(EntityType<? extends CreatureEntity> type, World worldIn) {
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
	    //return GUIHandler.CAPTAIN_MERIK_GUI_ID;
		return 5;
	}
	
	protected String[] getChatMessages() {
        return new String[] {
                "message.merik.battles",
                "message.merik.datticon",
                "message.merik.hurry",
                "message.merik.phoenix",
                "message.merik.sword"
        };
    }
	
	@Override
	public MerchantOffers getRecipeList() {
		MerchantOffers offers = new MerchantOffers();
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.stormSword, 1), ItemRegistry.stormSword.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.ghostbane, 1), ItemRegistry.ghostbane.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.shadowSaber, 1), ItemRegistry.shadowSaber.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.arcaniumSaber, 1), ItemRegistry.arcaniumSaber.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.captainsSparkler, 1), ItemRegistry.captainsSparkler.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(ItemRegistry.firefly, 1), ItemRegistry.firefly.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.dungeonTokens, 15), new ItemStack(ItemRegistry.meriksMissile, 1), ItemRegistry.meriksMissile.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.dungeonTokens, 30), new ItemStack(ItemRegistry.liviciaSword, 1), ItemRegistry.liviciaSword.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(ItemRegistry.laVekor, 1), ItemRegistry.laVekor.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(ItemRegistry.grenade, 10), ItemRegistry.grenade.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaHelmet, 1), ItemRegistry.kormaHelmet.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaChestplate, 1), ItemRegistry.kormaChestplate.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaLeggings, 1), ItemRegistry.kormaLeggings.getMaxDamage(), 1, 1));
		offers.add(new MerchantOffer(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ItemRegistry.kormaBoots, 1), ItemRegistry.kormaBoots.getMaxDamage(), 1, 1));
		return offers;
	}
}
