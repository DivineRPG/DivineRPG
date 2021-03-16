package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockModDoor extends DoorBlock {
    public BlockModDoor(String name, Material material, float hardness, float resistance, ToolType tool) {
        super(Block.Properties
                .of(material)
                .strength(hardness, resistance)
                .harvestTool(tool)
                .requiresCorrectToolForDrops());
        setRegistryName(DivineRPG.MODID, name);
    }
}