package TeamDivineRPG.divinerpg.client;

import TeamDivineRPG.divinerpg.client.renders.RenderWhale;
import TeamDivineRPG.divinerpg.registries.EntityRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderEntities {
    public static void render(){
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.WHALE, RenderWhale::new);
    }
}
