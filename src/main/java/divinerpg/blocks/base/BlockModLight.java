package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLight extends BlockModPowered {
    public BlockModLight(String name, float hardness) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(hardness, 3.0F).sound(SoundType.GLASS).setLightLevel((p_235464_0_) -> {
            return 15;
        }));
        //TODO - Figure out how to change luminance based on power when inside of block properties
    }

}
