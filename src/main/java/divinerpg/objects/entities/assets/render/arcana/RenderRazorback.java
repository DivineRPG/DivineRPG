package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelRazorback;
import divinerpg.objects.entities.entity.arcana.EntityRazorback;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRazorback extends RenderLiving<EntityRazorback> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/razorback.png");

    public RenderRazorback(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRazorback(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRazorback entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityRazorback> {
        @Override
        public Render<? super EntityRazorback> createRenderFor(RenderManager manager) {
            return new RenderRazorback(manager, new ModelRazorback(), 0);
        }
    }
}