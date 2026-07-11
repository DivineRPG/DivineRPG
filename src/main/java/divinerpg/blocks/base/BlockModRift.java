package divinerpg.blocks.base;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import divinerpg.block_entities.block.RiftBlockEntity;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockModRift extends BaseEntityBlock implements DivinePortalLogic {
    public static final ResourceLocation
            ADVANCEMENT_UNSTABLE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/an_unstable_combination"),
            ADVANCEMENT_STABLE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/ripple_space_time");
    public final ResourceKey<Level> rootDimension;
    public final TagKey<Level> stableDimension;
    public final TagKey<Block> resonanceTag;
    public final TagKey<Item> empowerTag;
    public final byte variant;
    public BlockModRift(Properties properties, ResourceLocation rootDimension, TagKey<Level> stableDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        this(properties.pushReaction(PushReaction.BLOCK), ResourceKey.create(Registries.DIMENSION, rootDimension), stableDimension, resonanceTag, empowerTag, variant);
    }
    public BlockModRift(ResourceKey<Level> rootDimension, TagKey<Level> stableDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        this(Properties.of().replaceable().noCollission().noLootTable().air().strength(-1, 3600000), rootDimension, stableDimension, resonanceTag, empowerTag, variant);
    }
    public BlockModRift(Properties properties, ResourceKey<Level> rootDimension, TagKey<Level> stableDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        super(properties.pushReaction(PushReaction.BLOCK));
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.LEVEL, 15));
        this.rootDimension = rootDimension;
        this.stableDimension = stableDimension;
        this.resonanceTag = resonanceTag;
        this.empowerTag = empowerTag;
        this.variant = variant;
    }

    @Override protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(newState.is(this)) return;
        if(!newState.isAir()) {
            level.playSound(null, pos, SoundRegistry.RIFT_COLSE_MUFFLED.get(), SoundSource.BLOCKS, 1F, 1F);
            if(state.hasBlockEntity()) level.removeBlockEntity(pos);
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
            level.removeBlockEntity(pos);
        } if(!level.holderOrThrow(level.dimension()).is(stableDimension)) {
            level.explode(null, pos.getX() + .5, pos.getY(), pos.getZ() + .5, 3, Level.ExplosionInteraction.TNT);
            BlockPos p;
            for(int i = 0; i < 15; i++) if(level.getBlockState(p = pos.offset(Mth.sign(Math.random() - .5) * (level.random.nextInt(3) + 1), Mth.sign(Math.random() - .5) * (level.random.nextInt(2) + 1) - 1, Mth.sign(Math.random() - .5) * (level.random.nextInt(3) + 1))).isAir())
                level.setBlock(p, Blocks.FIRE.defaultBlockState(), 3);
        } level.playSound(null, pos, SoundRegistry.RIFT_CLOSE.get(), SoundSource.BLOCKS, 1F, 1F);
    }
    @Override protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if(oldState.is(this)) return;
        RiftBlockEntity e = (RiftBlockEntity) level.getBlockEntity(pos);
        e.variant = variant;
        int lifetime = 200;
        List<BlockState> states = level.getBlockStates(new AABB(UniversalPosition.toVec3(pos.offset(-2, -2, -2)), UniversalPosition.toVec3(pos.offset(2, 2, 2)))).toList();
        for(BlockState s : states) if(s.is(resonanceTag)) lifetime = (lifetime * 5) >> 2;
        e.maxLifeTime = e.lifeTime = lifetime;
        if(!level.holderOrThrow(level.dimension()).is(stableDimension)) {
            e.variant = (byte) (e.variant | 0b10000);
            level.explode(null, pos.getX() + .5, pos.getY(), pos.getZ() + .5, 5, Level.ExplosionInteraction.TNT);
            BlockPos p;
            for(int i = 0; i < 15; i++) if(level.getBlockState(p = pos.offset(Mth.sign(Math.random() - .5) * (level.random.nextInt(3) + 1), Mth.sign(Math.random() - .5) * (level.random.nextInt(2) + 1) - 1, Mth.sign(Math.random() - .5) * (level.random.nextInt(3) + 1))).isAir())
                level.setBlock(p, Blocks.FIRE.defaultBlockState(), 3);
            if(level instanceof ServerLevel s) {
                List<ServerPlayer> players = Utils.getNearbyPlayers(s, pos.getX(), pos.getY(), pos.getZ(), 9);
                for(ServerPlayer player : players) Utils.awardAdvancement(s.getServer(), player, ADVANCEMENT_UNSTABLE, "create_unstable_rift");
            }
        } else if(level instanceof ServerLevel s) {
            List<ServerPlayer> players = Utils.getNearbyPlayers(s, pos.getX(), pos.getY(), pos.getZ(), 9);
            for(ServerPlayer player : players) Utils.awardAdvancement(s.getServer(), player, ADVANCEMENT_STABLE, "create_stable_rift");
        } level.playSound(null, pos, SoundRegistry.RIFT_OPEN.get(), SoundSource.BLOCKS, 1F, 1F);
        if(level instanceof ServerLevel s) s.sendParticles(switch(e.variant & 0b111) {
        case 6 -> ParticleRegistry.OVERWORLD_RIFT.get();
        case 5 -> ParticleRegistry.MORTUM_RIFT.get();
        case 4 -> ParticleRegistry.SKYTHERN_RIFT.get();
        case 3 -> ParticleRegistry.APALACHIA_RIFT.get();
        case 2 -> ParticleRegistry.WILDWOOD_RIFT.get();
        default -> ParticleRegistry.EDEN_RIFT.get();
        }, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 5, 0D, 0D, 0D, 0D);
    }
    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof ItemEntity e && e.getItem().is(empowerTag)) {
            e.discard();
            RiftBlockEntity r = (RiftBlockEntity) level.getBlockEntity(pos);
            r.lifeTime = r.maxLifeTime;
            level.playSound(null, pos, SoundRegistry.RIFT_REPLENISH.get(), SoundSource.BLOCKS, 1F, 1F);
        } else if(level.dimension() != rootDimension) entity.setAsInsidePortal(this, pos);
    }
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? createTickerHelper(type, BlockEntityRegistry.RIFT.get(), RiftBlockEntity::clientTick) : createTickerHelper(type, BlockEntityRegistry.RIFT.get(), RiftBlockEntity::serverTick);
    }
    @Override public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BlockEntityRegistry.RIFT.get().create(blockPos, blockState);
    }
    @Override public @Nullable DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
        if(level.dimension() == rootDimension || (entity instanceof ItemEntity e && e.getItem().is(empowerTag))) return null;
        return DivinePortalLogic.super.getPortalDestination(level, entity, pos);
    }
    @Override @Nullable
    public BlockPos lookForNearbyPortal(ServerLevel level, Entity entity, BlockPos center) {
        return level.getBlockState(center.below()).is(this) ? center.below() : null;
    }
    @Override
    public boolean hasSpace(ServerLevel level, BlockPos pos) {
        return level.getBlockState(pos.above()).isAir();
    }
    @Override
    public BlockPos placeAndLink(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos, Entity entity) {
        BlockPos pos = targetPos.below();
        BlockState state = targetLevel.getBlockState(pos);
        if(!state.isFaceSturdy(targetLevel, pos, Direction.UP)) targetLevel.setBlock(pos, BlockRegistry.twilightStone.get().defaultBlockState(), 3);
        targetLevel.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
        targetLevel.setBlock(targetPos.above(), Blocks.AIR.defaultBlockState(), 3);
        targetLevel.setBlock(targetPos.above(2), defaultBlockState(), 3);
        return targetPos;
    }

    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {return Shapes.empty();}
    @Override public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {return state.getValue(BlockStateProperties.LEVEL);}
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.LEVEL);}
    @Override protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    public static final MapCodec<BlockModRift> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(propertiesCodec(), ResourceLocation.CODEC.fieldOf("root_dimension").forGetter(BlockModRift::rootDimensionLocation), TagKey.codec(Registries.DIMENSION).fieldOf("stable_dimension").forGetter(BlockModRift::stableDimension), TagKey.codec(Registries.BLOCK).fieldOf("supported_blocks").forGetter(BlockModRift::resonanceTag), TagKey.codec(Registries.ITEM).fieldOf("replenishing_items").forGetter(BlockModRift::empowerTag), Codec.BYTE.fieldOf("variant").forGetter(BlockModRift::variant)).apply(instance, BlockModRift::new));
    @Override protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    @Override public ResourceKey<Level> rootDimension() {return rootDimension;}
    public ResourceLocation rootDimensionLocation() {return rootDimension.location();}
    public TagKey<Level> stableDimension() {return stableDimension;}
    public TagKey<Block> resonanceTag() {return resonanceTag;}
    public TagKey<Item> empowerTag() {return empowerTag;}
    public byte variant() {return variant;}
}