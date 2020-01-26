package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelDensos;
import divinerpg.objects.entities.entity.twilight.EntityReyvor;
import divinerpg.registry.ModItems;
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

public class RenderReyvor extends RenderLiving<EntityReyvor> {
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/reyvor.png");
    public static final IRenderFactory FACTORY = new Factory();

    public RenderReyvor(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDensos(), shadowsizeIn);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityReyvor entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityReyvor> {
        @Override
        public Render<? super EntityReyvor> createRenderFor(RenderManager manager) {
            return new RenderReyvor(manager, new ModelDensos(), 0);
        }
    }

    private class MainHandLayer implements LayerRenderer<EntityReyvor> {
        protected final RenderReyvor renderReyvor;

        public MainHandLayer(RenderReyvor renderReyvorIn) {
            this.renderReyvor = renderReyvorIn;
        }

        @Override
        public void doRenderLayer(EntityReyvor entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelDensos) this.renderReyvor.getMainModel()).rightarm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0.05F, 0.4375F, 0F);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(ModItems.twilightBow),
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