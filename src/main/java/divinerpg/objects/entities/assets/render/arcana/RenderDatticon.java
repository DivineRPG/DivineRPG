package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSamek;
import divinerpg.objects.entities.entity.arcana.EntityDatticon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDatticon extends RenderLiving<EntityDatticon> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/datticon.png");

    public RenderDatticon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSamek(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDatticon entity) {
        return texture;
    }
}