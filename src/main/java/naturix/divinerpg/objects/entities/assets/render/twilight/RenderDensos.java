package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.ModelDensos;
import naturix.divinerpg.objects.entities.entity.twilight.Densos;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDensos extends RenderLiving<Densos> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/densos.png");

    public RenderDensos(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDensos(), shadowsizeIn);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Densos entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Densos> {
        @Override
        public Render<? super Densos> createRenderFor(RenderManager manager) {
            return new RenderDensos(manager, new ModelDensos(), 0.5F);
        }
    }

    private class MainHandLayer implements LayerRenderer<Densos> {
        protected final RenderDensos renderDensos;

        public MainHandLayer(RenderDensos renderDensosIn) {
            this.renderDensos = renderDensosIn;
        }

        @Override
        public void doRenderLayer(Densos entity, float limbSwing, float limbSwingAmount, float partialTicks,
                float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelDensos) this.renderDensos.getMainModel()).rightarm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(-0F, 0, -0.55f);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModItems.haliteBlade),
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