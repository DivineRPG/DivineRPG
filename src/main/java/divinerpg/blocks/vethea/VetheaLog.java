package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModLog;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.ENT;
import static net.minecraft.world.entity.MobSpawnType.MOB_SUMMONED;

public class VetheaLog extends BlockModLog {
    //Wood (or logs with the same side/top color)
    public VetheaLog(MapColor mapColor, SoundType sound) {super(mapColor, sound);}
    //Wood with default sounds
    public VetheaLog(MapColor mapColor) {super(mapColor);}
    //Logs
    public VetheaLog(MapColor topMapColor, MapColor sideMapColor, SoundType sound) {super(topMapColor, sideMapColor, sound);}
    //Logs with default sounds
    public VetheaLog(MapColor topMapColor, MapColor sideMapColor) {super(topMapColor, sideMapColor);}
    @Override public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(!world.isClientSide) ENT.get().spawn((ServerLevel)world, stack, player, pos, MOB_SUMMONED, true, false);
        super.playerDestroy(world, player, pos, state, blockEntity, stack);
    }
}