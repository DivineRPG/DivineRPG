package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelGreenfeet<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leftarmbox;
    ModelRenderer leftarm;
    ModelRenderer rightlegext;
    ModelRenderer leftlegext;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer rightarm;
    ModelRenderer rightarmbox;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;

    public ModelGreenfeet()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 2F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 25, 16);
        body.addBox(-7F, 0F, -2F, 14, 12, 4);
        body.setPos(0F, 0F, 2F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0.4461433F, 0F, 0F);
        leftarmbox = new ModelRenderer(this, 32, 0);
        leftarmbox.addBox(-2F, 10F, -3F, 6, 4, 6);
        leftarmbox.setPos(8F, 2F, 3F);
        leftarmbox.setTexSize(64, 32);
        leftarmbox.mirror = true;
        setRotation(leftarmbox, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(8F, 2F, 3F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightlegext = new ModelRenderer(this, 0, 16);
        rightlegext.addBox(-2F, 0F, -6F, 4, 3, 8);
        rightlegext.setPos(-4F, 9F, 4F);
        rightlegext.setTexSize(64, 32);
        rightlegext.mirror = true;
        setRotation(rightlegext, 0F, 0F, 0F);
        leftlegext = new ModelRenderer(this, 0, 16);
        leftlegext.addBox(-2F, 0F, -6F, 4, 3, 8);
        leftlegext.setPos(4F, 9F, 4F);
        leftlegext.setTexSize(64, 32);
        leftlegext.mirror = true;
        setRotation(leftlegext, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 3F, -6F, 4, 12, 4);
        leftleg.setPos(4F, 9F, 4F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 3F, -6F, 4, 12, 4);
        rightleg.setPos(-4F, 9F, 4F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-8F, 2F, 3F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        rightarmbox = new ModelRenderer(this, 32, 0);
        rightarmbox.addBox(-4F, 10F, -3F, 6, 4, 6);
        rightarmbox.setPos(-8F, 2F, 3F);
        rightarmbox.setTexSize(64, 32);
        rightarmbox.mirror = true;
        setRotation(rightarmbox, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 57, 0);
        Shape1.addBox(-5F, 0F, 0F, 2, 9, 1);
        Shape1.setPos(-1F, -3F, 10F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, -0.5948578F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 57, 0);
        Shape2.addBox(-5F, 0F, 0F, 2, 9, 1);
        Shape2.setPos(-1F, 0F, 12F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, -0.5948578F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 57, 0);
        Shape3.addBox(0F, 0F, 0F, 2, 9, 1);
        Shape3.setPos(-1F, -3F, 10F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, -0.5948578F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 57, 0);
        Shape4.addBox(0F, 0F, 0F, 2, 9, 1);
        Shape4.setPos(-1F, 0F, 12F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, -0.5948578F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 57, 0);
        Shape5.addBox(5F, 0F, 0F, 2, 9, 1);
        Shape5.setPos(-1F, -3F, 10F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, -0.5948578F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 57, 0);
        Shape6.addBox(5F, 0F, 0F, 2, 9, 1);
        Shape6.setPos(-1F, 0F, 12F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, -0.5948578F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, leftarmbox, leftarm, rightlegext, leftlegext, leftleg, rightleg, rightarm, rightarmbox, Shape1, Shape2, Shape3, Shape4, Shape5, Shape6);
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
        this.rightarmbox.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmbox.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.rightarmbox.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.leftarmbox.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightlegext.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.leftlegext.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.yRot = 0.0F;
        this.rightlegext.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
        this.leftlegext.yRot = 0.0F;

        this.rightarm.yRot = 0.0F;
        this.rightarmbox.yRot = 0.0F;
        this.leftarm.yRot = 0.0F;
        this.leftarmbox.yRot = 0.0F;

        this.rightarm.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmbox.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmbox.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;

        this.rightarm.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarm.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmbox.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmbox.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }

}
