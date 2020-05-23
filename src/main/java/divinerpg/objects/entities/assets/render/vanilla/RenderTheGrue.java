package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelTheGrue;
import divinerpg.objects.entities.entity.vanilla.EntityTheGrue;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTheGrue extends RenderLiving<EntityTheGrue> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/the_grue.png");

    public RenderTheGrue(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTheGrue(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTheGrue entity) {
        return texture;
    }
}