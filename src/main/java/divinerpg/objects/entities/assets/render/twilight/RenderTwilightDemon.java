package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelTwilightDemon;
import divinerpg.objects.entities.entity.twilight.EntityTwilightDemon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderTwilightDemon extends RenderLiving<EntityTwilightDemon> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png");

    public RenderTwilightDemon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTwilightDemon(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTwilightDemon entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityTwilightDemon entity, float f) {
        GL11.glScalef(2, 2, 2);
    }

}