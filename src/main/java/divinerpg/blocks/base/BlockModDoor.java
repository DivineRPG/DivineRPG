package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;

public class BlockModDoor extends DoorBlock {
    public BlockModDoor(Material material, float hardness, float resistance, SoundType sound) {
        super(Block.Properties
                .of(material)
                .strength(hardness, resistance)
                .noOcclusion()
                .requiresCorrectToolForDrops()
                .sound(sound), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN);
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
            state = state.cycle(OPEN);
            world.setBlock(pos, state, 10);
            world.levelEvent(player, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), pos, 0);
            return InteractionResult.sidedSuccess(world.isClientSide);
    }
    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }
    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }
    @Override
    public ItemStack getCloneItemStack(BlockGetter block, BlockPos pos, BlockState state) {
        return new ItemStack(state.getBlock());
    }
}