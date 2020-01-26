package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelGlacon;
import divinerpg.objects.entities.entity.vanilla.EntityGlacon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGlacon extends RenderLiving<EntityGlacon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/glacon.png");

    public RenderGlacon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGlacon(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGlacon entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityGlacon> {
        @Override
        public Render<? super EntityGlacon> createRenderFor(RenderManager manager) {
            return new RenderGlacon(manager, new ModelGlacon(), 0F);
        }
    }
}