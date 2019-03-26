package naturix.divinerpg.objects.blocks.twilight;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockPurpleGlowBone extends BlockMod implements IPlantable, IHasModel {

	static float var3 = 0.375F;
	public static final AxisAlignedBB FULL_BLOCK_AABB = new AxisAlignedBB(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3,
	        1.0F, 0.5F + var3);

	public BlockPurpleGlowBone(String name) {
		super(Material.ROCK, name);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setTickRandomly(true);
		setCreativeTab(null);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	@SuppressWarnings("deprecation")
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModItems.purpleGlowboneSeeds);
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.getDefaultState();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return EnumPlantType.Beach;
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
	}
	//
	// @Override
	// public void updateTick(World worldgen, BlockPos pos, IBlockState state,
	// Random rand) {
	// int i=pos.getX();
	// int j=pos.getY();
	// int k=pos.getZ();
	// BlockPos pos2 = new BlockPos(i, j+1, k);
	// BlockPos pos3 = new BlockPos(i, j-1, k);
	// if(worldgen.isAirBlock(pos2) && worldgen.getBlockState(pos) == Blocks.AIR &&
	// worldgen.getBlockState(pos3) == Blocks.GRASS) {
	// worldgen.setBlockState(pos2, this, 2);
	// worldgen.setBlockState(pos, this, 1);
	// }
	// }
	//
	// @Override
	// public boolean canBlockStay(World w, int x, int y, int z) {
	// return w.getBlock(x, y - 1, z) == this || w.getBlock(x, y - 1, z) ==
	// Blocks.grass;
	// }
	//
	// @Override
	// public boolean canPlaceBlockAt(World w, int x, int y, int z) {
	// return true;
	// }
	//
	// @Override
	// public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
	// this.checkBlockCoordValid(w, x, y, z);
	// }
	//
	// protected void checkBlockCoordValid(World worldgen, int i, int j, int k) {
	// if(!this.canBlockStay(worldgen, i, j, k)) {
	// if(worldgen.getBlockMetadata(i, j, k) ==
	// 2)this.dropBlockAsItemWithChance(worldgen, i, j, k,
	// worldgen.getBlockMetadata(i, j, k), 1f, 0);
	// else if(worldgen.getBlockMetadata(i, j, k) ==
	// 0)this.dropBlockAsItem(worldgen, i, j, k, new
	// ItemStack(TwilightItemsCrops.purpleGlowboneSeeds));
	// worldgen.breakBlock(i, j, k, false);
	// }else if(worldgen.getBlockMetadata(i, j, k) != 0 && worldgen.getBlock(i, j+1,
	// k) != this){
	// worldgen.setBlock(i, j, k, this, 0, 2);
	// }
	// }
	//
	// @Override
	// public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y,
	// int z) {
	// return null;
	// }
	//
	// @Override
	// public Item getItemDropped(int meta, Random rand, int fortune){
	// return TwilightItemsCrops.purpleGlowboneSeeds;
	// }
	//
	// @Override
	// public int quantityDropped(Random rand) {
	// return 1+rand.nextInt(2);
	// }
	//
	// @Override
	// public ArrayList<ItemStack> getDrops(World worldgen, int x, int y, int z, int
	// meta, int fortune)
	// {
	// ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
	// if(meta == 2){
	// drops.add(new ItemStack(TwilightItemsCrops.purpleGlowbone, 1));
	// drops.add(new ItemStack(this.getItemDropped(0, this.rand, 0),
	// this.quantityDropped(this.rand)));
	// }
	// if(meta == 0){
	// drops.add(new ItemStack(this.getItemDropped(0, this.rand, 0), 1));
	// }
	// return drops;
	// }

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}