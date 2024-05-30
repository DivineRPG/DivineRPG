package divinerpg.entities.iceika.groglin;

import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinSharlatan extends Groglin implements RangedAttackMob {
	public GroglinSharlatan(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 10);
		important = true;
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
	@Override protected TagKey<Item> getAcceptedItems() {return Groglin.HUNTER_ACCEPTED;}
	@Override protected String getTradesLocation() {return "trades/groglin_sharlatan";}
}