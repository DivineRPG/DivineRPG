package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import static divinerpg.registries.EntityRegistry.BONE_FRAGMENT;

public class BoneBomb extends DivineThrowableProjectile {
    public BoneBomb(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
        baseDamage = 16;
    }
    @Override public void onHitEntity(EntityHitResult result) {
        //TODO - Kitra hit entity result
        /*if(!(result.getEntity() instanceof EntityKitra)) super.onHitEntity(result);*/
    }

    @Override public void onHit(HitResult result) {
        super.onHit(result);
        if(result.getType() != HitResult.Type.MISS) {
            for(int i = 0; i < 64; i++) {
                double motionX = (random.nextDouble() - .5) * 2, motionY = (random.nextDouble() - .5) * 2, motionZ = (random.nextDouble() - .5) * 2;
                BoneFragment e = BONE_FRAGMENT.get().create(level(), EntitySpawnReason.TRIGGERED);
                e.setOwner(getOwner());
                e.setPos(result.getLocation());
                e.shoot(motionX, motionY, motionZ, 1, 0);
                level().addFreshEntity(e);
            } discard();
        }
    }
    @Override public void tick() {
        super.tick();
        noPhysics = isInWater();
        double radius = getBbWidth() * 1.5;
        AABB aabb = new AABB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius);
        BlockPos.betweenClosedStream(aabb).forEach(blockPos -> {
            BlockState blockState = level().getBlockState(blockPos);
            if(blockState.is(BlockTags.ICE)) level().destroyBlock(blockPos, true);
        });
    }
}