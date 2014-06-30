package net.divinerpg.client.render.entity.arcana.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWraith extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg3;
    ModelRenderer leg4;
  
  public ModelWraith()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 6F, -8F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 19, 0);
      body.addBox(-6F, -10F, -7F, 12, 22, 10);
      body.setRotationPoint(0F, 11F, 2F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0.8644027F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-3F, 0F, -3F, 4, 11, 4);
      leg3.setRotationPoint(-3F, 13F, -5F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, -1.308997F, 1.134464F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-1F, 0F, -3F, 4, 11, 4);
      leg4.setRotationPoint(3F, 13F, -5F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, -1.308997F, -1.134464F, -0.0743572F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    head.render(f5);
    body.render(f5);
    leg3.render(f5);
    leg4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
      this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
      this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
      this.leg4.rotateAngleY = 0.0F;
      this.leg3.rotateAngleY = 0.0F;
  }

}
