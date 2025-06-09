package divinerpg.entities.iceika.groglin;

import divinerpg.entities.goals.FollowLeaderGoal;
import divinerpg.entities.projectile.arrows.IcicleArrow;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GroglinHunter extends Groglin implements RangedAttackMob {
	public GroglinHunter(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.icicle_bow.get()));
	}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 20, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinSharlatan.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null && !level().isClientSide) {
			IcicleArrow abstractarrow = new IcicleArrow(level(), this, new ItemStack(ItemRegistry.icicle_arrow.get()), getItemBySlot(EquipmentSlot.MAINHAND));
			double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
			abstractarrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
			playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
			level().addFreshEntity(abstractarrow);
		}
	}
	@Override
	protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GROGLIN_HUNTER.get(level(), getRandom()), 3);
	}
}