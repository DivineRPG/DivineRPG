package naturix.divinerpg.objects.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityIceikaChest;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on Feb /01/2019
 */
public class IceikaChest extends BlockContainer {
	public String name;

	public IceikaChest(String name) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.BlocksTab);
		setSoundType(SoundType.GLASS);
		this.name = name;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityIceikaChest tileEntity = (TileEntityIceikaChest) worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileEntity);
		super.breakBlock(worldIn, pos, state);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityIceikaChest();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
	        EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(DivineRPG.instance, GUIHandler.ICEIKA_CHEST_GUI_ID, worldIn, pos.getX(), pos.getY(),
			        pos.getZ());
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
	        ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof TileEntityIceikaChest) {
				((TileEntityIceikaChest) tileEntity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		Random random = worldIn.rand;
		for (int i = 0; i < 6; ++i) {
			double d1 = pos.getX() + random.nextFloat();
			double d2 = pos.getY() + random.nextFloat();
			double d3 = pos.getZ() + random.nextFloat();

			if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
				d2 = pos.getY() + 0.0625D + 1.0D;
			}

			if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
				d2 = pos.getY() - 0.0625D;
			}

			if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
				d3 = pos.getZ() + 0.0625D + 1.0D;
			}

			if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
				d3 = pos.getZ() - 0.0625D;
			}

			if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
				d1 = pos.getX() + 0.0625D + 1.0D;
			}

			if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
				d1 = pos.getX() - 0.0625D;
			}

			if (d1 < pos.getX() || d1 > pos.getX() + 1 || d2 < 0.0D || d2 > pos.getY() + 1 || d3 < pos.getZ()
			        || d3 > pos.getZ() + 1) {
				if (rand.nextInt(10) <= 5) {
					DivineRPG.proxy.spawnParticle(worldIn, DRPGParticleTypes.FROST, d1, d2, d3, 0.0D, 0.5D, 0.0D);
				}
			}
		}
	}

	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
}
