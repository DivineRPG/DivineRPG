package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import divinerpg.objects.entities.assets.model.twilight.ModelEternalArcher;
import divinerpg.objects.entities.entity.twilight.EternalArcher;
import divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEternalArcher extends RenderLiving<EternalArcher> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eternal_archer.png");

    public RenderEternalArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEternalArcher(), shadowsizeIn);
        addLayer(new HandsLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EternalArcher entity) {
        return texture;
    }

    @Override
    public void preRenderCallback(EternalArcher entity, float f) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
    }

    public static class Factory implements IRenderFactory<EternalArcher> {
        @Override
        public Render<? super EternalArcher> createRenderFor(RenderManager manager) {
            return new RenderEternalArcher(manager, new ModelEternalArcher(), 0);
        }
    }

    private class HandsLayer implements LayerRenderer<EternalArcher> {
        protected final RenderEternalArcher renderEternalArcher;

        public HandsLayer(RenderEternalArcher renderEternalArcherIn) {
            this.renderEternalArcher = renderEternalArcherIn;
        }

        @Override
        public void doRenderLayer(EternalArcher entity, float limbSwing, float limbSwingAmount, float partialTicks,
                float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            for (ModelRenderer renderRight : ((ModelEternalArcher) this.renderEternalArcher.getMainModel()).armsRight) {
                GlStateManager.enableRescaleNormal();
                GlStateManager.pushMatrix();
                renderRight.postRender(0.0625F);
                GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
                GlStateManager.translate(0.03F, 0F, 0F);
                GlStateManager.rotate(90, 0, 1, 0);
                GlStateManager.rotate(45, 0, 0, -1);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModItems.haliteBow),
                        ItemCameraTransforms.TransformType.NONE);
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
            }
            for (ModelRenderer renderLeft : ((ModelEternalArcher) this.renderEternalArcher.getMainModel()).armsLeft) {
                GlStateManager.enableRescaleNormal();
                GlStateManager.pushMatrix();
                renderLeft.postRender(0.0625F);
                GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
                GlStateManager.translate(0.08F, 0F, 0F);
                GlStateManager.rotate(90, 0, 1, 0);
                GlStateManager.rotate(45, 0, 0, -1);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModItems.haliteBow),
                        ItemCameraTransforms.TransformType.NONE);
                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
            }
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
    }
}