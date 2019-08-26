package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.arcana.ModelRejuvGolem;
import divinerpg.objects.entities.entity.arcana.GolemOfRejuvenation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGolemOfRejuvenation extends RenderLiving<GolemOfRejuvenation> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/golem_of_rejuvenation.png");

    public RenderGolemOfRejuvenation(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRejuvGolem(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GolemOfRejuvenation entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<GolemOfRejuvenation> {
        @Override
        public Render<? super GolemOfRejuvenation> createRenderFor(RenderManager manager) {
            return new RenderGolemOfRejuvenation(manager, new ModelRejuvGolem(), 0.5F);
        }
    }

    @Override
    public void preRenderCallback(GolemOfRejuvenation entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}