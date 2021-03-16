package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelCrabOld<T extends Entity> extends SegmentedModel<T> {

    ModelRenderer RearEnd;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg7;
    ModelRenderer Leg5;
    ModelRenderer Leg3;

    public ModelCrabOld() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.RearEnd = new ModelRenderer(this, 0, 12);
        this.RearEnd.addBox(-5.0F, -4.0F, -6.0F, 12, 8, 12);
        this.RearEnd.setPos(-1.0F, 16.0F, 0.0F);
        this.RearEnd.setTexSize(64, 32);
        this.RearEnd.mirror = true;
        this.setRotation(this.RearEnd, 0.0F, 0.0F, 0.0F);
        this.Leg8 = new ModelRenderer(this, 18, 0);
        this.Leg8.addBox(-1.0F, -1.0F, -1.0F, 16, 4, 4);
        this.Leg8.setPos(4.0F, 16.0F, -4.0F);
        this.Leg8.setTexSize(64, 32);
        this.Leg8.mirror = true;
        this.setRotation(this.Leg8, 0.0F, 0.5759587F, -0.1396263F);
        this.Leg6 = new ModelRenderer(this, 18, 0);
        this.Leg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
        this.Leg6.setPos(4.0F, 16.0F, 0.0F);
        this.Leg6.setTexSize(64, 32);
        this.Leg6.mirror = true;
        this.setRotation(this.Leg6, 0.0F, 0.2792527F, 0.1919862F);
        this.Leg4 = new ModelRenderer(this, 18, 0);
        this.Leg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2);
        this.Leg4.setPos(4.0F, 16.0F, 1.0F);
        this.Leg4.setTexSize(64, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0F, -0.2792527F, 0.1919862F);
        this.Leg7 = new ModelRenderer(this, 18, 0);
        this.Leg7.addBox(-15.0F, -1.0F, -1.0F, 16, 4, 4);
        this.Leg7.setPos(-4.0F, 16.0F, -4.0F);
        this.Leg7.setTexSize(64, 32);
        this.Leg7.mirror = true;
        this.setRotation(this.Leg7, 0.0F, -0.5759587F, 0.1396263F);
        this.Leg5 = new ModelRenderer(this, 18, 0);
        this.Leg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
        this.Leg5.setPos(-4.0F, 16.0F, 0.0F);
        this.Leg5.setTexSize(64, 32);
        this.Leg5.mirror = true;
        this.setRotation(this.Leg5, 0.0F, -0.2792527F, -0.1919862F);
        this.Leg3 = new ModelRenderer(this, 18, 0);
        this.Leg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2);
        this.Leg3.setPos(-4.0F, 16.0F, 1.0F);
        this.Leg3.setTexSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0F, 0.2792527F, -0.1919862F);
    }

    @Override
    public void setupAnim(T entityIn, float var1, float var2, float var3, float var4, float var5) {
        float var7 = ((float) Math.PI / 4F);
        this.Leg3.zRot = -var7 * 0.74F;
        this.Leg4.zRot = var7 * 0.74F;
        this.Leg5.zRot = -var7 * 0.74F;
        this.Leg6.zRot = var7 * 0.74F;
        this.Leg7.zRot = -var7;
        this.Leg8.zRot = var7;
        float var8 = -0.0F;
        float var9 = 0.3926991F;
        this.Leg3.yRot = var9 * 1.0F + var8;
        this.Leg4.yRot = -var9 * 1.0F - var8;
        this.Leg5.yRot = -var9 * 1.0F + var8;
        this.Leg6.yRot = var9 * 1.0F - var8;
        this.Leg7.yRot = -var9 * 2.0F + var8;
        this.Leg8.yRot = var9 * 2.0F - var8;
        float var10 = -(MathHelper.cos(var1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * var2;
        float var11 = -(MathHelper.cos(var1 * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * var2;
        float var12 = -(MathHelper.cos(var1 * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * var2;
        float var13 = -(MathHelper.cos(var1 * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * var2;
        float var14 = Math.abs(MathHelper.sin(var1 * 0.6662F + 0.0F) * 0.4F) * var2;
        float var15 = Math.abs(MathHelper.sin(var1 * 0.6662F + (float) Math.PI) * 0.4F) * var2;
        float var16 = Math.abs(MathHelper.sin(var1 * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * var2;
        float var17 = Math.abs(MathHelper.sin(var1 * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * var2;
        this.Leg3.yRot += var11;
        this.Leg4.yRot += -var11;
        this.Leg5.yRot += var12;
        this.Leg6.yRot += -var12;
        this.Leg7.yRot += var13;
        this.Leg8.yRot += -var13;
        this.Leg3.zRot += var15;
        this.Leg4.zRot += -var15;
        this.Leg5.zRot += var16;
        this.Leg6.zRot += -var16;
        this.Leg7.zRot += var17;
        this.Leg8.zRot += -var17;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(RearEnd, Leg8, Leg6, Leg4, Leg7, Leg5, Leg3);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }

}
