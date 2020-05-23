package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelZone;
import divinerpg.objects.entities.entity.vethea.EntityZone;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderZone extends RenderLiving<EntityZone> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/zone.png");

    public RenderZone(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelZone(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZone entity) {
        return texture;
    }


}