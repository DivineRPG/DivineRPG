package divinerpg.entities.iceika.gruzzorlug;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import static divinerpg.registries.AttachmentRegistry.IMPORTANT;
import static divinerpg.registries.ItemRegistry.frostking_sword;
import static divinerpg.registries.RecipeRegistry.Trades.GRUZZORLUG_GENERAL;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GruzzorlugGeneral extends Gruzzorlug {
    public GruzzorlugGeneral(EntityType<? extends GruzzorlugGeneral> type, Level worldIn) {
        super(type, worldIn);
        if(!worldIn.isClientSide()) setData(IMPORTANT.attachment, true);
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, frostking_sword.toStack());}
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), GRUZZORLUG_GENERAL.get(level(), getRandom()), 3);}
}