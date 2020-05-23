package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelMysteriousMan;
import divinerpg.objects.entities.entity.vethea.EntityMysteriousManLayer1;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMysteriousManLayer1 extends RenderLiving<EntityMysteriousManLayer1> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/mysterious_man_layer_1.png");

    public RenderMysteriousManLayer1(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMysteriousMan(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMysteriousManLayer1 entity) {
        return texture;
    }

}