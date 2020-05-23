package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelWraith;
import divinerpg.objects.entities.entity.arcana.EntityWraith;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWraith extends RenderLiving<EntityWraith> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/wraith.png");

    public RenderWraith(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWraith(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWraith entity) {
        return texture;
    }
}