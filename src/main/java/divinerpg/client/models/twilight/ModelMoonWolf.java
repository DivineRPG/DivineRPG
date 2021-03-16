package divinerpg.client.models.twilight;

import com.google.common.collect.*;
import divinerpg.entities.wildwood.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelMoonWolf<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;
    ModelRenderer Ear4;
    ModelRenderer Ear3;
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public ModelMoonWolf() {
        texWidth = 64;
        texHeight = 32;

        WolfHead = new ModelRenderer(this, 0, 0);
        WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
        WolfHead.setPos(-1F, 13.5F, -7F);
        WolfHead.setTexSize(64, 32);
        WolfHead.mirror = true;
        setRotation(WolfHead, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 18, 14);
        Body.addBox(-4F, -3F, -3F, 6, 9, 6);
        Body.setPos(0F, 14F, 2F);
        Body.setTexSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 1.570796F, 0F, 0F);
        Mane = new ModelRenderer(this, 21, 0);
        Mane.addBox(-4F, -3F, -3F, 8, 6, 7);
        Mane.setPos(-1F, 14F, -3F);
        Mane.setTexSize(64, 32);
        Mane.mirror = true;
        setRotation(Mane, 1.570796F, 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 18);
        Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg1.setPos(-2.5F, 16F, 7F);
        Leg1.setTexSize(64, 32);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 18);
        Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg2.setPos(0.5F, 16F, 7F);
        Leg2.setTexSize(64, 32);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 18);
        Leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg3.setPos(-2.5F, 16F, -4F);
        Leg3.setTexSize(64, 32);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 18);
        Leg4.addBox(-1F, 0F, -1F, 2, 8, 2);
        Leg4.setPos(0.5F, 16F, -4F);
        Leg4.setTexSize(64, 32);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Ear1 = new ModelRenderer(this, 16, 14);
        Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
        Ear1.setPos(-1F, 13.5F, -7F);
        Ear1.setTexSize(64, 32);
        Ear1.mirror = true;
        setRotation(Ear1, 0F, 0F, 0F);
        Ear2 = new ModelRenderer(this, 16, 14);
        Ear2.addBox(1F, -5F, 0F, 2, 2, 1);
        Ear2.setPos(-1F, 13.5F, -7F);
        Ear2.setTexSize(64, 32);
        Ear2.mirror = true;
        setRotation(Ear2, 0F, 0F, 0F);
        Nose = new ModelRenderer(this, 0, 10);
        Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
        Nose.setPos(-0.5F, 13.5F, -7F);
        Nose.setTexSize(64, 32);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        Ear4 = new ModelRenderer(this, 16, 14);
        Ear4.addBox(0F, 0F, 0F, 2, 2, 1);
        Ear4.setPos(0F, 8F, -5F);
        Ear4.setTexSize(64, 32);
        Ear4.mirror = true;
        setRotation(Ear4, 0F, 0F, 0F);
        Ear3 = new ModelRenderer(this, 16, 14);
        Ear3.addBox(0F, 0F, 0F, 2, 2, 1);
        Ear3.setPos(-4F, 8F, -5F);
        Ear3.setTexSize(64, 32);
        Ear3.mirror = true;
        setRotation(Ear3, 0F, 0F, 0F);
        spike1 = new ModelRenderer(this, 37, 0);
        spike1.addBox(13F, 0F, -1F, 2, 6, 1);
        spike1.setPos(0F, 14F, 2F);
        spike1.setTexSize(64, 32);
        spike1.mirror = true;
        setRotation(spike1, 0.7853982F, 0F, 3 * (float) Math.PI / 2);
        spike2 = new ModelRenderer(this, 37, 0);
        spike2.addBox(8F, 0F, -1F, 2, 6, 1);
        spike2.setPos(0F, 14F, 2F);
        spike2.setTexSize(64, 32);
        spike2.mirror = true;
        setRotation(spike2, 0.7853982F, 0F, 3 * (float) Math.PI / 2);
        spike3 = new ModelRenderer(this, 37, 0);
        spike3.addBox(-15F, 0.5F, -1.5F, 2, 6, 1);
        spike3.setPos(-1F, 14F, 2F);
        spike3.setTexSize(64, 32);
        spike3.mirror = true;
        setRotation(spike3, 0.7853982F, 0F, (float) Math.PI / 2);
        spike4 = new ModelRenderer(this, 37, 0);
        spike4.addBox(-10F, 0.5F, -1.5F, 2, 6, 1);
        spike4.setPos(-1F, 14F, 2F);
        spike4.setTexSize(64, 32);
        spike4.mirror = true;
        setRotation(spike4, 0.7853982F, 0F, (float) Math.PI / 2);
        Shape1 = new ModelRenderer(this, 4, 0);
        Shape1.addBox(0F, 0F, 0F, 1, 1, 4);
        Shape1.setPos(1F, 11F, -12F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 4, 0);
        Shape2.addBox(0F, 0F, 0F, 1, 1, 4);
        Shape2.setPos(-4F, 11F, -12F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        this.Body.addChild(spike1);
        this.Body.addChild(spike2);
        this.Body.addChild(spike3);
        this.Body.addChild(spike4);
    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(WolfHead, Body, Mane, Leg1, Leg2, Leg3, Leg4, Ear1, Ear2, Nose, Ear4, Ear3, Shape1, Shape2);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }



    public void prepareMobModel(T entity, float var2, float var3, float var4) {
        EntityMoonWolf moonWolf = (EntityMoonWolf) entity;

        if (moonWolf.isInSittingPose()) {
            this.Mane.setPos(-1.0F, 16.0F, -3.0F);
            this.Mane.xRot = ((float) Math.PI * 2F / 5F);
            this.Mane.yRot = 0.0F;
            this.Body.setPos(0.0F, 18.0F, 0.0F);
            this.Body.xRot = ((float) Math.PI / 4F);

            this.Leg1.setPos(-2.5F, 22.0F, 2.0F);
            this.Leg1.xRot = ((float) Math.PI * 3F / 2F);
            this.Leg2.setPos(0.5F, 22.0F, 2.0F);
            this.Leg2.xRot = ((float) Math.PI * 3F / 2F);
            this.Leg3.xRot = 5.811947F;
            this.Leg3.setPos(-2.49F, 17.0F, -4.0F);
            this.Leg4.xRot = 5.811947F;
            this.Leg4.setPos(0.51F, 17.0F, -4.0F);
        } else {
            this.Body.setPos(0.0F, 14.0F, 2.0F);
            this.Body.xRot = ((float) Math.PI / 2F);

            this.Mane.setPos(-1.0F, 14.0F, -3.0F);
            this.Mane.xRot = this.Body.xRot;
            this.Leg1.setPos(-2.5F, 16.0F, 7.0F);
            this.Leg2.setPos(0.5F, 16.0F, 7.0F);
            this.Leg3.setPos(-2.5F, 16.0F, -4.0F);
            this.Leg4.setPos(0.5F, 16.0F, -4.0F);
            this.Leg1.xRot = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
            this.Leg2.xRot = MathHelper.cos(var2 * 0.6662F + (float) Math.PI) * 1.4F * var3;
            this.Leg3.xRot = MathHelper.cos(var2 * 0.6662F + (float) Math.PI) * 1.4F * var3;
            this.Leg4.xRot = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
        }

    }
    @Override
    public void setupAnim(T e, float var1, float var2, float var3, float var4, float var5) {
        this.WolfHead.xRot = var5 / (180F / (float) Math.PI);
        this.WolfHead.yRot = var4 / (180F / (float) Math.PI);
        this.Nose.xRot = var5 / (180F / (float) Math.PI);
        this.Nose.yRot = var4 / (180F / (float) Math.PI);
        this.Ear1.xRot = var5 / (180F / (float) Math.PI);
        this.Ear1.yRot = var4 / (180F / (float) Math.PI);
        this.Ear2.xRot = var5 / (180F / (float) Math.PI);
        this.Ear2.yRot = var4 / (180F / (float) Math.PI);
        this.Ear3.xRot = var5 / (180F / (float) Math.PI);
        this.Ear3.yRot = var4 / (180F / (float) Math.PI);
        this.Ear4.xRot = var5 / (180F / (float) Math.PI);
        this.Ear4.yRot = var4 / (180F / (float) Math.PI);
    }
}