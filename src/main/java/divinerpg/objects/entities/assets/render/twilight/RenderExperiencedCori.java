package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.twilight.ModelExperiencedCori;
import divinerpg.objects.entities.entity.twilight.cories.EntityExperiencedCori;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderExperiencedCori extends RenderLiving<EntityExperiencedCori> {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/experienced_cori.png");

    public RenderExperiencedCori(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelExperiencedCori(), 0);
    }

    @Override
    protected void preRenderCallback(EntityExperiencedCori entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GL11.glScaled(5, 5, 5);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityExperiencedCori entity) {
        return texture;
    }

}