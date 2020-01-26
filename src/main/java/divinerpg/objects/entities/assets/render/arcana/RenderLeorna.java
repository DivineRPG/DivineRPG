package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelLeorna;
import divinerpg.objects.entities.entity.arcana.EntityLeorna;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLeorna extends RenderLiving<EntityLeorna> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/leorna.png");

    public RenderLeorna(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLeorna(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLeorna entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityLeorna> {
        @Override
        public Render<? super EntityLeorna> createRenderFor(RenderManager manager) {
            return new RenderLeorna(manager, new ModelLeorna(), 0F);
        }
    }
}