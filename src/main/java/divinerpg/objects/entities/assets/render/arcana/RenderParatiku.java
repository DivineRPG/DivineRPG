package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelParatiku;
import divinerpg.objects.entities.entity.arcana.EntityParatiku;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderParatiku extends RenderLiving<EntityParatiku> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/paratiku.png");

    public RenderParatiku(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelParatiku(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityParatiku entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityParatiku> {
        @Override
        public Render<? super EntityParatiku> createRenderFor(RenderManager manager) {
            return new RenderParatiku(manager, new ModelParatiku(), 0);
        }
    }
}