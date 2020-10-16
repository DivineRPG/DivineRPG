package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.ToolType;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(String name, float hardness, MaterialColor color) {
        super(name, Block.Properties.create(Material.EARTH, color).func_235861_h_().hardnessAndResistance(hardness, 3.0F).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND));
    }
}
