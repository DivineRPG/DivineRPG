package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelLeorna;
import divinerpg.objects.entities.entity.arcana.EntityLeorna;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLeorna extends RenderLiving<EntityLeorna> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/leorna.png");

    public RenderLeorna(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelLeorna(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLeorna entity) {
        return texture;
    }
}