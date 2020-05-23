package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import divinerpg.objects.entities.entity.arcana.EntityDramix;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderDramix extends RenderLiving<EntityDramix> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png");

    public RenderDramix(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDramix(), 0.84F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDramix entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityDramix entity, float f) {
        GL11.glScalef(1.2f, 1.2f, 1.2f);
    }
}