package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelKobblin<T extends Entity> extends SegmentedModel<T> {
    // fields
    ModelRenderer Pad;
    ModelRenderer RArm1;
    ModelRenderer Neck;
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Tongue;
    ModelRenderer RArm2;
    ModelRenderer RLeg;
    ModelRenderer LArm2;
    ModelRenderer LArm1;
    ModelRenderer LLeg;

    public ModelKobblin() {
        texWidth = 64;
        texHeight = 32;

        Pad = new ModelRenderer(this, 0, 0);
        Pad.addBox(0F, 0F, 0F, 16, 3, 16);
        Pad.setPos(-8F, 5F, -8F);
        Pad.setTexSize(64, 32);
        Pad.mirror = true;
        setRotation(Pad, 0F, 0F, 0F);
        RArm1 = new ModelRenderer(this, 48, 19);
        RArm1.addBox(0F, 0F, 0F, 1, 4, 1);
        RArm1.setPos(-3.5F, 14F, 2.5F);
        RArm1.setTexSize(64, 32);
        RArm1.mirror = true;
        setRotation(RArm1, -0.7853982F, 0.3665191F, 0F);
        Neck = new ModelRenderer(this, 40, 23);
        Neck.addBox(0F, 0F, 0F, 2, 3, 2);
        Neck.setPos(-1F, 13F, -0.5F);
        Neck.setTexSize(64, 32);
        Neck.mirror = true;
        setRotation(Neck, 0.5235988F, 0F, 0F);
        Body = new ModelRenderer(this, 20, 19);
        Body.addBox(0F, 0F, 0F, 5, 6, 5);
        Body.setPos(-2.5F, 14F, 0.5F);
        Body.setTexSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 0, 19);
        Head.addBox(0F, 0F, 0F, 5, 5, 5);
        Head.setPos(-2.5F, 8F, -2.5F);
        Head.setTexSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Tongue = new ModelRenderer(this, 40, 19);
        Tongue.addBox(0F, 0F, 0F, 3, 3, 1);
        Tongue.setPos(-1.5F, 12F, -2.5F);
        Tongue.setTexSize(64, 32);
        Tongue.mirror = true;
        setRotation(Tongue, -0.7853982F, 0F, 0F);
        RArm2 = new ModelRenderer(this, 48, 24);
        RArm2.addBox(-1.5F, 2F, 2.5F, 1, 4, 1);
        RArm2.setPos(-3.5F, 14F, 2.5F);
        RArm2.setTexSize(64, 32);
        RArm2.mirror = true;
        setRotation(RArm2, -1.570796F, -0.3665191F, 0F);
        RArm2.mirror = false;
        RLeg = new ModelRenderer(this, 48, 19);
        RLeg.addBox(0F, 0F, 0F, 1, 4, 1);
        RLeg.setPos(-2F, 20F, 2.5F);
        RLeg.setTexSize(64, 32);
        RLeg.mirror = true;
        setRotation(RLeg, 0F, 0F, 0F);
        LArm2 = new ModelRenderer(this, 48, 24);
        LArm2.addBox(1.5F, 1.5F, 2.5F, 1, 4, 1);
        LArm2.setPos(2.5F, 14F, 2.5F);
        LArm2.setTexSize(64, 32);
        LArm2.mirror = true;
        setRotation(LArm2, -1.570796F, 0.3665191F, 0F);
        LArm1 = new ModelRenderer(this, 48, 19);
        LArm1.addBox(0F, 0F, 0F, 1, 4, 1);
        LArm1.setPos(2.5F, 14F, 2.5F);
        LArm1.setTexSize(64, 32);
        LArm1.mirror = true;
        setRotation(LArm1, -0.7853982F, -0.3665191F, 0F);
        LLeg = new ModelRenderer(this, 48, 19);
        LLeg.addBox(0F, 0F, 0F, 1, 4, 1);
        LLeg.setPos(1F, 20F, 2.5F);
        LLeg.setTexSize(64, 32);
        LLeg.mirror = true;
        setRotation(LLeg, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float ageInTicks, float netHeadYaw, float headPitch) {
        this.RArm1.xRot = -0.7853982F + (MathHelper.cos(f * 0.6662F) * 0.8F * f1);
        this.RArm2.xRot = -1.570796F + (MathHelper.cos(f * 0.6662F) * 0.8F * f1);
        this.LArm1.xRot = -0.7853982F + (MathHelper.cos(f * 0.6662F + (float) Math.PI) * 0.8F * f1);
        this.LArm2.xRot = -1.570796F + (MathHelper.cos(f * 0.6662F + (float) Math.PI) * 0.8F * f1);

        this.RLeg.xRot = (MathHelper.cos(f * 0.6662F) * f1);
        this.LLeg.xRot = (MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Pad, RArm1, Neck, Body, Head, Tongue, RArm2, RLeg, LArm2, LArm1, LLeg);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
