package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelBunny;
import divinerpg.objects.entities.entity.twilight.Bunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBunny extends RenderLiving<Bunny> {
    private static final ResourceLocation bunnyLoc = new ResourceLocation("divinerpg:textures/entity/bunny.png");
    private static final ResourceLocation tamedBunnyLoc = new ResourceLocation(
            "divinerpg:textures/entity/tamed_bunny.png");
    private static final ResourceLocation tamedAngryBunnyLoc = new ResourceLocation(
            "divinerpg:textures/entity/tamed_angry_bunny.png");
    public static final IRenderFactory FACTORY = new Factory();
    private float scale = 1;

    public RenderBunny(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBunny(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Bunny bunny) {
        ResourceLocation tex = bunnyLoc;
        scale = 1;
        if (bunny.isTamed()) {
            if (bunny.isTamedAndAngry()) {
                tex = tamedAngryBunnyLoc;
                scale = 1.2f;
            } else {
                tex = tamedBunnyLoc;
            }
        }
        return tex;
    }

    public static class Factory implements IRenderFactory<Bunny> {
        @Override
        public Render<? super Bunny> createRenderFor(RenderManager manager) {
            return new RenderBunny(manager, new ModelBunny(), 0F);
        }
    }

    @Override
    protected void preRenderCallback(Bunny bunny, float partialTickTime) {
        super.preRenderCallback(bunny, partialTickTime);
        GL11.glScalef(scale, scale, scale);
    }
}