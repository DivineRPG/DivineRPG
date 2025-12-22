package divinerpg.blocks.vethea;

import divinerpg.blocks.base.SimplePortalBlock;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.DimensionTransition;

public class VetheaPortal extends SimplePortalBlock {
	public VetheaPortal() {
		super(LevelRegistry.VETHEA, LevelRegistry.MORTUM, BlockRegistry.mortumBlock.get(), null);
	}

	@Override
	public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
		if(level.dimension() == rootDimension && entity instanceof ServerPlayer p) {
			DimensionTransition d = p.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);
			if(d.missingRespawnBlock()) p.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.NO_RESPAWN_BLOCK_AVAILABLE, 0F));
			return d;
		} UniversalPosition target = getTargetLocation(level, entity, pos);
		if(target == null) return null;
		ServerLevel targetLevel = target.level(level.getServer());
		BlockPos targetPosition = target.blockPos();
		for(int tries = 0; tries < 10; tries++) if(hasRoomForPortal(targetLevel, pos = applyPlacementLocationPreference(targetLevel, entity, targetPosition.offset((int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)), 0, (int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)))))) break;
		return transitionTo(level.getServer(), entity, new UniversalPosition(targetLevel.dimension(), pos));
	}
	@Override
	public boolean hasRoomForPortal(ServerLevel level, BlockPos pos) {
		return level.getBlockState(pos).isAir() || level.getBlockState(pos.above()).isAir();
	}
}