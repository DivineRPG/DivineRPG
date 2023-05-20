package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(MaterialColor color) {
        super(BlockBehaviour.Properties.of(Material.GLASS, color).strength(0.3F).sound(SoundType.GLASS).lightLevel((state) -> 15));
    }
}
