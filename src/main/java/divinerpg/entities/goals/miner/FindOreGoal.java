package divinerpg.entities.goals.miner;


import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class FindOreGoal extends Goal {
    private final Monster miner;
    private final double speedModifier;
    private BlockPos targetOrePos;
    private BlockPos chestPos;
    private int miningTime;
    private boolean isStuck;
    private boolean isMiningTunnel;
    private BlockPos tunnelTargetPos;
    private static final double REACH_DISTANCE = 4.9D;

    public FindOreGoal(Monster miner, double speedModifier, BlockPos chestPos) {
        this.miner = miner;
        this.speedModifier = Math.max(speedModifier, 0.5);
        this.chestPos = chestPos;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (this.miner.getTarget() != null || !this.miner.isAlive()) {
            return false;
        }
        targetOrePos = findClosestOre();
        return targetOrePos != null || (chestPos != null && isStuck);
    }

    @Override
    public boolean canContinueToUse() {
        return (targetOrePos != null && this.miner.level().getBlockState(targetOrePos).is(BlockTags.create(Identifier.parse("c:ores"))))
                || isMiningTunnel;
    }

    @Override
    public void start() {
        isStuck = false;
        isMiningTunnel = false;
        moveToTargetOre();
    }

    @Override
    public void stop() {
        this.miner.getNavigation().stop();
        targetOrePos = null;
        miningTime = 0;
        isMiningTunnel = false;
        isStuck = false;
    }

    @Override
    public void tick() {
        if (targetOrePos != null) {
            double distanceToOre = this.miner.position().distanceTo(Vec3.atCenterOf(targetOrePos));
            double horizontalDistance = Math.sqrt(Math.pow(targetOrePos.getX() - miner.position().x, 2) +
                    Math.pow(targetOrePos.getZ() - miner.position().z, 2));
            double verticalDistance = Math.abs(targetOrePos.getY() - miner.position().y);

            if (distanceToOre < REACH_DISTANCE) {
                mineOre(targetOrePos);
            } else if (!this.miner.getNavigation().isInProgress()) {
                isStuck = checkIfStuck();
                if (isStuck) {
                    targetOrePos = null;
                    tunnelTargetPos = chestPos;
                    startTunnelMining();
                } else {
                    moveToTargetOre();
                }
            }
        } else if (isMiningTunnel) {
            mineTunnel();
        }
        if (isStuck) {
            tryToEscape();
        }
    }

    private boolean checkIfStuck() {
        BlockPos minerPos = this.miner.blockPosition();
        int freeSpaceCount = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos checkPos = minerPos.offset(x, y, z);
                    if (this.miner.level().getBlockState(checkPos).isAir()) {
                        freeSpaceCount++;
                    }
                }
            }
        }

        boolean hasFreeSpaceAbove = this.miner.level().getBlockState(minerPos.above()).isAir();

        return freeSpaceCount < 5 && hasFreeSpaceAbove;
    }

    private void moveToTargetOre() {
        if (targetOrePos != null) {
            this.miner.getNavigation().moveTo(targetOrePos.getX(), targetOrePos.getY(), targetOrePos.getZ(), speedModifier);
        }
    }

    private void startTunnelMining() {
        if (tunnelTargetPos != null) {
            isMiningTunnel = true;
        }
    }

    private void mineTunnel() {
        BlockPos minerPos = this.miner.blockPosition();
        Vec3 direction = Vec3.atLowerCornerOf(tunnelTargetPos.subtract(minerPos)).normalize();
        int dx = (int) Math.signum(direction.x);
        int dy = (int) Math.signum(direction.y);
        int dz = (int) Math.signum(direction.z);

        BlockPos nextPos = minerPos.offset(dx, dy, dz);
        if (this.miner.level().getBlockState(nextPos).isAir()) {
            this.miner.getNavigation().moveTo(Vec3.atCenterOf(nextPos).x, Vec3.atCenterOf(nextPos).y, Vec3.atCenterOf(nextPos).z, speedModifier);
        } else {
            mineBlock(nextPos);
        }
    }

    private void mineOre(BlockPos pos) {
        if (this.miner.level().getBlockState(pos).is(BlockTags.create(Identifier.parse("c:ores")))) {
            Block block = this.miner.level().getBlockState(pos).getBlock();
            float hardness = block.defaultDestroyTime();

            // Perform ray trace to ensure line of sight
            boolean hasLineOfSight = hasClearLineOfSight(pos);
            if (!hasLineOfSight) {
                return; // Exit if there's no line of sight
            }

            double verticalOffset = pos.getY() - this.miner.getEyePosition().y;

            if (verticalOffset > REACH_DISTANCE) {
                return;
            }

            if (verticalOffset > 1.0) {
                this.miner.getLookControl().setLookAt(pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5);
            }

            if (miningTime < hardness * 10) {
                miningTime++;
                this.miner.swing(InteractionHand.MAIN_HAND);
                this.miner.level().levelEvent(2001, pos, Block.getId(this.miner.level().getBlockState(pos)));
            } else {
                block.dropResources(this.miner.level().getBlockState(pos), this.miner.level(), pos, null, this.miner, this.miner.getMainHandItem());
                this.miner.level().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                miningTime = 0;
            }
        }
    }

    private void mineBlock(BlockPos pos) {
        double distanceToBlock = this.miner.getEyePosition().distanceTo(Vec3.atCenterOf(pos));

        if (!this.miner.level().getBlockState(pos).isAir()) {
            Block block = this.miner.level().getBlockState(pos).getBlock();
            float hardness = block.defaultDestroyTime();

            double verticalOffset = pos.getY() - this.miner.getEyePosition().y;

            if (verticalOffset > REACH_DISTANCE) {
                return;
            }

            if (miningTime < hardness * 10) {
                miningTime++;
                this.miner.swing(InteractionHand.MAIN_HAND);
                this.miner.level().levelEvent(2001, pos, Block.getId(this.miner.level().getBlockState(pos)));
            } else {
                this.miner.level().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                miningTime = 0;
            }
        }
    }

    private void tryToEscape() {
        BlockPos minerPos = this.miner.blockPosition();

        for (int yOffset = 1; yOffset <= REACH_DISTANCE; yOffset++) {
            BlockPos abovePos = minerPos.above(yOffset);
            boolean isAir = this.miner.level().getBlockState(abovePos).isAir();

            if (isAir) {
                Block blockToPlace = Blocks.COBBLESTONE;
                this.miner.level().setBlock(minerPos, blockToPlace.defaultBlockState(), 3);
                this.miner.jumpFromGround();
                isStuck = false;
                break;
            } else {
                mineBlock(abovePos);
            }
        }
    }

    private BlockPos findClosestOre() {
        double searchRadius = this.miner.getAttribute(Attributes.FOLLOW_RANGE).getValue();
        List<BlockPos> nearbyOres = getNearbyBlocks(this.miner, BlockTags.create(Identifier.parse("c:ores")), searchRadius);
        if (nearbyOres.isEmpty()) {
            return null;
        }

        return nearbyOres.stream()
                .filter(this::isValidTargetOre)
                .min(Comparator.comparingDouble(ore -> this.miner.distanceToSqr(ore.getX(), ore.getY(), ore.getZ())))
                .orElse(null);
    }

    private List<BlockPos> getNearbyBlocks(Entity entity, TagKey<Block> blockTag, double searchRadius) {
        Level level = entity.level();
        BlockPos entityPos = entity.blockPosition();
        List<BlockPos> blocks = new ArrayList<>();

        int minX = (int) Math.floor(entityPos.getX() - searchRadius);
        int maxX = (int) Math.ceil(entityPos.getX() + searchRadius);
        int minY = (int) Math.max(entityPos.getY() - searchRadius, level.getMaxY());
        int maxY = (int) Math.min(entityPos.getY() + searchRadius, level.getMinY());
        int minZ = (int) Math.floor(entityPos.getZ() - searchRadius);
        int maxZ = (int) Math.ceil(entityPos.getZ() + searchRadius);

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if (level.getBlockState(pos).is(blockTag)) {
                        blocks.add(pos);
                    }
                }
            }
        }
        return blocks;
    }

    private boolean isValidTargetOre(BlockPos pos) {
        return this.miner.level().getBlockState(pos).is(BlockTags.create(Identifier.parse("c:ores")));
    }

    private boolean hasClearLineOfSight(BlockPos pos) {
        Vec3 minerEyePos = this.miner.getEyePosition();
        Vec3 blockCenterPos = Vec3.atCenterOf(pos);

        BlockHitResult hitResult = this.miner.level().clip(new ClipContext(minerEyePos, blockCenterPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this.miner));
        return hitResult.getBlockPos().equals(pos);
    }

}