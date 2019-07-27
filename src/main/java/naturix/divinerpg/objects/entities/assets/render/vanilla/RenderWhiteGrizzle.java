package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.ModelGrizzle;
import naturix.divinerpg.objects.entities.entity.vanilla.WhiteGrizzle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWhiteGrizzle extends RenderLiving<WhiteGrizzle> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/white_grizzle.png");

    public RenderWhiteGrizzle(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGrizzle(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(WhiteGrizzle entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<WhiteGrizzle> {
        @Override
        public Render<? super WhiteGrizzle> createRenderFor(RenderManager manager) {
            return new RenderWhiteGrizzle(manager, new ModelGrizzle(), 0F);
        }
    }
}