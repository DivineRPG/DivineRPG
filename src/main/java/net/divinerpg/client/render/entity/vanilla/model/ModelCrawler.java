package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelCrawler extends ModelBase
{
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
  
  public ModelCrawler()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      earL = new ModelRenderer(this, 36, 2);
      earL.addBox(5F, 1F, -8F, 1, 2, 5);
      earL.setRotationPoint(-1F, 6F, -8F);
      earL.setTextureSize(64, 32);
      earL.mirror = true;
      setRotation(earL, 0F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 28, 16);
      rightfoot.addBox(-4F, 7F, -4F, 6, 4, 6);
      rightfoot.setRotationPoint(-3F, 13F, -5F);
      rightfoot.setTextureSize(64, 32);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 28, 16);
      leftfoot.addBox(-2F, 7F, -4F, 6, 4, 6);
      leftfoot.setRotationPoint(3F, 13F, -5F);
      leftfoot.setTextureSize(64, 32);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-1F, 0F, -3F, 4, 7, 4);
      leftleg.setRotationPoint(3F, 13F, -5F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-3F, 0F, -3F, 4, 7, 4);
      rightleg.setRotationPoint(-3F, 13F, -5F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      body = new ModelRenderer(this, 19, 16);
      body.addBox(-7F, -6F, -5F, 7, 5, 10);
      body.setRotationPoint(7F, 15F, -6F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, -0.4363323F, 0F, 0F);
      body2 = new ModelRenderer(this, 19, 0);
      body2.addBox(-7F, -6F, -5F, 7, 5, 10);
      body2.setRotationPoint(0F, 15F, -6F);
      body2.setTextureSize(64, 32);
      body2.mirror = true;
      setRotation(body2, -0.4363323F, 0F, 0F);
      body3 = new ModelRenderer(this, 24, 19);
      body3.addBox(-7F, -6F, -5F, 7, 5, 2);
      body3.setRotationPoint(0F, 27F, 2F);
      body3.setTextureSize(64, 32);
      body3.mirror = true;
      setRotation(body3, -1.570796F, 0F, 0F);
      body4 = new ModelRenderer(this, 19, 19);
      body4.addBox(-7F, -6F, -5F, 7, 5, 2);
      body4.setRotationPoint(7F, 27F, 2F);
      body4.setTextureSize(64, 32);
      body4.mirror = true;
      setRotation(body4, -1.570796F, 0F, 0F);
      body5 = new ModelRenderer(this, 24, 19);
      body5.addBox(-7F, -6F, -5F, 6, 5, 4);
      body5.setRotationPoint(1F, 24F, 3F);
      body5.setTextureSize(64, 32);
      body5.mirror = true;
      setRotation(body5, -1.308997F, 0F, 0F);
      body6 = new ModelRenderer(this, 19, 19);
      body6.addBox(-7F, -6F, -5F, 6, 5, 4);
      body6.setRotationPoint(7F, 24F, 3F);
      body6.setTextureSize(64, 32);
      body6.mirror = true;
      setRotation(body6, -1.308997F, 0F, 0F);
      body7 = new ModelRenderer(this, 24, 19);
      body7.addBox(-7F, -6F, -5F, 7, 5, 7);
      body7.setRotationPoint(0F, 20F, 1F);
      body7.setTextureSize(64, 32);
      body7.mirror = true;
      setRotation(body7, -0.7853982F, 0F, 0F);
      body8 = new ModelRenderer(this, 19, 19);
      body8.addBox(-7F, -6F, -5F, 7, 5, 7);
      body8.setRotationPoint(7F, 20F, 1F);
      body8.setTextureSize(64, 32);
      body8.mirror = true;
      setRotation(body8, -0.7853982F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -6F, 8, 8, 6);
      head.setRotationPoint(0F, 6F, -8F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      earR = new ModelRenderer(this, 36, 2);
      earR.addBox(-4F, 1F, -8F, 1, 2, 5);
      earR.setRotationPoint(-1F, 6F, -8F);
      earR.setTextureSize(64, 32);
      earR.mirror = true;
      setRotation(earR, 0F, 0F, 0F);
      earL2 = new ModelRenderer(this, 36, 2);
      earL2.addBox(5F, -7F, -3F, 1, 5, 2);
      earL2.setRotationPoint(-1F, 6F, -8F);
      earL2.setTextureSize(64, 32);
      earL2.mirror = true;
      setRotation(earL2, 0F, 0F, 0F);
      earR2 = new ModelRenderer(this, 36, 2);
      earR2.addBox(-4F, -7F, -3F, 1, 5, 2);
      earR2.setRotationPoint(-1F, 6F, -8F);
      earR2.setTextureSize(64, 32);
      earR2.mirror = true;
      setRotation(earR2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    earL.render(f5);
    rightfoot.render(f5);
    leftfoot.render(f5);
    leftleg.render(f5);
    rightleg.render(f5);
    body.render(f5);
    body2.render(f5);
    body3.render(f5);
    body4.render(f5);
    body5.render(f5);
    body6.render(f5);
    body7.render(f5);
    body8.render(f5);
    head.render(f5);
    earR.render(f5);
    earL2.render(f5);
    earR2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
      this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.head.rotateAngleX = var5 / (180F / (float)Math.PI);
      this.earL.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.earL.rotateAngleX = var5 / (180F / (float)Math.PI);
      this.earR.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.earR.rotateAngleX = var5 / (180F / (float)Math.PI);
      this.earL2.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.earL2.rotateAngleX = var5 / (180F / (float)Math.PI);
      this.earR2.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.earR2.rotateAngleX = var5 / (180F / (float)Math.PI);
      
      this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.rightfoot.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      
      this.leftleg.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
      this.leftfoot.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
      
      this.rightleg.rotateAngleY = 0.0F;
      this.rightfoot.rotateAngleY = 0.0F;
      
      this.leftleg.rotateAngleY = 0.0F;
      this.leftfoot.rotateAngleY = 0.0F;
  }

}
