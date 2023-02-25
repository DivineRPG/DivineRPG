package divinerpg.client.renders.tiles;


import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.tiles.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

import com.mojang.math.Vector3f;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderAltarOfCorruption implements BlockEntityRenderer<AltarOfCorruptionEntity> {
    @SuppressWarnings("deprecation")
	public static final Material TEXTURE_BOOK = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(DivineRPG.MODID, "textures/model/altar_book.png"));
    private final BookModel bookModel;

    public RenderAltarOfCorruption(BlockEntityRendererProvider.Context context) {
        this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }


    public void render(AltarOfCorruptionEntity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5D, 0.75D, 0.5D);
        float f = (float)tileEntityIn.time + partialTicks;
        matrixStackIn.translate(0.0D, (double)(0.1F + Mth.sin(f * 0.1F) * 0.01F), 0.0D);

        float f1;
        for(f1 = tileEntityIn.rot - tileEntityIn.oRot; f1 >= (float)Math.PI; f1 -= ((float)Math.PI * 2F)) {
        }

        while(f1 < -(float)Math.PI) {
            f1 += ((float)Math.PI * 2F);
        }

        float f2 = tileEntityIn.oRot + f1 * partialTicks;
        matrixStackIn.mulPose(Vector3f.YP.rotation(-f2));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(80.0F));
        float f3 = Mth.lerp(partialTicks, tileEntityIn.oFlip, tileEntityIn.flip);
        float f4 = Mth.frac(f3 + 0.25F) * 1.6F - 0.3F;
        float f5 = Mth.frac(f3 + 0.75F) * 1.6F - 0.3F;
        float f6 = Mth.lerp(partialTicks, tileEntityIn.oOpen, tileEntityIn.open);
        this.bookModel.setupAnim(f, Mth.clamp(f4, 0.0F, 1.0F), Mth.clamp(f5, 0.0F, 1.0F), f6);
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(TEXTURE_BOOK.texture()));
        bookModel.renderToBuffer(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }
}