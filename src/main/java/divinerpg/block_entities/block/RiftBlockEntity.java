package divinerpg.block_entities.block;

import divinerpg.network.payload.RequestRiftVariant;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.ParticleRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.*;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

public class RiftBlockEntity extends BlockEntity {
    public int lifeTime, maxLifeTime, clientTickCount;
    public byte variant;
    public RiftBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.RIFT.get(), pos, blockState);
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("lifetime", lifeTime);
        output.putInt("maxlifetime", maxLifeTime);
        output.putByte("variant", variant);
    }
    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.getInt("lifetime").ifPresent(i -> lifeTime = i);
        input.getInt("maxlifetime").ifPresent(i -> maxLifeTime = i);
        variant = input.getByteOr("variant", (byte) 0);
    }
    @Override public void onLoad() {
        super.onLoad();
        if(level != null && level.isClientSide()) ClientPacketDistributor.sendToServer(new RequestRiftVariant(worldPosition));
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

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        if(!state.isAir()) {
            level.playSound(null, pos, SoundRegistry.RIFT_CLOSE_MUFFLED.get(), SoundSource.BLOCKS, 1F, 1F);
            return;
        } if(state.hasBlockEntity()) {
            if(level instanceof ServerLevel s) s.sendParticles(switch(((RiftBlockEntity)level.getBlockEntity(pos)).variant & 0b111) {
                case 6 -> ParticleRegistry.OVERWORLD_RIFT.get();
                case 5 -> ParticleRegistry.MORTUM_RIFT.get();
                case 4 -> ParticleRegistry.SKYTHERN_RIFT.get();
                case 3 -> ParticleRegistry.APALACHIA_RIFT.get();
                case 2 -> ParticleRegistry.WILDWOOD_RIFT.get();
                default -> ParticleRegistry.EDEN_RIFT.get();
            }, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 5, 0D, 0D, 0D, 0D);
        } level.playSound(null, pos, SoundRegistry.RIFT_CLOSE.get(), SoundSource.BLOCKS, 1F, 1F);
    }
}