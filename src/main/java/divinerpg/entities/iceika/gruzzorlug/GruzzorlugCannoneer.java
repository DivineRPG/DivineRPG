package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.goals.FollowLeaderGoal;
import divinerpg.registries.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class GruzzorlugCannoneer extends Gruzzorlug implements RangedAttackMob {
	public GruzzorlugCannoneer(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.frost_cannon.get()));
	}

	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new AggressiveRangedAttackGoal(20));
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugCommander.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = EntityRegistry.FROST_CANNON_SHOT.get().create(level());
			projectile.setOwner(this);
			projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(SoundRegistry.FROST_CANNON.get());
        }
	}
	@Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GRUZZORLUG_CANNONEER.get(level(), getRandom()), 3);
	}
}