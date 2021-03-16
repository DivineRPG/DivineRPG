package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;

public class ModelSeimer<T extends Entity> extends SegmentedModel<T> 
{
    //fields
	ModelRenderer body;
    ModelRenderer headtop;
    ModelRenderer headbottom;
    ModelRenderer headright;
    ModelRenderer headleft;
    ModelRenderer hornright;
    ModelRenderer hornright2;
    ModelRenderer sensorright2;
    ModelRenderer sensorleft;
    ModelRenderer wingright;
    ModelRenderer wingleft;
    ModelRenderer wingleft1;
    ModelRenderer wingright2;
    ModelRenderer hornleft;
    ModelRenderer sensorright;
    ModelRenderer hornleft2;
    ModelRenderer sensorleft2;

    public ModelSeimer()
    {
    	texWidth = 64;
        texHeight = 32;
        body = new ModelRenderer(this, 0, 7);
        body.addBox(0F, 0F, 0F, 16, 9, 16);
        body.setPos(8F, 10F, -8F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, -1.570796F, 0F);
        headtop = new ModelRenderer(this, 15, 14);
        headtop.addBox(0F, 0F, 0F, 2, 2, 16);
        headtop.setPos(8F, 10F, -10F);
        headtop.setTexSize(64, 32);
        headtop.mirror = true;
        setRotation(headtop, 0F, -1.570796F, 0F);
        headbottom = new ModelRenderer(this, 32, 0);
        headbottom.addBox(0F, 0F, 0F, 2, 2, 14);
        headbottom.setPos(7F, 16F, -10F);
        headbottom.setTexSize(64, 32);
        headbottom.mirror = true;
        setRotation(headbottom, 0F, -1.570796F, 0F);
        headright = new ModelRenderer(this, 54, 0);
        headright.addBox(0F, 0F, 0F, 2, 4, 2);
        headright.setPos(7F, 12F, -10F);
        headright.setTexSize(64, 32);
        headright.mirror = true;
        setRotation(headright, 0F, -1.570796F, 0F);
        headleft = new ModelRenderer(this, 54, 0);
        headleft.addBox(0F, -1F, 0F, 2, 4, 2);
        headleft.setPos(-5F, 13F, -10F);
        headleft.setTexSize(64, 32);
        headleft.mirror = true;
        setRotation(headleft, 0F, -1.570796F, 0F);
        hornright = new ModelRenderer(this, 0, 12);
        hornright.addBox(0F, 0F, 0F, 2, 6, 2);
        hornright.setPos(6F, 4F, -3F);
        hornright.setTexSize(64, 32);
        hornright.mirror = true;
        setRotation(hornright, 0F, -1.570796F, 0F);
        hornright2 = new ModelRenderer(this, 0, 13);
        hornright2.addBox(0F, 0F, 0F, 2, 6, 2);
        hornright2.setPos(3F, 4F, -3F);
        hornright2.setTexSize(64, 32);
        hornright2.mirror = true;
        setRotation(hornright2, 0F, -1.570796F, 0F);
        sensorright2 = new ModelRenderer(this, 0, 20);
        sensorright2.addBox(0F, 0F, 0F, 6, 2, 2);
        sensorright2.setPos(3F, 4F, -9F);
        sensorright2.setTexSize(64, 32);
        sensorright2.mirror = true;
        setRotation(sensorright2, 0F, -1.570796F, 0F);
        sensorleft = new ModelRenderer(this, 0, 20);
        sensorleft.addBox(0F, 0F, 0F, 6, 2, 2);
        sensorleft.setPos(6F, 4F, -9F);
        sensorleft.setTexSize(64, 32);
        sensorleft.mirror = true;
        setRotation(sensorleft, 0F, -1.570796F, 0F);
        wingright = new ModelRenderer(this, 27, 0);
        wingright.addBox(0F, 0F, 0F, 10, 2, 8);
        wingright.setPos(-8F, 16F, -6F);
        wingright.setTexSize(64, 32);
        wingright.mirror = true;
        setRotation(wingright, 0F, -1.570796F, 0F);
        wingleft = new ModelRenderer(this, 29, 0);
        wingleft.addBox(0F, 0F, 0F, 10, 2, 8);
        wingleft.setPos(16F, 16F, -6F);
        wingleft.setTexSize(64, 32);
        wingleft.mirror = true;
        setRotation(wingleft, 0F, -1.570796F, 0F);
        wingleft1 = new ModelRenderer(this, 29, 0);
        wingleft1.addBox(0F, 0F, 0F, 10, 2, 8);
        wingleft1.setPos(16F, 12F, -6F);
        wingleft1.setTexSize(64, 32);
        wingleft1.mirror = true;
        setRotation(wingleft1, 0F, -1.570796F, 0F);
        wingright2 = new ModelRenderer(this, 27, 0);
        wingright2.addBox(0F, 0F, 0F, 10, 2, 8);
        wingright2.setPos(-8F, 12F, -6F);
        wingright2.setTexSize(64, 32);
        wingright2.mirror = true;
        setRotation(wingright2, 0F, -1.570796F, 0F);
        hornleft = new ModelRenderer(this, 0, 13);
        hornleft.addBox(0F, 0F, 0F, 2, 6, 2);
        hornleft.setPos(-4F, 4F, -3F);
        hornleft.setTexSize(64, 32);
        hornleft.mirror = true;
        setRotation(hornleft, 0F, -1.570796F, 0F);
        sensorright = new ModelRenderer(this, 0, 20);
        sensorright.addBox(0F, 0F, 0F, 6, 2, 2);
        sensorright.setPos(-4F, 4F, -9F);
        sensorright.setTexSize(64, 32);
        sensorright.mirror = true;
        setRotation(sensorright, 0F, -1.570796F, 0F);
        hornleft2 = new ModelRenderer(this, 0, 13);
        hornleft2.addBox(0F, 0F, 0F, 2, 6, 2);
        hornleft2.setPos(-1F, 4F, -3F);
        hornleft2.setTexSize(64, 32);
        hornleft2.mirror = true;
        setRotation(hornleft2, 0F, -1.570796F, 0F);
        sensorleft2 = new ModelRenderer(this, 0, 20);
        sensorleft2.addBox(0F, 0F, 0F, 6, 2, 2);
        sensorleft2.setPos(-1F, 4F, -9F);
        sensorleft2.setTexSize(64, 32);
        sensorleft2.mirror = true;
        setRotation(sensorleft2, 0F, -1.570796F, 0F);
    }
    
    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(body, headtop, headbottom, headright, headleft, hornright, hornright2, sensorright2, sensorright2, sensorleft, wingright, wingleft, wingleft1, wingright2, hornleft, sensorright, hornleft2, sensorleft2);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
	}
}
