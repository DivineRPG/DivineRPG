package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTermid;
import divinerpg.objects.entities.entity.twilight.EntityTermid;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTermid extends RenderLiving<EntityTermid> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/termid.png");

    public RenderTermid(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTermid(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTermid entity) {
        return texture;
    }

}