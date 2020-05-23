package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelMadivel;
import divinerpg.objects.entities.entity.twilight.EntityMadivel;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMadivel extends RenderLiving<EntityMadivel> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/madivel.png");

    public RenderMadivel(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMadivel(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMadivel entity) {
        return texture;
    }

}