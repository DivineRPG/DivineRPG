package divinerpg;

import divinerpg.client.*;
import divinerpg.compat.*;
import divinerpg.events.*;
import divinerpg.registries.*;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.*;
import net.minecraftforge.common.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.*;

import java.util.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";
    public static DRPGTab tabs = new DRPGTab();

    public static List<Class<? extends TileEntity>> registeredDivineTiles = new ArrayList<>();

    public DivineRPG() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ProtectPetsEvent());
        MinecraftForge.EVENT_BUS.register(new ArmorAbilitiesEvent());
    }

    private void setup(final FMLCommonSetupEvent event) {
        tabs.init();
        EntityRegistry.init();
        KeyRegistry.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRegistry.render();
        FancyRenders.init();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
}
