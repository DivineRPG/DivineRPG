package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.arcana.EntityDatticon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDatticon extends RenderLiving<EntityDatticon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/datticon.png");

    public RenderDatticon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDatticon entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityDatticon> {
        @Override
        public Render<? super EntityDatticon> createRenderFor(RenderManager manager) {
            return new RenderDatticon(manager, new ModelSamek(), 0F);
        }
    }
}