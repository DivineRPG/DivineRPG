package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelDeathcryx<T extends Entity> extends SegmentedModel<T> 
{
    //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Leg5;
    ModelRenderer Leg6;
    ModelRenderer Leg7;
    ModelRenderer Leg8;
    ModelRenderer Tail2;

    public ModelDeathcryx()
    {
        texWidth = 64;
        texHeight = 32;
        WolfHead = new ModelRenderer(this, 0, 0);
        WolfHead.addBox(-3F, -3F, -2F, 10, 9, 4);
        WolfHead.setPos(-3F, 11.5F, -7F);
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
        Mane.addBox(-4F, -3F, -3F, 8, 10, 7);
        Mane.setPos(-1F, 14F, -2F);
        Mane.setTexSize(64, 32);
        Mane.mirror = true;
        setRotation(Mane, ((float)Math.PI / 2F), 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 18);
        Leg1.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg1.setPos(-5.5F, 16F, 4F);
        Leg1.setTexSize(64, 32);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 18);
        Leg2.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg2.setPos(2.5F, 16F, 4F);
        Leg2.setTexSize(64, 32);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 18);
        Leg3.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg3.setPos(-6.5F, 16F, -7F);
        Leg3.setTexSize(64, 32);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 18);
        Leg4.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg4.setPos(3.5F, 16F, -7F);
        Leg4.setTexSize(64, 32);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Tail = new ModelRenderer(this, 22, 13);
        Tail.addBox(-1F, 0F, -1F, 4, 12, 4);
        Tail.setPos(1F, 15F, 7F);
        Tail.setTexSize(64, 32);
        Tail.mirror = true;
        setRotation(Tail, 1.130069F, 0F, 0F);
        Ear1 = new ModelRenderer(this, 16, 14);
        Ear1.addBox(-3F, -5F, 0F, 2, 4, 1);
        Ear1.setPos(-2F, 9.9F, -7F);
        Ear1.setTexSize(64, 32);
        Ear1.mirror = true;
        setRotation(Ear1, 0.3490659F, 0F, 0F);
        Ear2 = new ModelRenderer(this, 16, 14);
        Ear2.addBox(1F, -5F, 0F, 2, 4, 1);
        Ear2.setPos(0F, 9.9F, -7F);
        Ear2.setTexSize(64, 32);
        Ear2.mirror = true;
        setRotation(Ear2, 0.3490659F, 0F, 0F);
        Nose = new ModelRenderer(this, 0, 20);
        Nose.addBox(-2F, 0F, -5F, 6, 5, 4);
        Nose.setPos(-2F, 11.5F, -8F);
        Nose.setTexSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 52, 15);
        Shape1.addBox(-3F, -10F, 0F, 1, 10, 4);
        Shape1.setPos(0F, 11F, 4F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, -1.003822F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 52, 15);
        Shape2.addBox(-2F, 0F, 0F, 1, 13, 4);
        Shape2.setPos(-1F, 0F, 7F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, -0.6320364F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 52, 15);
        Shape3.addBox(-2F, 0F, 0F, 1, 13, 4);
        Shape3.setPos(-1F, -2F, -5.466667F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0.1115358F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 52, 15);
        Shape4.addBox(0F, 0F, 0F, 2, 13, 4);
        Shape4.setPos(-6F, -2F, -5.466667F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0.1115358F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 52, 15);
        Shape5.addBox(0F, 0F, 0F, 2, 13, 4);
        Shape5.setPos(-6F, 0F, 7F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, -0.6320364F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 52, 15);
        Shape6.addBox(-1F, -10F, 0F, 2, 10, 4);
        Shape6.setPos(-5F, 11F, 4F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, -1.003822F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 52, 15);
        Shape7.addBox(0F, 0F, 0F, 2, 13, 4);
        Shape7.setPos(2F, -2F, -5.466667F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0.1115358F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 52, 15);
        Shape8.addBox(0F, 0F, 0F, 2, 13, 4);
        Shape8.setPos(2F, 0F, 7F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, -0.6320364F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 52, 15);
        Shape9.addBox(-1F, -10F, 0F, 2, 10, 4);
        Shape9.setPos(3F, 11F, 4F);
        Shape9.setTexSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, -1.003822F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 52, 15);
        Shape10.addBox(1F, 0F, 0F, 1, 13, 4);
        Shape10.setPos(-1F, -2F, -5.466667F);
        Shape10.setTexSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, 0.1115358F, 0F, 0F);
        Shape11 = new ModelRenderer(this, 52, 15);
        Shape11.addBox(1F, 0F, 0F, 1, 13, 4);
        Shape11.setPos(-1F, 0F, 7F);
        Shape11.setTexSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, -0.6320364F, 0F, 0F);
        Shape12 = new ModelRenderer(this, 52, 15);
        Shape12.addBox(0F, -10F, 0F, 1, 10, 4);
        Shape12.setPos(0F, 11F, 4F);
        Shape12.setTexSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, -1.003822F, 0F, 0F);
        Leg5 = new ModelRenderer(this, 0, 18);
        Leg5.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg5.setPos(-6.5F, 16F, -2F);
        Leg5.setTexSize(64, 32);
        Leg5.mirror = true;
        setRotation(Leg5, 0F, 0F, 0F);
        Leg6 = new ModelRenderer(this, 0, 18);
        Leg6.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg6.setPos(-5.5F, 16F, 9F);
        Leg6.setTexSize(64, 32);
        Leg6.mirror = true;
        setRotation(Leg6, 0F, 0F, 0F);
        Leg7 = new ModelRenderer(this, 0, 18);
        Leg7.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg7.setPos(2.5F, 16F, 9F);
        Leg7.setTexSize(64, 32);
        Leg7.mirror = true;
        setRotation(Leg7, 0F, 0F, 0F);
        Leg8 = new ModelRenderer(this, 0, 18);
        Leg8.addBox(-1F, 0F, -1F, 3, 8, 3);
        Leg8.setPos(3.5F, 16F, -2F);
        Leg8.setTexSize(64, 32);
        Leg8.mirror = true;
        setRotation(Leg8, 0F, 0F, 0F);
        Tail2 = new ModelRenderer(this, 22, 13);
        Tail2.addBox(-1F, 0F, -1F, 4, 12, 4);
        Tail2.setPos(-5F, 15F, 7F);
        Tail2.setTexSize(64, 32);
        Tail2.mirror = true;
        setRotation(Tail2, 1.130069F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(WolfHead, Body, Mane, Leg1, Leg2, Leg3, Leg4, Tail, Ear1, Ear2, Nose, Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Shape8, Shape9, Shape10, Shape11, Shape12, Leg5, Leg6, Leg7, Leg8, Tail2);
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
        this.Leg5.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Leg6.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg7.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg8.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}
