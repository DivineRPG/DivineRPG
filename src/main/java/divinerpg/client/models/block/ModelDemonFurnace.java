package divinerpg.client.models.block;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;

public class ModelDemonFurnace extends Model {
    //fields
    ModelRenderer Box;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Arm4;
    ModelRenderer Arm5;
    ModelRenderer Arm6;

    public ModelDemonFurnace() {
        super(RenderType::entityCutoutNoCull);
        texWidth = 64;
        texHeight = 64;

        Box = new ModelRenderer(this, 0, 0);
        Box.addBox(0F, 0F, 0F, 16, 16, 16);
        Box.setPos(8F, 8F, -8F);
        Box.setTexSize(64, 64);
        Box.mirror = true;
        setRotation(Box, 0F, 0F, 3.141593F);
        Arm1 = new ModelRenderer(this, 0, 32);
        Arm1.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm1.setPos(-7F, -7F, 3F);
        Arm1.setTexSize(64, 64);
        Arm1.mirror = true;
        setRotation(Arm1, 0F, 0F, 1.256637F);
        Arm2 = new ModelRenderer(this, 0, 32);
        Arm2.addBox(0F, 0F, 0F, 4, 16, 2);
        Arm2.setPos(-8F, 8F, 3F);
        Arm2.setTexSize(64, 64);
        Arm2.mirror = true;
        setRotation(Arm2, 0F, 0F, 0F);
        Arm3 = new ModelRenderer(this, 0, 32);
        Arm3.addBox(0F, 0F, 0F, 4, 16, 2);
        Arm3.setPos(4F, 8F, 3F);
        Arm3.setTexSize(64, 64);
        Arm3.mirror = true;
        setRotation(Arm3, 0F, 0F, 0F);
        Arm4 = new ModelRenderer(this, 0, 32);
        Arm4.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm4.setPos(-8F, -4F, 3F);
        Arm4.setTexSize(64, 64);
        Arm4.mirror = true;
        setRotation(Arm4, 0F, 0F, 0.6632251F);
        Arm5 = new ModelRenderer(this, 0, 32);
        Arm5.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm5.setPos(6F, -3F, 3F);
        Arm5.setTexSize(64, 64);
        Arm5.mirror = true;
        setRotation(Arm5, 0F, 0F, -1.256637F);
        Arm6 = new ModelRenderer(this, 0, 32);
        Arm6.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm6.setPos(4F, -3F, 3F);
        Arm6.setTexSize(64, 64);
        Arm6.mirror = true;
        setRotation(Arm6, 0F, 0F, -0.6632251F);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        Box.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        Arm1.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        Arm2.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        Arm3.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        Arm4.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        Arm5.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        Arm6.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
