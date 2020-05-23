package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.arcana.EntityWarGeneral;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWarGeneral extends RenderLiving<EntityWarGeneral> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/war_general.png");

    public RenderWarGeneral(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSamek(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWarGeneral entity) {
        return texture;
    }
}