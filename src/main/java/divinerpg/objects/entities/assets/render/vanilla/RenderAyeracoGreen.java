package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.objects.entities.assets.model.vanilla.ModelAyeraco;
import divinerpg.objects.entities.entity.vanilla.ayeraco.EntityAyeracoGreen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderAyeracoGreen extends RenderLiving<EntityAyeracoGreen> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ayeraco_green.png");

    public RenderAyeracoGreen(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAyeraco(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAyeracoGreen entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityAyeracoGreen> {
        @Override
        public Render<? super EntityAyeracoGreen> createRenderFor(RenderManager manager) {
            return new RenderAyeracoGreen(manager, new ModelAyeraco(), 0F);
        }
    }
}