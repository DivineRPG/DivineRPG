package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelDramcryx;
import naturix.divinerpg.entities.entity.vanilla.JungleDramcryx;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleDramcryx extends RenderLiving<JungleDramcryx> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_dramcryx.png");

    public RenderJungleDramcryx(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramcryx(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(JungleDramcryx entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<JungleDramcryx> {
        @Override
        public Render<? super JungleDramcryx> createRenderFor(RenderManager manager) {
            return new RenderJungleDramcryx(manager, new ModelDramcryx(), 0F);
        }
    }
}