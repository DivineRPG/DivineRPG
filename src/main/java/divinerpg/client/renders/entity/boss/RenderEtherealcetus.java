package divinerpg.client.renders.entity.boss;


import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelEtherealcetus;
import divinerpg.entities.boss.EntityEtherealcetus;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEtherealcetus extends MobRenderer<EntityEtherealcetus, ModelEtherealcetus> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/etherealcetus.png");
    public RenderEtherealcetus(Context context) {
        super(context, new ModelEtherealcetus(context), 0.8F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityEtherealcetus entity) {
        return TEXTURE;
    }

    @Override
    public void render(EntityEtherealcetus etherealcetus, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        matrixStack.translate(0.0, -1.75, 0.0);
        super.render(etherealcetus, entityYaw, partialTicks, matrixStack, buffer, packedLight);
        RenderSystem.disableBlend();
        matrixStack.popPose();
    }

}