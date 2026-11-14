package divinerpg.blocks.vethea;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.ENT;
import static net.minecraft.world.entity.EntitySpawnReason.MOB_SUMMONED;

public class VetheaLog extends RotatedPillarBlock { // Ensure this extends RotatedPillarBlock
    public VetheaLog(Properties p) { super(p); }
    @Override public void playerDestroy(ServerLevel world, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(!world.isClientSide()) ENT.get().spawn(world, stack, player, pos, MOB_SUMMONED, true, false);
        super.playerDestroy(world, player, pos, state, blockEntity, stack);
    }
}