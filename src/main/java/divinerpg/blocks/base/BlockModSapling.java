package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockModSapling extends SaplingBlock {
    private final Supplier<Block> grassSupplier;
    private final Supplier<Block> dirtSupplier;

    public BlockModSapling(String name, Supplier<Block> grassSupplier, Supplier<Block> dirtSupplier, Tree tree) {
        super(tree, Properties.of(Material.PLANT)
                .dynamicShape()
                .randomTicks()
                .noCollission()
                .instabreak()
                .sound(SoundType.WET_GRASS));
        setRegistryName(DivineRPG.MODID, name);
        this.grassSupplier = grassSupplier;
        this.dirtSupplier = dirtSupplier;
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        return soil.getBlock() == grassSupplier.get() || soil.getBlock() == dirtSupplier.get();
    }
}
