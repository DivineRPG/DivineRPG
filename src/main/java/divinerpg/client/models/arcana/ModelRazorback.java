package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelRazorback<T extends Entity> extends SegmentedModel<T> 
{
    //fields
	ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    ModelRenderer Spike4;
    ModelRenderer Spike5;
    ModelRenderer Spike6;
    ModelRenderer Spike7;
    ModelRenderer Spike8;
    ModelRenderer Spike9;
    ModelRenderer Spike10;

    public ModelRazorback()
    {
    	texWidth = 64;
        texHeight = 32;
        body = new ModelRenderer(this, 18, 4);
        body.addBox(0F, 0F, 0F, 8, 8, 3);
        body.setPos(-4F, 22F, -4F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, ((float)Math.PI / 2F), 0F, 0F);
        leg1 = new ModelRenderer(this, 0, 19);
        leg1.addBox(-2F, 0F, 0F, 1, 3, 1);
        leg1.setPos(-3F, 21F, 3F);
        leg1.setTexSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 19);
        leg2.addBox(0F, 0F, 0F, 1, 3, 1);
        leg2.setPos(4F, 21F, 3F);
        leg2.setTexSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 19);
        leg3.addBox(-2F, 0F, -1F, 1, 3, 1);
        leg3.setPos(-3F, 21F, -3F);
        leg3.setTexSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 19);
        leg4.addBox(0F, 0F, -1F, 1, 3, 1);
        leg4.setPos(4F, 21F, -3F);
        leg4.setTexSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        Spike1 = new ModelRenderer(this, 0, 25);
        Spike1.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike1.setPos(3F, 17F, 0F);
        Spike1.setTexSize(64, 32);
        Spike1.mirror = true;
        setRotation(Spike1, 0F, 0F, 0F);
        Spike2 = new ModelRenderer(this, 0, 25);
        Spike2.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike2.setPos(-3F, 17F, 0F);
        Spike2.setTexSize(64, 32);
        Spike2.mirror = true;
        setRotation(Spike2, 0F, 0F, 0F);
        Spike3 = new ModelRenderer(this, 0, 25);
        Spike3.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike3.setPos(-4F, 17F, -3F);
        Spike3.setTexSize(64, 32);
        Spike3.mirror = true;
        setRotation(Spike3, 0F, 0F, 0F);
        Spike4 = new ModelRenderer(this, 0, 25);
        Spike4.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike4.setPos(-4F, 17F, 2F);
        Spike4.setTexSize(64, 32);
        Spike4.mirror = true;
        setRotation(Spike4, 0F, 0F, 0F);
        Spike5 = new ModelRenderer(this, 0, 25);
        Spike5.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike5.setPos(2F, 17F, 2F);
        Spike5.setTexSize(64, 32);
        Spike5.mirror = true;
        setRotation(Spike5, 0F, 0F, 0F);
        Spike6 = new ModelRenderer(this, 0, 25);
        Spike6.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike6.setPos(2F, 17F, -2F);
        Spike6.setTexSize(64, 32);
        Spike6.mirror = true;
        setRotation(Spike6, 0F, 0F, 0F);
        Spike7 = new ModelRenderer(this, 0, 25);
        Spike7.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike7.setPos(0F, 17F, -3F);
        Spike7.setTexSize(64, 32);
        Spike7.mirror = true;
        setRotation(Spike7, 0F, 0F, 0F);
        Spike8 = new ModelRenderer(this, 0, 25);
        Spike8.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike8.setPos(-1F, 17F, -1F);
        Spike8.setTexSize(64, 32);
        Spike8.mirror = true;
        setRotation(Spike8, 0F, 0F, 0F);
        Spike9 = new ModelRenderer(this, 0, 25);
        Spike9.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike9.setPos(3F, 17F, -4F);
        Spike9.setTexSize(64, 32);
        Spike9.mirror = true;
        setRotation(Spike9, 0F, 0F, 0F);
        Spike10 = new ModelRenderer(this, 0, 25);
        Spike10.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike10.setPos(-1F, 17F, 3F);
        Spike10.setTexSize(64, 32);
        Spike10.mirror = true;
        setRotation(Spike10, 0F, 0F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(body, leg1, leg2, leg3, leg4, Spike1, Spike2, Spike3, Spike4, Spike5, Spike6, Spike7, Spike8, Spike9, Spike10);
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
		this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg4.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}
}

