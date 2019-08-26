package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelTwilightDemon;
import divinerpg.objects.entities.entity.twilight.TwilightDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTwilightDemon extends RenderLiving<TwilightDemon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/twilight_demon.png");

    public RenderTwilightDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightDemon(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(TwilightDemon entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(TwilightDemon entity, float f) {
        GL11.glScalef(2, 2, 2);
    }

    public static class Factory implements IRenderFactory<TwilightDemon> {
        @Override
        public Render<? super TwilightDemon> createRenderFor(RenderManager manager) {
            return new RenderTwilightDemon(manager, new ModelTwilightDemon(), 0);
        }
    }
}