package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.vanilla.BlockAyeracoBeam;
import divinerpg.tiles.bosses.TileEntityAyeracoBeam;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.*;

import java.lang.Math;

public class RenderAyeracoBeam implements BlockEntityRenderer<TileEntityAyeracoBeam> {
	public static final ResourceLocation
		blue_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_blue.png"),
		green_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_green.png"),
		pink_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_pink.png"),
		purple_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_purple.png"),
		red_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_red.png"),
		yellow_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_yellow.png"),
		white_beam = new ResourceLocation(DivineRPG.MODID + ":textures/block/beam_white.png");
    public RenderAyeracoBeam(BlockEntityRendererProvider.Context context) {
    }

    public void render(TileEntityAyeracoBeam te, float p_225616_2_, PoseStack p_225616_3_, MultiBufferSource p_225616_4_, int p_225616_5_, int p_225616_6_) {
    renderBeaconBeam(p_225616_3_, p_225616_4_, p_225616_2_, te.getLevel().getHeight(), p_225616_5_, p_225616_6_, te);
    }

    private static void renderBeaconBeam(PoseStack p_228841_0_, MultiBufferSource p_228841_1_, float p_228841_2_, long p_228841_3_, int p_228841_5_, int p_228841_6_, TileEntityAyeracoBeam te) {
    	renderBeaconBeam(p_228841_0_, p_228841_1_, switch(((BlockAyeracoBeam) te.getBlockState().getBlock()).getColor()) {
    	case BLUE -> blue_beam;
		case GREEN -> green_beam;
		case PINK -> pink_beam;
		case PURPLE -> purple_beam;
		case RED -> red_beam;
		case YELLOW -> yellow_beam;
		case WHITE -> white_beam;
        }, p_228841_2_, 1.0F, p_228841_3_, p_228841_5_, p_228841_6_, 0.2F, 0.25F);
    }

    public static void renderBeaconBeam(PoseStack p_228842_0_, MultiBufferSource p_228842_1_, ResourceLocation p_228842_2_, float p_228842_3_, float p_228842_4_, long p_228842_5_, int p_228842_7_, int p_228842_8_, float p_228842_10_, float p_228842_11_) {
        int i = p_228842_7_ + p_228842_8_;
        p_228842_0_.pushPose();
        p_228842_0_.translate(0.5D, 0.0D, 0.5D);
        float f = (float)Math.floorMod(p_228842_5_, 40L) + p_228842_3_;
        float f1 = p_228842_8_ < 0 ? f : -f;
        float f2 = Mth.frac(f1 * 0.2F - (float)Mth.floor(f1 * 0.1F));
        float f3 = 1.0F;
        float f4 = 1.0F;
        float f5 = 1.0F;
        p_228842_0_.pushPose();
        p_228842_0_.mulPose(Axis.YP.rotationDegrees(f * 2.25F - 45.0F));
        float f6 = 0.0F;
        float f8 = 0.0F;
        float f9 = -p_228842_10_;
        float f12 = -p_228842_10_;
        float f15 = -1.0F + f2;
        float f16 = (float)p_228842_8_ * p_228842_4_ * (0.5F / p_228842_10_) + f15;
        renderPart(p_228842_0_, p_228842_1_.getBuffer(RenderType.beaconBeam(p_228842_2_, false)), f3, f4, f5, 1.0F, p_228842_7_, i, 0.0F, p_228842_10_, p_228842_10_, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        p_228842_0_.popPose();
        f6 = -p_228842_11_;
        float f7 = -p_228842_11_;
        f8 = -p_228842_11_;
        f9 = -p_228842_11_;
        f15 = -1.0F + f2;
        f16 = (float)p_228842_8_ * p_228842_4_ + f15;
        renderPart(p_228842_0_, p_228842_1_.getBuffer(RenderType.beaconBeam(p_228842_2_, true)), f3, f4, f5, 0.125F, p_228842_7_, i, f6, f7, p_228842_11_, f8, f9, p_228842_11_, p_228842_11_, p_228842_11_, 0.0F, 1.0F, f16, f15);
        p_228842_0_.popPose();
    }

    private static void renderPart(PoseStack p_228840_0_, VertexConsumer p_228840_1_, float p_228840_2_, float p_228840_3_, float p_228840_4_, float p_228840_5_, int p_228840_6_, int p_228840_7_, float p_228840_8_, float p_228840_9_, float p_228840_10_, float p_228840_11_, float p_228840_12_, float p_228840_13_, float p_228840_14_, float p_228840_15_, float p_228840_16_, float p_228840_17_, float p_228840_18_, float p_228840_19_) {
        PoseStack.Pose matrixstack$entry = p_228840_0_.last();
        Matrix4f matrix4f = matrixstack$entry.pose();
        Matrix3f matrix3f = matrixstack$entry.normal();
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_8_, p_228840_9_, p_228840_10_, p_228840_11_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_14_, p_228840_15_, p_228840_12_, p_228840_13_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_10_, p_228840_11_, p_228840_14_, p_228840_15_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
        renderQuad(matrix4f, matrix3f, p_228840_1_, p_228840_2_, p_228840_3_, p_228840_4_, p_228840_5_, p_228840_6_, p_228840_7_, p_228840_12_, p_228840_13_, p_228840_8_, p_228840_9_, p_228840_16_, p_228840_17_, p_228840_18_, p_228840_19_);
    }

    private static void renderQuad(Matrix4f p_228839_0_, Matrix3f p_228839_1_, VertexConsumer p_228839_2_, float p_228839_3_, float p_228839_4_, float p_228839_5_, float p_228839_6_, int p_228839_7_, int p_228839_8_, float p_228839_9_, float p_228839_10_, float p_228839_11_, float p_228839_12_, float p_228839_13_, float p_228839_14_, float p_228839_15_, float p_228839_16_) {
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_8_, p_228839_9_, p_228839_10_, p_228839_14_, p_228839_15_);
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_7_, p_228839_9_, p_228839_10_, p_228839_14_, p_228839_16_);
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_7_, p_228839_11_, p_228839_12_, p_228839_13_, p_228839_16_);
        addVertex(p_228839_0_, p_228839_1_, p_228839_2_, p_228839_3_, p_228839_4_, p_228839_5_, p_228839_6_, p_228839_8_, p_228839_11_, p_228839_12_, p_228839_13_, p_228839_15_);
    }

    private static void addVertex(Matrix4f p_228838_0_, Matrix3f p_228838_1_, VertexConsumer p_228838_2_, float p_228838_3_, float p_228838_4_, float p_228838_5_, float p_228838_6_, int p_228838_7_, float p_228838_8_, float p_228838_9_, float p_228838_10_, float p_228838_11_) {
        p_228838_2_.vertex(p_228838_0_, p_228838_8_, (float)p_228838_7_, p_228838_9_).color(p_228838_3_, p_228838_4_, p_228838_5_, p_228838_6_).uv(p_228838_10_, p_228838_11_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(p_228838_1_, 0.0F, 1.0F, 0.0F).endVertex();
    }

    public boolean shouldRenderOffScreen(TileEntityAyeracoBeam p_188185_1_) {
        return true;
    }
}
