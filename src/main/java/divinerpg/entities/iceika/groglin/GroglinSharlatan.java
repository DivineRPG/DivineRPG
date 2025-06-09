package divinerpg.entities.iceika.groglin;

import divinerpg.registries.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class GroglinSharlatan extends Groglin implements RangedAttackMob {
	public GroglinSharlatan(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		if(!worldIn.isClientSide()) setData(AttachmentRegistry.IMPORTANT.attachment, true);
	}
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ItemRegistry.serenade_of_ice.get()));
	}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 10, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
	}
	@Override public void performRangedAttack(LivingEntity e, float f) {
		LivingEntity target = getTarget();
		if(isAlive() && target != null) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 1, false, true, true));
            target.setTicksFrozen(target.getTicksFrozen() + 10);
            if(getRandom().nextBoolean()) target.hurt(damageSources().indirectMagic(this, this), 1);
        }
	}
	@Override protected void updateTrades() {
        addOffersFromItemListings(getOffers(), RecipeRegistry.Trades.GROGLIN_SHARLATAN.get(level(), getRandom()), 3);
	}
}