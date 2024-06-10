package divinerpg.registries;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.util.DamageSources;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.*;
import net.minecraftforge.registries.*;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import java.util.function.Consumer;

import static divinerpg.DivineRPG.MODID;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MODID);
    private static ForgeFlowingFluid.Properties fluidProperties() {
        return new ForgeFlowingFluid.Properties(SMOLDERING_TAR, SMOLDERING_TAR_FLUID, SMOLDERING_TAR_FLUID_FLOWING).block(SMOLDERING_TAR_BLOCK).bucket(ItemRegistry.smoldering_tar_bucket);
    }
    public static final RegistryObject<FluidType> SMOLDERING_TAR = FLUID_TYPES.register("smoldering_tar_fluid_type", () ->
            new FluidType(FluidType.Properties.create().canSwim(false).canHydrate(false).canDrown(true).density(1153).viscosity(8000).temperature(1100).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)) {
                @Override public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation
                                STILL = new ResourceLocation(DivineRPG.MODID, "block/liquid_tar_still"),
                                FLOW = new ResourceLocation(DivineRPG.MODID, "block/liquid_tar_flow");
                        @Override public ResourceLocation getStillTexture() {return STILL;}
                        @Override public ResourceLocation getFlowingTexture() {return FLOW;}
                        @Override public int getTintColor() {return 0xAF7FFFD4;}
                        @Override public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                            int color = getTintColor();
                            return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F, (color & 0xFF) / 255F);
                        }
                        @Override public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                            //TODO: fix the red fog issue that comes with the lava fluid tag
                            //TODO: configure different fog distances based on if you have fire res. or spectator mode
                            nearDistance = -8;
                            farDistance = 4;
                            if(farDistance > renderDistance) {
                                farDistance = renderDistance;
                                shape = FogShape.CYLINDER;
                            } RenderSystem.setShaderFogStart(nearDistance);
                            RenderSystem.setShaderFogEnd(farDistance);
                            RenderSystem.setShaderFogShape(shape);
                        }
                    });
                }
            });
    public static final RegistryObject<FlowingFluid> SMOLDERING_TAR_FLUID = FLUIDS.register("smoldering_tar_still", () ->
            new ForgeFlowingFluid.Source(fluidProperties()) {
                @Override public int getSlopeFindDistance(LevelReader level) {return level.dimensionType().ultraWarm() ? 4 : 2;}
                @Override public int getDropOff(LevelReader level) {return level.dimensionType().ultraWarm() ? 1 : 2;}
                @Override public int getTickDelay(LevelReader level) {return level.dimensionType().ultraWarm() ? 30 : 50;}
                @Override public int getSpreadDelay(Level level, BlockPos pos, FluidState state1, FluidState state2) {
                    int i = getTickDelay(level);
                    if(!state1.isEmpty() && !state2.isEmpty() && !state1.getValue(FALLING) && !state2.getValue(FALLING) && state2.getHeight(level, pos) > state1.getHeight(level, pos) && level.getRandom().nextInt(4) != 0) {i *= 4;}
                    return i;
                }
                @Override public void animateTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
                    BlockPos blockpos = pos.above();
                    if(level.getBlockState(blockpos).isAir() && !level.getBlockState(blockpos).isSolidRender(level, blockpos)) {
                        if(random.nextInt(100) == 0) {
                            double f = .5 + random.nextDouble() / 4 * (random.nextBoolean() ? 1 : -1);
                            double d0 = (double)pos.getX() + f;
                            double d1 = (double)pos.getY() + .9;
                            double d2 = (double)pos.getZ() + f;
                            level.addParticle(ParticleRegistry.TAR.get(), d0, d1, d2, 0, .005, 0);
                            level.playLocalSound(d0, d1, d2, SoundEvents.LAVA_POP, SoundSource.BLOCKS, .2F + random.nextFloat() * .2F, .9F + random.nextFloat() * .15F, false);
                        }
                        if(random.nextInt(200) == 0) level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, .2F + random.nextFloat() * .2F, .9F + random.nextFloat() * .15F, false);
                    }
                }
                private void fizz(LevelAccessor level, BlockPos pos) {level.levelEvent(1501, pos, 0);}
                @Override protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {this.fizz(level, pos);}
                });
    public static final RegistryObject<Fluid> SMOLDERING_TAR_FLUID_FLOWING = FLUIDS.register("smoldering_tar_flowing", () ->
            new ForgeFlowingFluid.Flowing(fluidProperties()) {
                private void fizz(LevelAccessor level, BlockPos pos) {level.levelEvent(1501, pos, 0);}
                @Override protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {this.fizz(level, pos);}
                @Override protected void spreadTo(LevelAccessor level, BlockPos pos, BlockState blockState, Direction dir, FluidState fluidState) {
                    if(dir == Direction.DOWN) {
                        FluidState fluidstate = level.getFluidState(pos);
                        if(defaultFluidState().is(FluidTags.LAVA) && fluidstate.is(FluidTags.WATER)) {
                            if(blockState.getBlock() instanceof LiquidBlock) level.setBlock(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(level, pos, pos, Blocks.STONE.defaultBlockState()), 3);
                            fizz(level, pos);
                            return;
                        }
                    } super.spreadTo(level, pos, blockState, dir, fluidState);
                }
            }
    );
    public static final RegistryObject<LiquidBlock> SMOLDERING_TAR_BLOCK = BlockRegistry.BLOCKS.register("smoldering_tar", () ->
            new LiquidBlock(SMOLDERING_TAR_FLUID, BlockBehaviour.Properties.of().sound(SoundType.EMPTY).replaceable().pushReaction(PushReaction.DESTROY).randomTicks().mapColor(MapColor.COLOR_BLACK).noCollission().strength(100).noLootTable()) {
                @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
                    if(entity.isInFluidType()) {
                        //TODO: fix slowing down differently if you stay on top of a none solid block (e.g. a slab)
                        //TODO: fix xp orbs jumping on top of tar
                        entity.makeStuckInBlock(state, new Vec3(.4, .4, .4));
                        //TODO: the fire gets extinguished during rains unlike when entity.lavaHurt() is used
                        entity.setSecondsOnFire(12);
                        //That doesn't look right buh: me trying to copy the way entity.lavaHurt() works
                        if(((entity instanceof LivingEntity && !entity.fireImmune() && !((LivingEntity) entity).hasEffect(MobEffects.FIRE_RESISTANCE)) || (!(entity instanceof LivingEntity) && !entity.fireImmune())) && entity.hurt(DamageSources.source(level, DamageSources.TAR), 4)) entity.playSound(SoundEvents.GENERIC_BURN, .4F, 2 + entity.random.nextFloat() * .4F);
                    }
                }
            });
}