package net.divinerpg.blocks.twilight;

import net.divinerpg.api.blocks.BlockModFire;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.helper.blocks.TwilightBlocks;
import net.divinerpg.helper.utils.LogHelper;
import net.minecraft.world.World;

public class BlockBlueFire extends BlockModFire {

    public BlockBlueFire(String name) {
        super(name);
    }

    @Override
    protected void lightPortal(World world, int x, int y, int z) {
        BlockModPortal portal = (BlockModPortal) TwilightBlocks.edenPortal;
//        int id = world.provider.dimensionId;
//        if(id > 0 || !portal.isPortalCorrectSize(world, x, y, z)){
//            LogHelper.debug("Eden portal");
//            if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) world.setBlockToAir(x, y, z);
//            else world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
//        }
//        portal = (BlockModPortal) TwilightBlocks.wildWoodPortal;
//        if(id > 0 || !portal.isPortalCorrectSize(world, x, y, z)){
//            LogHelper.debug("Wildwood portal");
//            if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) world.setBlockToAir(x, y, z);
//            else world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
//        }
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.edenBlock)) {
            LogHelper.debug("Eden block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Eden portal did not light");
        }
        portal = (BlockModPortal) TwilightBlocks.wildWoodPortal;
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.wildWoodBlock)) {
            LogHelper.debug("Eden block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Eden portal did not light");
        }
    }

}
