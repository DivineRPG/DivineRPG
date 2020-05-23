package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelRollum;
import divinerpg.objects.entities.entity.iceika.EntityRollum;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRollum extends RenderLiving<EntityRollum> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/rollum.png");

    public RenderRollum(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRollum(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRollum entity) {
        return texture;
    }
}