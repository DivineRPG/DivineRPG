package naturix.divinerpg.entities.assets.render;

import naturix.divinerpg.entities.entity.WildFire;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;

public class MainHandLayerRender implements LayerRenderer<WildFire> {
    private final RenderWildFire RenderWildFire;

    public MainHandLayerRender(RenderWildFire RenderWildFireIn) {
        RenderWildFire = RenderWildFireIn;
    }

    @Override
    public void doRenderLayer(WildFire entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ItemStack stack = entitylivingbaseIn.getHeldItemMainhand();

        if(stack != null) {
            if(stack.getItem() == ModItems.infernoBow)
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.35F, 0.65F + -0.0F, -0.6F);
            GlStateManager.rotate(280.0F, 200.0F, 50.0F, 0.0F);
            //GlStateManager.rotate(-155.0F, 250.0F, 40.0F, -205.0F);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entitylivingbaseIn, new ItemStack(ModItems.infernoBow), ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}