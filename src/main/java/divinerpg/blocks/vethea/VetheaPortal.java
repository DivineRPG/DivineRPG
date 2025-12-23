package divinerpg.blocks.vethea;

import divinerpg.blocks.base.SimplePortalBlock;
import divinerpg.registries.*;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.DimensionTransition;
import org.jetbrains.annotations.Nullable;

public class VetheaPortal extends SimplePortalBlock {
	public VetheaPortal() {
		super(LevelRegistry.VETHEA, LevelRegistry.MORTUM, BlockRegistry.mortumBlock.get(), null);
	}
	@Override @Nullable
	public DimensionTransition getSimpleConnection(ServerLevel level, Entity entity, BlockPos pos) {
		if(level.dimension() == rootDimension && entity instanceof ServerPlayer p) {
			DimensionTransition d = p.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.DO_NOTHING);
			if(d.missingRespawnBlock()) p.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.NO_RESPAWN_BLOCK_AVAILABLE, 0F));
			return d;
		} return null;
	}
	@Override
	public boolean hasSpace(ServerLevel level, BlockPos pos) {
		return level.getBlockState(pos).isAir() || level.getBlockState(pos.above()).isAir();
	}
	@Override @Nullable public BlockPos lookForNearbyPortal(ServerLevel level, Entity entity, BlockPos center) {return null;}
	@Override public void link(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos) {}
	@Override public BlockPos placeAndLink(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos, Entity entity) {return targetPos;}
}