package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelDeathHound<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Tail;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;
    ModelRenderer Tail2;
    ModelRenderer Leg4;
    ModelRenderer Leg5;

    public ModelDeathHound()
    {
        texWidth = 64;
        texHeight = 32;
        WolfHead = new ModelRenderer(this, 0, 0);
        WolfHead.addBox(-3F, -3F, -2F, 6, 6, 6);
        WolfHead.setPos(-1F, 13.5F, -10F);
        WolfHead.setTexSize(64, 32);
        WolfHead.mirror = true;
        setRotation(WolfHead, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 18, 14);
        Body.addBox(-4F, -2F, -3F, 6, 9, 6);
        Body.setPos(0F, 14F, 2F);
        Body.setTexSize(64, 32);
        Body.mirror = true;
        setRotation(Body, ((float)Math.PI / 2F), 0F, 0F);
        Mane = new ModelRenderer(this, 21, 0);
        Mane.addBox(-4F, -3F, -3F, 8, 9, 7);
        Mane.setPos(-1F, 14F, -3F);
        Mane.setTexSize(64, 32);
        Mane.mirror = true;
        setRotation(Mane, ((float)Math.PI / 2F), 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 18);
        Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg1.setPos(-2.5F, 16F, -1F);
        Leg1.setTexSize(64, 32);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 18);
        Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg2.setPos(0.5F, 16F, -1F);
        Leg2.setTexSize(64, 32);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 18);
        Leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg3.setPos(-1F, 16F, -7F);
        Leg3.setTexSize(64, 32);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Tail = new ModelRenderer(this, 9, 18);
        Tail.addBox(-1F, 0F, -1F, 2, 8, 2);
        Tail.setPos(-3F, 12F, 8F);
        Tail.setTexSize(64, 32);
        Tail.mirror = true;
        setRotation(Tail, 1.130069F, 0F, 0F);
        Ear1 = new ModelRenderer(this, 43, 16);
        Ear1.addBox(-3F, -5F, 0F, 2, 4, 1);
        Ear1.setPos(-1F, 11.5F, -7F);
        Ear1.setTexSize(64, 32);
        Ear1.mirror = true;
        setRotation(Ear1, 0F, 0F, 0F);
        Ear2 = new ModelRenderer(this, 43, 16);
        Ear2.addBox(1F, -5F, 0F, 2, 4, 1);
        Ear2.setPos(-1F, 11.5F, -7F);
        Ear2.setTexSize(64, 32);
        Ear2.mirror = true;
        setRotation(Ear2, 0F, 0F, 0F);
        Nose = new ModelRenderer(this, 0, 19);
        Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
        Nose.setPos(-0.5F, 13.5F, -11F);
        Nose.setTexSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        Tail2 = new ModelRenderer(this, 9, 18);
        Tail2.addBox(-1F, 0F, -1F, 2, 8, 2);
        Tail2.setPos(1F, 12F, 8F);
        Tail2.setTexSize(64, 32);
        Tail2.mirror = true;
        setRotation(Tail2, 1.130069F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 18);
        Leg4.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg4.setPos(0.5F, 16F, 7F);
        Leg4.setTexSize(64, 32);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Leg5 = new ModelRenderer(this, 0, 18);
        Leg5.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg5.setPos(-2.5F, 16F, 7F);
        Leg5.setTexSize(64, 32);
        Leg5.mirror = true;
        setRotation(Leg5, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(WolfHead, Body, Mane, Leg1, Leg2, Leg3, Tail, Ear1, Ear2, Nose, Tail2, Leg4, Leg5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch) {
        this.Leg1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
