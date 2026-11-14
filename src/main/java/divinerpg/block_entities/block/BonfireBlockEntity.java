package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class BonfireBlockEntity extends BlockEntity {
    public int lifeTime;
    public BonfireBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.BONFIRE.get(), pos, state);
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("lifetime", lifeTime);
    }
    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.getInt("lifetime").ifPresent(i -> lifeTime = i);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, BonfireBlockEntity entity) {
        if(entity.lifeTime > 0) {
            entity.lifeTime--;
            if(entity.lifeTime < 1) level.setBlock(pos, Blocks.FIRE.defaultBlockState(), 3);
        }
    }
    public static void particleTick(Level level, BlockPos pos, BlockState state, BonfireBlockEntity blockEntity) {
        if(level.getRandom().nextFloat() < 0.11F) for(int i = 0; i < level.getRandom().nextInt(2) + 2; ++i) CampfireBlock.makeParticles(level, pos, true, true);
    }
}