package divinerpg.entities.vanilla.overworld;

import divinerpg.registries.AttachmentRegistry;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nullable;

public class EntityPumpkinSpider extends Spider {
	public EntityPumpkinSpider(EntityType<? extends Spider> type, Level worldIn) {super(type, worldIn);}
	@Override public void onAddedToLevel() {
		super.onAddedToLevel();
		if(level().isClientSide) AttachmentRegistry.ANGRY.requestAttachment(this, null);
		setRot(0, 0);
		absRotateTo(0, 0);
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
		if(!level().isClientSide) {
			Player player = level().getNearestPlayer(this, 4);
			if(player != null && hasLineOfSight(player)) setProvoked(player);
			else setProvoked(getTarget());
		}
	}
	@Override public boolean hurt(DamageSource source, float amount) {
		Entity entity = source.getDirectEntity();
		if(!(entity instanceof LivingEntity)) entity = source.getEntity();
		if(entity instanceof LivingEntity l && !l.level().isClientSide) setProvoked(l);
		return super.hurt(source, amount);
	}
	@Nullable
	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
		return data;
	}
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
		absRotateTo(0, 0);
		setYBodyRot(0);
		setYHeadRot(0);
	}
	@Override public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
		return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
	}
}