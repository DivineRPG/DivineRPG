package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import divinerpg.block_entities.block.RiftBlockEntity;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;

import static divinerpg.DivineRPG.MODID;

public class RenderRift implements BlockEntityRenderer<RiftBlockEntity> {
    BlockEntityRenderDispatcher dispatcher;
    static final RenderType
        overworld = RenderType.entityTranslucentCull(ResourceLocation.fromNamespaceAndPath(MODID, "textures/block/overworld_rift_full.png")),
        eden = RenderType.entityTranslucentCull(ResourceLocation.fromNamespaceAndPath(MODID, "textures/block/eden_rift_full.png")),
        wildwood = RenderType.entityTranslucentCull(ResourceLocation.fromNamespaceAndPath(MODID, "textures/block/wildwood_rift_full.png")),
        apalachia = RenderType.entityTranslucentCull(ResourceLocation.fromNamespaceAndPath(MODID, "textures/block/apalachia_rift_full.png")),
        skythern = RenderType.entityTranslucentCull(ResourceLocation.fromNamespaceAndPath(MODID, "textures/block/skythern_rift_full.png")),
        mortum = RenderType.entityTranslucentCull(ResourceLocation.fromNamespaceAndPath(MODID, "textures/block/mortum_rift_full.png"));
    public RenderRift(BlockEntityRendererProvider.Context context) {
        dispatcher = context.getBlockEntityRenderDispatcher();
    }
    static float
        sh1 = (float)Math.floor(Math.random() * 4D) * .25F,
        sh2 = .125F + (float)Math.floor(Math.random() * 4D) * .25F,
        sh3 = (float)Math.floor(Math.random() * 4D) * .25F,
        sh4 = .125F + (float)Math.floor(Math.random() * 4D) * .25F;
    @Override
    public void render(RiftBlockEntity riftBlockEntity, float v, PoseStack matrix, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        if(riftBlockEntity.variant == 0) return;
        matrix.pushPose();
        matrix.translate(.5F, .1F, .5F);
        matrix.scale(2F, 2F, 2F);
        matrix.mulPose(dispatcher.camera.rotation());
        PoseStack.Pose matrixEntry = matrix.last();
        Matrix4f matrix4f = matrixEntry.pose();
        VertexConsumer vertexBuilder = buffer.getBuffer(switch(riftBlockEntity.variant & 0b111) {
            case 1 -> eden;
            case 2 -> wildwood;
            case 3 -> apalachia;
            case 4 -> skythern;
            case 5 -> mortum;
            default -> overworld;
        });
        if((riftBlockEntity.variant & 0b10000) == 0b10000 ) {
            switch(Mth.floor(Math.random() * 5D)) {
            case 0 -> sh1 = (float)Math.floor(Math.random() * 4D) * .25F;
            case 1 -> sh2 = .125F + (float)Math.floor(Math.random() * 4D) * .25F;
            case 2 -> sh3 = (float)Math.floor(Math.random() * 4D) * .25F;
            case 3 -> sh4 = .125F + (float)Math.floor(Math.random() * 4D) * .25F;
            default -> {}
            } poses(vertexBuilder, matrix4f, packedLight, 0F, .5F, 0F, sh1);
            poses(vertexBuilder, matrix4f, packedLight, 0F, 0F, 0F, sh2);
            poses(vertexBuilder, matrix4f, packedLight, .5F, .5F,  .5F, sh3);
            poses(vertexBuilder, matrix4f, packedLight, .5F, 0F, .5F, sh4);
        } else {
            float shift = ((riftBlockEntity.clientTickCount >> 2) & 3) * .25F, shiftmax = shift + .25F;
            pos(vertexBuilder, matrix4f, packedLight, 0, 0, 0, shiftmax);
            pos(vertexBuilder, matrix4f, packedLight, 1, 0, 1, shiftmax);
            pos(vertexBuilder, matrix4f, packedLight, 1, 1, 1, shift);
            pos(vertexBuilder, matrix4f, packedLight, 0, 1, 0, shift);
        }
        matrix.popPose();
    }
    private static void poses(VertexConsumer vertexBuilder, Matrix4f matrix4f, int packedLight, float x, float y, float slide, float shift) {
        float slidemax = slide + .5F, shiftmax = shift + .125F, xmax = x + .5F, ymax = y + .5F;
        pos(vertexBuilder, matrix4f, packedLight, x, y, slide, shiftmax);
        pos(vertexBuilder, matrix4f, packedLight, xmax, y, slidemax, shiftmax);
        pos(vertexBuilder, matrix4f, packedLight, xmax, ymax, slidemax, shift);
        pos(vertexBuilder, matrix4f, packedLight, x, ymax, slide, shift);
    }
    private static void pos(VertexConsumer vertexBuilder, Matrix4f matrix4f, int lightmapUV, float x, float y, float u, float v) {
        vertexBuilder.addVertex(matrix4f, x - .5F, y - .25F, 0).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(lightmapUV).setNormal(0, 1, 0);
    }
}
