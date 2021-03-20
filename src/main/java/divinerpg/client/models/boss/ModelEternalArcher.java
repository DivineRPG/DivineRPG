package divinerpg.client.models.boss;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelEternalArcher<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer head;
    public ModelRenderer shoulder6;
    public ModelRenderer armRight1, armRight2, armRight3;
    public ModelRenderer armLeft1, armLeft2, armLeft3;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer shoulder1;
    public ModelRenderer shoulder4;
    public ModelRenderer shoulder3;
    public ModelRenderer shoulder2;
    public ModelRenderer shoulder5;

    public ModelEternalArcher() {
        texWidth = 128;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        shoulder6 = new ModelRenderer(this, 41, 1);
        shoulder6.addBox(-4F, 0F, -2F, 10, 3, 4);
        shoulder6.setPos(18F, -6F, 0F);
        shoulder6.setTexSize(128, 32);
        shoulder6.mirror = true;
        setRotation(shoulder6, 0F, 0F, 0F);
        armRight1 = new ModelRenderer(this, 110, 16);
        armRight1.addBox(-3F, -2 - 0.5F, -2F, 4, 12, 4);
        armRight1.setPos(-21F, -1F, 0F);
        armRight1.setTexSize(128, 32);
        armRight1.mirror = true;
        setRotation(armRight1, 0F, 0F, 0F);
        armLeft1 = new ModelRenderer(this, 110, 16);
        armLeft1.addBox(-1F, -2 - 0.5F, -2F, 4, 12, 4);
        armLeft1.setPos(21F, -1F, 0F);
        armLeft1.setTexSize(128, 32);
        armLeft1.mirror = true;
        setRotation(armLeft1, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-3F, 12F, 0F);
        rightleg.setTexSize(128, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(3F, 12F, 0F);
        leftleg.setTexSize(128, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        armRight2 = new ModelRenderer(this, 71, 16);
        armRight2.addBox(-3F, -2 - 0.5F, -2F, 4, 12, 4);
        armRight2.setPos(-7F, 5F, 0F);
        armRight2.setTexSize(128, 32);
        armRight2.mirror = true;
        setRotation(armRight2, 0F, 0F, 0F);
        armLeft2 = new ModelRenderer(this, 71, 16);
        armLeft2.addBox(-1F, -2 - 0.5F, -2F, 4, 12, 4);
        armLeft2.setPos(7F, 5F, 0F);
        armLeft2.setTexSize(128, 32);
        armLeft2.mirror = true;
        setRotation(armLeft2, 0F, 0F, 0F);
        armLeft3 = new ModelRenderer(this, 91, 16);
        armLeft3.addBox(-1F, -2 - 0.5F, -2F, 4, 12, 4);
        armLeft3.setPos(14F, 2F, 0F);
        armLeft3.setTexSize(128, 32);
        armLeft3.mirror = true;
        setRotation(armLeft3, 0F, 0F, 0F);
        armRight3 = new ModelRenderer(this, 91, 16);
        armRight3.addBox(-3F, -2 - 0.5F, -2F, 4, 12, 4);
        armRight3.setPos(-14F, 2F, 0F);
        armRight3.setTexSize(128, 32);
        armRight3.mirror = true;
        setRotation(armRight3, 0F, 0F, 0F);
        body = new ModelRenderer(this, 46, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(128, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        shoulder1 = new ModelRenderer(this, 41, 1);
        shoulder1.addBox(-4F, 0F, -2F, 10, 3, 4);
        shoulder1.setPos(-20F, -6F, 0F);
        shoulder1.setTexSize(128, 32);
        shoulder1.mirror = true;
        setRotation(shoulder1, 0F, 0F, 0F);
        shoulder4 = new ModelRenderer(this, 19, 24);
        shoulder4.addBox(-4F, 0F, -2F, 6, 3, 4);
        shoulder4.setPos(8F, 0F, 0F);
        shoulder4.setTexSize(128, 32);
        shoulder4.mirror = true;
        setRotation(shoulder4, 0F, 0F, 0F);
        shoulder3 = new ModelRenderer(this, 19, 24);
        shoulder3.addBox(-4F, 0F, -2F, 6, 3, 4);
        shoulder3.setPos(-6F, 0F, 0F);
        shoulder3.setTexSize(128, 32);
        shoulder3.mirror = true;
        setRotation(shoulder3, 0F, 0F, 0F);
        shoulder2 = new ModelRenderer(this, 17, 16);
        shoulder2.addBox(-4F, 0F, -2F, 10, 3, 4);
        shoulder2.setPos(-13F, -3F, 0F);
        shoulder2.setTexSize(128, 32);
        shoulder2.mirror = true;
        setRotation(shoulder2, 0F, 0F, 0F);
        shoulder5 = new ModelRenderer(this, 17, 16);
        shoulder5.addBox(-4F, 0F, -2F, 10, 3, 4);
        shoulder5.setPos(11F, -3F, 0F);
        shoulder5.setTexSize(128, 32);
        shoulder5.mirror = true;
        setRotation(shoulder5, 0F, 0F, 0F);
    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, shoulder6, rightleg, leftleg, armRight1, armRight2, armRight3, armLeft1, armLeft2, armLeft3,
                body, shoulder1, shoulder4, shoulder3, shoulder2, shoulder5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.rightleg.xRot = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg.xRot = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        armRight1.xRot = 0;
        armRight2.xRot = 0;
        armRight3.xRot = 0;

        armLeft1.xRot = 0;
        armLeft2.xRot = 0;
        armLeft3.xRot = 0;

    }

}
