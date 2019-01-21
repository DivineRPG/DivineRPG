package naturix.divinerpg.entities.assets.render.vanilla;

import naturix.divinerpg.entities.entity.vanilla.Cyclops;
import net.minecraft.client.Minecraft;

public class DodgyRenders {
	
//	public static Field modelManager = ReflectionHelper.findField(Minecraft.class, "modelManager", "field_175617_aL");
//    public static Field renderItem = ReflectionHelper.findField(Minecraft.class, "renderItem", "field_175621_X");
//    public static Field itemRenderer = ReflectionHelper.findField(ItemRenderer.class, "itemRenderer", "field_178112_h");
//    public static Field playerRenderer = ReflectionHelper.findField(RenderManager.class, "playerRenderer", "field_178637_m");
//    public static Field skinMap = ReflectionHelper.findField(RenderManager.class, "skinMap", "field_178636_l");
//	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static void replaceRenderers()
    {
        Minecraft mc = Minecraft.getMinecraft();


        mc.getRenderManager().entityRenderMap.put(Cyclops.class, new RenderCyclops(mc.getRenderManager(), 2f));

//        ((IReloadableResourceManager)(mc.getResourceManager())).registerReloadListener(modRenderItem);
    }
     
}
