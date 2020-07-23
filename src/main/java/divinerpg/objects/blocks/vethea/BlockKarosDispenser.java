package divinerpg.objects.blocks.vethea;

import divinerpg.enums.ArrowType;
import divinerpg.objects.blocks.BlockModUnbreakable;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockKarosDispenser extends BlockModUnbreakable {

    public static final PropertyDirection FACING;
    public static final PropertyBool TRIGGERED;

    static {
        FACING = BlockDirectional.FACING;
        TRIGGERED = PropertyBool.create("triggered");
    }
    
    public BlockKarosDispenser(String name) {
        super(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(TRIGGERED, false));
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultDirection(worldIn, pos, state);
    }

    public void dispense(World world, BlockPos pos) {
        double var5 = pos.getX();
        double var7 = pos.getY();
        double var9 = pos.getZ();

        BlockSourceImpl blocksourceimpl = new BlockSourceImpl(world, pos);
        EnumFacing par3EnumFacing = (EnumFacing)blocksourceimpl.getBlockState().getValue(FACING);

        EntityDivineArrow var11 = new EntityDivineArrow(world, ArrowType.KAROS_ARROW, var5 + 0.5D + par3EnumFacing.getFrontOffsetX(), var7 + 0.5D, var9 + 0.5D + par3EnumFacing.getFrontOffsetZ());
        var11.damageMin = var11.damageMax = 12;
        double var12 = world.rand.nextDouble() * 0.1D + 0.9D;
        var11.motionX = (double)par3EnumFacing.getFrontOffsetX() * var12;
        var11.motionY = 0D;
        var11.motionZ = (double)par3EnumFacing.getFrontOffsetZ() * var12;
        //var11.motionX += world.rand.nextGaussian() * 0.007499999832361937D * (double)par2;
        var11.motionY += 0;
        //var11.motionZ += world.rand.nextGaussian() * 0.007499999832361937D * (double)par2;
        world.spawnEntity(var11);
    }

    public int tickRate(World worldIn) {
        return 4;
    }

    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            boolean flag = worldIn.getBlockState(pos.north()).isFullBlock();
            boolean flag1 = worldIn.getBlockState(pos.south()).isFullBlock();
            if (enumfacing == EnumFacing.NORTH && flag && !flag1) {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag) {
                enumfacing = EnumFacing.NORTH;
            } else {
                boolean flag2 = worldIn.getBlockState(pos.west()).isFullBlock();
                boolean flag3 = worldIn.getBlockState(pos.east()).isFullBlock();
                if (enumfacing == EnumFacing.WEST && flag2 && !flag3) {
                    enumfacing = EnumFacing.EAST;
                } else if (enumfacing == EnumFacing.EAST && flag3 && !flag2) {
                    enumfacing = EnumFacing.WEST;
                }
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing).withProperty(TRIGGERED, false), 2);
        }

    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        } else {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityDispenser) {
                playerIn.displayGUIChest((TileEntityDispenser)tileentity);
                if (tileentity instanceof TileEntityDropper) {
                    playerIn.addStat(StatList.DROPPER_INSPECTED);
                } else {
                    playerIn.addStat(StatList.DISPENSER_INSPECTED);
                }
            }

            return true;
        }
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.up());
        boolean flag1 = (Boolean)state.getValue(TRIGGERED);
        if (flag && !flag1) {
            worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
            worldIn.setBlockState(pos, state.withProperty(TRIGGERED, true), 4);
        } else if (!flag && flag1) {
            worldIn.setBlockState(pos, state.withProperty(TRIGGERED, false), 4);
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityDispenser();
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)).withProperty(TRIGGERED, false);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityDispenser) {
                ((TileEntityDispenser)tileentity).setCustomName(stack.getDisplayName());
            }
        }

    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof TileEntityDispenser) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityDispenser)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }

    public static IPosition getDispensePosition(IBlockSource coords) {
        EnumFacing enumfacing = (EnumFacing)coords.getBlockState().getValue(FACING);
        double d0 = coords.getX() + 0.7D * (double)enumfacing.getFrontOffsetX();
        double d1 = coords.getY() + 0.7D * (double)enumfacing.getFrontOffsetY();
        double d2 = coords.getZ() + 0.7D * (double)enumfacing.getFrontOffsetZ();
        return new PositionImpl(d0, d1, d2);
    }

    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(TRIGGERED, (meta & 8) > 0);
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;
        int j = i | ((EnumFacing)state.getValue(FACING)).getIndex();
        if ((Boolean)state.getValue(TRIGGERED)) {
            j |= 8;
        }

        return j;
    }

    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING, TRIGGERED});
    }
}
