package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSkythernFiend;
import divinerpg.objects.entities.entity.twilight.EntitySkythernFiend;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSkythernFiend extends RenderLiving<EntitySkythernFiend> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/skythern_fiend.png");

    public RenderSkythernFiend(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSkythernFiend(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySkythernFiend entity) {
        return texture;
    }
}