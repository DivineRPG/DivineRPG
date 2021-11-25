package divinerpg.blocks.base;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLog extends RotatedPillarBlock {

    public BlockModLog(String name, MaterialColor color) {
        super(AbstractBlock.Properties.of(Material.WOOD, color).strength(2.0F).sound(SoundType.WOOD));
        setRegistryName(DivineRPG.MODID, name);
    }


}