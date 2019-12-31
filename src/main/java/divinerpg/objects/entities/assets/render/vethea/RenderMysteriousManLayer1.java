package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelMysteriousMan;
import divinerpg.objects.entities.entity.vethea.EntityMysteriousManLayer1;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMysteriousManLayer1 extends RenderLiving<EntityMysteriousManLayer1> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mysterious_man_layer_1.png");
    private final ModelMysteriousMan modelEntity;

    public RenderMysteriousManLayer1(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMysteriousMan(), 1F);
        modelEntity = (ModelMysteriousMan) super.mainModel;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMysteriousManLayer1 entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMysteriousManLayer1> {

        @Override
        public Render<? super EntityMysteriousManLayer1> createRenderFor(RenderManager manager) {
            return new RenderMysteriousManLayer1(manager, new ModelMysteriousMan(), 1F);
        }
    }

}