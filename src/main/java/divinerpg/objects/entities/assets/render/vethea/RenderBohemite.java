package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelBohemite;
import divinerpg.objects.entities.entity.vethea.EntityBohemite;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBohemite extends RenderLiving<EntityBohemite> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/bohemite.png");

    public RenderBohemite(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBohemite(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBohemite entity) {
        return texture;
    }

}