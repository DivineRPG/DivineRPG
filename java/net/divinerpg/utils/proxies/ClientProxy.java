package net.divinerpg.utils.proxies;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.client.ArcanaRenderer;
import net.divinerpg.client.ClientTickHandler;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.client.render.BossTickHandler;
import net.divinerpg.client.render.entity.ArcanaEntityRenderer;
import net.divinerpg.client.render.entity.IceikaEntityRenderer;
import net.divinerpg.client.render.entity.TwilightEntityRenderer;
import net.divinerpg.client.render.entity.VanillaEntityRenderer;
import net.divinerpg.client.render.entity.VetheaEntityRenderer;
import net.divinerpg.client.render.item.RenderBow;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.DevHatEvent;
import net.divinerpg.utils.events.EventClientLogin;
import net.divinerpg.utils.events.EventOverlay;
import net.divinerpg.utils.events.EventStaffLogin;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        LogHelper.info("Adding events");
        if(ConfigurationHelper.canShowWelcomeChat) Util.addEventBus(new EventClientLogin());
        else Util.addEventBus(new EventStaffLogin());
        Util.addSpecialEventBus(new ClientTickHandler());
        Util.addSpecialEventBus(new ArcanaRenderer());
        
        for(Item bow : ItemModBow.bowList) {
        	MinecraftForgeClient.registerItemRenderer(bow, new RenderBow());
        }
        
        if (Reference.DEBUG) {
            LogHelper.dev("Entering DEBUG mode");
            Util.addEventBus(new EventOverlay());
            LangRegistry.registerNames();
            Sounds.init();
        }
    }

    @Override
    public void renderThings() {
        LogHelper.info("Adding renderers");
        VanillaEntityRenderer.init();
        TwilightEntityRenderer.init();
        IceikaEntityRenderer.init();
        VetheaEntityRenderer.init();
        ArcanaEntityRenderer.init();
        LogHelper.info("Adding gui renderers");
        Util.addSpecialEventBus(new BossTickHandler());
        LogHelper.info("Adding sounds");
        NetworkRegistry.INSTANCE.registerGuiHandler(DivineRPG.instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new DevHatEvent());
    }
}
