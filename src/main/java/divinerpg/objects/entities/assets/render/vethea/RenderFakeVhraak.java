package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelVhraak;
import divinerpg.objects.entities.entity.vethea.EntityFakeVhraak;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFakeVhraak extends RenderLiving<EntityFakeVhraak> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vhraak.png");
    private final ModelVhraak modelEntity;

    public RenderFakeVhraak(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVhraak(), 1F);
        modelEntity = (ModelVhraak) super.mainModel;

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFakeVhraak entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityFakeVhraak> {

        @Override
        public Render<? super EntityFakeVhraak> createRenderFor(RenderManager manager) {
            return new RenderFakeVhraak(manager, new ModelVhraak(), 1F);
        }
    }

}