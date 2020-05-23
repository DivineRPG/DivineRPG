package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelRoamer;
import divinerpg.objects.entities.entity.arcana.EntityRoamer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRoamer extends RenderLiving<EntityRoamer> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/roamer.png");

    public RenderRoamer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRoamer(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRoamer entity) {
        return texture;
    }
}