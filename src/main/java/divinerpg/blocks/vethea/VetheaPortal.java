package divinerpg.blocks.vethea;

import divinerpg.blocks.base.SimplePortal;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.LevelRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.TeleportTransition;
import org.jetbrains.annotations.Nullable;

public class VetheaPortal extends SimplePortal {
    public VetheaPortal(Properties p) {
        super(p, LevelRegistry.VETHEA, LevelRegistry.MORTUM, BlockRegistry.mortumBlock.get(), null);
    }
    @Override @Nullable
    public TeleportTransition getSimpleConnection(ServerLevel level, Entity entity, BlockPos pos) {
        if(level.dimension() == rootDimension && entity instanceof ServerPlayer p) {
            TeleportTransition d = p.findRespawnPositionAndUseSpawnBlock(true, TeleportTransition.DO_NOTHING);
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