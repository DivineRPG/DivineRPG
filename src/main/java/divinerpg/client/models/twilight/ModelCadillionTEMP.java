package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelCadillionTEMP<T extends Entity> extends SegmentedModel<T> {
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer head;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer Horn;

	public ModelCadillionTEMP() {
		this.texWidth = 64;
		this.texHeight = 32;

		this.body = new ModelRenderer(this, 18, 4);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 8, 18, 10);
		this.body.setPos(2.0F, 5.0F, 2.0F);
		this.body.setTexSize(64, 32);
		this.body.mirror = true;
		setRotation(this.body, 1.570796F, 0.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 16);
		this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leg1.setPos(-2.0F, 12.0F, 7.0F);
		this.leg1.setTexSize(64, 32);
		this.leg1.mirror = true;
		setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 16);
		this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leg2.setPos(2.0F, 12.0F, 7.0F);
		this.leg2.setTexSize(64, 32);
		this.leg2.mirror = true;
		setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.leg2.mirror = false;
		this.leg3 = new ModelRenderer(this, 0, 16);
		this.leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4);
		this.leg3.setPos(-2.0F, 12.0F, -5.0F);
		this.leg3.setTexSize(64, 32);
		this.leg3.mirror = true;
		setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 0, 16);
		this.leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4);
		this.leg4.setPos(2.0F, 12.0F, -5.0F);
		this.leg4.setTexSize(64, 32);
		this.leg4.mirror = true;
		setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -3.0F, -6.0F, 8, 8, 6);
		this.head.setPos(0.0F, 3.0F, -8.0F);
		this.head.setTexSize(64, 32);
		this.head.mirror = true;
		setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.horn1 = new ModelRenderer(this, 55, 0);
		this.horn1.addBox(-3.0F, -6.0F, -5.0F, 1, 3, 3);
		this.horn1.setPos(0.0F, 3.0F, -8.0F);
		this.horn1.setTexSize(64, 32);
		this.horn1.mirror = true;
		setRotation(this.horn1, 0.0F, 0.0F, 0.0F);
		this.horn2 = new ModelRenderer(this, 55, 0);
		this.horn2.addBox(2.0F, -6.0F, -5.0F, 1, 3, 3);
		this.horn2.setPos(0.0F, 3.0F, -8.0F);
		this.horn2.setTexSize(64, 32);
		this.horn2.mirror = true;
		setRotation(this.horn2, 0.0F, 0.0F, 0.0F);
		this.Horn = new ModelRenderer(this, 55, 5);
		this.Horn.addBox(-1.0F, 3.0F, 2.0F, 2, 8, 2);
		this.Horn.setPos(0.0F, 3.0F, -8.0F);
		this.Horn.setTexSize(64, 32);
		this.Horn.mirror = true;
		setRotation(this.Horn, -2.13777F, 0.0F, 0.0F);
	}


	private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
		var1.xRot = var2;
		var1.yRot = var3;
		var1.zRot = var4;
	}

	@Override
	public void setupAnim(T entityIn, float var1, float var2, float var3, float var4, float var5) {
		this.head.yRot = (var4 / 57.295776F);
		this.Horn.yRot = (var4 / 63.661976F);
		this.horn1.yRot = var4 / (180F / (float)Math.PI);
		this.horn2.yRot = var4 / (180F / (float)Math.PI);
		this.body.xRot = 1.570796F;
		this.leg1.xRot = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2);
		this.leg2.xRot = (MathHelper.cos(var1 * 0.6662F + 3.141593F) * 1.4F * var2);
		this.leg3.xRot = (MathHelper.cos(var1 * 0.6662F + 3.141593F) * 1.4F * var2);
		this.leg4.xRot = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2);
	}

	@Override
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(body, leg1, leg2, leg3, leg4, head, horn1, horn2, Horn);
	}

}
