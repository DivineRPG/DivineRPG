package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelLeorna<T extends Entity> extends SegmentedModel<T> 
{
    //fields
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer a;
    ModelRenderer Bar1;
    ModelRenderer Bar2;
    ModelRenderer Bar3;
    ModelRenderer Bar4;
    ModelRenderer Box;

    public ModelLeorna()
    {
    	texWidth = 64;
        texHeight = 32;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, -2F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 13);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 13);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-5F, 2F, 0F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 13);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(5F, 2F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 13);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-2F, 12F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 13);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(2F, 12F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        a = new ModelRenderer(this, 0, 0);
        a.addBox(0F, 0F, 0F, 1, 1, 1);
        a.setPos(0F, 0F, 0F);
        a.setTexSize(64, 32);
        a.mirror = true;
        setRotation(a, 0F, 0F, 0F);
        Bar1 = new ModelRenderer(this, 0, 29);
        Bar1.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar1.setPos(-12F, 9F, 3F);
        Bar1.setTexSize(64, 32);
        Bar1.mirror = true;
        setRotation(Bar1, 0F, 0F, 0F);
        Bar2 = new ModelRenderer(this, 0, 29);
        Bar2.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar2.setPos(-12F, 0F, 3F);
        Bar2.setTexSize(64, 32);
        Bar2.mirror = true;
        setRotation(Bar2, 0F, 0F, 0F);
        Bar3 = new ModelRenderer(this, 0, 29);
        Bar3.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar3.setPos(-12F, 3F, 3F);
        Bar3.setTexSize(64, 32);
        Bar3.mirror = true;
        setRotation(Bar3, 0F, 0F, 0F);
        Bar4 = new ModelRenderer(this, 0, 29);
        Bar4.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar4.setPos(-12F, 6F, 3F);
        Bar4.setTexSize(64, 32);
        Bar4.mirror = true;
        setRotation(Bar4, 0F, 0F, 0F);
        Box = new ModelRenderer(this, 33, 0);
        Box.addBox(0F, 0F, 0F, 4, 12, 3);
        Box.setPos(-2F, -1F, 2F);
        Box.setTexSize(64, 32);
        Box.mirror = true;
        setRotation(Box, 0F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, rightarm, leftarm, rightleg, leftleg, a, Bar1, Bar2, Bar3, Bar4, Box);
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
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.rightarm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;

        if (this.riding)
        {
            this.rightarm.xRot += -((float)Math.PI / 5F);
            this.leftarm.xRot += -((float)Math.PI / 5F);
            this.rightleg.xRot = -((float)Math.PI * 2F / 5F);
            this.leftleg.xRot = -((float)Math.PI * 2F / 5F);
            this.rightleg.yRot = ((float)Math.PI / 10F);
            this.leftleg.yRot = -((float)Math.PI / 10F);
        }

        this.rightarm.yRot = 0.0F;
        this.leftarm.yRot = 0.0F;
        float var8;
        float var9;

        if (this.attackTime > -9990.0F)
        {
            var8 = this.attackTime;
            this.body.yRot = MathHelper.sin(MathHelper.sqrt(var8) * (float)Math.PI * 2.0F) * 0.2F;
            this.rightarm.zRot = MathHelper.sin(this.body.yRot) * 5.0F;
            this.rightarm.xRot = -MathHelper.cos(this.body.yRot) * 5.0F;
            this.leftarm.zRot = -MathHelper.sin(this.body.yRot) * 5.0F;
            this.leftarm.xRot = MathHelper.cos(this.body.yRot) * 5.0F;
            this.rightarm.yRot += this.body.yRot;
            this.leftarm.yRot += this.body.yRot;
            this.leftarm.xRot += this.body.yRot;
            var8 = 1.0F - this.attackTime;
            var8 *= var8;
            var8 *= var8;
            var8 = 1.0F - var8;
            var9 = MathHelper.sin(var8 * (float)Math.PI);
            float var10 = MathHelper.sin(this.attackTime * (float)Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
            this.rightarm.xRot = (float)((double)this.rightarm.xRot - ((double)var9 * 1.2D + (double)var10));
            this.rightarm.yRot += this.body.yRot * 2.0F;
            this.rightarm.zRot = MathHelper.sin(this.attackTime * (float)Math.PI) * -0.4F;
        }

        {
            this.body.xRot = 0.0F;
            this.rightleg.zRot = 0.1F;
            this.leftleg.zRot = 0.1F;
            this.rightleg.yRot = 12.0F;
            this.leftleg.yRot = 12.0F;
            this.head.yRot = 0.0F;
        }

        this.rightarm.zRot += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarm.zRot -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarm.xRot += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.xRot -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}

