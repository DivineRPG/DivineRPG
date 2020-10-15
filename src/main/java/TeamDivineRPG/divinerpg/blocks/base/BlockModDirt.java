package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BlockModDirt extends BlockMod{
    public BlockModDirt(String name, float hardness, MaterialColor color) {
        super(name, Block.Properties.create(Material.EARTH, color).func_235861_h_().hardnessAndResistance(hardness, 3.0F).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND));
    }
}
