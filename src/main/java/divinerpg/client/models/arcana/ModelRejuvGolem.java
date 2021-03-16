package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelRejuvGolem<T extends Entity> extends SegmentedModel<T> 
{
    //fields
	ModelRenderer head;
    ModelRenderer rightshoulder;
    ModelRenderer leftshoulder;
    ModelRenderer middle;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;

    public ModelRejuvGolem()
    {
    	texWidth = 128;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 4, 8, 8);
        head.setPos(2F, 7F, 0F);
        head.setTexSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        rightshoulder = new ModelRenderer(this, 73, 3);
        rightshoulder.addBox(-4F, -6F, -3F, 6, 5, 6);
        rightshoulder.setPos(-6F, 11F, 0F);
        rightshoulder.setTexSize(128, 32);
        rightshoulder.mirror = true;
        setRotation(rightshoulder, -0.6981317F, 0F, 0F);
        leftshoulder = new ModelRenderer(this, 73, 3);
        leftshoulder.addBox(-2F, -6F, -3F, 6, 5, 6);
        leftshoulder.setPos(6F, 11F, 0F);
        leftshoulder.setTexSize(128, 32);
        leftshoulder.mirror = true;
        setRotation(leftshoulder, -0.6981317F, 0F, 0F);
        middle = new ModelRenderer(this, 68, 18);
        middle.addBox(-4F, 0F, -2F, 8, 5, 8);
        middle.setPos(0F, 7F, -2F);
        middle.setTexSize(128, 32);
        middle.mirror = true;
        setRotation(middle, 0F, 0F, 0F);
        body = new ModelRenderer(this, 25, 10);
        body.addBox(-4F, 0F, -2F, 10, 12, 10);
        body.setPos(-1F, 12F, -3F);
        body.setTexSize(128, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-6F, 11F, 0F);
        rightarm.setTexSize(128, 32);
        rightarm.mirror = true;
        setRotation(rightarm, -0.6981317F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(6F, 11F, 0F);
        leftarm.setTexSize(128, 32);
        leftarm.mirror = true;
        setRotation(leftarm, -0.6981317F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, rightshoulder, leftshoulder, middle, body, rightarm, leftarm);
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
        this.rightarm.xRot = this.rightshoulder.xRot = MathHelper.cos(limbSwing)*limbSwingAmount*0.75f - 0.6981317F;
        this.leftarm.xRot = this.leftshoulder.xRot = MathHelper.cos(limbSwing + (float)Math.PI)*limbSwingAmount*0.75f - 0.6981317F;
	}
}

