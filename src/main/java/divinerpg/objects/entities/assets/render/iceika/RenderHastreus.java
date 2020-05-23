package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelHastreus;
import divinerpg.objects.entities.entity.iceika.EntityHastreus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHastreus extends RenderLiving<EntityHastreus> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/hastreus.png");

    public RenderHastreus(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHastreus(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHastreus entity) {
        return texture;
    }
}