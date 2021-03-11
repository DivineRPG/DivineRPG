package divinerpg.client.models.arcana;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

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
    	textureWidth = 64;
        textureHeight = 32;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, -2F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 13);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 13);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 13);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 13);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 13);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        a = new ModelRenderer(this, 0, 0);
        a.addBox(0F, 0F, 0F, 1, 1, 1);
        a.setRotationPoint(0F, 0F, 0F);
        a.setTextureSize(64, 32);
        a.mirror = true;
        setRotation(a, 0F, 0F, 0F);
        Bar1 = new ModelRenderer(this, 0, 29);
        Bar1.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar1.setRotationPoint(-12F, 9F, 3F);
        Bar1.setTextureSize(64, 32);
        Bar1.mirror = true;
        setRotation(Bar1, 0F, 0F, 0F);
        Bar2 = new ModelRenderer(this, 0, 29);
        Bar2.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar2.setRotationPoint(-12F, 0F, 3F);
        Bar2.setTextureSize(64, 32);
        Bar2.mirror = true;
        setRotation(Bar2, 0F, 0F, 0F);
        Bar3 = new ModelRenderer(this, 0, 29);
        Bar3.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar3.setRotationPoint(-12F, 3F, 3F);
        Bar3.setTextureSize(64, 32);
        Bar3.mirror = true;
        setRotation(Bar3, 0F, 0F, 0F);
        Bar4 = new ModelRenderer(this, 0, 29);
        Bar4.addBox(0F, 0F, 0F, 24, 2, 1);
        Bar4.setRotationPoint(-12F, 6F, 3F);
        Bar4.setTextureSize(64, 32);
        Bar4.mirror = true;
        setRotation(Bar4, 0F, 0F, 0F);
        Box = new ModelRenderer(this, 33, 0);
        Box.addBox(0F, 0F, 0F, 4, 12, 3);
        Box.setRotationPoint(-2F, -1F, 2F);
        Box.setTextureSize(64, 32);
        Box.mirror = true;
        setRotation(Box, 0F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(head, body, rightarm, leftarm, rightleg, leftleg, a, Bar1, Bar2, Bar3, Bar4, Box);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
        this.head.rotateAngleX = headPitch / (180F / (float)Math.PI);
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;

        if (this.isSitting)
        {
            this.rightarm.rotateAngleX += -((float)Math.PI / 5F);
            this.leftarm.rotateAngleX += -((float)Math.PI / 5F);
            this.rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.rightleg.rotateAngleY = ((float)Math.PI / 10F);
            this.leftleg.rotateAngleY = -((float)Math.PI / 10F);
        }

        this.rightarm.rotateAngleY = 0.0F;
        this.leftarm.rotateAngleY = 0.0F;
        float var8;
        float var9;

        if (this.swingProgress > -9990.0F)
        {
            var8 = this.swingProgress;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(var8) * (float)Math.PI * 2.0F) * 0.2F;
            this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.rightarm.rotateAngleY += this.body.rotateAngleY;
            this.leftarm.rotateAngleY += this.body.rotateAngleY;
            this.leftarm.rotateAngleX += this.body.rotateAngleY;
            var8 = 1.0F - this.swingProgress;
            var8 *= var8;
            var8 *= var8;
            var8 = 1.0F - var8;
            var9 = MathHelper.sin(var8 * (float)Math.PI);
            float var10 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
            this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
            this.rightarm.rotateAngleZ = MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
        }

        {
            this.body.rotateAngleX = 0.0F;
            this.rightleg.rotationPointZ = 0.1F;
            this.leftleg.rotationPointZ = 0.1F;
            this.rightleg.rotationPointY = 12.0F;
            this.leftleg.rotationPointY = 12.0F;
            this.head.rotationPointY = 0.0F;
        }

        this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}

