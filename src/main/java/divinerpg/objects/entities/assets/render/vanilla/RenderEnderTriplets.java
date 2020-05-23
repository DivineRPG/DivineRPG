package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelEnderTriplets;
import divinerpg.objects.entities.entity.vanilla.EntityEnderTriplets;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEnderTriplets extends RenderLiving<EntityEnderTriplets> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_triplets.png");

    public RenderEnderTriplets(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnderTriplets(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderTriplets entity) {
        return texture;
    }

}