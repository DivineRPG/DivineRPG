package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockModLeaves extends LeavesBlock {
    public BlockModLeaves(MaterialColor color, SoundType sound) {
        super(Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(sound).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false));
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 30;
    }
}
