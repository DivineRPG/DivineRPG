package divinerpg.client.renders.entity.boss;


import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelKitra;
import divinerpg.entities.boss.EntityKitra;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKitra extends MobRenderer<EntityKitra, ModelKitra> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/kitra.png");
    public RenderKitra(Context context) {
        super(context, new ModelKitra(context), 1.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityKitra entity) {
        return TEXTURE;
    }

    @Override
    public void render(EntityKitra kitra, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        matrixStack.translate(0.0, -1.75, 0.0);
        super.render(kitra, entityYaw, partialTicks, matrixStack, buffer, packedLight);
        RenderSystem.disableBlend();
        matrixStack.popPose();
    }

}