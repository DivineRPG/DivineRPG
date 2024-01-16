package divinerpg.registries;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.*;
import net.minecraftforge.registries.*;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

import static divinerpg.DivineRPG.MODID;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MODID);

    private static ForgeFlowingFluid.Properties fluidProperties()
    {
        return new ForgeFlowingFluid.Properties(SMOLDERING_TAR, SMOLDERING_TAR_FLUID, SMOLDERING_TAR_FLUID_FLOWING)
                .block(SMOLDERING_TAR_BLOCK)
                .bucket(SMOLDERING_TAR_BUCKET);
    }

    public static final RegistryObject<FluidType> SMOLDERING_TAR = FLUID_TYPES.register("smoldering_tar_fluid_type", () ->
            new FluidType(FluidType.Properties.create().supportsBoating(false).canSwim(false).canHydrate(false).canDrown(true).density(1153).viscosity(8000).temperature(1100).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA))
            {

                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer)
                {
                    consumer.accept(new IClientFluidTypeExtensions()
                    {
                        private static final ResourceLocation STILL = new ResourceLocation(DivineRPG.MODID,
                                "block/liquid_tar_still"),
                                FLOW = new ResourceLocation(DivineRPG.MODID,
                                        "block/liquid_tar_flow"),
                                OVERLAY = new ResourceLocation("block/obsidian"),
                                VIEW_OVERLAY = new ResourceLocation("textures/block/obsidian.png");

                        @Override
                        public ResourceLocation getStillTexture()
                        {
                            return STILL;
                        }

                        @Override
                        public ResourceLocation getFlowingTexture()
                        {
                            return FLOW;
                        }

                        @Override
                        public ResourceLocation getOverlayTexture()
                        {
                            return OVERLAY;
                        }

                        @Override
                        public ResourceLocation getRenderOverlayTexture(Minecraft mc)
                        {
                            return VIEW_OVERLAY;
                        }

                        @Override
                        public int getTintColor() {
                        return 0xAF7FFFD4;
                        }

                        @Override
                        public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor)
                        {
                            int color = this.getTintColor();
                            return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F, (color & 0xFF) / 255F);
                        }

                        @Override
                        public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape)
                        {
                            nearDistance = -8F;
                            farDistance = 24F;

                            if (farDistance > renderDistance)
                            {
                                farDistance = renderDistance;
                                shape = FogShape.CYLINDER;
                            }

                            RenderSystem.setShaderFogStart(nearDistance);
                            RenderSystem.setShaderFogEnd(farDistance);
                            RenderSystem.setShaderFogShape(shape);
                        }
                    });
                }
            });
    public static final RegistryObject<FlowingFluid> SMOLDERING_TAR_FLUID = FLUIDS.register("smoldering_tar_still", () ->
            new ForgeFlowingFluid.Source(fluidProperties())
            {
                @Override
                public int getAmount(FluidState state) {
                    return 3;
                }
            });
    public static final RegistryObject<Fluid> SMOLDERING_TAR_FLUID_FLOWING = FLUIDS.register("smoldering_tar_flowing", () ->
            new ForgeFlowingFluid.Flowing(fluidProperties()));
    public static final RegistryObject<LiquidBlock> SMOLDERING_TAR_BLOCK = BlockRegistry.BLOCKS.register("smoldering_tar", () ->
            new LiquidBlock(SMOLDERING_TAR_FLUID, BlockBehaviour.Properties.of().sound(SoundType.EMPTY).replaceable().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_BLACK).noCollission().strength(100.0F).noLootTable()) {
                @Override
                public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
                    entity.lavaHurt();
                }
            });
    public static final RegistryObject<Item> SMOLDERING_TAR_BUCKET = ItemRegistry.ITEMS.register("smoldering_tar_bucket", () ->
            new BucketItem(SMOLDERING_TAR_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
}
