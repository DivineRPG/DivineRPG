package divinerpg;

import divinerpg.client.*;
import divinerpg.client.renders.layer.*;
import divinerpg.config.*;
import divinerpg.events.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.data.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.config.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.*;
import org.apache.logging.log4j.*;

import java.util.*;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "divinerpg";
    public static DRPGTab tabs = new DRPGTab();

    public DivineRPG() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::post);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ProtectPetsEvent());
        MinecraftForge.EVENT_BUS.register(new ArmorAbilitiesEvent());
        MinecraftForge.EVENT_BUS.register(new EventClientLogin());
        MinecraftForge.EVENT_BUS.register(new MissingMappingEvent());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    }

    private void setup(final FMLCommonSetupEvent event) {
        tabs.init();
        EntityRegistry.init();
        KeyRegistry.init();
        FeatureRegistry.registerOres();
    }
    private void post(final FMLLoadCompleteEvent event){
        Utils.loadHatInformation();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRegistry.render();
        FancyRenders.init();

        Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getRenderManager().getSkinMap();
        PlayerRenderer render;
        render = skinMap.get("default");
        render.addLayer(new PlayerHatRender<>(render));

        render = skinMap.get("slim");
        render.addLayer(new PlayerHatRender<>(render));
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
    }
}
