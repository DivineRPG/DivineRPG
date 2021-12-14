package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.*;

public class RenderAyeracoSpawn extends TileEntityRenderer<TileEntityAyeracoSpawn> {
    private static ResourceLocation greenTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/green_ayeraco_symbol.png");
    private static ResourceLocation redTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/red_ayeraco_symbol.png");
    private static ResourceLocation yellowTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/yellow_ayeraco_symbol.png");
    private static ResourceLocation blueTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/blue_ayeraco_symbol.png");
    private static ResourceLocation purpleTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/purple_ayeraco_symbol.png");

    public RenderAyeracoSpawn(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntityAyeracoSpawn tile, float ticks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
    matrixStack.pushPose();
        if (tile.spawnTick > 430)
            Minecraft.getInstance().textureManager.bind(greenTexture);
        else if (tile.spawnTick > 300)
            Minecraft.getInstance().textureManager.bind(blueTexture);
        else if (tile.spawnTick > 210)
            Minecraft.getInstance().textureManager.bind(redTexture);
        else if (tile.spawnTick > 145)
            Minecraft.getInstance().textureManager.bind(yellowTexture);
        else if (tile.spawnTick > 0)
            Minecraft.getInstance().textureManager.bind(purpleTexture);

        matrixStack.scale(2, 2, 2);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuilder();
        float minU = 0;
        float maxU = 1;
        float minV = 0;
        float maxV = 1;
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;

        matrixStack.translate(0, 0, -0.28125F);
        matrixStack.mulPose(new Quaternion(Vector3f.XP.rotationDegrees(tile.getLevel().getGameTime() * 4)));
        matrixStack.translate(0, 0, 0.28125f);
        matrixStack.mulPose(new Quaternion(Vector3f.XN.rotationDegrees(270)));
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.vertex(0.0F - f8, 0.0F - f9, 0.0D).uv(minU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(f7 - f8, 0.0F - f9, 0.0D).uv(maxU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(f7 - f8, 1.0F - f9, 0.0D).uv(maxU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(0.0F - f8, 1.0F - f9, 0.0D).uv(minU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.end();

        matrixStack.translate(0, 0.001f, -0.28125f);
        matrixStack.mulPose(new Quaternion(Vector3f.XN.rotationDegrees(-tile.getLevel().getGameTime() * 4)));
        matrixStack.translate(0, 0, 0.28125f);
        matrixStack.mulPose(new Quaternion(Vector3f.XN.rotationDegrees(270)));
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.vertex(0.0F - f8, 0.0F - f9, 0.0D).uv(minU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(f7 - f8, 0.0F - f9, 0.0D).uv(maxU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(f7 - f8, 1.0F - f9, 0.0D).uv(maxU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferBuilder.vertex(0.0F - f8, 1.0F - f9, 0.0D).uv(minU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.end();
    matrixStack.popPose();
    }


}
