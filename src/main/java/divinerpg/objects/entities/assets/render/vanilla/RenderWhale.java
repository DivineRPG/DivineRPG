package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelWhale;
import divinerpg.objects.entities.entity.vanilla.EntityWhale;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWhale extends RenderLiving<EntityWhale> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/whale.png");

    public RenderWhale(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWhale(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWhale entity) {
        return texture;
    }

}