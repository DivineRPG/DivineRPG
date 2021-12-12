package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModGlass extends AbstractGlassBlock {
    public BlockModGlass(String name, float hardness) {
        super(Block.Properties.of(Material.GLASS, MaterialColor.NONE).dynamicShape().requiresCorrectToolForDrops().noOcclusion().strength(hardness, 3.0F).sound(SoundType.GLASS));
    setRegistryName(name);
    }

}
