package divinerpg;

import divinerpg.config.Config;
import divinerpg.data.DataGenerators;
import divinerpg.events.SpawnEvents;
import divinerpg.network.Payloads;
import divinerpg.registries.*;
import divinerpg.utils.Utils;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(DivineRPG.MODID)
public class DivineRPG {
    public static final String MODID = "divinerpg";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DivineRPG(IEventBus bus, ModContainer container) {
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(DataGenerators::genData);
        bus.addListener(DivineRegistries::creativeTab);
        bus.addListener(SpawnEvents::registerSpawnPlacements);
        bus.register(EntityRegistry.class);
        NeoForge.EVENT_BUS.register(this);
        bus.register(Payloads.class);
        DivineRegistries.register(bus);
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(()-> {
            Utils.loadHatInformation();
            BlockEntityRegistry.renderTiles();
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

}
