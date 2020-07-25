package divinerpg.utils.portals.description;

import divinerpg.dimensions.arcana.mazegen.ArcanaMazeGenerator;
import divinerpg.dimensions.arcana.mazegen.Cell;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.arcana.ArcanaStructureHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ArcanaTeleporter extends Teleporter {

    protected WorldServer world;

    public ArcanaTeleporter(WorldServer var1) {
        super(var1);
        this.world = var1;
    }

    @Override
    public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
        System.out.println("this isn't even called at all what a waste");
        if (entity.dimension == DimensionRegistry.arcanaDimension.getId()) {
            //Convert player location to chunk
            int chunkX = (MathHelper.floor(entity.posX) & ~0xf) / 16;
            int chunkZ = (MathHelper.floor(entity.posZ) & ~0xf) / 16;

            System.out.println("Entity coordinates " + entity.posX + " " + entity.posZ);
            System.out.println("Chunk coordinates " + chunkX + " " + chunkZ);
            //Coordinates where portal frame should be. Accounts for constant +8 offset in chunk generator to prevent cascading
            int portalLocationX = (chunkX * 16) + 6 + 8;
            int portalLocationY = 9;
            int portalLocationZ = (chunkZ * 16) + 5 + 8;

            // Find existing portal, first check the room corresponding to the chunk as this covers the most likely cases
            //NEED TO EXPAND SEARCH RADIUS
            if (this.world.getBlockState(new BlockPos(portalLocationX, portalLocationY, portalLocationZ)).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                entity.setLocationAndAngles(portalLocationX - 1.5D, portalLocationY, portalLocationZ + 1.5D, entity.rotationYaw, 0.0F);
                entity.motionX = entity.motionY = entity.motionZ = 0.0D;
                return true;
            }

            //Search in 15x15 region centered around portal, but not if it goes outside maze bounds

            System.out.println("reached");
            // Since there is no existing portal, create a new portal room
            Cell cell = ArcanaMazeGenerator.obtainMazePiece(chunkX, chunkZ, this.world.getSeed());
            ArcanaStructureHandler portalRoom = null;
            switch (cell.getPieceType()) {
                case CROSSROADS:
                    portalRoom = StructureRegistry.CROSSROADS_PORTAL_TEST;
                    break;
                case THREE_WAY:
                    portalRoom = StructureRegistry.JUNCTION_PORTAL_TEST;
                    break;
                case CORNER:
                    portalRoom = StructureRegistry.CORNER_PORTAL_TEST;
                    break;
                case HALLWAY:
                    portalRoom = StructureRegistry.HALLWAY_PORTAL_TEST;
                    break;
                case DEAD_END:
                    portalRoom = StructureRegistry.DEAD_END_PORTAL_TEST;
                    break;
            }
            portalRoom.generateWithRotation(this.world, this.random, new BlockPos(chunkX * 16 + 8, 8, chunkZ * 16 + 8), cell.getRotation());
            entity.setLocationAndAngles(portalLocationX - 1D, portalLocationY, portalLocationZ -1D, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            return true;
        }

        return false;
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        return false;
    }
}