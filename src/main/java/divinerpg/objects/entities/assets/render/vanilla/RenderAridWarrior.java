package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelAridWarrior;
import divinerpg.objects.entities.entity.vanilla.EntityAridWarrior;
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

public class RenderAridWarrior extends RenderLiving<EntityAridWarrior> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/arid_warrior.png");

    public RenderAridWarrior(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAridWarrior(), 0);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAridWarrior entity) {
        return texture;
    }

    private class MainHandLayer implements LayerRenderer<EntityAridWarrior> {
        protected final RenderAridWarrior renderAridWarrior;

        public MainHandLayer(RenderAridWarrior renderAridWarriorIn) {
            this.renderAridWarrior = renderAridWarriorIn;
        }

        @Override
        public void doRenderLayer(EntityAridWarrior entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelAridWarrior) this.renderAridWarrior.getMainModel()).rightarmBS2.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(-0.125F, -0.14f, -0.02);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(WeaponRegistry.shadowBow),
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