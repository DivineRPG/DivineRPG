package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelGreenfeet;
import divinerpg.objects.entities.entity.twilight.EntityGreenfeet;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGreenfeet extends RenderLiving<EntityGreenfeet> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/greenfeet.png");

    public RenderGreenfeet(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGreenfeet(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGreenfeet entity) {
        return texture;
    }
}