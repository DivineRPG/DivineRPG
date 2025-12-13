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
import net.minecraft.server.MinecraftServer;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static divinerpg.blocks.base.PortalBlock.*;

public class BlockModRift extends BaseEntityBlock implements Portal {
    public static final ResourceLocation
            ADVANCEMENT_UNSTABLE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/an_unstable_combination"),
            ADVANCEMENT_STABLE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/ripple_space_time");
    public final ResourceKey<Level> rootDimension, chainDimension;
    public final TagKey<Block> resonanceTag;
    public final TagKey<Item> empowerTag;
    public final byte variant;
    public BlockModRift(Properties properties, ResourceLocation rootDimension, ResourceLocation chainDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        this(properties.pushReaction(PushReaction.BLOCK), ResourceKey.create(Registries.DIMENSION, rootDimension), ResourceKey.create(Registries.DIMENSION, chainDimension), resonanceTag, empowerTag, variant);
    }
    public BlockModRift(ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        this(Properties.of().replaceable().noCollission().noLootTable().air().strength(-1, 3600000), rootDimension, chainDimension, resonanceTag, empowerTag, variant);
    }
    public BlockModRift(Properties properties, ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, TagKey<Block> resonanceTag, TagKey<Item> empowerTag, byte variant) {
        super(properties.pushReaction(PushReaction.BLOCK));
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.LEVEL, 15));
        this.rootDimension = rootDimension;
        this.chainDimension = chainDimension;
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
                case 5 -> ParticleRegistry.MORTUM_RIFT.get();
                case 4 -> ParticleRegistry.SKYTHERN_RIFT.get();
                case 3 -> ParticleRegistry.APALACHIA_RIFT.get();
                case 2 -> ParticleRegistry.WILDWOOD_RIFT.get();
                default -> ParticleRegistry.EDEN_RIFT.get();
            }, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 5, 0D, 0D, 0D, 0D);
            level.removeBlockEntity(pos);
        } if(level.dimension() != rootDimension && level.dimension() != chainDimension) {
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
        if(level.dimension() != rootDimension && level.dimension() != chainDimension) {
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
        case 5 -> ParticleRegistry.MORTUM_RIFT.get();
        case 4 -> ParticleRegistry.SKYTHERN_RIFT.get();
        case 3 -> ParticleRegistry.APALACHIA_RIFT.get();
        case 2 -> ParticleRegistry.WILDWOOD_RIFT.get();
        default -> ParticleRegistry.EDEN_RIFT.get();
        }, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 5, 0D, 0D, 0D, 0D);
    }
    @Override protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
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
        ServerLevel targetLevel = level.getServer().getLevel(rootDimension);
        BlockPos targetPosition = scalePosition(pos, level.dimensionType(), targetLevel.dimensionType());
        for(int tries = 0; tries < 10; tries++) if(hasRoom(targetLevel, pos = applyLocationPreference(targetLevel, entity, targetPosition.offset((int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)), 0, (int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)))))) break;
        targetPosition = pos;
        BlockState state = targetLevel.getBlockState(pos = targetPosition.below());
        if(state.is(this)) return transitionTo(level.getServer(), entity, new UniversalPosition(rootDimension, pos));
        if(!state.isFaceSturdy(targetLevel, pos, Direction.UP)) targetLevel.setBlock(pos, BlockRegistry.twilightStone.get().defaultBlockState(), 3);
        targetLevel.setBlock(targetPosition, Blocks.AIR.defaultBlockState(), 3);
        targetLevel.setBlock(targetPosition.above(), Blocks.AIR.defaultBlockState(), 3);
        targetLevel.setBlock(targetPosition.above(2), defaultBlockState(), 3);
        return transitionTo(level.getServer(), entity, new UniversalPosition(rootDimension, targetPosition));
    }
    public DimensionTransition transitionTo(MinecraftServer server, Entity entity, UniversalPosition pos) {
        return new DimensionTransition(pos.level(server), pos.pos().add(.5, 0, .5), Vec3.ZERO, entity.getYRot(), entity.getXRot(), false, DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET).then(e -> e.hurt(e.damageSources().inWall(), e.level().dimension() == chainDimension ? 1 : 18)));
    }
    /**
     * Use this method to influence where in the world the portal should be placed.
     * @param level the target level where the portal should get placed
     * @param pos the initial position provided for location search
     * @return the new preferred block position for where to place the portal
     */
    @NotNull
    public BlockPos applyLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
        return PortalBlock.defaultLocationPreferences(level, pos);
    }
    public boolean hasRoom(ServerLevel level, BlockPos pos) {
        return level.getBlockState(pos).isAir() && level.getBlockState(pos.above()).isAir() && level.getBlockState(pos.above(2)).isAir();
    }
    @Override public int getPortalTransitionTime(ServerLevel level, Entity entity) {
        return 0;
    }

    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
    @Override public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(BlockStateProperties.LEVEL);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.LEVEL);
    }
    @Override protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    public static final MapCodec<BlockModRift> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(propertiesCodec(), ResourceLocation.CODEC.fieldOf("root_dimension").forGetter(BlockModRift::rootDimension), ResourceLocation.CODEC.fieldOf("chain_dimension").forGetter(BlockModRift::chainDimension), TagKey.codec(Registries.BLOCK).fieldOf("supported_blocks").forGetter(BlockModRift::resonanceTag), TagKey.codec(Registries.ITEM).fieldOf("replenishing_items").forGetter(BlockModRift::empowerTag), Codec.BYTE.fieldOf("variant").forGetter(BlockModRift::variant)).apply(instance, BlockModRift::new));
    @Override protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    public ResourceLocation rootDimension() {
        return rootDimension.location();
    }
    public ResourceLocation chainDimension() {
        return chainDimension.location();
    }
    public TagKey<Block> resonanceTag() {
        return resonanceTag;
    }
    public TagKey<Item> empowerTag() {
        return empowerTag;
    }
    public byte variant() {
        return variant;
    }
}