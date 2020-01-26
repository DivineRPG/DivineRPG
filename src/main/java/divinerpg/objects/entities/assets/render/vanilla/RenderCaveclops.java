package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelCyclops;
import divinerpg.objects.entities.entity.vanilla.EntityCaveclops;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCaveclops extends RenderLiving<EntityCaveclops> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/caveclops.png");

    public RenderCaveclops(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCyclops(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaveclops entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityCaveclops> {
        @Override
        public Render<? super EntityCaveclops> createRenderFor(RenderManager manager) {
            return new RenderCaveclops(manager, new ModelCyclops(), 0F);
        }
    }
}