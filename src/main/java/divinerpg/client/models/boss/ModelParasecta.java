package divinerpg.client.models.boss;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelParasecta<T extends Entity> extends SegmentedModel<T>
{
    ModelRenderer foot6;
    ModelRenderer wing2;
    ModelRenderer wing1;
    ModelRenderer body;
    ModelRenderer leg6;
    ModelRenderer foot4;
    ModelRenderer leg4;
    ModelRenderer foot5;
    ModelRenderer leg5;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer foot3;
    ModelRenderer tusk1;
    ModelRenderer head;
    ModelRenderer tusk2;

    public ModelParasecta() {
        texWidth = 128;
        texHeight = 32;

        foot6 = new ModelRenderer(this, 15, 17);
        foot6.addBox(-5F, -1F, -7F, 2, 9, 1);
        foot6.setPos(-3F, 13F, 11F);
        foot6.setTexSize(128, 32);
        foot6.mirror = true;
        setRotation(foot6, 0F, 0F, -0.4363323F);
        wing2 = new ModelRenderer(this, 0, 0);
        wing2.addBox(-14F, 0F, -5F, 14, 1, 10);
        wing2.setPos(-10F, 0F, 0F);
        wing2.setTexSize(128, 32);
        wing2.mirror = true;
        setRotation(wing2, -0.7330383F, 0F, 0F);
        wing1 = new ModelRenderer(this, 0, 0);
        wing1.addBox(0F, 0F, -5F, 14, 1, 10);
        wing1.setPos(10F, 0F, 0F);
        wing1.setTexSize(128, 32);
        wing1.mirror = true;
        setRotation(wing1, -0.7330383F, 0F, 0F);
        body = new ModelRenderer(this, 78, 0);
        body.addBox(-6F, -10F, -7F, 20, 22, 5);
        body.setPos(-4F, -3F, 2F);
        body.setTexSize(128, 32);
        body.mirror = true;
        setRotation(body, 0.8644027F, 0F, 0F);
        leg6 = new ModelRenderer(this, 0, 14);
        leg6.addBox(-6F, -10F, -7F, 4, 12, 3);
        leg6.setPos(-3F, 15F, 10F);
        leg6.setTexSize(128, 32);
        leg6.mirror = true;
        setRotation(leg6, 0F, 0F, 0F);
        foot4 = new ModelRenderer(this, 15, 17);
        foot4.addBox(-5F, -1F, -7F, 2, 9, 1);
        foot4.setPos(-3F, 6F, 1F);
        foot4.setTexSize(128, 32);
        foot4.mirror = true;
        setRotation(foot4, 0F, 0F, -0.4363323F);
        leg4 = new ModelRenderer(this, 0, 14);
        leg4.addBox(-6F, -10F, -7F, 4, 12, 3);
        leg4.setPos(-3F, 8F, 0F);
        leg4.setTexSize(128, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        foot5 = new ModelRenderer(this, 15, 17);
        foot5.addBox(-5F, -1F, -7F, 2, 9, 1);
        foot5.setPos(-3F, 10F, 6F);
        foot5.setTexSize(128, 32);
        foot5.mirror = true;
        setRotation(foot5, 0F, 0F, -0.4363323F);
        leg5 = new ModelRenderer(this, 0, 14);
        leg5.addBox(-6F, -10F, -7F, 4, 12, 3);
        leg5.setPos(-3F, 12F, 5F);
        leg5.setTexSize(128, 32);
        leg5.mirror = true;
        setRotation(leg5, 0F, 0F, 0F);
        leg1 = new ModelRenderer(this, 0, 14);
        leg1.addBox(-6F, -10F, -7F, 4, 12, 3);
        leg1.setPos(11F, 8F, 0F);
        leg1.setTexSize(128, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 14);
        leg2.addBox(-6F, -10F, -7F, 4, 12, 3);
        leg2.setPos(11F, 12F, 5F);
        leg2.setTexSize(128, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 14);
        leg3.addBox(-6F, -10F, -7F, 4, 12, 3);
        leg3.setPos(11F, 15F, 10F);
        leg3.setTexSize(128, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        foot1 = new ModelRenderer(this, 15, 17);
        foot1.addBox(-5F, -1F, -7F, 2, 9, 1);
        foot1.setPos(11F, 9F, 1F);
        foot1.setTexSize(128, 32);
        foot1.mirror = true;
        setRotation(foot1, 0F, 0F, 0.4363323F);
        foot2 = new ModelRenderer(this, 15, 17);
        foot2.addBox(-5F, -1F, -7F, 2, 9, 1);
        foot2.setPos(11F, 13F, 6F);
        foot2.setTexSize(128, 32);
        foot2.mirror = true;
        setRotation(foot2, 0F, 0F, 0.4363323F);
        foot3 = new ModelRenderer(this, 15, 17);
        foot3.addBox(-5F, -1F, -7F, 2, 9, 1);
        foot3.setPos(11F, 16F, 11F);
        foot3.setTexSize(128, 32);
        foot3.mirror = true;
        setRotation(foot3, 0F, 0F, 0.4363323F);
        tusk1 = new ModelRenderer(this, 47, 16);
        tusk1.addBox(0F, 0.5333334F, 0F, 1, 3, 1);
        tusk1.setPos(2F, 0F, -13F);
        tusk1.setTexSize(128, 32);
        tusk1.mirror = true;
        setRotation(tusk1, 0F, 0F, 0.1396263F);
        head = new ModelRenderer(this, 48, 0);
        head.addBox(-4F, -4F, -6F, 8, 8, 6);
        head.setPos(0F, -3F, -8F);
        head.setTexSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        tusk2 = new ModelRenderer(this, 47, 16);
        tusk2.addBox(-1F, 0.5333334F, 0F, 1, 3, 1);
        tusk2.setPos(-2F, 0F, -13F);
        tusk2.setTexSize(128, 32);
        tusk2.mirror = true;
        setRotation(tusk2, 0F, 0F, -0.1396263F);
    }

    @Override
    public void setupAnim(T e, float f, float f1, float f2, float f3, float f4) {
        this.wing1.yRot = MathHelper.cos(f3 * 1.3F) * (float) Math.PI * 0.25F;
        this.wing2.yRot = -this.wing1.yRot;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(foot6, wing2, wing1, body, leg6, foot4, leg4, foot5, leg5, leg1, leg2, leg3, foot1, foot2, foot3, tusk1, head, tusk2);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
