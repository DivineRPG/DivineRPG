package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelRejuvGolem;
import divinerpg.objects.entities.entity.arcana.EntityGolemOfRejuvenation;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderGolemOfRejuvenation extends RenderLiving<EntityGolemOfRejuvenation> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/golem_of_rejuvenation.png");

    public RenderGolemOfRejuvenation(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelRejuvGolem(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGolemOfRejuvenation entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityGolemOfRejuvenation entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}