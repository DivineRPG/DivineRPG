package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelKarot;
import divinerpg.objects.entities.entity.twilight.EntityKarot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKarot extends RenderLiving<EntityKarot> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/karot.png");

    public RenderKarot(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKarot(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKarot entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityKarot entity, float f) {
        GL11.glScalef(5, 5, 5);
    }

    public static class Factory implements IRenderFactory<EntityKarot> {
        @Override
        public Render<? super EntityKarot> createRenderFor(RenderManager manager) {
            return new RenderKarot(manager, new ModelKarot(), 0);
        }
    }
}