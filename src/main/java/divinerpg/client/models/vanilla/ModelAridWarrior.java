package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelAridWarrior<T extends EntityAridWarrior> extends SegmentedModel<T> implements IHasArm {

    //fields
    ModelRenderer ear1;
    ModelRenderer leftarmBS1;
    ModelRenderer rightleg;
    ModelRenderer body;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer leftarmBS2;
    ModelRenderer leftarmTS1;
    ModelRenderer leftarmTS2;
    ModelRenderer rightarmTS2;
    ModelRenderer rightarmBS1;
    public ModelRenderer rightarmBS2;
    ModelRenderer rightarmTS1;
    ModelRenderer head;
    ModelRenderer ear2;
    ModelRenderer leftleg;
    ModelRenderer rightfoot;
    ModelRenderer rightlegpart;
    ModelRenderer rightlegpart2;
    ModelRenderer leftfoot;
    ModelRenderer leftlegpart2;
    ModelRenderer leftlegpart1;

    public ModelAridWarrior() {
        texWidth = 64;
        texHeight = 32;

        ear1 = new ModelRenderer(this, 34, 0);
        ear1.addBox(-6F, -8F, -4F, 2, 3, 8);
        ear1.setPos(10F, -12F, -5F);
        ear1.setTexSize(64, 32);
        ear1.mirror = true;
        setRotation(ear1, -0.8179294F, 0F, 0F);
        leftarmBS1 = new ModelRenderer(this, 28, 16);
        leftarmBS1.addBox(-1F, -1F, -2F, 7, 3, 4);
        leftarmBS1.setPos(8F, 4F, 0F);
        leftarmBS1.setTexSize(64, 32);
        leftarmBS1.mirror = true;
        setRotation(leftarmBS1, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-5F, 12F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 6F, -2F, 14, 6, 4);
        body.setPos(-3F, 0F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 16, 16);
        body2.addBox(-4F, 6F, -2F, 14, 6, 4);
        body2.setPos(-3F, -14F, 0F);
        body2.setTexSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 16, 16);
        body3.addBox(-4F, 6F, -2F, 3, 8, 4);
        body3.setPos(8F, -8F, 0F);
        body3.setTexSize(64, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        body4 = new ModelRenderer(this, 16, 16);
        body4.addBox(-4F, 6F, -2F, 3, 8, 4);
        body4.setPos(-3F, -8F, 0F);
        body4.setTexSize(64, 32);
        body4.mirror = true;
        setRotation(body4, 0F, 0F, 0F);
        leftarmBS2 = new ModelRenderer(this, 40, 16);
        leftarmBS2.addBox(2F, 1F, -2F, 4, 6, 4);
        leftarmBS2.setPos(8F, 5F, 0F);
        leftarmBS2.setTexSize(64, 32);
        leftarmBS2.mirror = true;
        setRotation(leftarmBS2, 0F, 0F, 0F);
        leftarmTS1 = new ModelRenderer(this, 28, 16);
        leftarmTS1.addBox(-1F, -1F, -2F, 7, 3, 4);
        leftarmTS1.setPos(8F, -7F, 0F);
        leftarmTS1.setTexSize(64, 32);
        leftarmTS1.mirror = true;
        setRotation(leftarmTS1, 0F, 0F, 0F);
        leftarmTS2 = new ModelRenderer(this, 40, 16);
        leftarmTS2.addBox(2F, 1F, -2F, 4, 6, 4);
        leftarmTS2.setPos(8F, -6F, 0F);
        leftarmTS2.setTexSize(64, 32);
        leftarmTS2.mirror = true;
        setRotation(leftarmTS2, 0F, 0F, 0F);
        rightarmTS2 = new ModelRenderer(this, 40, 16);
        rightarmTS2.addBox(-6F, 1F, -2F, 4, 6, 4);
        rightarmTS2.setPos(-8F, -6F, 0F);
        rightarmTS2.setTexSize(64, 32);
        rightarmTS2.mirror = true;
        setRotation(rightarmTS2, 0F, 0F, 0F);
        rightarmBS1 = new ModelRenderer(this, 28, 16);
        rightarmBS1.addBox(-6F, -1F, -2F, 7, 3, 4);
        rightarmBS1.setPos(-8F, 4F, 0F);
        rightarmBS1.setTexSize(64, 32);
        rightarmBS1.mirror = true;
        setRotation(rightarmBS1, 0F, 0F, 0F);
        rightarmBS2 = new ModelRenderer(this, 40, 16);
        rightarmBS2.addBox(-6F, 1F, -2F, 4, 6, 4);
        rightarmBS2.setPos(-8F, 5F, 0F);
        rightarmBS2.setTexSize(64, 32);
        rightarmBS2.mirror = true;
        setRotation(rightarmBS2, 0F, 0F, 0F);
        rightarmTS1 = new ModelRenderer(this, 28, 16);
        rightarmTS1.addBox(-6F, -1F, -2F, 7, 3, 4);
        rightarmTS1.setPos(-8F, -7F, 0F);
        rightarmTS1.setTexSize(64, 32);
        rightarmTS1.mirror = true;
        setRotation(rightarmTS1, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, -8F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        ear2 = new ModelRenderer(this, 34, 0);
        ear2.addBox(-6F, -8F, -4F, 2, 3, 8);
        ear2.setPos(0F, -12F, -5F);
        ear2.setTexSize(64, 32);
        ear2.mirror = true;
        setRotation(ear2, -0.8179294F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(5F, 12F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightfoot = new ModelRenderer(this, 0, 16);
        rightfoot.addBox(-4F, 9F, -4F, 8, 3, 8);
        rightfoot.setPos(-5F, 12F, 0F);
        rightfoot.setTexSize(64, 32);
        rightfoot.mirror = true;
        setRotation(rightfoot, 0F, 0F, 0F);
        rightlegpart = new ModelRenderer(this, 0, 16);
        rightlegpart.addBox(-3F, 1F, -3F, 6, 3, 6);
        rightlegpart.setPos(-5F, 12F, 0F);
        rightlegpart.setTexSize(64, 32);
        rightlegpart.mirror = true;
        setRotation(rightlegpart, 0F, 0F, 0F);
        rightlegpart2 = new ModelRenderer(this, 0, 16);
        rightlegpart2.addBox(-3F, 5F, -3F, 6, 3, 6);
        rightlegpart2.setPos(-5F, 12F, 0F);
        rightlegpart2.setTexSize(64, 32);
        rightlegpart2.mirror = true;
        setRotation(rightlegpart2, 0F, 0F, 0F);
        leftfoot = new ModelRenderer(this, 0, 16);
        leftfoot.addBox(-4F, 9F, -4F, 8, 3, 8);
        leftfoot.setPos(5F, 12F, 0F);
        leftfoot.setTexSize(64, 32);
        leftfoot.mirror = true;
        setRotation(leftfoot, 0F, 0F, 0F);
        leftlegpart2 = new ModelRenderer(this, 0, 16);
        leftlegpart2.addBox(-3F, 5F, -3F, 6, 3, 6);
        leftlegpart2.setPos(5F, 12F, 0F);
        leftlegpart2.setTexSize(64, 32);
        leftlegpart2.mirror = true;
        setRotation(leftlegpart2, 0F, 0F, 0F);
        leftlegpart1 = new ModelRenderer(this, 0, 16);
        leftlegpart1.addBox(-3F, 1F, -3F, 6, 3, 6);
        leftlegpart1.setPos(5F, 12F, 0F);
        leftlegpart1.setTexSize(64, 32);
        leftlegpart1.mirror = true;
        setRotation(leftlegpart1, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float var1, float var2, float var3, float var4, float var5) {
        this.head.yRot = var4 / (180F / (float) Math.PI);
        this.head.xRot = var5 / (180F / (float) Math.PI);
        this.ear1.yRot = var4 / (180F / (float) Math.PI);
        this.ear1.xRot = var5 / (180F / (float) Math.PI);
        this.ear2.yRot = var4 / (180F / (float) Math.PI);
        this.ear2.xRot = var5 / (180F / (float) Math.PI);

        this.rightarmBS1.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;
        this.rightarmBS2.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;
        this.rightarmTS1.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;
        this.rightarmTS2.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;

        this.leftarmBS1.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmBS2.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmTS1.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmTS2.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;

        this.rightarmBS1.zRot = 0.0F;
        this.rightarmBS2.zRot = 0.0F;
        this.rightarmTS1.zRot = 0.0F;
        this.rightarmTS2.zRot = 0.0F;

        this.leftarmBS1.zRot = 0.0F;
        this.leftarmBS2.zRot = 0.0F;
        this.leftarmTS1.zRot = 0.0F;
        this.leftarmTS2.zRot = 0.0F;

        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightlegpart.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightlegpart2.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightfoot.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

        this.leftleg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftlegpart1.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftlegpart2.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftfoot.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;

        this.rightleg.yRot = 0.0F;
        this.rightlegpart.yRot = 0.0F;
        this.rightlegpart2.yRot = 0.0F;
        this.rightfoot.yRot = 0.0F;

        this.leftleg.yRot = 0.0F;
        this.leftlegpart1.yRot = 0.0F;
        this.leftlegpart2.yRot = 0.0F;
        this.leftfoot.yRot = 0.0F;

        this.rightarmBS1.yRot = 0.0F;
        this.rightarmBS2.yRot = 0.0F;
        this.rightarmTS1.yRot = 0.0F;
        this.rightarmTS2.yRot = 0.0F;

        this.leftarmBS1.yRot = 0.0F;
        this.leftarmBS2.yRot = 0.0F;
        this.leftarmTS2.yRot = 0.0F;
        this.leftarmTS1.yRot = 0.0F;

        this.rightarmBS1.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmBS2.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmBS1.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmBS2.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;

        this.leftarmBS1.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmBS2.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmTS1.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmTS2.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;

        this.rightarmBS1.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmBS2.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmTS1.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmTS2.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;

        this.leftarmBS1.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmBS2.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmTS1.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmTS2.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(ear1, leftarmBS1, rightleg, body, body2, body3, body4, leftarmBS2, leftarmTS1, leftarmTS2,
                rightarmTS2, rightarmBS1, rightarmBS2, rightarmTS1, head, ear2, leftleg, rightfoot, rightlegpart,
                rightlegpart2, leftfoot, leftlegpart2, leftlegpart1);
    }


    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }



    @Override
    public void translateToHand(HandSide sideIn, MatrixStack matrixStackIn) {
        this.getArmForSide(sideIn).translateAndRotate(matrixStackIn);
    }
    protected ModelRenderer getArmForSide(HandSide side) {
        return side == HandSide.LEFT ? this.leftarmTS1 : this.rightarmTS1;
    }
}
