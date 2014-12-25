package net.divinerpg.client.render.entity.twilight.model;

import net.divinerpg.entities.twilight.EntityEternalArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEternalArcher extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer shoulder6;
    public ModelRenderer[] armsRight = new ModelRenderer[3];
    public ModelRenderer[] armsLeft = new ModelRenderer[3];
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer shoulder1;
    public ModelRenderer shoulder4;
    public ModelRenderer shoulder3;
    public ModelRenderer shoulder2;
    public ModelRenderer shoulder5;
      
  public ModelEternalArcher() {
    textureWidth = 128;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      shoulder6 = new ModelRenderer(this, 41, 1);
      shoulder6.addBox(-4F, 0F, -2F, 10, 3, 4);
      shoulder6.setRotationPoint(18F, -6F, 0F);
      shoulder6.setTextureSize(128, 32);
      shoulder6.mirror = true;
      setRotation(shoulder6, 0F, 0F, 0F);
      armsRight[0] = new ModelRenderer(this, 110, 16);
      armsRight[0].addBox(-3F, -2-0.5F, -2F, 4, 12, 4);
      armsRight[0].setRotationPoint(-21F, -1F, 0F);
      armsRight[0].setTextureSize(128, 32);
      armsRight[0].mirror = true;
      setRotation(armsRight[0], 0F, 0F, 0F);
      armsLeft[2] = new ModelRenderer(this, 110, 16);
      armsLeft[2].addBox(-1F, -2-0.5F, -2F, 4, 12, 4);
      armsLeft[2].setRotationPoint(21F, -1F, 0F);
      armsLeft[2].setTextureSize(128, 32);
      armsLeft[2].mirror = true;
      setRotation(armsLeft[2], 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-3F, 12F, 0F);
      rightleg.setTextureSize(128, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(3F, 12F, 0F);
      leftleg.setTextureSize(128, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      armsRight[2] = new ModelRenderer(this, 71, 16);
      armsRight[2].addBox(-3F, -2-0.5F, -2F, 4, 12, 4);
      armsRight[2].setRotationPoint(-7F, 5F, 0F);
      armsRight[2].setTextureSize(128, 32);
      armsRight[2].mirror = true;
      setRotation(armsRight[2], 0F, 0F, 0F);
      armsLeft[0] = new ModelRenderer(this, 71, 16);
      armsLeft[0].addBox(-1F, -2-0.5F, -2F, 4, 12, 4);
      armsLeft[0].setRotationPoint(7F, 5F, 0F);
      armsLeft[0].setTextureSize(128, 32);
      armsLeft[0].mirror = true;
      setRotation(armsLeft[0], 0F, 0F, 0F);
      armsLeft[1] = new ModelRenderer(this, 91, 16);
      armsLeft[1].addBox(-1F, -2-0.5F, -2F, 4, 12, 4);
      armsLeft[1].setRotationPoint(14F, 2F, 0F);
      armsLeft[1].setTextureSize(128, 32);
      armsLeft[1].mirror = true;
      setRotation(armsLeft[1], 0F, 0F, 0F);
      armsRight[1] = new ModelRenderer(this, 91, 16);
      armsRight[1].addBox(-3F, -2-0.5F, -2F, 4, 12, 4);
      armsRight[1].setRotationPoint(-14F, 2F, 0F);
      armsRight[1].setTextureSize(128, 32);
      armsRight[1].mirror = true;
      setRotation(armsRight[1], 0F, 0F, 0F);
      body = new ModelRenderer(this, 46, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      shoulder1 = new ModelRenderer(this, 41, 1);
      shoulder1.addBox(-4F, 0F, -2F, 10, 3, 4);
      shoulder1.setRotationPoint(-20F, -6F, 0F);
      shoulder1.setTextureSize(128, 32);
      shoulder1.mirror = true;
      setRotation(shoulder1, 0F, 0F, 0F);
      shoulder4 = new ModelRenderer(this, 19, 24);
      shoulder4.addBox(-4F, 0F, -2F, 6, 3, 4);
      shoulder4.setRotationPoint(8F, 0F, 0F);
      shoulder4.setTextureSize(128, 32);
      shoulder4.mirror = true;
      setRotation(shoulder4, 0F, 0F, 0F);
      shoulder3 = new ModelRenderer(this, 19, 24);
      shoulder3.addBox(-4F, 0F, -2F, 6, 3, 4);
      shoulder3.setRotationPoint(-6F, 0F, 0F);
      shoulder3.setTextureSize(128, 32);
      shoulder3.mirror = true;
      setRotation(shoulder3, 0F, 0F, 0F);
      shoulder2 = new ModelRenderer(this, 17, 16);
      shoulder2.addBox(-4F, 0F, -2F, 10, 3, 4);
      shoulder2.setRotationPoint(-13F, -3F, 0F);
      shoulder2.setTextureSize(128, 32);
      shoulder2.mirror = true;
      setRotation(shoulder2, 0F, 0F, 0F);
      shoulder5 = new ModelRenderer(this, 17, 16);
      shoulder5.addBox(-4F, 0F, -2F, 10, 3, 4);
      shoulder5.setRotationPoint(11F, -3F, 0F);
      shoulder5.setTextureSize(128, 32);
      shoulder5.mirror = true;
      setRotation(shoulder5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    shoulder6.render(f5);
    armsRight[0].render(f5);
    armsLeft[2].render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    armsRight[2].render(f5);
    armsLeft[0].render(f5);
    armsLeft[1].render(f5);
    armsRight[1].render(f5);
    body.render(f5);
    shoulder1.render(f5);
    shoulder4.render(f5);
    shoulder3.render(f5);
    shoulder2.render(f5);
    shoulder5.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    
    for(ModelRenderer r : this.armsRight) {
    	r.rotateAngleX = 0;
    }
    
    for(ModelRenderer r : this.armsLeft) {
    	r.rotateAngleX = 0;
    }
    
    int s = ((EntityEternalArcher)entity).getSelectedArm();
    
    if(s<3) this.armsRight[s].rotateAngleX -= 0.4;
    else this.armsLeft[s-3].rotateAngleX -= 0.4;
  }

}
