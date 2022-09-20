package divinerpg.util;


import divinerpg.DivineRPG;
import divinerpg.client.particle.*;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleHandler {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.APALACHIA_PORTAL.get(), ParticleApalachiaPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.EDEN_PORTAL.get(), ParticleEdenPortal.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MORTUM_PORTAL.get(), ParticleMortumPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SKYTHERN_PORTAL.get(), ParticleSkythernPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.WILDWOOD_PORTAL.get(), ParticleWildwoodPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.GREEN_PORTAL.get(), ParticleGreenPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.BLACK_FLAME.get(),  ParticleColoredFlame.BlackProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.BLUE_FLAME.get(), ParticleColoredFlame.AquaProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.GREEN_FLAME.get(), ParticleColoredFlame.GreenProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.PURPLE_FLAME.get(), ParticleColoredFlame.PurpleProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.FROST.get(), ParticleFrost.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SPARKLER.get(), ParticleSparkler.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.ENDER_TRIPLET.get(), ParticleEnderTriplet.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.TAR.get(), ParticleTar.Factory::new);


        DivineRPG.LOGGER.info("[DivineRPG] Registered particles");
    }
}
