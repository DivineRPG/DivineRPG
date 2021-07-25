package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;

public class RenderAyeracoBeam extends TileEntityRenderer<TileEntityAyeracoBeam> {

    public RenderAyeracoBeam(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    public void render(TileEntityAyeracoBeam te, float p_225616_2_, MatrixStack p_225616_3_, IRenderTypeBuffer p_225616_4_, int p_225616_5_, int p_225616_6_) {
    renderBeaconBeam(p_225616_3_, p_225616_4_, p_225616_2_, te.getLevel().getHeight(), p_225616_5_, p_225616_6_, te);
    }

    private static void renderBeaconBeam(MatrixStack p_228841_0_, IRenderTypeBuffer p_228841_1_, float p_228841_2_, long p_228841_3_, int p_228841_5_, int p_228841_6_, TileEntityAyeracoBeam te) {
        renderBeaconBeam(p_228841_0_, p_228841_1_, te.texture, p_228841_2_, 1.0F, p_228841_3_, p_228841_5_, p_228841_6_, 0.2F, 0.25F);
    }

    public static void renderBeaconBeam(MatrixStack p_228842_0_, IRenderTypeBuffer p_228842_1_, ResourceLocation p_228842_2_, float p_228842_3_, float p_228842_4_, long p_228842_5_, int p_228842_7_, int p_228842_8_, float p_228842_10_, float p_228842_11_) {
        int i = p_228842_7_ + p_228842_8_;
        p_228842_0_.pushPose();
        p_228842_0_.translate(0.5D, 0.0D, 0.5D);
        float f = (float)Math.floorMod(p_228842_5_, 40L) + p_228842_3_;
        float f1 = p_228842_8_ < 0 ? f : -f;
        float f2 = MathHelper.frac(f1 * 0.2F - (float)MathHelper.floor(f1 * 0.1F));
        float f3 = 1.0F;
        float f4 = 1.0F;
        float f5 = 1.0F;
        p_228842_0_.pushPose();
        p_228842_0_.mulPose(Vector3f.YP.rotationDegrees(f * 2.25F - 45.0F));
        float f6 = 0.0F;
        float f8 = 0.0F;
        float f9 = -p_228842_10_;
        float f10 = 0.0F;
        float f11 = 0.0F;
        float f12 = -p_228842_10_;
        float f13 = 0.0F;
        float f14 = 1.0F;
        float f15 = -1.0F + f2;
        float f16 = (float)p_228842_8_ * p_228842_4_ * (0.5F / p_228842_10_) + f15;
        renderPart(p_228842_0_, p_228842_1_.getBuffer(RenderType.beaconBeam(p_228842_2_, false)), f3, f4, f5, 1.0F, p_228842_7_, i, 0.0F, p_228842_10_, p_228842_10_, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        p_228842_0_.popPose();
        f6 = -p_228842_11_;
        float f7 = -p_228842_11_;
        f8 = -p_228842_11_;
        f9 = -p_228842_11_;
        f13 = 0.0F;
        f14 = 1.0F;
        f15 = -1.0F + f2;
        f16 = (float)p_228842_8_ * p_228842_4_ + f15;
        renderPart(p_228842_0_, p_228842_1_.getBuffer(RenderType.beaconBeam(p_228842_2_, true)), f3, f4, f5, 0.125F, p_228842_7_, i, f6, f7, p_228842_11_, f8, f9, p_228842_11_, p_228842_11_, p_228842_11_, 0.0F, 1.0F, f16, f15);
        p_228842_0_.popPose();
    }

    private static void renderPart(MatrixStack p_228840_0_, IVertexBuilder p_228840_1_, float p_228840_2_, float p_228840_3_, float p_228840_4_, float p_228840_5_, int p_228840_6_, int p_228840_7_, float p_228840_8_, float p_228840_9_, float p_228840_10_, float p_228840_11_, float p_228840_12_, float p_228840_13_, float p_228840_14_, float p_228840_15_, float p_228840_16_, float p_228840_17_, float p_228840_18_, float p_228840_19_) {
        MatrixStack.Entry matrixstack$entry = p_228840_0_.last();
        Matrix4f matrix4f = matrixstack$entry.pose();
        Matrix3f matrix3f = matrixstack$entry.normal();
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_8_, p_228840_9_, p_228840_10_, p_228840_11_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_14_, p_228840_15_, p_228840_12_, p_228840_13_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_10_, p_228840_11_, p_228840_14_, p_228840_15_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_12_, p_228840_13_, p_228840_8_, p_228840_9_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
    }

    private static void renderQuad(Matrix4f p_228839_0_, Matrix3f p_228839_1_, IVertexBuilder p_228839_2_, float p_228839_3_, float p_228839_4_, float p_228839_5_, float p_228839_6_, int p_228839_7_, int p_228839_8_, float p_228839_9_, float p_228839_10_, float p_228839_11_, float p_228839_12_, float p_228839_13_, float p_228839_14_, float p_228839_15_, float p_228839_16_) {
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_8_, p_228839_9_, p_228839_10_, p_228839_14_, p_228839_15_);
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_7_, p_228839_9_, p_228839_10_, p_228839_14_, p_228839_16_);
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_7_, p_228839_11_, p_228839_12_, p_228839_13_, p_228839_16_);
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_8_, p_228839_11_, p_228839_12_, p_228839_13_, p_228839_15_);
    }

    private static void addVertex(Matrix4f p_228838_0_, Matrix3f p_228838_1_, IVertexBuilder p_228838_2_, float p_228838_3_, float p_228838_4_, float p_228838_5_, float p_228838_6_, int p_228838_7_, float p_228838_8_, float p_228838_9_, float p_228838_10_, float p_228838_11_) {
        p_228838_2_.vertex(p_228838_0_, p_228838_8_, (float)p_228838_7_, p_228838_9_).color(p_228838_3_, p_228838_4_, p_228838_5_, p_228838_6_).uv(p_228838_10_, p_228838_11_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(p_228838_1_, 0.0F, 1.0F, 0.0F).endVertex();
    }

    public boolean shouldRenderOffScreen(TileEntityAyeracoBeam p_188185_1_) {
        return true;
    }
}
