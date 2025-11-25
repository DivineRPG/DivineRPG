package divinerpg.events;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.client.particle.*;
import divinerpg.effect.dimension.*;
import divinerpg.registries.*;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.*;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.ParticleRegistry.*;
import static net.minecraft.world.effect.MobEffects.FIRE_RESISTANCE;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSidedExtraEvents {
    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation
                    STILL = ResourceLocation.fromNamespaceAndPath(MODID, "block/liquid_tar_still"),
                    FLOW = ResourceLocation.fromNamespaceAndPath(MODID, "block/liquid_tar_flow");
            @Override public ResourceLocation getStillTexture() {return STILL;}
            @Override public ResourceLocation getFlowingTexture() {return FLOW;}
            @Override public int getTintColor() {return 0xFF7FFFD4;}
            @Override public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                int color = 0xFF101916;
                return new Vector3f((color >> 16 & 0xFF) / 255F, (color >> 8 & 0xFF) / 255F, (color & 0xFF) / 255F);
            }
            @Override public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                //TODO: fix the red fog issue that comes with the lava fluid tag (or preferably exclude tar from it and implement all those little things that come with it ourselves)
                LivingEntity entity = (LivingEntity)camera.getEntity();
                if(entity.isSpectator()) {
                    nearDistance = -8;
                    farDistance = renderDistance * .25F;
                } else if(entity.hasEffect(FIRE_RESISTANCE)) {
                    nearDistance = 0;
                    farDistance = 4;
                } else {
                    nearDistance = .25F;
                    farDistance = 1;
                } if(farDistance > renderDistance) {
                    farDistance = renderDistance;
                    shape = FogShape.CYLINDER;
                } RenderSystem.setShaderFogStart(nearDistance);
                RenderSystem.setShaderFogEnd(farDistance);
                RenderSystem.setShaderFogShape(shape);
            }
        }, FluidRegistry.SMOLDERING_TAR);
    }
    @SubscribeEvent
    public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
        event.register(ResourceLocation.fromNamespaceAndPath(MODID, "iceika_sky"), new IceikaSky());
        event.register(ResourceLocation.fromNamespaceAndPath(MODID, "twilight_sky"), new TwilightSky());
        event.register(ResourceLocation.fromNamespaceAndPath(MODID, "vethea_sky"), new VetheaSky());
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(EDEN_PORTAL.get(), ParticlePortal.EdenProvider::new);
        event.registerSpriteSet(WILDWOOD_PORTAL.get(), ParticlePortal.WildwoodProvider::new);
        event.registerSpriteSet(APALACHIA_PORTAL.get(), ParticlePortal.ApalachiaProvider::new);
        event.registerSpriteSet(SKYTHERN_PORTAL.get(),ParticlePortal.SkythernProvider::new);
        event.registerSpriteSet(MORTUM_PORTAL.get(), ParticlePortal.MortumProvider::new);
        event.registerSpriteSet(HALITE_PORTAL.get(), ParticlePortal.HaliteProvider::new);
        event.registerSpriteSet(TWILIGHT_PORTAL.get(), ParticlePortal.TwilightProvider::new);
        event.registerSpriteSet(BLACK_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(BLUE_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(GREEN_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(PURPLE_FLAME.get(), FlameParticle.Provider::new);
        event.registerSpriteSet(FROST.get(), ParticleFrost.Provider::new);
        event.registerSpriteSet(SPARKLER.get(), ParticleSparkler.Provider::new);
        event.registerSpriteSet(ENDER_TRIPLET.get(), ParticleEnderTriplet.Provider::new);
        event.registerSpriteSet(TAR.get(), ParticleTar.Provider::new);
        event.registerSpriteSet(SPLASH.get(), ParticleSplash.Provider::new);
        event.registerSpriteSet(COLORED.get(), ParticleColored.Provider::new);
        event.registerSprite(EDEN_RIFT.get(), RiftParticle::createParticle);
        event.registerSprite(WILDWOOD_RIFT.get(), RiftParticle::createParticle);
        event.registerSprite(APALACHIA_RIFT.get(), RiftParticle::createParticle);
        event.registerSprite(SKYTHERN_RIFT.get(), RiftParticle::createParticle);
        event.registerSprite(MORTUM_RIFT.get(), RiftParticle::createParticle);
    }
    public static class MusicEvent {
        public static volatile boolean wantsToPlaySnowflakes = false;
        @OnlyIn(Dist.CLIENT) @SubscribeEvent
        public void musicEvent(SelectMusicEvent e) {
            if(e.getPlayingMusic() == null) {
                ClientLevel level = Minecraft.getInstance().level;
                if(level != null && level.dimension() == LevelRegistry.ICEIKA) {
                    if(AttachmentRegistry.IN_DUNGEON.get(Minecraft.getInstance().player)) e.setMusic(SoundRegistry.CRYSTAL_TEARS_MUSIC);
                    else if(wantsToPlaySnowflakes) {
                        e.setMusic(SoundRegistry.SNOWFLAKES_MUSIC);
                        wantsToPlaySnowflakes = false;
                    }
                }
            }
        }
    }
}