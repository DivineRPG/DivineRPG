package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BlockMod extends Block {

    public BlockMod(String name, float hardness) {
        super(Block.Properties.create(Material.ROCK, MaterialColor.STONE).func_235861_h_().hardnessAndResistance(hardness, 3.0F).sound(SoundType.STONE));
        setRegistryName(name);
    }

    public BlockMod(String name, Block.Properties properties) {
        super(properties);
        setRegistryName(name);
    }

    public BlockMod(String name, float hardness, float resistance) {
        super(Block.Properties.create(Material.ROCK, MaterialColor.STONE).func_235861_h_().hardnessAndResistance(hardness, resistance).sound(SoundType.STONE));
        setRegistryName(name);
    }

    public BlockMod(String name, float hardness, float resistance, Material material) {
        super(Block.Properties.create(material, MaterialColor.STONE).func_235861_h_().hardnessAndResistance(hardness, resistance).sound(SoundType.STONE));
        setRegistryName(name);
    }

    public BlockMod(String name, float hardness, float resistance, Material material, SoundType sound) {
        super(Block.Properties.create(material, MaterialColor.STONE).func_235861_h_().hardnessAndResistance(hardness, resistance).sound(sound));
        setRegistryName(name);
    }
}
