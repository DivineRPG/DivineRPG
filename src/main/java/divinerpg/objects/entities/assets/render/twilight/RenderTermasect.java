package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.twilight.ModelTermasect;
import divinerpg.objects.entities.entity.twilight.EntityTermasect;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTermasect extends RenderLiving<EntityTermasect> {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/termasect.png");

    public RenderTermasect(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTermasect(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTermasect entity) {
        return texture;
    }

}