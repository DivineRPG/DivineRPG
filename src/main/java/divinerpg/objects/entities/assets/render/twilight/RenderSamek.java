package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.twilight.EntitySamek;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSamek extends RenderLiving<EntitySamek> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/samek.png");

    public RenderSamek(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySamek entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntitySamek> {
        @Override
        public Render<? super EntitySamek> createRenderFor(RenderManager manager) {
            return new RenderSamek(manager, new ModelSamek(), 0);
        }
    }
}