package divinerpg.client.models.vanilla;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelScorcher<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer mainBody;
    ModelRenderer head;
    ModelRenderer rightArm;
    ModelRenderer leftArm;
    ModelRenderer rightArm2;
    ModelRenderer leftArm2;
    ModelRenderer leftHorn;
    ModelRenderer leftHorn2;
    ModelRenderer rightHorn;
    ModelRenderer rightHorn2;

    public ModelScorcher() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.mainBody = new ModelRenderer(this, 0, 0);
        this.mainBody.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.mainBody.setPos(-4.0F, 14.0F, -5.0F);
        this.mainBody.setTexSize(64, 64);
        this.mainBody.mirror = true;
        this.setRotation(this.mainBody, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 16);
        this.head.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6);
        this.head.setPos(-3.0F, 8.0F, -4.0F);
        this.head.setTexSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.rightArm = new ModelRenderer(this, 0, 48);
        this.rightArm.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightArm.setPos(-9.0F, 19.0F, -2.0F);
        this.rightArm.setTexSize(64, 64);
        this.rightArm.mirror = true;
        this.setRotation(this.rightArm, 0.0F, 0.0F, 0.0F);
        this.leftArm = new ModelRenderer(this, 0, 48);
        this.leftArm.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftArm.setPos(3.0F, 19.0F, -2.0F);
        this.leftArm.setTexSize(64, 64);
        this.leftArm.mirror = true;
        this.setRotation(this.leftArm, 0.0F, 0.0F, 0.0F);
        this.rightArm2 = new ModelRenderer(this, 0, 48);
        this.rightArm2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightArm2.setPos(-9.0F, 19.0F, -2.0F);
        this.rightArm2.setTexSize(64, 64);
        this.rightArm2.mirror = true;
        this.setRotation(this.rightArm2, 0.0F, 0.0F, -((float) Math.PI / 2F));
        this.leftArm2 = new ModelRenderer(this, 0, 48);
        this.leftArm2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftArm2.setPos(7.0F, 19.0F, -2.0F);
        this.leftArm2.setTexSize(64, 64);
        this.leftArm2.mirror = true;
        this.setRotation(this.leftArm2, 0.0F, 0.0F, -((float) Math.PI / 2F));
        this.leftHorn = new ModelRenderer(this, 0, 48);
        this.leftHorn.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftHorn.setPos(2.0F, 9.0F, 0.0F);
        this.leftHorn.setTexSize(64, 64);
        this.leftHorn.mirror = true;
        this.setRotation(this.leftHorn, 0.0F, 0.0F, 0.0F);
        this.leftHorn2 = new ModelRenderer(this, 0, 48);
        this.leftHorn2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftHorn2.setPos(6.0F, 9.0F, 0.0F);
        this.leftHorn2.setTexSize(64, 64);
        this.leftHorn2.mirror = true;
        this.setRotation(this.leftHorn2, 0.0F, 0.0F, -((float) Math.PI / 2F));
        this.rightHorn = new ModelRenderer(this, 0, 48);
        this.rightHorn.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightHorn.setPos(-8.0F, 9.0F, 0.0F);
        this.rightHorn.setTexSize(64, 64);
        this.rightHorn.mirror = true;
        this.setRotation(this.rightHorn, 0.0F, 0.0F, 0.0F);
        this.rightHorn2 = new ModelRenderer(this, 0, 48);
        this.rightHorn2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightHorn2.setPos(-8.0F, 9.0F, 0.0F);
        this.rightHorn2.setTexSize(64, 64);
        this.rightHorn2.mirror = true;
        this.setRotation(this.rightHorn2, 0.0F, 0.0F, -((float) Math.PI / 2F));
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(mainBody, head, rightArm, leftArm, rightArm2, leftArm2, leftHorn, leftHorn2, rightHorn, rightHorn2);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }
}
