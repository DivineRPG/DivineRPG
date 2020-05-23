package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelSeimer;
import divinerpg.objects.entities.entity.arcana.EntitySeimer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSeimer extends RenderLiving<EntitySeimer> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/seimer.png");

    public RenderSeimer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSeimer(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySeimer entity) {
        return texture;
    }

}