package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.entity.arcana.EntityDramix;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDramix extends RenderLiving<EntityDramix> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dramix.png");

    public RenderDramix(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramix(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDramix entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityDramix> {
        @Override
        public Render<? super EntityDramix> createRenderFor(RenderManager manager) {
            return new RenderDramix(manager, new ModelDramix(), 0.84F);
        }
    }

    @Override
    public void preRenderCallback(EntityDramix entity, float f) {
        GL11.glScalef(1.2f, 1.2f, 1.2f);
    }
}