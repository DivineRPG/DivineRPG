package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTwilightGolem;
import divinerpg.objects.entities.entity.twilight.EntitySkythernGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSkythernGolem extends RenderLiving<EntitySkythernGolem> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_golem.png");

    public RenderSkythernGolem(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySkythernGolem entity) {
        return texture;
    }

}