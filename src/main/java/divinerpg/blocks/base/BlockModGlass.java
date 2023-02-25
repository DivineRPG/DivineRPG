package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModGlass extends AbstractGlassBlock {
    public BlockModGlass(float hardness) {
        super(Block.Properties.of(Material.GLASS, MaterialColor.NONE).dynamicShape().requiresCorrectToolForDrops().noOcclusion().strength(hardness, 3.0F).sound(SoundType.GLASS));
    }

}
