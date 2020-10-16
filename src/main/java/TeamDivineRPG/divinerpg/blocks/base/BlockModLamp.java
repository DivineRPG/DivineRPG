package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(String name, float hardness, float resistance, int luminance) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.STONE).func_235861_h_().hardnessAndResistance(hardness, resistance).sound(SoundType.STONE).func_235838_a_((p_235464_0_) -> {
            return luminance;
        }));


    }
}
