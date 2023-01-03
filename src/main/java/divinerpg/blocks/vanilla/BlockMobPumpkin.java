package divinerpg.blocks.vanilla;

import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;

import java.util.function.Supplier;

public class BlockMobPumpkin extends HorizontalDirectionalBlock {
    private final Supplier<SoundEvent> sound;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public BlockMobPumpkin(Supplier<SoundEvent> sound) {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(1.0F, 1.0F)
                .sound(SoundType.WOOD));
        this.sound = sound;
        registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!player.isCrouching() && sound != null) {
            worldIn.playSound(player, pos, sound.get(), SoundSource.BLOCKS, 20.0F, 1.0F);
        }
        return InteractionResult.PASS;

    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
