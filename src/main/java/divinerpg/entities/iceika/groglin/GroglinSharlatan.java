package divinerpg.entities.iceika.groglin;

import divinerpg.registries.MobEffectRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GroglinSharlatan extends Groglin implements RangedAttackMob {
	public GroglinSharlatan(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 10);
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 10, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
	}
	@Override
	public void performRangedAttack(LivingEntity e, float f) {
		LivingEntity target = getTarget();
		if(isAlive() && target != null) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 1, false, true, true));
            target.setTicksFrozen(target.getTicksFrozen() + 10);
            if(getRandom().nextBoolean()) target.hurt(DamageSources.source(level(), DamageTypes.MAGIC), 1F);
        }
	}
	@Override
	protected TagKey<Item> getAcceptedItems() {
		return Groglin.HUNTER_ACCEPTED;
	}
	@Override
	protected String getTradesLocation() {
		return "trades/groglin_sharlatan";
	}
	@Override
	public void modifyReputationOnDeath(DamageSource source) {
		if(source.getDirectEntity() != null && source.getDirectEntity() instanceof LivingEntity entity) entity.addEffect(new MobEffectInstance(MobEffectRegistry.GROGLIN_BOUNTY.get(), -1, 0, false, false, true));
		if(source.getEntity() != null && source.getEntity() instanceof LivingEntity entity) entity.addEffect(new MobEffectInstance(MobEffectRegistry.GROGLIN_BOUNTY.get(), -1, 0, false, false, true));
		super.modifyReputationOnDeath(source);
	}
}