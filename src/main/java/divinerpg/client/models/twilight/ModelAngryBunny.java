package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelAngryBunny<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Tail;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;

    public ModelAngryBunny() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4);
        this.Head.setPos(-1.0F, 13.5F, -7.0F);
        this.Head.setTexSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 18, 14);
        this.Body.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6);
        this.Body.setPos(0.0F, 14.0F, -3.0F);
        this.Body.setTexSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, ((float) Math.PI / 2F), 0.0F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 0, 18);
        this.Leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg1.setPos(-2.5F, 16.0F, 3.0F);
        this.Leg1.setTexSize(64, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 0, 18);
        this.Leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg2.setPos(0.5F, 16.0F, 3.0F);
        this.Leg2.setTexSize(64, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 18);
        this.Leg3.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg3.setPos(-2.5F, 16.0F, -4.0F);
        this.Leg3.setTexSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
        this.Leg4 = new ModelRenderer(this, 0, 18);
        this.Leg4.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg4.setPos(0.5F, 16.0F, -4.0F);
        this.Leg4.setTexSize(64, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
        this.Ear1 = new ModelRenderer(this, 16, 14);
        this.Ear1.addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1);
        this.Ear1.setPos(-1.0F, 13.5F, -7.0F);
        this.Ear1.setTexSize(64, 32);
        this.Ear1.mirror = true;
        this.setRotation(this.Ear1, 0.0F, 0.0F, 0.0F);
        this.Ear2 = new ModelRenderer(this, 16, 14);
        this.Ear2.addBox(1.0F, -5.0F, 0.0F, 2, 2, 1);
        this.Ear2.setPos(-1.0F, 13.5F, -7.0F);
        this.Ear2.setTexSize(64, 32);
        this.Ear2.mirror = true;
        this.setRotation(this.Ear2, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 6, 0);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
        this.Tail.setPos(-2.0F, 13.0F, 4.0F);
        this.Tail.setTexSize(64, 32);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
        this.Shape1 = new ModelRenderer(this, 50, 18);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape1.setPos(0.0F, 9.0F, 0.0F);
        this.Shape1.setTexSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.Shape2 = new ModelRenderer(this, 50, 18);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape2.setPos(-4.0F, 9.0F, 0.0F);
        this.Shape2.setTexSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
        this.Shape3 = new ModelRenderer(this, 50, 18);
        this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape3.setPos(0.0F, 9.0F, -4.0F);
        this.Shape3.setTexSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
        this.Shape4 = new ModelRenderer(this, 50, 18);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape4.setPos(-4.0F, 9.0F, -4.0F);
        this.Shape4.setTexSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.xRot = headPitch / (180F / (float) Math.PI);
        this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Ear1.xRot = headPitch / (180F / (float) Math.PI);
        this.Ear1.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Ear2.xRot = headPitch / (180F / (float) Math.PI);
        this.Ear2.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.Body.xRot = ((float) Math.PI / 2F);
        this.Leg1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.Leg3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.Leg4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Head, Body, Leg1, Leg2, Leg3, Leg4, Ear1, Ear2, Tail, Shape1, Shape2, Shape3, Shape4);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }

}
