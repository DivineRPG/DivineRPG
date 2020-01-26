package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelMadivel;
import divinerpg.objects.entities.entity.twilight.EntityMadivel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMadivel extends RenderLiving<EntityMadivel> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/madivel.png");

    public RenderMadivel(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMadivel(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMadivel entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMadivel> {
        @Override
        public Render<? super EntityMadivel> createRenderFor(RenderManager manager) {
            return new RenderMadivel(manager, new ModelMadivel(), 0);
        }
    }
}