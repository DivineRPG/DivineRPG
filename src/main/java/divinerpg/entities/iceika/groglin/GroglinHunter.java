package divinerpg.entities.iceika.groglin;

import divinerpg.entities.ai.FollowLeaderGoal;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinHunter extends Groglin implements RangedAttackMob {
	public GroglinHunter(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 3);
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 15, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinSharlatan.class, 1D, 4F, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override
	public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level(), ArrowType.PALE_ARCHER_ARROW, this, target, 1.6F, 1.2F);
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333D) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .18D, d2, 1.6F, 1.2F);
            level().addFreshEntity(projectile);
        }
	}
	@Override
	protected TagKey<Item> getAcceptedItems() {
		return Groglin.HUNTER_ACCEPTED;
	}
	@Override
	protected String getTradesLocation() {
		return "trades/groglin_hunter";
	}
}