package net.divinerpg.blocks.iceika;

import net.divinerpg.api.blocks.BlockModFire;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockIceikaFire extends BlockModFire {
	
	public BlockIceikaFire(String name) {
		super(name);
	}

	@Override
    protected void lightPortal(World world, int x, int y, int z) {
		BlockModPortal portal = (BlockModPortal) IceikaBlocks.portal;
		if (world.getBlock(x, y - 1, z).equals(Blocks.snow)) {
			LogHelper.debug("Snow lit");
			if (!portal.tryCreatePortal(world, x, y, z))
				LogHelper.debug("Iceika portal did not light");
		}
	}
}
