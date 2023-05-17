package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(float hardness, float resistance, MaterialColor color, SoundType sound) {
        super(Block.Properties.of(Material.GLASS, color).strength(hardness, resistance).sound(sound).lightLevel((state) -> 15));


    }
}
