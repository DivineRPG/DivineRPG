package divinerpg.client.models.twilight;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTomo<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer body;
    ModelRenderer headtop;
    ModelRenderer headbottom;
    ModelRenderer headright;
    ModelRenderer headleft;
    ModelRenderer hornright;
    ModelRenderer hornleft;
    ModelRenderer sensorright;
    ModelRenderer sensorleft;
    ModelRenderer wingright;
    ModelRenderer wingleft;

    public ModelTomo()
    {
        this.texWidth = 64;
        this.texHeight = 32;
        this.body = new ModelRenderer(this, 0, 7);
        this.body.addBox(0.0F, 0.0F, 0.0F, 16, 9, 16);
        this.body.setPos(8.0F, 10.0F, -8.0F);
        this.body.setTexSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.headtop = new ModelRenderer(this, 15, 14);
        this.headtop.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16);
        this.headtop.setPos(8.0F, 10.0F, -10.0F);
        this.headtop.setTexSize(64, 32);
        this.headtop.mirror = true;
        this.setRotation(this.headtop, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.headbottom = new ModelRenderer(this, 32, 0);
        this.headbottom.addBox(0.0F, 0.0F, 0.0F, 2, 2, 14);
        this.headbottom.setPos(7.0F, 16.0F, -10.0F);
        this.headbottom.setTexSize(64, 32);
        this.headbottom.mirror = true;
        this.setRotation(this.headbottom, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.headright = new ModelRenderer(this, 54, 0);
        this.headright.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
        this.headright.setPos(7.0F, 12.0F, -10.0F);
        this.headright.setTexSize(64, 32);
        this.headright.mirror = true;
        this.setRotation(this.headright, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.headleft = new ModelRenderer(this, 54, 0);
        this.headleft.addBox(0.0F, -1.0F, 0.0F, 2, 4, 2);
        this.headleft.setPos(-5.0F, 13.0F, -10.0F);
        this.headleft.setTexSize(64, 32);
        this.headleft.mirror = true;
        this.setRotation(this.headleft, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.hornright = new ModelRenderer(this, 0, 12);
        this.hornright.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2);
        this.hornright.setPos(6.0F, 4.0F, -3.0F);
        this.hornright.setTexSize(64, 32);
        this.hornright.mirror = true;
        this.setRotation(this.hornright, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.hornleft = new ModelRenderer(this, 0, 13);
        this.hornleft.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2);
        this.hornleft.setPos(-4.0F, 4.0F, -3.0F);
        this.hornleft.setTexSize(64, 32);
        this.hornleft.mirror = true;
        this.setRotation(this.hornleft, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.sensorright = new ModelRenderer(this, 0, 20);
        this.sensorright.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.sensorright.setPos(-4.0F, 4.0F, -9.0F);
        this.sensorright.setTexSize(64, 32);
        this.sensorright.mirror = true;
        this.setRotation(this.sensorright, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.sensorleft = new ModelRenderer(this, 0, 20);
        this.sensorleft.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.sensorleft.setPos(6.0F, 4.0F, -9.0F);
        this.sensorleft.setTexSize(64, 32);
        this.sensorleft.mirror = true;
        this.setRotation(this.sensorleft, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.wingright = new ModelRenderer(this, 27, 0);
        this.wingright.addBox(0.0F, 0.0F, 0.0F, 10, 2, 8);
        this.wingright.setPos(-8.0F, 12.0F, -6.0F);
        this.wingright.setTexSize(64, 32);
        this.wingright.mirror = true;
        this.setRotation(this.wingright, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.wingleft = new ModelRenderer(this, 29, 0);
        this.wingleft.addBox(0.0F, 0.0F, 0.0F, 10, 2, 8);
        this.wingleft.setPos(16.0F, 12.0F, -6.0F);
        this.wingleft.setTexSize(64, 32);
        this.wingleft.mirror = true;
        this.setRotation(this.wingleft, 0.0F, -((float)Math.PI / 2F), 0.0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(body, headtop, headbottom, headright, headleft, hornright, hornleft, sensorright, sensorleft, wingright, wingleft);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }
}
