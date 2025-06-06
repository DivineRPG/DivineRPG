package divinerpg.blocks.twilight;

import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.twilight.ItemFrozenClock;
import divinerpg.registries.DataComponentRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TwilightFire extends FireBlock {
    public TwilightFire() {
        super();
    }
    public TwilightFire(float fireDamage) {
        super(fireDamage);
    }
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(stack.is(Items.CLOCK) && ItemFrozenClock.useOnFire(level, player, pos, state, Utils.determineTimeOfDay(level))) return ItemInteractionResult.SUCCESS;
        else if(stack.is(ItemRegistry.frozen_clock) && ItemFrozenClock.useOnFire(level, player, pos, state, stack.get(DataComponentRegistry.variant))) return ItemInteractionResult.SUCCESS;
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}