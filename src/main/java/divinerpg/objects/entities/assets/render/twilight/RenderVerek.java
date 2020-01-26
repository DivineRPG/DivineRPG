package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.twilight.EntityVerek;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVerek extends RenderLiving<EntityVerek> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/verek.png");

    public RenderVerek(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityVerek entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityVerek> {
        @Override
        public Render<? super EntityVerek> createRenderFor(RenderManager manager) {
            return new RenderVerek(manager, new ModelSamek(), 0);
        }
    }
}