package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModWall extends WallBlock {
    public BlockModWall(String name, Block block, float hardness) {
        super(Block.Properties.create(block.getDefaultState().getMaterial(), block.getDefaultState().getMaterial().getColor())
                .func_235861_h_()
                .hardnessAndResistance(hardness, 3600000.0F)
                .sound(block.getDefaultState().getSoundType()));
        setRegistryName(name);
    }
}
