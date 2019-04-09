package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.ModelTheGrue;
import naturix.divinerpg.objects.entities.entity.vanilla.TheGrue;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTheGrue extends RenderLiving<TheGrue> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/the_grue.png");

    public RenderTheGrue(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTheGrue(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(TheGrue entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<TheGrue> {
        @Override
        public Render<? super TheGrue> createRenderFor(RenderManager manager) {
            return new RenderTheGrue(manager, new ModelTheGrue(), 0F);
        }
    }
}