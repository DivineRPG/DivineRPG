package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BeaconBaseBase extends BlockBase {
	public boolean isBeaconBase = Config.isBeaconBase;
	protected String name;

	public BeaconBaseBase(Material material, String name) {
		super(Material.ROCK, name);
		setCreativeTab(DivineRPG.BlocksTab);
	}

	@Override
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon) {
		return isBeaconBase;
	}

	public BeaconBaseBase setBeaconBase(boolean b) {
		isBeaconBase = b;
		return this;
	}

}