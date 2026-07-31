package divinerpg.entities.iceika.gruzzorlug;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import static divinerpg.registries.AttachmentRegistry.IMPORTANT;
import static divinerpg.registries.EntityRegistry.FRACTITE_CANNON_SHOT;
import static divinerpg.registries.ItemRegistry.fractite_cannon;
import static divinerpg.registries.RecipeRegistry.Trades.GRUZZORLUG_COMMANDER;
import static divinerpg.registries.SoundRegistry.FRACTITE_CANNON;
import static net.minecraft.world.InteractionHand.MAIN_HAND;

public class GruzzorlugCommander extends Gruzzorlug implements RangedAttackMob {
    public GruzzorlugCommander(EntityType<? extends GruzzorlugCommander> type, Level worldIn) {
        super(type, worldIn);
        if(!worldIn.isClientSide()) setData(IMPORTANT.attachment, true);
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, fractite_cannon.toStack());}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new AggressiveRangedAttackGoal(25));
    }
    @Override public void performRangedAttack(LivingEntity target, float f) {
        if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = FRACTITE_CANNON_SHOT.get().create(level(), EntitySpawnReason.EVENT);
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(FRACTITE_CANNON.get());
        }
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), GRUZZORLUG_COMMANDER.get(level(), getRandom()), 3);}
}