package net.divinerpg.utils.proxies;

import java.util.Random;

import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.client.ArcanaRenderer;
import net.divinerpg.client.ClientTickHandler;
import net.divinerpg.client.render.BossTickHandler;
import net.divinerpg.client.render.entity.ArcanaEntityRenderer;
import net.divinerpg.client.render.entity.IceikaEntityRenderer;
import net.divinerpg.client.render.entity.TwilightEntityRenderer;
import net.divinerpg.client.render.entity.VanillaEntityRenderer;
import net.divinerpg.client.render.entity.VetheaEntityRenderer;
import net.divinerpg.client.render.item.RenderBow;
import net.divinerpg.client.render.item.RenderPhaser;
import net.divinerpg.client.render.item.RenderProjectileShooter;
import net.divinerpg.entities.fx.EntityBlackFlameFX;
import net.divinerpg.entities.fx.EntityBlueFlameFX;
import net.divinerpg.entities.fx.EntityEdenPortalFX;
import net.divinerpg.entities.fx.EntityGreenFlameFX;
import net.divinerpg.entities.fx.EntityGreenPortalFX;
import net.divinerpg.entities.fx.EntityMortumPortalFX;
import net.divinerpg.entities.fx.EntitySkythernPortalFX;
import net.divinerpg.entities.fx.EntityWildWoodPortalFX;
import net.divinerpg.items.vanilla.ItemProjectileShooter;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.DevHatEvent;
import net.divinerpg.utils.events.EventClientLogin;
import net.divinerpg.utils.events.EventFog;
import net.divinerpg.utils.events.EventOverlay;
import net.divinerpg.utils.events.EventStaffLogin;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	private static Random rand = new Random();
	
    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        LogHelper.info("Adding events");
        if(ConfigurationHelper.canShowWelcomeChat) Util.postForgeEvent(new EventClientLogin());
        else Util.postForgeEvent(new EventStaffLogin());
        Util.postFMLEvent(new ClientTickHandler());
        Util.postFMLEvent(new ArcanaRenderer());
        
        for(Item bow : ItemModBow.bowList) {
        	MinecraftForgeClient.registerItemRenderer(bow, new RenderBow());
        }
        
        for(Item gun : ItemProjectileShooter.gunList) {
        	MinecraftForgeClient.registerItemRenderer(gun, new RenderProjectileShooter());
        }
        
        for(Item phaser : ItemProjectileShooter.phaserList) {
        	MinecraftForgeClient.registerItemRenderer(phaser, new RenderPhaser());
        }
        
        MinecraftForgeClient.registerItemRenderer(VanillaItemsWeapons.corruptedCannon, new RenderProjectileShooter());
        
        if (Reference.DEBUG) {
            LogHelper.dev("Entering DEBUG mode");
            Util.postForgeEvent(new EventOverlay());
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
        Util.postFMLEvent(new BossTickHandler());
        LogHelper.info("Adding sounds");
        Util.postForgeEvent(new DevHatEvent());
        Util.postForgeEvent(new EventFog());
    }
    
    @Override
    public void spawnParticle(World w, double x, double y, double z, String particle, boolean random) {
    	if(random) {
    		x += (rand.nextDouble()-rand.nextDouble())/4;
    		y += (rand.nextDouble()-rand.nextDouble())/4;
    		z += (rand.nextDouble()-rand.nextDouble())/4;
    	}
    	EntityFX fx = null;
    	if(particle == "eden") fx = new EntityEdenPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "wildwood") fx = new EntityWildWoodPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "apalachia") fx = new EntityPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "skythern") fx = new EntitySkythernPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "mortum") fx = new EntityMortumPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "halite") fx = new EntityGreenPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "greenFlame") fx = new EntityGreenFlameFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "blackFlame") fx = new EntityBlackFlameFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	else if(particle == "blueFlame") fx = new EntityBlueFlameFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    	if(fx != null) FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
    }
}
