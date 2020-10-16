package TeamDivineRPG.divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelEnderSpider<T extends Entity> extends SegmentedModel<T> {
    /**
     * The spider's head box
     */
    public ModelRenderer spiderHead;
    /**
     * The spider's neck box
     */
    public ModelRenderer spiderNeck;
    /**
     * The spider's body box
     */
    public ModelRenderer spiderBody;
    /**
     * Spider's first leg
     */
    public ModelRenderer spiderLeg1;
    /**
     * Spider's second leg
     */
    public ModelRenderer spiderLeg2;
    /**
     * Spider's third leg
     */
    public ModelRenderer spiderLeg3;
    /**
     * Spider's fourth leg
     */
    public ModelRenderer spiderLeg4;
    /**
     * Spider's fifth leg
     */
    public ModelRenderer spiderLeg5;
    /**
     * Spider's sixth leg
     */
    public ModelRenderer spiderLeg6;
    /**
     * Spider's seventh leg
     */
    public ModelRenderer spiderLeg7;
    /**
     * Spider's eight leg
     */
    public ModelRenderer spiderLeg8;

    public ModelEnderSpider() {
        float f = 0.0F;
        int i = 15;
        this.spiderHead = new ModelRenderer(this, 32, 4);
        this.spiderHead.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.spiderHead.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.spiderNeck = new ModelRenderer(this, 0, 0);
        this.spiderNeck.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.spiderNeck.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.spiderBody = new ModelRenderer(this, 0, 12);
        this.spiderBody.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12, 0.0F);
        this.spiderBody.setRotationPoint(0.0F, 15.0F, 9.0F);
        this.spiderLeg1 = new ModelRenderer(this, 18, 0);
        this.spiderLeg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        this.spiderLeg2 = new ModelRenderer(this, 18, 0);
        this.spiderLeg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg2.setRotationPoint(4.0F, 15.0F, 2.0F);
        this.spiderLeg3 = new ModelRenderer(this, 18, 0);
        this.spiderLeg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        this.spiderLeg4 = new ModelRenderer(this, 18, 0);
        this.spiderLeg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg4.setRotationPoint(4.0F, 15.0F, 1.0F);
        this.spiderLeg5 = new ModelRenderer(this, 18, 0);
        this.spiderLeg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        this.spiderLeg6 = new ModelRenderer(this, 18, 0);
        this.spiderLeg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg6.setRotationPoint(4.0F, 15.0F, 0.0F);
        this.spiderLeg7 = new ModelRenderer(this, 18, 0);
        this.spiderLeg7.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
        this.spiderLeg8 = new ModelRenderer(this, 18, 0);
        this.spiderLeg8.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg8.setRotationPoint(4.0F, 15.0F, -1.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.spiderHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.spiderHead.rotateAngleX = headPitch * 0.017453292F;
        float f = ((float) Math.PI / 4F);
        this.spiderLeg1.rotateAngleZ = -((float) Math.PI / 4F);
        this.spiderLeg2.rotateAngleZ = ((float) Math.PI / 4F);
        this.spiderLeg3.rotateAngleZ = -0.58119464F;
        this.spiderLeg4.rotateAngleZ = 0.58119464F;
        this.spiderLeg5.rotateAngleZ = -0.58119464F;
        this.spiderLeg6.rotateAngleZ = 0.58119464F;
        this.spiderLeg7.rotateAngleZ = -((float) Math.PI / 4F);
        this.spiderLeg8.rotateAngleZ = ((float) Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        this.spiderLeg1.rotateAngleY = ((float) Math.PI / 4F);
        this.spiderLeg2.rotateAngleY = -((float) Math.PI / 4F);
        this.spiderLeg3.rotateAngleY = 0.3926991F;
        this.spiderLeg4.rotateAngleY = -0.3926991F;
        this.spiderLeg5.rotateAngleY = -0.3926991F;
        this.spiderLeg6.rotateAngleY = 0.3926991F;
        this.spiderLeg7.rotateAngleY = -((float) Math.PI / 4F);
        this.spiderLeg8.rotateAngleY = ((float) Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.spiderLeg1.rotateAngleY += f3;
        this.spiderLeg2.rotateAngleY += -f3;
        this.spiderLeg3.rotateAngleY += f4;
        this.spiderLeg4.rotateAngleY += -f4;
        this.spiderLeg5.rotateAngleY += f5;
        this.spiderLeg6.rotateAngleY += -f5;
        this.spiderLeg7.rotateAngleY += f6;
        this.spiderLeg8.rotateAngleY += -f6;
        this.spiderLeg1.rotateAngleZ += f7;
        this.spiderLeg2.rotateAngleZ += -f7;
        this.spiderLeg3.rotateAngleZ += f8;
        this.spiderLeg4.rotateAngleZ += -f8;
        this.spiderLeg5.rotateAngleZ += f9;
        this.spiderLeg6.rotateAngleZ += -f9;
        this.spiderLeg7.rotateAngleZ += f10;
        this.spiderLeg8.rotateAngleZ += -f10;
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(spiderHead, spiderNeck, spiderBody, spiderLeg1, spiderLeg2, spiderLeg3, spiderLeg4, spiderLeg5, spiderLeg6, spiderLeg7, spiderLeg8);
    }

}