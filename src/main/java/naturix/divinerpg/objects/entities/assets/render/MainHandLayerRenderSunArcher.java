package naturix.divinerpg.objects.entities.assets.render;

import naturix.divinerpg.objects.entities.assets.render.twilight.RenderSunArcher;
import naturix.divinerpg.objects.entities.entity.twilight.SunArcher;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;

public class MainHandLayerRenderSunArcher implements LayerRenderer<SunArcher> {

    public MainHandLayerRenderSunArcher(RenderSunArcher renderSunArcherIn) {
        
    }

    @Override
    public void doRenderLayer(SunArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.375f, -0.125f, -0.5f);
        GlStateManager.rotate(-90, 0, 1.75f, 0);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getItemRenderer().renderItem(entitylivingbaseIn, new ItemStack(ModItems.edenBow),
                ItemCameraTransforms.TransformType.NONE);
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}