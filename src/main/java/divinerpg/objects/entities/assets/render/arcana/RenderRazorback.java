package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelRazorback;
import divinerpg.objects.entities.entity.arcana.EntityRazorback;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRazorback extends RenderLiving<EntityRazorback> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/razorback.png");

    public RenderRazorback(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRazorback(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRazorback entity) {
        return texture;
    }

}