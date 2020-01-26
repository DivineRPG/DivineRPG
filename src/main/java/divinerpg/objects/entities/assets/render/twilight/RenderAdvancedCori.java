package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelCori;
import divinerpg.objects.entities.entity.twilight.EntityAdvancedCori;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAdvancedCori extends RenderLiving<EntityAdvancedCori> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/advanced_cori.png");

    public RenderAdvancedCori(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCori(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAdvancedCori entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityAdvancedCori> {
        @Override
        public Render<? super EntityAdvancedCori> createRenderFor(RenderManager manager) {
            return new RenderAdvancedCori(manager, new ModelCori(), 0);
        }
    }
}