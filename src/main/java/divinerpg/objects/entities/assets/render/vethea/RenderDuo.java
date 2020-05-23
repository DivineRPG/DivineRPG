package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelDuo;
import divinerpg.objects.entities.entity.vethea.EntityDuo;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDuo extends RenderLiving<EntityDuo> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/duo.png");

    public RenderDuo(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDuo(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDuo entity) {
        return texture;
    }

}