package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelBasilisk;
import divinerpg.objects.entities.entity.twilight.EntityBasilisk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBasilisk extends RenderLiving<EntityBasilisk> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/basilisk.png");

    public RenderBasilisk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBasilisk(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBasilisk entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityBasilisk> {
        @Override
        public Render<? super EntityBasilisk> createRenderFor(RenderManager manager) {
            return new RenderBasilisk(manager, new ModelBasilisk(), 0);
        }
    }
}