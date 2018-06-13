package naturix.divinerpg.proxy;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModEntities;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(DivineRPG.modId + ":" + id, "inventory"));
    }
    public void registerEntityRenderer(Entity entity, int meta, String id) {
    	ModEntities.init();
    }
}
