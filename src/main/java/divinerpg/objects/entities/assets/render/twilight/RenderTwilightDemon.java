package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelTwilightDemon;
import divinerpg.objects.entities.entity.twilight.EntityTwilightDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTwilightDemon extends RenderLiving<EntityTwilightDemon> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/twilight_demon.png");

    public RenderTwilightDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightDemon(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTwilightDemon entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityTwilightDemon entity, float f) {
        GL11.glScalef(2, 2, 2);
    }

    public static class Factory implements IRenderFactory<EntityTwilightDemon> {
        @Override
        public Render<? super EntityTwilightDemon> createRenderFor(RenderManager manager) {
            return new RenderTwilightDemon(manager, new ModelTwilightDemon(), 0);
        }
    }
}