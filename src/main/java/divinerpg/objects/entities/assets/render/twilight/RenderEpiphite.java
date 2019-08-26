package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelEpiphite;
import divinerpg.objects.entities.entity.twilight.Epiphite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEpiphite extends RenderLiving<Epiphite> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/epiphite.png");

    public RenderEpiphite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEpiphite(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Epiphite entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Epiphite> {
        @Override
        public Render<? super Epiphite> createRenderFor(RenderManager manager) {
            return new RenderEpiphite(manager, new ModelEpiphite(), 0);
        }
    }

    @Override
    public void preRenderCallback(Epiphite entity, float f) {
        GL11.glScalef(1.25f, 1.25f, 1.25f);
    }
}