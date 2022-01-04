package divinerpg.client.models.twilight;

import com.google.common.collect.*;
import divinerpg.entities.eden.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelBunny<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer tail;
	private final ModelRenderer Leg1;
	private final ModelRenderer Leg2;
	private final ModelRenderer Leg3;
	private final ModelRenderer Leg4;

    public ModelBunny() {
        texWidth = 64;
        texHeight = 32;

        Head = new ModelRenderer(this);
		Head.setPos(0.0F, 15.0F, -6.0F);
		Head.texOffs(0, 0).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, true);
		Head.texOffs(16, 14).addBox(-3.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		Head.texOffs(16, 14).addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);

		Body = new ModelRenderer(this);
		Body.setPos(1.0F, 16.0F, -2.0F);
		setRotation(Body, 1.5708F, 0.0F, 0.0F);
		Body.texOffs(18, 14).addBox(-4.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F, true);

		tail = new ModelRenderer(this);
		tail.setPos(-1.0F, 7.0F, 1.0F);
		Body.addChild(tail);
		setRotation(tail, -1.5708F, 0.0F, 0.0F);
		tail.texOffs(6, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);

		Leg1 = new ModelRenderer(this);
		Leg1.setPos(2.0F, 19.0F, -2.0F);
		Leg1.texOffs(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);

		Leg2 = new ModelRenderer(this);
		Leg2.setPos(-2.0F, 19.0F, -2.0F);
		Leg2.texOffs(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);

		Leg3 = new ModelRenderer(this);
		Leg3.setPos(2.0F, 19.0F, 3.0F);
		Leg3.texOffs(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);

		Leg4 = new ModelRenderer(this);
		Leg4.setPos(-2.0F, 19.0F, 3.0F);
		Leg4.texOffs(0, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Head, Body, Leg1, Leg2, Leg3, Leg4);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T e, float f, float f1, float f2, float f3, float f4) {
        if ((e instanceof EntityBunny && ((EntityBunny) e).isOrderedToSit())) {
            Body.xRot = 0.95993f;
            Leg1.xRot = Leg2.xRot = -1.5708f;
            Leg3.xRot = Leg4.xRot = -0.2818f;
            Leg1.yRot = Leg2.yRot = 23;
            Leg1.zRot = Leg2.zRot = 2;
        } else {
            this.Body.xRot = ((float) Math.PI / 2F);
            this.Leg1.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
            this.Leg2.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
            this.Leg3.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
            this.Leg4.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        }
        this.Head.xRot = f4 / (180F / (float) Math.PI);
        this.Head.yRot = f3 / (180F / (float) Math.PI);
        this.tail.xRot = ((float) Math.PI / 2F);
    }
}
