package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelJungleBat;
import divinerpg.objects.entities.entity.vanilla.EntityJungleBat;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleBat extends RenderLiving<EntityJungleBat> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_bat.png");

    public RenderJungleBat(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJungleBat(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJungleBat entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityJungleBat> {
        @Override
        public Render<? super EntityJungleBat> createRenderFor(RenderManager manager) {
            return new RenderJungleBat(manager, new ModelJungleBat(), 0F);
        }
    }
}