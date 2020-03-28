package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.twilight.ModelSorcerer;
import divinerpg.objects.entities.entity.twilight.EntitySorcerer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSorcerer extends RenderLiving<EntitySorcerer> {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/sorcerer.png");

    public RenderSorcerer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSorcerer(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySorcerer entity) {
        return texture;
    }
}