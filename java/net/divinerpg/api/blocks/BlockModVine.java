package net.divinerpg.api.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockModVine extends BlockMod implements IShearable {

    public BlockModVine(String name) {
        super(EnumBlockType.VINES, name, 0.0F);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public int getRenderType() {
        return 20;
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
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
        float f = 0.0625F;
        int l = blockAccess.getBlockMetadata(x, y, z);
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = 1.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag = l > 0;

        if ((l & 2) != 0) {
            f4 = Math.max(f4, 0.0625F);
            f1 = 0.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
            flag = true;
        }

        if ((l & 8) != 0) {
            f1 = Math.min(f1, 0.9375F);
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
            flag = true;
        }

        if ((l & 4) != 0) {
            f6 = Math.max(f6, 0.0625F);
            f3 = 0.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }

        if ((l & 1) != 0) {
            f3 = Math.min(f3, 0.9375F);
            f6 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }

        if (!flag && this.canBePlacedOnBlock(blockAccess.getBlock(x, y + 1, z))) {
            f2 = Math.min(f2, 0.9375F);
            f5 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
        }

        this.setBlockBounds(f1, f2, f3, f4, f5, f6);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
        switch (side) {
            case 1:
                return this.canBePlacedOnBlock(world.getBlock(x, y + 1, z));
            case 2:
                return this.canBePlacedOnBlock(world.getBlock(x, y, z + 1));
            case 3:
                return this.canBePlacedOnBlock(world.getBlock(x, y, z - 1));
            case 4:
                return this.canBePlacedOnBlock(world.getBlock(x + 1, y, z));
            case 5:
                return this.canBePlacedOnBlock(world.getBlock(x - 1, y, z));
            default:
                return false;
        }
    }

    protected boolean canBePlacedOnBlock(Block block) {
        return block.renderAsNormalBlock() && block.getMaterial().blocksMovement();
    }

    //TODO: Is this an appropriate name? Brock formally called it func_150094_e like an idiot
    protected boolean areVinesOnBlock(World world, int x, int y, int z) {

        int l = world.getBlockMetadata(x, y, z);
        int i1 = l;

        if (l > 0) {
            for (int j1 = 0; j1 <= 3; ++j1) {
                int k1 = 1 << j1;

                if ((l & k1) != 0 && !this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[j1], y, z + Direction.offsetZ[j1]))
                        && (world.getBlock(x, y + 1, z) != this || (world.getBlockMetadata(x, y + 1, z) & k1) == 0))
                    i1 &= ~k1;
            }
        }

        if (i1 == 0 && !this.canBePlacedOnBlock(world.getBlock(x, y + 1, z)))
            return false;
        if (i1 != l)
            world.setBlockMetadataWithNotify(x, y, z, i1, 2);

        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote && !this.areVinesOnBlock(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote && world.rand.nextInt(4) == 0) {
            byte b0 = 4;
            int l = 5;
            boolean flag = false;
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;
            lableA: //TODO formerly label134, why? Also, who the heck uses lables in Java? thats stupid

            for (i1 = x - b0; i1 <= x + b0; ++i1) {
                for (j1 = z - b0; j1 <= z + b0; ++j1) {
                    for (k1 = y - 1; k1 <= y + 1; ++k1) {
                        if (world.getBlock(i1, k1, j1) == this) {
                            l--;
                            if (l <= 0) {
                                flag = true;
                                break lableA;
                            }
                        }
                    }
                }
            }

            i1 = world.getBlockMetadata(x, y, z);
            j1 = world.rand.nextInt(6);
            k1 = Direction.facingToDirection[j1];
            int l1 = 0;

            if (j1 == 1 && y < 255 && world.isAirBlock(x, y + 1, z)) {
                if (flag) return;

                int j2 = world.rand.nextInt(16) & i1;

                if (j2 > 0) {
                    for (l1 = 0; l1 <= 3; ++l1) {
                        if (!this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[l1], y + 1, z + Direction.offsetZ[l1])))
                            j2 &= ~(1 << l1);
                    }

                    if (j2 > 0)
                        world.setBlock(x, y + 1, z, this, j2, 2);
                }
            } else {
                Block block = null;
                int i2 = 0;

                if (j1 >= 2 && j1 <= 5 && (i1 & 1 << k1) == 0) {
                    if (flag) return;

                    block = world.getBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1]);

                    if (block.getMaterial() == Material.air) {
                        l1 = k1 + 1 & 3;
                        i2 = k1 + 3 & 3;

                        if ((i1 & 1 << l1) != 0
                                && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[k1] + Direction.offsetX[l1], y,
                                        z + Direction.offsetZ[k1] + Direction.offsetZ[l1]))) world.setBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1], this, 1 << l1, 2);
                        else if ((i1 & 1 << i2) != 0
                                && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[k1] + Direction.offsetX[i2], y,
                                        z + Direction.offsetZ[k1] + Direction.offsetZ[i2]))) world.setBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1], this, 1 << i2, 2);
                        else if ((i1 & 1 << l1) != 0 && world.isAirBlock(x + Direction.offsetX[k1] + Direction.offsetX[l1], y, z + Direction.offsetZ[k1] + Direction.offsetZ[l1])
                                && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[l1], y,
                                        z + Direction.offsetZ[l1]))) world.setBlock(x + Direction.offsetX[k1] + Direction.offsetX[l1], y, z + Direction.offsetZ[k1] + Direction.offsetZ[l1], this, 1 << (k1 + 2 & 3), 2);
                        else if ((i1 & 1 << i2) != 0 && world.isAirBlock(x + Direction.offsetX[k1] + Direction.offsetX[i2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[i2])
                                && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[i2], y, z + Direction.offsetZ[i2]))) world.setBlock(x + Direction.offsetX[k1] + Direction.offsetX[i2], y, z
                                + Direction.offsetZ[k1] + Direction.offsetZ[i2], this, 1 << (k1 + 2 & 3), 2);
                        else if (this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[k1], y + 1, z + Direction.offsetZ[k1])))
                            world.setBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1], this, 0, 2);
                    } else if (block.getMaterial().isOpaque() && block.renderAsNormalBlock())
                        world.setBlockMetadataWithNotify(x, y, z, i1 | 1 << k1, 2);
                } else if (y > 1) {
                    block = world.getBlock(x, y - 1, z);

                    if (block.getMaterial() == Material.air) {
                        l1 = world.rand.nextInt(16) & i1;
                        if (l1 > 0)
                            world.setBlock(x, y - 1, z, this, l1, 2);
                    } else if (block == this) {
                        l1 = world.rand.nextInt(16) & i1;
                        i2 = world.getBlockMetadata(x, y - 1, z);
                        if (i2 != (i2 | l1))
                            world.setBlockMetadataWithNotify(x, y - 1, z, i2 | l1, 2);
                    }
                }
            }
        }
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        byte b0 = 0;
        switch (side) {
            case 2:
                b0 = 1;
                break;
            case 3:
                b0 = 4;
                break;
            case 4:
                b0 = 8;
                break;
            case 5:
                b0 = 2;
        }

        return b0 != 0 ? b0 : meta;
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par3) {
        return null;
    }

    @Override
    public int quantityDropped(Random rand) {
        return 0;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1));
        return ret;
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
        return true;
    }
}
