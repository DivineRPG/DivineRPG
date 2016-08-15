package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSoulSpider extends ModelBase {
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
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 5, 3, 7);
      body.setRotationPoint(-2.5F, 17F, -3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leg1top = new ModelRenderer(this, 0, 10);
      leg1top.addBox(0F, 0F, -1F, 2, 4, 2);
      leg1top.setRotationPoint(-2F, 18F, -1F);
      leg1top.setTextureSize(64, 32);
      leg1top.mirror = true;
      setRotation(leg1top, 0F, 0F, 0.8726646F);
      leg1middle = new ModelRenderer(this, 0, 16);
      leg1middle.addBox(-0.5F, 3F, -0.5F, 1, 2, 1);
      leg1middle.setRotationPoint(-1.5F, 18.2F, -1F);
      leg1middle.setTextureSize(64, 32);
      leg1middle.mirror = true;
      setRotation(leg1middle, 0F, 0F, 0.6108652F);
      leg1bottom = new ModelRenderer(this, 0, 16);
      leg1bottom.addBox(-1.5F, 4.5F, -0.5F, 1, 2, 1);
      leg1bottom.setRotationPoint(-1.75F, 18.3F, -1F);
      leg1bottom.setTextureSize(64, 32);
      leg1bottom.mirror = true;
      setRotation(leg1bottom, 0F, 0F, 0.3490659F);
      leg2top = new ModelRenderer(this, 0, 10);
      leg2top.addBox(0F, 0F, -1F, 2, 4, 2);
      leg2top.setRotationPoint(-2F, 18F, 2F);
      leg2top.setTextureSize(64, 32);
      leg2top.mirror = true;
      setRotation(leg2top, 0F, 0F, 0.8726646F);
      leg2middle = new ModelRenderer(this, 0, 16);
      leg2middle.addBox(-0.5F, 3F, -0.5F, 1, 2, 1);
      leg2middle.setRotationPoint(-1.5F, 18.2F, 2F);
      leg2middle.setTextureSize(64, 32);
      leg2middle.mirror = true;
      setRotation(leg2middle, 0F, 0F, 0.6108652F);
      leg2bottom = new ModelRenderer(this, 0, 16);
      leg2bottom.addBox(-1.5F, 4.5F, -0.5F, 1, 2, 1);
      leg2bottom.setRotationPoint(-1.8F, 18.3F, 2F);
      leg2bottom.setTextureSize(64, 32);
      leg2bottom.mirror = true;
      setRotation(leg2bottom, 0F, 0F, 0.3490659F);
      leg3top = new ModelRenderer(this, 0, 10);
      leg3top.addBox(-2F, 0F, -1F, 2, 4, 2);
      leg3top.setRotationPoint(2F, 18F, -1F);
      leg3top.setTextureSize(64, 32);
      leg3top.mirror = true;
      setRotation(leg3top, 0F, 0F, -0.8726646F);
      leg4top = new ModelRenderer(this, 0, 10);
      leg4top.addBox(-2F, 0F, -1F, 2, 4, 2);
      leg4top.setRotationPoint(2F, 18F, 2F);
      leg4top.setTextureSize(64, 32);
      leg4top.mirror = true;
      setRotation(leg4top, 0F, 0F, -0.8726646F);
      leg3middle = new ModelRenderer(this, 0, 16);
      leg3middle.addBox(-1.5F, 3F, -0.5F, 1, 2, 1);
      leg3middle.setRotationPoint(2.5F, 17.6F, -1F);
      leg3middle.setTextureSize(64, 32);
      leg3middle.mirror = true;
      setRotation(leg3middle, 0F, 0F, -0.6108652F);
      leg4middle = new ModelRenderer(this, 0, 16);
      leg4middle.addBox(-1.5F, 3F, -0.5F, 1, 2, 1);
      leg4middle.setRotationPoint(2.5F, 17.6F, 2F);
      leg4middle.setTextureSize(64, 32);
      leg4middle.mirror = true;
      setRotation(leg4middle, 0F, 0F, -0.6108652F);
      leg3bottom = new ModelRenderer(this, 0, 16);
      leg3bottom.addBox(-0.5F, 4.5F, -0.5F, 1, 2, 1);
      leg3bottom.setRotationPoint(2.8F, 18F, -1F);
      leg3bottom.setTextureSize(64, 32);
      leg3bottom.mirror = true;
      setRotation(leg3bottom, 0F, 0F, -0.3490659F);
      leg4bottom = new ModelRenderer(this, 0, 16);
      leg4bottom.addBox(-0.5F, 4.5F, -0.5F, 1, 2, 1);
      leg4bottom.setRotationPoint(2.9F, 18F, 2F);
      leg4bottom.setTextureSize(64, 32);
      leg4bottom.mirror = true;
      setRotation(leg4bottom, 0F, 0F, -0.3490659F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    leg1top.render(f5);
    leg1middle.render(f5);
    leg1bottom.render(f5);
    leg2top.render(f5);
    leg2middle.render(f5);
    leg2bottom.render(f5);
    leg3top.render(f5);
    leg4top.render(f5);
    leg3middle.render(f5);
    leg4middle.render(f5);
    leg3bottom.render(f5);
    leg4bottom.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.leg1top.rotateAngleX = this.leg2top.rotateAngleX = this.leg1middle.rotateAngleX = this.leg2middle.rotateAngleX = this.leg1bottom.rotateAngleX = this.leg2bottom.rotateAngleX = (float) Math.sin(f/2)*f1*1.3f;
    this.leg3top.rotateAngleX = this.leg4top.rotateAngleX = this.leg3middle.rotateAngleX = this.leg4middle.rotateAngleX = this.leg3bottom.rotateAngleX = this.leg4bottom.rotateAngleX = (float) Math.cos(f/2)*f1*1.3f;
  }

}
