package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelMysteriousMan;
import divinerpg.objects.entities.entity.vethea.EntityMysteriousManLayer3;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMysteriousManLayer3 extends RenderLiving<EntityMysteriousManLayer3> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_3.png");

    public RenderMysteriousManLayer3(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMysteriousMan(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMysteriousManLayer3 entity) {
        return texture;
    }

}