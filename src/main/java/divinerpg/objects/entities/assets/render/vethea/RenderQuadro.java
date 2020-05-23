package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelQuadro;
import divinerpg.objects.entities.entity.vethea.EntityQuadro;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderQuadro extends RenderLiving<EntityQuadro> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/quadro.png");

    public RenderQuadro(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelQuadro(), 1F);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityQuadro entity) {
        return texture;
    }

}