package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GruzzorlugGeneral extends Gruzzorlug {
	public GruzzorlugGeneral(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		if(!worldIn.isClientSide()) setData(AttachmentRegistry.IMPORTANT.attachment, true);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, ItemRegistry.frostking_sword.toStack());
	}
	@Override
	protected void updateTrades() {
        this.addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GRUZZORLUG_GENERAL.get(level(), getRandom()), 3);
	}
}