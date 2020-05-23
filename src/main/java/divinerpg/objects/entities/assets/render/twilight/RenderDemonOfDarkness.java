package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelDemonOfDarkness;
import divinerpg.objects.entities.entity.twilight.EntityDemonOfDarkness;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDemonOfDarkness extends RenderLiving<EntityDemonOfDarkness> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/demon_of_darkness.png");

    public RenderDemonOfDarkness(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDemonOfDarkness(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDemonOfDarkness entity) {
        return texture;
    }
}