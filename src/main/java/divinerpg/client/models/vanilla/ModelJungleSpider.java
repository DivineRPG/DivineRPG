package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelJungleSpider<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer Headp1;
    ModelRenderer Body;
    ModelRenderer RearEnd;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg7;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer Head;
    ModelRenderer Headp2;
    ModelRenderer Headp3;
    ModelRenderer Headp4;
    ModelRenderer Headp5;
    ModelRenderer Headp6;
    ModelRenderer RearBump2;
    ModelRenderer RearBump1;

    public ModelJungleSpider() {
        texWidth = 64;
        texHeight = 32;

        Headp1 = new ModelRenderer(this, 32, 16);
        Headp1.addBox(4F, -15F, -5F, 1, 4, 2);
        Headp1.setPos(0F, 14F, -3F);
        Headp1.setTexSize(64, 32);
        Headp1.mirror = true;
        setRotation(Headp1, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 0, 0);
        Body.addBox(-3F, -3F, -3F, 6, 6, 6);
        Body.setPos(0F, 16F, 0F);
        Body.setTexSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        RearEnd = new ModelRenderer(this, 14, 12);
        RearEnd.addBox(-5F, -6F, -6F, 4, 2, 4);
        RearEnd.setPos(3F, 16F, 15F);
        RearEnd.setTexSize(64, 32);
        RearEnd.mirror = true;
        setRotation(RearEnd, 0F, 0F, 0F);
        Leg8 = new ModelRenderer(this, 18, 0);
        Leg8.addBox(-1F, -1F, -1F, 16, 2, 2);
        Leg8.setPos(4F, 16F, -1F);
        Leg8.setTexSize(64, 32);
        Leg8.mirror = true;
        setRotation(Leg8, 0F, 0.5759587F, 0.1919862F);
        Leg6 = new ModelRenderer(this, 18, 0);
        Leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
        Leg6.setPos(4F, 16F, 0F);
        Leg6.setTexSize(64, 32);
        Leg6.mirror = true;
        setRotation(Leg6, 0F, 0.2792527F, 0.1919862F);
        Leg4 = new ModelRenderer(this, 18, 0);
        Leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
        Leg4.setPos(4F, 16F, 1F);
        Leg4.setTexSize(64, 32);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, -0.2792527F, 0.1919862F);
        Leg2 = new ModelRenderer(this, 18, 0);
        Leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
        Leg2.setPos(4F, 16F, 2F);
        Leg2.setTexSize(64, 32);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, -0.5759587F, 0.1919862F);
        Leg7 = new ModelRenderer(this, 18, 0);
        Leg7.addBox(-15F, -1F, -1F, 16, 2, 2);
        Leg7.setPos(-4F, 16F, -1F);
        Leg7.setTexSize(64, 32);
        Leg7.mirror = true;
        setRotation(Leg7, 0F, -0.5759587F, -0.1919862F);
        Leg5 = new ModelRenderer(this, 18, 0);
        Leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
        Leg5.setPos(-4F, 16F, 0F);
        Leg5.setTexSize(64, 32);
        Leg5.mirror = true;
        setRotation(Leg5, 0F, -0.2792527F, -0.1919862F);
        Leg3 = new ModelRenderer(this, 18, 0);
        Leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
        Leg3.setPos(-4F, 16F, 1F);
        Leg3.setTexSize(64, 32);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0.2792527F, -0.1919862F);
        Leg1 = new ModelRenderer(this, 18, 0);
        Leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
        Leg1.setPos(-4F, 16F, 2F);
        Leg1.setTexSize(64, 32);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0.5759587F, -0.1919862F);
        Head = new ModelRenderer(this, 32, 4);
        Head.addBox(-4F, -4F, -8F, 8, 8, 8);
        Head.setPos(0F, 16F, -3F);
        Head.setTexSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Headp2 = new ModelRenderer(this, 25, 19);
        Headp2.addBox(2F, -11F, -3F, 1, 2, 5);
        Headp2.setPos(0F, 12F, -10F);
        Headp2.setTexSize(64, 32);
        Headp2.mirror = true;
        setRotation(Headp2, 0F, 0F, 0F);
        Headp3 = new ModelRenderer(this, 32, 16);
        Headp3.addBox(-5F, -15F, -5F, 1, 4, 2);
        Headp3.setPos(0F, 14F, -3F);
        Headp3.setTexSize(64, 32);
        Headp3.mirror = true;
        setRotation(Headp3, 0F, 0F, 0F);
        Headp4 = new ModelRenderer(this, 25, 19);
        Headp4.addBox(-3F, -11F, -3F, 1, 2, 5);
        Headp4.setPos(0F, 12F, -10F);
        Headp4.setTexSize(64, 32);
        Headp4.mirror = true;
        setRotation(Headp4, 0F, 0F, 0F);
        Headp5 = new ModelRenderer(this, 25, 19);
        Headp5.addBox(4F, -11F, -3F, 1, 2, 5);
        Headp5.setPos(0F, 12F, -10F);
        Headp5.setTexSize(64, 32);
        Headp5.mirror = true;
        setRotation(Headp5, 0F, 0F, 0F);
        Headp6 = new ModelRenderer(this, 25, 19);
        Headp6.addBox(-5F, -11F, -3F, 1, 2, 5);
        Headp6.setPos(0F, 12F, -10F);
        Headp6.setTexSize(64, 32);
        Headp6.mirror = true;
        setRotation(Headp6, 0F, 0F, 0F);
        RearBump2 = new ModelRenderer(this, 0, 12);
        RearBump2.addBox(-5F, -4F, -6F, 10, 8, 12);
        RearBump2.setPos(0F, 16F, 9F);
        RearBump2.setTexSize(64, 32);
        RearBump2.mirror = true;
        setRotation(RearBump2, 0F, 0F, 0F);
        RearBump1 = new ModelRenderer(this, 14, 12);
        RearBump1.addBox(-5F, -6F, -6F, 4, 2, 4);
        RearBump1.setPos(3F, 16F, 9F);
        RearBump1.setTexSize(64, 32);
        RearBump1.mirror = true;
        setRotation(RearBump1, 0F, 0F, 0F);
        Head.addChild(Headp1);
        Head.addChild(Headp2);
        Head.addChild(Headp3);
        Head.addChild(Headp4);
        Head.addChild(Headp5);
        Head.addChild(Headp6);
    }

    @Override
    public void setupAnim(T entityIn, float par1, float par2, float par3, float par4, float par5) {
        this.Head.yRot = par4 / (180F / (float) Math.PI);
        this.Head.xRot = par5 / (180F / (float) Math.PI);

        float var8 = ((float) Math.PI / 4F);
        this.Leg1.zRot = -var8;
        this.Leg2.zRot = var8;
        this.Leg3.zRot = -var8 * 0.74F;
        this.Leg4.zRot = var8 * 0.74F;
        this.Leg5.zRot = -var8 * 0.74F;
        this.Leg6.zRot = var8 * 0.74F;
        this.Leg7.zRot = -var8;
        this.Leg8.zRot = var8;
        float var9 = -0.0F;
        float var10 = 0.3926991F;
        this.Leg1.yRot = var10 * 2.0F + var9;
        this.Leg2.yRot = -var10 * 2.0F - var9;
        this.Leg3.yRot = var10 * 1.0F + var9;
        this.Leg4.yRot = -var10 * 1.0F - var9;
        this.Leg5.yRot = -var10 * 1.0F + var9;
        this.Leg6.yRot = var10 * 1.0F - var9;
        this.Leg7.yRot = -var10 * 2.0F + var9;
        this.Leg8.yRot = var10 * 2.0F - var9;
        float var11 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * par2;
        float var12 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * par2;
        float var13 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * par2;
        float var14 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * par2;
        float var15 = Math.abs(MathHelper.sin(par1 * 0.6662F + 0.0F) * 0.4F) * par2;
        float var16 = Math.abs(MathHelper.sin(par1 * 0.6662F + (float) Math.PI) * 0.4F) * par2;
        float var17 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * par2;
        float var18 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * par2;
        this.Leg1.yRot += var11;
        this.Leg2.yRot += -var11;
        this.Leg3.yRot += var12;
        this.Leg4.yRot += -var12;
        this.Leg5.yRot += var13;
        this.Leg6.yRot += -var13;
        this.Leg7.yRot += var14;
        this.Leg8.yRot += -var14;
        this.Leg1.zRot += var15;
        this.Leg2.zRot += -var15;
        this.Leg3.zRot += var16;
        this.Leg4.zRot += -var16;
        this.Leg5.zRot += var17;
        this.Leg6.zRot += -var17;
        this.Leg7.zRot += var18;
        this.Leg8.zRot += -var18;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Body, RearEnd, Leg8, Leg6, Leg4, Leg2, Leg7, Leg5, Leg3, Leg1, Head, RearBump2, RearBump1);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }


}
