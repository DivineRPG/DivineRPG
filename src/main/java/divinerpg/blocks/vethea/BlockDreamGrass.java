package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.material.*;

public class BlockDreamGrass extends BlockModGrass {

    public BlockDreamGrass(String name, float hardness) {
        super(name, () -> BlockRegistry.dreamDirt, hardness, MaterialColor.COLOR_LIGHT_GREEN);
    }
}
