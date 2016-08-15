package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelAridWarrior extends ModelBase
{
  //fields
    ModelRenderer ear1;
    ModelRenderer leftarmBS1;
    ModelRenderer rightleg;
    ModelRenderer body;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer leftarmBS2;
    ModelRenderer leftarmTS1;
    ModelRenderer leftarmTS2;
    ModelRenderer rightarmTS2;
    ModelRenderer rightarmBS1;
    public ModelRenderer rightarmBS2;
    ModelRenderer rightarmTS1;
    ModelRenderer head;
    ModelRenderer ear2;
    ModelRenderer leftleg;
    ModelRenderer rightfoot;
    ModelRenderer rightlegpart;
    ModelRenderer rightlegpart2;
    ModelRenderer leftfoot;
    ModelRenderer leftlegpart2;
    ModelRenderer leftlegpart1;
  
  public ModelAridWarrior()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      ear1 = new ModelRenderer(this, 34, 0);
      ear1.addBox(-6F, -8F, -4F, 2, 3, 8);
      ear1.setRotationPoint(10F, -12F, -5F);
      ear1.setTextureSize(64, 32);
      ear1.mirror = true;
      setRotation(ear1, -0.8179294F, 0F, 0F);
      leftarmBS1 = new ModelRenderer(this, 28, 16);
      leftarmBS1.addBox(-1F, -1F, -2F, 7, 3, 4);
      leftarmBS1.setRotationPoint(8F, 4F, 0F);
      leftarmBS1.setTextureSize(64, 32);
      leftarmBS1.mirror = true;
      setRotation(leftarmBS1, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-5F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 6F, -2F, 14, 6, 4);
      body.setRotationPoint(-3F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      body2 = new ModelRenderer(this, 16, 16);
      body2.addBox(-4F, 6F, -2F, 14, 6, 4);
      body2.setRotationPoint(-3F, -14F, 0F);
      body2.setTextureSize(64, 32);
      body2.mirror = true;
      setRotation(body2, 0F, 0F, 0F);
      body3 = new ModelRenderer(this, 16, 16);
      body3.addBox(-4F, 6F, -2F, 3, 8, 4);
      body3.setRotationPoint(8F, -8F, 0F);
      body3.setTextureSize(64, 32);
      body3.mirror = true;
      setRotation(body3, 0F, 0F, 0F);
      body4 = new ModelRenderer(this, 16, 16);
      body4.addBox(-4F, 6F, -2F, 3, 8, 4);
      body4.setRotationPoint(-3F, -8F, 0F);
      body4.setTextureSize(64, 32);
      body4.mirror = true;
      setRotation(body4, 0F, 0F, 0F);
      leftarmBS2 = new ModelRenderer(this, 40, 16);
      leftarmBS2.addBox(2F, 1F, -2F, 4, 6, 4);
      leftarmBS2.setRotationPoint(8F, 5F, 0F);
      leftarmBS2.setTextureSize(64, 32);
      leftarmBS2.mirror = true;
      setRotation(leftarmBS2, 0F, 0F, 0F);
      leftarmTS1 = new ModelRenderer(this, 28, 16);
      leftarmTS1.addBox(-1F, -1F, -2F, 7, 3, 4);
      leftarmTS1.setRotationPoint(8F, -7F, 0F);
      leftarmTS1.setTextureSize(64, 32);
      leftarmTS1.mirror = true;
      setRotation(leftarmTS1, 0F, 0F, 0F);
      leftarmTS2 = new ModelRenderer(this, 40, 16);
      leftarmTS2.addBox(2F, 1F, -2F, 4, 6, 4);
      leftarmTS2.setRotationPoint(8F, -6F, 0F);
      leftarmTS2.setTextureSize(64, 32);
      leftarmTS2.mirror = true;
      setRotation(leftarmTS2, 0F, 0F, 0F);
      rightarmTS2 = new ModelRenderer(this, 40, 16);
      rightarmTS2.addBox(-6F, 1F, -2F, 4, 6, 4);
      rightarmTS2.setRotationPoint(-8F, -6F, 0F);
      rightarmTS2.setTextureSize(64, 32);
      rightarmTS2.mirror = true;
      setRotation(rightarmTS2, 0F, 0F, 0F);
      rightarmBS1 = new ModelRenderer(this, 28, 16);
      rightarmBS1.addBox(-6F, -1F, -2F, 7, 3, 4);
      rightarmBS1.setRotationPoint(-8F, 4F, 0F);
      rightarmBS1.setTextureSize(64, 32);
      rightarmBS1.mirror = true;
      setRotation(rightarmBS1, 0F, 0F, 0F);
      rightarmBS2 = new ModelRenderer(this, 40, 16);
      rightarmBS2.addBox(-6F, 1F, -2F, 4, 6, 4);
      rightarmBS2.setRotationPoint(-8F, 5F, 0F);
      rightarmBS2.setTextureSize(64, 32);
      rightarmBS2.mirror = true;
      setRotation(rightarmBS2, 0F, 0F, 0F);
      rightarmTS1 = new ModelRenderer(this, 28, 16);
      rightarmTS1.addBox(-6F, -1F, -2F, 7, 3, 4);
      rightarmTS1.setRotationPoint(-8F, -7F, 0F);
      rightarmTS1.setTextureSize(64, 32);
      rightarmTS1.mirror = true;
      setRotation(rightarmTS1, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, -8F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      ear2 = new ModelRenderer(this, 34, 0);
      ear2.addBox(-6F, -8F, -4F, 2, 3, 8);
      ear2.setRotationPoint(0F, -12F, -5F);
      ear2.setTextureSize(64, 32);
      ear2.mirror = true;
      setRotation(ear2, -0.8179294F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(5F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      rightfoot = new ModelRenderer(this, 0, 16);
      rightfoot.addBox(-4F, 9F, -4F, 8, 3, 8);
      rightfoot.setRotationPoint(-5F, 12F, 0F);
      rightfoot.setTextureSize(64, 32);
      rightfoot.mirror = true;
      setRotation(rightfoot, 0F, 0F, 0F);
      rightlegpart = new ModelRenderer(this, 0, 16);
      rightlegpart.addBox(-3F, 1F, -3F, 6, 3, 6);
      rightlegpart.setRotationPoint(-5F, 12F, 0F);
      rightlegpart.setTextureSize(64, 32);
      rightlegpart.mirror = true;
      setRotation(rightlegpart, 0F, 0F, 0F);
      rightlegpart2 = new ModelRenderer(this, 0, 16);
      rightlegpart2.addBox(-3F, 5F, -3F, 6, 3, 6);
      rightlegpart2.setRotationPoint(-5F, 12F, 0F);
      rightlegpart2.setTextureSize(64, 32);
      rightlegpart2.mirror = true;
      setRotation(rightlegpart2, 0F, 0F, 0F);
      leftfoot = new ModelRenderer(this, 0, 16);
      leftfoot.addBox(-4F, 9F, -4F, 8, 3, 8);
      leftfoot.setRotationPoint(5F, 12F, 0F);
      leftfoot.setTextureSize(64, 32);
      leftfoot.mirror = true;
      setRotation(leftfoot, 0F, 0F, 0F);
      leftlegpart2 = new ModelRenderer(this, 0, 16);
      leftlegpart2.addBox(-3F, 5F, -3F, 6, 3, 6);
      leftlegpart2.setRotationPoint(5F, 12F, 0F);
      leftlegpart2.setTextureSize(64, 32);
      leftlegpart2.mirror = true;
      setRotation(leftlegpart2, 0F, 0F, 0F);
      leftlegpart1 = new ModelRenderer(this, 0, 16);
      leftlegpart1.addBox(-3F, 1F, -3F, 6, 3, 6);
      leftlegpart1.setRotationPoint(5F, 12F, 0F);
      leftlegpart1.setTextureSize(64, 32);
      leftlegpart1.mirror = true;
      setRotation(leftlegpart1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    ear1.render(f5);
    leftarmBS1.render(f5);
    rightleg.render(f5);
    body.render(f5);
    body2.render(f5);
    body3.render(f5);
    body4.render(f5);
    leftarmBS2.render(f5);
    leftarmTS1.render(f5);
    leftarmTS2.render(f5);
    rightarmTS2.render(f5);
    rightarmBS1.render(f5);
    rightarmBS2.render(f5);
    rightarmTS1.render(f5);
    head.render(f5);
    ear2.render(f5);
    leftleg.render(f5);
    rightfoot.render(f5);
    rightlegpart.render(f5);
    rightlegpart2.render(f5);
    leftfoot.render(f5);
    leftlegpart2.render(f5);
    leftlegpart1.render(f5);
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
      this.ear1.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.ear1.rotateAngleX = var5 / (180F / (float)Math.PI);
      this.ear2.rotateAngleY = var4 / (180F / (float)Math.PI);
      this.ear2.rotateAngleX = var5 / (180F / (float)Math.PI);
      
      this.rightarmBS1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
      this.rightarmBS2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
      this.rightarmTS1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
      this.rightarmTS2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
      
      this.leftarmBS1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.leftarmBS2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.leftarmTS1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.leftarmTS2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      
      this.rightarmBS1.rotateAngleZ = 0.0F;
      this.rightarmBS2.rotateAngleZ = 0.0F;
      this.rightarmTS1.rotateAngleZ = 0.0F;
      this.rightarmTS2.rotateAngleZ = 0.0F;
      
      this.leftarmBS1.rotateAngleZ = 0.0F;
      this.leftarmBS2.rotateAngleZ = 0.0F;
      this.leftarmTS1.rotateAngleZ = 0.0F;
      this.leftarmTS2.rotateAngleZ = 0.0F;
      
      this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.rightlegpart.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.rightlegpart2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.rightfoot.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      
      this.leftleg.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
      this.leftlegpart1.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
      this.leftlegpart2.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
      this.leftfoot.rotateAngleX = MathHelper.cos((float) (var1 * 0.6662F + Math.PI)) * 1.4F * var2;
      
      this.rightleg.rotateAngleY = 0.0F;
      this.rightlegpart.rotateAngleY = 0.0F;
      this.rightlegpart2.rotateAngleY = 0.0F;
      this.rightfoot.rotateAngleY = 0.0F;
      
      this.leftleg.rotateAngleY = 0.0F;
      this.leftlegpart1.rotateAngleY = 0.0F;
      this.leftlegpart2.rotateAngleY = 0.0F;
      this.leftfoot.rotateAngleY = 0.0F;

      this.rightarmBS1.rotateAngleY = 0.0F;
      this.rightarmBS2.rotateAngleY = 0.0F;
      this.rightarmTS1.rotateAngleY = 0.0F;
      this.rightarmTS2.rotateAngleY = 0.0F;
      
      this.leftarmBS1.rotateAngleY = 0.0F;
      this.leftarmBS2.rotateAngleY = 0.0F;
      this.leftarmTS2.rotateAngleY = 0.0F;
      this.leftarmTS1.rotateAngleY = 0.0F;
      
      this.rightarmBS1.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.rightarmBS2.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.rightarmBS1.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.rightarmBS2.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      
      this.leftarmBS1.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.leftarmBS2.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.leftarmTS1.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.leftarmTS2.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      
      this.rightarmBS1.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.rightarmBS2.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.rightarmTS1.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.rightarmTS2.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      
      this.leftarmBS1.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.leftarmBS2.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.leftarmTS1.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.leftarmTS2.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
  }

}
