package divinerpg.blocks.fluid;

import net.minecraft.block.*;
import net.minecraft.fluid.*;

import java.util.function.*;

public class BlockTar extends FlowingFluidBlock {
    public BlockTar(Supplier<? extends FlowingFluid> supplier, Properties properties) {
        super(supplier, properties);
        setRegistryName("smoldering_tar");
    }
}

