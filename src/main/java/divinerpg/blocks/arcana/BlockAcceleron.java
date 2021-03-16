package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.*;

public class BlockAcceleron extends BlockMod {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    @Deprecated
    public BlockAcceleron(String name) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 3.0F)
                .sound(SoundType.WOOD)
                .friction(1.2F));
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}