package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.AABB;

public class EntityJackOMan extends EntityDivineMerchant {
    public EntityJackOMan(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn, "jack_o_man");
    }
    @Override
    public String[] getChatMessages() {
        return new String[] {
                "message.jackoman.boo",
                "message.jackoman.lost",
                "message.jackoman.hurah",
                "message.jackoman.seen"
        };
    }

    @Override protected void updateTrades() {addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.JACK_O_MAN.get(level(), getRandom()), 5);}

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JACKOMAN.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.JACKOMAN.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.JACKOMAN.get();
    }

    public static boolean rules(ServerLevelAccessor level, BlockPos pos) {
        return level.getEntitiesOfClass(EntityJackOMan.class, new AABB(pos).inflate(32)).isEmpty();
    }
}
