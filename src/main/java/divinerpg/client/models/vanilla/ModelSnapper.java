package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSnapper<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer body;
    ModelRenderer shell;
    ModelRenderer head;
    ModelRenderer shell2;
    ModelRenderer shell3;

    public ModelSnapper() {
        texWidth = 128;
        texHeight = 64;

        leg1 = new ModelRenderer(this, 0, 0);
        leg1.addBox(0F, 0F, -1F, 2, 4, 2);
        leg1.setPos(-5.5F, 20F, -5F);
        leg1.setTexSize(128, 64);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 0);
        leg2.addBox(0F, 0F, -1F, 2, 4, 2);
        leg2.setPos(-5.5F, 20F, 5F);
        leg2.setTexSize(128, 64);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 0);
        leg3.addBox(0F, 0F, -1F, 2, 4, 2);
        leg3.setPos(3.5F, 20F, -5F);
        leg3.setTexSize(128, 64);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 0);
        leg4.addBox(0F, 0F, -1F, 2, 4, 2);
        leg4.setPos(3.5F, 20F, 5F);
        leg4.setTexSize(128, 64);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 10, 3, 15);
        body.setPos(-5F, 17F, -7F);
        body.setTexSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        shell = new ModelRenderer(this, 0, 46);
        shell.addBox(0F, 0F, 0F, 11, 3, 15);
        shell.setPos(-5.5F, 16F, -6.5F);
        shell.setTexSize(128, 64);
        shell.mirror = true;
        setRotation(shell, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 40);
        head.addBox(-1F, -4F, -1F, 2, 4, 2);
        head.setPos(0F, 19F, -6F);
        head.setTexSize(128, 64);
        head.mirror = true;
        setRotation(head, 1.308997F, 0F, 0F);
        shell2 = new ModelRenderer(this, 84, 49);
        shell2.addBox(0F, 0F, 0F, 9, 1, 13);
        shell2.setPos(-4.5F, 15F, -5F);
        shell2.setTexSize(128, 64);
        shell2.mirror = true;
        setRotation(shell2, 0F, 0F, 0F);
        shell3 = new ModelRenderer(this, 52, 52);
        shell3.addBox(0F, 0F, 0F, 7, 1, 11);
        shell3.setPos(-3.5F, 14F, -4F);
        shell3.setTexSize(128, 64);
        shell3.mirror = true;
        setRotation(shell3, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float f2, float f3, float f4) {
        this.leg1.xRot = MathHelper.cos(f * 0.6662F) * f1;
        this.leg3.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.leg2.xRot = MathHelper.cos(f * 0.6662F) * f1;
        this.leg4.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;

        this.head.yRot = 0.75f * f3 / (180F / (float) Math.PI);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(leg1, leg2, leg3, leg4, body, shell, head, shell2, shell3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
