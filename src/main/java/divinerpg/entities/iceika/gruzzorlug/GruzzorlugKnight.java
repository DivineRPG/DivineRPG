package divinerpg.entities.iceika.gruzzorlug;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.frozen_maul;
import static divinerpg.registries.RecipeRegistry.Trades.GRUZZORLUG_KNIGHT;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GruzzorlugKnight extends Gruzzorlug {
    public GruzzorlugKnight(EntityType<? extends GruzzorlugKnight> type, Level worldIn) {super(type, worldIn);}
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(frozen_maul.get()));}
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), GRUZZORLUG_KNIGHT.get(level(), getRandom()), 3);}
}