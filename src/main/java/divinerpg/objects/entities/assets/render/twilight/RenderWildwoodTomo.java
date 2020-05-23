package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.EntityWildwoodTomo;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWildwoodTomo extends RenderLiving<EntityWildwoodTomo> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_tomo.png");

    public RenderWildwoodTomo(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTomo(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWildwoodTomo entity) {
        return texture;
    }

}