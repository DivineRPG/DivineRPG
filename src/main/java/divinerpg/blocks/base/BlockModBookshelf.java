package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(float hardness, MaterialColor color) {
        super(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(hardness, 6.0F).color(color).sound(SoundType.STONE));
    }


    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.0F;
    }
}
