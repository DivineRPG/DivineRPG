package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelMoonWolf;
import divinerpg.objects.entities.entity.twilight.EntityMoonWolf;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderMoonWolf extends RenderLiving<EntityMoonWolf> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/moon_wolf.png");

    public RenderMoonWolf(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelMoonWolf(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMoonWolf entity) {
        return texture;
    }

}