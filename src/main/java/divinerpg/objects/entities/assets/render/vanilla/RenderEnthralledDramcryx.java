package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelEnthralledDramcryx;
import divinerpg.objects.entities.entity.vanilla.EntityEnthralledDramcryx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEnthralledDramcryx extends RenderLiving<EntityEnthralledDramcryx> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/enthralled_dramcryx.png");

    public RenderEnthralledDramcryx(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnthralledDramcryx(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnthralledDramcryx entity) {
        return texture;
    }
}