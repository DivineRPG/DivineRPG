package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelAyeraco;
import divinerpg.objects.entities.entity.boss.ayeraco.EntityAyeraco;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderAyeraco extends RenderLiving<EntityAyeraco> {
    private ResourceLocation texture;

    public RenderAyeraco(RenderManager rendermanagerIn, String color) {
        super(rendermanagerIn, new ModelAyeraco(), 1F);
        this.texture = new ResourceLocation(DivineRPG.MODID, String.format("textures/entity/ayeraco_%s.png", color));
    }

    @Override
    protected void preRenderCallback(EntityAyeraco entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);

        GL11.glScaled(2, 2, 2);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAyeraco entity) {
        return texture;
    }
}
