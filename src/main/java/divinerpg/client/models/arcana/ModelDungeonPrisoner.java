package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelDungeonPrisoner<T extends Entity> extends SegmentedModel<T>
{
    //fields
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer headp2;
    ModelRenderer headp3;

    public ModelDungeonPrisoner()
    {
    	texWidth = 64;
        texHeight = 32;
        head = new ModelRenderer(this, 32, 0);
        head.addBox(-4F, -10F, -4F, 8, 10, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 5F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-5F, 7F, 0F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(5F, 7F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        rightleg.setPos(-2F, 17F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        leftleg.setPos(2F, 17F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        headp2 = new ModelRenderer(this, 0, 0);
        headp2.addBox(-5F, 0F, -4F, 10, 5, 8);
        headp2.setPos(0F, -10F, 0F);
        headp2.setTexSize(64, 32);
        headp2.mirror = true;
        setRotation(headp2, (float)Math.PI, 0F, 0F);
        headp3 = new ModelRenderer(this, 0, 0);
        headp3.addBox(-5F, -5F, -4F, 10, 5, 8);
        headp3.setPos(0F, 5F, 0F);
        headp3.setTexSize(64, 32);
        headp3.mirror = true;
        setRotation(headp3, 0F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, rightarm, leftarm, rightleg, leftleg, headp2, headp3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.headp2.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.headp2.xRot = headPitch / (180F / (float)Math.PI);
        this.headp3.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.headp3.xRot = headPitch / (180F / (float)Math.PI);
        this.rightarm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
        this.rightarm.yRot = 0.0F;
        this.leftarm.yRot = 0.0F;
        this.rightarm.zRot += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarm.zRot -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarm.xRot += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.xRot -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}

