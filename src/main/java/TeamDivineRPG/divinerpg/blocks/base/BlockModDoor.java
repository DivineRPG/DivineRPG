package TeamDivineRPG.divinerpg.blocks.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockModDoor extends DoorBlock {
    public BlockModDoor(String name, Material material, float hardness, float resistance, ToolType tool) {
        super(Block.Properties
                .create(material)
                .hardnessAndResistance(hardness, resistance)
                .harvestTool(tool)
                .func_235861_h_());
        setRegistryName(DivineRPG.MODID, name);
    }
}