package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLeaves extends LeavesBlock {

    public BlockModLeaves(String name, MaterialColor color, float hardness) {
        super(Block.Properties.create(Material.LEAVES, color).notSolid().setRequiresTool().hardnessAndResistance(1, 3.0F).sound(SoundType.PLANT));
        setRegistryName(DivineRPG.MODID, name);
    }
}
