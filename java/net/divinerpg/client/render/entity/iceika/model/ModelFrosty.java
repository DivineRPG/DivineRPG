package net.divinerpg.client.render.entity.iceika.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFrosty extends ModelBase
{
    ModelRenderer hatBase;
    ModelRenderer bottom;
    ModelRenderer rightFinger1;
    ModelRenderer middle;
    ModelRenderer rightArm;
    ModelRenderer leftArm;
    ModelRenderer rightFinger3;
    ModelRenderer rightFinger2;
    ModelRenderer leftFinger2;
    ModelRenderer leftFinger3;
    ModelRenderer leftFinger1;
    ModelRenderer hatTop;
    ModelRenderer head;
  
  public ModelFrosty()
  {
    textureWidth = 256;
    textureHeight = 32;
    
      hatBase = new ModelRenderer(this, 105, 18);
      hatBase.addBox(0F, 0F, 0F, 12, 2, 12);
      hatBase.setRotationPoint(-6F, -10F, -6F);
      hatBase.setTextureSize(256, 32);
      hatBase.mirror = true;
      setRotation(hatBase, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 0);
      bottom.addBox(0F, 0F, 0F, 16, 13, 16);
      bottom.setRotationPoint(-8F, 11F, -8F);
      bottom.setTextureSize(256, 32);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      rightFinger1 = new ModelRenderer(this, 51, 0);
      rightFinger1.addBox(-1F, 7F, -16F, 1, 1, 5);
      rightFinger1.setRotationPoint(-5F, 2F, 3F);
      rightFinger1.setTextureSize(256, 32);
      rightFinger1.mirror = true;
      setRotation(rightFinger1, -0.2093362F, 0.6578549F, 0F);
      middle = new ModelRenderer(this, 159, 0);
      middle.addBox(0F, 0F, 0F, 12, 13, 12);
      middle.setRotationPoint(-6F, 1F, -6F);
      middle.setTextureSize(256, 32);
      middle.mirror = true;
      setRotation(middle, 0F, 0F, 0F);
      rightArm = new ModelRenderer(this, 66, 0);
      rightArm.addBox(0F, 0F, -12F, 2, 2, 12);
      rightArm.setRotationPoint(-6F, 2F, 2F);
      rightArm.setTextureSize(256, 32);
      rightArm.mirror = true;
      setRotation(rightArm, 0.3490659F, 0.7853982F, 0F);
      leftArm = new ModelRenderer(this, 66, 0);
      leftArm.addBox(0F, 0F, -12F, 2, 2, 12);
      leftArm.setRotationPoint(5F, 2F, 2F);
      leftArm.setTextureSize(256, 32);
      leftArm.mirror = true;
      setRotation(leftArm, 0.3490659F, -0.7853982F, 0F);
      rightFinger3 = new ModelRenderer(this, 51, 0);
      rightFinger3.addBox(4F, -2F, -15F, 1, 1, 5);
      rightFinger3.setRotationPoint(-5F, 2F, 3F);
      rightFinger3.setTextureSize(256, 32);
      rightFinger3.mirror = true;
      setRotation(rightFinger3, 0.6457718F, 1.178355F, 0F);
      rightFinger2 = new ModelRenderer(this, 51, 0);
      rightFinger2.addBox(-5F, -6F, -17F, 1, 1, 5);
      rightFinger2.setRotationPoint(-5F, 2F, 3F);
      rightFinger2.setTextureSize(256, 32);
      rightFinger2.mirror = true;
      setRotation(rightFinger2, 0.7944863F, 0.3232474F, 0F);
      leftFinger2 = new ModelRenderer(this, 51, 0);
      leftFinger2.addBox(-2F, -6F, -17F, 1, 1, 5);
      leftFinger2.setRotationPoint(4F, 2F, 3F);
      leftFinger2.setTextureSize(256, 32);
      leftFinger2.mirror = true;
      setRotation(leftFinger2, 0.7944863F, -1.029641F, 0F);
      leftFinger3 = new ModelRenderer(this, 51, 0);
      leftFinger3.addBox(7F, -2F, -15F, 1, 1, 5);
      leftFinger3.setRotationPoint(4F, 2F, 3F);
      leftFinger3.setTextureSize(256, 32);
      leftFinger3.mirror = true;
      setRotation(leftFinger3, 0.6457718F, -0.1745329F, 0F);
      leftFinger1 = new ModelRenderer(this, 51, 0);
      leftFinger1.addBox(2F, 7F, -16F, 1, 1, 5);
      leftFinger1.setRotationPoint(4F, 2F, 3F);
      leftFinger1.setTextureSize(256, 32);
      leftFinger1.mirror = true;
      setRotation(leftFinger1, -0.2093362F, -0.6950335F, 0F);
      hatTop = new ModelRenderer(this, 65, 17);
      hatTop.addBox(0F, 0F, 0F, 8, 7, 8);
      hatTop.setRotationPoint(-4F, -17F, -4F);
      hatTop.setTextureSize(256, 32);
      hatTop.mirror = true;
      setRotation(hatTop, 0F, 0F, 0F);
      head = new ModelRenderer(this, 96, 0);
      head.addBox(0F, 0F, 0F, 8, 9, 8);
      head.setRotationPoint(-4F, -8F, -4F);
      head.setTextureSize(256, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    GL11.glPushMatrix();
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    GL11.glDepthMask(true);
    GL11.glEnable(GL11.GL_ALPHA_TEST);
    hatBase.render(f5);
    rightFinger1.render(f5);
    bottom.render(f5);
    middle.render(f5);
    head.render(f5);
    rightArm.render(f5);
    leftArm.render(f5);
    rightFinger3.render(f5);
    rightFinger2.render(f5);
    leftFinger2.render(f5);
    leftFinger3.render(f5);
    leftFinger1.render(f5);
    hatTop.render(f5);
    GL11.glDisable(GL11.GL_BLEND);
    GL11.glPopMatrix();
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
