package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockModUnbreakable extends BlockMod {
    public BlockModUnbreakable(String name) {
        this(name, Material.STONE);
    }

    public BlockModUnbreakable(String name, Properties properties) {
        super(name, properties);
    }

    public BlockModUnbreakable(String name, boolean isLamp) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(-1.0F, 3600000.0F)
                .sound(SoundType.STONE)
                .lightLevel((p_235464_0_) -> {
                    return 15;
                }));
    }

    public BlockModUnbreakable(String name, Material material) {
        super(name, Block.Properties.of(material, MaterialColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(-1.0F, 3600000.0F)
                .sound(SoundType.STONE));
    }
}
