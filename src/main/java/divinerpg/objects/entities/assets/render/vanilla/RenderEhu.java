package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelEhu;
import divinerpg.objects.entities.entity.vanilla.EntityEhu;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEhu extends RenderLiving<EntityEhu> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/ehu.png");

    public RenderEhu(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEhu(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEhu entity) {
        return texture;
    }
}