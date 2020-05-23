package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelShark;
import divinerpg.objects.entities.entity.vanilla.EntityShark;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderShark extends RenderLiving<EntityShark> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/shark.png");

    public RenderShark(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelShark(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityShark entity) {
        return texture;
    }
}