package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BlockModPlanks extends BlockMod {
    public BlockModPlanks(float hardness) {
        super(hardness);
    }

    public BlockModPlanks(Properties properties) {
        super(properties);
    }

    public BlockModPlanks(float hardness, float resistance) {
        super(hardness, resistance);
    }

    public BlockModPlanks(float hardness, float resistance, Material material) {
        super(hardness, resistance, material);
    }

    public BlockModPlanks(float hardness, float resistance, Material material, SoundType sound) {
        super(hardness, resistance, material, sound);
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 5;
        }
        return 0;
    }
}
