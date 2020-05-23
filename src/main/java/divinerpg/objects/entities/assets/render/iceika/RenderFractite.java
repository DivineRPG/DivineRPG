package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelFractite;
import divinerpg.objects.entities.entity.iceika.EntityFractite;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderFractite extends RenderLiving<EntityFractite> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/fractite.png");

    public RenderFractite(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelFractite(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFractite entity) {
        return texture;
    }
}