package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.objects.entities.assets.model.arcana.ModelRejuvGolem;
import naturix.divinerpg.objects.entities.entity.arcana.GolemOfRejuvination;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGolemOfRejuvination extends RenderLiving<GolemOfRejuvination> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/golem_of_rejuvination.png");

    public RenderGolemOfRejuvination(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRejuvGolem(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GolemOfRejuvination entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<GolemOfRejuvination> {
        @Override
        public Render<? super GolemOfRejuvination> createRenderFor(RenderManager manager) {
            return new RenderGolemOfRejuvination(manager, new ModelRejuvGolem(), 0.5F);
        }
    }

    @Override
    public void preRenderCallback(GolemOfRejuvination entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}