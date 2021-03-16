package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelGrizzle<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg4;
    ModelRenderer leg3;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer snout;
    ModelRenderer ear2;
    ModelRenderer ear1;
    ModelRenderer tail;

    public ModelGrizzle() {
        texWidth = 128;
        texHeight = 128;

        leg1 = new ModelRenderer(this, 0, 0);
        leg1.addBox(-1.9999F, 0F, -2F, 4, 10, 4);
        leg1.setPos(-4F, 14F, -8F);
        leg1.setTexSize(128, 128);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 0);
        leg2.addBox(-1.9999F, 0F, -2F, 4, 8, 4);
        leg2.setPos(-4F, 16F, 8F);
        leg2.setTexSize(128, 128);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 0);
        leg4.addBox(-2.0001F, 0F, -2F, 4, 8, 4);
        leg4.setPos(4F, 16F, 8F);
        leg4.setTexSize(128, 128);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 0);
        leg3.addBox(-2.0001F, 0F, -2F, 4, 10, 4);
        leg3.setPos(4F, 14F, -8F);
        leg3.setTexSize(128, 128);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 12, 10, 22);
        body.setPos(-6F, 4.5F, -11F);
        body.setTexSize(128, 128);
        body.mirror = true;
        setRotation(body, -0.0872665F, 0F, 0F);
        head = new ModelRenderer(this, 0, 32);
        head.addBox(-4F, -3F, -5F, 8, 8, 6);
        head.setPos(0F, 5F, -11F);
        head.setTexSize(128, 128);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        snout = new ModelRenderer(this, 0, 46);
        snout.addBox(-2F, 1F, -9F, 4, 4, 4);
        snout.setPos(0F, 5F, -11F);
        snout.setTexSize(128, 128);
        snout.mirror = true;
        setRotation(snout, 0F, 0F, 0F);
        ear2 = new ModelRenderer(this, 0, 14);
        ear2.addBox(3F, -4F, -1F, 2, 2, 1);
        ear2.setPos(0F, 5F, -11F);
        ear2.setTexSize(128, 128);
        ear2.mirror = true;
        setRotation(ear2, 0F, 0F, 0F);
        ear1 = new ModelRenderer(this, 0, 14);
        ear1.addBox(-5F, -4F, -1F, 2, 2, 1);
        ear1.setPos(0F, 5F, -11F);
        ear1.setTexSize(128, 128);
        ear1.mirror = true;
        setRotation(ear1, 0F, 0F, 0F);
        tail = new ModelRenderer(this, 0, 26);
        tail.addBox(5F, 4F, 21.54F, 2, 2, 2);
        tail.setPos(-6F, 4.5F, -11F);
        tail.setTexSize(128, 128);
        tail.mirror = true;
        setRotation(tail, -0.0872665F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float f2, float f3, float f4) {

        this.leg1.xRot = MathHelper.cos(f * 0.6662F) * f1;
        this.leg3.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.leg2.xRot = MathHelper.cos(f * 0.6662F) * f1;
        this.leg4.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;

        this.head.xRot = this.ear1.xRot = this.ear2.xRot = this.snout.xRot = f4 / (180F / (float) Math.PI);
        this.head.yRot = this.ear1.yRot = this.ear2.yRot = this.snout.yRot = f3 / (180F / (float) Math.PI);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(leg1, leg2, leg4, leg3, body, head, snout, ear2, ear1, tail);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }


}
