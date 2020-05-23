package divinerpg.objects.entities.assets.render.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.arcana.ModelParasecta;
import divinerpg.objects.entities.entity.arcana.EntityParasecta;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderParasecta extends RenderLiving<EntityParasecta> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png");

    public RenderParasecta(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelParasecta(), 1.05F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityParasecta entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityParasecta entity, float f) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
    }
}