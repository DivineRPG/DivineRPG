package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLight extends BlockModPowered {
    public BlockModLight(String name, float hardness) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.BLACK).func_235861_h_().hardnessAndResistance(hardness, 3.0F).sound(SoundType.GLASS).func_235838_a_((p_235464_0_) -> {
            return 15;
        }));
        //TODO - Figure out how to change luminance based on power when inside of block properties
    }

}