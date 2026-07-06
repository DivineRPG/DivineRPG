package net.divinerpg;

import net.divinerpg.config.Config;
import net.divinerpg.data.DataGenerators;
import net.divinerpg.registries.DivineRegistries;
import net.divinerpg.registries.PaintingRegistry;
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
        bus.addListener(DataGenerators::genData);
        bus.addListener(DivineRegistries::creativeTab);
        NeoForge.EVENT_BUS.register(this);
        DivineRegistries.register(bus);
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
