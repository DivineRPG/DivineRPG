package divinerpg.blocks.vethea;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.ENT;
import static net.minecraft.world.entity.EntitySpawnReason.MOB_SUMMONED;

public class VetheaLog extends RotatedPillarBlock {

    public VetheaLog(MapColor color, SoundType sound, Properties p) { super(p.mapColor(color).sound(sound)); }
    public VetheaLog(MapColor top, MapColor side, SoundType sound, Properties p) { super(p.mapColor(top).sound(sound)); }

    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if(!level.isClientSide()) ENT.get().spawn(level, destroyedWith, player, pos, MOB_SUMMONED, true, false);
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }
}