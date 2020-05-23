package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDeathcryx;
import divinerpg.objects.entities.entity.arcana.EntityFyracryx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderFyracryx extends RenderLiving<EntityFyracryx> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/fyracryx.png");

    public RenderFyracryx(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDeathcryx(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFyracryx entity) {
        return texture;
    }
}