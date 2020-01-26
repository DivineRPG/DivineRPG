package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelWraith;
import divinerpg.objects.entities.entity.arcana.EntityWraith;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWraith extends RenderLiving<EntityWraith> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wraith.png");

    public RenderWraith(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWraith(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWraith entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWraith> {
        @Override
        public Render<? super EntityWraith> createRenderFor(RenderManager manager) {
            return new RenderWraith(manager, new ModelWraith(), 0);
        }
    }
}