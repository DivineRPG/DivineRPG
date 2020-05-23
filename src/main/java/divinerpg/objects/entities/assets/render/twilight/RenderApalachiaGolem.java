package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTwilightGolem;
import divinerpg.objects.entities.entity.twilight.EntityApalachiaGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderApalachiaGolem extends RenderLiving<EntityApalachiaGolem> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/apalachia_golem.png");

    public RenderApalachiaGolem(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityApalachiaGolem entity) {
        return texture;
    }
}