package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.entity.arcana.Dramix;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDramix extends RenderLiving<Dramix> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dramix.png");

    public RenderDramix(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramix(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Dramix entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Dramix> {
        @Override
        public Render<? super Dramix> createRenderFor(RenderManager manager) {
            return new RenderDramix(manager, new ModelDramix(), 0.84F);
        }
    }

    @Override
    public void preRenderCallback(Dramix entity, float f) {
        GL11.glScalef(1.2f, 1.2f, 1.2f);
    }
}