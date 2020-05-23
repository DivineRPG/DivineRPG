package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelJungleBat;
import divinerpg.objects.entities.entity.vanilla.EntityJungleBat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderJungleBat extends RenderLiving<EntityJungleBat> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_bat.png");

    public RenderJungleBat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelJungleBat(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJungleBat entity) {
        return texture;
    }

}