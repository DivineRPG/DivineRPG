package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSorcerer<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer staffProngRight2;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer leftarm;
    ModelRenderer staffPoleRight;
    ModelRenderer staffCapRight;
    ModelRenderer staffProngRight3;
    ModelRenderer staffProngRight1;
    ModelRenderer staffProngRight4;
    ModelRenderer head;
    ModelRenderer ray2;
    ModelRenderer ray8;
    ModelRenderer ray6;
    ModelRenderer ray4;
    ModelRenderer ray1;
    ModelRenderer ray7;
    ModelRenderer ray5;
    ModelRenderer ray3;
    ModelRenderer staffPoleLeft;
    ModelRenderer staffCapLeft;
    ModelRenderer staffProngLeft1;
    ModelRenderer staffProngLeft2;
    ModelRenderer staffProngLeft4;
    ModelRenderer staffProngLeft3;

    public ModelSorcerer() {
        texWidth = 64;
        texHeight = 32;

        body = new ModelRenderer(this, 24, 0);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 10, 23);
        rightarm.addBox(-6F, 4F, -2F, 4, 4, 4);
        rightarm.setPos(-4F, 2F, -2F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        staffProngRight2 = new ModelRenderer(this, 40, 20);
        staffProngRight2.addBox(-3F, -7F, -3F, 1, 2, 1);
        staffProngRight2.setPos(-4F, 2F, 0F);
        staffProngRight2.setTexSize(64, 32);
        staffProngRight2.mirror = true;
        setRotation(staffProngRight2, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 12);
        rightleg.addBox(-2F, 10F, -6F, 4, 2, 8);
        rightleg.setPos(-3F, 12F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 12);
        leftleg.addBox(-2F, 10F, -6F, 4, 2, 8);
        leftleg.setPos(3F, 12F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 10, 23);
        leftarm.addBox(1F, 4F, -4F, 4, 4, 4);
        leftarm.setPos(5F, 2F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        staffPoleRight = new ModelRenderer(this, 53, 0);
        staffPoleRight.addBox(-5F, -4F, -5F, 2, 22, 2);
        staffPoleRight.setPos(-4F, 2F, 0F);
        staffPoleRight.setTexSize(64, 32);
        staffPoleRight.mirror = true;
        setRotation(staffPoleRight, 0F, 0F, 0F);
        staffCapRight = new ModelRenderer(this, 40, 25);
        staffCapRight.addBox(-6F, -5F, -6F, 4, 2, 4);
        staffCapRight.setPos(-4F, 2F, 0F);
        staffCapRight.setTexSize(64, 32);
        staffCapRight.mirror = true;
        setRotation(staffCapRight, 0F, 0F, 0F);
        staffProngRight3 = new ModelRenderer(this, 40, 20);
        staffProngRight3.addBox(-6F, -7F, -3F, 1, 2, 1);
        staffProngRight3.setPos(-4F, 2F, 0F);
        staffProngRight3.setTexSize(64, 32);
        staffProngRight3.mirror = true;
        setRotation(staffProngRight3, 0F, 0F, 0F);
        staffProngRight1 = new ModelRenderer(this, 40, 20);
        staffProngRight1.addBox(-3F, -7F, -6F, 1, 2, 1);
        staffProngRight1.setPos(-4F, 2F, 0F);
        staffProngRight1.setTexSize(64, 32);
        staffProngRight1.mirror = true;
        setRotation(staffProngRight1, 0F, 0F, 0F);
        staffProngRight4 = new ModelRenderer(this, 40, 20);
        staffProngRight4.addBox(-6F, -7F, -6F, 1, 2, 1);
        staffProngRight4.setPos(-4F, 2F, 0F);
        staffProngRight4.setTexSize(64, 32);
        staffProngRight4.mirror = true;
        setRotation(staffProngRight4, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-3F, -6F, -3F, 6, 6, 6);
        head.setPos(0F, -5F, -1F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        ray2 = new ModelRenderer(this, 0, 23);
        ray2.addBox(-7F, -1F, -1F, 2, 2, 2);
        ray2.setPos(0F, -9F, -1F);
        ray2.setTexSize(64, 32);
        ray2.mirror = true;
        setRotation(ray2, 0F, 0F, -0.7853982F);
        ray8 = new ModelRenderer(this, 0, 23);
        ray8.addBox(-1F, 6F, -1F, 2, 2, 2);
        ray8.setPos(0F, -9F, -1F);
        ray8.setTexSize(64, 32);
        ray8.mirror = true;
        setRotation(ray8, 0F, 0F, -0.7853982F);
        ray6 = new ModelRenderer(this, 0, 23);
        ray6.addBox(5F, -1F, -1F, 2, 2, 2);
        ray6.setPos(0F, -9F, -1F);
        ray6.setTexSize(64, 32);
        ray6.mirror = true;
        setRotation(ray6, 0F, 0F, -0.7853982F);
        ray4 = new ModelRenderer(this, 0, 23);
        ray4.addBox(-1F, -7F, -1F, 2, 2, 2);
        ray4.setPos(0F, -9F, -1F);
        ray4.setTexSize(64, 32);
        ray4.mirror = true;
        setRotation(ray4, 0F, 0F, -0.7853982F);
        ray1 = new ModelRenderer(this, 0, 23);
        ray1.addBox(-1F, 6F, -1F, 2, 2, 2);
        ray1.setPos(0F, -9F, -1F);
        ray1.setTexSize(64, 32);
        ray1.mirror = true;
        setRotation(ray1, 0F, 0F, 0F);
        ray7 = new ModelRenderer(this, 0, 23);
        ray7.addBox(5F, -1F, -1F, 2, 2, 2);
        ray7.setPos(0F, -9F, -1F);
        ray7.setTexSize(64, 32);
        ray7.mirror = true;
        setRotation(ray7, 0F, 0F, 0F);
        ray5 = new ModelRenderer(this, 0, 23);
        ray5.addBox(-1F, -7F, -1F, 2, 2, 2);
        ray5.setPos(0F, -9F, -1F);
        ray5.setTexSize(64, 32);
        ray5.mirror = true;
        setRotation(ray5, 0F, 0F, 0F);
        ray3 = new ModelRenderer(this, 0, 23);
        ray3.addBox(-7F, -1F, -1F, 2, 2, 2);
        ray3.setPos(0F, -9F, -1F);
        ray3.setTexSize(64, 32);
        ray3.mirror = true;
        setRotation(ray3, 0F, 0F, 0F);
        staffPoleLeft = new ModelRenderer(this, 53, 0);
        staffPoleLeft.addBox(2F, -4F, -5F, 2, 22, 2);
        staffPoleLeft.setPos(5F, 2F, 0F);
        staffPoleLeft.setTexSize(64, 32);
        staffPoleLeft.mirror = true;
        setRotation(staffPoleLeft, 0F, 0F, 0F);
        staffCapLeft = new ModelRenderer(this, 40, 25);
        staffCapLeft.addBox(1F, -5F, -6F, 4, 2, 4);
        staffCapLeft.setPos(5F, 2F, 0F);
        staffCapLeft.setTexSize(64, 32);
        staffCapLeft.mirror = true;
        setRotation(staffCapLeft, 0F, 0F, 0F);
        staffProngLeft1 = new ModelRenderer(this, 40, 20);
        staffProngLeft1.addBox(4F, -7F, -6F, 1, 2, 1);
        staffProngLeft1.setPos(5F, 2F, 0F);
        staffProngLeft1.setTexSize(64, 32);
        staffProngLeft1.mirror = true;
        setRotation(staffProngLeft1, 0F, 0F, 0F);
        staffProngLeft2 = new ModelRenderer(this, 40, 20);
        staffProngLeft2.addBox(4F, -7F, -3F, 1, 2, 1);
        staffProngLeft2.setPos(5F, 2F, 0F);
        staffProngLeft2.setTexSize(64, 32);
        staffProngLeft2.mirror = true;
        setRotation(staffProngLeft2, 0F, 0F, 0F);
        staffProngLeft4 = new ModelRenderer(this, 40, 20);
        staffProngLeft4.addBox(1F, -7F, -6F, 1, 2, 1);
        staffProngLeft4.setPos(5F, 2F, 0F);
        staffProngLeft4.setTexSize(64, 32);
        staffProngLeft4.mirror = true;
        setRotation(staffProngLeft4, 0F, 0F, 0F);
        staffProngLeft3 = new ModelRenderer(this, 40, 20);
        staffProngLeft3.addBox(1F, -7F, -3F, 1, 2, 1);
        staffProngLeft3.setPos(5F, 2F, 0F);
        staffProngLeft3.setTexSize(64, 32);
        staffProngLeft3.mirror = true;
        setRotation(staffProngLeft3, 0F, 0F, 0F);
    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(body, rightarm, staffProngRight2, rightleg, leftleg, leftarm, staffPoleRight, staffCapRight, staffProngRight3, staffProngRight1, staffProngRight4, head, ray2, ray8,
        ray6, ray4, ray1, ray7, ray5, ray3, staffPoleLeft, staffCapLeft, staffProngLeft1, staffProngLeft2, staffProngLeft4, staffProngLeft3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T e, float f, float f1, float f2, float f3, float f4) {
        this.ray1.zRot  = this.ray3.zRot = this.ray5.zRot = this.ray7.zRot = f2/10;
        this.ray2.zRot = this.ray4.zRot = this.ray6.zRot = this.ray8.zRot = f2/10 - 0.7853982F;
        this.leftleg.xRot = this.rightarm.xRot = this.staffPoleRight.xRot = this.staffCapRight.xRot = this.staffProngRight1.xRot = this.staffProngRight2.xRot = this.staffProngRight3.xRot = this.staffProngRight4.xRot = MathHelper.cos(f)*f1*1.2f;
        this.rightleg.xRot = this.leftarm.xRot = this.staffPoleLeft.xRot = this.staffCapLeft.xRot = this.staffProngLeft1.xRot = this.staffProngLeft2.xRot = this.staffProngLeft3.xRot = this.staffProngLeft4.xRot = MathHelper.cos(f+(float)Math.PI)*f1*1.2f;
    }

}
