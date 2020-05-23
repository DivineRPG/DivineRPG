package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelEnt;
import divinerpg.objects.entities.entity.vethea.EntityEnt;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEnt extends RenderLiving<EntityEnt> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/ent.png");

    public RenderEnt(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnt(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnt entity) {
        return texture;
    }


}