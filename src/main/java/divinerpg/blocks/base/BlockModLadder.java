package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLadder extends LadderBlock {
    public BlockModLadder(String name, MaterialColor color) {
        super(Block.Properties.create(Material.WOOD, color)
                .hardnessAndResistance(0.4F, 3.0F)
                .sound(SoundType.LADDER)
                .notSolid()
                .func_235861_h_());
        setRegistryName(name);
    }
}
