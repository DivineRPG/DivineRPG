package TeamDivineRPG.divinerpg.client.renders.vanilla;


import TeamDivineRPG.divinerpg.DivineRPG;
import TeamDivineRPG.divinerpg.client.models.vanilla.ModelShark;
import TeamDivineRPG.divinerpg.entities.vanilla.EntityShark;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderShark extends EntityRenderer<EntityShark> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/shark.png");
    protected final ModelShark model = new ModelShark();

    public RenderShark(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        this.shadowSize = 0.8F;
    }

    public void render(EntityShark entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
        float f = 4.3F * MathHelper.sin(0.6F * entityIn.ticksExisted);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
        if (!entityIn.isInWater()) {
            matrixStackIn.translate(0.1F, 0.1F, -0.1F);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
        }
        this.model.setRotationAngles(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.getRenderType(this.getEntityTexture(entityIn)));
        this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntityShark entity) {
        return TEXTURE;
    }
}