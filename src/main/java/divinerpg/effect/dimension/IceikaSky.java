package divinerpg.effect.dimension;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.Utils;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;

import org.joml.*;

import javax.annotation.Nullable;
import java.lang.Math;

public class IceikaSky extends DimensionSpecialEffects {
	public static final ResourceLocation
		SUN_LOCATION = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/particle/white_dwarf.png"),
		MOON_LOCATION = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/particle/ice_moon_phases.png"),
		SNOW_LOCATION = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/environment/snow.png"),
		HAIL_LOCATION = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/environment/hail.png"),
		BONEYARD_LOCATION = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "boneyard");
	@Nullable private VertexBuffer skyBuffer, starBuffer;
	private final float[] rainSizeX = new float[1024], rainSizeZ = new float[1024];
	private boolean isRaining = false, isBoneyard = false, isBlizzard = false;
	private int lastTick;
	public IceikaSky() {
		super(256F, true, SkyType.NORMAL, false, false);
		
		for(int i = 0; i < 32; ++i) for(int j = 0; j < 32; ++j) {
			float f = j - 16, f1 = i - 16, f2 = Mth.sqrt(f * f + f1 * f1);
			rainSizeX[i << 5 | j] = -f1 / f2;
			rainSizeZ[i << 5 | j] = f / f2;
		}
		//create sky
		Tesselator tesselator = Tesselator.getInstance();
		RenderSystem.setShader(GameRenderer::getPositionShader);
		if(starBuffer != null) starBuffer.close();
		starBuffer = new VertexBuffer(VertexBuffer.Usage.DYNAMIC);
		MeshData bufferbuilder$renderedbuffer = TwilightSky.drawStars(tesselator);
		starBuffer.bind();
		starBuffer.upload(bufferbuilder$renderedbuffer);
		VertexBuffer.unbind();
		tesselator = Tesselator.getInstance();
	    if(skyBuffer != null) skyBuffer.close();
	    skyBuffer = new VertexBuffer(VertexBuffer.Usage.DYNAMIC);
	    bufferbuilder$renderedbuffer = TwilightSky.buildSkyDisc(tesselator, 16F);
	    skyBuffer.bind();
	    skyBuffer.upload(bufferbuilder$renderedbuffer);
	    VertexBuffer.unbind();
	}
	@SuppressWarnings("resource")
	@Override
	public boolean renderSnowAndRain(ClientLevel level, int ticks, float partialTick, LightTexture lightTexture, double camX, double camY, double camZ) {
		float f = level.getRainLevel(partialTick);
		if(f > 0F) {
    	  lightTexture.turnOnLightLayer();
          int i = Mth.floor(camX), j = Mth.floor(camY), k = Mth.floor(camZ);
          Tesselator tesselator = Tesselator.getInstance();
          BufferBuilder bufferbuilder = null;
          RenderSystem.disableCull();
          RenderSystem.enableBlend();
          RenderSystem.defaultBlendFunc();
          RenderSystem.enableDepthTest();
          int l = Minecraft.useFancyGraphics() ? 10 : 5;
          RenderSystem.depthMask(Minecraft.useShaderTransparency());
          int i1 = -1;
          float f1 = ticks + partialTick;
          RenderSystem.setShader(GameRenderer::getParticleShader);
          RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
          BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
          for(int j1 = k - l; j1 <= k + l; ++j1) for(int k1 = i - l; k1 <= i + l; ++k1) {
            int l1 = (j1 - k + 16) * 32 + k1 - i + 16;
            double d0 = this.rainSizeX[l1] * .5D, d1 = this.rainSizeZ[l1] * .5D;
            blockpos$mutableblockpos.set(k1, camY, j1);
            Biome biome = level.getBiome(blockpos$mutableblockpos).value();
            if(biome.getPrecipitationAt(blockpos$mutableblockpos) != Biome.Precipitation.NONE) {
               int i2 = level.getHeight(Heightmap.Types.MOTION_BLOCKING, k1, j1), j2 = j - l, k2 = j + l;
               if(j2 < i2) j2 = i2;
               if(k2 < i2) k2 = i2;
               int l2 = i2;
               if(i2 < j) l2 = j;
               if(j2 != k2) {
                 RandomSource randomsource = RandomSource.create((long)(k1 * k1 * 3121 + k1 * 45238971 ^ j1 * j1 * 418711 + j1 * 13761));
                 blockpos$mutableblockpos.set(k1, j2, j1);
                 int precipitationType = Utils.ICEIKA_WEATHER;
                 if(precipitationType == 0) {
                     if(i1 != 0) {
                         if(i1 >= 0) BufferUploader.drawWithShader(bufferbuilder.build());
                         i1 = 0;
                         RenderSystem.setShaderTexture(0, SNOW_LOCATION);
                         bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
                      }
                      float f5 = -((ticks & 511) + partialTick) / 512F, f6 = (float)(randomsource.nextDouble() + f1 * .01 * randomsource.nextGaussian()), f7 = (float)(randomsource.nextDouble() + f1 * randomsource.nextGaussian() * .001D);
                      double d3 = k1 + .5 - camX, d5 = j1 + .5D - camZ;
                      float f8 = (float) (Math.sqrt(d3 * d3 + d5 * d5) / l), f9 = ((1F - f8 * f8) * .3F + .5F) * f;
                      blockpos$mutableblockpos.set(k1, l2, j1);
                      int k3 = LevelRenderer.getLightColor(level, blockpos$mutableblockpos), l3 = k3 >> 16 & '\uffff', i4 = k3 & '\uffff', j4 = (l3 * 3 + 240) / 4, k4 = (i4 * 3 + 240) / 4;
                      bufferbuilder.addVertex((float)(k1 - camX - d0 + .5), (float)(k2 - camY), (float)(j1 - camZ - d1 + .5)).setUv(0F + f6, j2 * .25F + f5 + f7).setColor(1F, 1F, 1F, f9).setUv2(k4, j4);
                      bufferbuilder.addVertex((float)(k1 - camX + d0 + .5), (float)(k2 - camY), (float)(j1 - camZ + d1 + .5)).setUv(1F + f6, j2 * .25F + f5 + f7).setColor(1F, 1F, 1F, f9).setUv2(k4, j4);
                      bufferbuilder.addVertex((float)(k1 - camX + d0 + .5), (float)(j2 - camY), (float)(j1 - camZ + d1 + .5)).setUv(1F + f6, k2 * .25F + f5 + f7).setColor(1F, 1F, 1F, f9).setUv2(k4, j4);
                      bufferbuilder.addVertex((float)(k1 - camX - d0 + .5), (float)(j2 - camY), (float)(j1 - camZ - d1 + .5)).setUv(0F + f6, k2 * .25F + f5 + f7).setColor(1F, 1F, 1F, f9).setUv2(k4, j4);
                 } else if(precipitationType == 1) {
                	 if(i1 != 1) {
                         if(i1 >= 0) BufferUploader.drawWithShader(bufferbuilder.build());
                         i1 = 1;
                         RenderSystem.setShaderTexture(0, HAIL_LOCATION);
                         bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
                      }
                      int i3 = ticks + k1 * k1 * 3121 + k1 * 45238971 + j1 * j1 * 418711 + j1 * 13761 & 31;
                      float f2 = -(i3 + partialTick) / 32F * (3F + randomsource.nextFloat());
                      double d2 = k1 + .5 - camX, d4 = j1 + .5 - camZ;
                      float f3 = (float)Math.sqrt(d2 * d2 + d4 * d4) / l;
                      float f4 = ((1F - f3 * f3) * .5F + .5F) * f;
                      blockpos$mutableblockpos.set(k1, l2, j1);
                      int j3 = LevelRenderer.getLightColor(level, blockpos$mutableblockpos);
                      uv2(bufferbuilder.addVertex((float)(k1 - camX - d0 + .5), (float)(k2 - camY), (float)(j1 - camZ - d1 + .5)).setUv(0F, j2 * .25F + f2).setColor(1F, 1F, 1F, f4), j3);
                      uv2(bufferbuilder.addVertex((float)(k1 - camX + d0 + .5), (float)(k2 - camY), (float)(j1 - camZ + d1 + .5)).setUv(1F, j2 * .25F + f2).setColor(1F, 1F, 1F, f4), j3);
                      uv2(bufferbuilder.addVertex((float)(k1 - camX + d0 + .5), (float)(j2 - camY), (float)(j1 - camZ + d1 + .5)).setUv(1F, k2 * .25F + f2).setColor(1F, 1F, 1F, f4), j3);
                      uv2(bufferbuilder.addVertex((float)(k1 - camX - d0 + .5), (float)(j2 - camY), (float)(j1 - camZ - d1 + .5)).setUv(0F, k2 * .25F + f2).setColor(1F, 1F, 1F, f4), j3);
                 } else if(precipitationType == 2 && lastTick != ticks && Minecraft.getInstance().options.particles().get() != ParticleStatus.MINIMAL && randomsource.nextBoolean()) {
                	 double x = camX + Math.random() * 38D - 19D, y = camY + Math.random() * 16D - 8D, z = camZ + Math.random() * 32D - 16D;
                	 if(level.canSeeSky(new BlockPos((int)x, (int)y, (int)z))) {
                		 isBlizzard = true;
                		 level.addParticle(ParticleTypes.SNOWFLAKE, true, x, y, z, .5, .1, 0);
                	 }
                 }
               }
            }
          }
          if(i1 >= 0) BufferUploader.drawWithShader(bufferbuilder.build());
          RenderSystem.enableCull();
          RenderSystem.disableBlend();
          lightTexture.turnOffLightLayer();
		}
		lastTick = ticks;
		return true;
	}
	public static void uv2(VertexConsumer c, int j) {
		c.setUv2(j & '\uffff', j >> 16 & '\uffff');
	}
	@Override
	public boolean tickRain(ClientLevel level, int ticks, Camera camera) {
		return true;
	}
	public Vec3 getBrightnessDependentFogColor(Vec3 vec, float f) {
		return vec.multiply(f * .94 + .06, f * .94 + .06, f * .91 + .09);
	}
	public boolean isFoggyAt(int x, int y) {return (y < 128 && isRaining) || isBoneyard;}
	@Override @Nullable
	public float[] getSunriseColor(float f, float ff) {
		float color[] = super.getSunriseColor(f, ff);
		if(color == null) return null;
		return new float[] {color[0] * .2F, color[1] * .9F, color[2], color[3]};
	}

	@Override
	public boolean renderSky(ClientLevel level, int ticks, float partialTick, Matrix4f modelViewMatrix, Camera camera, Matrix4f projectionMatrix, boolean isFoggy, Runnable setupFog) {
        if(isBlizzard && Utils.ICEIKA_WEATHER != 2 && level.canSeeSky(camera.getBlockPosition())) {
       	 isBlizzard = false;
       	 level.playLocalSound(camera.getBlockPosition(), SoundRegistry.SNOWFLAKES_AFTER_BLIZZARD.get(), SoundSource.MUSIC, .2F, 1F, false);
        }
		isRaining = level.isRaining();
		isBoneyard = level.getBiome(camera.getBlockPosition()).is(BONEYARD_LOCATION);
		setupFog.run();
		if(!isFoggy) {
			FogType fogtype = camera.getFluidInCamera();
			if(fogtype != FogType.POWDER_SNOW && fogtype != FogType.LAVA && !TwilightSky.doesMobEffectBlockSky(camera)) {
//				RenderSystem.disableBlend();
				Vec3 vec3 = level.getSkyColor(camera.getPosition(), partialTick);
				float f = (float)(vec3.x * .1), f1 = (float)(vec3.y * .1), f2 = (float)(vec3.z * .17);
				FogRenderer.levelFogColor();
				Tesselator tesselator = Tesselator.getInstance();
				RenderSystem.depthMask(false);
				RenderSystem.setShaderColor(f, f1, f2, 1F);
				ShaderInstance shaderinstance = RenderSystem.getShader();
				skyBuffer.bind();
				skyBuffer.drawWithShader(modelViewMatrix, projectionMatrix, shaderinstance);
				VertexBuffer.unbind();
				RenderSystem.enableBlend();
				RenderSystem.defaultBlendFunc();
				float[] afloat = level.effects().getSunriseColor(level.getTimeOfDay(partialTick), partialTick);
				if(afloat != null) {
					RenderSystem.setShader(GameRenderer::getPositionColorShader);
//					RenderSystem.disableBlend();
					RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
					modelViewMatrix.rotate(Axis.XP.rotationDegrees(90.0F));
					float f3 = Mth.sin(level.getSunAngle(partialTick)) < 0F ? 180F : 0F;
					modelViewMatrix.rotate(Axis.ZP.rotationDegrees(f3));
					modelViewMatrix.rotate(Axis.ZP.rotationDegrees(90F));
					float f4 = afloat[0], f5 = afloat[1], f6 = afloat[2];
					BufferBuilder bufferbuilder = tesselator.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
					bufferbuilder.addVertex(modelViewMatrix, 0F, 100F, 0F).setColor(f4, f5, f6, afloat[3]);
					for(int j = 0; j <= 16; ++j) {
						float f7 = (float)(j * (Math.PI * 2F) / 16F), f8 = Mth.sin(f7), f9 = Mth.cos(f7);
						bufferbuilder.addVertex(modelViewMatrix, f8 * 120F, f9 * 120F, -f9 * 40F * afloat[3]).setColor(afloat[0], afloat[1], afloat[2], 0F);
					}
					BufferUploader.drawWithShader(bufferbuilder.build());
				}
//				RenderSystem.enableBlend();
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				float f11 = 1F - level.getRainLevel(partialTick);
				RenderSystem.setShaderColor(1F, 1F, 1F, f11);
				modelViewMatrix.rotate(Axis.YP.rotationDegrees(-90F));
				modelViewMatrix.rotate(Axis.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360F));
				float f12 = 30F;
				RenderSystem.setShader(GameRenderer::getPositionTexShader);
				RenderSystem.setShaderTexture(0, SUN_LOCATION);
				BufferBuilder bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
				bufferbuilder.addVertex(modelViewMatrix, -f12, 100F, -f12).setUv(0F, 0F);
				bufferbuilder.addVertex(modelViewMatrix, f12, 100F, -f12).setUv(1F, 0F);
				bufferbuilder.addVertex(modelViewMatrix, f12, 100F, f12).setUv(1F, 1F);
				bufferbuilder.addVertex(modelViewMatrix, -f12, 100F, f12).setUv(0F, 1F);
				BufferUploader.drawWithShader(bufferbuilder.build());
				f12 = 20F;
	            RenderSystem.setShaderTexture(0, MOON_LOCATION);
	            int k = level.getMoonPhase(), l = k % 4, i1 = k / 4 % 2;
	            float f13 = l / 4F, f14 = i1 / 2F, f15 = (l + 1) / 4F, f16 = (i1 + 1) / 2F;
	            bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
	            bufferbuilder.addVertex(modelViewMatrix, -f12, -100F, f12).setUv(f15, f16);
	            bufferbuilder.addVertex(modelViewMatrix, f12, -100F, f12).setUv(f13, f16);
	            bufferbuilder.addVertex(modelViewMatrix, f12, -100F, -f12).setUv(f13, f14);
	            bufferbuilder.addVertex(modelViewMatrix, -f12, -100F, -f12).setUv(f15, f14);
	            BufferUploader.drawWithShader(bufferbuilder.build());
//	            RenderSystem.disableBlend();
				float f10 = level.getStarBrightness(partialTick) * f11 + .5F;
				RenderSystem.setShaderColor(f10, f10, f10, f10);
				FogRenderer.setupNoFog();
				starBuffer.bind();
				starBuffer.drawWithShader(modelViewMatrix, projectionMatrix, GameRenderer.getPositionShader());
				VertexBuffer.unbind();
				setupFog.run();
				RenderSystem.setShaderColor(.82F, .85F + ((afloat == null ? 0F : afloat[1] * 1.84F) * (.398F - Math.abs(Mth.cos(level.getTimeOfDay(partialTick) * ((float)Math.PI * 2F))))), .92F + f2 * 1.4F, 1F);
				RenderSystem.disableBlend();
				RenderSystem.defaultBlendFunc();
				RenderSystem.depthMask(true);
			}
		}
		return true;
	}
}