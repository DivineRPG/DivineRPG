package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelHelio;
import divinerpg.objects.entities.entity.vethea.EntityHelio;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHelio extends RenderLiving<EntityHelio> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/helio.png");

    public RenderHelio(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHelio(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHelio entity) {
        return texture;
    }


}