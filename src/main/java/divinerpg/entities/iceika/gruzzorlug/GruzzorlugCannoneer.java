package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.ai.FollowLeaderGoal;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GruzzorlugCannoneer extends Gruzzorlug implements RangedAttackMob {
	public GruzzorlugCannoneer(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 7);
	}
	@Override
	protected TagKey<Item> getAcceptedItems() {
		return Gruzzorlug.KNIGHT_ACCEPTED;
	}
	@Override
	protected String getTradesLocation() {
		return "trades/gruzzorlug_cannoneer";
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 20, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugCommander.class, 1D, 4F, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override
	public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            EntityShooterBullet projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.FROST_CANNON_SHOT);
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333D) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(SoundRegistry.FROST_CANNON.get());
        }
	}
}