package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

public class Hook extends Projectile implements Leashable {
    LeashData leashData;
    BlockState lastState;
    boolean inGround;
    public float hookDistance = 0F;
    public Hook(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public @Nullable LeashData getLeashData() {
        return leashData;
    }
    @Override
    public void setLeashData(LeashData leashData) {
        this.leashData = leashData;
    }
    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = getBoundingBox().getSize() * 10D;
        if(Double.isNaN(d0)) d0 = 1D;
        d0 *= 64D * getViewScale();
        return distance < d0 * d0;
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
    @Override
    public void tick() {
        super.tick();
        Vec3 dv;
        Entity owner = getOwner();
        if(owner == null || !owner.isAlive()) {
            discard();
            return;
        } dv = owner.position().subtract(position());
        if(dv.lengthSqr() > 4096D) {
            setDeltaMovement(dv = dv.normalize());
            hasImpulse = true;
        } else dv = getDeltaMovement();
        if(xRotO == 0F && yRotO == 0F) {
            double h = dv.horizontalDistance();
            setYRot((float)(Mth.atan2(dv.x, dv.z) * 180D / Math.PI));
            setXRot((float)(Mth.atan2(dv.y, h) * 180D / Math.PI));
            yRotO = getYRot();
            xRotO = getXRot();
        }
        BlockPos blockpos = blockPosition();
        BlockState blockstate = level().getBlockState(blockpos);
        if(!blockstate.isAir()) {
            VoxelShape voxelshape = blockstate.getCollisionShape(level(), blockpos);
            if(!voxelshape.isEmpty()) for(AABB aabb : voxelshape.toAabbs()) if(aabb.move(blockpos).contains(position())) {
                hook(true);
                break;
            }
        }
        if(isInWaterOrRain() || blockstate.is(Blocks.POWDER_SNOW) || isInFluidType((fluidType, height) -> canFluidExtinguish(fluidType))) clearFire();
        if(inGround) {
            if(lastState != blockstate && shouldFall()) startFalling();
        } else {
            Vec3 pos = position(), newpos = pos.add(dv);
            HitResult hitresult = level().clip(new ClipContext(pos, newpos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if(hitresult.getType() != HitResult.Type.MISS) newpos = hitresult.getLocation();
            if(!isRemoved() && hitresult != null && hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact(this, hitresult)) {
                hitTargetOrDeflectSelf(hitresult);
                hasImpulse = true;
            }
            dv = getDeltaMovement();
            double dx = dv.x, dy = dv.y, dz = dv.z, newx = getX() + dx, newy = getY() + dy, newz = getZ() + dz, h = dv.horizontalDistance();
            setYRot((float)(Mth.atan2(dx, dz) * 180D / Math.PI));
            setXRot((float)(Mth.atan2(newy, h) * 180D / Math.PI));
            setXRot(lerpRotation(xRotO, getXRot()));
            setYRot(lerpRotation(yRotO, getYRot()));
            float f = .99F;
            if(isInWater()) {
                for(int j = 0; j < 4; ++j) level().addParticle(ParticleTypes.BUBBLE, newx - dx * .25, newy - dy * .25, newz - dz * .25, dx, dy, dz);
                f = .6F;
            }
            setDeltaMovement(dv.scale(f));
            applyGravity();
            setPos(newx, newy, newz);
            checkInsideBlocks();
        }
        if(owner instanceof Player p) {
            boolean shift = p.isShiftKeyDown();
            if(shift && hookDistance > 0F && !p.onGround()) {
                hookDistance += .2F;
                if(hookDistance > 64F) hookDistance = 64F;
            } if(p.isUsingItem() && p.getUseItem().is(ItemRegistry.jungle_hook)) {
                if(shift) discard();
                else if(hookDistance > 0F) {
                    hookDistance -= 1F;
                    if(hookDistance < .2F) hookDistance = .2F;
                }
            }
        }
        if((tickCount & 1) == 0) Leashable.tickLeash(this);
    }
    public void hook(boolean inGround) {
        if(inGround == this.inGround) return;
        if(inGround) {
            Entity owner = getOwner();
            if(owner == null) discard();
            else {
                this.inGround = true;
                hookDistance = distanceTo(owner) + 1F;
            }
        } else {
            this.inGround = false;
            hookDistance = 0F;
        }
    }
    @Override
    public boolean handleLeashAtDistance(Entity leashHolder, float distance) {
        if(hookDistance > 0F && distance > hookDistance) {
            Vec3 diff = position().subtract(leashHolder.position());
            diff = diff.scale((distance - hookDistance) * 0.06 / hookDistance).add(diff.scale(-0.1 * diff.dot(leashHolder.getDeltaMovement()) / distance)).multiply(0.2, 1, 0.2);
            if(diff.length() > 0.01) {
                leashHolder.addDeltaMovement(diff);
                if(leashHolder.getDeltaMovement().y > -0.1) leashHolder.resetFallDistance();
                leashHolder.hasImpulse = true;
            }
        } return false;
    }
    @Override
    protected double getDefaultGravity() {
        return .0525;
    }
    private boolean shouldFall() {
        return inGround && level().noCollision(this, new AABB(position().subtract(.1, .1, .1), position().add(.1, .1, .1)));
    }
    private void startFalling() {
        hook(false);
        Vec3 vec3 = getDeltaMovement();
        setDeltaMovement(vec3.multiply(random.nextFloat() * .2F, random.nextFloat() * .2F, random.nextFloat() * .2F));
    }
    @Override
    public void move(MoverType type, Vec3 pos) {
        super.move(type, pos);
        if(type != MoverType.SELF && shouldFall()) startFalling();
    }
    @Override
    protected void onHitBlock(BlockHitResult result) {
        lastState = level().getBlockState(result.getBlockPos());
        super.onHitBlock(result);
        Vec3 dv = result.getLocation().subtract(getX(), getY(), getZ());
        setDeltaMovement(dv);
        Vec3 smalldv = dv.normalize().scale(.05);
        setPosRaw(getX() - smalldv.x, getY() - smalldv.y, getZ() - smalldv.z);
        hook(true);
    }
    @Override public boolean shouldBeSaved() {return false;}
    @Override protected Entity.MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }
    @Override public boolean isAttackable() {return false;}
    @Override
    public void setOwner(@Nullable Entity owner) {
        if(getOwner() instanceof ServerPlayer p && owner != p) AttachmentRegistry.HOOKED.set(p, false);
        super.setOwner(owner);
        setLeashedTo(owner, !level().isClientSide);
        if(owner instanceof ServerPlayer) AttachmentRegistry.HOOKED.set(owner, true);
    }
    @Override
    public void onRemovedFromLevel() {
        super.onRemovedFromLevel();
        if(getOwner() instanceof ServerPlayer p) AttachmentRegistry.HOOKED.set(p, false);
    }
}
