package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.objects.entities.assets.model.vanilla.ModelAyeraco;
import divinerpg.objects.entities.entity.vanilla.ayeraco.EntityAyeracoBlue;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderAyeracoBlue extends RenderLiving<EntityAyeracoBlue> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ayeraco_blue.png");

    public RenderAyeracoBlue(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAyeraco(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAyeracoBlue entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityAyeracoBlue> {
        @Override
        public Render<? super EntityAyeracoBlue> createRenderFor(RenderManager manager) {
            return new RenderAyeracoBlue(manager, new ModelAyeraco(), 0F);
        }
    }
}