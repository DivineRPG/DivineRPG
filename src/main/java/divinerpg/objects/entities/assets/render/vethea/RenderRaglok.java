package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelRaglok;
import divinerpg.objects.entities.entity.vethea.EntityRaglok;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRaglok extends RenderLiving<EntityRaglok> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/raglok_gogdure.png");

    public RenderRaglok(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRaglok(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRaglok entity) {
        return texture;
    }


	}