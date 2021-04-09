package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class BlockArcanaDoor extends BlockModDoor {
    private Supplier<Item> keyItem;

    public BlockArcanaDoor(String name, Supplier<Item> key) {
        super(name, Material.STONE, -1, 6000000F, ToolType.PICKAXE);
        this.keyItem = key;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        BlockState iblockstate = pos.equals(pos.below()) ? state : world.getBlockState(pos.below());

        if (iblockstate.getBlock() != this) {
            return ActionResultType.FAIL;
        } else {
            if (!player.isCreative()) {
                if (iblockstate.getValue(OPEN).equals(true)) {
                    return ActionResultType.FAIL;
                }
                Item key = this.keyItem.get();
                ItemStack itemstack = player.getItemInHand(hand);
                if (itemstack == null || itemstack.getItem() != key) {
                    return ActionResultType.FAIL;
                }
                itemstack.shrink(1);
            }
            state = iblockstate.cycle(OPEN);
            world.setBlock(pos.below(), state, 10);
            world.setBlockAndUpdate(pos.below(), state);
            world.levelEvent(player, ((Boolean) state.getValue(OPEN)).booleanValue() ? 1005 : 1011, pos, 0);

            BlockPos[] adjacent = {
                    pos.below().north(),
                    pos.below().east(),
                    pos.below().south(),
                    pos.below().west()
            };

            for (BlockPos adjacentPos : adjacent) {
                BlockState adjacentBlockState = world.getBlockState(adjacentPos);
                if (adjacentBlockState.getBlock() != this) {
                    continue;
                } else if (!player.isCreative() && adjacentBlockState.getValue(OPEN).equals(true)) {
                    break;
                } else {
                    adjacentBlockState = iblockstate.cycle(OPEN);
                    world.setBlock(adjacentPos, adjacentBlockState, 10);
                    world.setBlockAndUpdate(adjacentPos, state);
                    world.levelEvent(player, ((Boolean) state.getValue(OPEN)).booleanValue() ? 1005 : 1011, adjacentPos, 0);
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return ActionResultType.SUCCESS;
    }
}
