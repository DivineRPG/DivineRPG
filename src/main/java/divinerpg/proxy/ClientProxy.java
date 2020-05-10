package divinerpg.proxy;

import divinerpg.api.Reference;
import divinerpg.client.ArcanaRenderer;
import divinerpg.enums.ParticleType;
import divinerpg.events.EventBowZoom;
import divinerpg.events.EventClientLogin;
import divinerpg.events.EventTooltip;
import divinerpg.objects.entities.assets.render.PlayerHatRender;
import divinerpg.particle.*;
import divinerpg.registry.ModEntities;
import divinerpg.registry.ModSounds;
import divinerpg.utils.log.InitLog;
import divinerpg.utils.log.IntenseDebug;
import divinerpg.utils.log.PostInitLog;
import divinerpg.utils.log.PreInitLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.awt.*;

public class ClientProxy extends CommonProxy {
    public static MusicTicker.MusicType Music_Iceika;

    @Override
    public EntityPlayer getPlayer() {
        return FMLClientHandler.instance().getClientPlayerEntity();
    }

    @Deprecated
	@Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        InitLog.init();
        Music_Iceika = EnumHelperClient.addMusicType("iceika_music", ModSounds.ICEIKA_MUSIC, 1200, 12000);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        MinecraftForge.EVENT_BUS.register(new ArcanaRenderer());
        MinecraftForge.EVENT_BUS.register(new EventClientLogin());
        MinecraftForge.EVENT_BUS.register(new EventTooltip());

        PostInitLog.init();
        IntenseDebug.init();

        RenderPlayer renderPlayer = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
        if (renderPlayer != null) {
            renderPlayer.addLayer(new PlayerHatRender(renderPlayer));
        }
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModEntities.initModels();
        OBJLoader.INSTANCE.addDomain(Reference.MODID);
        MinecraftForge.EVENT_BUS.register(new EventBowZoom());
        PreInitLog.init();
    }

    @Override
    public void spawnParticle(World w, double x, double y, double z, String particle, boolean random) {
        this.spawnParticle(w, x, y, z, particle, random);
    }

    @Override
    public void spawnParticle(World world, ParticleType particletype, double x, double y, double z, double velX,
            double velY, double velZ) {
        if (canSpawnParticle(world, x, y, z)) {
            Particle particle = null;

            switch (particletype) {
            case NONE:
                break;
            case APALACHIA_PORTAL:
                particle = new ParticleApalachiaPortal(world, x, y, z, velX, velY, velZ);
                break;
            case EDEN_PORTAL:
                particle = new ParticleEdenPortal(world, x, y, z, velX, velY, velZ);
                break;
            case MORTUM_PORTAL:
                particle = new ParticleMortumPortal(world, x, y, z, velX, velY, velZ);
                break;
            case SKYTHERN_PORTAL:
                particle = new ParticleSkythernPortal(world, x, y, z, velX, velY, velZ);
                break;
            case WILDWOOD_PORTAL:
                particle = new ParticleWildWoodPortal(world, x, y, z, velX, velY, velZ);
                break;
            case GREEN_PORTAL:
                particle = new ParticleGreenPortal(world, x, y, z, velX, velY, velZ);
                break;
            case BLACK_FLAME:
                particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 0, 0, 0);
                break;
            case BLUE_FLAME:
                particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 0.3f, 0.7f, 1);
                break;
            case GREEN_FLAME:
                particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 0, 1, 0);
                break;
            case PURPLE_FLAME:
                particle = new ParticleColoredFlame(world, x, y, z, velX, velY, velZ, 1, 0, 1);
                break;
            case FROST:
                particle = new ParticleFrost(world, x, y, z, velX, velY, velZ);
                break;
            case SPARKLER:
                particle = new ParticleSparkler(world, x, y, z, velX, velY, velZ);
                break;
            case ENDER_TRIPLET:
                particle = new ParticleEnderTriplet(world, x, y, z, velX, velY, velZ);
                break;
            }

            if (particle != null) {
                Minecraft.getMinecraft().effectRenderer.addEffect(particle);
            }
        }
    }

    public void spawnColoredParticle(World world, double x, double y, double z, Color color, boolean bigger,
            boolean shortLived) {
        if (canSpawnParticle(world, x, y, z)) {
            Minecraft.getMinecraft().effectRenderer
                    .addEffect(new ParticleColored(world, x, y, z, 0, 0, 0, color, bigger, shortLived));
        }
    }

    private boolean canSpawnParticle(World world, double x, double y, double z) {
        if (FMLCommonHandler.instance().getEffectiveSide() != Side.CLIENT)
            return false;

        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = mc.getRenderViewEntity();

        if (entity != null && mc.effectRenderer != null) {
            int i = mc.gameSettings.particleSetting;

            if (i == 1 && world.rand.nextInt(3) == 0) {
                i = 2;
            }

            double d0 = entity.posX - x;
            double d1 = entity.posY - y;
            double d2 = entity.posZ - z;

            return d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1;
        }

        return false;
    }
//
//    @Override
//    public void updateClientArcana(float amount) {
//        EntityPlayer player = DivineRPG.proxy.getPlayer();
//
//        if (player != null) {
//            IArcana arcana = DivineAPI.getArcana(player);
//            if (arcana != null) {
//                arcana.set(amount);
//            }
//        }
//    }

}
