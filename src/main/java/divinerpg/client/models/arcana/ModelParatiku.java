package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelParatiku<T extends Entity> extends SegmentedModel<T> 
{
    //fields
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer WingRT;
    ModelRenderer WingRB;
    ModelRenderer WingLB;
    ModelRenderer WingLT;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelParatiku()
    {
    	texWidth = 64;
        texHeight = 32;
        head = new ModelRenderer(this, 0, 7);
        head.addBox(-4F, -4F, -6F, 8, 8, 6);
        head.setPos(0F, 6F, -8F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 19, 0);
        body.addBox(-6F, -10F, -7F, 12, 22, 10);
        body.setPos(0F, 11F, 2F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0.8644027F, 0F, 0F);
        WingRT = new ModelRenderer(this, 0, 0);
        WingRT.addBox(-14F, 0F, -5F, 14, 1, 10);
        WingRT.setPos(-6F, 7F, 0F);
        WingRT.setTexSize(64, 32);
        WingRT.mirror = true;
        setRotation(WingRT, -0.7330383F, 0F, 0F);
        WingRB = new ModelRenderer(this, 0, 0);
        WingRB.addBox(-14F, 0F, -5F, 14, 1, 10);
        WingRB.setPos(-6F, 14F, 0F);
        WingRB.setTexSize(64, 32);
        WingRB.mirror = true;
        setRotation(WingRB, -0.7330383F, 0F, 0F);
        WingLB = new ModelRenderer(this, 0, 0);
        WingLB.addBox(0F, 0F, -5F, 14, 1, 10);
        WingLB.setPos(6F, 14F, 0F);
        WingLB.setTexSize(64, 32);
        WingLB.mirror = true;
        setRotation(WingLB, -0.7330383F, 0F, 0F);
        WingLT = new ModelRenderer(this, 0, 0);
        WingLT.addBox(0F, 0F, -5F, 14, 1, 10);
        WingLT.setPos(6F, 7F, 0F);
        WingLT.setTexSize(64, 32);
        WingLT.mirror = true;
        setRotation(WingLT, -0.7330383F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 13, 21);
        Shape1.addBox(0F, 0F, 0F, 2, 10, 1);
        Shape1.setPos(-1F, 4F, 10F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, -0.2602503F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 13, 21);
        Shape2.addBox(0F, 0F, 0F, 2, 10, 1);
        Shape2.setPos(-1F, -4F, 0F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, -0.2602503F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 13, 21);
        Shape3.addBox(0F, 0F, 0F, 2, 10, 1);
        Shape3.setPos(-1F, -1F, 5F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, -0.2602503F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, WingRT, WingRB, WingLB, WingLT, Shape1, Shape2, Shape3);
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
		//EntityParatiku var8 = (EntityParatiku)entity;

		 this.head.xRot = headPitch / (180F / (float)Math.PI);
		 this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
		 this.head.zRot = 0.0F;
		 this.body.xRot = ((float)Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
		 this.body.yRot = 0.0F;
		 this.WingRT.yRot = MathHelper.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
		 this.WingLT.yRot = -this.WingRT.yRot;
		 
		 this.WingRB.yRot = MathHelper.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
		 this.WingLB.yRot = -this.WingRB.yRot;
	}
}

