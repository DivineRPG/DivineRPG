package divinerpg.blocks.base;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockModLamp extends BlockMod {
    public BlockModLamp(MaterialColor color) {
        super(Block.Properties.of(Material.METAL, color).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.LANTERN).lightLevel((state) -> 15));
    }
    public BlockModLamp(Material material, MaterialColor color) {
        super(Block.Properties.of(material, color).strength(0.3F).sound(SoundType.GLASS).lightLevel((state) -> 15));
    }
}