package divinerpg.objects.entities.assets.model.twilight;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;


public class ModelSkythernFiend extends ModelBase {
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
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);

        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightleg.setTextureSize(64, 32);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftleg.setTextureSize(64, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
        this.connector = new ModelRenderer(this, 0, 20);
        this.connector.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6);
        this.connector.setRotationPoint(-2.0F, -6.0F, -9.0F);
        this.connector.setTextureSize(64, 32);
        this.connector.mirror = true;
        this.setRotation(this.connector, 0.0F, 0.0F, 0.0F);
        this.eye = new ModelRenderer(this, 32, 0);
        this.eye.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.eye.setRotationPoint(-4.0F, -8.0F, -16.0F);
        this.eye.setTextureSize(64, 32);
        this.eye.mirror = true;
        this.setRotation(this.eye, 0.0F, 0.0F, 0.0F);

        this.leftarm = new ModelRenderer(this, 40, 16);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
        this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.leftarm.setTextureSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
        this.leftSpear = new ModelRenderer(this, -2, 0);
        this.leftSpear.addBox(-4.5F, -1, 2, 1, 1, 13);
        this.leftSpear.setRotationPoint(5.5F, 10.0F, -15.0F);
        this.leftSpear.setTextureSize(64, 32);
        this.leftSpear.mirror = true;
        this.setRotation(this.leftSpear, 0.0F, 0.0F, 0.0F);

        this.rightarm = new ModelRenderer(this, 40, 16);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
        this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.rightarm.setTextureSize(64, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
        this.rightSpear = new ModelRenderer(this, 0, 0);
        this.rightSpear.addBox(5.5F, -1, 2, 1, 1, 13);
        this.rightSpear.setRotationPoint(-7.0F, 10.0F, -15.0F);
        this.rightSpear.setTextureSize(64, 32);
        this.rightSpear.mirror = true;
        this.setRotation(this.rightSpear, 0.0F, 0.0F, 0.0F);

        rightarm.addChild(rightSpear);
        leftarm.addChild(leftSpear);

        head.addChild(connector);
        head.addChild(eye);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);
        this.head.render(var7);
        this.body.render(var7);
        this.rightarm.render(var7);
        this.leftarm.render(var7);
        this.rightleg.render(var7);
        this.leftleg.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.head.rotateAngleY = var4 / (180F / (float) Math.PI);
        this.head.rotateAngleX = var5 / (180F / (float) Math.PI);

        this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 1.4F * var2;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
    }
}
