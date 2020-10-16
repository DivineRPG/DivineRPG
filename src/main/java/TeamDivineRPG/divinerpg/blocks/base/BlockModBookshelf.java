package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(String name, float hardness, Material material) {
        super(name, Block.Properties.create(Material.ROCK, MaterialColor.STONE).func_235861_h_().hardnessAndResistance(hardness, 3.0F).sound(SoundType.STONE));
    }

    public float getEnchantPowerBonus(World world, BlockPos pos) {
        //TODO - this no longer works
        return 1.0F;
    }
}
