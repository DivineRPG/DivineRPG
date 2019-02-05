package naturix.divinerpg.entities.assets.render.vanilla;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelGlacon;
import naturix.divinerpg.entities.entity.vanilla.Glacon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderGlacon extends RenderLiving<Glacon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/glacon.png");

    public RenderGlacon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGlacon(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Glacon entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Glacon> {
        @Override
        public Render<? super Glacon> createRenderFor(RenderManager manager) {
            return new RenderGlacon(manager, new ModelGlacon(), 0F);
        }
    }
}