package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.vethea.ModelSpinarusBody;
import divinerpg.objects.entities.entity.vethea.EntitySpinarus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSpinarus extends RenderLiving<EntitySpinarus> {


    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/spinarus.png");
//	private final ModelSpinarusHead modelEntity2;
//	private final ModelSpinarusTail modelEntity3;

    public RenderSpinarus(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSpinarusBody(), 1F);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpinarus entity) {
        return texture;
    }

}