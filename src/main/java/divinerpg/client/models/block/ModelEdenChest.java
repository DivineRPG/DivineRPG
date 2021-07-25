package divinerpg.client.models.block;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;

public class ModelEdenChest extends Model {
    public ModelRenderer lid;
    public ModelRenderer storage;
    public ModelRenderer chestKnobLeft;
    public ModelRenderer chestKnobMiddle;
    public ModelRenderer chestKnobRight;

    public ModelEdenChest() {
        super(RenderType::entityCutoutNoCull);
        this.texWidth = 64;
        this.texHeight = 64;

        this.lid = new ModelRenderer(this, 0, 0);
        this.lid.setPos(1.0F, 7.0F, 15.0F);
        this.lid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.chestKnobLeft = new ModelRenderer(this, 0, 0);
        this.chestKnobLeft.setPos(4.0F, 7.0F, 15.0F);
        this.chestKnobLeft.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobMiddle = new ModelRenderer(this, 0, 0);
        this.chestKnobMiddle.setPos(8.0F, 7.0F, 15.0F);
        this.chestKnobMiddle.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobRight = new ModelRenderer(this, 0, 0);
        this.chestKnobRight.setPos(12.0F, 7.0F, 15.0F);
        this.chestKnobRight.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.storage = new ModelRenderer(this, 0, 19);
        this.storage.setPos(1.0F, 6.0F, 1.0F);
        this.storage.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        this.chestKnobRight.xRot = this.chestKnobMiddle.xRot = this.chestKnobLeft.xRot = this.lid.xRot;
        this.lid.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestKnobLeft.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestKnobMiddle.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.chestKnobRight.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        this.storage.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
    }
}