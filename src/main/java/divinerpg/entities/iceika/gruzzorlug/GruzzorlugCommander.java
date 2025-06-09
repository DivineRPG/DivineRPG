package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.registries.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class GruzzorlugCommander extends Gruzzorlug implements RangedAttackMob {
	public GruzzorlugCommander(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		if(!worldIn.isClientSide()) setData(AttachmentRegistry.IMPORTANT.attachment, true);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, ItemRegistry.fractite_cannon.toStack());
	}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new AggressiveRangedAttackGoal(25));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = EntityRegistry.FRACTITE_CANNON_SHOT.get().create(level());
			projectile.setOwner(this);
			projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(SoundRegistry.FRACTITE_CANNON.get());
        }
	}
	@Override
	protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GRUZZORLUG_COMMANDER.get(level(), getRandom()), 3);
	}
}