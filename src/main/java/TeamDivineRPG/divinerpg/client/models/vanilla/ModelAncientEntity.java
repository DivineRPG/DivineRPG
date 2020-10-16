package TeamDivineRPG.divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelAncientEntity<T extends Entity> extends SegmentedModel<T> {
    // fields
    ModelRenderer head;
    ModelRenderer legr;
    ModelRenderer legl;
    ModelRenderer legL2B;
    ModelRenderer body2;
    ModelRenderer body;
    ModelRenderer legR2B;
    ModelRenderer legL2T;
    ModelRenderer legR2T;
    ModelRenderer legR2M;
    ModelRenderer legL2M;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer hornbottoml;
    ModelRenderer horntopl;
    ModelRenderer hornbottomr;
    ModelRenderer horntopr;

    public ModelAncientEntity() {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -4F, -6F, 8, 8, 6);
        head.setRotationPoint(0F, -13F, -19F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        legr = new ModelRenderer(this, 0, 16);
        legr.addBox(-3F, 0F, -2F, 4, 12, 4);
        legr.setRotationPoint(-7F, 12F, 4F);
        legr.setTextureSize(64, 32);
        legr.mirror = true;
        setRotation(legr, 0F, 0F, 0F);
        legl = new ModelRenderer(this, 0, 16);
        legl.addBox(-1F, 0F, -2F, 4, 12, 4);
        legl.setRotationPoint(7F, 12F, 4F);
        legl.setTextureSize(64, 32);
        legl.mirror = true;
        setRotation(legl, 0F, 0F, 0F);
        legL2B = new ModelRenderer(this, 0, 19);
        legL2B.addBox(-1F, 24F, -2F, 3, 9, 2);
        legL2B.setRotationPoint(7F, -9F, -16F);
        legL2B.setTextureSize(64, 32);
        legL2B.mirror = true;
        setRotation(legL2B, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 18, 4);
        body2.addBox(-6F, -10F, -7F, 12, 18, 10);
        body2.setRotationPoint(0F, -7.6F, -10.7F);
        body2.setTextureSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 0.7853982F, 0F, 0F);
        body = new ModelRenderer(this, 18, 4);
        body.addBox(-6F, -10F, -7F, 12, 18, 10);
        body.setRotationPoint(0F, 5F, 2F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0.7853982F, 0F, 0F);
        legR2B = new ModelRenderer(this, 0, 19);
        legR2B.addBox(-2F, 24F, -2F, 3, 9, 2);
        legR2B.setRotationPoint(-7F, -9F, -16F);
        legR2B.setTextureSize(64, 32);
        legR2B.mirror = true;
        setRotation(legR2B, 0F, 0F, 0F);
        legL2T = new ModelRenderer(this, 0, 14);
        legL2T.addBox(-1F, 0F, -4F, 6, 12, 6);
        legL2T.setRotationPoint(7F, -9F, -16F);
        legL2T.setTextureSize(64, 32);
        legL2T.mirror = true;
        setRotation(legL2T, 0F, 0F, 0F);
        legR2T = new ModelRenderer(this, 0, 14);
        legR2T.addBox(-5F, 0F, -4F, 6, 12, 6);
        legR2T.setRotationPoint(-7F, -9F, -16F);
        legR2T.setTextureSize(64, 32);
        legR2T.mirror = true;
        setRotation(legR2T, 0F, 0F, 0F);
        legR2M = new ModelRenderer(this, 0, 16);
        legR2M.addBox(-3F, 12F, -3F, 4, 12, 4);
        legR2M.setRotationPoint(-7F, -9F, -16F);
        legR2M.setTextureSize(64, 32);
        legR2M.mirror = true;
        setRotation(legR2M, 0F, 0F, 0F);
        legL2M = new ModelRenderer(this, 0, 16);
        legL2M.addBox(-1F, 12F, -3F, 4, 12, 4);
        legL2M.setRotationPoint(7F, -9F, -16F);
        legL2M.setTextureSize(64, 32);
        legL2M.mirror = true;
        setRotation(legL2M, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 34, 4);
        Shape1.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape1.setRotationPoint(-3F, 9F, 1F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 2.119181F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 34, 4);
        Shape2.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape2.setRotationPoint(-3F, 6F, -1F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 2.119181F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 34, 4);
        Shape3.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape3.setRotationPoint(-3F, 3F, -3F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 2.119181F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 34, 4);
        Shape4.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape4.setRotationPoint(-3F, 0F, -5F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 2.119181F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 34, 4);
        Shape5.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape5.setRotationPoint(-3F, -3F, -7F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 2.119181F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 34, 4);
        Shape6.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape6.setRotationPoint(-3F, -6F, -9F);
        Shape6.setTextureSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 2.119181F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 34, 4);
        Shape7.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape7.setRotationPoint(-3F, -9F, -11F);
        Shape7.setTextureSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 2.119181F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 34, 4);
        Shape8.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape8.setRotationPoint(-3F, -15F, -15F);
        Shape8.setTextureSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 2.119181F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 34, 4);
        Shape9.addBox(0F, 0F, 0F, 6, 11, 1);
        Shape9.setRotationPoint(-3F, -12F, -13F);
        Shape9.setTextureSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 2.119181F, 0F, 0F);
        hornbottoml = new ModelRenderer(this, 33, 17);
        hornbottoml.addBox(0F, 0F, -6F, 1, 1, 6);
        hornbottoml.setRotationPoint(4F, -19F, -20F);
        hornbottoml.setTextureSize(64, 32);
        hornbottoml.mirror = true;
        setRotation(hornbottoml, 0.9666439F, 0F, 0F);
        horntopl = new ModelRenderer(this, 33, 17);
        horntopl.addBox(0F, 0F, -12F, 1, 1, 12);
        horntopl.setRotationPoint(4F, -19F, -20F);
        horntopl.setTextureSize(64, 32);
        horntopl.mirror = true;
        setRotation(horntopl, 0F, 0F, 0F);
        hornbottomr = new ModelRenderer(this, 33, 17);
        hornbottomr.addBox(0F, 0F, -6F, 1, 1, 6);
        hornbottomr.setRotationPoint(-5F, -19F, -20F);
        hornbottomr.setTextureSize(64, 32);
        hornbottomr.mirror = true;
        setRotation(hornbottomr, 0.9666439F, 0F, 0F);
        horntopr = new ModelRenderer(this, 33, 17);
        horntopr.addBox(0F, 0F, -12F, 1, 1, 12);
        horntopr.setRotationPoint(-5F, -19F, -20F);
        horntopr.setTextureSize(64, 32);
        horntopr.mirror = true;
        setRotation(horntopr, 0F, 0F, 0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.legr.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legR2B.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legR2M.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legR2T.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.legl.rotateAngleX = MathHelper.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;
        this.legL2B.rotateAngleX = MathHelper.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;
        this.legL2M.rotateAngleX = MathHelper.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;
        this.legL2T.rotateAngleX = MathHelper.cos((float) (limbSwing * 0.6662F + Math.PI)) * 1.4F * limbSwingAmount;
    }

    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(
                head, legr, legl, legL2B, body2, body, legR2B, legL2T, legR2T, legR2M, legL2M, Shape1, Shape2, Shape3, Shape4, Shape5,
                Shape6, Shape7, Shape8, Shape9, hornbottoml, horntopl, hornbottomr, horntopr);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
