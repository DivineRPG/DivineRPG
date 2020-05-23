package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelGlacide;
import divinerpg.objects.entities.entity.iceika.EntityGlacide;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGlacide extends RenderLiving<EntityGlacide> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/glacon.png");

    public RenderGlacide(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGlacide(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGlacide entity) {
        return texture;
    }
}