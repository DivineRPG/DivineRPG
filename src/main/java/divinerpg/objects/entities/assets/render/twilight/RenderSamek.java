package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.twilight.EntitySamek;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSamek extends RenderLiving<EntitySamek> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/samek.png");

    public RenderSamek(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSamek(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySamek entity) {
        return texture;
    }
}