package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelEpiphite;
import divinerpg.objects.entities.entity.twilight.EntityEpiphite;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderEpiphite extends RenderLiving<EntityEpiphite> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/epiphite.png");

    public RenderEpiphite(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEpiphite(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEpiphite entity) {
        return texture;
    }


    @Override
    public void preRenderCallback(EntityEpiphite entity, float f) {
        GL11.glScalef(1.25f, 1.25f, 1.25f);
    }
}