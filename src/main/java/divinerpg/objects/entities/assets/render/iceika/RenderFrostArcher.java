package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.iceika.EntityFrostArcher;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderFrostArcher extends RenderLiving<EntityFrostArcher> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/frost_archer.png");

    public RenderFrostArcher(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBiped(), 1F);
        addLayer(new MainHandLayer(this));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFrostArcher entity) {
        return texture;
    }

    private class MainHandLayer implements LayerRenderer<EntityFrostArcher> {
        protected final RenderFrostArcher renderFrostArcher;

        public MainHandLayer(RenderFrostArcher renderFrostArcherIn) {
            this.renderFrostArcher = renderFrostArcherIn;
        }

        @Override
        public void doRenderLayer(EntityFrostArcher entity, float limbSwing, float limbSwingAmount, float partialTicks,
                                  float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            ((ModelBiped) this.renderFrostArcher.getMainModel()).bipedRightArm.postRender(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            GlStateManager.translate(0.05f, 0, -0.05);
            GlStateManager.rotate(90, 0, 1, 0);
            GlStateManager.rotate(45, 0, 0, -1);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().getItemRenderer().renderItem(entity, new ItemStack(WeaponRegistry.icicleBow),
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