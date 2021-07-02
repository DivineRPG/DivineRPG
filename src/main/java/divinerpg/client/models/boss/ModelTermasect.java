package divinerpg.client.models.boss;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTermasect<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer base3;
    ModelRenderer body;
    ModelRenderer headR;
    ModelRenderer headL;
    ModelRenderer neck;
    ModelRenderer headMid;
    ModelRenderer slab1;
    ModelRenderer slab2;
    ModelRenderer slab3;
    ModelRenderer slab4;
    ModelRenderer armRa;
    ModelRenderer armLa;
    ModelRenderer armRb;
    ModelRenderer armLb;
    ModelRenderer armRc;
    ModelRenderer armRc2;

    public ModelTermasect() {
        texWidth = 128;
        texHeight = 128;

        base1 = new ModelRenderer(this, 0, 0);
        base1.addBox(-3F, 0F, -3F, 6, 1, 6);
        base1.setPos(0F, 20F, 0F);
        base1.setTexSize(128, 128);
        base1.mirror = true;
        setRotation(base1, 0F, 0F, 0F);
        base2 = new ModelRenderer(this, 0, 7);
        base2.addBox(-5F, 0F, -5F, 10, 1, 10);
        base2.setPos(0F, 16F, 0F);
        base2.setTexSize(128, 128);
        base2.mirror = true;
        setRotation(base2, 0F, 0F, 0F);
        base3 = new ModelRenderer(this, 0, 18);
        base3.addBox(-7F, 0F, -7F, 14, 1, 14);
        base3.setPos(0F, 12F, 0F);
        base3.setTexSize(128, 128);
        base3.mirror = true;
        setRotation(base3, 0F, 0F, 0F);
        body = new ModelRenderer(this, 56, 0);
        body.addBox(-6F, 0F, -6F, 12, 24, 12);
        body.setPos(0F, -15F, 0F);
        body.setTexSize(128, 128);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        headR = new ModelRenderer(this, 0, 33);
        headR.addBox(-3F, -6F, -5F, 6, 6, 5);
        headR.setPos(-4F, -12F, -3F);
        headR.setTexSize(128, 128);
        headR.mirror = true;
        setRotation(headR, 0F, 0F, 0F);
        headL = new ModelRenderer(this, 0, 33);
        headL.addBox(-3F, -6F, -5F, 6, 6, 5);
        headL.setPos(4F, -12F, -3F);
        headL.setTexSize(128, 128);
        headL.mirror = true;
        setRotation(headL, 0F, 0F, 0F);
        neck = new ModelRenderer(this, 0, 44);
        neck.addBox(-1F, 0F, -1F, 2, 6, 2);
        neck.setPos(0F, -21F, 0F);
        neck.setTexSize(128, 128);
        neck.mirror = true;
        setRotation(neck, 0F, 0F, 0F);
        headMid = new ModelRenderer(this, 0, 33);
        headMid.addBox(-3F, -6F, -5F, 6, 6, 5);
        headMid.setPos(0F, -19F, 0F);
        headMid.setTexSize(128, 128);
        headMid.mirror = true;
        setRotation(headMid, 0F, 0F, 0F);
        slab1 = new ModelRenderer(this, 0, 52);
        slab1.addBox(-8F, 0F, -8F, 16, 2, 16);
        slab1.setPos(0F, 5F, 0F);
        slab1.setTexSize(128, 128);
        slab1.mirror = true;
        setRotation(slab1, 0F, 0F, 0F);
        slab2 = new ModelRenderer(this, 0, 52);
        slab2.addBox(-8F, 0F, -8F, 16, 2, 16);
        slab2.setPos(0F, 1F, 0F);
        slab2.setTexSize(128, 128);
        slab2.mirror = true;
        setRotation(slab2, 0F, 0F, 0F);
        slab3 = new ModelRenderer(this, 0, 52);
        slab3.addBox(-8F, 0F, -8F, 16, 2, 16);
        slab3.setPos(0F, -3F, 0F);
        slab3.setTexSize(128, 128);
        slab3.mirror = true;
        setRotation(slab3, 0F, 0F, 0F);
        slab4 = new ModelRenderer(this, 0, 52);
        slab4.addBox(-8F, 0F, -8F, 16, 2, 16);
        slab4.setPos(0F, -7F, 0F);
        slab4.setTexSize(128, 128);
        slab4.mirror = true;
        setRotation(slab4, 0F, 0F, 0F);
        armRa = new ModelRenderer(this, 0, 70);
        armRa.addBox(-2F, -0.5F, -2F, 4, 14, 4);
        armRa.setPos(-5F, -13F, 0F);
        armRa.setTexSize(128, 128);
        armRa.mirror = true;
        setRotation(armRa, 0F, 0F, 0.7853982F);
        armLa = new ModelRenderer(this, 0, 70);
        armLa.addBox(-2F, -0.5F, -2F, 4, 14, 4);
        armLa.setPos(5F, -13F, 0F);
        armLa.setTexSize(128, 128);
        armLa.mirror = true;
        setRotation(armLa, 0F, 0F, -0.7853982F);
        armRb = new ModelRenderer(this, 16, 70);
        armRb.addBox(-2F, 9.5F, -10F, 4, 4, 8);
        armRb.setPos(-5F, -13F, 0F);
        armRb.setTexSize(128, 128);
        armRb.mirror = true;
        setRotation(armRb, 0F, 0F, 0.7853982F);
        armLb = new ModelRenderer(this, 16, 70);
        armLb.addBox(-2F, 9.5F, -10F, 4, 4, 8);
        armLb.setPos(5F, -13F, 0F);
        armLb.setTexSize(128, 128);
        armLb.mirror = true;
        setRotation(armLb, 0F, 0F, -0.7853982F);
        armRc = new ModelRenderer(this, 40, 70);
        armRc.addBox(-1F, 10.5F, -16F, 2, 2, 6);
        armRc.setPos(-5F, -13F, 0F);
        armRc.setTexSize(128, 128);
        armRc.mirror = true;
        setRotation(armRc, 0F, 0F, 0.7853982F);
        armRc2 = new ModelRenderer(this, 40, 70);
        armRc2.addBox(-1F, 10.5F, -16F, 2, 2, 6);
        armRc2.setPos(5F, -13F, 0F);
        armRc2.setTexSize(128, 128);
        armRc2.mirror = true;
        setRotation(armRc2, 0F, 0F, -0.7853982F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                base1.yRot = limbSwing % 1F;
                base2.yRot = limbSwing % 2F;
                base3.yRot = limbSwing % 3F;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(base1, base2, base3, body, headR, headL, neck, headMid, slab1, slab2, slab3, slab4, armRa, armLa, armRb, armLb, armRc, armRc2);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
