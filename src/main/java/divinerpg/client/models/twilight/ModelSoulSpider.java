package divinerpg.client.models.twilight;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSoulSpider<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer body;
    ModelRenderer leg1top;
    ModelRenderer leg1middle;
    ModelRenderer leg1bottom;
    ModelRenderer leg2top;
    ModelRenderer leg2middle;
    ModelRenderer leg2bottom;
    ModelRenderer leg3top;
    ModelRenderer leg4top;
    ModelRenderer leg3middle;
    ModelRenderer leg4middle;
    ModelRenderer leg3bottom;
    ModelRenderer leg4bottom;
  
  public ModelSoulSpider() {
    texWidth = 64;
    texHeight = 32;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 5, 3, 7);
      body.setPos(-2.5F, 17F, -3F);
      body.setTexSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg1top = new ModelRenderer(this, 0, 10);
      leg1top.addBox(0F, 0F, -1F, 2, 4, 2);
      leg1top.setPos(-2F, 18F, -1F);
      leg1top.setTexSize(64, 32);
      leg1top.mirror = true;
      setRotation(leg1top, 0F, 0F, 0.8726646F);
      leg1middle = new ModelRenderer(this, 0, 16);
      leg1middle.addBox(-0.5F, 3F, -0.5F, 1, 2, 1);
      leg1middle.setPos(-1.5F, 18.2F, -1F);
      leg1middle.setTexSize(64, 32);
      leg1middle.mirror = true;
      setRotation(leg1middle, 0F, 0F, 0.6108652F);
      leg1bottom = new ModelRenderer(this, 0, 16);
      leg1bottom.addBox(-1.5F, 4.5F, -0.5F, 1, 2, 1);
      leg1bottom.setPos(-1.75F, 18.3F, -1F);
      leg1bottom.setTexSize(64, 32);
      leg1bottom.mirror = true;
      setRotation(leg1bottom, 0F, 0F, 0.3490659F);
      leg2top = new ModelRenderer(this, 0, 10);
      leg2top.addBox(0F, 0F, -1F, 2, 4, 2);
      leg2top.setPos(-2F, 18F, 2F);
      leg2top.setTexSize(64, 32);
      leg2top.mirror = true;
      setRotation(leg2top, 0F, 0F, 0.8726646F);
      leg2middle = new ModelRenderer(this, 0, 16);
      leg2middle.addBox(-0.5F, 3F, -0.5F, 1, 2, 1);
      leg2middle.setPos(-1.5F, 18.2F, 2F);
      leg2middle.setTexSize(64, 32);
      leg2middle.mirror = true;
      setRotation(leg2middle, 0F, 0F, 0.6108652F);
      leg2bottom = new ModelRenderer(this, 0, 16);
      leg2bottom.addBox(-1.5F, 4.5F, -0.5F, 1, 2, 1);
      leg2bottom.setPos(-1.8F, 18.3F, 2F);
      leg2bottom.setTexSize(64, 32);
      leg2bottom.mirror = true;
      setRotation(leg2bottom, 0F, 0F, 0.3490659F);
      leg3top = new ModelRenderer(this, 0, 10);
      leg3top.addBox(-2F, 0F, -1F, 2, 4, 2);
      leg3top.setPos(2F, 18F, -1F);
      leg3top.setTexSize(64, 32);
      leg3top.mirror = true;
      setRotation(leg3top, 0F, 0F, -0.8726646F);
      leg4top = new ModelRenderer(this, 0, 10);
      leg4top.addBox(-2F, 0F, -1F, 2, 4, 2);
      leg4top.setPos(2F, 18F, 2F);
      leg4top.setTexSize(64, 32);
      leg4top.mirror = true;
      setRotation(leg4top, 0F, 0F, -0.8726646F);
      leg3middle = new ModelRenderer(this, 0, 16);
      leg3middle.addBox(-1.5F, 3F, -0.5F, 1, 2, 1);
      leg3middle.setPos(2.5F, 17.6F, -1F);
      leg3middle.setTexSize(64, 32);
      leg3middle.mirror = true;
      setRotation(leg3middle, 0F, 0F, -0.6108652F);
      leg4middle = new ModelRenderer(this, 0, 16);
      leg4middle.addBox(-1.5F, 3F, -0.5F, 1, 2, 1);
      leg4middle.setPos(2.5F, 17.6F, 2F);
      leg4middle.setTexSize(64, 32);
      leg4middle.mirror = true;
      setRotation(leg4middle, 0F, 0F, -0.6108652F);
      leg3bottom = new ModelRenderer(this, 0, 16);
      leg3bottom.addBox(-0.5F, 4.5F, -0.5F, 1, 2, 1);
      leg3bottom.setPos(2.8F, 18F, -1F);
      leg3bottom.setTexSize(64, 32);
      leg3bottom.mirror = true;
      setRotation(leg3bottom, 0F, 0F, -0.3490659F);
      leg4bottom = new ModelRenderer(this, 0, 16);
      leg4bottom.addBox(-0.5F, 4.5F, -0.5F, 1, 2, 1);
      leg4bottom.setPos(2.9F, 18F, 2F);
      leg4bottom.setTexSize(64, 32);
      leg4bottom.mirror = true;
      setRotation(leg4bottom, 0F, 0F, -0.3490659F);
  }

  @Override
  public Iterable<ModelRenderer> parts() {
    return ImmutableList.of(body, leg1top, leg1middle, leg1bottom, leg2top, leg2middle, leg2bottom, leg3top, leg4top, leg3middle, leg4middle, leg3bottom, leg4bottom);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.xRot = x;
    model.yRot = y;
    model.zRot = z;
  }
  
  @Override
  public void setupAnim(T e, float f, float f1, float f2, float f3, float f4) {
    
    this.leg1top.xRot = this.leg2top.xRot = this.leg1middle.xRot = this.leg2middle.xRot = this.leg1bottom.xRot = this.leg2bottom.xRot = (float) Math.sin(f/2)*f1*1.3f;
    this.leg3top.xRot = this.leg4top.xRot = this.leg3middle.xRot = this.leg4middle.xRot = this.leg3bottom.xRot = this.leg4bottom.xRot = (float) Math.cos(f/2)*f1*1.3f;
  }

}
