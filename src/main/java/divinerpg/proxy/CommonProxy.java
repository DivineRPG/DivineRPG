package divinerpg.proxy;

import java.awt.Color;
import java.io.File;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.Reference;
import divinerpg.capabilities.Arcana;
import divinerpg.capabilities.CapabilityArcana;
import divinerpg.capabilities.CapabilityHandler;
import divinerpg.capabilities.IArcana;
import divinerpg.enums.ParticleType;
import divinerpg.events.Ticker;
import divinerpg.objects.blocks.tile.entity.TileEntityAltarOfCorruption;
import divinerpg.objects.blocks.tile.entity.TileEntityArcaniumExtractor;
import divinerpg.objects.blocks.tile.entity.TileEntityAyeracoBeam;
import divinerpg.objects.blocks.tile.entity.TileEntityAyeracoSpawn;
import divinerpg.objects.blocks.tile.entity.TileEntityBoneChest;
import divinerpg.objects.blocks.tile.entity.TileEntityCoalstoneFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityDemonFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import divinerpg.objects.blocks.tile.entity.TileEntityEdenChest;
import divinerpg.objects.blocks.tile.entity.TileEntityFrostedChest;
import divinerpg.objects.blocks.tile.entity.TileEntityGreenlightFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityMoltenFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityMoonlightFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityOceanfireFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import divinerpg.objects.blocks.tile.entity.TileEntityPresentBox;
import divinerpg.objects.blocks.tile.entity.TileEntityStatue;
import divinerpg.objects.blocks.tile.entity.TileEntityStupidSpawner;
import divinerpg.objects.blocks.tile.entity.TileEntityWhitefireFurnace;
import divinerpg.registry.*;
import divinerpg.world.WorldGenTreeGenerator;
import divinerpg.world.structures.WorldGenCustomStructures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public static Configuration config;

    public EntityPlayer getPlayer() {
        return null;
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(DivineRPG.instance, new GUIHandler());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        CapabilityManager.INSTANCE.register(IArcana.class, new CapabilityArcana(), Arcana::new);
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
        ModEntities.initSpawns();
        if (Config.genJSON) {
            ModRecipes x = new ModRecipes();
        }
    }

    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ModEntities());
        ModDimensions.init();
        ModItems.init();
        ModBlocks.init();
        ModSeeds.init();
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenTreeGenerator(), 0);
        ModEntities.initLoot();
        MinecraftForge.EVENT_BUS.register(new Ticker());

        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "DivineRPG/divinerpg.cfg"));
        Config.readConfig();
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    @SuppressWarnings("deprecation")
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityDramixAltar.class, Reference.MODID + ":te_dramix_altar");
        GameRegistry.registerTileEntity(TileEntityParasectaAltar.class, Reference.MODID + ":te_parasecta_altar");
        GameRegistry.registerTileEntity(TileEntityCoalstoneFurnace.class, Reference.MODID + ":te_colastone_furnace");
        GameRegistry.registerTileEntity(TileEntityMoltenFurnace.class, Reference.MODID + ":te_molten_furnace");
        GameRegistry.registerTileEntity(TileEntityOceanfireFurnace.class, Reference.MODID + ":te_oceanfire_furnace");
        GameRegistry.registerTileEntity(TileEntityWhitefireFurnace.class, Reference.MODID + ":te_whitefire_furnace");
        GameRegistry.registerTileEntity(TileEntityDemonFurnace.class, Reference.MODID + ":te_demon_furnace");
        GameRegistry.registerTileEntity(TileEntityGreenlightFurnace.class, Reference.MODID + ":te_greenlight_furnace");
        GameRegistry.registerTileEntity(TileEntityMoonlightFurnace.class, Reference.MODID + ":te_moonlight_furnace");
        GameRegistry.registerTileEntity(TileEntityArcaniumExtractor.class, Reference.MODID + ":te_arcanium_extractor");
        GameRegistry.registerTileEntity(TileEntityFrostedChest.class, Reference.MODID + ":te_iceika_chest");
        GameRegistry.registerTileEntity(TileEntityAyeracoBeam.class, Reference.MODID + ":te_ayeraco_beam");
        GameRegistry.registerTileEntity(TileEntityAyeracoSpawn.class, Reference.MODID + ":te_ayeraco_spawn");
        GameRegistry.registerTileEntity(TileEntityPresentBox.class, Reference.MODID + ":te_present_box");
        GameRegistry.registerTileEntity(TileEntityBoneChest.class, Reference.MODID + ":te_bone_chest");
        GameRegistry.registerTileEntity(TileEntityAltarOfCorruption.class, Reference.MODID + ":te_altar_of_corruption");
        GameRegistry.registerTileEntity(TileEntityStatue.class, Reference.MODID + ":te_statue");
        GameRegistry.registerTileEntity(TileEntityEdenChest.class, Reference.MODID + ":te_eden_chest");
        GameRegistry.registerTileEntity(TileEntityStupidSpawner.class, Reference.MODID + ":te_stupid_spawner");
    }

    public void RegisterTileEntityRender() {
    }

    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
    }

    public void spawnParticle(World world, ParticleType particle, double z, double x, double y, double velX,
            double velY, double velZ) {
    }

    public void spawnParticle(World w, double x, double y, double z, String particle, boolean random) {
    }

    public void spawnColoredParticle(World world, double x, double y, double z, Color color, boolean bigger,
            boolean shortLived) {
    }

    public void updateClientArcana(float amount) {
    }

    public void enqueueWork(Runnable runnable) {
        FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(runnable);
    }
}