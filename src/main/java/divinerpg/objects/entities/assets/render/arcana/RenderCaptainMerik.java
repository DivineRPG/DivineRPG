package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.arcana.EntityCaptainMerik;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCaptainMerik extends RenderLiving<EntityCaptainMerik> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/captain_merik.png");

    public RenderCaptainMerik(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSamek(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaptainMerik entity) {
        return texture;
    }

}