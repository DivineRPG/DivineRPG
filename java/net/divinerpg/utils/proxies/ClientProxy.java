package net.divinerpg.utils.proxies;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.ArcanaTickHandler;
import net.divinerpg.client.ClientTickHandler;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.client.render.BossTickHandler;
import net.divinerpg.client.render.entity.ArcanaEntityRenderer;
import net.divinerpg.client.render.entity.IceikaEntityRenderer;
import net.divinerpg.client.render.entity.TwilightEntityRenderer;
import net.divinerpg.client.render.entity.VanillaEntityRenderer;
import net.divinerpg.client.render.entity.VetheaEntityRenderer;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.EventClientLogin;
import net.divinerpg.utils.events.EventExtraArmor;
import net.divinerpg.utils.events.EventOverlay;
import net.divinerpg.utils.events.EventStaffLogin;

import com.jadarstudios.developercapes.DevCapes;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        LogHelper.info("Adding events");
        if(ConfigurationHelper.canShowWelcomeChat) Util.addEventBus(new EventClientLogin());
        else Util.addEventBus(new EventStaffLogin());
        Util.addSpecialEventBus(new ArcanaTickHandler());
        Util.addSpecialEventBus(new ClientTickHandler());
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
        if (Reference.registerCapes) {
            LogHelper.info("Adding capes");
            DevCapes.getInstance().registerConfig("https://dl-web.dropbox.com/get/Divine%20RPG/DivineRPGCapes.json", Reference.MOD_NAME);
        }
    }
}
