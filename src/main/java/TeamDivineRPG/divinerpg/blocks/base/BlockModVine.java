package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockModVine extends VineBlock {
    public BlockModVine(String name) {
        super(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.LIGHT_BLUE)
                .func_235861_h_()
                .notSolid()
                .tickRandomly()
                .doesNotBlockMovement()
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.field_235601_w_));
        setRegistryName(name);
    }
}
