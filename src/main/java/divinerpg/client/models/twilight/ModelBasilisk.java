package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelBasilisk<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg5;
    ModelRenderer leg6;
    ModelRenderer Spine_1;
    ModelRenderer Spine_2;
    ModelRenderer Spine_3;
    ModelRenderer Spine_4;
    ModelRenderer Spine_5;

    public ModelBasilisk()
    {
        this.texWidth = 64;
        this.texHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-5.0F, -3.0F, -6.0F, 10, 6, 7);
        this.head.setPos(0.0F, 15.0F, -8.0F);
        this.head.setTexSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 32, 10);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 6);
        this.body.setPos(0.0F, 11.0F, 3.0F);
        this.body.setTexSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0F, -1.0F, -2.0F, 4, 6, 4);
        this.leg1.setPos(-3.0F, 19.0F, -5.0F);
        this.leg1.setTexSize(64, 32);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0F, -1.0F, -2.0F, 4, 6, 4);
        this.leg2.setPos(3.0F, 19.0F, -5.0F);
        this.leg2.setTexSize(64, 32);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0F, -1.0F, -2.0F, 4, 6, 4);
        this.leg3.setPos(-3.0F, 19.0F, 1.0F);
        this.leg3.setTexSize(64, 32);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0F, -1.0F, -2.0F, 4, 6, 4);
        this.leg4.setPos(3.0F, 19.0F, 1.0F);
        this.leg4.setTexSize(64, 32);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
        this.leg5 = new ModelRenderer(this, 0, 16);
        this.leg5.addBox(-2.0F, -1.0F, -2.0F, 4, 6, 4);
        this.leg5.setPos(-3.0F, 19.0F, 7.0F);
        this.leg5.setTexSize(64, 32);
        this.leg5.mirror = true;
        this.setRotation(this.leg5, 0.0F, 0.0F, 0.0F);
        this.leg6 = new ModelRenderer(this, 0, 16);
        this.leg6.addBox(-2.0F, -1.0F, -2.0F, 4, 6, 4);
        this.leg6.setPos(3.0F, 19.0F, 7.0F);
        this.leg6.setTexSize(64, 32);
        this.leg6.mirror = true;
        this.setRotation(this.leg6, 0.0F, 0.0F, 0.0F);
        this.Spine_1 = new ModelRenderer(this, 56, 0);
        this.Spine_1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
        this.Spine_1.setPos(0.0F, 11.0F, -5.0F);
        this.Spine_1.setTexSize(64, 32);
        this.Spine_1.mirror = true;
        this.setRotation(this.Spine_1, 0.0F, 0.0F, 0.0F);
        this.Spine_2 = new ModelRenderer(this, 56, 0);
        this.Spine_2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
        this.Spine_2.setPos(0.0F, 11.0F, -2.0F);
        this.Spine_2.setTexSize(64, 32);
        this.Spine_2.mirror = true;
        this.setRotation(this.Spine_2, 0.0F, 0.0F, 0.0F);
        this.Spine_3 = new ModelRenderer(this, 56, 0);
        this.Spine_3.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
        this.Spine_3.setPos(0.0F, 11.0F, 1.0F);
        this.Spine_3.setTexSize(64, 32);
        this.Spine_3.mirror = true;
        this.setRotation(this.Spine_3, 0.0F, 0.0F, 0.0F);
        this.Spine_4 = new ModelRenderer(this, 56, 0);
        this.Spine_4.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
        this.Spine_4.setPos(0.0F, 11.0F, 4.0F);
        this.Spine_4.setTexSize(64, 32);
        this.Spine_4.mirror = true;
        this.setRotation(this.Spine_4, 0.0F, 0.0F, 0.0F);
        this.Spine_5 = new ModelRenderer(this, 56, 0);
        this.Spine_5.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
        this.Spine_5.setPos(0.0F, 11.0F, 7.0F);
        this.Spine_5.setTexSize(64, 32);
        this.Spine_5.mirror = true;
        this.setRotation(this.Spine_5, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg5.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg6.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, leg1, leg2, leg3, leg4, leg5, leg6, Spine_1, Spine_2, Spine_3, Spine_4, Spine_5);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }

}
