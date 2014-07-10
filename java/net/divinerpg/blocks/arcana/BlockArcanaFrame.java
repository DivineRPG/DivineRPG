package net.divinerpg.blocks.arcana;

import java.util.List;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockArcanaFrame extends BlockMod {

    protected Block portal;

    public BlockArcanaFrame(String name, Block portal) {
        super(EnumBlockType.ROCK, name, 5.0F);
        this.portal = portal;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * if the specified block is in the given AABB, add its collision bounding
     * box to the given list
     */
    public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        this.setBlockBoundsForItemRender();
    }

    /**
     * checks if an ender eye has been inserted into the frame block.
     * parameters: metadata
     */
    public static boolean isEnderEyeInserted(int par0) {
        return (par0 & 4) != 0;
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack stack) {
        int var6 = ((MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) + 2) % 4;
        world.setBlockMetadataWithNotify(x, y, z, var6, 3);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) == this && world.getBlock(x, y, z + 1) == this
                && world.getBlock(x, y, z + 2) == this && world.getBlock(x + 1, y, z + 3) == this
                && world.getBlock(x + 2, y, z + 3) == this && world.getBlock(x + 3, y, z + 3) == this
                && world.getBlock(x + 4, y, z) == this && world.getBlock(x + 4, y, z + 1) == this
                && world.getBlock(x + 4, y, z + 2) == this
                && world.getBlock(x + 1, y, z - 1) == this && world.getBlock(x + 2, y, z - 1) == this
                && world.getBlock(x + 3, y, z - 1) == this) {

            world.setBlock(x + 1, y, z, portal);
            world.setBlock(x + 2, y, z, portal);
            world.setBlock(x + 3, y, z, portal);
            world.setBlock(x + 1, y, z + 1, portal);
            world.setBlock(x + 2, y, z + 1, portal);
            world.setBlock(x + 3, y, z + 1, portal);
            world.setBlock(x + 1, y, z + 2, portal);
            world.setBlock(x + 2, y, z + 2, portal);
            world.setBlock(x + 3, y, z + 2, portal);
        }
    }
}
