package naturix.divinerpg.objects.blocks.vanilla;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class VanillaBlock extends BlockMod {

    private Random rand = new Random();

    public VanillaBlock(EnumBlockType type, String name, float hardness, int harvest) {
        super(type, name, hardness, DivineRPG.BlocksTab);
        setHarvestLevel("pickaxe", harvest);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0) {
                j = 0;
            }

            return this.quantityDropped(random) * (j + 1);
        } else {
            return this.quantityDropped(random);
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (state.getBlock() == ModBlocks.netheriteOre) {
            entity.attackEntityFrom(DamageSource.IN_FIRE, 1.0F);
        }
    }

    // FIXME - Extend collision box of Netherite Ore?
    //@Override
    //public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    //{
    //    float f = 0.0625F;
    //    return this == VanillaBlocks.netheriteOre ? AxisAlignedBB.getBoundingBox((double)((float)x + f), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)(y + 1) - f), (double)((float)(z + 1) - f)) : super.getCollisionBoundingBoxFromPool(world, x, y, z);
    //}

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int j1 = 0;

            if (this == ModBlocks.bloodgemOre) {
                j1 = MathHelper.getInt(rand, 0, 4);
            }
            return j1;
        }
        return 0;
    }
}