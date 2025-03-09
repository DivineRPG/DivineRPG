package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockMod;
import divinerpg.items.twilight.ItemFrozenClock;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

public class TwilightPortalFrame extends BlockMod {
    public TwilightPortalFrame(MapColor color, float hardness, float resistance, SoundType sound, NoteBlockInstrument instrument) {
        super(color, hardness, resistance, sound, instrument);
    }
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(stack.is(Items.CLOCK)) return ItemFrozenClock.useOnPortalBlock(level, player, pos.relative(hitResult.getDirection()), state, Utils.determineTimeOfDay(level)) == InteractionResult.SUCCESS ? ItemInteractionResult.SUCCESS : ItemInteractionResult.FAIL;
        if(stack.is(ItemRegistry.frozen_clock)) return ItemFrozenClock.useOnPortalBlock(level, player, pos.relative(hitResult.getDirection()), state, stack.get(DataComponentRegistry.variant)) == InteractionResult.SUCCESS ? ItemInteractionResult.SUCCESS : ItemInteractionResult.FAIL;
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}