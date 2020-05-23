package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelBasilisk;
import divinerpg.objects.entities.entity.twilight.EntityBasilisk;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBasilisk extends RenderLiving<EntityBasilisk> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/basilisk.png");

    public RenderBasilisk(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBasilisk(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBasilisk entity) {
        return texture;
    }
}