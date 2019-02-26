package naturix.divinerpg.objects.entities.assets.render;

import naturix.divinerpg.objects.entities.assets.render.vanilla.RenderWildFire;
import naturix.divinerpg.objects.entities.entity.vanilla.WildFire;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class MainHandLayerRender implements LayerRenderer<WildFire> {
    private final RenderWildFire RenderWildFire;

    public MainHandLayerRender(RenderWildFire RenderWildFireIn) {
        RenderWildFire = RenderWildFireIn;
    }

    @Override
    public void doRenderLayer(WildFire entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ItemStack stack = entitylivingbaseIn.getHeldItemMainhand();

        if(stack != null) {
            //if(stack.getItem() == ModItems.infernoBow)
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.48F, 0.45F, -0.05F);
            GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-45.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            //Minecraft.getMinecraft().getItemRenderer().renderItem(entitylivingbaseIn, new ItemStack(ModItems.infernoBow), ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}