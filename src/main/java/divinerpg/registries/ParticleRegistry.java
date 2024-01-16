package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.particle.*;
import divinerpg.client.particle.options.ParticleColouredType;
import net.minecraft.core.particles.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MODID);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> APALACHIA_PORTAL = PARTICLES.register("apalachia_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EDEN_PORTAL = PARTICLES.register("eden_portal", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MORTUM_PORTAL = PARTICLES.register("mortum_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SKYTHERN_PORTAL = PARTICLES.register("skythern_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WILDWOOD_PORTAL = PARTICLES.register("wildwood_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GREEN_PORTAL = PARTICLES.register("green_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLACK_FLAME = PARTICLES.register("black_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_FLAME = PARTICLES.register("blue_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GREEN_FLAME = PARTICLES.register("green_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PURPLE_FLAME = PARTICLES.register("purple_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FROST = PARTICLES.register("frost", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPARKLER = PARTICLES.register("sparkler", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ENDER_TRIPLET = PARTICLES.register("ender_triplets", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TAR = PARTICLES.register("tar", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, ParticleType<ParticleColouredType.ParticleColour>> COLORED = PARTICLES.register("colored", () -> new ParticleColouredType(false));



    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleRegistry.APALACHIA_PORTAL.get(), ParticleApalachiaPortal.Provider::new);
        event.registerSpriteSet(ParticleRegistry.EDEN_PORTAL.get(), ParticleEdenPortal.Provider::new);
        event.registerSpriteSet(ParticleRegistry.MORTUM_PORTAL.get(), ParticleMortumPortal.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SKYTHERN_PORTAL.get(), ParticleSkythernPortal.Provider::new);
        event.registerSpriteSet(ParticleRegistry.WILDWOOD_PORTAL.get(), ParticleWildwoodPortal.Provider::new);
        event.registerSpriteSet(ParticleRegistry.GREEN_PORTAL.get(), ParticleGreenPortal.Provider::new);
        event.registerSpriteSet(ParticleRegistry.BLACK_FLAME.get(), ParticleColoredFlame.BlackProvider::new);
        event.registerSpriteSet(ParticleRegistry.BLUE_FLAME.get(), ParticleColoredFlame.AquaProvider::new);
        event.registerSpriteSet(ParticleRegistry.GREEN_FLAME.get(), ParticleColoredFlame.GreenProvider::new);
        event.registerSpriteSet(ParticleRegistry.PURPLE_FLAME.get(), ParticleColoredFlame.PurpleProvider::new);
        event.registerSpriteSet(ParticleRegistry.FROST.get(), ParticleFrost.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SPARKLER.get(), ParticleSparkler.Provider::new);
        event.registerSpriteSet(ParticleRegistry.ENDER_TRIPLET.get(), ParticleEnderTriplet.Provider::new);
        event.registerSpriteSet(ParticleRegistry.TAR.get(), ParticleTar.Provider::new);
        event.registerSpriteSet(ParticleRegistry.COLORED.get(), ParticleColored.Provider::new);
    }
}