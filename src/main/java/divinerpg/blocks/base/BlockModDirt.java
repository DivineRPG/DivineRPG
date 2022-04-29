package divinerpg.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

public class BlockModDirt extends BlockMod {
    public BlockModDirt(String name, float hardness, MaterialColor color) {
        super(name, Block.Properties.of(Material.DIRT, color).strength(hardness, 3.0F).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.GRASS));
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }



}
