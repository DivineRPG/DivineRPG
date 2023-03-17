package divinerpg.blocks.arcana;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcanaDoor extends DoorBlock {
    private ResourceLocation keyItem;

    public BlockArcanaDoor(ResourceLocation key) {
        super(Properties.of(Material.STONE).strength(-1, 6000000F), BlockSetType.STONE);
        this.keyItem = key;
    }



    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
        BlockState iblockstate = pos.equals(pos.below()) ? state : world.getBlockState(pos.below());

        if (iblockstate.getBlock() != this) {
            return InteractionResult.FAIL;
        } else {
            if (!player.isCreative()) {
                if (iblockstate.getValue(OPEN).equals(true)) {
                    return InteractionResult.FAIL;
                }
                Item key = ForgeRegistries.ITEMS.getValue(keyItem);
                ItemStack itemstack = player.getItemInHand(hand);
                if (itemstack == null || itemstack.getItem() != key) {
                    return InteractionResult.FAIL;
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
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
