package divinerpg.blocks.vethea;

import divinerpg.blocks.base.SimplePortalBlock;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.DimensionTransition;
import org.jetbrains.annotations.NotNull;

public class VetheaPortal extends SimplePortalBlock {
	public VetheaPortal() {
		super(LevelRegistry.VETHEA, LevelRegistry.MORTUM, BlockRegistry.mortumBlock.get(), null);
	}
	@Override
	public UniversalPosition getTargetLocation(ServerLevel source, Entity entity, BlockPos pos) {
		if(source.dimension() == rootDimension && entity instanceof ServerPlayer p) {
			DimensionTransition d = p.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);
			if(d != null) {
				if(d.missingRespawnBlock()) p.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.NO_RESPAWN_BLOCK_AVAILABLE, 0F));
				return new UniversalPosition(d.newLevel(), d.pos());
			}
		} return super.getTargetLocation(source, entity, pos);
	}
	@Override
	public @NotNull BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
		return level.dimension() != rootDimension && entity instanceof ServerPlayer ? pos : super.applyPlacementLocationPreference(level, entity, pos).above();
	}
	@Override
	public boolean hasRoomForPortal(ServerLevel level, BlockPos pos) {
		return level.getBlockState(pos).isAir() || level.getBlockState(pos.above()).isAir();
	}
	@Override
	public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {
		return pos;
	}
}