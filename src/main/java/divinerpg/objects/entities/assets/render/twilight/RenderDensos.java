package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelDensos;
import divinerpg.objects.entities.entity.boss.EntityDensos;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDensos extends RenderLiving<EntityDensos> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png");

    public RenderDensos(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDensos(), 0.5F);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDensos entity) {
        return texture;
    }


    private class MainHandLayer implements LayerRenderer<EntityDensos> {
        protected final RenderDensos renderDensos;

        public MainHandLayer(RenderDensos renderDensosIn) {
            this.renderDensos = renderDensosIn;
        }

        @Override
        public void doRenderLayer(EntityDensos entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelDensos) this.renderDensos.getMainModel()).rightarm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(-0F, 0.2, -0.55f);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(WeaponRegistry.haliteBlade),
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