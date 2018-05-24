package naturix.divinerpg.bases.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class StatueBase extends Block {

	private String name;
	public StatueBase(String name) {
		super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DivineRPG.BlocksTab);
        setHardness(1F);
		setResistance(2f);
		this.name = name;
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
} 