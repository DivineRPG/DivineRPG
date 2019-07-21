package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import naturix.divinerpg.objects.entities.entity.arcana.Datticon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDatticon extends RenderLiving<Datticon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/datticon.png");

    public RenderDatticon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Datticon entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Datticon> {
        @Override
        public Render<? super Datticon> createRenderFor(RenderManager manager) {
            return new RenderDatticon(manager, new ModelSamek(), 0F);
        }
    }
}