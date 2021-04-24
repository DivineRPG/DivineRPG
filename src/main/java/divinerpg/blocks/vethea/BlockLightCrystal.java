package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(String name, float hardness) {
        super(name, AbstractBlock.Properties.of(Material.GLASS).strength(hardness).lightLevel((p_235464_0_) -> {
            return 1;
        }));
    }
}
