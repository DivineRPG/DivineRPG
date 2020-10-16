package TeamDivineRPG.divinerpg.blocks.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class BlockModSapling extends SaplingBlock {
    private final Supplier<Block> grassSupplier;
    private final Supplier<Block> dirtSupplier;

    public BlockModSapling(String name, Supplier<Block> grassSupplier, Supplier<Block> dirtSupplier, Tree tree) {
        super(tree, Properties.create(Material.PLANTS)
                .doesNotBlockMovement()
                .tickRandomly()
                .notSolid()
                .zeroHardnessAndResistance()
                .sound(SoundType.PLANT));
        setRegistryName(DivineRPG.MODID, name);
        this.grassSupplier = grassSupplier;
        this.dirtSupplier = dirtSupplier;
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.down());
        return soil.getBlock() == grassSupplier.get() || soil.getBlock() == dirtSupplier.get();
    }
}
