package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelWraith<T extends Entity> extends SegmentedModel<T> 
{
    //fields
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg3;
    ModelRenderer leg4;

    public ModelWraith()
    {
    	texWidth = 64;
        texHeight = 32;
        head = new ModelRenderer(this, 0, 0);
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
        leg3 = new ModelRenderer(this, 0, 16);
        leg3.addBox(-3F, 0F, -3F, 4, 11, 4);
        leg3.setPos(-3F, 13F, -5F);
        leg3.setTexSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, -1.308997F, 1.134464F, 0F);
        leg4 = new ModelRenderer(this, 0, 16);
        leg4.addBox(-1F, 0F, -3F, 4, 11, 4);
        leg4.setPos(3F, 13F, -5F);
        leg4.setTexSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, -1.308997F, -1.134464F, -0.0743572F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, leg3, leg4);
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
	      this.leg4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	      this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.leg4.yRot = 0.0F;
	      this.leg3.yRot = 0.0F;
	}
}
