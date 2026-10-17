package divinerpg.effect.dimension;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import divinerpg.DivineRPG;
import divinerpg.registries.LevelRegistry;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.state.level.SkyRenderState;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import org.joml.*;

import java.lang.Math;
import java.util.Optional;
import java.util.OptionalDouble;

public class TwilightSkyRenderer implements AutoCloseable {

    public static final Identifier SUN_LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/particle/twilight_sun.png");
    public static final Identifier POG_SUN_LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/particle/pog_sun.png");

    private final RenderTarget renderTarget;
    private final GpuBuffer skyBuffer;
    private final GpuBuffer starBuffer;
    private final GpuBuffer sunBuffer;
    private final AbstractTexture sunTexture;
    private final AbstractTexture pogSunTexture;
    private final RenderSystem.AutoStorageIndexBuffer quadIndices;

    public TwilightSkyRenderer(TextureManager textureManager, RenderTarget renderTarget) {
        this.renderTarget = renderTarget;
        this.quadIndices = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
        this.sunTexture = textureManager.getTexture(SUN_LOCATION);
        this.pogSunTexture = textureManager.getTexture(POG_SUN_LOCATION);

        this.skyBuffer = buildSkyDiscBuffer(16.0F);
        this.starBuffer = buildStarsBuffer();
        this.sunBuffer = buildSunQuadBuffer();
    }

    public static boolean doesMobEffectBlockSky(Camera camera) {
        Entity entity = camera.entity();
        if (!(entity instanceof LivingEntity livingentity)) return false;
        return livingentity.hasEffect(MobEffects.BLINDNESS) || livingentity.hasEffect(MobEffects.DARKNESS) || livingentity.hasEffect(MobEffectRegistry.HEAVY_AIR);
    }

    public void render(ClientLevel level, SkyRenderState state, Camera camera) {
        FogType fogType = camera.getFluidInCamera();
        if (fogType == FogType.POWDER_SNOW || fogType == FogType.LAVA || doesMobEffectBlockSky(camera)) {
            return;
        }
        GpuTextureView colorTexture = this.renderTarget.getColorTextureView();
        GpuTextureView depthTexture = this.renderTarget.getDepthTextureView();
        try (RenderPass renderPass = RenderSystem.getDevice().createCommandEncoder().createRenderPass(() -> "Twilight Sky", colorTexture, Optional.empty(), depthTexture, OptionalDouble.empty())) {
            RenderSystem.bindDefaultUniforms(renderPass);
            renderSkyDisc(renderPass, state.skyColor);
            boolean usePogSun = level.dimension() == LevelRegistry.MORTUM && camera.position().y < 0;
            AbstractTexture targetSun = usePogSun ? this.pogSunTexture : this.sunTexture;
            renderSun(renderPass, state.sunAngle, state.rainBrightness, targetSun);
            if (state.starBrightness > 0.0F) {
                renderStars(renderPass, state.starAngle, state.starBrightness * state.rainBrightness * 1.01F);
            }
        }
    }

    private void renderSkyDisc(RenderPass renderPass, Vector3fc color) {
        GpuBufferSlice dynamicTransforms = RenderSystem.getDynamicUniforms().writeTransform(RenderSystem.getModelViewMatrixCopy(), new Vector4f(color.x(), color.y(), color.z(), 1.0F));
        renderPass.pushDebugGroup(() -> "Twilight Sky Disc");
        renderPass.setPipeline(RenderSystem.getCompiledPipeline(RenderPipelines.SKY));
        renderPass.setUniform("DynamicTransforms", dynamicTransforms);
        renderPass.setVertexBuffer(0, this.skyBuffer.slice());
        renderPass.draw(10, 1, 0, 0);
        renderPass.popDebugGroup();
    }

    private void renderSun(RenderPass renderPass, float sunAngle, float rainBrightness, AbstractTexture texture) {
        Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.pushMatrix();
        modelViewStack.rotate(Axis.YP.rotationDegrees(-90.0F));
        modelViewStack.rotate(Axis.XP.rotationDegrees(sunAngle * (180.0F / (float) Math.PI)));
        modelViewStack.translate(0.0F, 100.0F, 0.0F);
        modelViewStack.scale(30.0F, 1.0F, 30.0F);
        GpuBufferSlice dynamicTransforms = RenderSystem.getDynamicUniforms().writeTransform(new Matrix4f(modelViewStack), new Vector4f(1.0F, 1.0F, 1.0F, rainBrightness));
        renderPass.pushDebugGroup(() -> "Twilight Sun");
        renderPass.setPipeline(RenderSystem.getCompiledPipeline(RenderPipelines.CELESTIAL));
        RenderSystem.bindDefaultUniforms(renderPass);
        renderPass.setUniform("DynamicTransforms", dynamicTransforms);
        renderPass.setUniform("Sampler0", texture.getTextureView(), texture.getSampler());
        renderPass.setVertexBuffer(0, this.sunBuffer.slice());
        renderPass.setIndexBuffer(this.quadIndices.getBuffer(6), this.quadIndices.type());
        renderPass.drawIndexed(6, 1, 0, 0, 0);
        renderPass.popDebugGroup();
        modelViewStack.popMatrix();
    }

