package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(String name, float hardness, float resistance, int luminance) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(hardness, resistance).sound(SoundType.STONE).lightLevel((p_235464_0_) -> {
            return luminance;
        }));


    }
}
