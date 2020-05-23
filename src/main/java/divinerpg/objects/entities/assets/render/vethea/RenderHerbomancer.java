package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelHerbomancer;
import divinerpg.objects.entities.entity.vethea.EntityHerbomancer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHerbomancer extends RenderLiving<EntityHerbomancer> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/herbomancer.png");

    public RenderHerbomancer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHerbomancer(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHerbomancer entity) {
        return texture;
    }


}