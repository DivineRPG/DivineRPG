package net.divinerpg.blocks.vethea;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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

import static net.minecraft.world.entity.EntitySpawnReason.MOB_SUMMONED;

public class VetheaLog extends RotatedPillarBlock { // Ensure this extends RotatedPillarBlock

    public VetheaLog(MapColor color, SoundType sound, Properties p) { super(p.mapColor(color).sound(sound)); }
    public VetheaLog(MapColor top, MapColor side, SoundType sound, Properties p) { super(p.mapColor(top).sound(sound)); }

    //TODO - ENT
    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(!world.isClientSide()) /*ENT.get()*/ EntityTypes.ALLAY.spawn((ServerLevel)world, stack, player, pos, MOB_SUMMONED, true, false);
        super.playerDestroy(world, player, pos, state, blockEntity, stack);
    }
}