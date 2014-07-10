package net.divinerpg.api.blocks;

import java.util.Random;

import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModDoor extends BlockMod {

    @SideOnly(Side.CLIENT)
    protected IIcon[] topIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon[] bottomIcon;
    protected Item    key;
    protected boolean canOpenByHand;

    public BlockModDoor(EnumBlockType blockType, String name, float hardness, Item key) {
        super(blockType, name, hardness);
        if(hardness == -1F) setBlockUnbreakable();
        setCreativeTab(null);
        canOpenByHand = key == null;
        setTickRandomly(true);
        float f = 0.5f;
        float f1 = 1.0f;
        setBlockBounds(0.5f - f, 0, 0.5f - f, 0.5f + f, f1, 0.5f + f);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return bottomIcon[0];
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (side != 1 && side != 0) {
            int i1 = this.getBlockMetadata(blockAccess, x, y, z);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag) {
                if (j1 == 0 && side == 2) flag1 = !flag1;
                else if (j1 == 1 && side == 5) flag1 = !flag1;
                else if (j1 == 2 && side == 3) flag1 = !flag1;
                else if (j1 == 3 && side == 4)
                    flag1 = !flag1;
            } else {
                if (j1 == 0 && side == 5) flag1 = !flag1;
                else if (j1 == 1 && side == 3) flag1 = !flag1;
                else if (j1 == 2 && side == 4) flag1 = !flag1;
                else if (j1 == 3 && side == 2)
                    flag1 = !flag1;

                if ((i1 & 16) != 0)
                    flag1 = !flag1;
            }

            return flag2 ? this.topIcon[flag1 ? 1 : 0] : this.bottomIcon[flag1 ? 1 : 0];
        }
        return bottomIcon[0];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.topIcon = new IIcon[2];
        this.bottomIcon = new IIcon[2];
        this.topIcon[0] = icon.registerIcon(textureName + "_top");
        this.bottomIcon[0] = icon.registerIcon(textureName + "_bottom");
        this.topIcon[1] = new IconFlipped(this.topIcon[0], true, false);
        this.bottomIcon[1] = new IconFlipped(this.bottomIcon[0], true, false);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess blockAccess, int x, int y, int z) {
        int l = this.getBlockMetadata(blockAccess, x, y, z);
        return (l & 4) != 0;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 7;
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
        this.thisMustBeNamedBetter(this.getBlockMetadata(blockAccess, x, y, z));
    }

    public int nameThisBetterBitwise(IBlockAccess world, int x, int y, int z) {
        return this.getBlockMetadata(world, x, y, z) & 3;
    }

    public boolean isNameThisBetter(IBlockAccess blockAccess, int x, int y, int z) {
        return (this.getBlockMetadata(blockAccess, x, y, z) & 4) != 0;
    }

    protected void thisMustBeNamedBetter(int needsName) {
        float f = 0.1875F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        int j = needsName & 3;
        boolean flag = (needsName & 4) != 0;
        boolean flag1 = (needsName & 16) != 0;

        switch (j) {
            case 0:
                if (flag) {
                    if (!flag1) this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                    else this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                } else this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                break;
            case 1:
                if (flag) {
                    if (!flag1) this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                    else this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                } else this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                break;
            case 2:
                if (flag) {
                    if (!flag1) this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                    else this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                } else this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 3:
                if (flag) {
                    if (!flag1) this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                    else this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                } else this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                break;
        }
    }

    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {}
    
    protected void notifyAndUpdateBlock(World world, int x, int y, int z, int j1, boolean flag, EntityPlayer player){
        int yOffset = flag ? 0 : 1;
        world.setBlockMetadataWithNotify(x, y - yOffset, z, j1, 2);
        world.markBlockRangeForRenderUpdate(x, y - yOffset, z, x, y, z);
        world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        int i1 = this.getBlockMetadata(world, x, y, z);
        int j1 = (i1 & 7) ^ 4;
        boolean flag = (i1 & 8) == 0;
        if (!canOpenByHand) {
            if (player.getHeldItem() != null && player.getHeldItem().getItem() == key) {
                player.getHeldItem().stackSize--;
                notifyAndUpdateBlock(world, x, y, z, j1, flag, player);
                return true;
            }
            return false;
        }
        notifyAndUpdateBlock(world, x, y, z, j1, flag, player);
        return true;
    }

    public void setBlockMetadata(World world, int x, int y, int z, boolean flag) {
        int l = this.getBlockMetadata(world, x, y, z);
        boolean flag1 = (l & 4) != 0;

        if (flag1 != flag) {
            int i1 = l & 7;
            i1 ^= 4;

            if ((l & 8) == 0) {
                world.setBlockMetadataWithNotify(x, y, z, i1, 2);
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            } else {
                world.setBlockMetadataWithNotify(x, y - 1, z, i1, 2);
                world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }

            world.playAuxSFXAtEntity((EntityPlayer) null, 1003, x, y, z, 0);
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0) {
            boolean flag = false;
            if (world.getBlock(x, y + 1, z) != this) {
                world.setBlockToAir(x, y, z);
                flag = true;
            }
            if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) {
                world.setBlockToAir(x, y, z);
                flag = true;

                if (world.getBlock(x, y + 1, z) == this)
                    world.setBlockToAir(x, y + 1, z);
            }

            if (flag) {
                if (!world.isRemote)
                    this.dropBlockAsItem(world, x, y, z, l, 0);
            } else {
                boolean flag1 = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);
                if ((flag1 || block.canProvidePower()) && block != this)
                    this.setBlockMetadata(world, x, y, z, flag1);
            }
        } else {
            if (world.getBlock(x, y - 1, z) != this)
                world.setBlockToAir(x, y, z);

            if (block != this)
                this.onNeighborBlockChange(world, x, y - 1, z, block);
        }
    }

    public Item getItemDropped(int par1, Random par2Rand, int par3) {
        return null;
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 startVector, Vec3 endVector) {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, startVector, endVector);
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return y >= 255 ? false : World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z)
                && super.canPlaceBlockAt(world, x, y + 1, z);
    }

    public int getMobilityFlag() {
        return 1;
    }

    public int getBlockMetadata(IBlockAccess blockAccess, int x, int y, int z) {
        int l = blockAccess.getBlockMetadata(x, y, z);
        boolean flag = (l & 8) != 0;
        int i1;
        int j1;

        if (flag) {
            i1 = blockAccess.getBlockMetadata(x, y - 1, z);
            j1 = l;
        } else {
            i1 = l;
            j1 = blockAccess.getBlockMetadata(x, y + 1, z);
        }

        boolean flag1 = (j1 & 1) != 0;
        return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return null;
    }

    public void onBlockHarvested(World world, int x, int y, int z, int par5, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && (par5 & 8) != 0 && world.getBlock(x, y - 1, z) == this)
            world.setBlockToAir(x, y - 1, z);
    }
}