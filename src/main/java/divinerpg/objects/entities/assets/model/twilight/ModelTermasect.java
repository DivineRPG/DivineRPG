package divinerpg.objects.entities.assets.model.twilight;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTermasect extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer base3;
    ModelRenderer body;
    ModelRenderer headR;
    ModelRenderer headL;
    ModelRenderer neck;
    ModelRenderer headMid;
    ModelRenderer slab1;
    ModelRenderer slab2;
    ModelRenderer slab3;
    ModelRenderer slab4;
    ModelRenderer armRa;
    ModelRenderer armLa;
    ModelRenderer armRb;
    ModelRenderer armLb;
    ModelRenderer armRc;
    ModelRenderer armRc2;
  
  public ModelTermasect()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      base1 = new ModelRenderer(this, 0, 0);
      base1.addBox(-3F, 0F, -3F, 6, 1, 6);
      base1.setRotationPoint(0F, 20F, 0F);
      base1.setTextureSize(128, 128);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 0, 7);
      base2.addBox(-5F, 0F, -5F, 10, 1, 10);
      base2.setRotationPoint(0F, 16F, 0F);
      base2.setTextureSize(128, 128);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      base3 = new ModelRenderer(this, 0, 18);
      base3.addBox(-7F, 0F, -7F, 14, 1, 14);
      base3.setRotationPoint(0F, 12F, 0F);
      base3.setTextureSize(128, 128);
      base3.mirror = true;
      setRotation(base3, 0F, 0F, 0F);
      body = new ModelRenderer(this, 56, 0);
      body.addBox(-6F, 0F, -6F, 12, 24, 12);
      body.setRotationPoint(0F, -15F, 0F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      headR = new ModelRenderer(this, 0, 33);
      headR.addBox(-3F, -6F, -5F, 6, 6, 5);
      headR.setRotationPoint(-4F, -12F, -3F);
      headR.setTextureSize(128, 128);
      headR.mirror = true;
      setRotation(headR, 0F, 0F, 0F);
      headL = new ModelRenderer(this, 0, 33);
      headL.addBox(-3F, -6F, -5F, 6, 6, 5);
      headL.setRotationPoint(4F, -12F, -3F);
      headL.setTextureSize(128, 128);
      headL.mirror = true;
      setRotation(headL, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 0, 44);
      neck.addBox(-1F, 0F, -1F, 2, 6, 2);
      neck.setRotationPoint(0F, -21F, 0F);
      neck.setTextureSize(128, 128);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      headMid = new ModelRenderer(this, 0, 33);
      headMid.addBox(-3F, -6F, -5F, 6, 6, 5);
      headMid.setRotationPoint(0F, -19F, 0F);
      headMid.setTextureSize(128, 128);
      headMid.mirror = true;
      setRotation(headMid, 0F, 0F, 0F);
      slab1 = new ModelRenderer(this, 0, 52);
      slab1.addBox(-8F, 0F, -8F, 16, 2, 16);
      slab1.setRotationPoint(0F, 5F, 0F);
      slab1.setTextureSize(128, 128);
      slab1.mirror = true;
      setRotation(slab1, 0F, 0F, 0F);
      slab2 = new ModelRenderer(this, 0, 52);
      slab2.addBox(-8F, 0F, -8F, 16, 2, 16);
      slab2.setRotationPoint(0F, 1F, 0F);
      slab2.setTextureSize(128, 128);
      slab2.mirror = true;
      setRotation(slab2, 0F, 0F, 0F);
      slab3 = new ModelRenderer(this, 0, 52);
      slab3.addBox(-8F, 0F, -8F, 16, 2, 16);
      slab3.setRotationPoint(0F, -3F, 0F);
      slab3.setTextureSize(128, 128);
      slab3.mirror = true;
      setRotation(slab3, 0F, 0F, 0F);
      slab4 = new ModelRenderer(this, 0, 52);
      slab4.addBox(-8F, 0F, -8F, 16, 2, 16);
      slab4.setRotationPoint(0F, -7F, 0F);
      slab4.setTextureSize(128, 128);
      slab4.mirror = true;
      setRotation(slab4, 0F, 0F, 0F);
      armRa = new ModelRenderer(this, 0, 70);
      armRa.addBox(-2F, -0.5F, -2F, 4, 14, 4);
      armRa.setRotationPoint(-5F, -13F, 0F);
      armRa.setTextureSize(128, 128);
      armRa.mirror = true;
      setRotation(armRa, 0F, 0F, 0.7853982F);
      armLa = new ModelRenderer(this, 0, 70);
      armLa.addBox(-2F, -0.5F, -2F, 4, 14, 4);
      armLa.setRotationPoint(5F, -13F, 0F);
      armLa.setTextureSize(128, 128);
      armLa.mirror = true;
      setRotation(armLa, 0F, 0F, -0.7853982F);
      armRb = new ModelRenderer(this, 16, 70);
      armRb.addBox(-2F, 9.5F, -10F, 4, 4, 8);
      armRb.setRotationPoint(-5F, -13F, 0F);
      armRb.setTextureSize(128, 128);
      armRb.mirror = true;
      setRotation(armRb, 0F, 0F, 0.7853982F);
      armLb = new ModelRenderer(this, 16, 70);
      armLb.addBox(-2F, 9.5F, -10F, 4, 4, 8);
      armLb.setRotationPoint(5F, -13F, 0F);
      armLb.setTextureSize(128, 128);
      armLb.mirror = true;
      setRotation(armLb, 0F, 0F, -0.7853982F);
      armRc = new ModelRenderer(this, 40, 70);
      armRc.addBox(-1F, 10.5F, -16F, 2, 2, 6);
      armRc.setRotationPoint(-5F, -13F, 0F);
      armRc.setTextureSize(128, 128);
      armRc.mirror = true;
      setRotation(armRc, 0F, 0F, 0.7853982F);
      armRc2 = new ModelRenderer(this, 40, 70);
      armRc2.addBox(-1F, 10.5F, -16F, 2, 2, 6);
      armRc2.setRotationPoint(5F, -13F, 0F);
      armRc2.setTextureSize(128, 128);
      armRc2.mirror = true;
      setRotation(armRc2, 0F, 0F, -0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    GL11.glScaled(5, 5, 5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    base1.render(f5);
    base2.render(f5);
    base3.render(f5);
    body.render(f5);
    headR.render(f5);
    headL.render(f5);
    neck.render(f5);
    headMid.render(f5);
    slab1.render(f5);
    slab2.render(f5);
    slab3.render(f5);
    slab4.render(f5);
    armRa.render(f5);
    armLa.render(f5);
    armRb.render(f5);
    armLb.render(f5);
    armRc.render(f5);
    armRc2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
