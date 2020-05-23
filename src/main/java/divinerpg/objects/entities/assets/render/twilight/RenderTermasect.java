package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTermasect;
import divinerpg.objects.entities.entity.twilight.EntityTermasect;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderTermasect extends RenderLiving<EntityTermasect> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png");

    public RenderTermasect(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTermasect(), 0);
    }

    @Override
    protected void preRenderCallback(EntityTermasect entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GL11.glScaled(5, 5, 5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTermasect entity) {
        return texture;
    }

}