package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelGrizzle;
import divinerpg.objects.entities.entity.vanilla.BrownGrizzle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBrownGrizzle extends RenderLiving<BrownGrizzle> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/brown_grizzle.png");

    public RenderBrownGrizzle(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGrizzle(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(BrownGrizzle entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<BrownGrizzle> {
        @Override
        public Render<? super BrownGrizzle> createRenderFor(RenderManager manager) {
            return new RenderBrownGrizzle(manager, new ModelGrizzle(), 0F);
        }
    }
}