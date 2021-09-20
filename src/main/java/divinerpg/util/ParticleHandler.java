package divinerpg.util;


import divinerpg.*;
import divinerpg.client.particle.*;
import divinerpg.registries.*;
import net.minecraft.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.APALACHIA_PORTAL.get(), ParticleApalachiaPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.EDEN_PORTAL.get(), ParticleEdenPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MORTUM_PORTAL.get(), ParticleMortumPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SKYTHERN_PORTAL.get(), ParticleSkythernPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.WILDWOOD_PORTAL.get(), ParticleWildwoodPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.GREEN_PORTAL.get(), ParticleGreenPortal.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.BLACK_FLAME.get(),  ParticleColoredFlame.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.BLUE_FLAME.get(), ParticleColoredFlame.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.GREEN_FLAME.get(), ParticleColoredFlame.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.PURPLE_FLAME.get(), ParticleColoredFlame.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.FROST.get(), ParticleFrost.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SPARKLER.get(), ParticleSparkler.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.ENDER_TRIPLET.get(), ParticleEnderTriplet.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.TAR.get(), ParticleTar.Factory::new);


        DivineRPG.LOGGER.info("[DivineRPG] Registered particles");
    }
}
