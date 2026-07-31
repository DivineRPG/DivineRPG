package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.bullet.EntitySaguaroWormShot;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.neoforged.neoforge.common.Tags.Blocks;
import net.neoforged.neoforge.fluids.FluidType;

import static divinerpg.registries.TagRegistry.AVOIDS_THORNS;
import static net.minecraft.world.damagesource.DamageTypes.THORNS;

public class EntitySaguaroWorm extends EntityDivineMonster implements RangedAttackMob {
    public EntitySaguaroWorm(EntityType<? extends EntitySaguaroWorm> type, Level worldIn) {super(type, worldIn);}
    @Override public void onAddedToLevel() {
        super.onAddedToLevel();
        setRot(0, 0);
        absSnapRotationTo(0, 0);
        setYBodyRot(0);
        setYHeadRot(0);
    }
    //TODO: to switch to melee damage when the player is really close
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 30, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    public static boolean saguaroWormSpawnRule(LevelAccessor worldIn, BlockPos pos) {return worldIn.getBlockState(pos.below()).is(Blocks.SANDS);}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override public void tick() {
        super.tick();
        if(!level().isClientSide()) {
            //TODO: unlike pumpkin spiders they shouldn't really keep looking at the player; they're still looking at the player, but the model change says that it's no longer provoked
            Player player = level().getNearestPlayer(this, 6);
            if(player != null && hasLineOfSight(player)) setProvoked(player);
            else setProvoked(getTarget());
        }
    }
    @Override public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if(level().isClientSide()) return false;
        Entity entity = source.getDirectEntity();
        if(!(entity instanceof LivingEntity)) entity = source.getEntity();
        if(entity instanceof LivingEntity l && !l.level().isClientSide()) setProvoked(l);
        if(!source.is(AVOIDS_THORNS) && !source.is(THORNS)) {
            Entity directEntity = source.getDirectEntity();
            if(directEntity instanceof LivingEntity livingEntity) livingEntity.hurt(damageSources().thorns(this), 2);
        } return super.hurtServer(level, source, amount);
    }
    @Override public boolean isPushedByFluid(FluidType type) {return false;}
    @Override public boolean isPushable() {return false;}
    public boolean getProvoked() {return AttachmentRegistry.ANGRY.get(this);}
    public void setProvoked(LivingEntity entity) {
        if(entity == null || !hasLineOfSight(entity) && entity.distanceTo(this) > (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue() || !entity.isAlive()) {
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
        setRot(0, 0);
        absSnapRotationTo(0, 0);
        setYBodyRot(0);
        setYHeadRot(0);
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null && !level().isClientSide() && target.distanceTo(this) <= (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()) {
            for(int i = 0; i < 20; i++) {
                EntitySaguaroWormShot shot = EntityRegistry.SAGUARO_WORM_SHOT.get().create(level(), EntitySpawnReason.EVENT);
                shot.setOwner(this);
                shot.setPos(getEyePosition());
                double d0 = getTarget().getX() - getX();
                double d1 = getTarget().getY(.3333333333333333) - shot.getY();
                double d2 = getTarget().getZ() - getZ();
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                shot.shoot(d0, d1 + d3 * .2, d2, .9F, 10);
                level().addFreshEntity(shot);
            }
        }
    }
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.SAGUARO_WORM.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.SAGUARO_WORM.get();}
}