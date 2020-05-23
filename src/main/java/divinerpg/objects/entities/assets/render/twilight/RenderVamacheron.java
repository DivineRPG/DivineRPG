package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelVamacheron;
import divinerpg.objects.entities.entity.twilight.EntityVamacheron;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderVamacheron extends RenderLiving<EntityVamacheron> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/vamecheron.png");

    public RenderVamacheron(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelVamacheron(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityVamacheron entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityVamacheron entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}