package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.arcana.EntityZelus;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderZelus extends RenderLiving<EntityZelus> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/zelus.png");

    public RenderZelus(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBiped(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityZelus entity) {
        return texture;
    }

}