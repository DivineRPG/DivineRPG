package TeamDivineRPG.divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSaguaroWorm<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer connector2;
    ModelRenderer middle;
    ModelRenderer base;
    ModelRenderer connector1;
    ModelRenderer head;

    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelSaguaroWorm() {
        textureWidth = 64;
        textureHeight = 64;

        connector2 = new ModelRenderer(this, 0, 32);
        connector2.addBox(0F, 0F, 0F, 10, 16, 10);
        connector2.setRotationPoint(-5F, -24F, -21F);
        connector2.setTextureSize(64, 64);
        connector2.mirror = true;
        setRotation(connector2, 0.5759587F, 0F, 0F);
        middle = new ModelRenderer(this, 0, 0);
        middle.addBox(0F, 0F, 0F, 16, 16, 16);
        middle.setRotationPoint(-8F, -13F, -16F);
        middle.setTextureSize(64, 64);
        middle.mirror = true;
        setRotation(middle, 0.4363323F, 0F, 0F);
        base = new ModelRenderer(this, 0, 0);
        base.addBox(0F, 0F, 0F, 16, 16, 16);
        base.setRotationPoint(-8F, 8F, -8F);
        base.setTextureSize(64, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        connector1 = new ModelRenderer(this, 0, 32);
        connector1.addBox(0F, 0F, 0F, 10, 16, 10);
        connector1.setRotationPoint(-5F, -3F, -9F);
        connector1.setTextureSize(64, 64);
        connector1.mirror = true;
        setRotation(connector1, 0.3316126F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-8F, -16F, -8F, 16, 16, 16);
        head.setRotationPoint(0F, -24F, -14F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 1.047198F, 0F, 0F);

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 16, 16, 16);
        Shape1.setRotationPoint(-8F, -8F, -8F);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 16, 16, 16);
        Shape2.setRotationPoint(-8F, 8F, -8F);
        Shape2.setTextureSize(64, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.addBox(0F, 0F, 0F, 16, 16, 16);
        Shape3.setRotationPoint(-8F, -24F, -8F);
        Shape3.setTextureSize(64, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(connector2, middle, base, connector1, head, Shape1, Shape2, Shape3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
