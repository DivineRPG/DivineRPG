package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelMysteriousMan;
import divinerpg.objects.entities.entity.vethea.EntityMysteriousManLayer2;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMysteriousManLayer2 extends RenderLiving<EntityMysteriousManLayer2> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mysterious_man_layer_2.png");
    private final ModelMysteriousMan modelEntity;

    public RenderMysteriousManLayer2(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMysteriousMan(), 1F);
        modelEntity = (ModelMysteriousMan) super.mainModel;
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMysteriousManLayer2 entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityMysteriousManLayer2> {

        @Override
        public Render<? super EntityMysteriousManLayer2> createRenderFor(RenderManager manager) {
            return new RenderMysteriousManLayer2(manager, new ModelMysteriousMan(), 1F);
        }
    }

}