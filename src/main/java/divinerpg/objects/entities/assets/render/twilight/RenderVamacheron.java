package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelVamacheron;
import divinerpg.objects.entities.entity.twilight.EntityVamacheron;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVamacheron extends RenderLiving<EntityVamacheron> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vamecheron.png");

    public RenderVamacheron(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVamacheron(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityVamacheron entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityVamacheron entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }

    public static class Factory implements IRenderFactory<EntityVamacheron> {
        @Override
        public Render<? super EntityVamacheron> createRenderFor(RenderManager manager) {
            return new RenderVamacheron(manager, new ModelVamacheron(), 0.5F);
        }
    }
}