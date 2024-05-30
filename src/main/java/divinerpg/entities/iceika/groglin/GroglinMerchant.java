package divinerpg.entities.iceika.groglin;

import divinerpg.entities.ai.AvoidFactionGoal;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinMerchant extends Groglin {
	public GroglinMerchant(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 12);
	}
	@Override protected TagKey<Item> getAcceptedItems() {return Groglin.MERCHANT_ACCEPTED;}
	@Override protected String getTradesLocation() {return "trades/groglin_merchant";}
	@Override protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(4, new AvoidFactionGoal(this, getFaction(), (float)getAttributeValue(Attributes.FOLLOW_RANGE), 1.1, 1.1));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}
}