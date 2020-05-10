package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.api.Reference;
import divinerpg.objects.entities.assets.model.vanilla.ModelWildfire;
import divinerpg.objects.entities.entity.vanilla.EntityWildfire;
import divinerpg.registry.ModWeapons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWildfire extends RenderLiving<EntityWildfire> {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/wildfire.png");

    public RenderWildfire(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWildfire(), 0);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWildfire entity) {
        return texture;
    }


    private class MainHandLayer implements LayerRenderer<EntityWildfire> {
        protected final RenderWildfire renderWildfire;

        public MainHandLayer(RenderWildfire renderWildfireIn) {
            this.renderWildfire = renderWildfireIn;
        }

        @Override
        public void doRenderLayer(EntityWildfire entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelWildfire) this.renderWildfire.getMainModel()).rightarm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0.05, -0.115f, -0.08);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModWeapons.infernoBow),
                    ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
    }
}
