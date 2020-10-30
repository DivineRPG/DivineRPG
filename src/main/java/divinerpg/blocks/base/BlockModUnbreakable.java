package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockModUnbreakable extends BlockMod {
    public BlockModUnbreakable(String name) {
        this(name, Material.ROCK);
    }

    public BlockModUnbreakable(String name, Properties properties) {
        super(name, properties);
    }

    public BlockModUnbreakable(String name, boolean isLamp) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                .setRequiresTool()
                .hardnessAndResistance(-1.0F, 3600000.0F)
                .sound(SoundType.STONE)
                .setLightLevel((p_235464_0_) -> {
                    return 15;
                }));
    }

    public BlockModUnbreakable(String name, Material material) {
        super(name, Block.Properties.create(material, MaterialColor.STONE)
                .setRequiresTool()
                .hardnessAndResistance(-1.0F, 3600000.0F)
                .sound(SoundType.STONE));
    }
}
