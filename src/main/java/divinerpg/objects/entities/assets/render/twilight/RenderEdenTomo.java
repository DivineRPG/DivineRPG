package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.EntityEdenTomo;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEdenTomo extends RenderLiving<EntityEdenTomo> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_tomo.png");

    public RenderEdenTomo(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTomo(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEdenTomo entity) {
        return texture;
    }
}