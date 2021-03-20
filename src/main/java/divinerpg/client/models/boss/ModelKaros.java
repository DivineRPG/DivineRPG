package divinerpg.client.models.boss;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelKaros<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer head1;
    ModelRenderer body1;
    ModelRenderer rightarm1;
    ModelRenderer leftarm1;
    ModelRenderer head2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer body7;
    ModelRenderer body8;
    ModelRenderer body9;
    ModelRenderer body10;
    ModelRenderer body11;
    ModelRenderer body12;
    ModelRenderer body13;
    ModelRenderer body14;
    ModelRenderer body15;
    ModelRenderer body16;
    ModelRenderer body17;
    ModelRenderer body18;
    ModelRenderer body19;
    ModelRenderer body20;
    ModelRenderer body21;
    ModelRenderer body22;
    ModelRenderer body23;

    public ModelKaros()
    {
        texWidth = 64;
        texHeight = 32;

        head1 = new ModelRenderer(this, 0, 0);
        head1.addBox(-4F, -8F, -4F, 8, 8, 8);
        head1.setPos(8F, -11F, 0F);
        head1.setTexSize(64, 32);
        head1.mirror = true;
        setRotation(head1, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 16, 16);
        body1.addBox(-4F, 0F, -2F, 8, 6, 4);
        body1.setPos(4F, -1F, 2F);
        body1.setTexSize(64, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        rightarm1 = new ModelRenderer(this, 40, 0);
        rightarm1.addBox(-4F, -4F, -3F, 6, 4, 6);
        rightarm1.setPos(-10F, 2F, 0F);
        rightarm1.setTexSize(64, 32);
        rightarm1.mirror = true;
        setRotation(rightarm1, 0F, 0F, 0F);
        leftarm1 = new ModelRenderer(this, 40, 0);
        leftarm1.addBox(-2F, -4F, -3F, 6, 4, 6);
        leftarm1.setPos(10F, 2F, 0F);
        leftarm1.setTexSize(64, 32);
        leftarm1.mirror = true;
        setRotation(leftarm1, 0F, 0F, 0F);
        head2 = new ModelRenderer(this, 0, 0);
        head2.addBox(-4F, -8F, -4F, 8, 8, 8);
        head2.setPos(-8F, -11F, 0F);
        head2.setTexSize(64, 32);
        head2.mirror = true;
        setRotation(head2, 0F, 0F, 0F);
        rightarm2 = new ModelRenderer(this, 40, 16);
        rightarm2.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm2.setPos(-10F, 2F, 0F);
        rightarm2.setTexSize(64, 32);
        rightarm2.mirror = true;
        setRotation(rightarm2, 0F, 0F, 0F);
        leftarm2 = new ModelRenderer(this, 40, 16);
        leftarm2.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm2.setPos(10F, 2F, 0F);
        leftarm2.setTexSize(64, 32);
        leftarm2.mirror = true;
        setRotation(leftarm2, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 16, 16);
        body2.addBox(-4F, 0F, -2F, 8, 6, 4);
        body2.setPos(0F, -7F, 2F);
        body2.setTexSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 16, 16);
        body3.addBox(-4F, 0F, -2F, 8, 6, 4);
        body3.setPos(-4F, -1F, 2F);
        body3.setTexSize(64, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        body4 = new ModelRenderer(this, 16, 16);
        body4.addBox(-4F, 0F, -2F, 8, 6, 4);
        body4.setPos(-4F, -1F, -2F);
        body4.setTexSize(64, 32);
        body4.mirror = true;
        setRotation(body4, 0F, 0F, 0F);
        body5 = new ModelRenderer(this, 16, 16);
        body5.addBox(-4F, 0F, -2F, 8, 6, 4);
        body5.setPos(4F, -1F, -2F);
        body5.setTexSize(64, 32);
        body5.mirror = true;
        setRotation(body5, 0F, 0F, 0F);
        body6 = new ModelRenderer(this, 16, 16);
        body6.addBox(1F, -2F, -3F, 4, 4, 4);
        body6.setPos(6F, -6F, 1F);
        body6.setTexSize(64, 32);
        body6.mirror = true;
        setRotation(body6, 0F, 0F, -0.6108652F);
        body7 = new ModelRenderer(this, 27, 0);
        body7.addBox(-4F, 0F, -2F, 1, 6, 1);
        body7.setPos(7F, 11F, 5F);
        body7.setTexSize(64, 32);
        body7.mirror = true;
        setRotation(body7, 0F, 0F, 0F);
        body8 = new ModelRenderer(this, 16, 16);
        body8.addBox(-4F, 0F, -2F, 8, 6, 4);
        body8.setPos(0F, 5F, 2F);
        body8.setTexSize(64, 32);
        body8.mirror = true;
        setRotation(body8, 0F, 0F, 0F);
        body9 = new ModelRenderer(this, 16, 16);
        body9.addBox(-4F, 0F, -2F, 8, 6, 4);
        body9.setPos(0F, 5F, -2F);
        body9.setTexSize(64, 32);
        body9.mirror = true;
        setRotation(body9, 0F, 0F, 0F);
        body10 = new ModelRenderer(this, 27, 0);
        body10.addBox(-4F, 0F, -2F, 1, 6, 1);
        body10.setPos(0F, 11F, -2F);
        body10.setTexSize(64, 32);
        body10.mirror = true;
        setRotation(body10, 0F, 0F, 0F);
        body11 = new ModelRenderer(this, 27, 0);
        body11.addBox(-4F, 0F, -2F, 1, 6, 1);
        body11.setPos(2F, 11F, 3F);
        body11.setTexSize(64, 32);
        body11.mirror = true;
        setRotation(body11, 0F, 0F, 0F);
        body12 = new ModelRenderer(this, 27, 0);
        body12.addBox(-4F, 0F, -2F, 1, 6, 1);
        body12.setPos(1F, 11F, 5F);
        body12.setTexSize(64, 32);
        body12.mirror = true;
        setRotation(body12, 0F, 0F, 0F);
        body13 = new ModelRenderer(this, 27, 0);
        body13.addBox(-4F, 0F, -2F, 1, 6, 1);
        body13.setPos(5F, 11F, 4F);
        body13.setTexSize(64, 32);
        body13.mirror = true;
        setRotation(body13, 0F, 0F, 0F);
        body14 = new ModelRenderer(this, 27, 0);
        body14.addBox(-4F, 0F, -2F, 1, 6, 1);
        body14.setPos(6F, 11F, 0F);
        body14.setTexSize(64, 32);
        body14.mirror = true;
        setRotation(body14, 0F, 0F, 0F);
        body15 = new ModelRenderer(this, 27, 0);
        body15.addBox(-4F, 0F, -2F, 1, 6, 1);
        body15.setPos(4F, 11F, 1F);
        body15.setTexSize(64, 32);
        body15.mirror = true;
        setRotation(body15, 0F, 0F, 0F);
        body16 = new ModelRenderer(this, 27, 0);
        body16.addBox(-4F, 0F, -2F, 1, 6, 1);
        body16.setPos(7F, 11F, -2F);
        body16.setTexSize(64, 32);
        body16.mirror = true;
        setRotation(body16, 0F, 0F, 0F);
        body17 = new ModelRenderer(this, 27, 0);
        body17.addBox(-4F, 0F, -2F, 1, 6, 1);
        body17.setPos(3F, 11F, -1F);
        body17.setTexSize(64, 32);
        body17.mirror = true;
        setRotation(body17, 0F, 0F, 0F);
        body18 = new ModelRenderer(this, 16, 16);
        body18.addBox(-4F, 0F, -2F, 8, 6, 4);
        body18.setPos(0F, -7F, -2F);
        body18.setTexSize(64, 32);
        body18.mirror = true;
        setRotation(body18, 0F, 0F, 0F);
        body19 = new ModelRenderer(this, 16, 16);
        body19.addBox(-5F, -2F, -3F, 4, 4, 4);
        body19.setPos(-5F, -6F, 1F);
        body19.setTexSize(64, 32);
        body19.mirror = true;
        setRotation(body19, 0F, 0F, 0.6108652F);
        body20 = new ModelRenderer(this, 16, 16);
        body20.addBox(-4F, -1F, -2F, 7, 2, 2);
        body20.setPos(6F, -6F, 1F);
        body20.setTexSize(64, 32);
        body20.mirror = true;
        setRotation(body20, 0F, 0F, -0.6108652F);
        body21 = new ModelRenderer(this, 32, 11);
        body21.addBox(-4F, -1F, -2F, 5, 2, 2);
        body21.setPos(9F, -11F, 1F);
        body21.setTexSize(64, 32);
        body21.mirror = true;
        setRotation(body21, 0F, 0F, -1.570796F);
        body22 = new ModelRenderer(this, 16, 16);
        body22.addBox(-4F, -1F, -2F, 7, 2, 2);
        body22.setPos(-5F, -6F, 1F);
        body22.setTexSize(64, 32);
        body22.mirror = true;
        setRotation(body22, 0F, 0F, 0.6108652F);
        body23 = new ModelRenderer(this, 32, 11);
        body23.addBox(-4F, -1F, -2F, 5, 2, 2);
        body23.setPos(-8F, -11F, 1F);
        body23.setTexSize(64, 32);
        body23.mirror = true;
        setRotation(body23, 0F, 0F, -1.570796F);
    }

    @Override
    public void setupAnim(T p_225597_1_, float f, float f1, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.rightarm1.xRot = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarm2.xRot = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;

        this.leftarm1.xRot = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarm2.xRot = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head1, body1, rightarm1, leftarm1, head2, rightarm2, leftarm2, body2, body3, body4, body5, body6, body7,
                body8, body9, body10, body11, body12, body13, body14, body15, body16, body17, body18, body19, body20, body21, body22, body23);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

}
