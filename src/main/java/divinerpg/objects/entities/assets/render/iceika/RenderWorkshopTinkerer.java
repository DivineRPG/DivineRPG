package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelWorkshop;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWorkshopTinkerer extends RenderLiving<EntityWorkshopTinkerer> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_tinkerer.png");

    public RenderWorkshopTinkerer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWorkshop(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWorkshopTinkerer entity) {
        return texture;
    }

}