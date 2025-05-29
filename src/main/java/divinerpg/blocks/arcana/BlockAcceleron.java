package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;

import static net.minecraft.world.level.block.HorizontalDirectionalBlock.FACING;
import static net.minecraft.world.level.block.SoundType.METAL;
import static net.minecraft.world.level.material.MapColor.LAPIS;

public class BlockAcceleron extends BlockMod {
    //TODO: to make acceleration cap or remove the ability to shift on this block, since it basically sends you... far...
    public BlockAcceleron() {
        super(Properties.of().mapColor(LAPIS).requiresCorrectToolForDrops().strength(5, 6).sound(METAL).friction(1.2F));
    }
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}