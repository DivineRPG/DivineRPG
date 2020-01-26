package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelGrizzle;
import divinerpg.objects.entities.entity.vanilla.EntityWhiteGrizzle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWhiteGrizzle extends RenderLiving<EntityWhiteGrizzle> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/white_grizzle.png");

    public RenderWhiteGrizzle(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGrizzle(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWhiteGrizzle entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWhiteGrizzle> {
        @Override
        public Render<? super EntityWhiteGrizzle> createRenderFor(RenderManager manager) {
            return new RenderWhiteGrizzle(manager, new ModelGrizzle(), 0F);
        }
    }
}