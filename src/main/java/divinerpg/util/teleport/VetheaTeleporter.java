package divinerpg.util.teleport;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.util.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

public class VetheaTeleporter implements ITeleporter {

    public static final int PORTAL_SEARCH_CHUNK_RADIUS = 4;

    protected ServerWorld world;
    protected Random random = new Random();

    public VetheaTeleporter(ServerWorld var1) {
        this.world = var1;
    }

    public void placeInPortal(Entity entity, float rotationYaw) {
        int chunkX;
        int chunkZ;

        if (this.world.dimension().equals(KeyRegistry.VETHEA_WORLD)) {
            chunkX = (MathHelper.floor(entity.getX()) & ~0xf) / 16;
            chunkZ = (MathHelper.floor(entity.getZ()) & ~0xf) / 16;
            if (!(this.placeInExistingPortal(entity, rotationYaw))) {
                this.makePortalAt(world, entity.blockPosition().getX(), entity.blockPosition().getY(), entity.blockPosition().getZ());
                this.placeInExistingPortal(entity, rotationYaw);
            }
        }
        else {
            //Adjust player position for +8 anti-cascading offset first
            chunkX = ((MathHelper.floor(entity.getX()) - 8) & ~0xf) / 16;
            chunkZ = ((MathHelper.floor(entity.getZ()) - 8) & ~0xf) / 16;

            BlockPos pos = locateOverworldPortal(this.world, chunkX, chunkZ);
                if(pos == null && entity instanceof ServerPlayerEntity) {
                    ServerPlayerEntity player = (ServerPlayerEntity) entity;
                    if (player.getRespawnPosition() != null) {
                        BlockPos spawnPoint = player.getRespawnPosition();
//                        entity.teleportTo(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ());
                    }
                }
            else {
//                entity.teleportTo(pos.getX() + random.nextInt(3), getTopBlock(world, pos) + 1, pos.getZ() + random.nextInt(3));
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
                    if(world.getBlockState(searchPos).getBlock() == BlockRegistry.vetheaPortal) {
                        return searchPos;
                    }
                    if(world.getBlockState(searchPos).getBlock() == BlockRegistry.nightmareBed) {
                        return searchPos;
                    }
                }
            }
        }
        return null;
    }

    public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
        short searchRange = 200;
        double var10 = -1.0D;
        int var12 = 0;
        int var13 = 0;
        int var14 = 0;
        int entityPosX_floored = MathHelper.floor(entity.xo);
        int entityPosY = MathHelper.floor(entity.zo);
        double var24;

        for(int searchX = entityPosX_floored - searchRange; searchX <= entityPosX_floored + searchRange; ++searchX) {
            double var18 = searchX + 0.5D - entity.xo;

            for(int searchZ = entityPosY - searchRange; searchZ <= entityPosY + searchRange; ++searchZ) {
                double var21 = searchZ + 0.5D - entity.zo;

                for(int searchY = 64 - 1; searchY >= 0; --searchY) {
                    if(this.isBlockPortal(this.world, searchX, searchY, searchZ)) {
                        while(this.isBlockPortal(this.world, searchX, searchY - 1, searchZ)) {
                            --searchY;
                        }

                        var24 = searchY + 0.5D - entity.yo;
                        double var26 = var18 * var18 + var24 * var24 + var21 * var21;

                        if(var10 < 0.0D || var26 < var10) {
                            var10 = var26;
                            var12 = searchX;
                            var13 = searchY;
                            var14 = searchZ;
                        }
                    }
                }
            }
        }

        if(var10 >= 0.0D) {
            double var28 = var12 + 0.5D;
            double var22 = var13 + 0.5D;
            var24 = var14 + 0.5D;

            if(this.isBlockPortal(this.world, var12 - 1, var13, var14)) var28 -= 0.5D;

            if(this.isBlockPortal(this.world, var12 + 1, var13, var14)) var28 += 0.5D;

            if(this.isBlockPortal(this.world, var12, var13, var14 - 1)) var24 -= 0.5D;

            if(this.isBlockPortal(this.world, var12, var13, var14 + 1)) var24 += 0.5D;


            entity.moveTo(var28, var22 + 1.0D, var24 + 1.0D, rotationYaw, 0.0F);
            entity.setDeltaMovement(0, 0, 0);
            return true;
        } else
            return false;
    }


    public boolean isBlockPortal(World var1, int var2, int var3, int var4) {
        return var1.getBlockState(new BlockPos(var2, var3, var4)) == BlockRegistry.vetheaPortal.defaultBlockState();
    }


    private void makePortalAt(World world, int x, int y, int z) {

        y=16;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 6; k++) {
                    world.setBlock(new BlockPos(x+i-3, y+j+1, z+k-4), Blocks.AIR.defaultBlockState(), 0);
                }
            }
        }

        world.setBlock(new BlockPos(x + 1, y, z), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x, y, z), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 2, y, z), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 1, z - 1), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 1, z + 1), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 2, z - 2), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 2, z + 2), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 3, z + 1), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 3, z - 1), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 4, z), BlockRegistry.mortumBlock.defaultBlockState(), 0);
        world.setBlock(new BlockPos(x + 1, y + 1, z), BlockRegistry.vetheaPortal.defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
        world.setBlock(new BlockPos(x + 1, y + 2, z + 1), BlockRegistry.vetheaPortal.defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
        world.setBlock(new BlockPos(x + 1, y + 2, z), BlockRegistry.vetheaPortal.defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
        world.setBlock(new BlockPos(x + 1, y + 2, z - 1), BlockRegistry.vetheaPortal.defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
        world.setBlock(new BlockPos(x + 1, y + 3, z), BlockRegistry.vetheaPortal.defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
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
            entity.teleportTo(entity.getX(), 17, entity.getZ());
        }else{
            if(this.locateOverworldPortal(world, entity.xChunk, entity.zChunk) == null){
            entity.teleportTo(entity.getX(), getTopBlock(world, new BlockPos(entity.getX(), entity.getY(), entity.getZ())), entity.getZ());
            }else {
                entity.teleportTo(locateOverworldPortal(world, entity.xChunk, entity.zChunk).getX(), locateOverworldPortal(world, entity.xChunk, entity.zChunk).getY(), locateOverworldPortal(world, entity.xChunk, entity.zChunk).getZ());
            }
        }
        return entity;
    }

}