package naturix.divinerpg.entities.assets.render.vanilla;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelSaguaroWorm;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSaguaroWorm extends RenderLiving<naturix.divinerpg.entities.entity.vanilla.saguaroworm.SaguaroWorm> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/saguaro_worm.png");

    public RenderSaguaroWorm(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSaguaroWorm(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(
            naturix.divinerpg.entities.entity.vanilla.saguaroworm.SaguaroWorm entity) {
        return texture;
    }

    public static class Factory
            implements IRenderFactory<naturix.divinerpg.entities.entity.vanilla.saguaroworm.SaguaroWorm> {
        @Override
        public Render<? super naturix.divinerpg.entities.entity.vanilla.saguaroworm.SaguaroWorm> createRenderFor(
                RenderManager manager) {
            return new RenderSaguaroWorm(manager, new ModelSaguaroWorm(), 0F);
        }
    }
}