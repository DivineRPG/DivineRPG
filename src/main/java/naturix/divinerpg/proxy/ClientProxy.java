package naturix.divinerpg.proxy;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModEntities;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
    

    public void registerItemRenderer(Item item, int meta, String id) {
    	if (Config.debug = true) {
        DivineRPG.logger.info(id.toLowerCase() + "'s model has just been registered");
        }
    	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(DivineRPG.modId + ":" + id, "inventory"));
    }
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ModEntities.initModels();
    }
    
}
