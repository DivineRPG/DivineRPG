package net.divinerpg.utils.proxies;

import java.util.Random;

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
import net.divinerpg.client.render.item.RenderPhaser;
import net.divinerpg.client.render.item.RenderProjectileShooter;
import net.divinerpg.entities.twilight.effects.EntityEdenPortalFX;
import net.divinerpg.entities.twilight.effects.EntityGreenPortalFX;
import net.divinerpg.entities.twilight.effects.EntityMortumPortalFX;
import net.divinerpg.entities.twilight.effects.EntitySkythernPortalFX;
import net.divinerpg.entities.twilight.effects.EntityWildWoodPortalFX;
import net.divinerpg.items.vanilla.ItemProjectileShooter;
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
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	private static Random rand = new Random();
	
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
        
        for(Item gun : ItemProjectileShooter.gunList) {
        	MinecraftForgeClient.registerItemRenderer(gun, new RenderProjectileShooter());
        }
        
        for(Item phaser : ItemProjectileShooter.phaserList) {
        	MinecraftForgeClient.registerItemRenderer(phaser, new RenderPhaser());
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
        MinecraftForge.EVENT_BUS.register(new DevHatEvent());
    }
    
    @Override
    public void spawnParticle(World w, double x, double y, double z, String particle) {
    	EntityFX fx = null;
    	if(particle == "eden") fx = new EntityEdenPortalFX(w, x+rand.nextDouble()/4, y+rand.nextDouble()/4, z+rand.nextDouble()/4, 0.0D, 0.0D, 0.0D);
    	else if(particle == "wildwood") fx = new EntityWildWoodPortalFX(w, x+rand.nextDouble()/4, y+rand.nextDouble()/4, z+rand.nextDouble()/4, 0.0D, 0.0D, 0.0D);
    	else if(particle == "apalachia") fx = new EntityPortalFX(w, x+rand.nextDouble()/4, y+rand.nextDouble()/4, z+rand.nextDouble()/4, 0.0D, 0.0D, 0.0D);
    	else if(particle == "skythern") fx = new EntitySkythernPortalFX(w, x+rand.nextDouble()/4, y+rand.nextDouble()/4, z+rand.nextDouble()/4, 0.0D, 0.0D, 0.0D);
    	else if(particle == "mortum") fx = new EntityMortumPortalFX(w, x+rand.nextDouble()/4, y+rand.nextDouble()/4, z+rand.nextDouble()/4, 0.0D, 0.0D, 0.0D);
    	else if(particle == "halite") fx = new EntityGreenPortalFX(w, x+rand.nextDouble()/4, y+rand.nextDouble()/4, z+rand.nextDouble()/4, 0.0D, 0.0D, 0.0D);
    	if(fx != null) FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
    }
}
