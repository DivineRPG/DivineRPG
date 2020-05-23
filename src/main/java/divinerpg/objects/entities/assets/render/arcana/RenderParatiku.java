package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelParatiku;
import divinerpg.objects.entities.entity.arcana.EntityParatiku;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderParatiku extends RenderLiving<EntityParatiku> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/paratiku.png");

    public RenderParatiku(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelParatiku(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityParatiku entity) {
        return texture;
    }
}