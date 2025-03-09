package divinerpg.entities.iceika;

import divinerpg.entities.goals.FactionTargetGoal;
import divinerpg.entities.base.*;
import divinerpg.registries.AttachmentRegistry;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;

import javax.annotation.Nullable;

public abstract class EntityIceikaNPC extends EntityDivineMerchant implements FactionEntity {
	public EntityIceikaNPC(EntityType<? extends EntityDivineMerchant> type, Level worldIn, String profession) {
        super(type, worldIn, profession);
        setPathfindingMalus(PathType.POWDER_SNOW, -1);
    }
	protected abstract Holder<MobEffect> getTargetEffect();
	@Override protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
        if(!(this instanceof RangedAttackMob)) goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, false));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new FactionTargetGoal<>(this, getFaction(), true, !(this instanceof RangedAttackMob)));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}
	@Override protected PathNavigation createNavigation(Level level) {
		GroundPathNavigation nav = new GroundPathNavigation(this, level);
		nav.setCanOpenDoors(true);
		nav.setCanPassDoors(true);
		return nav;
	}
	@Nullable
	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
		RandomSource random = level.getRandom();
		populateDefaultEquipmentSlots(random, difficulty);
		populateDefaultEquipmentEnchantments(level, random, difficulty);
		return data;
	}
	@Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if(getFaction().likes(player)) return super.mobInteract(player, hand);
    	playSound(SoundEvents.VILLAGER_NO);
    	return InteractionResult.FAIL;
    }
	@Override public void die(DamageSource source) {
		if(level() instanceof ServerLevel) modifyReputationOnDeath(source);
		super.die(source);
	}
	@Override public void modifyReputationOnDeath(DamageSource source) {
		if(isImportant()) {
			if(source.getDirectEntity() != null && source.getDirectEntity() instanceof LivingEntity entity)
				entity.addEffect(new MobEffectInstance(getTargetEffect(), -1, 0, false, false, true));
			if(source.getEntity() != null && source.getEntity() instanceof LivingEntity entity)
				entity.addEffect(new MobEffectInstance(getTargetEffect(), -1, 0, false, false, true));
		} FactionEntity.super.modifyReputationOnDeath(source);
	}
	public boolean isImportant() {
		return AttachmentRegistry.IMPORTANT.get(this);
	}
	@Override public boolean hurt(DamageSource source, float f) {
		if(level() instanceof ServerLevel) modifyReputationOnHurt(source, f);
		return super.hurt(source, f);
	}
	@Override protected boolean shouldDespawnInPeaceful() {return false;}
	@Override
	public String[] getChatMessages() {
		return new String[0];
	}
	@Override
	protected void rewardTradeXp(MerchantOffer offer) {
		super.rewardTradeXp(offer);
		Player player = getTradingPlayer();
		if(player != null && offer.shouldRewardExp()) getFaction().reputation.modify(player, 1);
	}
}