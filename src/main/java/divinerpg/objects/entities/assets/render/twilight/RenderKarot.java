package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelKarot;
import divinerpg.objects.entities.entity.twilight.EntityKarot;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderKarot extends RenderLiving<EntityKarot> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png");

    public RenderKarot(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelKarot(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKarot entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EntityKarot entity, float f) {
        GL11.glScalef(5, 5, 5);
    }
}