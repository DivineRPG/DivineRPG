package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(float hardness, Material material) {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(hardness, 3.0F).sound(SoundType.STONE));
    }


    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.0F;
    }
}
