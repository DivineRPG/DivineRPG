package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelAngryBunny;
import divinerpg.objects.entities.entity.twilight.EntityAngryBunny;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderAngryBunny extends RenderLiving<EntityAngryBunny> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_bunny.png");

    public RenderAngryBunny(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAngryBunny(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAngryBunny entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityAngryBunny entity, float f) {
        GL11.glScalef(2, 2, 2);
    }
}