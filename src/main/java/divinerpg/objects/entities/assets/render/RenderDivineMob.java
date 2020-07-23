package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.entity.EntityDivineMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivineMob extends RenderLiving<EntityDivineMob> {

    private ResourceLocation texture;
    private float scaleFactor;

    public RenderDivineMob(RenderManager renderManager, ModelBase model, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
        this.scaleFactor = 1F;
    }

    public RenderDivineMob(RenderManager renderManager, ModelBase model, float scaleFactor, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
        this.scaleFactor = scaleFactor;
    }

    @Override
    protected void preRenderCallback(EntityDivineMob mob, float partialTickTime) {
        GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
    }

    protected ResourceLocation getEntityTexture(EntityDivineMob entity) {
        return texture;
    }

}
