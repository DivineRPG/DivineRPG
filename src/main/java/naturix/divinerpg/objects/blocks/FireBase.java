package naturix.divinerpg.objects.blocks;

import java.util.ArrayList;
import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireBase extends BlockFire implements IHasModel {

	protected ArrayList<PortalBase> portals = new ArrayList<PortalBase>();
	protected String name;

	public FireBase(String name) { // TODO
		super();
		this.name = name;
		setLightLevel(1.0F);
		setCreativeTab(null);
		setUnlocalizedName(name);
		this.setRegistryName(name);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public void addPortal(PortalBase portal) {
		portals.add(portal);
	}

	protected boolean canNeighborBurn(World world, BlockPos pos) {
		return this.canCatchFire(world, pos.west()) || this.canCatchFire(world, pos.east())
		        || this.canCatchFire(world, pos.up()) || this.canCatchFire(world, pos.down())
		        || this.canCatchFire(world, pos.south()) || this.canCatchFire(world, pos.north());
	}

	protected void lightPortal(World world, BlockPos pos, IBlockState state) {
		if (this == ModBlocks.blueFire) {
			ModBlocks.edenPortal.makePortal(world, pos);
			ModBlocks.wildwoodPortal.makePortal(world, pos);
			ModBlocks.apalachiaPortal.makePortal(world, pos);
			ModBlocks.skythernPortal.makePortal(world, pos);
			ModBlocks.mortumPortal.makePortal(world, pos);
		} else {
			ModBlocks.iceikaPortal.makePortal(world, pos);
		}
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		lightPortal(world, pos, state);
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		lightPortal(worldIn, pos, state);
		if (worldIn.getGameRules().getBoolean("doFireTick")) {
			if (!worldIn.isAreaLoaded(pos, 2)) {
				return; // Forge: prevent loading unloaded chunks when spreading fire
			}
			if (!this.canPlaceBlockAt(worldIn, pos)) {
				worldIn.setBlockToAir(pos);
			}

			Block block = worldIn.getBlockState(pos.down()).getBlock();
			boolean flag = block.isFireSource(worldIn, pos.down(), EnumFacing.UP);

			int i = state.getValue(AGE).intValue();

			if (!flag && worldIn.isRaining() && this.canDie(worldIn, pos) && rand.nextFloat() < 0.2F + i * 0.03F) {
				worldIn.setBlockToAir(pos);
			} else {
				if (i < 15) {
					state = state.withProperty(AGE, Integer.valueOf(i + rand.nextInt(3) / 2));
					worldIn.setBlockState(pos, state, 4);
				}

				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));

				if (!flag) {

					if (!this.canCatchFire(worldIn, pos.down(), EnumFacing.UP) && i == 15 && rand.nextInt(4) == 0) {
						worldIn.setBlockToAir(pos);
						return;
					}
				}

				boolean flag1 = worldIn.isBlockinHighHumidity(pos);
				if (flag1) {
				}

				for (int k = -1; k <= 1; ++k) {
					for (int l = -1; l <= 1; ++l) {
						for (int i1 = -1; i1 <= 4; ++i1) {
							if (k != 0 || i1 != 0 || l != 0) {
								if (i1 > 1) {
								}

								pos.add(k, i1, l);
							}
						}
					}
				}
			}
		}
	}

}