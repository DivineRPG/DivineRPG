package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelTheWatcher;
import divinerpg.objects.entities.entity.vanilla.EntityTheWatcher;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderTheWatcher extends RenderLiving<EntityTheWatcher> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png");

    public RenderTheWatcher(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTheWatcher(), 0);
    }

    @Override
    protected void preRenderCallback(EntityTheWatcher entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);

        GL11.glScaled(3, 3, 3);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTheWatcher entity) {
        return texture;
    }
}