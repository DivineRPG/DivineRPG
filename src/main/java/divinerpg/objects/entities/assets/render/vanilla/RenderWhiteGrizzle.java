package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelGrizzle;
import divinerpg.objects.entities.entity.vanilla.EntityWhiteGrizzle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWhiteGrizzle extends RenderLiving<EntityWhiteGrizzle> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/white_grizzle.png");

    public RenderWhiteGrizzle(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGrizzle(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWhiteGrizzle entity) {
        return texture;
    }

}