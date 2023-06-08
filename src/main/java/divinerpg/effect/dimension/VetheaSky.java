package divinerpg.effect.dimension;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;
import org.joml.*;

import javax.annotation.Nullable;

public class VetheaSky extends DimensionSpecialEffects {
	public static final ResourceLocation EYE_LOCATION = new ResourceLocation(DivineRPG.MODID, "textures/particle/eye.png");
	@Nullable private VertexBuffer starBuffer;
	public VetheaSky() {
		super(Float.NaN, true, SkyType.NORMAL, false, false);
		
		//create sky
		Tesselator tesselator = Tesselator.getInstance();
		BufferBuilder bufferbuilder = tesselator.getBuilder();
		RenderSystem.setShader(GameRenderer::getPositionShader);
		if(starBuffer != null) starBuffer.close();
		starBuffer = new VertexBuffer(VertexBuffer.Usage.DYNAMIC);
		BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = TwilightSky.drawStars(bufferbuilder);
		starBuffer.bind();
		starBuffer.upload(bufferbuilder$renderedbuffer);
		VertexBuffer.unbind();
	}
	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 vec, float f) {
		return vec.scale(0.15);
	}
	@Override public boolean isFoggyAt(int i, int ii) {return false;}
	@Override
	public boolean renderSky(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
		setupFog.run();
		if(!isFoggy) {
			FogType fogtype = camera.getFluidInCamera();
			if(fogtype != FogType.POWDER_SNOW && fogtype != FogType.LAVA && !TwilightSky.doesMobEffectBlockSky(camera)) {
//				RenderSystem.disableBlend();
				Vec3 vec3 = level.getSkyColor(camera.getPosition(), partialTick);
				float f = (float)vec3.x, f1 = (float)vec3.y, f2 = (float)vec3.z;
				FogRenderer.levelFogColor();
				BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
				RenderSystem.depthMask(false);
				RenderSystem.setShaderColor(f, f1, f2, 1F);
//				ShaderInstance shaderinstance = RenderSystem.getShader();
				RenderSystem.enableBlend();
				RenderSystem.defaultBlendFunc();
//				RenderSystem.enableBlend();
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				poseStack.pushPose();
				float f11 = 1F - level.getRainLevel(partialTick);
				RenderSystem.setShaderColor(1F, 1F, 1F, f11);
				poseStack.mulPose(Axis.YP.rotationDegrees(-90F));
				poseStack.mulPose(Axis.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360F));
				Matrix4f matrix4f1 = poseStack.last().pose();
				float f12 = 20F;
				RenderSystem.setShader(GameRenderer::getPositionTexShader);
				RenderSystem.setShaderTexture(0, EYE_LOCATION);
				int k = level.getMoonPhase(), l = k % 4, i1 = k / 4 % 2;
				float f13 = (l + 0) / 4F, f14 = (i1 + 0) / 2F, f15 = (l + 1) / 4F, f16 = (i1 + 1) / 2F;
				bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
				bufferbuilder.vertex(matrix4f1, -f12, -100F, f12).uv(f15, f16).endVertex();
				bufferbuilder.vertex(matrix4f1, f12, -100F, f12).uv(f13, f16).endVertex();
				bufferbuilder.vertex(matrix4f1, f12, -100F, -f12).uv(f13, f14).endVertex();
				bufferbuilder.vertex(matrix4f1, -f12, -100F, -f12).uv(f15, f14).endVertex();
				BufferUploader.drawWithShader(bufferbuilder.end());
//				RenderSystem.disableBlend();
				float f10 = level.getStarBrightness(partialTick) * f11 * 1.01F;
				RenderSystem.setShaderColor(f10, f10, f10, f10);
                FogRenderer.setupNoFog();
                starBuffer.bind();
                starBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
                VertexBuffer.unbind();
                setupFog.run();
                RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
                RenderSystem.disableBlend();
				RenderSystem.defaultBlendFunc();
                poseStack.popPose();
//                RenderSystem.disableBlend();
//                RenderSystem.setShaderColor(0F, 0F, 0F, 1F);
//                if(level.effects().hasGround()) RenderSystem.setShaderColor(f * .2F + .04F, f1 * .2F + .04F, f2 * .6F + .1F, 1F);
//	            else RenderSystem.setShaderColor(f, f1, f2, 1F);
//	            RenderSystem.enableBlend();
	            RenderSystem.depthMask(true);
			}
		}
		return true;
	}
}