package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelLivestockMerchant<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer head;
    ModelRenderer hatbottom;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer hatTop;
    ModelRenderer frontRightCorner;
    ModelRenderer frontLeftCorner;
    ModelRenderer backRightCorner;
    ModelRenderer backLeftCorner;

    public ModelLivestockMerchant() {
        texWidth = 64;
        texHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(64, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        hatbottom = new ModelRenderer(this, 0, 42);
        hatbottom.addBox(-7F, -8F, -7F, 14, 1, 14);
        hatbottom.setPos(0F, 0F, 0F);
        hatbottom.setTexSize(64, 64);
        hatbottom.mirror = true;
        setRotation(hatbottom, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(64, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-5F, 2F, 0F);
        rightarm.setTexSize(64, 64);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(5F, 2F, 0F);
        leftarm.setTexSize(64, 64);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-2F, 12F, 0F);
        rightleg.setTexSize(64, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(2F, 12F, 0F);
        leftleg.setTexSize(64, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        hatTop = new ModelRenderer(this, 0, 32);
        hatTop.addBox(-4F, -10F, -4F, 8, 2, 8);
        hatTop.setPos(0F, 0F, 0F);
        hatTop.setTexSize(64, 64);
        hatTop.mirror = true;
        setRotation(hatTop, 0F, 0F, 0F);
        frontRightCorner = new ModelRenderer(this, 0, 62);
        frontRightCorner.addBox(-7F, -8F, -7F, 1, 1, 1);
        frontRightCorner.setPos(0F, 0F, 0F);
        frontRightCorner.setTexSize(64, 64);
        frontRightCorner.mirror = true;
        setRotation(frontRightCorner, 0F, 0F, 0F);
        frontLeftCorner = new ModelRenderer(this, 4, 62);
        frontLeftCorner.addBox(6F, -8F, -7F, 1, 1, 1);
        frontLeftCorner.setPos(0F, 0F, 0F);
        frontLeftCorner.setTexSize(64, 64);
        frontLeftCorner.mirror = true;
        setRotation(frontLeftCorner, 0F, 0F, 0F);
        backRightCorner = new ModelRenderer(this, 8, 62);
        backRightCorner.addBox(-7F, -8F, 6F, 1, 1, 1);
        backRightCorner.setPos(0F, 0F, 0F);
        backRightCorner.setTexSize(64, 64);
        backRightCorner.mirror = true;
        setRotation(backRightCorner, 0F, 0F, 0F);
        backLeftCorner = new ModelRenderer(this, 12, 62);
        backLeftCorner.addBox(6F, -8F, 6F, 1, 1, 1);
        backLeftCorner.setPos(0F, 0F, 0F);
        backLeftCorner.setTexSize(64, 64);
        backLeftCorner.mirror = true;
        setRotation(backLeftCorner, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float f2, float f3, float f4) {
        this.hatTop.yRot = this.hatbottom.yRot = this.frontRightCorner.yRot = this.backRightCorner.yRot = this.backLeftCorner.yRot = this.frontLeftCorner.yRot = this.head.yRot = f3 / (180F / (float) Math.PI);
        this.hatTop.xRot = this.hatbottom.xRot = this.frontRightCorner.xRot = this.backRightCorner.xRot = this.backLeftCorner.xRot = this.frontLeftCorner.xRot = this.head.xRot = f4 / (180F / (float) Math.PI);
        this.rightarm.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
        this.leftarm.xRot = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightleg.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, hatbottom, body, rightarm, leftarm, rightleg, leftleg, hatTop, frontRightCorner, frontLeftCorner, backRightCorner, backLeftCorner);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }


}
