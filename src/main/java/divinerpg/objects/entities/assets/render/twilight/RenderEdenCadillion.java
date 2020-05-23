package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelCadillion;
import divinerpg.objects.entities.entity.twilight.EntityEdenCadillion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEdenCadillion extends RenderLiving<EntityEdenCadillion> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/eden_cadillion.png");

    public RenderEdenCadillion(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCadillion(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEdenCadillion entity) {
        return texture;
    }
}