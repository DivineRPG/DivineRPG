package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModSlab extends SlabBlock {
    public BlockModSlab(String name, Block base, float hardness) {
        super(Block.Properties.create(base.getDefaultState().getMaterial(), base.getDefaultState().getMaterial().getColor())
                .setRequiresTool()
                .hardnessAndResistance(hardness, 3.0F)
                .sound(base.getDefaultState().getSoundType()));
        setRegistryName(name);
    }
}
