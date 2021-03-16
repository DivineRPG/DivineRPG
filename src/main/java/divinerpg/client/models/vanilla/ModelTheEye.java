package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTheEye<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer ear1;
    ModelRenderer body1;
    ModelRenderer ext1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer leftbackfoot;
    ModelRenderer eye1;
    ModelRenderer cap1;
    ModelRenderer leftbackleg;
    ModelRenderer leftfrontfoot;
    ModelRenderer leftfrontleg;
    ModelRenderer eye2;
    ModelRenderer ext2;
    ModelRenderer cap2;
    ModelRenderer rightbackfoot;
    ModelRenderer rightbackleg;
    ModelRenderer ext3;
    ModelRenderer eye3;
    ModelRenderer cap3;
    ModelRenderer ext4;
    ModelRenderer cap4;
    ModelRenderer eye4;
    ModelRenderer rightfrontleg;
    ModelRenderer rightfrontfoot;
    ModelRenderer head;
    ModelRenderer ear2;
    ModelRenderer ear3;
    ModelRenderer ear4;

    public ModelTheEye() {
        texWidth = 64;
        texHeight = 32;

        ear1 = new ModelRenderer(this, 0, 22);
        ear1.addBox(4F, -4F, 6F, 1, 2, 7);
        ear1.setPos(0F, 1F, 0F);
        ear1.setTexSize(64, 32);
        ear1.mirror = true;
        setRotation(ear1, 1.047198F, 0F, 0F);
        body1 = new ModelRenderer(this, 32, 12);
        body1.addBox(-4F, 0F, -2F, 8, 12, 8);
        body1.setPos(-4F, 0F, -6F);
        body1.setTexSize(64, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        ext1 = new ModelRenderer(this, 24, 0);
        ext1.addBox(-2F, -2F, -2F, 4, 2, 8);
        ext1.setPos(10F, 12F, 9F);
        ext1.setTexSize(64, 32);
        ext1.mirror = true;
        setRotation(ext1, 0F, 0.7853982F, 0F);
        body2 = new ModelRenderer(this, 32, 12);
        body2.addBox(-4F, 0F, -2F, 8, 12, 8);
        body2.setPos(-4F, 0F, 2F);
        body2.setTexSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 32, 12);
        body3.addBox(-4F, 0F, -2F, 8, 12, 8);
        body3.setPos(4F, 0F, -6F);
        body3.setTexSize(64, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        body4 = new ModelRenderer(this, 32, 12);
        body4.addBox(-4F, 0F, -2F, 8, 12, 8);
        body4.setPos(4F, 0F, 2F);
        body4.setTexSize(64, 32);
        body4.mirror = true;
        setRotation(body4, 0F, 0F, 0F);
        leftbackfoot = new ModelRenderer(this, 0, 24);
        leftbackfoot.addBox(-3F, 10F, -3F, 6, 2, 6);
        leftbackfoot.setPos(14F, 12F, 13F);
        leftbackfoot.setTexSize(64, 32);
        leftbackfoot.mirror = true;
        setRotation(leftbackfoot, 0F, 0F, 0F);
        eye1 = new ModelRenderer(this, 48, 0);
        eye1.addBox(0F, 0F, 0F, 4, 4, 4);
        eye1.setPos(12F, 8F, 11F);
        eye1.setTexSize(64, 32);
        eye1.mirror = true;
        setRotation(eye1, 0F, 0F, 0F);
        cap1 = new ModelRenderer(this, 48, 0);
        cap1.addBox(0F, 0F, 0F, 4, 4, 4);
        cap1.setPos(7F, 8F, 6F);
        cap1.setTexSize(64, 32);
        cap1.mirror = true;
        setRotation(cap1, 0F, 0F, 0F);
        leftbackleg = new ModelRenderer(this, 0, 16);
        leftbackleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftbackleg.setPos(14F, 12F, 13F);
        leftbackleg.setTexSize(64, 32);
        leftbackleg.mirror = true;
        setRotation(leftbackleg, 0F, 0F, 0F);
        leftfrontfoot = new ModelRenderer(this, 0, 24);
        leftfrontfoot.addBox(-3F, 10F, -3F, 6, 2, 6);
        leftfrontfoot.setPos(14F, 12F, -13F);
        leftfrontfoot.setTexSize(64, 32);
        leftfrontfoot.mirror = true;
        setRotation(leftfrontfoot, 0F, 0F, 0F);
        leftfrontleg = new ModelRenderer(this, 0, 16);
        leftfrontleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftfrontleg.setPos(14F, 12F, -13F);
        leftfrontleg.setTexSize(64, 32);
        leftfrontleg.mirror = true;
        setRotation(leftfrontleg, 0F, 0F, 0F);
        eye2 = new ModelRenderer(this, 48, 0);
        eye2.addBox(0F, 0F, 0F, 4, 4, 4);
        eye2.setPos(12F, 8F, -15F);
        eye2.setTexSize(64, 32);
        eye2.mirror = true;
        setRotation(eye2, 0F, 0F, 0F);
        ext2 = new ModelRenderer(this, 24, 0);
        ext2.addBox(-2F, -2F, -2F, 4, 2, 8);
        ext2.setPos(13F, 12F, -12F);
        ext2.setTexSize(64, 32);
        ext2.mirror = true;
        setRotation(ext2, 0F, -0.7853982F, 0F);
        cap2 = new ModelRenderer(this, 48, 0);
        cap2.addBox(0F, 0F, 0F, 4, 4, 4);
        cap2.setPos(7F, 8F, -10F);
        cap2.setTexSize(64, 32);
        cap2.mirror = true;
        setRotation(cap2, 0F, 0F, 0F);
        rightbackfoot = new ModelRenderer(this, 0, 24);
        rightbackfoot.addBox(-3F, 10F, -3F, 6, 2, 6);
        rightbackfoot.setPos(-13F, 12F, 13F);
        rightbackfoot.setTexSize(64, 32);
        rightbackfoot.mirror = true;
        setRotation(rightbackfoot, 0F, 0F, 0F);
        rightbackleg = new ModelRenderer(this, 0, 16);
        rightbackleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightbackleg.setPos(-13F, 12F, 13F);
        rightbackleg.setTexSize(64, 32);
        rightbackleg.mirror = true;
        setRotation(rightbackleg, 0F, 0F, 0F);
        ext3 = new ModelRenderer(this, 24, 0);
        ext3.addBox(-2F, -2F, -2F, 4, 2, 8);
        ext3.setPos(-9F, 12F, 9F);
        ext3.setTexSize(64, 32);
        ext3.mirror = true;
        setRotation(ext3, 0F, -0.7853982F, 0F);
        eye3 = new ModelRenderer(this, 48, 0);
        eye3.addBox(0F, 0F, 0F, 4, 4, 4);
        eye3.setPos(-15F, 8F, 11F);
        eye3.setTexSize(64, 32);
        eye3.mirror = true;
        setRotation(eye3, 0F, 0F, 0F);
        cap3 = new ModelRenderer(this, 48, 0);
        cap3.addBox(0F, 0F, 0F, 4, 4, 4);
        cap3.setPos(-10F, 8F, 6F);
        cap3.setTexSize(64, 32);
        cap3.mirror = true;
        setRotation(cap3, 0F, 0F, 0F);
        ext4 = new ModelRenderer(this, 24, 0);
        ext4.addBox(-2F, -2F, -2F, 4, 2, 8);
        ext4.setPos(-12F, 12F, -12F);
        ext4.setTexSize(64, 32);
        ext4.mirror = true;
        setRotation(ext4, 0F, 0.7853982F, 0F);
        cap4 = new ModelRenderer(this, 48, 0);
        cap4.addBox(0F, 0F, 0F, 4, 4, 4);
        cap4.setPos(-10F, 8F, -10F);
        cap4.setTexSize(64, 32);
        cap4.mirror = true;
        setRotation(cap4, 0F, 0F, 0F);
        eye4 = new ModelRenderer(this, 48, 0);
        eye4.addBox(0F, 0F, 0F, 4, 4, 4);
        eye4.setPos(-15F, 8F, -15F);
        eye4.setTexSize(64, 32);
        eye4.mirror = true;
        setRotation(eye4, 0F, 0F, 0F);
        rightfrontleg = new ModelRenderer(this, 0, 16);
        rightfrontleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightfrontleg.setPos(-13F, 12F, -13F);
        rightfrontleg.setTexSize(64, 32);
        rightfrontleg.mirror = true;
        setRotation(rightfrontleg, 0F, 0F, 0F);
        rightfrontfoot = new ModelRenderer(this, 0, 24);
        rightfrontfoot.addBox(-3F, 10F, -3F, 6, 2, 6);
        rightfrontfoot.setPos(-13F, 12F, -13F);
        rightfrontfoot.setTexSize(64, 32);
        rightfrontfoot.mirror = true;
        setRotation(rightfrontfoot, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -9F, -4F, 8, 8, 8);
        head.setPos(0F, 1F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        ear2 = new ModelRenderer(this, 0, 22);
        ear2.addBox(4F, -7F, 5F, 1, 2, 7);
        ear2.setPos(0F, 1F, 0F);
        ear2.setTexSize(64, 32);
        ear2.mirror = true;
        setRotation(ear2, 1.047198F, 0F, 0F);
        ear3 = new ModelRenderer(this, 0, 22);
        ear3.addBox(-5F, -4F, 6F, 1, 2, 7);
        ear3.setPos(0F, 1F, 0F);
        ear3.setTexSize(64, 32);
        ear3.mirror = true;
        setRotation(ear3, 1.047198F, 0F, 0F);
        ear4 = new ModelRenderer(this, 0, 22);
        ear4.addBox(-5F, -7F, 5F, 1, 2, 7);
        ear4.setPos(0F, 1F, 0F);
        ear4.setTexSize(64, 32);
        ear4.mirror = true;
        setRotation(ear4, 1.047198F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float var1, float var2, float var3, float var4, float var5) {
        this.head.yRot = var4 / (180F / (float) Math.PI);
        this.head.xRot = var5 / (180F / (float) Math.PI);
        this.ear1.yRot = var4 / (180F / (float) Math.PI);
        this.ear1.xRot = var5 / (180F / (float) Math.PI);
        this.ear2.yRot = var4 / (180F / (float) Math.PI);
        this.ear2.xRot = var5 / (180F / (float) Math.PI);
        this.ear3.yRot = var4 / (180F / (float) Math.PI);
        this.ear3.xRot = var5 / (180F / (float) Math.PI);
        this.ear4.yRot = var4 / (180F / (float) Math.PI);
        this.ear4.xRot = var5 / (180F / (float) Math.PI);

        this.rightfrontleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightbackleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightfrontfoot.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightbackfoot.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

        this.leftfrontleg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftbackleg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftfrontfoot.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftbackfoot.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;

        this.rightfrontleg.yRot = 0.0F;
        this.rightbackleg.yRot = 0.0F;
        this.rightfrontfoot.yRot = 0.0F;
        this.rightbackfoot.yRot = 0.0F;

        this.leftfrontleg.yRot = 0.0F;
        this.leftbackleg.yRot = 0.0F;
        this.leftfrontfoot.yRot = 0.0F;
        this.leftbackfoot.yRot = 0.0F;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(ear1, body1, ext1, body2, body3, body4, leftbackfoot, eye1, cap1, leftbackleg, leftfrontfoot, leftfrontleg, eye2, ext2, cap2, rightbackfoot, rightbackleg,
                ext3, eye3, cap3, ext4, cap4, eye4, rightfrontleg, rightfrontfoot, head, ear2, ear3, ear4);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
