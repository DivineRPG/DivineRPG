package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockModUnbreakable extends BlockMod {
    public BlockModUnbreakable(String name) {
        this(name, Material.ROCK);
    }
    public BlockModUnbreakable(String name, Properties properties) {
        super(name, properties);
    }

    public BlockModUnbreakable(String name, boolean isLamp) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                .func_235861_h_()
                .hardnessAndResistance(-1.0F, 3600000.0F)
                .sound(SoundType.STONE)
                .func_235838_a_((p_235464_0_) -> { return 15; }));
    }

    public BlockModUnbreakable(String name, Material material) {
        super(name, Block.Properties.create(material, MaterialColor.STONE)
                .func_235861_h_()
                .hardnessAndResistance(-1.0F, 3600000.0F)
                .sound(SoundType.STONE));
    }
}
