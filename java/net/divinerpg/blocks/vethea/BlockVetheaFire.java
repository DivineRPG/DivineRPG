package net.divinerpg.blocks.vethea;

import net.divinerpg.api.blocks.BlockModFire;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;

public class BlockVetheaFire extends BlockModFire {
	
	public BlockVetheaFire(String name) {
        super(name);
    }

    @Override
    protected void lightPortal(World world, int x, int y, int z) {
        BlockModPortal portal = (BlockModPortal) VetheaBlocks.vetheaPortal;
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.mortumBlock)) {
            LogHelper.debug("Mortum block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Vethea portal did not light");
        }
    }

}