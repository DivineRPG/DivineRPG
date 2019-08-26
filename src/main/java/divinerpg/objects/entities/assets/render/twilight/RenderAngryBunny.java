package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelAngryBunny;
import divinerpg.objects.entities.entity.twilight.AngryBunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAngryBunny extends RenderLiving<AngryBunny> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/angry_bunny.png");

    public RenderAngryBunny(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAngryBunny(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AngryBunny entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<AngryBunny> {
        @Override
        public Render<? super AngryBunny> createRenderFor(RenderManager manager) {
            return new RenderAngryBunny(manager, new ModelAngryBunny(), 0F);
        }
    }

    @Override
    public void preRenderCallback(AngryBunny entity, float f) {
        GL11.glScalef(2, 2, 2);
    }
}