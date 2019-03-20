package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModTorch extends BlockTorch implements IHasModel {
	private String particle;

	public BlockModTorch(String name, String particle) {
		super();
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setLightLevel(1);
		this.setHardness(0.0F);
		this.particle = particle;

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (this.particle != null) {
			EnumFacing enumfacing = stateIn.getValue(FACING);
			pos.getX();
			pos.getY();
			pos.getZ();
			if (enumfacing.getAxis().isHorizontal()) {
				enumfacing.getOpposite();
			} else {
				// worldIn.spawnParticle(this.particle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}