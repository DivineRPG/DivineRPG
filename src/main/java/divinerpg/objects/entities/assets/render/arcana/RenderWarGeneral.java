package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.arcana.EntityWarGeneral;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWarGeneral extends RenderLiving<EntityWarGeneral> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/war_general.png");

    public RenderWarGeneral(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWarGeneral entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWarGeneral> {
        @Override
        public Render<? super EntityWarGeneral> createRenderFor(RenderManager manager) {
            return new RenderWarGeneral(manager, new ModelSamek(), 0F);
        }
    }
}