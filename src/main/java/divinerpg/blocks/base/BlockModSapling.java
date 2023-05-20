package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import java.util.function.*;

public class BlockModSapling extends SaplingBlock {
    private final Supplier<Block> grassSupplier;
    private final Supplier<Block> dirtSupplier;

    public BlockModSapling(MaterialColor color, Supplier<Block> grassSupplier, Supplier<Block> dirtSupplier, AbstractTreeGrower tree) {
        super(tree, BlockBehaviour.Properties.of(Material.PLANT, color).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
        this.grassSupplier = grassSupplier;
        this.dirtSupplier = dirtSupplier;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        return super.canSurvive(state, worldIn, pos) || soil.getBlock() == grassSupplier.get() || soil.getBlock() == dirtSupplier.get();
    }
}