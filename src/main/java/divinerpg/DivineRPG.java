package divinerpg;

import divinerpg.client.*;
import divinerpg.compat.*;
import divinerpg.config.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.data.*;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::post);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
        EventRegistry.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    }

    private void setup(final FMLCommonSetupEvent event) {
        tabs.init();
        EntityRegistry.init();
        KeyRegistry.init();
        FeatureRegistry.registerOres();
        ModCompat.initCommon(event);
    }
    private void post(final FMLLoadCompleteEvent event){
        Utils.loadHatInformation();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRegistry.render();
        FancyRenders.init();
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
    }
}
