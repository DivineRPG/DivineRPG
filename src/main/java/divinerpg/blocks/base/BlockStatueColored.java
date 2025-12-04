package divinerpg.blocks.base;

import divinerpg.enums.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.Tags;

import static divinerpg.registries.SoundRegistry.AYERACO;
import static net.minecraft.stats.Stats.ITEM_USED;

public class BlockStatueColored extends BlockStatue {
    public static final EnumProperty<BlockColor> COLOR = BlockColor.COLOR;
    public BlockStatueColored() {
        super(AYERACO);
        registerDefaultState(stateDefinition.any().setValue(COLOR, BlockColor.WHITE));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR);
    }
    @Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        colorTest: {
            BlockColor color = state.getValue(COLOR);
            if(stack.is(Tags.Items.DYES_RED) && color != BlockColor.RED) color = BlockColor.RED;
            else if(stack.is(Tags.Items.DYED_YELLOW) && color != BlockColor.YELLOW) color = BlockColor.YELLOW;
            else if(stack.is(Tags.Items.DYES_GREEN) && color != BlockColor.GREEN) color = BlockColor.GREEN;
            else if(stack.is(Tags.Items.DYES_BLUE) && color != BlockColor.BLUE) color = BlockColor.BLUE;
            else if(stack.is(Tags.Items.DYES_PURPLE) && color != BlockColor.PURPLE) color = BlockColor.PURPLE;
            else if(stack.is(Tags.Items.DYES_PINK) && color != BlockColor.PINK) color = BlockColor.PINK;
            else if(stack.is(Tags.Items.DYES_WHITE) && color != BlockColor.WHITE) color = BlockColor.WHITE;
            else break colorTest;
            stack.consume(1, player);
            player.awardStat(ITEM_USED.get(stack.getItem()));
            player.setItemInHand(hand, stack);
            world.setBlock(pos, defaultBlockState().setValue(COLOR, color).setValue(ROTATION, state.getValue(ROTATION)), 3);
            return ItemInteractionResult.SUCCESS;
        } return super.useItemOn(stack, state, world, pos, player, hand, trace);
    }
}