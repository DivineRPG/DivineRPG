package divinerpg.objects.blocks.vanilla;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockModFence extends BlockFence  {
	public BlockModFence(MapColor mapColor, String name) {
		super(Material.WOOD, mapColor);
		setUnlocalizedName(name);
		setRegistryName(DivineRPG.MODID, name);
		this.setCreativeTab(DivineRPGTabs.BlocksTab);
	}

	public BlockModFence(String name) {
		this(MapColor.WOOD, name);
	}

	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		BlockPos other = pos.offset(facing);
		Block block = world.getBlockState(other).getBlock();

		return block instanceof BlockFence || block instanceof BlockFenceGate;
	}
}
