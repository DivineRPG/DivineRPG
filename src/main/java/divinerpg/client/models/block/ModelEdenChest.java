package divinerpg.client.models.block;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;

public class ModelEdenChest extends Model {
    public ModelRenderer chestLid = (new ModelRenderer(this, 0, 0)).setTexSize(64, 64);
    public ModelRenderer chestBelow;
    public ModelRenderer chestKnobLeft;
    public ModelRenderer chestKnobMiddle;
    public ModelRenderer chestKnobRight;

    public ModelEdenChest() {
        super(RenderType::entityCutoutNoCull);
        this.chestLid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.chestLid.xRot = 1.0F;
        this.chestLid.yRot = 7.0F;
        this.chestLid.zRot = 15.0F;
        this.chestKnobLeft = (new ModelRenderer(this, 0, 0)).setTexSize(64, 64);
        this.chestKnobLeft.addBox(-5.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobLeft.xRot = 8.0F;
        this.chestKnobLeft.yRot = 7.0F;
        this.chestKnobLeft.zRot = 15.0F;
        this.chestKnobMiddle = (new ModelRenderer(this, 0, 0)).setTexSize(64, 64);
        this.chestKnobMiddle.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobMiddle.xRot = 8.0F;
        this.chestKnobMiddle.yRot = 7.0F;
        this.chestKnobMiddle.zRot = 15.0F;
        this.chestKnobRight = (new ModelRenderer(this, 0, 0)).setTexSize(64, 64);
        this.chestKnobRight.addBox(3.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobRight.xRot = 8.0F;
        this.chestKnobRight.yRot = 7.0F;
        this.chestKnobRight.zRot = 15.0F;
        this.chestBelow = (new ModelRenderer(this, 0, 19)).setTexSize(64, 64);
        this.chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        this.chestBelow.xRot = 1.0F;
        this.chestBelow.yRot = 6.0F;
        this.chestBelow.zRot = 1.0F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.chestKnobRight.xRot = this.chestKnobMiddle.xRot = this.chestKnobLeft.xRot = this.chestLid.xRot;
        this.chestLid.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestKnobLeft.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestKnobMiddle.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestKnobRight.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestBelow.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }
}