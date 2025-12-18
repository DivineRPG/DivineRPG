package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockModPressurePlate extends PressurePlateBlock {
    public BlockModPressurePlate(DeferredBlock<Block> base, BlockSetType type) {
        super(type, Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(base.get().defaultMapColor()));
    }
    public BlockModPressurePlate(Block copy, MapColor color, BlockSetType type) {
        super(type, Properties.ofFullCopy(copy).mapColor(color).requiresCorrectToolForDrops());
    }
}