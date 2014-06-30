package net.divinerpg.client.render.entity.arcana.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSeimer extends ModelBase
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
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 0, 7);
      body.addBox(0F, 0F, 0F, 16, 9, 16);
      body.setRotationPoint(8F, 10F, -8F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, -1.570796F, 0F);
      headtop = new ModelRenderer(this, 15, 14);
      headtop.addBox(0F, 0F, 0F, 2, 2, 16);
      headtop.setRotationPoint(8F, 10F, -10F);
      headtop.setTextureSize(64, 32);
      headtop.mirror = true;
      setRotation(headtop, 0F, -1.570796F, 0F);
      headbottom = new ModelRenderer(this, 32, 0);
      headbottom.addBox(0F, 0F, 0F, 2, 2, 14);
      headbottom.setRotationPoint(7F, 16F, -10F);
      headbottom.setTextureSize(64, 32);
      headbottom.mirror = true;
      setRotation(headbottom, 0F, -1.570796F, 0F);
      headright = new ModelRenderer(this, 54, 0);
      headright.addBox(0F, 0F, 0F, 2, 4, 2);
      headright.setRotationPoint(7F, 12F, -10F);
      headright.setTextureSize(64, 32);
      headright.mirror = true;
      setRotation(headright, 0F, -1.570796F, 0F);
      headleft = new ModelRenderer(this, 54, 0);
      headleft.addBox(0F, -1F, 0F, 2, 4, 2);
      headleft.setRotationPoint(-5F, 13F, -10F);
      headleft.setTextureSize(64, 32);
      headleft.mirror = true;
      setRotation(headleft, 0F, -1.570796F, 0F);
      hornright = new ModelRenderer(this, 0, 12);
      hornright.addBox(0F, 0F, 0F, 2, 6, 2);
      hornright.setRotationPoint(6F, 4F, -3F);
      hornright.setTextureSize(64, 32);
      hornright.mirror = true;
      setRotation(hornright, 0F, -1.570796F, 0F);
      hornright2 = new ModelRenderer(this, 0, 13);
      hornright2.addBox(0F, 0F, 0F, 2, 6, 2);
      hornright2.setRotationPoint(3F, 4F, -3F);
      hornright2.setTextureSize(64, 32);
      hornright2.mirror = true;
      setRotation(hornright2, 0F, -1.570796F, 0F);
      sensorright2 = new ModelRenderer(this, 0, 20);
      sensorright2.addBox(0F, 0F, 0F, 6, 2, 2);
      sensorright2.setRotationPoint(3F, 4F, -9F);
      sensorright2.setTextureSize(64, 32);
      sensorright2.mirror = true;
      setRotation(sensorright2, 0F, -1.570796F, 0F);
      sensorleft = new ModelRenderer(this, 0, 20);
      sensorleft.addBox(0F, 0F, 0F, 6, 2, 2);
      sensorleft.setRotationPoint(6F, 4F, -9F);
      sensorleft.setTextureSize(64, 32);
      sensorleft.mirror = true;
      setRotation(sensorleft, 0F, -1.570796F, 0F);
      wingright = new ModelRenderer(this, 27, 0);
      wingright.addBox(0F, 0F, 0F, 10, 2, 8);
      wingright.setRotationPoint(-8F, 16F, -6F);
      wingright.setTextureSize(64, 32);
      wingright.mirror = true;
      setRotation(wingright, 0F, -1.570796F, 0F);
      wingleft = new ModelRenderer(this, 29, 0);
      wingleft.addBox(0F, 0F, 0F, 10, 2, 8);
      wingleft.setRotationPoint(16F, 16F, -6F);
      wingleft.setTextureSize(64, 32);
      wingleft.mirror = true;
      setRotation(wingleft, 0F, -1.570796F, 0F);
      wingleft1 = new ModelRenderer(this, 29, 0);
      wingleft1.addBox(0F, 0F, 0F, 10, 2, 8);
      wingleft1.setRotationPoint(16F, 12F, -6F);
      wingleft1.setTextureSize(64, 32);
      wingleft1.mirror = true;
      setRotation(wingleft1, 0F, -1.570796F, 0F);
      wingright2 = new ModelRenderer(this, 27, 0);
      wingright2.addBox(0F, 0F, 0F, 10, 2, 8);
      wingright2.setRotationPoint(-8F, 12F, -6F);
      wingright2.setTextureSize(64, 32);
      wingright2.mirror = true;
      setRotation(wingright2, 0F, -1.570796F, 0F);
      hornleft = new ModelRenderer(this, 0, 13);
      hornleft.addBox(0F, 0F, 0F, 2, 6, 2);
      hornleft.setRotationPoint(-4F, 4F, -3F);
      hornleft.setTextureSize(64, 32);
      hornleft.mirror = true;
      setRotation(hornleft, 0F, -1.570796F, 0F);
      sensorright = new ModelRenderer(this, 0, 20);
      sensorright.addBox(0F, 0F, 0F, 6, 2, 2);
      sensorright.setRotationPoint(-4F, 4F, -9F);
      sensorright.setTextureSize(64, 32);
      sensorright.mirror = true;
      setRotation(sensorright, 0F, -1.570796F, 0F);
      hornleft2 = new ModelRenderer(this, 0, 13);
      hornleft2.addBox(0F, 0F, 0F, 2, 6, 2);
      hornleft2.setRotationPoint(-1F, 4F, -3F);
      hornleft2.setTextureSize(64, 32);
      hornleft2.mirror = true;
      setRotation(hornleft2, 0F, -1.570796F, 0F);
      sensorleft2 = new ModelRenderer(this, 0, 20);
      sensorleft2.addBox(0F, 0F, 0F, 6, 2, 2);
      sensorleft2.setRotationPoint(-1F, 4F, -9F);
      sensorleft2.setTextureSize(64, 32);
      sensorleft2.mirror = true;
      setRotation(sensorleft2, 0F, -1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    body.render(f5);
    headtop.render(f5);
    headbottom.render(f5);
    headright.render(f5);
    headleft.render(f5);
    hornright.render(f5);
    hornright2.render(f5);
    sensorright2.render(f5);
    sensorleft.render(f5);
    wingright.render(f5);
    wingleft.render(f5);
    wingleft1.render(f5);
    wingright2.render(f5);
    hornleft.render(f5);
    sensorright.render(f5);
    hornleft2.render(f5);
    sensorleft2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5){}

}
