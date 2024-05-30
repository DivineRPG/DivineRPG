package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GruzzorlugCommander extends Gruzzorlug implements RangedAttackMob {
	public GruzzorlugCommander(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 8);
		important = true;
	}
	@Override protected TagKey<Item> getAcceptedItems() {return Gruzzorlug.KNIGHT_ACCEPTED;}
	@Override protected String getTradesLocation() {return "trades/gruzzorlug_cannoneer";}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 25, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.FRACTITE_CANNON_SHOT);
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(SoundRegistry.FRACTITE_CANNON.get());
        }
	}
}