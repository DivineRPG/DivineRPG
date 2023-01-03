package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import java.util.function.*;

public class BlockModSapling extends SaplingBlock {
    private final Supplier<Block> grassSupplier;
    private final Supplier<Block> dirtSupplier;

    public BlockModSapling(Supplier<Block> grassSupplier, Supplier<Block> dirtSupplier, AbstractTreeGrower tree) {
        super(tree, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
        this.grassSupplier = grassSupplier;
        this.dirtSupplier = dirtSupplier;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        return super.canSurvive(state, worldIn, pos) || soil.getBlock() == grassSupplier.get() || soil.getBlock() == dirtSupplier.get();
    }
}
