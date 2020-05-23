package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelVermenous;
import divinerpg.objects.entities.entity.vethea.EntityVermenous;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderVermenous extends RenderLiving<EntityVermenous> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/vermenous.png");

    public RenderVermenous(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelVermenous(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityVermenous entity) {
        return texture;
    }

}