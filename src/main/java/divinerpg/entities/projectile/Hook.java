package divinerpg.entities.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.AttachmentRegistry.HOOKED;
import static divinerpg.registries.ItemRegistry.jungle_hook;
import static net.minecraft.world.level.block.Blocks.POWDER_SNOW;

public class Hook extends Projectile implements Leashable {
    private LeashData leashData;
    private BlockState lastState;
    private boolean inGround;
    public float hookDistance = 0.0F;
    public boolean infinite;

    public Hook(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable LeashData getLeashData() {
        return this.leashData;
    }

    @Override
    public void setLeashData(@Nullable LeashData leashData) {
        this.leashData = leashData;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = getBoundingBox().getSize() * 10.0D;
        if (Double.isNaN(d0)) {
            d0 = 1.0D;
        }
        d0 *= 64.0D * getViewScale();
        return distance < d0 * d0;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}

    @Override
    public void tick() {
        super.tick();
        Vec3 dv;
        Entity owner = getOwner();

        if (owner == null || !owner.isAlive() || !isAlive()) {
            unhook();
            return;
        }

        dv = owner.position().subtract(position());
        if (dv.lengthSqr() > 4096.0D) {
            dv = dv.normalize();
            setDeltaMovement(dv);
//            hasImpulse = true;
        } else {
            dv = getDeltaMovement();
        }

        if (xRotO == 0.0F && yRotO == 0.0F) {
            double h = dv.horizontalDistance();
            setYRot((float) (Mth.atan2(dv.x, dv.z) * Mth.RAD_TO_DEG));
            setXRot((float) (Mth.atan2(dv.y, h) * Mth.RAD_TO_DEG));
            yRotO = getYRot();
            xRotO = getXRot();
        }

        BlockPos blockpos = blockPosition();
        BlockState blockstate = level().getBlockState(blockpos);

        if (!blockstate.isAir()) {
            VoxelShape voxelshape = blockstate.getCollisionShape(level(), blockpos);
            if (!voxelshape.isEmpty()) {
                for (AABB aabb : voxelshape.toAabbs()) {
                    if (aabb.move(blockpos).contains(position())) {
                        hook(true);
                        break;
                    }
                }
            }
        }

        if (isInWaterOrRain() || blockstate.is(POWDER_SNOW) /* || isInFluidType((fluidType, height) -> canFluidExtinguish(fluidType))*/) {
            clearFire();
        }

        if (inGround) {
            if (lastState != blockstate && shouldFall()) {
                startFalling();
            }
        } else {
            Vec3 pos = position();
            Vec3 newpos = pos.add(dv);
            HitResult hitresult = level().clip(new ClipContext(pos, newpos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));

            if (hitresult.getType() != HitResult.Type.MISS) {
                newpos = hitresult.getLocation();
            }

            if (!isRemoved() && hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact(this, hitresult)) {
                hitTargetOrDeflectSelf(hitresult);
//                hasImpulse = true;
            }

            dv = getDeltaMovement();
            double dx = dv.x, dy = dv.y, dz = dv.z;
            double newx = getX() + dx, newy = getY() + dy, newz = getZ() + dz;
            double h = dv.horizontalDistance();

            setYRot((float) (Mth.atan2(dx, dz) * Mth.RAD_TO_DEG));
            setXRot((float) (Mth.atan2(newy, h) * Mth.RAD_TO_DEG));
            setXRot(lerpRotation(xRotO, getXRot()));
            setYRot(lerpRotation(yRotO, getYRot()));

            float f = 0.99F;
            if (isInWater()) {
                for (int j = 0; j < 4; ++j) {
                    level().addParticle(ParticleTypes.BUBBLE, newx - dx * 0.25D, newy - dy * 0.25D, newz - dz * 0.25D, dx, dy, dz);
                }
                f = 0.6F;
            }

            setDeltaMovement(dv.scale(f));
            applyGravity();
            setPos(newx, newy, newz);
            onInsideBlock(lastState);
        }

        if (owner instanceof Player p) {
            boolean shift = p.isShiftKeyDown();
            if (shift && hookDistance > 0 && !p.onGround()) {
                hookDistance += 0.2F;
                if (hookDistance > 64.0F) {
                    hookDistance = 64.0F;
                }
            }

            if (p.isUsingItem() && p.getUseItem().is(jungle_hook.get())) {
                if (shift) {
                    unhook();
                } else if (hookDistance > 0) {
                    hookDistance -= 1.0F;
                    if (hookDistance < 0.2F) {
                        hookDistance = 0.2F;
                    }
                }
            }
        }

        if ((tickCount & 1) == 0) {
            Leashable.tickLeash(level().getServer().getLevel(level().dimension()), this);
        }
    }

    public void hook(boolean inGround) {
        if (inGround == this.inGround) return;
        if (inGround) {
            Entity owner = getOwner();
            if (owner == null) {
                unhook();
            } else {
                this.inGround = true;
                hookDistance = distanceTo(owner) + 1.0F;
            }
        } else {
            this.inGround = false;
            hookDistance = 0.0F;
        }
    }

    //TODO - Leash distance
//    @Override
//    public boolean handleLeashAtDistance(Entity leashHolder, float distance) {
//        if (hookDistance > 0 && distance > hookDistance) {
//            Vec3 diff = position().subtract(leashHolder.position());
//            diff = diff.scale((distance - hookDistance) * 0.06D / hookDistance)
//                    .add(diff.scale(-0.1D * diff.dot(leashHolder.getDeltaMovement()) / distance))
//                    .multiply(0.2D, 1.0D, 0.2D);
//
//            if (diff.length() > 0.01D) {
//                leashHolder.addDeltaMovement(diff);
//                if (leashHolder.getDeltaMovement().y > -0.1D) {
//                    leashHolder.resetFallDistance();
//                }
////                leashHolder.hasImpulse = true;
//            }
//        }
//        return false;
//    }

    @Override
    protected double getDefaultGravity() {
        return 0.0525D;
    }

    private boolean shouldFall() {
        return inGround && level().noCollision(this, new AABB(position().subtract(0.1D, 0.1D, 0.1D), position().add(0.1D, 0.1D, 0.1D)));
    }

    private void startFalling() {
        hook(false);
        Vec3 vec3 = getDeltaMovement();
        setDeltaMovement(vec3.multiply(random.nextFloat() * 0.2F, random.nextFloat() * 0.2F, random.nextFloat() * 0.2F));
    }

    @Override
    public void move(MoverType type, Vec3 pos) {
        super.move(type, pos);
        if (type != MoverType.SELF && shouldFall()) {
            startFalling();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        lastState = level().getBlockState(result.getBlockPos());
        super.onHitBlock(result);
        Vec3 dv = result.getLocation().subtract(getX(), getY(), getZ());
        setDeltaMovement(dv);
        Vec3 smalldv = dv.normalize().scale(0.05D);
        setPosRaw(getX() - smalldv.x, getY() - smalldv.y, getZ() - smalldv.z);
        hook(true);
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public void setOwner(@Nullable Entity owner) {
        if (getOwner() instanceof ServerPlayer p && owner != p) {
            p.setData(HOOKED.attachment.get(), false);
        }
        super.setOwner(owner);
        setLeashedTo(owner, !level().isClientSide());
        if (owner instanceof ServerPlayer playerOwner) {
            playerOwner.setData(HOOKED.attachment.get(), true);
        }
    }

    @Override
    public void onRemovedFromLevel() {
        super.onRemovedFromLevel();
        if (getOwner() instanceof ServerPlayer p) {
            p.setData(HOOKED.attachment.get(), false);
        }
    }

//    @Override
//    public void dropLeash(boolean broadcastPacket, boolean dropItem) {
//        Leashable.super.dropLeash(broadcastPacket, dropItem && !infinite);
//    }

    public void unhook() {
//        dropLeash(true, true);
        discard();
    }
}