package naturix.divinerpg.proxy;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.RenderTiles;
import naturix.divinerpg.events.EventDevHat;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.utils.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModEntities.initModels();
        OBJLoader.INSTANCE.addDomain(DivineRPG.modId);

    }
	@Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        RenderTiles.init();
        Utils.setupCapes();
        Utils.updateCapeList();
    }
	@Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        DivineRPG.registerEvent(new EventDevHat());
        
       }
	
    @Override
	public EntityPlayer getPlayer() {
		return FMLClientHandler.instance().getClientPlayerEntity();
	}

    public void registerItemRenderer(Item item, int meta, String id) {
    	if (Config.debug = true) {
        DivineRPG.logger.info(id.toLowerCase() + "'s model has just been registered");
        
        }
    	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(DivineRPG.modId + ":" + id, "inventory"));
    	
    }

 
}
