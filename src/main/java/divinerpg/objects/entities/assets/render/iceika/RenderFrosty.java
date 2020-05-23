package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelFrosty;
import divinerpg.objects.entities.entity.iceika.EntityFrosty;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderFrosty extends RenderLiving<EntityFrosty> {
    ResourceLocation frostyLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/frosty.png");
    ResourceLocation angryFrostyLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_frosty.png");

    public RenderFrosty(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelFrosty(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFrosty frosty) {
        return frosty.isAngry() ? angryFrostyLoc : frostyLoc;
    }
}