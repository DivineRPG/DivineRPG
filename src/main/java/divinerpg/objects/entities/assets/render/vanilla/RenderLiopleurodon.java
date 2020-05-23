package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelLiopleurodon;
import divinerpg.objects.entities.entity.vanilla.EntityLiopleurodon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLiopleurodon extends RenderLiving<EntityLiopleurodon> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/liopleurodon.png");

    public RenderLiopleurodon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelLiopleurodon(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLiopleurodon entity) {
        return texture;
    }

}