package divinerpg.utils.portals.description;

import divinerpg.dimensions.arcana.mazegen.ArcanaMazeGenerator;
import divinerpg.dimensions.arcana.mazegen.Cell;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.arcana.ArcanaStructureHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.ITeleporter;

import java.util.Random;

public class ArcanaTeleporter implements ITeleporter {

    protected WorldServer world;
    protected Random random = new Random();

    public ArcanaTeleporter(WorldServer var1) {
        this.world = var1;
    }

    public void placeInPortal(Entity entity, float rotationYaw) {
        int chunkX = (MathHelper.floor(entity.posX) & ~0xf) / 16;
        int chunkZ = (MathHelper.floor(entity.posZ) & ~0xf) / 16;

        if (this.world.provider.getDimensionType().getId() == DimensionRegistry.arcanaDimension.getId()) {
            if (!(this.placeInExistingPortal(entity, rotationYaw))) {
                this.makePortalRoom(chunkX, chunkZ);
                this.placeInExistingPortal(entity, rotationYaw);
            }
        }
        else {
            BlockPos spawnPoint = this.world.getTopSolidOrLiquidBlock(this.world.getSpawnPoint());
            entity.moveToBlockPosAndAngles(spawnPoint, entity.rotationYaw, entity.rotationPitch);
        }
    }

    public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
        if (this.world.provider.getDimensionType().getId() == DimensionRegistry.arcanaDimension.getId()) {

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
            if (this.world.getBlockState(new BlockPos(portalLocationX, portalLocationY, portalLocationZ)).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                entity.setLocationAndAngles(portalLocationX - 1.5D, portalLocationY, portalLocationZ + 1.5D, entity.rotationYaw, 0.0F);
                entity.motionX = entity.motionY = entity.motionZ = 0.0D;
                return true;
            }
            else {
                //Search in 15x15 region centered around portal
                BlockPos.MutableBlockPos searchPos = new BlockPos.MutableBlockPos();
                for(int searchX = portalLocationX - (7 * 16); searchX < portalLocationX + (7 * 16); searchX += 16) {
                    for (int searchZ = portalLocationZ - (7 * 16); searchZ < portalLocationZ + (7 * 16); searchZ += 16) {
                        searchPos.setPos(searchX, portalLocationY, searchZ);
                        if (this.world.getBlockState(searchPos).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                            entity.setLocationAndAngles(searchX - 1.5D, portalLocationY, searchZ + 1.5D, entity.rotationYaw, 0.0F);
                            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
                            return true;
                        }
                    }
                }
            }

            //No portal found, return false
            return false;
        }

        return false;
    }

    public void makePortalRoom(int chunkX, int chunkZ) {
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
    }

    public void placeEntity(World world, Entity entity, float yaw) {
        if (entity instanceof EntityPlayerMP) {
            this.placeInPortal(entity, yaw);
        } else {
            this.placeInExistingPortal(entity, yaw);
        }
    }
}