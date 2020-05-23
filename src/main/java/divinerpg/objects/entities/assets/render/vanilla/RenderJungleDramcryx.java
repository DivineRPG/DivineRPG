package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelDramcryx;
import divinerpg.objects.entities.entity.vanilla.EntityJungleDramcryx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderJungleDramcryx extends RenderLiving<EntityJungleDramcryx> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_dramcryx.png");

    public RenderJungleDramcryx(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDramcryx(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJungleDramcryx entity) {
        return texture;
    }
}