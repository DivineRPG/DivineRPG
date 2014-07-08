package net.divinerpg.client;

import net.divinerpg.CommonProxy;
import net.divinerpg.DivineRPG;
import net.divinerpg.Reference;
import net.divinerpg.Sounds;
import net.divinerpg.client.render.BossTickHandler;
import net.divinerpg.client.render.entity.ArcanaEntityRenderer;
import net.divinerpg.client.render.entity.IceikaEntityRenderer;
import net.divinerpg.client.render.entity.TwilightEntityRenderer;
import net.divinerpg.client.render.entity.VanillaEntityRenderer;
import net.divinerpg.client.render.entity.VetheaEntityRenderer;
import net.divinerpg.helper.Util;
import net.divinerpg.helper.event.EventExtraArmor;
import net.divinerpg.helper.event.EventOverlay;
import net.divinerpg.helper.utils.LangRegistry;
import net.divinerpg.helper.utils.LogHelper;

import com.jadarstudios.developercapes.DevCapes;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        LogHelper.info("Adding events");
        //if(ConfigurationHelper.canShowWelcomeChat) Util.addEventBus(new EventClientLogin());
        //if(!ConfigurationHelper.canShowWelcomeChat) Util.addEventBus(new EventStaffLogin());
        Util.addSpecialEventBus(new ArcanaTickHandler());
        Util.addSpecialEventBus(new ClientTickHandler());
        if (Reference.DEBUG) {
            LogHelper.dev("Entering DEBUG mode");
            Util.addEventBus(new EventOverlay());
            Util.addEventBus(new EventExtraArmor());
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
