package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelEnchantedArcher<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer rightarmext;
    ModelRenderer leftfoot;
    ModelRenderer bodymain;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body6;
    ModelRenderer body5;
    public ModelRenderer rightarm;
    ModelRenderer rightarmcap;
    ModelRenderer leftarm;
    ModelRenderer leftarmext;
    ModelRenderer leftarmcap;
    ModelRenderer leftleg;
    ModelRenderer leftlegcap;
    ModelRenderer rightfoot;
    ModelRenderer rightleg;
    ModelRenderer rightlegcap;
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
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;

    public ModelEnchantedArcher()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, -16F, -19F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 0, 22);
        body1.addBox(-4F, 0F, -2F, 8, 6, 4);
        body1.setPos(0F, -12F, -2F);
        body1.setTexSize(64, 32);
        body1.mirror = true;
        setRotation(body1, 0.2617994F, 0F, 0F);
        rightarmext = new ModelRenderer(this, 40, 10);
        rightarmext.addBox(-7F, -2F, -2F, 8, 4, 4);
        rightarmext.setPos(-5F, -16F, -6F);
        rightarmext.setTexSize(64, 32);
        rightarmext.mirror = true;
        setRotation(rightarmext, 0F, 0F, 0F);
        leftfoot = new ModelRenderer(this, 28, 15);
        leftfoot.addBox(-3F, 17F, -9F, 6, 5, 12);
        leftfoot.setPos(10F, 2F, 0F);
        leftfoot.setTexSize(64, 32);
        leftfoot.mirror = true;
        setRotation(leftfoot, 0F, 0F, 0F);
        bodymain = new ModelRenderer(this, 28, 10);
        bodymain.addBox(-4F, 0F, -2F, 14, 18, 4);
        bodymain.setPos(-3F, -6F, 0F);
        bodymain.setTexSize(64, 32);
        bodymain.mirror = true;
        setRotation(bodymain, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 0, 22);
        body2.addBox(-4F, 0F, -2F, 8, 6, 4);
        body2.setPos(0F, -21F, -14F);
        body2.setTexSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 1.308997F, 0F, 0F);
        body3 = new ModelRenderer(this, 16, 16);
        body3.addBox(-4F, 0F, -2F, 4, 3, 4);
        body3.setPos(2F, -21F, -16F);
        body3.setTexSize(64, 32);
        body3.mirror = true;
        setRotation(body3, 1.570796F, 0F, 0F);
        body4 = new ModelRenderer(this, 0, 22);
        body4.addBox(-4F, 0F, -2F, 4, 3, 4);
        body4.setPos(2F, -14F, -3F);
        body4.setTexSize(64, 32);
        body4.mirror = true;
        setRotation(body4, 0.5235988F, 0F, 0F);
        body6 = new ModelRenderer(this, 0, 22);
        body6.addBox(-4F, 0F, -2F, 8, 6, 4);
        body6.setPos(0F, -18F, -7F);
        body6.setTexSize(64, 32);
        body6.mirror = true;
        setRotation(body6, 0.7853982F, 0F, 0F);
        body5 = new ModelRenderer(this, 0, 22);
        body5.addBox(-4F, 0F, -2F, 4, 3, 4);
        body5.setPos(2F, -19F, -9F);
        body5.setTexSize(64, 32);
        body5.mirror = true;
        setRotation(body5, 1.047198F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 10);
        rightarm.addBox(-11F, -2F, -2F, 4, 18, 4);
        rightarm.setPos(-5F, -16F, -6F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        rightarmcap = new ModelRenderer(this, 40, 10);
        rightarmcap.addBox(-12F, -3F, -3F, 6, 6, 6);
        rightarmcap.setPos(-5F, -16F, -6F);
        rightarmcap.setTexSize(64, 32);
        rightarmcap.mirror = true;
        setRotation(rightarmcap, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 10);
        leftarm.addBox(7F, -2F, -2F, 4, 18, 4);
        leftarm.setPos(5F, -16F, -6F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        leftarmext = new ModelRenderer(this, 40, 10);
        leftarmext.addBox(-1F, -2F, -2F, 8, 4, 4);
        leftarmext.setPos(5F, -16F, -6F);
        leftarmext.setTexSize(64, 32);
        leftarmext.mirror = true;
        setRotation(leftarmext, 0F, 0F, 0F);
        leftarmcap = new ModelRenderer(this, 40, 10);
        leftarmcap.addBox(6F, -3F, -3F, 6, 6, 6);
        leftarmcap.setPos(5F, -16F, -6F);
        leftarmcap.setTexSize(64, 32);
        leftarmcap.mirror = true;
        setRotation(leftarmcap, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 37, 6);
        leftleg.addBox(-2F, 0F, -2F, 4, 22, 4);
        leftleg.setPos(10F, 2F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        leftlegcap = new ModelRenderer(this, 37, 6);
        leftlegcap.addBox(-3F, -2F, -3F, 6, 5, 6);
        leftlegcap.setPos(10F, 2F, 0F);
        leftlegcap.setTexSize(64, 32);
        leftlegcap.mirror = true;
        setRotation(leftlegcap, 0F, 0F, 0F);
        rightfoot = new ModelRenderer(this, 28, 15);
        rightfoot.addBox(-3F, 17F, -9F, 6, 5, 12);
        rightfoot.setPos(-10F, 2F, 0F);
        rightfoot.setTexSize(64, 32);
        rightfoot.mirror = true;
        setRotation(rightfoot, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 37, 6);
        rightleg.addBox(-2F, 0F, -2F, 4, 22, 4);
        rightleg.setPos(-10F, 2F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        rightlegcap = new ModelRenderer(this, 37, 6);
        rightlegcap.addBox(-3F, -2F, -3F, 6, 5, 6);
        rightlegcap.setPos(-10F, 2F, 0F);
        rightlegcap.setTexSize(64, 32);
        rightlegcap.mirror = true;
        setRotation(rightlegcap, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 35, 14);
        Shape1.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape1.setPos(-2F, -31F, -13F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 35, 14);
        Shape2.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape2.setPos(-2F, -29F, -11F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 35, 14);
        Shape3.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape3.setPos(-2F, -27F, -9F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 35, 14);
        Shape4.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape4.setPos(-2F, -8F, 8F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, -1.047198F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 35, 14);
        Shape5.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape5.setPos(-2F, -5F, 10F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, -1.308997F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 35, 14);
        Shape6.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape6.setPos(-2F, -24F, -2F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, -0.2617994F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 35, 14);
        Shape7.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape7.setPos(-2F, -25F, -4F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, -0.2617994F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 35, 14);
        Shape8.addBox(1F, 0F, 0F, 2, 9, 1);
        Shape8.setPos(-2F, -20F, 3F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, -0.5235988F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 35, 14);
        Shape9.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape9.setPos(-2F, -12F, 7F);
        Shape9.setTexSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, -0.7853982F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 35, 14);
        Shape10.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape10.setPos(-2F, -15F, 6F);
        Shape10.setTexSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, -0.7853982F, 0F, 0F);
        Shape11 = new ModelRenderer(this, 35, 14);
        Shape11.addBox(0F, 0F, 0F, 2, 9, 1);
        Shape11.setPos(-1F, -18F, 5F);
        Shape11.setTexSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, -0.7853982F, 0F, 0F);
        Shape12 = new ModelRenderer(this, 35, 14);
        Shape12.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape12.setPos(-2F, 10F, 10F);
        Shape12.setTexSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, -1.570796F, 0F, 0F);
        Shape13 = new ModelRenderer(this, 35, 14);
        Shape13.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape13.setPos(-2F, 8F, 10F);
        Shape13.setTexSize(64, 32);
        Shape13.mirror = true;
        setRotation(Shape13, -1.570796F, 0F, 0F);
        Shape14 = new ModelRenderer(this, 35, 14);
        Shape14.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape14.setPos(-2F, 6F, 10F);
        Shape14.setTexSize(64, 32);
        Shape14.mirror = true;
        setRotation(Shape14, -1.570796F, 0F, 0F);
        Shape15 = new ModelRenderer(this, 35, 14);
        Shape15.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape15.setPos(-2F, 4F, 10F);
        Shape15.setTexSize(64, 32);
        Shape15.mirror = true;
        setRotation(Shape15, -1.570796F, 0F, 0F);
        Shape16 = new ModelRenderer(this, 35, 14);
        Shape16.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape16.setPos(-2F, 2F, 10F);
        Shape16.setTexSize(64, 32);
        Shape16.mirror = true;
        setRotation(Shape16, -1.570796F, 0F, 0F);
        Shape17 = new ModelRenderer(this, 35, 14);
        Shape17.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape17.setPos(-2F, 0F, 10F);
        Shape17.setTexSize(64, 32);
        Shape17.mirror = true;
        setRotation(Shape17, -1.570796F, 0F, 0F);
        Shape18 = new ModelRenderer(this, 35, 14);
        Shape18.addBox(0F, 0F, 0F, 4, 9, 1);
        Shape18.setPos(-2F, -2F, 10F);
        Shape18.setTexSize(64, 32);
        Shape18.mirror = true;
        setRotation(Shape18, -1.570796F, 0F, 0F);
        Shape19 = new ModelRenderer(this, 35, 14);
        Shape19.addBox(1F, 0F, 0F, 2, 9, 1);
        Shape19.setPos(-2F, -26F, -6F);
        Shape19.setTexSize(64, 32);
        Shape19.mirror = true;
        setRotation(Shape19, -0.2617994F, 0F, 0F);
        Shape20 = new ModelRenderer(this, 35, 14);
        Shape20.addBox(1F, 0F, 0F, 2, 9, 1);
        Shape20.setPos(-2F, -22F, 1F);
        Shape20.setTexSize(64, 32);
        Shape20.mirror = true;
        setRotation(Shape20, -0.5235988F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body1, rightarmext, leftfoot, bodymain, body2, body3, body4, body6, body5, rightarm, rightarmcap, leftarm, leftarmext, leftarmcap, leftleg, leftlegcap, rightfoot, rightleg, rightlegcap, Shape1, Shape2,
                Shape3, Shape4, Shape5, Shape6, Shape7, Shape8, Shape9, Shape10, Shape11, Shape12, Shape13, Shape14, Shape15, Shape16, Shape17, Shape18, Shape19, Shape20);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T ent, float var1, float var2, float var3, float var4, float var5)
    {
        this.head.yRot = var4 / (180F / (float)Math.PI);
        this.head.xRot = var5 / (180F / (float)Math.PI);

        this.rightarm.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.rightarmcap.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.rightarmext.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;

        this.leftarm.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmcap.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmext.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;

        this.rightarm.zRot = 0.0F;
        this.rightarmcap.zRot = 0.0F;
        this.rightarmext.zRot = 0.0F;

        this.leftarm.zRot = 0.0F;
        this.leftarmcap.zRot = 0.0F;
        this.leftarmext.zRot = 0.0F;

        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightlegcap.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightfoot.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

        this.leftleg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftlegcap.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftfoot.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;

        this.rightleg.yRot = 0.0F;
        this.rightlegcap.yRot = 0.0F;
        this.rightfoot.yRot = 0.0F;

        this.leftleg.yRot = 0.0F;
        this.leftlegcap.yRot = 0.0F;
        this.leftfoot.yRot = 0.0F;

        this.rightarm.yRot = 0.0F;
        this.rightarmcap.yRot = 0.0F;
        this.rightarmext.yRot = 0.0F;

        this.leftarm.yRot = 0.0F;
        this.leftarmcap.yRot = 0.0F;
        this.leftarmext.yRot = 0.0F;

        this.rightarm.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmcap.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmext.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;

        this.leftarm.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmcap.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmext.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;

        this.rightarm.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmcap.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmext.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;

        this.leftarm.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmcap.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmext.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }

}
