package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelCori;
import divinerpg.objects.entities.entity.twilight.cories.EntityWeakCori;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWeakCori extends RenderLiving<EntityWeakCori> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/weak_cori.png");

    public RenderWeakCori(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCori(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWeakCori entity) {
        return texture;
    }

}