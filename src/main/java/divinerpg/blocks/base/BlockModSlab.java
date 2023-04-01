package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BlockModSlab extends SlabBlock {
    public BlockModSlab(Block base, float hardness) {
        super(Block.Properties.of(base.defaultBlockState().getMaterial(), base.defaultBlockState().getMaterial().getColor())
                .requiresCorrectToolForDrops()
                .strength(hardness, 3.0F)
                .sound(base.defaultBlockState().getSoundType()));
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 20;
        }
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }
}
