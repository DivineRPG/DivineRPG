package divinerpg.entities.iceika.groglin;

import divinerpg.entities.ai.AvoidFactionGoal;
import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.PotionRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GroglinMerchant extends Groglin {
	public GroglinMerchant(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 12);
	}
	@Override protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(4, new AvoidFactionGoal(this, getFaction(), (float)getAttributeValue(Attributes.FOLLOW_RANGE), 1.1, 1.1));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 20), new ItemStack(BlockRegistry.iceLamp.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 3), new ItemStack(ItemRegistry.winterberry.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 5), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.TEA.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 64), new ItemStack(ItemRegistry.olivine.get(), 64), new ItemStack(ItemRegistry.glacial_wall_totem.get()), random.nextInt(7), 25),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 15), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get()), new ItemStack(ItemRegistry.armor_pouch.get()), random.nextInt(7), 5)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}