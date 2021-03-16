package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelDensos<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer head;
    ModelRenderer body;
    public ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head1;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head4;

    public ModelDensos()
    {
        this.texWidth = 64;
        this.texHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-11.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setPos(1.0F, 0.0F, 0.0F);
        this.head.setTexSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
        this.body.setPos(0.0F, 0.0F, 0.0F);
        this.body.setTexSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 40, 4);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 18, 4);
        this.rightarm.setPos(-5.0F, 2.0F, 0.0F);
        this.rightarm.setTexSize(64, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 40, 1);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 18, 4);
        this.leftarm.setPos(5.0F, 2.0F, 0.0F);
        this.leftarm.setTexSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
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
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.head1.setPos(1.466667F, -8.0F, -4.0F);
        this.head1.setTexSize(64, 32);
        this.head1.mirror = true;
        this.setRotation(this.head1, 0.0F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 0);
        this.head2.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.head2.setPos(6.0F, -16.0F, -3.0F);
        this.head2.setTexSize(64, 32);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0F, 0.0F, 0.0F);
        this.head3 = new ModelRenderer(this, 0, 0);
        this.head3.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.head3.setPos(-15.0F, -16.0F, -3.0F);
        this.head3.setTexSize(64, 32);
        this.head3.mirror = true;
        this.setRotation(this.head3, 0.0F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 0, 0);
        this.head4.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.head4.setPos(-4.0F, -16.0F, -3.0F);
        this.head4.setTexSize(64, 32);
        this.head4.mirror = true;
        this.setRotation(this.head4, 0.0F, 0.0F, 0.0F);
    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, rightarm, leftarm, rightleg, leftleg, head1, head2, head3, head4);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }

    @Override
    public void setupAnim(T ent, float var1, float var2, float var3, float var4, float var5)
    {
        this.head.yRot = var4 / (180F / (float)Math.PI);
        this.head.xRot = var5 / (180F / (float)Math.PI);
        this.head1.yRot = var4 / (180F / (float)Math.PI);
        this.head1.xRot = var5 / (180F / (float)Math.PI);
        this.head2.yRot = var4 / (180F / (float)Math.PI);
        this.head2.xRot = var5 / (180F / (float)Math.PI);
        this.head3.yRot = var4 / (180F / (float)Math.PI);
        this.head3.xRot = var5 / (180F / (float)Math.PI);
        this.head4.yRot = var4 / (180F / (float)Math.PI);
        this.head4.xRot = var5 / (180F / (float)Math.PI);
        this.rightarm.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
    }
}
