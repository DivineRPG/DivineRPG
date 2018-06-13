package naturix.divinerpg.bases.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class StatueBase extends Block {
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	private String name;
	public StatueBase(String name) {
		super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DivineRPG.BlocksTab);
        setHardness(1F);
		setResistance(2f);
		this.name = name;
		//this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		}
		
	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
	 @Override
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
	        return BLOCK_AABB;
	    }
	public boolean canEntitySpawn(Entity entityIn)
	{
		return false;
	}
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        EnumFacing entityFacing = entity.getHorizontalFacing();

        if(!world.isRemote) {
            if(entityFacing == EnumFacing.NORTH) {
                entityFacing = EnumFacing.SOUTH;
            } else if(entityFacing == EnumFacing.EAST) {
                entityFacing = EnumFacing.WEST;
            } else if(entityFacing == EnumFacing.SOUTH) {
                entityFacing = EnumFacing.NORTH;
            } else if(entityFacing == EnumFacing.WEST) {
                entityFacing = EnumFacing.EAST;
            }

            world.setBlockState(pos, state.withProperty(FACING, entityFacing), 2);
        }
    }
} 