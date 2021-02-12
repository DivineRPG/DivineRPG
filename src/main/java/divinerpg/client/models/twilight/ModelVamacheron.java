package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelVamacheron<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer Horn;
    ModelRenderer Shape1;
    ModelRenderer head1;
    ModelRenderer horn3;
    ModelRenderer horn4;
    ModelRenderer Horn1;
    ModelRenderer Shape2;

    public ModelVamacheron()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6);
        this.head.setRotationPoint(-6.0F, 4.0F, -8.0F);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 18, 4);
        this.body.addBox(-6.0F, -10.0F, -7.0F, 8, 18, 10);
        this.body.setRotationPoint(2.0F, 5.0F, 2.0F);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leg1.setRotationPoint(-2.0F, 12.0F, 7.0F);
        this.leg1.setTextureSize(64, 32);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leg2.setRotationPoint(2.0F, 12.0F, 7.0F);
        this.leg2.setTextureSize(64, 32);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4);
        this.leg3.setRotationPoint(-2.0F, 12.0F, -5.0F);
        this.leg3.setTextureSize(64, 32);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4);
        this.leg4.setRotationPoint(2.0F, 12.0F, -5.0F);
        this.leg4.setTextureSize(64, 32);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
        this.horn1 = new ModelRenderer(this, 54, 0);
        this.horn1.addBox(-4.0F, -5.0F, -4.0F, 1, 3, 3);
        this.horn1.setRotationPoint(-6.0F, 2.0F, -8.0F);
        this.horn1.setTextureSize(64, 32);
        this.horn1.mirror = true;
        this.setRotation(this.horn1, 0.0F, 0.0F, 0.0F);
        this.horn2 = new ModelRenderer(this, 55, 0);
        this.horn2.addBox(3.0F, -5.0F, -4.0F, 1, 3, 3);
        this.horn2.setRotationPoint(-6.0F, 2.0F, -8.0F);
        this.horn2.setTextureSize(64, 32);
        this.horn2.mirror = true;
        this.setRotation(this.horn2, 0.0F, 0.0F, 0.0F);
        this.Horn = new ModelRenderer(this, 55, 7);
        this.Horn.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2);
        this.Horn.setRotationPoint(-7.0F, 0.0F, -20.0F);
        this.Horn.setTextureSize(64, 32);
        this.Horn.mirror = true;
        this.setRotation(this.Horn, 1.22173F, 0.0F, 0.0F);
        this.Shape1 = new ModelRenderer(this, 9, 0);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape1.setRotationPoint(-7.0F, 3.0F, -15.0F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.addBox(0.0F, 0.0F, 0.0F, 8, 8, 6);
        this.head1.setRotationPoint(2.0F, 0.0F, -14.0F);
        this.head1.setTextureSize(64, 32);
        this.head1.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.horn3 = new ModelRenderer(this, 55, 0);
        this.horn3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3);
        this.horn3.setRotationPoint(2.0F, -3.0F, -12.0F);
        this.horn3.setTextureSize(64, 32);
        this.horn3.mirror = true;
        this.setRotation(this.horn3, 0.0F, 0.0F, 0.0F);
        this.horn4 = new ModelRenderer(this, 55, 0);
        this.horn4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3);
        this.horn4.setRotationPoint(9.0F, -3.0F, -12.0F);
        this.horn4.setTextureSize(64, 32);
        this.horn4.mirror = true;
        this.setRotation(this.horn4, 0.0F, 0.0F, 0.0F);
        this.Horn1 = new ModelRenderer(this, 55, 7);
        this.Horn1.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2);
        this.Horn1.setRotationPoint(5.0F, 0.0F, -20.0F);
        this.Horn1.setTextureSize(64, 32);
        this.Horn1.mirror = true;
        this.setRotation(this.Horn1, 1.22173F, 0.0F, 0.0F);
        this.Shape2 = new ModelRenderer(this, 9, 0);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape2.setRotationPoint(5.0F, 3.0F, -15.0F);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(head, body, leg1, leg2, leg3, leg4, horn1, horn2, Horn, Shape1, head1, horn3, horn4, Horn1, Shape2);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    @Override
    public void setRotationAngles(T e, float var1, float var2, float var3, float var4, float var5)
    {
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leg2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.leg3.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.leg4.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    }
}
