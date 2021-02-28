package divinerpg.world.teleporter;


import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;

public class EdenTeleporter
{
    public static void changeDimension(RegistryKey<World> type, Entity entity, BlockPos pos)
    {
        MinecraftServer server = LogicalSidedProvider.INSTANCE.get(LogicalSide.SERVER);

        if (server == null)
            return;

        RegistryKey<World> transferDimension = entity.world.getDimensionKey() == type ? World.OVERWORLD : type;
        ServerWorld transferWorld = server.getWorld(transferDimension);

        if (!ForgeHooks.onTravelToDimension(entity, transferDimension))
            return;

        Entity teleportedEntity = teleportEntity(entity, transferWorld, pos);

        teleportedEntity.fallDistance = 0.0F;
    }

    private static Entity teleportEntity(Entity entity, ServerWorld transferWorld, BlockPos pos)
    {
        if (entity instanceof ServerPlayerEntity)
        {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;

            player.teleport(transferWorld, pos.getX(), pos.getY(), pos.getZ(), entity.rotationYaw, entity.rotationPitch);

            if (transferWorld.getDimensionKey() != World.OVERWORLD)
            {
                int maxY = entity.world.getHeight(Type.MOTION_BLOCKING, pos.getX(), pos.getZ());
                //int transferY = transferWorld.getDimensionKey() == World.OVERWORLD && entity instanceof ServerPlayerEntity && ((ServerPlayerEntity) entity).func_241140_K_(/*overworld*/) != null ? ((ServerPlayerEntity) entity).func_241140_K_(/*overworld*/).getY() : maxY;

                BlockPos endpointPos = new BlockPos(pos.getX() + 0.5, maxY, pos.getZ() + 0.5);

                for (int x = -1; x < 2; ++x)
                {
                    for (int z = -1; z < 2; ++z)
                    {
                        BlockPos newPos = new BlockPos(endpointPos.add(x, -1, z));
                        if (transferWorld.getBlockState(new BlockPos(newPos)).getBlock() == Blocks.LAVA || transferWorld.getBlockState(new BlockPos(newPos).up()).getBlock() == Blocks.LAVA)
                            transferWorld.setBlockState(newPos, Blocks.GRASS_BLOCK.getDefaultState());
                    }
                }

                player.setLocationAndAngles(endpointPos.getX(), endpointPos.getY(), endpointPos.getZ(), entity.rotationYaw, entity.rotationPitch);
            }

            return player;
        }

        entity.detach();
        entity.changeDimension(transferWorld);

        Entity teleportedEntity = entity.getType().create(transferWorld);

        if (teleportedEntity == null)
            return entity;

        teleportedEntity.copyDataFromOld(entity);
        teleportedEntity.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), entity.rotationYaw, entity.rotationPitch);
        teleportedEntity.setRotationYawHead(entity.rotationYaw);
        teleportedEntity.setMotion(Vector3d.ZERO);
        transferWorld.addFromAnotherDimension(teleportedEntity);
        entity.remove();

        return teleportedEntity;
    }
}
