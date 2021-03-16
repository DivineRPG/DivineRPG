package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSkythernFiend<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer connector;
    ModelRenderer eye;
    ModelRenderer leftSpear;
    ModelRenderer rightSpear;

    public ModelSkythernFiend() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setPos(0.0F, 0.0F, 0.0F);
        this.head.setTexSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
        this.body.setPos(0.0F, 0.0F, 0.0F);
        this.body.setTexSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);

        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.rightleg.setPos(-2.0F, 12.0F, 0.0F);
        this.rightleg.setTexSize(64, 32);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leftleg.setPos(2.0F, 12.0F, 0.0F);
        this.leftleg.setTexSize(64, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
        this.connector = new ModelRenderer(this, 0, 20);
        this.connector.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6);
        this.connector.setPos(-2.0F, -6.0F, -9.0F);
        this.connector.setTexSize(64, 32);
        this.connector.mirror = true;
        this.setRotation(this.connector, 0.0F, 0.0F, 0.0F);
        this.eye = new ModelRenderer(this, 32, 0);
        this.eye.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.eye.setPos(-4.0F, -8.0F, -16.0F);
        this.eye.setTexSize(64, 32);
        this.eye.mirror = true;
        this.setRotation(this.eye, 0.0F, 0.0F, 0.0F);

        this.leftarm = new ModelRenderer(this, 40, 16);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
        this.leftarm.setPos(5.0F, 2.0F, 0.0F);
        this.leftarm.setTexSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
        this.leftSpear = new ModelRenderer(this, -2, 0);
        this.leftSpear.addBox(-4.5F, -1, 2, 1, 1, 13);
        this.leftSpear.setPos(5.5F, 10.0F, -15.0F);
        this.leftSpear.setTexSize(64, 32);
        this.leftSpear.mirror = true;
        this.setRotation(this.leftSpear, 0.0F, 0.0F, 0.0F);

        this.rightarm = new ModelRenderer(this, 40, 16);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
        this.rightarm.setPos(-5.0F, 2.0F, 0.0F);
        this.rightarm.setTexSize(64, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
        this.rightSpear = new ModelRenderer(this, 0, 0);
        this.rightSpear.addBox(5.5F, -1, 2, 1, 1, 13);
        this.rightSpear.setPos(-7.0F, 10.0F, -15.0F);
        this.rightSpear.setTexSize(64, 32);
        this.rightSpear.mirror = true;
        this.setRotation(this.rightSpear, 0.0F, 0.0F, 0.0F);

        rightarm.addChild(rightSpear);
        leftarm.addChild(leftSpear);

        head.addChild(connector);
        head.addChild(eye);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, rightarm, leftarm, rightleg, leftleg);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }

    @Override
    public void setupAnim(T e, float var1, float var2, float var3, float var4, float var5) {
        this.head.yRot = var4 / (180F / (float) Math.PI);
        this.head.xRot = var5 / (180F / (float) Math.PI);

        this.rightarm.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 1.4F * var2;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
    }
}
