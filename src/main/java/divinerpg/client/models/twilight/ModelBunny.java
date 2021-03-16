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
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer tail;

    public ModelBunny() {
        texWidth = 64;
        texHeight = 32;

        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-3F, -3F, -2F, 6, 6, 4);
        Head.setPos(-1F, 16.5F, -7F);
        Head.setTexSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 18, 14);
        Body.addBox(-4F, -2F, -3F, 6, 9, 6);
        Body.setPos(0F, 17F, -3F);
        Body.setTexSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 1.570796F, 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 18);
        Leg1.addBox(-1F, 0F, -1F, 2, 5, 2);
        Leg1.setPos(-2.5F, 19F, 3F);
        Leg1.setTexSize(64, 32);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 18);
        Leg2.addBox(-1F, 0F, -1F, 2, 5, 2);
        Leg2.setPos(0.5F, 19F, 3F);
        Leg2.setTexSize(64, 32);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 18);
        Leg3.addBox(-1F, 0F, -1F, 2, 5, 2);
        Leg3.setPos(-2.5F, 19F, -4F);
        Leg3.setTexSize(64, 32);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 18);
        Leg4.addBox(-1F, 0F, -1F, 2, 5, 2);
        Leg4.setPos(0.5F, 19F, -4F);
        Leg4.setTexSize(64, 32);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Ear1 = new ModelRenderer(this, 16, 14);
        Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
        Ear1.setPos(-1F, 16.5F, -7F);
        Ear1.setTexSize(64, 32);
        Ear1.mirror = true;
        setRotation(Ear1, 0F, 0F, 0F);
        Ear2 = new ModelRenderer(this, 16, 14);
        Ear2.addBox(1F, -5F, 0F, 2, 2, 1);
        Ear2.setPos(-1F, 16.5F, -7F);
        Ear2.setTexSize(64, 32);
        Ear2.mirror = true;
        setRotation(Ear2, 0F, 0F, 0F);
        tail = new ModelRenderer(this, 6, 0);
        tail.addBox(0F, -5F, 8F, 2, 2, 1);
        tail.setPos(-2F, 16F, 4F);
        tail.setTexSize(64, 32);
        tail.mirror = true;
        setRotation(tail, 0F, 0F, 0F);
        Body.addChild(tail);
    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Head, Body, Leg1, Leg2, Leg3, Leg4, Ear1, Ear2);
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
            Leg1.yRot = Leg2.yRot = 19;
            Leg1.zRot = Leg2.zRot = 3;
            this.Body.xRot = ((float) Math.PI / 2F);
            this.Leg1.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
            this.Leg2.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
            this.Leg3.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
            this.Leg4.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        }
        this.Head.xRot = f4 / (180F / (float) Math.PI);
        this.Head.yRot = f3 / (180F / (float) Math.PI);
        this.Ear1.xRot = f4 / (180F / (float) Math.PI);
        this.Ear1.yRot = f3 / (180F / (float) Math.PI);
        this.Ear2.xRot = f4 / (180F / (float) Math.PI);
        this.Ear2.yRot = f3 / (180F / (float) Math.PI);
        this.tail.xRot = ((float) Math.PI / 2F);
    }
}
