package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDeathcryx;
import divinerpg.objects.entities.entity.arcana.death.EntityDeathcryx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDeathcryx extends RenderLiving<EntityDeathcryx> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/deathcryx.png");

    public RenderDeathcryx(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDeathcryx(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDeathcryx entity) {
        return texture;
    }
}