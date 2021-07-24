package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTheHunger<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarmm;
    ModelRenderer leftarmb;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer leftarmt;
    ModelRenderer leftarmm;
    ModelRenderer rightarmt;
    ModelRenderer rightarmb;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
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

    public ModelTheHunger()
    {
        texWidth = 56;
        texHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(56, 64);
        head.mirror = true;
        setRotation(head, -0.7853982F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(56, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarmm = new ModelRenderer(this, 40, 16);
        rightarmm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarmm.setPos(-5F, 7F, 0.5F);
        rightarmm.setTexSize(56, 64);
        rightarmm.mirror = true;
        setRotation(rightarmm, 0.1745329F, 0F, 1.570796F);
        leftarmb = new ModelRenderer(this, 40, 16);
        leftarmb.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarmb.setPos(3F, 9F, 0.5F);
        leftarmb.setTexSize(56, 64);
        leftarmb.mirror = true;
        setRotation(leftarmb, 0.1745329F, 0F, -0.9250245F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-2F, 12F, 0F);
        rightleg.setTexSize(56, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(2F, 12F, 0F);
        leftleg.setTexSize(56, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        leftarmt = new ModelRenderer(this, 40, 16);
        leftarmt.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarmt.setPos(5F, 3F, 0.5F);
        leftarmt.setTexSize(56, 64);
        leftarmt.mirror = true;
        setRotation(leftarmt, 0.1745329F, 0F, -2.042035F);
        leftarmm = new ModelRenderer(this, 40, 16);
        leftarmm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarmm.setPos(5F, 7F, 0.5F);
        leftarmm.setTexSize(56, 64);
        leftarmm.mirror = true;
        setRotation(leftarmm, 0.1745329F, 0F, -1.570796F);
        rightarmt = new ModelRenderer(this, 40, 16);
        rightarmt.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarmt.setPos(-5F, 3F, 0.5F);
        rightarmt.setTexSize(56, 64);
        rightarmt.mirror = true;
        setRotation(rightarmt, 0.1745329F, 0F, 2.042035F);
        rightarmb = new ModelRenderer(this, 40, 16);
        rightarmb.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarmb.setPos(-3F, 9F, 0.5F);
        rightarmb.setTexSize(56, 64);
        rightarmb.mirror = true;
        setRotation(rightarmb, 0.1745329F, 0F, 0.9250245F);
        Shape1 = new ModelRenderer(this, 0, 32);
        Shape1.addBox(0F, 0F, -9F, 8, 2, 9);
        Shape1.setPos(-4F, 2F, -1F);
        Shape1.setTexSize(56, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 32);
        Shape2.addBox(0F, 0F, -7F, 6, 1, 8);
        Shape2.setPos(-3F, 1F, -2F);
        Shape2.setTexSize(56, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 32);
        Shape3.addBox(0F, 0F, -9F, 8, 2, 9);
        Shape3.setPos(-4F, 8F, -1F);
        Shape3.setTexSize(56, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape3.mirror = false;
        Shape4 = new ModelRenderer(this, 0, 32);
        Shape4.addBox(0F, 0F, -7F, 6, 1, 8);
        Shape4.setPos(-3F, 10F, -2F);
        Shape4.setTexSize(56, 64);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape4.mirror = false;
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape5.setPos(2F, 3.4F, -9F);
        Shape5.setTexSize(56, 64);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 0, 0);
        Shape7.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape7.setPos(-0.5F, 3.4F, -9F);
        Shape7.setTexSize(56, 64);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape6.setPos(-3F, 3.4F, -9F);
        Shape6.setTexSize(56, 64);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 0, 0);
        Shape8.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape8.setPos(2F, 3.4F, -7F);
        Shape8.setTexSize(56, 64);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 0, 0);
        Shape9.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape9.setPos(2F, 3.4F, -5F);
        Shape9.setTexSize(56, 64);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 0, 0);
        Shape10.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape10.setPos(-3F, 3.4F, -7F);
        Shape10.setTexSize(56, 64);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, 0F, 0F);
        Shape11 = new ModelRenderer(this, 0, 0);
        Shape11.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape11.setPos(-3F, 3.4F, -5F);
        Shape11.setTexSize(56, 64);
        Shape11.mirror = true;
        setRotation(Shape11, 0F, 0F, 0F);
        Shape12 = new ModelRenderer(this, 0, 0);
        Shape12.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape12.setPos(-1.7F, 7.4F, -9F);
        Shape12.setTexSize(56, 64);
        Shape12.mirror = true;
        setRotation(Shape12, 0F, 0F, 0F);
        Shape13 = new ModelRenderer(this, 0, 0);
        Shape13.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape13.setPos(2F, 7.4F, -6F);
        Shape13.setTexSize(56, 64);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, 0F);
        Shape14 = new ModelRenderer(this, 0, 0);
        Shape14.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape14.setPos(-3F, 7.4F, -6F);
        Shape14.setTexSize(56, 64);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 0F, 0F);
        Shape15 = new ModelRenderer(this, 0, 0);
        Shape15.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape15.setPos(0.7F, 7.4F, -9F);
        Shape15.setTexSize(56, 64);
        Shape15.mirror = true;
        setRotation(Shape15, 0F, 0F, 0F);
        Shape16 = new ModelRenderer(this, 0, 0);
        Shape16.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape16.setPos(2F, 7.4F, -8F);
        Shape16.setTexSize(56, 64);
        Shape16.mirror = true;
        setRotation(Shape16, 0F, 0F, 0F);
        Shape17 = new ModelRenderer(this, 0, 0);
        Shape17.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape17.setPos(-3F, 7.4F, -8F);
        Shape17.setTexSize(56, 64);
        Shape17.mirror = true;
        setRotation(Shape17, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, rightarmm, leftarmb, rightleg, leftleg, leftarmt, leftarmm, rightarmt, rightarmb, Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Shape8, Shape9, Shape10, Shape11, Shape12, Shape13, Shape14, Shape15, Shape16, Shape17);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}