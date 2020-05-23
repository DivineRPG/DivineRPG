package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelGlacon;
import divinerpg.objects.entities.entity.vanilla.EntityGlacon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGlacon extends RenderLiving<EntityGlacon> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png");

    public RenderGlacon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGlacon(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGlacon entity) {
        return texture;
    }
}