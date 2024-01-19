package divinerpg;

import divinerpg.compat.ModCompat;
import divinerpg.config.*;
import divinerpg.events.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import divinerpg.util.vanilla.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.*;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";

    public DivineRPG(IEventBus bus) {
        EventRegistry.init();
        bus.addListener(this::setup);
        bus.addListener(this::post);
        bus.addListener(this::client);
        NeoForge.EVENT_BUS.addListener(AttatchCapabilityEvent::onAttachCapabilitiesPlayer);
        NeoForge.EVENT_BUS.addListener(AttatchCapabilityEvent::onAttachCapabilitiesLevelChunk);
        NeoForge.EVENT_BUS.addListener(AttatchCapabilityEvent::onRegisterCapabilities);
        NeoForge.EVENT_BUS.addListener(SpawnEvents::spawnPlacementCheck);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, DivineRPG.MODID + "/divinerpg-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, DivineRPG.MODID + "/divinerpg-common.toml");

        NeoForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModCompat.initCommon(event);
        TriggerRegistry.registerTriggers();
        PlacementModifierRegistry.init();
        DivineRPGPacketHandler.init();

        event.enqueueWork(() -> {
            RecipeRegistry.BrewingRecipes.init();
            LogStripper.setup(event);
            PlantPots.setup(event);
            Compostables.setup(event);
        });
    }
    private void client(final FMLClientSetupEvent event) {
        ModelPropRegistry.init();
        MenuTypeRegistry.registerScreenFactories();
        BlockEntityRegistry.renderTiles();
        NeoForge.EVENT_BUS.register(new ArcanaRenderer());
        NeoForge.EVENT_BUS.register(new EventClientLogin());
        Utils.loadHatInformation();
    }
    private void post(final FMLLoadCompleteEvent event){
    }
}