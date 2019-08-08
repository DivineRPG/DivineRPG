package naturix.divinerpg.proxy;

import java.awt.Color;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.client.ArcanaRenderer;
import naturix.divinerpg.client.ClientTicker;
import naturix.divinerpg.client.render.RenderItemArcaniumExtractor;
import naturix.divinerpg.client.render.RenderItemBoneChest;
import naturix.divinerpg.client.render.RenderItemDemonFurnace;
import naturix.divinerpg.client.render.RenderItemDramixAltar;
import naturix.divinerpg.client.render.RenderItemEdenChest;
import naturix.divinerpg.client.render.RenderItemFrostedChest;
import naturix.divinerpg.client.render.RenderItemParasectaAltar;
import naturix.divinerpg.client.render.RenderItemPresentBox;
import naturix.divinerpg.client.render.RenderItemStatue;
import naturix.divinerpg.events.EventBowZoom;
import naturix.divinerpg.events.EventClientLogin;
import naturix.divinerpg.events.EventTooltip;
import naturix.divinerpg.objects.blocks.BlockStatue;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityAltarOfCorruption;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityArcaniumExtractor;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityAyeracoBeam;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityAyeracoSpawn;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityBoneChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityEdenChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityFrostedChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityPresentBox;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityStatue;
import naturix.divinerpg.objects.blocks.tile.render.RenderAltarOfCorruption;
import naturix.divinerpg.objects.blocks.tile.render.RenderArcaniumExtractor;
import naturix.divinerpg.objects.blocks.tile.render.RenderAyeracoBeam;
import naturix.divinerpg.objects.blocks.tile.render.RenderAyeracoSpawn;
import naturix.divinerpg.objects.blocks.tile.render.RenderBoneChest;
import naturix.divinerpg.objects.blocks.tile.render.RenderDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.render.RenderDramixAltar;
import naturix.divinerpg.objects.blocks.tile.render.RenderEdenChest;
import naturix.divinerpg.objects.blocks.tile.render.RenderFrostedChest;
import naturix.divinerpg.objects.blocks.tile.render.RenderParasectaAltar;
import naturix.divinerpg.objects.blocks.tile.render.RenderPresentBox;
import naturix.divinerpg.objects.blocks.tile.render.RenderStatue;
import naturix.divinerpg.particle.ParticleApalachiaPortal;
import naturix.divinerpg.particle.ParticleColored;
import naturix.divinerpg.particle.ParticleColoredFlame;
import naturix.divinerpg.particle.ParticleEdenPortal;
import naturix.divinerpg.particle.ParticleEnderTriplet;
import naturix.divinerpg.particle.ParticleFrost;
import naturix.divinerpg.particle.ParticleGreenPortal;
import naturix.divinerpg.particle.ParticleMortumPortal;
import naturix.divinerpg.particle.ParticleSkythernPortal;
import naturix.divinerpg.particle.ParticleSparkler;
import naturix.divinerpg.particle.ParticleWildWoodPortal;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.Utils;
import naturix.divinerpg.utils.log.InitLog;
import naturix.divinerpg.utils.log.IntenseDebug;
import naturix.divinerpg.utils.log.PostInitLog;
import naturix.divinerpg.utils.log.PreInitLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    public static MusicTicker.MusicType Music_Iceika;
    public static ArcanaHelper arcanaHelper;

    @Override
    public EntityPlayer getPlayer() {
        return FMLClientHandler.instance().getClientPlayerEntity();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        Utils.setupCapes();
        Utils.updateCapeList();

        InitLog.init();
        Music_Iceika = EnumHelperClient.addMusicType("iceika_music", ModSounds.ICEIKA_MUSIC, 1200, 12000);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        Utils.postFMLEvent(new ArcanaRenderer());
        Utils.postFMLEvent(new ClientTicker());
        MinecraftForge.EVENT_BUS.register(new EventClientLogin());
        MinecraftForge.EVENT_BUS.register(new EventTooltip());

        PostInitLog.init();
        IntenseDebug.init();
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        //ModelLoader.setCustomStateMapper(ModBlocks.tar, new StateMap.Builder().ignore(BlockFluidBase.LEVEL).build());
        ModEntities.initModels();
        OBJLoader.INSTANCE.addDomain(Reference.MODID);
        MinecraftForge.EVENT_BUS.register(new EventBowZoom());
        PreInitLog.init();
    }

    @Override
    public void registerItemRenderer(final Item item, final int meta, final String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
        if (item.equals(Item.getItemFromBlock(ModBlocks.frostedChest))
                || item.equals(Item.getItemFromBlock(ModBlocks.decorativeFrostedChest))) {
            item.setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.presentBox))) {
            item.setTileEntityItemStackRenderer(new RenderItemPresentBox());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.boneChest))) {
            item.setTileEntityItemStackRenderer(new RenderItemBoneChest());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.demonFurnace))) {
            item.setTileEntityItemStackRenderer(new RenderItemDemonFurnace());
        } else if (item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof BlockStatue) {
            item.setTileEntityItemStackRenderer(new RenderItemStatue());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.edenChest))) {
            item.setTileEntityItemStackRenderer(new RenderItemEdenChest());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.arcaniumExtractor))) {
            item.setTileEntityItemStackRenderer(new RenderItemArcaniumExtractor());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.dramixAltar))) {
            item.setTileEntityItemStackRenderer(new RenderItemDramixAltar());
        } else if (item.equals(Item.getItemFromBlock(ModBlocks.parasectaAltar))) {
            item.setTileEntityItemStackRenderer(new RenderItemParasectaAltar());
        }
    }

    @Override
    public void RegisterTileEntityRender() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new RenderDramixAltar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new RenderParasectaAltar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrostedChest.class, new RenderFrostedChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAyeracoBeam.class, new RenderAyeracoBeam());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAyeracoSpawn.class, new RenderAyeracoSpawn());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonFurnace.class, new RenderDemonFurnace());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArcaniumExtractor.class, new RenderArcaniumExtractor());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresentBox.class, new RenderPresentBox());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoneChest.class, new RenderBoneChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltarOfCorruption.class, new RenderAltarOfCorruption());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatue.class, new RenderStatue());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEdenChest.class, new RenderEdenChest());
    }

    @Override
    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), id));
    }

    @Override
    public void spawnParticle(World w, double x, double y, double z, String particle, boolean random) {
        this.spawnParticle(w, x, y, z, particle, random);
    }

    @Override
    public void spawnParticle(World world, DRPGParticleTypes particletype, double x, double y, double z, double velX,
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
                return true;
            }
        }

        return false;
    }

    @Override
    public void updateClientArcana(float amount) {
        IArcana arcana = Minecraft.getMinecraft().player.getCapability(ArcanaProvider.ARCANA_CAP, null);
        arcana.set(amount);
    }

}
