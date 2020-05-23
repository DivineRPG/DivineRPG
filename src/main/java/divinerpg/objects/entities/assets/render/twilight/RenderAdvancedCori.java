package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelCori;
import divinerpg.objects.entities.entity.twilight.cories.EntityAdvancedCori;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderAdvancedCori extends RenderLiving<EntityAdvancedCori> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/advanced_cori.png");

    public RenderAdvancedCori(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCori(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAdvancedCori entity) {
        return texture;
    }

}