package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModPressurePlate extends PressurePlateBlock {

    public BlockModPressurePlate(String name) {
        super(Sensitivity.EVERYTHING, AbstractBlock.Properties.copy(Blocks.OAK_PRESSURE_PLATE));
        setRegistryName(name);
    }
}
