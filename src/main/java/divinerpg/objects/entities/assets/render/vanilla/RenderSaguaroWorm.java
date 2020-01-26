package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelSaguaroWorm;
import divinerpg.objects.entities.entity.vanilla.EntitySaguaroWorm;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSaguaroWorm extends RenderLiving<EntitySaguaroWorm> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/saguaro_worm.png");

    public RenderSaguaroWorm(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSaguaroWorm(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySaguaroWorm entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntitySaguaroWorm> {
        @Override
        public Render<? super EntitySaguaroWorm> createRenderFor(RenderManager manager) {
            return new RenderSaguaroWorm(manager, new ModelSaguaroWorm(), 0F);
        }
    }
}