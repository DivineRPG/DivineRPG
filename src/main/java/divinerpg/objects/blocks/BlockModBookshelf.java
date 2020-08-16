package divinerpg.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockModBookshelf extends BlockMod {
    public BlockModBookshelf(String name, float hardness, Material material) {
        super(name, hardness, material);
    }

    public int quantityDropped(Random random) {
        return 3;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.BOOK;
    }

    public float getEnchantPowerBonus(World world, BlockPos pos) {
        return 1.0F;
    }
}
