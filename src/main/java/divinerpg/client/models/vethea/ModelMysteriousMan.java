package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.*;

public class ModelMysteriousMan<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer head;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body;
    ModelRenderer neck;
    ModelRenderer facemask1;
    ModelRenderer facemask2;
    ModelRenderer facemask3;
    ModelRenderer facemask4;

    public ModelMysteriousMan()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, -2F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-5F, 2F, 0F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(5F, 2F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-2F, 12F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(2F, 12F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        neck = new ModelRenderer(this, 20, 18);
        neck.addBox(-4F, 0F, -2F, 4, 2, 4);
        neck.setPos(2F, -2F, 0F);
        neck.setTexSize(64, 32);
        neck.mirror = true;
        setRotation(neck, 0F, 0F, 0F);
        facemask1 = new ModelRenderer(this, 37, 3);
        facemask1.addBox(-4F, 0F, -2F, 8, 2, 0);
        facemask1.setPos(0F, -2F, -2F);
        facemask1.setTexSize(64, 32);
        facemask1.mirror = true;
        setRotation(facemask1, 0F, 0F, 0F);
        facemask2 = new ModelRenderer(this, 37, 3);
        facemask2.addBox(-4F, 0F, -2F, 8, 2, 0);
        facemask2.setPos(0F, -2F, 6F);
        facemask2.setTexSize(64, 32);
        facemask2.mirror = true;
        setRotation(facemask2, 0F, 0F, 0F);
        facemask3 = new ModelRenderer(this, 37, 3);
        facemask3.addBox(4F, 0F, -2F, 0, 2, 8);
        facemask3.setPos(0F, -2F, -2F);
        facemask3.setTexSize(64, 32);
        facemask3.mirror = true;
        setRotation(facemask3, 0F, 0F, 0F);
        facemask4 = new ModelRenderer(this, 37, 3);
        facemask4.addBox(-4F, 0F, -2F, 0, 2, 8);
        facemask4.setPos(0F, -2F, -2F);
        facemask4.setTexSize(64, 32);
        facemask4.mirror = true;
        setRotation(facemask4, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, rightarm, leftarm, rightleg, leftleg, body, neck, facemask1, facemask2, facemask3, facemask4);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.leftleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.rightleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.rightarm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        this.leftarm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
    }
}