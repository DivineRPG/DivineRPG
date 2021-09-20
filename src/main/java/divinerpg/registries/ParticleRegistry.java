package divinerpg.registries;

import divinerpg.*;
import net.minecraft.particles.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;


public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DivineRPG.MODID);

    public static final RegistryObject<BasicParticleType> APALACHIA_PORTAL = PARTICLES.register("apalachia_portal", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> EDEN_PORTAL = PARTICLES.register("eden_portal", () -> new BasicParticleType(true));
    public static final RegistryObject<BasicParticleType> MORTUM_PORTAL = PARTICLES.register("mortum_portal", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> SKYTHERN_PORTAL = PARTICLES.register("skythern_portal", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> WILDWOOD_PORTAL = PARTICLES.register("wildwood_portal", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> GREEN_PORTAL = PARTICLES.register("green_portal", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> BLACK_FLAME = PARTICLES.register("black_flame", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> BLUE_FLAME = PARTICLES.register("blue_flame", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> GREEN_FLAME = PARTICLES.register("green_flame", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> PURPLE_FLAME = PARTICLES.register("purple_flame", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> FROST = PARTICLES.register("frost", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> SPARKLER = PARTICLES.register("sparkler", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> ENDER_TRIPLET = PARTICLES.register("ender_triplets", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> TAR = PARTICLES.register("tar", () -> new BasicParticleType(false));


}