package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.AABB;

import static divinerpg.registries.RecipeRegistry.Trades.JACK_O_MAN;
import static divinerpg.registries.SoundRegistry.JACKOMAN;

public class EntityJackOMan extends EntityDivineMerchant {
    public EntityJackOMan(EntityType<? extends EntityJackOMan> type, Level worldIn) {super(type, worldIn, "jack_o_man");}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.jackoman.boo",
            "message.jackoman.lost",
            "message.jackoman.hurah",
            "message.jackoman.seen"
        };
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), JACK_O_MAN.get(level(), getRandom()), 5);}
    @Override protected SoundEvent getAmbientSound() {return JACKOMAN.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return JACKOMAN.get();}
    @Override protected SoundEvent getDeathSound() {return JACKOMAN.get();}
    public static boolean rules(ServerLevelAccessor level, BlockPos pos) {
        return level.getEntitiesOfClass(EntityJackOMan.class, new AABB(pos).inflate(64)).isEmpty();
    }
}