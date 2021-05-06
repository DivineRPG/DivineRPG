package divinerpg.client.renders.tiles;


import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.tiles.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderAltarOfCorruption extends TileEntityRenderer<AltarOfCorruptionEntity> {
    public static final RenderMaterial TEXTURE_BOOK = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, new ResourceLocation(DivineRPG.MODID, "textures/model/altar_book.png"));
    private final BookModel modelBook = new BookModel();

    public RenderAltarOfCorruption(TileEntityRendererDispatcher p_i226010_1_) {
        super(p_i226010_1_);
    }

    public void render(AltarOfCorruptionEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5D, 0.75D, 0.5D);
        float f = (float)tileEntityIn.time + partialTicks;
        matrixStackIn.translate(0.0D, (double)(0.1F + MathHelper.sin(f * 0.1F) * 0.01F), 0.0D);

        float f1;
        for(f1 = tileEntityIn.rot - tileEntityIn.oRot; f1 >= (float)Math.PI; f1 -= ((float)Math.PI * 2F)) {
        }

        while(f1 < -(float)Math.PI) {
            f1 += ((float)Math.PI * 2F);
        }

        float f2 = tileEntityIn.oRot + f1 * partialTicks;
        matrixStackIn.mulPose(Vector3f.YP.rotation(-f2));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(80.0F));
        float f3 = MathHelper.lerp(partialTicks, tileEntityIn.oFlip, tileEntityIn.flip);
        float f4 = MathHelper.frac(f3 + 0.25F) * 1.6F - 0.3F;
        float f5 = MathHelper.frac(f3 + 0.75F) * 1.6F - 0.3F;
        float f6 = MathHelper.lerp(partialTicks, tileEntityIn.oOpen, tileEntityIn.open);
        this.modelBook.setupAnim(f, MathHelper.clamp(f4, 0.0F, 1.0F), MathHelper.clamp(f5, 0.0F, 1.0F), f6);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(TEXTURE_BOOK.texture()));
        modelBook.renderToBuffer(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }
}