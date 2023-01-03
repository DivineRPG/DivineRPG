package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(float hardness, float resistance, int luminance) {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(hardness, resistance).sound(SoundType.STONE).lightLevel((state) -> {
            return luminance;
        }));


    }
}
