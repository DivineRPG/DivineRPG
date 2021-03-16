package divinerpg.client.models.vanilla;

import divinerpg.entities.vanilla.overworld.EntityShark;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelShark<T extends EntityShark> extends SegmentedModel<T> {
    ModelRenderer bodyTop;
    ModelRenderer flipperL;
    ModelRenderer flipperR;
    ModelRenderer tailConnector;
    ModelRenderer tailTop;
    ModelRenderer tailBottom;
    ModelRenderer fin;
    ModelRenderer bodyBottom;
    ModelRenderer bodyMiddle;
    ModelRenderer bodyBack;


    public ModelShark() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.bodyTop = new ModelRenderer(this, 0, 0);
        this.bodyTop.addBox(0.0F, 0.0F, 0.0F, 8, 2, 26);
        this.bodyTop.setPos(-5.0F, 18.0F, -11.0F);
        this.bodyTop.setTexSize(64, 64);
        this.bodyTop.mirror = true;
        this.setRotation(this.bodyTop, 0.0F, 0.0F, 0.0F);
        this.flipperL = new ModelRenderer(this, 0, 58);
        this.flipperL.addBox(0.0F, 0.0F, -3.0F, 10, 2, 4);
        this.flipperL.setPos(1.0F, 21.0F, 2.0F);
        this.flipperL.setTexSize(64, 64);
        this.flipperL.mirror = true;
        this.setRotation(this.flipperL, 0.0F, -0.6108652F, 0.0F);
        this.flipperR = new ModelRenderer(this, 0, 58);
        this.flipperR.addBox(-6.0F, 0.0F, -3.0F, 10, 2, 4);
        this.flipperR.setPos(-6.0F, 21.0F, 4.0F);
        this.flipperR.setTexSize(64, 64);
        this.flipperR.mirror = true;
        this.setRotation(this.flipperR, 0.0F, 0.6108652F, 0.0F);
        this.tailConnector = new ModelRenderer(this, 0, 2);
        this.tailConnector.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 5);
        this.tailConnector.setPos(-1.0F, 21.0F, 16.0F);
        this.tailConnector.setTexSize(64, 64);
        this.tailConnector.mirror = true;
        this.setRotation(this.tailConnector, 0.0F, 0.0F, ((float) Math.PI / 2F));
        this.tailTop = new ModelRenderer(this, 0, 0);
        this.tailTop.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 8);
        this.tailTop.setPos(-1.0F, 20.0F, 20.0F);
        this.tailTop.setTexSize(64, 64);
        this.tailTop.mirror = true;
        this.setRotation(this.tailTop, 0.6108652F, 0.0F, 0.0F);
        this.tailBottom = new ModelRenderer(this, 0, 0);
        this.tailBottom.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 8);
        this.tailBottom.setPos(-1.0F, 21.0F, 19.0F);
        this.tailBottom.setTexSize(64, 64);
        this.tailBottom.mirror = true;
        this.setRotation(this.tailBottom, -0.6108652F, 0.0F, 0.0F);
        this.fin = new ModelRenderer(this, 0, 0);
        this.fin.addBox(0.0F, 0.0F, 0.0F, 2, 3, 8);
        this.fin.setPos(-2.0F, 18.0F, 0.0F);
        this.fin.setTexSize(64, 64);
        this.fin.mirror = true;
        this.setRotation(this.fin, 0.9599311F, 0.0F, 0.0F);
        this.bodyBottom = new ModelRenderer(this, 0, 32);
        this.bodyBottom.addBox(0.0F, 0.0F, 0.0F, 8, 2, 24);
        this.bodyBottom.setPos(-5.0F, 22.0F, -9.0F);
        this.bodyBottom.setTexSize(64, 64);
        this.bodyBottom.mirror = true;
        this.setRotation(this.bodyBottom, 0.0F, 0.0F, 0.0F);
        this.bodyMiddle = new ModelRenderer(this, 3, 1);
        this.bodyMiddle.addBox(0.0F, 0.0F, 0.0F, 8, 2, 21);
        this.bodyMiddle.setPos(-5.0F, 20.0F, -6.0F);
        this.bodyMiddle.setTexSize(64, 64);
        this.bodyMiddle.mirror = true;
        this.setRotation(this.bodyMiddle, 0.0F, 0.0F, 0.0F);
        this.bodyBack = new ModelRenderer(this, 24, 8);
        this.bodyBack.addBox(0.0F, 0.0F, 0.0F, 8, 6, 1);
        this.bodyBack.setPos(-5.0F, 18.0F, 15.0F);
        this.bodyBack.setTexSize(64, 64);
        this.bodyBack.mirror = true;
        this.setRotation(this.bodyBack, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(bodyTop, flipperL, flipperR, tailConnector, tailTop, tailBottom, fin, bodyBottom, bodyMiddle, bodyBack);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }
}