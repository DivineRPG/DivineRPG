package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class BlockModPressurePlate extends PressurePlateBlock {
    public BlockModPressurePlate(MapColor color, BlockSetType type) {
        super(type, Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(color));
    }
    public BlockModPressurePlate(Block copy, MapColor color, BlockSetType type) {
        super(type, Properties.ofFullCopy(copy).mapColor(color).requiresCorrectToolForDrops());
    }
}