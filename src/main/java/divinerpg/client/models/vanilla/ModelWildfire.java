package divinerpg.client.models.vanilla;

import com.google.common.collect.*;
import com.mojang.blaze3d.matrix.*;
import divinerpg.entities.vanilla.nether.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelWildfire<T extends EntityWildfire> extends SegmentedModel<T> implements IHasArm {

    public boolean isHolding;
    public ItemStack itemStack;
    // fields
    public ModelRenderer P1;
    public ModelRenderer P2;
    public ModelRenderer P3;
    public ModelRenderer leftarm;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer P4;
    public ModelRenderer P5;
    public ModelRenderer P6;
    public ModelRenderer P7;
    public ModelRenderer P8;
    public ModelRenderer rightarm;
    public ModelRenderer P9;
    public ModelRenderer P10;
    public ModelRenderer P11;
    public ModelRenderer P12;
    public ModelRenderer P13;
    public ModelRenderer P14;
    public ModelRenderer P15;
    public ModelRenderer P16;
    public ModelRenderer P17;

    public ModelWildfire() {
        texWidth = 64;
        texHeight = 32;

        P1 = new ModelRenderer(this, 32, 17);
        P1.addBox(-4F, -13F, -1F, 2, 8, 2);
        P1.setPos(6F, -6F, 9F);
        P1.setTexSize(64, 32);
        P1.mirror = true;
        setRotation(P1, 0.7853982F, 0F, 0F);
        P2 = new ModelRenderer(this, 16, 16);
        P2.addBox(-4F, 0F, -2F, 5, 12, 4);
        P2.setPos(4F, 0F, 0F);
        P2.setTexSize(64, 32);
        P2.mirror = true;
        setRotation(P2, 0F, 0F, 0F);
        P3 = new ModelRenderer(this, 40, 16);
        P3.addBox(-1F, -3F, -2F, 2, 4, 6);
        P3.setPos(5F, -1F, -1F);
        P3.setTexSize(64, 32);
        P3.mirror = true;
        setRotation(P3, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(7F, 2F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-3F, 12F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(3F, 12F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        P4 = new ModelRenderer(this, 43, 18);
        P4.addBox(1F, -2F, -2F, 1, 2, 4);
        P4.setPos(4F, 2F, 0F);
        P4.setTexSize(64, 32);
        P4.mirror = true;
        setRotation(P4, 0F, 0F, 0F);
        P5 = new ModelRenderer(this, 40, 16);
        P5.addBox(-2F, -3F, -2F, 6, 2, 4);
        P5.setPos(7F, 1F, 0F);
        P5.setTexSize(64, 32);
        P5.mirror = true;
        setRotation(P5, 0F, 0F, 0F);
        P6 = new ModelRenderer(this, 40, 16);
        P6.addBox(-2F, -3F, -2F, 6, 2, 4);
        P6.setPos(-9F, 1F, 0F);
        P6.setTexSize(64, 32);
        P6.mirror = true;
        setRotation(P6, 0F, 0F, 0F);
        P7 = new ModelRenderer(this, 40, 16);
        P7.addBox(-1F, -3F, -2F, 2, 4, 6);
        P7.setPos(-5F, -1F, -1F);
        P7.setTexSize(64, 32);
        P7.mirror = true;
        setRotation(P7, 0F, 0F, 0F);
        P8 = new ModelRenderer(this, 43, 18);
        P8.addBox(1F, -2F, -2F, 1, 2, 4);
        P8.setPos(-7F, 2F, 0F);
        P8.setTexSize(64, 32);
        P8.mirror = true;
        setRotation(P8, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-7F, 2F, 0F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        P9 = new ModelRenderer(this, 23, 19);
        P9.addBox(-3F, -2F, -2F, 3, 9, 2);
        P9.setPos(-10F, -1F, 1F);
        P9.setTexSize(64, 32);
        P9.mirror = true;
        setRotation(P9, 0F, 0F, 2.530727F);
        P10 = new ModelRenderer(this, 23, 19);
        P10.addBox(-3F, -2F, -2F, 3, 9, 2);
        P10.setPos(8F, -3F, 1F);
        P10.setTexSize(64, 32);
        P10.mirror = true;
        setRotation(P10, 0F, 0F, -2.530727F);
        P11 = new ModelRenderer(this, 32, 0);
        P11.addBox(-3F, -8F, -4F, 6, 12, 6);
        P11.setPos(0F, 1F, 0F);
        P11.setTexSize(64, 32);
        P11.mirror = true;
        setRotation(P11, -0.3490659F, 0F, 0F);
        P12 = new ModelRenderer(this, 32, 17);
        P12.addBox(-4F, -13F, -1F, 2, 8, 2);
        P12.setPos(0F, -6F, 9F);
        P12.setTexSize(64, 32);
        P12.mirror = true;
        setRotation(P12, 0.7853982F, 0F, 0F);
        P13 = new ModelRenderer(this, 19, 22);
        P13.addBox(-5F, -14F, -1F, 4, 4, 4);
        P13.setPos(6F, 1F, -1F);
        P13.setTexSize(64, 32);
        P13.mirror = true;
        setRotation(P13, -0.3490659F, 0F, 0F);
        P14 = new ModelRenderer(this, 19, 22);
        P14.addBox(-5F, -14F, -1F, 4, 4, 4);
        P14.setPos(0F, 1F, -1F);
        P14.setTexSize(64, 32);
        P14.mirror = true;
        setRotation(P14, -0.3490659F, 0F, 0F);
        P15 = new ModelRenderer(this, 32, 17);
        P15.addBox(-4F, -13F, -1F, 2, 8, 2);
        P15.setPos(0F, 2F, 0F);
        P15.setTexSize(64, 32);
        P15.mirror = true;
        setRotation(P15, -0.3490659F, 0F, 0F);
        P16 = new ModelRenderer(this, 32, 17);
        P16.addBox(-4F, -13F, -1F, 2, 8, 2);
        P16.setPos(6F, 2F, 0F);
        P16.setTexSize(64, 32);
        P16.mirror = true;
        setRotation(P16, -0.3490659F, 0F, 0F);
        P17 = new ModelRenderer(this, 16, 16);
        P17.addBox(-4F, 0F, -2F, 5, 12, 4);
        P17.setPos(-1F, 0F, 0F);
        P17.setTexSize(64, 32);
        P17.mirror = true;
        setRotation(P17, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float var1, float var2, float var3, float var4, float var5) {
        this.rightarm.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.xRot = MathHelper.cos(var1 * 0.6662F + (float) Math.PI) * 1.4F * var2;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
        this.rightarm.yRot = 0.0F;
        this.leftarm.yRot = 0.0F;
        this.rightarm.zRot += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.zRot -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarm.xRot += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarm.xRot -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(P1, P2, P3, leftarm, rightleg, leftleg, P4, P5, P6, P7, P8, rightarm,
                P9, P10, P11, P12, P13, P14, P15, P16, P17);
    }

    @Override
    public void prepareMobModel(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		if (entitylivingbaseIn instanceof EntityWildfire) {
			EntityWildfire mobDarkenedKnight = (EntityWildfire) entitylivingbaseIn;
			isHolding = mobDarkenedKnight.getMainArm() != null
			        || !mobDarkenedKnight.getMainHandItem().isEmpty();
		}
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
        return side == HandSide.LEFT ? this.leftarm : this.rightarm;
    }
}
