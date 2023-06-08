package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(MapColor color) {
        super(Block.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(2F, 6.0F).sound(SoundType.STONE));
    }


    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.0F;
    }
}
