package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.EntityWildwoodTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildwoodTomo extends RenderLiving<EntityWildwoodTomo> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildwood_tomo.png");

    public RenderWildwoodTomo(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTomo(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWildwoodTomo entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWildwoodTomo> {
        @Override
        public Render<? super EntityWildwoodTomo> createRenderFor(RenderManager manager) {
            return new RenderWildwoodTomo(manager, new ModelTomo(), 0);
        }
    }
}