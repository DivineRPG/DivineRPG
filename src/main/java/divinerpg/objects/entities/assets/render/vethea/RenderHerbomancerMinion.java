package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelHerbomancerMinion;
import divinerpg.objects.entities.entity.vethea.EntityHerbomancerMinion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHerbomancerMinion extends RenderLiving<EntityHerbomancerMinion> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/herbomancer.png");

    public RenderHerbomancerMinion(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHerbomancerMinion(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHerbomancerMinion entity) {
        return texture;
    }

	}