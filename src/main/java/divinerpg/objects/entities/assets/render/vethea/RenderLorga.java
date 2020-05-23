package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelLorga;
import divinerpg.objects.entities.entity.vethea.EntityLorga;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLorga extends RenderLiving<EntityLorga> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/lorga.png");

    public RenderLorga(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelLorga(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLorga entity) {
        return texture;
    }

}