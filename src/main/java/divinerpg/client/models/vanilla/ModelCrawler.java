package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelCrawler<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer earL;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer body;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer body7;
    ModelRenderer body8;
    ModelRenderer head;
    ModelRenderer earR;
    ModelRenderer earL2;
    ModelRenderer earR2;

    public ModelCrawler() {
        texWidth = 64;
        texHeight = 32;

        earL = new ModelRenderer(this, 36, 2);
        earL.addBox(5F, 1F, -8F, 1, 2, 5);
        earL.setPos(-1F, 6F, -8F);
        earL.setTexSize(64, 32);
        earL.mirror = true;
        setRotation(earL, 0F, 0F, 0F);
        rightfoot = new ModelRenderer(this, 28, 16);
        rightfoot.addBox(-4F, 7F, -4F, 6, 4, 6);
        rightfoot.setPos(-3F, 13F, -5F);
        rightfoot.setTexSize(64, 32);
        rightfoot.mirror = true;
        setRotation(rightfoot, 0F, 0F, 0F);
        leftfoot = new ModelRenderer(this, 28, 16);
        leftfoot.addBox(-2F, 7F, -4F, 6, 4, 6);
        leftfoot.setPos(3F, 13F, -5F);
        leftfoot.setTexSize(64, 32);
        leftfoot.mirror = true;
        setRotation(leftfoot, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-1F, 0F, -3F, 4, 7, 4);
        leftleg.setPos(3F, 13F, -5F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-3F, 0F, -3F, 4, 7, 4);
        rightleg.setPos(-3F, 13F, -5F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 19, 16);
        body.addBox(-7F, -6F, -5F, 7, 5, 10);
        body.setPos(7F, 15F, -6F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, -0.4363323F, 0F, 0F);
        body2 = new ModelRenderer(this, 19, 0);
        body2.addBox(-7F, -6F, -5F, 7, 5, 10);
        body2.setPos(0F, 15F, -6F);
        body2.setTexSize(64, 32);
        body2.mirror = true;
        setRotation(body2, -0.4363323F, 0F, 0F);
        body3 = new ModelRenderer(this, 24, 19);
        body3.addBox(-7F, -6F, -5F, 7, 5, 2);
        body3.setPos(0F, 27F, 2F);
        body3.setTexSize(64, 32);
        body3.mirror = true;
        setRotation(body3, -1.570796F, 0F, 0F);
        body4 = new ModelRenderer(this, 19, 19);
        body4.addBox(-7F, -6F, -5F, 7, 5, 2);
        body4.setPos(7F, 27F, 2F);
        body4.setTexSize(64, 32);
        body4.mirror = true;
        setRotation(body4, -1.570796F, 0F, 0F);
        body5 = new ModelRenderer(this, 24, 19);
        body5.addBox(-7F, -6F, -5F, 6, 5, 4);
        body5.setPos(1F, 24F, 3F);
        body5.setTexSize(64, 32);
        body5.mirror = true;
        setRotation(body5, -1.308997F, 0F, 0F);
        body6 = new ModelRenderer(this, 19, 19);
        body6.addBox(-7F, -6F, -5F, 6, 5, 4);
        body6.setPos(7F, 24F, 3F);
        body6.setTexSize(64, 32);
        body6.mirror = true;
        setRotation(body6, -1.308997F, 0F, 0F);
        body7 = new ModelRenderer(this, 24, 19);
        body7.addBox(-7F, -6F, -5F, 7, 5, 7);
        body7.setPos(0F, 20F, 1F);
        body7.setTexSize(64, 32);
        body7.mirror = true;
        setRotation(body7, -0.7853982F, 0F, 0F);
        body8 = new ModelRenderer(this, 19, 19);
        body8.addBox(-7F, -6F, -5F, 7, 5, 7);
        body8.setPos(7F, 20F, 1F);
        body8.setTexSize(64, 32);
        body8.mirror = true;
        setRotation(body8, -0.7853982F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -4F, -6F, 8, 8, 6);
        head.setPos(0F, 6F, -8F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        earR = new ModelRenderer(this, 36, 2);
        earR.addBox(-4F, 1F, -8F, 1, 2, 5);
        earR.setPos(-1F, 6F, -8F);
        earR.setTexSize(64, 32);
        earR.mirror = true;
        setRotation(earR, 0F, 0F, 0F);
        earL2 = new ModelRenderer(this, 36, 2);
        earL2.addBox(5F, -7F, -3F, 1, 5, 2);
        earL2.setPos(-1F, 6F, -8F);
        earL2.setTexSize(64, 32);
        earL2.mirror = true;
        setRotation(earL2, 0F, 0F, 0F);
        earR2 = new ModelRenderer(this, 36, 2);
        earR2.addBox(-4F, -7F, -3F, 1, 5, 2);
        earR2.setPos(-1F, 6F, -8F);
        earR2.setTexSize(64, 32);
        earR2.mirror = true;
        setRotation(earR2, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float var1, float var2, float var3, float var4, float var5) {
        this.head.yRot = var4 / (180F / (float) Math.PI);
        this.head.xRot = var5 / (180F / (float) Math.PI);
        this.earL.yRot = var4 / (180F / (float) Math.PI);
        this.earL.xRot = var5 / (180F / (float) Math.PI);
        this.earR.yRot = var4 / (180F / (float) Math.PI);
        this.earR.xRot = var5 / (180F / (float) Math.PI);
        this.earL2.yRot = var4 / (180F / (float) Math.PI);
        this.earL2.xRot = var5 / (180F / (float) Math.PI);
        this.earR2.yRot = var4 / (180F / (float) Math.PI);
        this.earR2.xRot = var5 / (180F / (float) Math.PI);

        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightfoot.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

        this.leftleg.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
        this.leftfoot.xRot = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;

        this.rightleg.yRot = 0.0F;
        this.rightfoot.yRot = 0.0F;

        this.leftleg.yRot = 0.0F;
        this.leftfoot.yRot = 0.0F;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(earL, rightfoot, leftfoot, leftleg, rightleg, body, body2, body3, body4, body5, body6, body7,
                body8, head, earR, earL2, earR2);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

}
