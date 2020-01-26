package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EntityWildwoodCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildwoodCadillion extends RenderLiving<EntityWildwoodCadillion> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildwood_cadillion.png");

    public RenderWildwoodCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWildwoodCadillion entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWildwoodCadillion> {
        @Override
        public Render<? super EntityWildwoodCadillion> createRenderFor(RenderManager manager) {
            return new RenderWildwoodCadillion(manager, new ModelCadillion(), 0);
        }
    }
}