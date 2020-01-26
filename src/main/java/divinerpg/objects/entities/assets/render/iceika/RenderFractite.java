package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelFractite;
import divinerpg.objects.entities.entity.iceika.EntityFractite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFractite extends RenderLiving<EntityFractite> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/fractite.png");

    public RenderFractite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelFractite(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFractite entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityFractite> {
        @Override
        public Render<? super EntityFractite> createRenderFor(RenderManager manager) {
            return new RenderFractite(manager, new ModelFractite(), 0.5F);
        }
    }
}