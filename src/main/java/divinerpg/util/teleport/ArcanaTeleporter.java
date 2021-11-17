package divinerpg.util.teleport;

import divinerpg.registries.*;
import divinerpg.world.arcana.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.util.*;

import javax.annotation.*;
import java.util.*;

public class ArcanaTeleporter implements ITeleporter {
    public static final int PORTAL_SEARCH_CHUNK_RADIUS = 4;

    protected ServerWorld world;
    protected Random random = new Random();

    public ArcanaTeleporter(ServerWorld var1) {
        this.world = var1;
    }

    public void placeInPortal(Entity entity, float rotationYaw) {
        int chunkX;
        int chunkZ;

        if (this.world.dimension() == KeyRegistry.ARCANA_WORLD) {
            chunkX = (MathHelper.floor(entity.xo) & ~0xf) / 16;
            chunkZ = (MathHelper.floor(entity.zo) & ~0xf) / 16;
            if (!(this.placeInExistingPortal(entity, rotationYaw))) {
                Cell cell = ArcanaMazeGenerator.obtainMazePiece(chunkX, chunkZ, this.world.getSeed());
                Structure<?> portalRoom = ArcanaRooms.getPortalRoomByType(cell.getPieceType());
                //TODO - generate portal room
//        portalRoom.generateWithRotation(this.world, this.random, new BlockPos(chunkX * 16 + 8, 8, chunkZ * 16 + 8), cell.getRotation());
                this.placeInExistingPortal(entity, rotationYaw);
            }
        }
        else {
            //Adjust player position for +8 anti-cascading offset first
            chunkX = ((MathHelper.floor(entity.xo) - 8) & ~0xf) / 16;
            chunkZ = ((MathHelper.floor(entity.zo) - 8) & ~0xf) / 16;

            BlockPos pos = locateOverworldPortal(this.world, chunkX, chunkZ);
            if(pos == null) {
                BlockPos spawnPoint = null;
                if(entity instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity)entity;
                    spawnPoint = player.getSleepingPos().get();
                }
                if(spawnPoint == null) {
                    spawnPoint = world.getSharedSpawnPos();
                }
                entity.moveTo(spawnPoint, entity.xRot, entity.yRot);
            }
            else {
                entity.moveTo(pos, entity.xRot, entity.yRot);
            }
        }
    }

    private BlockPos locateOverworldPortal(World world, int chunkX, int chunkZ) {
        //Attempt to locate portal within chunks, going outwards
        BlockPos pos = null;
        for (int radius = 0; radius <= PORTAL_SEARCH_CHUNK_RADIUS; radius++) {
            pos = locatePortalByRadius(world, chunkX, chunkZ, radius);
            if (pos != null) {
                break;
            }
        }
        return pos;
    }

    @Nullable
    private BlockPos locatePortalByRadius(World world, int chunkX, int chunkZ, int radius) {
        //Check all chunks a <radius> distance from chunkX
        //Yeah it's messy but it's the efficient enough

        for(int currentChunkX = chunkX - radius; currentChunkX <= chunkX + radius; currentChunkX++) {
            BlockPos result = locatePortalInChunk(world, currentChunkX, chunkZ - radius);
            if(result != null) {
                return result;
            }

            result = locatePortalInChunk(world, currentChunkX, chunkZ + radius);
            if(result != null) {
                return result;
            }
        }

        for(int currentChunkZ = chunkZ - radius + 1; currentChunkZ <= chunkZ + radius - 1; currentChunkZ++) {
            BlockPos result = locatePortalInChunk(world, chunkX - radius, currentChunkZ);
            if(result != null) {
                return result;
            }

            result = locatePortalInChunk(world, chunkX + radius, currentChunkZ);
            if(result != null) {
                return result;
            }
        }

        return null;
    }

    @Nullable
    private BlockPos locatePortalInChunk(World world, int chunkX, int chunkZ) {
        BlockPos.Mutable searchPos = new BlockPos.Mutable();
        int baseX = chunkX * 16;
        int baseZ = chunkZ * 16;
        for(int y = 0; y < 256; y++) {
            for(int x = 0; x < 16; x++) {
                for(int z = 0; z < 16; z++) {
                    searchPos.set(baseX + x, y, baseZ + z);
                    if(world.getBlockState(searchPos).getBlock() == BlockRegistry.arcanaPortal) {
                        return searchPos;
                    }
                }
            }
        }
        return null;
    }

    public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
        if (this.world.dimension() == KeyRegistry.ARCANA_WORLD) {
            //Convert player location to chunk
            int chunkX = (MathHelper.floor(entity.xo) & ~0xf) / 16;
            int chunkZ = (MathHelper.floor(entity.zo) & ~0xf) / 16;

            //Coordinates where portal frame should be. Accounts for constant +8 offset in chunk generator to prevent cascading
            int portalLocationX = (chunkX * 16) + 6 + 8;
            int portalLocationY = 9;
            int portalLocationZ = (chunkZ * 16) + 5 + 8;

            // Find existing portal, first check the room corresponding to the chunk as this covers the most likely cases
            if (this.world.getBlockState(new BlockPos(portalLocationX, portalLocationY, portalLocationZ)).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                entity.moveTo(portalLocationX + 1.5D, portalLocationY, portalLocationZ + 2.5D, entity.yRot, 0.0F);
                entity.setDeltaMovement(0, 0 , 0);
                return true;
            }
            else {
                //Search in 15x15 chunk region centered around portal
                BlockPos.Mutable searchPos = new BlockPos.Mutable();
                for(int searchX = portalLocationX - (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchX < portalLocationX + (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchX += 16) {
                    for (int searchZ = portalLocationZ - (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchZ < portalLocationZ + (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchZ += 16) {
                        searchPos.move(searchX, portalLocationY, searchZ);
                        if (this.world.getBlockState(searchPos).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                            entity.moveTo(searchX + 1.5D, portalLocationY, searchZ + 2.5D, entity.yRot, 0.0F);
                            entity.setDeltaMovement(0, 0, 0);
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

    public void placeEntity(World world, Entity entity, float yaw) {
        if (entity instanceof ServerPlayerEntity) {
            this.placeInPortal(entity, yaw);
        } else {
            this.placeInExistingPortal(entity, yaw);
        }
    }
}