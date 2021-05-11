package divinerpg.client.models.block;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;

public class ModelPresentBox extends Model {
    public ModelRenderer lid, base, knob;

    public ModelPresentBox() {
        super(RenderType::entitySolid);
        this.texWidth = this.texHeight = 128;
        this.lid = (new ModelRenderer(this, 0, 0));
        this.lid.addBox(-1.0F, -8.0F, -33.0F, 32, 7, 32, 0.0F);
        this.lid.xRot = 1.0F;
        this.lid.yRot = 7.0F;
        this.lid.zRot = 33.0F;
        this.knob = (new ModelRenderer(this, 0, 0));
        this.knob.addBox(-2.0F, -4.0F, -30.0F, 4, 8, 2, 0.0F);
        this.knob.xRot = 8.0F;
        this.knob.yRot = 7.0F;
        this.knob.zRot = 15.0F;
        this.base = (new ModelRenderer(this, 0, 40));
        this.base.addBox(-1.0F, -1.0F, -1.0F, 32, 27, 32, 0.0F);
        this.base.xRot = 1.0F;
        this.base.yRot = 6.0F;
        this.base.zRot = 1.0F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        knob.xRot = lid.xRot;
        lid.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        knob.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        base.render(matrixStack, builder, light, overlay, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);

    }
}
