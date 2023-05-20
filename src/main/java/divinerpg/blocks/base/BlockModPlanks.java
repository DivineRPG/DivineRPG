package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockModPlanks extends BlockMod {
    public BlockModPlanks(MaterialColor color) {
        super(Block.Properties.of(Material.WOOD, color).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOD) {
            return 20;
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
