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
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.config.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.*;
import net.minecraftforge.registries.*;
import org.apache.logging.log4j.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";
    public static DRPGTab tabs = new DRPGTab();

    public DivineRPG() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::post);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::client);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
        EventRegistry.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        DeferredRegister<?>[] registers = {
                ParticleRegistry.PARTICLES,
                StructureRegistry.DEFERRED_REGISTRY_STRUCTURE,
                TraderProfession.PROFESSIONS,
                ContainerRegistry.CONTAINER_TYPES,
                RecipeRegistry.Serailizers.RECIPE_SERIALIZERS
        };

        for (DeferredRegister<?> register : registers) {
            register.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        tabs.init();
        EntityRegistry.registerSpawns();
        KeyRegistry.init();
        FeatureRegistry.registerOres();
        ModCompat.initCommon(event);
        TriggerRegistry.registerTriggers();
        CapabilityManager.INSTANCE.register(IArcana.class, new ArcanaStorage(), Arcana::new);

        event.enqueueWork(() -> {
            StructureRegistry.setupStructures();
            ConfiguredStructureRegistry.registerConfiguredStructures();
        });
    }

    private void client(final FMLClientSetupEvent event) {
        EntityRegistry.render();
        FancyRenders.init();
        MinecraftForge.EVENT_BUS.register(new ArcanaRenderer());
        ModelPropRegistry.init();

        event.enqueueWork(() -> {
            ContainerRegistry.registerScreenFactories();
        });
    }

    private void post(final FMLLoadCompleteEvent event){
        Utils.loadHatInformation();
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
    }
}
