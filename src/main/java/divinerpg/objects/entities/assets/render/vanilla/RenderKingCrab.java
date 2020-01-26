package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelKingCrab;
import divinerpg.objects.entities.entity.vanilla.EntityKingCrab;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKingCrab extends RenderLiving<EntityKingCrab> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/crab.png");

    public RenderKingCrab(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKingCrab(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKingCrab entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityKingCrab> {
        @Override
        public Render<? super EntityKingCrab> createRenderFor(RenderManager manager) {
            return new RenderKingCrab(manager, new ModelKingCrab(), 0F);
        }
    }
}