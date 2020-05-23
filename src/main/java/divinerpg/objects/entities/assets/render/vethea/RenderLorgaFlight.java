package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelLorgaflight;
import divinerpg.objects.entities.entity.vethea.EntityLorgaflight;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLorgaFlight extends RenderLiving<EntityLorgaflight> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/lorga_flight.png");

    public RenderLorgaFlight(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelLorgaflight(), 1F);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLorgaflight entity) {
        return texture;
    }
}