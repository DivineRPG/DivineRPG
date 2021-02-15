package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(String name, float hardness, Material material) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(hardness, 3.0F).sound(SoundType.STONE));
    }


    @Override
    public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
        return 1.0F;
    }
}
