package divinerpg.entities.goals.miner;

import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.EnumSet;

public class StoreInChestGoal extends Goal {
    private final EntityMiner miner;
    private BlockPos chestLocation;

    public StoreInChestGoal(EntityMiner miner) {
        this.miner = miner;
        this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return !miner.getInventory().isEmpty();
    }

    @Override
    public void start() {
        if (chestLocation != null) {
            miner.getNavigation().moveTo(chestLocation.getX() + 0.5, chestLocation.getY() + 0.5, chestLocation.getZ() + 0.5, 1.0);
        }
    }

    @Override
    public boolean canContinueToUse() {
        boolean canContinue = !miner.getInventory().isEmpty() && chestLocation != null &&
                miner.distanceToSqr(chestLocation.getX() + 0.5, chestLocation.getY() + 0.5, chestLocation.getZ() + 0.5) > 5.0D;
        return canContinue;
    }

    @Override
    public void tick() {
        if (chestLocation == null) {
            chestLocation = findNearbyChest();
        }
        if (chestLocation != null && miner.distanceToSqr(chestLocation.getX() + 0.5, chestLocation.getY() + 0.5, chestLocation.getZ() + 0.5) <= 5.0D) {
            storeItemsInChest();
        }
    }

    private BlockPos findNearbyChest() {
        BlockPos origin = miner.blockPosition();
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();

        for (int x = -5; x <= 5; x++) {
            for (int y = -3; y <= 3; y++) {
                for (int z = -5; z <= 5; z++) {
                    checkPos.set(origin.getX() + x, origin.getY() + y, origin.getZ() + z);
                    if (miner.level().getBlockState(checkPos).is(BlockTags.create(Identifier.fromNamespaceAndPath("c", "chests")))) {
                        return checkPos.immutable();
                    }
                }
            }
        }
        return null;
    }

    private void storeItemsInChest() {
        BlockEntity blockEntity = miner.level().getBlockEntity(chestLocation);
        if (blockEntity instanceof ChestBlockEntity chestBlockEntity) {

            Container chestInventory = chestBlockEntity;
            for (int i = 0; i < miner.getInventory().getContainerSize(); i++) {
                ItemStack minerStack = miner.getInventory().getItem(i);
                if (!minerStack.isEmpty()) {
                    for (int j = 0; j < chestInventory.getContainerSize(); j++) {
                        ItemStack chestStack = chestInventory.getItem(j);
                        if (chestStack.isEmpty()) {
                            chestInventory.setItem(j, minerStack.copy());
                            miner.getInventory().setItem(i, ItemStack.EMPTY);
                            break;
                        } else if (ItemStack.isSameItemSameComponents(minerStack, chestStack) &&
                                chestStack.getCount() < chestStack.getMaxStackSize()) {
                            int transferAmount = Math.min(minerStack.getCount(), chestStack.getMaxStackSize() - chestStack.getCount());
                            chestStack.grow(transferAmount);
                            minerStack.shrink(transferAmount);
                            if (minerStack.isEmpty()) {
                                miner.getInventory().setItem(i, ItemStack.EMPTY);
                                break;
                            }
                        }
                    }
                }
            }
            chestBlockEntity.setChanged();
        }
    }

}