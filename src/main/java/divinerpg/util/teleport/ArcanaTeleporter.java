package divinerpg.util.teleport;

import divinerpg.*;
import divinerpg.registries.*;
import divinerpg.world.arcana.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.template.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.util.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

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

        if (this.world.dimension().equals(KeyRegistry.ARCANA_WORLD)) {
            chunkX = (MathHelper.floor(entity.getX()) & ~0xf) / 16;
            chunkZ = (MathHelper.floor(entity.getZ()) & ~0xf) / 16;
            if (!(this.placeInExistingPortal(entity, rotationYaw))) {
                this.makePortalRoom(chunkX, chunkZ);
                this.placeInExistingPortal(entity, rotationYaw);
            }
        }
        else {
            //Adjust player position for +8 anti-cascading offset first
            chunkX = ((MathHelper.floor(entity.getX()) - 8) & ~0xf) / 16;
            chunkZ = ((MathHelper.floor(entity.getZ()) - 8) & ~0xf) / 16;

            BlockPos pos = locateOverworldPortal(this.world, chunkX, chunkZ);
            if(pos == null) {
                BlockPos spawnPoint = null;
                if(entity instanceof ServerPlayerEntity) {
                    ServerPlayerEntity player = (ServerPlayerEntity) entity;
                    spawnPoint = player.getRespawnPosition();
                }
                if(spawnPoint == null) {
                    ServerPlayerEntity player = (ServerPlayerEntity) entity;
                    spawnPoint = player.getRespawnPosition();
                }
                entity.teleportTo(spawnPoint.getX(), getTopBlock(world, pos), spawnPoint.getZ());
            }
            else {
                    entity.teleportTo(pos.getX() + random.nextInt(3), getTopBlock(world, pos) + 1, pos.getZ() + random.nextInt(3));
            }
        }
    }
    protected int getTopBlock(World world, BlockPos pos) {
        int j;
        int y=-1;
        int k=0;
        boolean topBlock = false;
        for ( j=255; j>=63; j--) {
            if (!world.getBlockState(pos.offset(0, j, 0)).getBlock().equals(Blocks.AIR)) {
                topBlock=true;
                k++;
            }
            if (topBlock && (k==1)) {
                y=j;
            }
        }
        return y;
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
        if (this.world.dimension().equals(KeyRegistry.ARCANA_WORLD)) {
            //Convert player location to chunk

            int chunkX = entity.level.getChunk(entity.blockPosition()).getPos().x;
            int chunkZ = entity.level.getChunk(entity.blockPosition()).getPos().z;

            //Coordinates where portal frame should be. Accounts for constant +8 offset in chunk generator to prevent cascading
            int portalLocationX = (chunkX * 16) + 6 + 8;
            int portalLocationY = 9;
            int portalLocationZ = (chunkZ * 16) + 5 + 8;

            // Find existing portal, first check the room corresponding to the chunk as this covers the most likely cases
            if (this.world.getBlockState(new BlockPos(portalLocationX, portalLocationY, portalLocationZ)).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                entity.moveTo(portalLocationX + 1.5D, portalLocationY, portalLocationZ + 2.5D, rotationYaw, 0.0F);
                entity.xo = entity.yo = entity.zo = 0.0D;
                return true;
            }
            else {
                //Search in 15x15 chunk region centered around portal
                BlockPos.Mutable searchPos = new BlockPos.Mutable();
                for(int searchX = portalLocationX - (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchX < portalLocationX + (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchX += 16) {
                    for (int searchZ = portalLocationZ - (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchZ < portalLocationZ + (PORTAL_SEARCH_CHUNK_RADIUS * 16); searchZ += 16) {
                        searchPos.set(searchX, portalLocationY, searchZ);
                        if (this.world.getBlockState(searchPos).getBlock() == BlockRegistry.arcanaHardPortalFrame) {
                            entity.moveTo(searchX + 1.5D, portalLocationY, searchZ + 2.5D, rotationYaw, 0.0F);
                            entity.xo = entity.yo = entity.zo = 0.0D;
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

        int x = chunkX * 16;
        int z = chunkZ * 16;
        BlockPos pos = new BlockPos(x, 0, z);
        Biome biome = world.getBiome(pos.offset(16, 0, 16));
        long worldSeed = world.getSeed();
        ArcanaStructureHandler portalRoom = ArcanaRooms.getPortalRoomByType(cell.getPieceType());
        Rotation rotation;
        Template template = world.getLevel().getStructureManager().get(new ResourceLocation(DivineRPG.MODID, portalRoom.getName()));

        world.getRandom().setSeed(world.getSeed());
        long k = world.getRandom().nextLong() / 2L * 2L + 1L;
        long l = world.getRandom().nextLong() / 2L * 2L + 1L;
        world.getRandom().setSeed((long) chunkX * k + (long) chunkZ * l ^ world.getSeed());


        if(world.getBlockState(new BlockPos(x + 8, 8, z + 8)).getBlock() == Blocks.AIR) {
            if(cell.getPieceType() == Cell.PieceType.CROSSROADS) {
                rotation = Rotation.values()[world.getRandom().nextInt(4)];
            } else {
                rotation = cell.getRotation();
            }

            BlockPos adjustedPosition = adjustForRotation(pos, template.getSize(), rotation);
            if (template != null && portalRoom.getName() != null ) {
                template.placeInWorld(world,
                        adjustedPosition,
                        new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).setRotation(rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK),
                        world.getRandom());
            }
        }
    }
    private BlockPos adjustForRotation(BlockPos position, BlockPos size, Rotation rotation) {
        switch(rotation) {
            case NONE:
                return position;
            case CLOCKWISE_90:
                return position.offset(size.getZ() - 1, 0, 0);
            case CLOCKWISE_180:
                return position.offset(size.getX() - 1, 0, size.getZ() - 1);
            case COUNTERCLOCKWISE_90:
                return position.offset(0, 0, size.getX() - 1);
            default:
                DivineRPG.LOGGER.warn("Invalid structure rotation passed in somehow, please report this.");
                return position;
        }
    }
    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (entity instanceof ServerPlayerEntity) {
            this.placeInPortal(entity, yaw);
        } else {
            this.placeInExistingPortal(entity, yaw);
        }

        entity.setPortalCooldown();
        entity = repositionEntity.apply(false);
        if(destWorld!= entity.level.getServer().getLevel(World.OVERWORLD)) {
            entity.teleportTo(entity.getX(), 2, entity.getZ());
        }else{
            entity.teleportTo(entity.getX(), getTopBlock(world, new BlockPos(entity.getX(), entity.getY(), entity.getZ())), entity.getZ());
        }
        return entity;
    }

}