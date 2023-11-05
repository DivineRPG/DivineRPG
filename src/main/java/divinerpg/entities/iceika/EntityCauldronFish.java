package divinerpg.entities.iceika;

import java.util.List;

import divinerpg.registries.ItemRegistry;
import net.minecraft.core.particles.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;

public class EntityCauldronFish extends Squid implements Bucketable {
	boolean fromBucket;
	public EntityCauldronFish(EntityType<EntityCauldronFish> type, Level level) {super(type, level);setPathfindingMalus(BlockPathTypes.RAIL, 1F);}
	@Override protected float getStandingEyeHeight(Pose pose, EntityDimensions dim) {return .25F;}
	@Override protected SoundEvent getAmbientSound() {return SoundEvents.TROPICAL_FISH_AMBIENT;}
	@Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.TROPICAL_FISH_HURT;}
	@Override protected SoundEvent getSquirtSound() {return SoundEvents.TROPICAL_FISH_HURT;}
	@Override protected ParticleOptions getInkParticle() {return ParticleTypes.SPLASH;}
	@Override protected SoundEvent getSwimSound() {return SoundEvents.FISH_SWIM;}
	@Override public boolean fromBucket() {return fromBucket;}
	@Override public void setFromBucket(boolean b) {fromBucket = b;}
	@Override public ItemStack getBucketItemStack() {return new ItemStack(ItemRegistry.cauldron_fish_bucket.get());}
	@Override public SoundEvent getPickupSound() {return SoundEvents.BUCKET_FILL_FISH;}
	@SuppressWarnings("deprecation") @Override public void saveToBucketTag(ItemStack stack) {Bucketable.saveDefaultDataToBucketTag(this, stack);}
	@SuppressWarnings("deprecation") @Override public void loadFromBucketTag(CompoundTag tag) {Bucketable.loadDefaultDataFromBucketTag(this, tag);}
	@Override protected InteractionResult mobInteract(Player player, InteractionHand hand) {return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));}
	@Override public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if(tag.contains("FromBucket")) fromBucket = tag.getBoolean("FromBucket");
	}
	@Override public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("FromBucket", fromBucket);
	}
	@Override public void tick() {
    	if(level().getRandom().nextInt(10) == 0) {
            List<Entity> e = level().getEntities(this, new AABB(blockPosition().offset(-25, -16, -25), blockPosition().offset(25, 16, 25)));
            for(Entity entity : e) if(entity instanceof LivingEntity ent) {
    	        if(entity instanceof EntityCauldronFish || (entity instanceof Player && (((Player)entity).isCreative() || ((Player)entity).isSpectator()))) continue;
    	        if(entity.position().distanceToSqr(position()) < 1.5) ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 18, true, false));
    	    }
    	} super.tick();
    }
}