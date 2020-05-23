package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSunstorm;
import divinerpg.objects.entities.entity.twilight.EntitySunstorm;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSunstorm extends RenderLiving<EntitySunstorm> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png");

    public RenderSunstorm(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSunstorm(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySunstorm entity) {
        return texture;
    }

}