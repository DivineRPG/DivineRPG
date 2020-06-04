package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelBunny;
import divinerpg.objects.entities.entity.eden.EntityBunny;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderBunny extends RenderLiving<EntityBunny> {
    private static final ResourceLocation bunnyLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/bunny.png");
    private static final ResourceLocation tamedBunnyLoc = new ResourceLocation(
            "divinerpg:textures/entity/tamed_bunny.png");
    private static final ResourceLocation tamedAngryBunnyLoc = new ResourceLocation(
            "divinerpg:textures/entity/tamed_angry_bunny.png");

    private float scale = 1;

    public RenderBunny(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBunny(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBunny bunny) {
        ResourceLocation tex = bunnyLoc;
        scale = 1;
        if (bunny.isTamed()) {
            if (bunny.isTamedAndAngry()) {
                tex = tamedAngryBunnyLoc;
                scale = 1.2f;
            } else {
                tex = tamedBunnyLoc;
            }
        }
        return tex;
    }

    @Override
    protected void preRenderCallback(EntityBunny bunny, float partialTickTime) {
        super.preRenderCallback(bunny, partialTickTime);
        GL11.glScalef(scale, scale, scale);
    }
}