package divinerpg.util.teleport;

import divinerpg.blocks.base.BlockModPortal;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.*;

import org.jetbrains.annotations.Nullable;

import java.util.function.*;

public class VetheaTeleporter implements ITeleporter {
	private boolean isPortalTravel;
	public VetheaTeleporter(boolean isPortalTravel) {
		this.isPortalTravel = isPortalTravel;
	}
	@Override public boolean isVanilla() {return false;}
	@Override
	public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
		player.playSound(SoundRegistry.VETHEA_TELEPORT.get(), 1F, 1F);
		return false;
	}
	@Override @Nullable
	public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
		if(entity instanceof ServerPlayer && !((ServerPlayer) entity).isOnPortalCooldown()) {
			ServerPlayer player = (ServerPlayer) entity;
			player.setPortalCooldown();

			if(destWorld.dimension() == LevelRegistry.VETHEA && !isPortalTravel) {
				//teleport to vethea without creating portal, cap Y to 50
				MutableBlockPos mut = new MutableBlockPos(entity.blockPosition().getX(), Math.min(destWorld.getMinBuildHeight() + 1, 50), entity.blockPosition().getZ());

				// Ensure Y position doesn't exceed 50 while searching for air blocks
				while(!destWorld.getBlockState(mut).isAir() && mut.getY() < 50) mut.move(Direction.UP);

				// Adjust to ensure correct landing location
				while(!destWorld.getBlockState(mut.above()).isAir() || !destWorld.getBlockState(mut).isAir() || destWorld.getBlockState(mut.below()).isAir()) mut.move(Direction.NORTH);

				return new PortalInfo(new Vec3(mut.getX() + (entity.getX() % 1), mut.getY() + .5, mut.getZ() + (entity.getZ() % 1)), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
			}

			if(destWorld.dimension() == LevelRegistry.VETHEA && !isPortalTravel) {
				//teleport to vethea without creating portal. only return through death (waking up) or creating a portal
				MutableBlockPos mut = new MutableBlockPos(entity.blockPosition().getX(), destWorld.getMinBuildHeight() + 1, entity.blockPosition().getZ());
				while(!destWorld.getBlockState(mut).isAir() && mut.getY() < 35) mut.move(Direction.UP);
				while(!destWorld.getBlockState(mut.above()).isAir() || !destWorld.getBlockState(mut).isAir() || destWorld.getBlockState(mut.below()).isAir()) mut.move(Direction.NORTH);
				return new PortalInfo(new Vec3(mut.getX() + (entity.getX() % 1), mut.getY() + .5, mut.getZ() + (entity.getZ() % 1)), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
			}
			//search for existing portal
			ChunkPos chunkPos = new ChunkPos(entity.blockPosition());
			int chunkX = chunkPos.x, chunkZ = chunkPos.z;
	    	for(int currentChunkX = chunkX - 4; currentChunkX < chunkX + 4; currentChunkX++) for(int currentChunkZ = chunkZ - 4; currentChunkZ < chunkZ + 4; currentChunkZ++) {
	    		MutableBlockPos searchPos = new MutableBlockPos();
	            int baseX = chunkX * 16, baseZ = chunkZ * 16;
	            for(int y = 0; y < 256; y++) for(int x = 0; x < 16; x++) for(int z = 0; z < 16; z++) {
	                searchPos.set(baseX + x, y, baseZ + z);
	                BlockState searchState = destWorld.getBlockState(searchPos).getBlock().defaultBlockState();
	                if(searchState == BlockRegistry.vetheaPortal.get().defaultBlockState()
	                		|| searchState == BlockRegistry.nightmareBed.get().defaultBlockState()) {
	                	return new PortalInfo(new Vec3(searchPos.getX() + (entity.getX() % 1), searchPos.getY() - (isBlockPortal(destWorld, searchPos.getX(), searchPos.getY() - 1, searchPos.getZ()) ? 1 : 0), searchPos.getZ() + (entity.getZ() % 1)), Vec3.ZERO, entity.getYRot(), entity.getXRot());
	                }
	            }
	        }
			//wake back up at your spawnpoint
			if(player.getRespawnPosition() != null && player.getRespawnDimension() == destWorld.dimension()) return new PortalInfo(new Vec3(player.getRespawnPosition().getX(), player.getRespawnPosition().getY(), player.getRespawnPosition().getZ()), Vec3.ZERO, player.getRespawnAngle(), player.getRespawnAngle());
	    	//create new portal
	    	MutableBlockPos pos = entity.blockPosition().mutable();
	    	while(!destWorld.getBlockState(pos).isAir()) pos.move(Direction.UP);
			int x = pos.getX(), y = pos.getY(), z = pos.getZ();
	        for(int i = 0; i < 5; i++) for(int j = 0; j < 5; j++) for(int k = 0; k < 6; k++) destWorld.setBlock(new BlockPos(x + i - 3, y + j + 1, z + k - 4), Blocks.AIR.defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y, z), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x, y, z), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 2, y, z), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 1, z - 1), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 1, z + 1), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 2, z - 2), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 2, z + 2), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 3, z + 1), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 3, z - 1), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 4, z), BlockRegistry.mortumBlock.get().defaultBlockState(), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 1, z), BlockRegistry.vetheaPortal.get().defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 2, z + 1), BlockRegistry.vetheaPortal.get().defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 2, z), BlockRegistry.vetheaPortal.get().defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 2, z - 1), BlockRegistry.vetheaPortal.get().defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
	        destWorld.setBlock(new BlockPos(x + 1, y + 3, z), BlockRegistry.vetheaPortal.get().defaultBlockState().setValue(BlockModPortal.AXIS, Direction.Axis.Z), 0);
	    	return new PortalInfo(new Vec3(pos.getX(), pos.getY(), pos.getZ()), Vec3.ZERO, entity.getYRot(), entity.getXRot());
		} return null;
	}
	public boolean isBlockPortal(ServerLevel var1, int var2, int var3, int var4) {
        return var1.getBlockState(new BlockPos(var2, var3, var4)).getBlock().defaultBlockState() == BlockRegistry.vetheaPortal.get().defaultBlockState();
    }
}