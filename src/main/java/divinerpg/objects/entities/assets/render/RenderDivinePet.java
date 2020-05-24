package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivinePet extends RenderLiving<EntityDivineRPGTameable> {

    private ResourceLocation texture;
    private float scaleFactor;

    public RenderDivinePet(RenderManager renderManager, ModelBase model, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
        this.scaleFactor = 1F;
    }

    public RenderDivinePet(RenderManager renderManager, ModelBase model, float scaleFactor, ResourceLocation texture) {
        super(renderManager, model, 1F);
        this.texture = texture;
        this.scaleFactor = scaleFactor;
    }

    @Override
    protected void preRenderCallback(EntityDivineRPGTameable mob, float partialTickTime) {
        GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
    }

    protected ResourceLocation getEntityTexture(EntityDivineRPGTameable entity) {
        return texture;
    }

}