    private void renderStars(RenderPass renderPass, float starAngle, float brightness) {
        Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
        modelViewStack.pushMatrix();
        modelViewStack.rotate(Axis.YP.rotationDegrees(-90.0F));
        modelViewStack.rotate(Axis.XP.rotationDegrees(starAngle * (180.0F / (float) Math.PI)));
        GpuBufferSlice dynamicTransforms = RenderSystem.getDynamicUniforms().writeTransform(new Matrix4f(modelViewStack), new Vector4f(brightness, brightness, brightness, brightness));
        renderPass.pushDebugGroup(() -> "Twilight Stars");
        renderPass.setPipeline(RenderSystem.getCompiledPipeline(RenderPipelines.STARS));
        RenderSystem.bindDefaultUniforms(renderPass);
        renderPass.setUniform("DynamicTransforms", dynamicTransforms);
        renderPass.setVertexBuffer(0, this.starBuffer.slice());
        renderPass.setIndexBuffer(this.quadIndices.getBuffer(1500 * 6), this.quadIndices.type());
        renderPass.drawIndexed(1500 * 6, 1, 0, 0, 0);
        renderPass.popDebugGroup();
        modelViewStack.popMatrix();
    }

    private static GpuBuffer buildSkyDiscBuffer(float yOffset) {
        try (ByteBufferBuilder byteBuilder = ByteBufferBuilder.exactlySized(10 * DefaultVertexFormat.POSITION.getVertexSize())) {
            BufferBuilder builder = new BufferBuilder(byteBuilder, PrimitiveTopology.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
            builder.addVertex(0.0F, yOffset, 0.0F);
            for (int i = -180; i <= 180; i += 45) {
                float rad = (float) Math.toRadians(i);
                builder.addVertex((float) (512.0 * Math.cos(rad)), yOffset, (float) (512.0 * Math.sin(rad)));
            }
            MeshData meshData = builder.buildOrThrow();
            return RenderSystem.getDevice().createBuffer(() -> "Twilight Sky Disc Buffer", 32, meshData.vertexBuffer());
        }
    }

    private static GpuBuffer buildSunQuadBuffer() {
        try (ByteBufferBuilder byteBuilder = ByteBufferBuilder.exactlySized(4 * DefaultVertexFormat.POSITION_TEX.getVertexSize())) {
            BufferBuilder builder = new BufferBuilder(byteBuilder, PrimitiveTopology.QUADS, DefaultVertexFormat.POSITION_TEX);
            builder.addVertex(-1.0F, 0.0F, -1.0F).setUv(0.0F, 0.0F);
            builder.addVertex(1.0F, 0.0F, -1.0F).setUv(1.0F, 0.0F);
            builder.addVertex(1.0F, 0.0F, 1.0F).setUv(1.0F, 1.0F);
            builder.addVertex(-1.0F, 0.0F, 1.0F).setUv(0.0F, 1.0F);
            MeshData meshData = builder.buildOrThrow();
            return RenderSystem.getDevice().createBuffer(() -> "Twilight Sun Buffer", 32, meshData.vertexBuffer());
        }
    }

    private static GpuBuffer buildStarsBuffer() {
        RandomSource random = RandomSource.create(10842L);
        try (ByteBufferBuilder byteBuilder = ByteBufferBuilder.exactlySized(1500 * 4 * DefaultVertexFormat.POSITION.getVertexSize())) {
            BufferBuilder builder = new BufferBuilder(byteBuilder, PrimitiveTopology.QUADS, DefaultVertexFormat.POSITION);
            for (int i = 0; i < 1500; ++i) {
                double d0 = random.nextFloat() * 2.0F - 1.0F;
                double d1 = random.nextFloat() * 2.0F - 1.0F;
                double d2 = random.nextFloat() * 2.0F - 1.0F;
                double size = 0.15F + random.nextFloat() * 0.1F;
                double distSqr = d0 * d0 + d1 * d1 + d2 * d2;
                if (distSqr < 1.0D && distSqr > 0.01D) {
                    double invDist = 1.0D / Math.sqrt(distSqr);
                    d0 *= invDist;
                    d1 *= invDist;
                    d2 *= invDist;
                    double x = d0 * 100.0D, y = d1 * 100.0D, z = d2 * 100.0D;
                    double yaw = Math.atan2(d0, d2);
                    double sinYaw = Math.sin(yaw), cosYaw = Math.cos(yaw);
                    double pitch = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                    double sinPitch = Math.sin(pitch), cosPitch = Math.cos(pitch);
                    double roll = random.nextDouble() * Math.PI * 2.0D;
                    double sinRoll = Math.sin(roll), cosRoll = Math.cos(roll);

                    for (int j = 0; j < 4; ++j) {
                        double cornerX = ((j & 2) - 1) * size;
                        double cornerY = ((j + 1 & 2) - 1) * size;
                        double rotX = cornerX * cosRoll - cornerY * sinRoll;
                        double rotY = cornerY * cosRoll + cornerX * sinRoll;
                        double pX = rotX * sinPitch;
                        double pY = -rotX * cosPitch;
                        double fX = pY * sinYaw - rotY * cosYaw;
                        double fZ = rotY * sinYaw + pY * cosYaw;
                        builder.addVertex((float) (x + fX), (float) (y + pX), (float) (z + fZ));
                    }
                }
            }
            MeshData meshData = builder.buildOrThrow();
            return RenderSystem.getDevice().createBuffer(() -> "Twilight Star Buffer", 32, meshData.vertexBuffer());
        }
    }

    @Override
    public void close() {
        if (this.skyBuffer != null) this.skyBuffer.close();
        if (this.starBuffer != null) this.starBuffer.close();
        if (this.sunBuffer != null) this.sunBuffer.close();
    }
}