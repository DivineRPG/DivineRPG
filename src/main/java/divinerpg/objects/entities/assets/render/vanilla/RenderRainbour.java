package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelRainbour;
import divinerpg.objects.entities.entity.vanilla.EntityRainbour;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderRainbour extends RenderLiving<EntityRainbour> {

    ResourceLocation rainbourLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/rainbour.png");
    ResourceLocation angryRainbourLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_rainbour.png");

    public RenderRainbour(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRainbour(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRainbour rainbour) {
        return rainbour.isAngry() ? angryRainbourLoc : rainbourLoc;
    }
}