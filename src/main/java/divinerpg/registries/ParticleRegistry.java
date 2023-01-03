package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.particle.*;
import divinerpg.client.particle.options.ParticleColouredType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import static divinerpg.DivineRPG.MODID;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MODID);
    public static final RegistryObject<SimpleParticleType> APALACHIA_PORTAL = PARTICLES.register("apalachia_portal", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> EDEN_PORTAL = PARTICLES.register("eden_portal", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> MORTUM_PORTAL = PARTICLES.register("mortum_portal", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SKYTHERN_PORTAL = PARTICLES.register("skythern_portal", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> WILDWOOD_PORTAL = PARTICLES.register("wildwood_portal", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GREEN_PORTAL = PARTICLES.register("green_portal", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> BLACK_FLAME = PARTICLES.register("black_flame", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> BLUE_FLAME = PARTICLES.register("blue_flame", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GREEN_FLAME = PARTICLES.register("green_flame", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> PURPLE_FLAME = PARTICLES.register("purple_flame", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FROST = PARTICLES.register("frost", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SPARKLER = PARTICLES.register("sparkler", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> ENDER_TRIPLET = PARTICLES.register("ender_triplets", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> TAR = PARTICLES.register("tar", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<ParticleColouredType.ParticleColour>> COLORED = PARTICLES.register("colored", () -> new ParticleColouredType(false));



    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerFactories(RegisterParticleProvidersEvent event) {
        ParticleEngine particles = Minecraft.getInstance().particleEngine;
        particles.register(ParticleRegistry.APALACHIA_PORTAL.get(), ParticleApalachiaPortal.Provider::new);
        particles.register(ParticleRegistry.EDEN_PORTAL.get(), ParticleEdenPortal.Provider::new);
        particles.register(ParticleRegistry.MORTUM_PORTAL.get(), ParticleMortumPortal.Provider::new);
        particles.register(ParticleRegistry.SKYTHERN_PORTAL.get(), ParticleSkythernPortal.Provider::new);
        particles.register(ParticleRegistry.WILDWOOD_PORTAL.get(), ParticleWildwoodPortal.Provider::new);
        particles.register(ParticleRegistry.GREEN_PORTAL.get(), ParticleGreenPortal.Provider::new);
        particles.register(ParticleRegistry.BLACK_FLAME.get(), ParticleColoredFlame.BlackProvider::new);
        particles.register(ParticleRegistry.BLUE_FLAME.get(), ParticleColoredFlame.AquaProvider::new);
        particles.register(ParticleRegistry.GREEN_FLAME.get(), ParticleColoredFlame.GreenProvider::new);
        particles.register(ParticleRegistry.PURPLE_FLAME.get(), ParticleColoredFlame.PurpleProvider::new);
        particles.register(ParticleRegistry.FROST.get(), ParticleFrost.Provider::new);
        particles.register(ParticleRegistry.SPARKLER.get(), ParticleSparkler.Provider::new);
        particles.register(ParticleRegistry.ENDER_TRIPLET.get(), ParticleEnderTriplet.Provider::new);
        particles.register(ParticleRegistry.TAR.get(), ParticleTar.Provider::new);
        particles.register(ParticleRegistry.COLORED.get(), ParticleColored.Provider::new);
    }
}