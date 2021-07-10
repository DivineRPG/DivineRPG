package divinerpg.client.models.block;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;

public class ModelArcaniumExtractor extends EntityModel {
    //fields
    ModelRenderer P2;
    ModelRenderer S1;
    ModelRenderer S2;
    ModelRenderer S3;
    ModelRenderer S4;
    ModelRenderer r1;
    ModelRenderer r2;
    ModelRenderer r3;
    ModelRenderer r4;
    ModelRenderer r5;
    ModelRenderer r6;
    ModelRenderer r7;
    ModelRenderer r8;
    ModelRenderer r9;
    ModelRenderer r10;
    ModelRenderer S7;
    ModelRenderer S6;
    ModelRenderer S5;
    ModelRenderer S8;
    ModelRenderer P4;
    ModelRenderer P3;

    public ModelArcaniumExtractor() {
        super();
        texWidth = 64;
        texHeight = 32;
        P2 = new ModelRenderer(this, 0, 16);
        P2.addBox(0F, 0F, 0F, 14, 2, 14);
        P2.setPos(-7F, 8F, -7F);
        P2.setTexSize(64, 32);
        P2.mirror = true;
        setRotation(P2, 0F, 0F, 0F);
        S1 = new ModelRenderer(this, 12, 0);
        S1.addBox(0F, 0F, 0F, 2, 8, 2);
        S1.setPos(3F, 10F, -5F);
        S1.setTexSize(64, 32);
        S1.mirror = true;
        setRotation(S1, 0F, 0F, 0F);
        S2 = new ModelRenderer(this, 12, 0);
        S2.addBox(0F, 0F, 0F, 2, 8, 2);
        S2.setPos(-5F, 10F, 3F);
        S2.setTexSize(64, 32);
        S2.mirror = true;
        setRotation(S2, 0F, 0F, 0F);
        S3 = new ModelRenderer(this, 12, 0);
        S3.addBox(0F, 0F, 0F, 2, 8, 2);
        S3.setPos(3F, 10F, 3F);
        S3.setTexSize(64, 32);
        S3.mirror = true;
        setRotation(S3, 0F, 0F, 0F);
        S4 = new ModelRenderer(this, 12, 0);
        S4.addBox(0F, 0F, 0F, 2, 8, 2);
        S4.setPos(-5F, 10F, -5F);
        S4.setTexSize(64, 32);
        S4.mirror = true;
        setRotation(S4, 0F, 0F, 0F);
        r1 = new ModelRenderer(this, 0, 0);
        r1.addBox(0F, 0F, 0F, 1, 4, 1);
        r1.setPos(1F, 20F, 0F);
        r1.setTexSize(64, 32);
        r1.mirror = true;
        setRotation(r1, 0F, 0F, 0F);
        r2 = new ModelRenderer(this, 0, 0);
        r2.addBox(0F, 0F, 0F, 1, 4, 1);
        r2.setPos(-3F, 20F, 4F);
        r2.setTexSize(64, 32);
        r2.mirror = true;
        setRotation(r2, 0F, 0F, 0F);
        r3 = new ModelRenderer(this, 0, 0);
        r3.addBox(0F, 0F, 0F, 1, 4, 1);
        r3.setPos(4F, 20F, -6F);
        r3.setTexSize(64, 32);
        r3.mirror = true;
        setRotation(r3, 0F, 0F, 0F);
        r4 = new ModelRenderer(this, 0, 0);
        r4.addBox(0F, 0F, 0F, 1, 4, 1);
        r4.setPos(-5F, 20F, -4F);
        r4.setTexSize(64, 32);
        r4.mirror = true;
        setRotation(r4, 0F, 0F, 0F);
        r5 = new ModelRenderer(this, 0, 0);
        r5.addBox(0F, 0F, 0F, 1, 2, 1);
        r5.setPos(4F, 20F, -1F);
        r5.setTexSize(64, 32);
        r5.mirror = true;
        setRotation(r5, 0F, 0F, 0F);
        r6 = new ModelRenderer(this, 0, 0);
        r6.addBox(0F, 0F, 0F, 1, 2, 1);
        r6.setPos(-5F, 20F, 2F);
        r6.setTexSize(64, 32);
        r6.mirror = true;
        setRotation(r6, 0F, 0F, 0F);
        r7 = new ModelRenderer(this, 0, 0);
        r7.addBox(0F, 0F, 0F, 1, 2, 1);
        r7.setPos(-1F, 20F, -5F);
        r7.setTexSize(64, 32);
        r7.mirror = true;
        setRotation(r7, 0F, 0F, 0F);
        r8 = new ModelRenderer(this, 0, 0);
        r8.addBox(0F, 0F, 0F, 1, 2, 1);
        r8.setPos(5F, 20F, 5F);
        r8.setTexSize(64, 32);
        r8.mirror = true;
        setRotation(r8, 0F, 0F, 0F);
        r9 = new ModelRenderer(this, 0, 0);
        r9.addBox(0F, 0F, 0F, 1, 2, 1);
        r9.setPos(2F, 20F, 3F);
        r9.setTexSize(64, 32);
        r9.mirror = true;
        setRotation(r9, 0F, 0F, 0F);
        r10 = new ModelRenderer(this, 0, 0);
        r10.addBox(0F, 0F, 0F, 1, 2, 1);
        r10.setPos(-3F, 20F, -2F);
        r10.setTexSize(64, 32);
        r10.mirror = true;
        setRotation(r10, 0F, 0F, 0F);
        S7 = new ModelRenderer(this, 12, 0);
        S7.addBox(0F, 0F, 0F, 2, 8, 2);
        S7.setPos(-4F, 0F, 2F);
        S7.setTexSize(64, 32);
        S7.mirror = true;
        setRotation(S7, 0F, 0F, 0F);
        S6 = new ModelRenderer(this, 12, 0);
        S6.addBox(0F, 0F, 0F, 2, 8, 2);
        S6.setPos(2F, 0F, 2F);
        S6.setTexSize(64, 32);
        S6.mirror = true;
        setRotation(S6, 0F, 0F, 0F);
        S5 = new ModelRenderer(this, 12, 0);
        S5.addBox(0F, 0F, 0F, 2, 8, 2);
        S5.setPos(2F, 0F, -4F);
        S5.setTexSize(64, 32);
        S5.mirror = true;
        setRotation(S5, 0F, 0F, 0F);
        S8 = new ModelRenderer(this, 12, 0);
        S8.addBox(0F, 0F, 0F, 2, 8, 2);
        S8.setPos(-4F, 0F, -4F);
        S8.setTexSize(64, 32);
        S8.mirror = true;
        setRotation(S8, 0F, 0F, 0F);
        P4 = new ModelRenderer(this, 0, 16);
        P4.addBox(0F, 0F, 0F, 14, 2, 14);
        P4.setPos(-7F, 18F, -7F);
        P4.setTexSize(64, 32);
        P4.mirror = true;
        setRotation(P4, 0F, 0F, 0F);
        P3 = new ModelRenderer(this, 0, 16);
        P3.addBox(0F, 0F, 0F, 14, 2, 14);
        P3.setPos(-7F, -1F, -7F);
        P3.setTexSize(64, 32);
        P3.mirror = true;
        setRotation(P3, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(Entity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        P2.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S1.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S2.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S3.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S4.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r1.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r2.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r3.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r4.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r5.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r6.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r7.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r8.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r9.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        r10.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S7.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S6.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S5.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        S8.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        P4.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        P3.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
