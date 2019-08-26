package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.assets.model.arcana.ModelParasecta;
import divinerpg.objects.entities.entity.arcana.Parasecta;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderParasecta extends RenderLiving<Parasecta> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/parasecta.png");

    public RenderParasecta(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelParasecta(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Parasecta entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Parasecta> {

        @Override
        public Render<? super Parasecta> createRenderFor(RenderManager manager) {
            return new RenderParasecta(manager, new ModelDramix(), 1.05F);
        }
    }

    @Override
    public void preRenderCallback(Parasecta entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}