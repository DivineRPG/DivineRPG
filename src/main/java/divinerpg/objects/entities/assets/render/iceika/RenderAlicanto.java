package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelAlicanto;
import divinerpg.objects.entities.entity.iceika.EntityAlicanto;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderAlicanto extends RenderLiving<EntityAlicanto> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/alicanto.png");

    public RenderAlicanto(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAlicanto(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAlicanto entity) {
        return texture;
    }
}