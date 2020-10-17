package divinerpg.client;

import divinerpg.client.renders.vanilla.*;
import divinerpg.registries.EntityRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderEntities {
    public static void render() {
//        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.ARID_WARRIOR, RenderAridWarrior::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.SHARK, RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.WHALE, RenderWhale::new);
    }
}
