package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelMysteriousMan;
import divinerpg.objects.entities.entity.vethea.EntityMysteriousManLayer3;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMysteriousManLayer3 extends RenderLiving<EntityMysteriousManLayer3> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mysterious_man_layer_3.png");
    private final ModelMysteriousMan modelEntity;

    public RenderMysteriousManLayer3(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMysteriousMan(), 1F);
        modelEntity = (ModelMysteriousMan) super.mainModel;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMysteriousManLayer3 entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMysteriousManLayer3> {

        @Override
        public Render<? super EntityMysteriousManLayer3> createRenderFor(RenderManager manager) {
            return new RenderMysteriousManLayer3(manager, new ModelMysteriousMan(), 1F);
        }
    }

}