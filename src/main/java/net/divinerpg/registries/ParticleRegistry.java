package net.divinerpg.registries;

import com.mojang.serialization.MapCodec;
import net.divinerpg.client.particle.options.ParticleColouredOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ParticleRegistry {
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EDEN_PORTAL = DivineRegistries.PARTICLES.register("eden_portal", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WILDWOOD_PORTAL = DivineRegistries.PARTICLES.register("wildwood_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> APALACHIA_PORTAL = DivineRegistries.PARTICLES.register("apalachia_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SKYTHERN_PORTAL = DivineRegistries.PARTICLES.register("skythern_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MORTUM_PORTAL = DivineRegistries.PARTICLES.register("mortum_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HALITE_PORTAL = DivineRegistries.PARTICLES.register("halite_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TWILIGHT_PORTAL = DivineRegistries.PARTICLES.register("twilight_portal", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLACK_FLAME = DivineRegistries.PARTICLES.register("black_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_FLAME = DivineRegistries.PARTICLES.register("blue_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GREEN_FLAME = DivineRegistries.PARTICLES.register("green_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PURPLE_FLAME = DivineRegistries.PARTICLES.register("purple_flame", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FROST = DivineRegistries.PARTICLES.register("frost", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPARKLER = DivineRegistries.PARTICLES.register("sparkler", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ENDER_TRIPLET = DivineRegistries.PARTICLES.register("ender_triplets", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TAR = DivineRegistries.PARTICLES.register("tar", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPLASH = DivineRegistries.PARTICLES.register("splash", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, ParticleType<ParticleColouredOption>> COLORED = DivineRegistries.PARTICLES.register("colored", () -> new ParticleType<>(false) {@Override public MapCodec<ParticleColouredOption> codec() {return null;} @Override public StreamCodec<? super RegistryFriendlyByteBuf, ParticleColouredOption> streamCodec() {return null;}});
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EDEN_RIFT = DivineRegistries.PARTICLES.register("eden_rift", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WILDWOOD_RIFT = DivineRegistries.PARTICLES.register("wildwood_rift", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> APALACHIA_RIFT = DivineRegistries.PARTICLES.register("apalachia_rift", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SKYTHERN_RIFT = DivineRegistries.PARTICLES.register("skythern_rift", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MORTUM_RIFT = DivineRegistries.PARTICLES.register("mortum_rift", () -> new SimpleParticleType(false));
    public static void load() {}
}
