package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelRotatick;
import divinerpg.objects.entities.entity.vanilla.EntityRotatick;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRotatick extends RenderLiving<EntityRotatick> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/rotatick.png");

    public RenderRotatick(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRotatick(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRotatick entity) {
        return texture;
    }

}