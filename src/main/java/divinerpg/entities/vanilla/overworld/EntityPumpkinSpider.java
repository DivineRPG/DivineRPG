package divinerpg.entities.vanilla.overworld;

import divinerpg.registries.AttachmentRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.neoforged.neoforge.fluids.FluidType;

import javax.annotation.Nullable;

public class EntityPumpkinSpider extends Spider {
	public EntityPumpkinSpider(EntityType<? extends Spider> type, Level worldIn) {super(type, worldIn);}
	@Override public void onAddedToLevel() {
		super.onAddedToLevel();
		setRot(0, 0);
		absSnapRotationTo(0, 0);
		setYBodyRot(0);
		setYHeadRot(0);
	}
	@Override protected void registerGoals() {
		goalSelector.addGoal(1, new FloatGoal(this));
		goalSelector.addGoal(3, new LeapAtTargetGoal(this, .4F));
		goalSelector.addGoal(4, new MeleeAttackGoal(this, 1, getProvoked()));
	}
	@Override public void tick() {
		super.tick();
		if(!level().isClientSide()) {
			Player player = level().getNearestPlayer(this, 4);
			if(player != null && hasLineOfSight(player)) setProvoked(player);
			else setProvoked(getTarget());
		}
	}
	@Override public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
		Entity entity = source.getDirectEntity();
		if(!(entity instanceof LivingEntity)) entity = source.getEntity();
		if(entity instanceof LivingEntity living && !living.level().isClientSide()) setProvoked(living);
		return super.hurtServer(level, source, amount);
	}
	@Override public void playAmbientSound() {if(getProvoked()) super.playAmbientSound();}
	@Nullable
	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason type, @Nullable SpawnGroupData data) {
		return data;
	}
	//TODO: to make it angry when something pushes it
//	@Override public void push(Entity entity) {
//		super.push(entity);
//		if(entity instanceof LivingEntity living && !(entity instanceof EntityPumpkinSpider)) setProvoked(living);
//	}
	@Override public boolean onClimbable() {return getProvoked() && super.onClimbable();}
	@Override public boolean isPushedByFluid(FluidType type) {return getProvoked() && super.isPushedByFluid(type);}
	public boolean getProvoked() {return AttachmentRegistry.ANGRY.get(this);}
	public void setProvoked(LivingEntity entity) {
		if(entity == null || (!hasLineOfSight(entity) && entity.distanceTo(this) > (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()) || !entity.isAlive()) {
			if(getProvoked()) calmDown();
		} else {
			if(entity instanceof Player player && (player.isCreative() || player.isSpectator())) {
				if(getProvoked()) calmDown();
				return;
			} AttachmentRegistry.ANGRY.set(this, true);
			setTarget(entity);
		}
	}
	//TODO: they turn back to 0;0, but sometimes for a moment for some reason they immediately look at the player, thus getting stuck at a wrong angle
	public void calmDown() {
		setTarget(null);
		AttachmentRegistry.ANGRY.set(this, false);
		getNavigation().setSpeedModifier(0);
		setRot(0, 0);
		absSnapRotationTo(0, 0);
		setYBodyRot(0);
		setYHeadRot(0);
	}
}