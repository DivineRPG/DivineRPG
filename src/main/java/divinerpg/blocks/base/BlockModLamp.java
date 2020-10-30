package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(String name, float hardness, float resistance, int luminance) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(hardness, resistance).sound(SoundType.STONE).setLightLevel((p_235464_0_) -> {
            return luminance;
        }));


    }
}
