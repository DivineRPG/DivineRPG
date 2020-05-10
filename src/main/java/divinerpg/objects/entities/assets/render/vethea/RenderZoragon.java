package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.vethea.ModelZoragon;
import divinerpg.objects.entities.entity.vethea.EntityZoragon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderZoragon extends RenderLiving<EntityZoragon> {


    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/zoragon.png");

    public RenderZoragon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelZoragon(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZoragon entity) {
        return texture;
    }

}