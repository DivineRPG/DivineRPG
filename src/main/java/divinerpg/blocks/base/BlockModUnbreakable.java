package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;

public class BlockModUnbreakable extends BlockMod {
    public BlockModUnbreakable() {
        this(Material.STONE);
    }

    public BlockModUnbreakable(Properties properties) {
        super(properties);
    }

    public BlockModUnbreakable(boolean isLamp) {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(-1.0F, 3600000.0F)
                .sound(SoundType.STONE)
                .lightLevel((p_235464_0_) -> {
                    return 15;
                }));
    }

    public BlockModUnbreakable(Material material) {
        super(Block.Properties.of(material, MaterialColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(-1.0F, 3600000.0F)
                .sound(SoundType.STONE));
    }
}
