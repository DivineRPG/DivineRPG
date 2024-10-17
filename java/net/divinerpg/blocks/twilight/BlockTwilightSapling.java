package net.divinerpg.blocks.twilight;

import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockTwilightSapling extends BlockMod implements IGrowable {

    private Block          grass, dirt;
    private WorldGenerator tree;
    private int            xOff, zOff;

    public BlockTwilightSapling(String name, Block grass, Block dirt, WorldGenerator tree) {
        super(EnumBlockType.PLANT, name, 0.0F);
        float var4 = 0.2F;
        this.setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
        this.grass = grass;
        this.dirt = dirt;
        this.tree = tree;
        setTickRandomly(true);
    }

    public BlockTwilightSapling(String name, Block grass, Block dirt, WorldGenerator tree, int xOff, int zOff) {
        this(name, grass, dirt, tree);
        this.xOff = xOff;
        this.zOff = zOff;
    }

    @Override
    public void updateTick(World w, int x, int y, int z, Random random) {
        if (!w.isRemote) {
            super.updateTick(w, x, y, z, random);
            if (random.nextInt(5) == 0) this.grow(w, x, y, z, random);
        }
    }

    @Override
    public boolean canPlaceBlockAt(World w, int x, int y, int z) {
        return w.getBlock(x, y - 1, z) == grass || w.getBlock(x, y - 1, z) == dirt;
    }

    @Override
    public boolean canBlockStay(World w, int x, int y, int z) {
        return w.getBlock(x, y - 1, z) == grass || w.getBlock(x, y - 1, z) == dirt;
    }

    @Override
    public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
        if (!this.canBlockStay(w, x, y, z)) {
            w.setBlockToAir(x, y, z);
            this.dropBlockAsItem(w, x, y, z, new ItemStack(this));
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        return null;
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean func_149851_a(World w, int x, int y, int z, boolean isClient) {
        return true;
    }

    @Override
    public boolean func_149852_a(World w, Random random, int x, int y, int z) {
        return w.rand.nextFloat() < 0.45F;
    }

    @Override
    public void func_149853_b(World w, Random random, int x, int y, int z) {
        this.grow(w, x, y, z, random);
    }

    public void grow(World w, int x, int y, int z, Random random) {
        if (w.getBlockMetadata(x, y, z) == 0) w.setBlockMetadataWithNotify(x, y, z, 1, 2);
        else if (w.getBlockMetadata(x, y, z) == 1) {
            w.setBlockToAir(x, y, z);
            tree.generate(w, random, x - xOff, y, z - zOff);
        }
    }
}
