package naturix.divinerpg.objects.blocks.iceika;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWinterberryBush extends BlockMod implements IShearable {

	protected String stateChangeName;
	public boolean isGrown;

	World w;

	public BlockWinterberryBush(boolean grown, String name) {
		super(EnumBlockType.LEAVES, name, 0.3F);
		this.isGrown = grown;
		setTickRandomly(true);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (this == ModBlocks.winterberryBushGrown) {
			return ModItems.winterberry;
		}
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public void onBlockDestroyedByPlayer(World w, BlockPos pos, IBlockState state) {
		if (isGrown) {
			w.setBlockState(pos, ModBlocks.winterberryBush.getDefaultState());
		}
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (this == ModBlocks.winterberryBush) {
			ret.add(new ItemStack(this, 1));
		}
		return ret;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
	        EnumFacing side) {
		return !Minecraft.getMinecraft().gameSettings.fancyGraphics && blockState == this ? false
		        : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState state, Random r) {
		if (r.nextInt(2) == 0 && w.getBlockState(pos) == ModBlocks.winterberryBush) {
			w.setBlockState(pos, ModBlocks.winterberryBushGrown.getDefaultState());
		}
	}

}