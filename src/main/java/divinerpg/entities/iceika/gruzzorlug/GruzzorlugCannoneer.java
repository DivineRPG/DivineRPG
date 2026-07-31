package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.goals.FollowLeaderGoal;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.FROST_CANNON_SHOT;
import static divinerpg.registries.ItemRegistry.frost_cannon;
import static divinerpg.registries.RecipeRegistry.Trades.GRUZZORLUG_CANNONEER;
import static divinerpg.registries.SoundRegistry.FROST_CANNON;
import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE;

public class GruzzorlugCannoneer extends Gruzzorlug implements RangedAttackMob {
    public GruzzorlugCannoneer(EntityType<? extends GruzzorlugCannoneer> type, Level worldIn) {super(type, worldIn);}
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(frost_cannon.get()));}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new AggressiveRangedAttackGoal(20));
        goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugCommander.class, 1, 4, (float)getAttributeValue(FOLLOW_RANGE)));
    }
    @Override public void performRangedAttack(LivingEntity target, float f) {
        if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = FROST_CANNON_SHOT.get().create(level(), EntitySpawnReason.EVENT);
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(FROST_CANNON.get());
        }
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), GRUZZORLUG_CANNONEER.get(level(), getRandom()), 3);}
}