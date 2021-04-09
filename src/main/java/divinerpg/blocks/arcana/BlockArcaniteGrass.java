package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.material.*;

public class BlockArcaniteGrass extends BlockModGrass {
    public BlockArcaniteGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.arcaniteDirt, hardness, MaterialColor.COLOR_BLUE);
    }
}
