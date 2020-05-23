package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelDreamwrecker;
import divinerpg.objects.entities.entity.vethea.EntityDreamwrecker;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDreamwrecker extends RenderLiving<EntityDreamwrecker> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/dreamwrecker.png");

    public RenderDreamwrecker(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDreamwrecker(), 1F);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDreamwrecker entity) {
        return texture;
    }

}