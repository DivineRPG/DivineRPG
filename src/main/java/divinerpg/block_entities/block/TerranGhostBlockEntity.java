package divinerpg.block_entities.block;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.*;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class TerranGhostBlockEntity extends BlockEntity {
    public int lifeTime = 300;
    public BlockState originalState;
    public TerranGhostBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.TERRAN_GHOST.get(), pos, blockState);
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("lifetime", lifeTime);
        if(originalState != null) output.store("originalstate", BlockState.FULL_CODEC, originalState);
    }
    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.getInt("lifetime").ifPresent(i -> lifeTime = i);
        input.read("originalstate", BlockState.FULL_CODEC).ifPresent(s -> originalState = s);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, TerranGhostBlockEntity entity) {
        entity.lifeTime--;
        if(entity.lifeTime <= 0) level.setBlock(pos, entity.originalState == null ? Blocks.AIR.defaultBlockState() : entity.originalState, 3);
    }
    public static void clientTick(Level level, BlockPos pos, BlockState state, TerranGhostBlockEntity entity) {
        RandomSource random = level.getRandom();
        if(random.nextInt(10) == 0) level.addParticle(ParticleRegistry.GREEN_FLAME.get(), pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), .0, .0, .0);
    }
    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        if(level instanceof ServerLevel s) {
            if(originalState != null && originalState != state) {
                List<ItemStack> drops = originalState.getDrops(new LootParams.Builder(s).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, ItemRegistry.terran_shickaxe.toStack()));
                for(ItemStack drop : drops) if(!drop.isEmpty()) {
                    ItemEntity itemEntity = new ItemEntity(s, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, drop);
                    itemEntity.setDeltaMovement(0, .1, 0);
                    s.addFreshEntity(itemEntity);
                }
            }
        } level.removeBlockEntity(pos);
    }
}