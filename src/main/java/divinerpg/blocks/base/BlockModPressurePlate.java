package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MaterialColor;

public class BlockModPressurePlate extends PressurePlateBlock {

    public BlockModPressurePlate(MaterialColor color) {
        super(Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).color(color), BlockSetType.OAK);
    }
}