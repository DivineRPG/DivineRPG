package naturix.divinerpg.bases.blocks.portal;

import java.util.Random;

import naturix.divinerpg.bases.blocks.BlockBase;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EdenBlock extends BlockBase{

	public EdenBlock(Material material, String name) {
		super(Material.ROCK, name);
	}
	private EnumFacing side;
    protected static Random itemRand = new Random();
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer entityIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		ItemStack par1ItemStack = entityIn.getHeldItem(hand);
		int par4 = pos.getX();
		int par5 = pos.getY();
		int par6 = pos.getZ();
		int par7 = side.getIndex();
		if(par1ItemStack.getItem() == ModItems.mysteriousClock) {
		if (par7 == 0) {
			par5--;
		}
		if (par7 == 1) {
			par5++;
		}
		if (par7 == 2) {
			par6--;
		}
		if (par7 == 3) {
			par6++;
		}
		if (par7 == 4) {
			par4--;
		}
		if (par7 == 5) {
			par4++;
		}
//		if (!entityIn.canPlayerEdit(new BlockPos(par4, par5, par6), side, par1ItemStack)) {
//			return EnumActionResult.FAIL != null;
//		}
		Block i1 = ModBlocks.portalEden.getDefaultState().getBlock();
		if (i1 == Blocks.AIR) {
			worldIn.playSound(entityIn, new BlockPos(par4, par5, par6), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
					itemRand.nextFloat() * 0.4F + 0.8F);
			ModBlocks.portalEden.trySpawnPortal(worldIn, pos);
		}
		//par1ItemStack.damageItem(1, entityIn);
        return false;
		}
		return false;
		}
}
