package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTheGrue<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer toeRightOut;
    ModelRenderer toeLeftOut;
    ModelRenderer toeRightIn;
    ModelRenderer toeLeftIn;
    ModelRenderer legRight;
    ModelRenderer legLeft;
    ModelRenderer thighRight;
    ModelRenderer thighLeft;
    ModelRenderer torso;
    ModelRenderer body;
    ModelRenderer Shape6;
    ModelRenderer tail1;
    ModelRenderer tail3;
    ModelRenderer tail2;
    ModelRenderer mouth;
    ModelRenderer head;

    public ModelTheGrue() {
        texWidth = 64;
        texHeight = 27;

        toeRightOut = new ModelRenderer(this, 0, 0);
        toeRightOut.addBox(3F, -6F, 15F, 2, 11, 2);
        toeRightOut.setPos(-5F, 2F, 4F);
        toeRightOut.setTexSize(32, 27);
        toeRightOut.mirror = true;
        setRotation(toeRightOut, -1.152537F, 0.8922867F, 0F);
        toeLeftOut = new ModelRenderer(this, 0, 0);
        toeLeftOut.addBox(-6F, -6F, 15F, 2, 11, 2);
        toeLeftOut.setPos(8F, 2F, 4F);
        toeLeftOut.setTexSize(32, 27);
        toeLeftOut.mirror = true;
        setRotation(toeLeftOut, -1.152537F, -0.8179294F, 0F);
        toeRightIn = new ModelRenderer(this, 0, 0);
        toeRightIn.addBox(11F, 3F, 12F, 2, 11, 2);
        toeRightIn.setPos(-5F, 2F, 4F);
        toeRightIn.setTexSize(32, 27);
        toeRightIn.mirror = true;
        setRotation(toeRightIn, -1.152537F, -0.0743572F, 0F);
        toeLeftIn = new ModelRenderer(this, 0, 0);
        toeLeftIn.addBox(-14F, 3F, 11F, 2, 11, 2);
        toeLeftIn.setPos(8F, 2F, 4F);
        toeLeftIn.setTexSize(32, 27);
        toeLeftIn.mirror = true;
        setRotation(toeLeftIn, -1.152537F, 0.1487144F, 0F);
        legRight = new ModelRenderer(this, 0, 0);
        legRight.addBox(4F, 4F, 6F, 3, 10, 3);
        legRight.setPos(-5F, 2F, 4F);
        legRight.setTexSize(32, 27);
        legRight.mirror = true;
        setRotation(legRight, -0.3717861F, 0F, 0.2230717F);
        legLeft = new ModelRenderer(this, 0, 0);
        legLeft.addBox(-6F, 4F, 7F, 3, 10, 3);
        legLeft.setPos(8F, 2F, 4F);
        legLeft.setTexSize(32, 27);
        legLeft.mirror = true;
        setRotation(legLeft, -0.4089647F, 0F, -0.2230717F);
        thighRight = new ModelRenderer(this, 0, 0);
        thighRight.addBox(-2F, 0F, -2F, 4, 11, 4);
        thighRight.setPos(-5F, 2F, 4F);
        thighRight.setTexSize(32, 27);
        thighRight.mirror = true;
        setRotation(thighRight, 0.6145831F, 0F, -0.4089647F);
        thighLeft = new ModelRenderer(this, 0, 0);
        thighLeft.addBox(-2F, 0F, -2F, 4, 11, 4);
        thighLeft.setPos(8F, 2F, 4F);
        thighLeft.setTexSize(32, 27);
        thighLeft.mirror = true;
        setRotation(thighLeft, 0.6145831F, 0F, 0.4089647F);
        torso = new ModelRenderer(this, 0, 0);
        torso.addBox(0F, 0F, 0F, 12, 6, 4);
        torso.setPos(-5F, -3F, 3F);
        torso.setTexSize(32, 27);
        torso.mirror = true;
        setRotation(torso, -0.2230717F, 0F, 0F);
        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 8, 9, 10);
        body.setPos(-3F, -9.333333F, 0F);
        body.setTexSize(32, 27);
        body.mirror = true;
        setRotation(body, -0.0743572F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.addBox(0F, 0F, 0F, 6, 8, 8);
        Shape6.setPos(-2F, -6F, -7F);
        Shape6.setTexSize(32, 27);
        Shape6.mirror = true;
        setRotation(Shape6, 0.3717861F, 0F, 0F);
        tail1 = new ModelRenderer(this, 0, 0);
        tail1.addBox(0F, 0F, 0F, 6, 6, 7);
        tail1.setPos(-2F, -2F, 7F);
        tail1.setTexSize(32, 27);
        tail1.mirror = true;
        setRotation(tail1, 1.226894F, 0F, 0F);
        tail3 = new ModelRenderer(this, 0, 0);
        tail3.addBox(0F, 0F, 0F, 2, 2, 2);
        tail3.setPos(0F, -3F, 17F);
        tail3.setTexSize(32, 27);
        tail3.mirror = true;
        setRotation(tail3, 0.7807508F, 0F, 0F);
        tail2 = new ModelRenderer(this, 0, 0);
        tail2.addBox(0F, 0F, 0F, 4, 4, 4);
        tail2.setPos(-1F, -3F, 13F);
        tail2.setTexSize(32, 27);
        tail2.mirror = true;
        setRotation(tail2, 1.041001F, 0F, 0F);
        mouth = new ModelRenderer(this, 0, 0);
        mouth.addBox(0F, 0F, 0F, 8, 2, 6);
        mouth.setPos(-3F, 4F, -9.466666F);
        mouth.setTexSize(32, 27);
        mouth.mirror = true;
        setRotation(mouth, 0.669215F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(0F, 0F, 0F, 8, 7, 11);
        head.setPos(-3F, -3F, -17F);
        head.setTexSize(32, 27);
        head.mirror = true;
        setRotation(head, 0.3346075F, 0F, 0F);
        legLeft.addChild(toeLeftIn);
        legLeft.addChild(toeLeftOut);
        legRight.addChild(toeRightIn);
        legRight.addChild(toeRightOut);
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float ageInTicks, float netHeadYaw, float headPitch) {

        this.legLeft.xRot = -0.4089647F + (MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4f * f1);
        this.thighLeft.xRot = 0.6145831F + (MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4f * f1);
        this.legRight.xRot = -0.4089647F + (MathHelper.cos(f * 0.6662F) * 1.4f * f1);
        this.thighRight.xRot = 0.6145831F + (MathHelper.cos(f * 0.6662F) * 1.4f * f1);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(legRight, legLeft, thighRight, thighLeft, torso, body, Shape6, tail1, tail3, tail2, mouth, head);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
