package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHelio<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer leftarmp1;
    ModelRenderer rightlegt;
    ModelRenderer leftlegt;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer leftlegm;
    ModelRenderer rightlegm;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer leftarmp2;
    ModelRenderer leftarmp3;
    ModelRenderer leftarmp4;
    ModelRenderer leftarmp5;
    ModelRenderer leftarmp6;

    public ModelHelio()
    {
        texWidth = 256;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(256, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 76, 0);
        body1.addBox(-4F, 0F, -2F, 6, 10, 3);
        body1.setPos(7F, 0F, -1F);
        body1.setTexSize(256, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        leftarmp1 = new ModelRenderer(this, 226, 6);
        leftarmp1.addBox(-1F, -3F, -3F, 8, 6, 6);
        leftarmp1.setPos(10F, 2F, 0F);
        leftarmp1.setTexSize(256, 32);
        leftarmp1.mirror = true;
        setRotation(leftarmp1, 0F, 0F, 0F);
        rightlegt = new ModelRenderer(this, 199, 17);
        rightlegt.addBox(-3F, -2F, -3F, 6, 5, 6);
        rightlegt.setPos(-6F, 12F, 0F);
        rightlegt.setTexSize(256, 32);
        rightlegt.mirror = true;
        setRotation(rightlegt, 0F, 0F, 0F);
        leftlegt = new ModelRenderer(this, 199, 17);
        leftlegt.addBox(-3F, -2F, -3F, 6, 5, 6);
        leftlegt.setPos(6F, 12F, 0F);
        leftlegt.setTexSize(256, 32);
        leftlegt.mirror = true;
        setRotation(leftlegt, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 76, 0);
        body2.addBox(-4F, 0F, -2F, 6, 10, 3);
        body2.setPos(7F, 0F, 2F);
        body2.setTexSize(256, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 58, 0);
        body3.addBox(-4F, 0F, -2F, 6, 12, 3);
        body3.setPos(1F, -2F, -1F);
        body3.setTexSize(256, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        body4 = new ModelRenderer(this, 16, 16);
        body4.addBox(-4F, 0F, -2F, 6, 12, 3);
        body4.setPos(1F, -2F, 2F);
        body4.setTexSize(256, 32);
        body4.mirror = true;
        setRotation(body4, 0F, 0F, 0F);
        body5 = new ModelRenderer(this, 40, 0);
        body5.addBox(-4F, 0F, -2F, 6, 10, 3);
        body5.setPos(-5F, 0F, -1F);
        body5.setTexSize(256, 32);
        body5.mirror = true;
        setRotation(body5, 0F, 0F, 0F);
        body6 = new ModelRenderer(this, 40, 0);
        body6.addBox(-4F, 0F, -2F, 6, 10, 3);
        body6.setPos(-5F, 0F, 2F);
        body6.setTexSize(256, 32);
        body6.mirror = true;
        setRotation(body6, 0F, 0F, 0F);
        leftlegm = new ModelRenderer(this, 97, 0);
        leftlegm.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftlegm.setPos(6F, 12F, 0F);
        leftlegm.setTexSize(256, 32);
        leftlegm.mirror = true;
        setRotation(leftlegm, 0F, 0F, 0F);
        rightlegm = new ModelRenderer(this, 97, 0);
        rightlegm.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightlegm.setPos(-6F, 12F, 0F);
        rightlegm.setTexSize(256, 32);
        rightlegm.mirror = true;
        setRotation(rightlegm, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 97, 20);
        leftleg.addBox(-3F, 7F, -3F, 6, 5, 6);
        leftleg.setPos(6F, 12F, 0F);
        leftleg.setTexSize(256, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 97, 20);
        rightleg.addBox(-3F, 7F, -3F, 6, 5, 6);
        rightleg.setPos(-6F, 12F, 0F);
        rightleg.setTexSize(256, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftarmp2 = new ModelRenderer(this, 140, 11);
        leftarmp2.addBox(3F, 10F, 10F, 12, 9, 12);
        leftarmp2.setPos(10F, 2F, 0F);
        leftarmp2.setTexSize(256, 32);
        leftarmp2.mirror = true;
        setRotation(leftarmp2, -1.570796F, 0.6108652F, 0F);
        leftarmp3 = new ModelRenderer(this, 36, 16);
        leftarmp3.addBox(1F, -2F, -2F, 4, 12, 4);
        leftarmp3.setPos(10F, 2F, 0F);
        leftarmp3.setTexSize(256, 32);
        leftarmp3.mirror = true;
        setRotation(leftarmp3, 0F, 0F, 0F);
        leftarmp4 = new ModelRenderer(this, 69, 17);
        leftarmp4.addBox(0F, 6F, 0F, 6, 9, 6);
        leftarmp4.setPos(10F, 2F, 0F);
        leftarmp4.setTexSize(256, 32);
        leftarmp4.mirror = true;
        setRotation(leftarmp4, -0.5235988F, 0F, 0F);
        leftarmp5 = new ModelRenderer(this, 116, 1);
        leftarmp5.addBox(1F, 9F, 3F, 8, 9, 8);
        leftarmp5.setPos(10F, 2F, 0F);
        leftarmp5.setTexSize(256, 32);
        leftarmp5.mirror = true;
        setRotation(leftarmp5, -0.8726646F, 0.2974289F, 0F);
        leftarmp6 = new ModelRenderer(this, 193, 10);
        leftarmp6.addBox(0F, 9F, 9F, 10, 9, 10);
        leftarmp6.setPos(10F, 2F, 0F);
        leftarmp6.setTexSize(256, 32);
        leftarmp6.mirror = true;
        setRotation(leftarmp6, -1.396263F, 0.2974289F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body1, leftarmp1, rightlegt, leftlegt, body2, body3, body4, body5, body6, leftlegm, rightlegm, leftleg, rightleg, leftarmp2, leftarmp3, leftarmp4, leftarmp5, leftarmp6);
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