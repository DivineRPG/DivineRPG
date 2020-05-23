package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelTwins;
import divinerpg.objects.entities.entity.vethea.EntityTwins;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTwins extends RenderLiving<EntityTwins> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/twins.png");

    public RenderTwins(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTwins(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTwins entity) {
        return texture;
    }


	}