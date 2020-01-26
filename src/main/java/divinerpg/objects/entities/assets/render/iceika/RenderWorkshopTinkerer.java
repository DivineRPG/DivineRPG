package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelWorkshop;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWorkshopTinkerer extends RenderLiving<EntityWorkshopTinkerer> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/workshop_tinkerer.png");

    public RenderWorkshopTinkerer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWorkshop(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWorkshopTinkerer entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWorkshopTinkerer> {
        @Override
        public Render<? super EntityWorkshopTinkerer> createRenderFor(RenderManager manager) {
            return new RenderWorkshopTinkerer(manager, new ModelWorkshop(), 0F);
        }
    }
}