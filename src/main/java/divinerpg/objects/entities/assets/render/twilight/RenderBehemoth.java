package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelBehemoth;
import divinerpg.objects.entities.entity.twilight.EntityBehemoth;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBehemoth extends RenderLiving<EntityBehemoth> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/behemoth.png");

    public RenderBehemoth(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBehemoth(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBehemoth entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityBehemoth> {
        @Override
        public Render<? super EntityBehemoth> createRenderFor(RenderManager manager) {
            return new RenderBehemoth(manager, new ModelBehemoth(), 0);
        }
    }
}