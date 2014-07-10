package net.divinerpg.blocks.twilight;

import net.divinerpg.api.blocks.BlockModFire;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockBlueFire extends BlockModFire {

    public BlockBlueFire(String name) {
        super(name);
    }

    @Override
    protected void lightPortal(World world, int x, int y, int z) {
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
        BlockModPortal portal = (BlockModPortal) TwilightBlocks.edenPortal;
        if (world.getBlock(x, y - 1, z).equals(VanillaBlocks.divineRock)) {
            LogHelper.debug("Divine Rock lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Eden portal did not light");
        }
        portal = (BlockModPortal) TwilightBlocks.wildwoodPortal;
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.edenBlock)) {
            LogHelper.debug("Eden block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Wildwood portal did not light");
        }
        portal = (BlockModPortal) TwilightBlocks.apalachiaPortal;
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.wildwoodBlock)) {
            LogHelper.debug("Wildwood block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Apalachia portal did not light");
        }
        portal = (BlockModPortal) TwilightBlocks.skythernPortal;
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.apalachiaBlock)) {
            LogHelper.debug("Apalachia block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Skythern portal did not light");
        }
        portal = (BlockModPortal) TwilightBlocks.mortumPortal;
        if (world.getBlock(x, y - 1, z).equals(TwilightBlocks.skythernBlock)) {
            LogHelper.debug("Skythern block lit");
            if (!portal.tryCreatePortal(world, x, y, z))
                LogHelper.debug("Mortum portal did not light");
        }
    }

}
