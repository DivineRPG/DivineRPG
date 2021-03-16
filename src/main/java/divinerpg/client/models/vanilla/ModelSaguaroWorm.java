package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSaguaroWorm<T extends EntitySaguaroWorm> extends SegmentedModel<T> {
    ModelRenderer connector2;
    ModelRenderer middle;
    ModelRenderer base;
    ModelRenderer connector1;
    ModelRenderer head;

    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelSaguaroWorm() {
        texWidth = 64;
        texHeight = 64;

        connector2 = new ModelRenderer(this, 0, 32);
        connector2.addBox(0F, 0F, 0F, 10, 16, 10);
        connector2.setPos(-5F, -24F, -21F);
        connector2.setTexSize(64, 64);
        connector2.mirror = true;
        setRotation(connector2, 0.5759587F, 0F, 0F);
        middle = new ModelRenderer(this, 0, 0);
        middle.addBox(0F, 0F, 0F, 16, 16, 16);
        middle.setPos(-8F, -13F, -16F);
        middle.setTexSize(64, 64);
        middle.mirror = true;
        setRotation(middle, 0.4363323F, 0F, 0F);
        base = new ModelRenderer(this, 0, 0);
        base.addBox(0F, 0F, 0F, 16, 16, 16);
        base.setPos(-8F, 8F, -8F);
        base.setTexSize(64, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        connector1 = new ModelRenderer(this, 0, 32);
        connector1.addBox(0F, 0F, 0F, 10, 16, 10);
        connector1.setPos(-5F, -3F, -9F);
        connector1.setTexSize(64, 64);
        connector1.mirror = true;
        setRotation(connector1, 0.3316126F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-8F, -16F, -8F, 16, 16, 16);
        head.setPos(0F, -24F, -14F);
        head.setTexSize(64, 64);
        head.mirror = true;
        setRotation(head, 1.047198F, 0F, 0F);

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 16, 16, 16);
        Shape1.setPos(-8F, -8F, -8F);
        Shape1.setTexSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 16, 16, 16);
        Shape2.setPos(-8F, 8F, -8F);
        Shape2.setTexSize(64, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.addBox(0F, 0F, 0F, 16, 16, 16);
        Shape3.setPos(-8F, -24F, -8F);
        Shape3.setTexSize(64, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
    public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        if(entityIn.getProvoked()){
            connector2.visible = true;
            middle.visible = true;
            base.visible = true;
            connector1.visible = true;
            head.visible = true;
            Shape1.visible = false;
            Shape2.visible = false;
            Shape3.visible = false;
        }
        else{
            connector2.visible = false;
            middle.visible = false;
            base.visible = false;
            connector1.visible = false;
            head.visible = false;
            Shape1.visible = true;
            Shape2.visible = true;
            Shape3.visible = true;
        }

    }
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(connector2, middle, base, connector1, head, Shape1, Shape2, Shape3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
