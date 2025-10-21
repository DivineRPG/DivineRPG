package divinerpg.block_entities.block;

import divinerpg.network.payload.RequestRiftVariant;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.network.PacketDistributor;

public class RiftBlockEntity extends BlockEntity {
    public int lifeTime, maxLifeTime, clientTickCount;
    public byte variant;
    public RiftBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.RIFT.get(), pos, blockState);
    }
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("lifetime", lifeTime);
        tag.putInt("maxlifetime", maxLifeTime);
        tag.putByte("variant", variant);
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if(tag.contains("lifetime")) lifeTime = tag.getInt("lifetime");
        if(tag.contains("maxlifetime")) maxLifeTime = tag.getInt("maxlifetime");
        if(tag.contains("variant")) variant = tag.getByte("variant");
    }
    @Override public void onLoad() {
        super.onLoad();
        if(level != null && level.isClientSide()) PacketDistributor.sendToServer(new RequestRiftVariant(worldPosition));
    }
    public static void clientTick(Level level, BlockPos pos, BlockState state, RiftBlockEntity entity) {
        entity.clientTickCount++;
        if((entity.clientTickCount & 0b111111) == 10) level.playLocalSound(pos, SoundRegistry.RIFT_AMBIENT.get(), SoundSource.BLOCKS, 1F, 1F, false);
        if((entity.variant & 0b10000) == 0b10000 && Math.random() < 0.15) level.playLocalSound(pos, SoundRegistry.RIFT_INSTABILITY.get(), SoundSource.BLOCKS, 1F, 1.5F - (float)Math.random(), false);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, RiftBlockEntity entity) {
        entity.lifeTime -= (entity.variant & 0b10000) | 1;
        int lightLevel = Math.clamp((int)((15F * entity.lifeTime) / entity.maxLifeTime), 0, 15);
        if(state.getValue(BlockStateProperties.LEVEL) != lightLevel) level.setBlock(pos, state.setValue(BlockStateProperties.LEVEL, lightLevel), Block.UPDATE_CLIENTS);
        if(entity.lifeTime < 0) level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
    }
}