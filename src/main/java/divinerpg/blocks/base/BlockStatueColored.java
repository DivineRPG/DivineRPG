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

import static divinerpg.registries.SoundRegistry.AYERACO;

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
    @Override public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        ItemStack item = player.getItemInHand(hand);
        colorTest: {
            BlockColor color = state.getValue(COLOR);
            if(item.is(Items.BLUE_DYE) && color != BlockColor.BLUE) color = BlockColor.BLUE;
            else if(item.is(Items.GREEN_DYE) && color != BlockColor.GREEN) color = BlockColor.GREEN;
            else if(item.is(Items.PINK_DYE) && color != BlockColor.PINK) color = BlockColor.PINK;
            else if(item.is(Items.PURPLE_DYE) && color != BlockColor.PURPLE) color = BlockColor.PURPLE;
            else if(item.is(Items.RED_DYE) && color != BlockColor.RED) color = BlockColor.RED;
            else if(item.is(Items.YELLOW_DYE) && color != BlockColor.YELLOW) color = BlockColor.YELLOW;
            else if(item.is(Items.WHITE_DYE) && color != BlockColor.WHITE) color = BlockColor.WHITE;
            else break colorTest;
            if(!player.isCreative()) item.shrink(1);
            player.setItemInHand(hand, item);
            world.setBlock(pos, defaultBlockState().setValue(COLOR, color).setValue(FACING, state.getValue(FACING)), 3);
            return InteractionResult.SUCCESS;
        } return super.use(state, world, pos, player, hand, trace);
    }
}