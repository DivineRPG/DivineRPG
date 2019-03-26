package naturix.divinerpg.objects.blocks.vanilla;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.objects.blocks.itemblock.IMetaName;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.handlers.EnumHandler.OreType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetherite extends BlockMod implements IHasModel, IMetaName {

	public BlockNetherite(String name) {
		super(Material.ROCK, name);
		setTickRandomly(true);

		setHardness(3f);
		setResistance(5f);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public void detectInBB(BlockPos pos, World world) {
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		AxisAlignedBB extendBB = new AxisAlignedBB(x - 0.1, y - 0.1, z - 0.1, x + 1.1, y + 1.1, z + 1.1);
		world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
		for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
			if (entity instanceof EntityLivingBase) {
				entity.attackEntityFrom(DamageSource.GENERIC, 1);
			}
		}
		world.getEntitiesWithinAABB(EntityItem.class, extendBB);
		for (EntityItem entityItem : world.getEntitiesWithinAABB(EntityItem.class, extendBB)) {
			entityItem.attackEntityFrom(DamageSource.ON_FIRE, 10);
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return OreType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, 5);
	}

	/**
	 * @Override protected BlockStateContainer createBlockState() { return new
	 *           BlockStateContainer(this, new IProperty[] { TYPE }); }
	 *
	 * @Override public int damageDropped(IBlockState state) { return
	 *           getMetaFromState(state); }
	 *
	 * @Override public int getMetaFromState(IBlockState state) { OreType type =
	 *           (OreType) state.getValue(TYPE); return type.getID(); }
	 *
	 * @Override public ItemStack getPickBlock(IBlockState state, RayTraceResult
	 *           target, World world, BlockPos pos, EntityPlayer player) { return
	 *           new ItemStack(Item.getItemFromBlock(this), 1,
	 *           getMetaFromState(state)); }
	 *
	 * @Override public IBlockState getStateFromMeta(int meta) { return
	 *           this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
	 *           }
	 *
	 *           public void getSubBlocks(Item itemIn, CreativeTabs tab,
	 *           NonNullList<ItemStack> list) { for (int i = 0; i <
	 *           OreType.values().length; i++) { list.add(new ItemStack(itemIn, 1,
	 *           i)); } }
	 */

	@Override
	public void registerModels() {
		for (int i = 0; i < OreType.values().length; i++) {
			DivineRPG.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
			        this.name + "_" + OreType.values()[i].getName(), "inventory");
		}
	}

	@Override
	public int tickRate(World worldIn) {
		return 5;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		detectInBB(pos, world);
		world.scheduleUpdate(pos, this, 5);
	}
}