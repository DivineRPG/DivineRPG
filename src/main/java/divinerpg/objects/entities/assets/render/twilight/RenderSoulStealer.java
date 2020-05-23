package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSoulStealer;
import divinerpg.objects.entities.entity.twilight.EntitySoulStealer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSoulStealer extends RenderLiving<EntitySoulStealer> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_stealer.png");

    public RenderSoulStealer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSoulStealer(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySoulStealer entity) {
        return texture;
    }

}