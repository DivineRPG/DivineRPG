package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelMandragora;
import divinerpg.objects.entities.entity.vethea.EntityMandragora;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMandragora extends RenderLiving<EntityMandragora> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/mandragora.png");

    public RenderMandragora(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMandragora(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMandragora entity) {
        return texture;
    }


}