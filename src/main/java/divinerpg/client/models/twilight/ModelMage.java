package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelMage<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer staffProng2;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer leftarm;
    ModelRenderer staffPole;
    ModelRenderer staffCap;
    ModelRenderer staffProng3;
    ModelRenderer staffProng1;
    ModelRenderer staffProng4;
    ModelRenderer head;
    ModelRenderer ray2;
    ModelRenderer ray1;
    ModelRenderer ray4;
    ModelRenderer ray3;

    public ModelMage() {
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
        staffProng2 = new ModelRenderer(this, 40, 20);
        staffProng2.addBox(4F, -7F, -3F, 1, 2, 1);
        staffProng2.setPos(5F, 2F, 0F);
        staffProng2.setTexSize(64, 32);
        staffProng2.mirror = true;
        setRotation(staffProng2, 0F, 0F, 0F);
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
        staffPole = new ModelRenderer(this, 53, 0);
        staffPole.addBox(2F, -4F, -5F, 2, 22, 2);
        staffPole.setPos(5F, 2F, 0F);
        staffPole.setTexSize(64, 32);
        staffPole.mirror = true;
        setRotation(staffPole, 0F, 0F, 0F);
        staffCap = new ModelRenderer(this, 40, 25);
        staffCap.addBox(1F, -5F, -6F, 4, 2, 4);
        staffCap.setPos(5F, 2F, 0F);
        staffCap.setTexSize(64, 32);
        staffCap.mirror = true;
        setRotation(staffCap, 0F, 0F, 0F);
        staffProng3 = new ModelRenderer(this, 40, 20);
        staffProng3.addBox(1F, -7F, -3F, 1, 2, 1);
        staffProng3.setPos(5F, 2F, 0F);
        staffProng3.setTexSize(64, 32);
        staffProng3.mirror = true;
        setRotation(staffProng3, 0F, 0F, 0F);
        staffProng1 = new ModelRenderer(this, 40, 20);
        staffProng1.addBox(4F, -7F, -6F, 1, 2, 1);
        staffProng1.setPos(5F, 2F, 0F);
        staffProng1.setTexSize(64, 32);
        staffProng1.mirror = true;
        setRotation(staffProng1, 0F, 0F, 0F);
        staffProng4 = new ModelRenderer(this, 40, 20);
        staffProng4.addBox(1F, -7F, -6F, 1, 2, 1);
        staffProng4.setPos(5F, 2F, 0F);
        staffProng4.setTexSize(64, 32);
        staffProng4.mirror = true;
        setRotation(staffProng4, 0F, 0F, 0F);
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
        setRotation(ray2, 0F, 0F, 0F);
        ray1 = new ModelRenderer(this, 0, 23);
        ray1.addBox(-1F, 6F, -1F, 2, 2, 2);
        ray1.setPos(0F, -9F, -1F);
        ray1.setTexSize(64, 32);
        ray1.mirror = true;
        setRotation(ray1, 0F, 0F, 0F);
        ray4 = new ModelRenderer(this, 0, 23);
        ray4.addBox(5F, -1F, -1F, 2, 2, 2);
        ray4.setPos(0F, -9F, -1F);
        ray4.setTexSize(64, 32);
        ray4.mirror = true;
        setRotation(ray4, 0F, 0F, 0F);
        ray3 = new ModelRenderer(this, 0, 23);
        ray3.addBox(-1F, -7F, -1F, 2, 2, 2);
        ray3.setPos(0F, -9F, -1F);
        ray3.setTexSize(64, 32);
        ray3.mirror = true;
        setRotation(ray3, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(body, rightarm, staffProng2, rightleg, leftleg, leftarm, staffPole, staffCap, staffProng3, staffProng1, staffProng4, head, ray2, ray1, ray4, ray3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T e, float f, float f1, float f2, float f3, float f4) {
        this.ray1.zRot = this.ray2.zRot = this.ray3.zRot = this.ray4.zRot = f2/10;
        this.leftleg.xRot = this.rightarm.xRot = MathHelper.cos(f)*f1*1.2f;
        this.rightleg.xRot = this.leftarm.xRot = this.staffPole.xRot = this.staffCap.xRot = this.staffProng1.xRot = this.staffProng2.xRot = this.staffProng3.xRot = this.staffProng4.xRot = MathHelper.cos(f+(float)Math.PI)*f1*1.2f;
    }

}
