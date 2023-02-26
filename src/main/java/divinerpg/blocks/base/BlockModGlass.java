package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BlockModGlass extends AbstractGlassBlock {
    public BlockModGlass(float hardness) {
        super(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F, hardness).sound(SoundType.GLASS).noOcclusion());
    }

}
