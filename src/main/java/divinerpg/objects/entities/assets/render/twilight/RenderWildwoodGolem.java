package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTwilightGolem;
import divinerpg.objects.entities.entity.twilight.EntityWildwoodGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWildwoodGolem extends RenderLiving<EntityWildwoodGolem> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/wildwood_golem.png");

    public RenderWildwoodGolem(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWildwoodGolem entity) {
        return texture;
    }
}