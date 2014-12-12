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

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack stack) {
        int var6 = ((MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) + 2) % 4;
        world.setBlockMetadataWithNotify(x, y, z, var6, 3);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z + 1) == this
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
