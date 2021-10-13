package divinerpg;

import divinerpg.capability.*;
import divinerpg.client.*;
import divinerpg.compat.*;
import divinerpg.config.*;
import divinerpg.events.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.data.*;
import net.minecraftforge.common.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.config.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.*;
import org.apache.logging.log4j.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";
    public static DRPGTab tabs = new DRPGTab();

    public DivineRPG() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::post);
        bus.addListener(this::client);
        bus.addListener(this::gatherData);
        EventRegistry.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        ParticleRegistry.PARTICLES.register(bus);
        StructureRegistry.DEFERRED_REGISTRY_STRUCTURE.register(bus);
        TraderProfession.PROFESSIONS.register(bus);
        ContainerRegistry.CONTAINER_TYPES.register(bus);
        RecipeRegistry.Serailizers.RECIPE_SERIALIZERS.register(bus);
        KeyRegistry.POI.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        DecoratorRegistry.DECORATORS.register(bus);
        BuilderRegistry.SURFACE_BUILDERS.register(bus);

    }

    private void setup(final FMLCommonSetupEvent event) {
        tabs.init();
        KeyRegistry.init();
        FeatureRegistry.register();
        ModCompat.initCommon(event);
        TriggerRegistry.registerTriggers();
        ArcanaCapability.register();
        NetworkingRegistry.init();
        StructureRegistry.setupStructures();
        ConfiguredStructureRegistry.registerConfiguredStructures();

    }

    private void client(final FMLClientSetupEvent event) {
        EntityRegistry.render();
        FancyRenders.init();
        MinecraftForge.EVENT_BUS.register(new ArcanaRenderer());
        ModelPropRegistry.init();
        ContainerRegistry.registerScreenFactories();
    }

    private void post(final FMLLoadCompleteEvent event){
        Utils.loadHatInformation();
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
    }
}
