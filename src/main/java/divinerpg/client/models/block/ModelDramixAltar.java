package divinerpg.client.models.block;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;

public class ModelDramixAltar extends Model {
    //fields
    ModelRenderer Base;
    ModelRenderer P1;
    ModelRenderer P2;
    ModelRenderer P3;
    ModelRenderer P4;
    ModelRenderer S1;
    ModelRenderer S2;
    ModelRenderer S3;
    ModelRenderer S4;

    public ModelDramixAltar() {
        super(RenderType::entityCutoutNoCull);
        texWidth = 64;
        texHeight = 32;
        Base = new ModelRenderer(this, 0, 15);
        Base.addBox(0F, 0F, 0F, 16, 1, 16);
        Base.setPos(-8F, 10F, -8F);
        Base.setTexSize(64, 32);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        P1 = new ModelRenderer(this, 0, 0);
        P1.addBox(0F, 0F, 0F, 2, 9, 2);
        P1.setPos(-8F, 11F, -8F);
        P1.setTexSize(64, 32);
        P1.mirror = true;
        setRotation(P1, 0F, 0F, 0F);
        P2 = new ModelRenderer(this, 0, 0);
        P2.addBox(0F, 0F, 0F, 2, 9, 2);
        P2.setPos(6F, 11F, -8F);
        P2.setTexSize(64, 32);
        P2.mirror = true;
        setRotation(P2, 0F, 0F, 0F);
        P3 = new ModelRenderer(this, 0, 0);
        P3.addBox(0F, 0F, 0F, 2, 9, 2);
        P3.setPos(6F, 11F, 6F);
        P3.setTexSize(64, 32);
        P3.mirror = true;
        setRotation(P3, 0F, 0F, 0F);
        P4 = new ModelRenderer(this, 0, 0);
        P4.addBox(0F, 0F, 0F, 2, 9, 2);
        P4.setPos(-8F, 11F, 6F);
        P4.setTexSize(64, 32);
        P4.mirror = true;
        setRotation(P4, 0F, 0F, 0F);
        S1 = new ModelRenderer(this, 22, 0);
        S1.addBox(0F, 0F, 0F, 4, 4, 4);
        S1.setPos(4F, 20F, 4F);
        S1.setTexSize(64, 32);
        S1.mirror = true;
        setRotation(S1, 0F, 0F, 0F);
        S2 = new ModelRenderer(this, 22, 0);
        S2.addBox(0F, 0F, 0F, 4, 4, 4);
        S2.setPos(-8F, 20F, 4F);
        S2.setTexSize(64, 32);
        S2.mirror = true;
        setRotation(S2, 0F, 0F, 0F);
        S3 = new ModelRenderer(this, 22, 0);
        S3.addBox(0F, 0F, 0F, 4, 4, 4);
        S3.setPos(-8F, 20F, -8F);
        S3.setTexSize(64, 32);
        S3.mirror = true;
        setRotation(S3, 0F, 0F, 0F);
        S4 = new ModelRenderer(this, 22, 0);
        S4.addBox(0F, 0F, 0F, 4, 4, 4);
        S4.setPos(4F, 20F, -8F);
        S4.setTexSize(64, 32);
        S4.mirror = true;
        setRotation(S4, 0F, 0F, 0F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        Base.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        P1.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        P2.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        P3.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        P4.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S1.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S2.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S3.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S4.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }
}