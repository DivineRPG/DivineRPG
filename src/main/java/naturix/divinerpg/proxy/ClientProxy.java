package naturix.divinerpg.proxy;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.client.ArcanaRenderer;
import naturix.divinerpg.client.ClientTicker;
import naturix.divinerpg.client.render.RenderItemFrostedChest;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityFrostedChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityAyeracoBeam;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixStatue;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.objects.blocks.tile.render.RenderAyeracoBeam;
import naturix.divinerpg.objects.blocks.tile.render.RenderDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.render.RenderDramixStatue;
import naturix.divinerpg.objects.blocks.tile.render.RenderIceikaChest;
import naturix.divinerpg.objects.blocks.tile.render.TileEntityDramixAltarRender;
import naturix.divinerpg.objects.blocks.tile.render.TileEntityParasectaAltarRender;
import naturix.divinerpg.particle.ParticleApalachiaPortal;
import naturix.divinerpg.particle.ParticleBlackFlame;
import naturix.divinerpg.particle.ParticleBlueFlame;
import naturix.divinerpg.particle.ParticleEdenPortal;
import naturix.divinerpg.particle.ParticleEnderTriplet;
import naturix.divinerpg.particle.ParticleFrost;
import naturix.divinerpg.particle.ParticleGreenFlame;
import naturix.divinerpg.particle.ParticleMortumPortal;
import naturix.divinerpg.particle.ParticleSkythernPortal;
import naturix.divinerpg.particle.ParticleSparkler;
import naturix.divinerpg.particle.ParticleWildWoodPortal;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.GUIHandler;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
    public static MusicTicker.MusicType Music_Iceika;

    ArcanaHelper ah;

    @Override
    public EntityPlayer getPlayer() {
        return FMLClientHandler.instance().getClientPlayerEntity();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        DRPGSoundHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(DivineRPG.instance, new GUIHandler());
        Utils.setupCapes();
        Utils.updateCapeList();

        Music_Iceika = EnumHelperClient.addMusicType("iceika_music", DRPGSoundHandler.ICEIKA_MUSIC, 1200, 12000);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        Utils.postFMLEvent(new ArcanaRenderer());
        Utils.postFMLEvent(new ClientTicker());

    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModEntities.initModels();
        OBJLoader.INSTANCE.addDomain(Reference.MODID);

    }

    @Override
    public void registerItemRenderer(final Item item, final int meta, final String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        if (item.equals(Item.getItemFromBlock(ModBlocks.frostedChest))) {
            item.setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        }
    }

    @Override
    public void RegisterTileEntityRender() {
        // ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVase.class, new
        // TileEntityVaseRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new TileEntityDramixAltarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new TileEntityParasectaAltarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrostedChest.class, new RenderIceikaChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAyeracoBeam.class, new RenderAyeracoBeam());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonFurnace.class, new RenderDemonFurnace());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixStatue.class, new RenderDramixStatue());
    }

    @Override
    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), id));
    }

    @Override
    public void spawnParticle(World world, DRPGParticleTypes particletype, double x, double y, double z, double velX,
            double velY, double velZ) {
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

            if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {
                Particle particle = null;

                switch (particletype) {
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
                case BLACK_FLAME:
                    particle = new ParticleBlackFlame(world, x, y, z, velX, velY, velZ);
                    break;
                case BLUE_FLAME:
                    particle = new ParticleBlueFlame(world, x, y, z, velX, velY, velZ);
                    break;
                case GREEN_FLAME:
                    particle = new ParticleGreenFlame(world, x, y, z, velX, velY, velZ);
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
                    mc.effectRenderer.addEffect(particle);
                }
            }
        }
    }

    @Override
    public void updateClientArcana(float amount) {
        // ArcanaHelper.getProperties(Minecraft.getMinecraft().player).setBarValue(amount);
    }

}
