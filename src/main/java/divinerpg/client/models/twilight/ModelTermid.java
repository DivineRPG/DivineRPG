package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTermid<T extends Entity> extends SegmentedModel<T> {
  //fields
    ModelRenderer legR;
    ModelRenderer legL;
    ModelRenderer body;
    ModelRenderer ridge1;
    ModelRenderer ridge2;
    ModelRenderer ridge3;
    ModelRenderer ridge4;
    ModelRenderer ridge5;
    ModelRenderer ridge6;
    ModelRenderer ridge7;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer jawL;
    ModelRenderer jawR;
  
  public ModelTermid()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      legR = new ModelRenderer(this, 0, 19);
      legR.addBox(-1F, 0F, -1F, 2, 4, 2);
      legR.setRotationPoint(-2.5F, 20F, 0F);
      legR.setTextureSize(128, 64);
      legR.mirror = true;
      setRotation(legR, 0F, 0F, 0F);
      legL = new ModelRenderer(this, 0, 19);
      legL.addBox(-1F, 0F, -1F, 2, 4, 2);
      legL.setRotationPoint(2.5F, 20F, 0F);
      legL.setTextureSize(128, 64);
      legL.mirror = true;
      setRotation(legL, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 6, 15, 4);
      body.setRotationPoint(-3F, 5F, -2F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      ridge1 = new ModelRenderer(this, 20, 0);
      ridge1.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge1.setRotationPoint(-4F, 18F, -3F);
      ridge1.setTextureSize(128, 64);
      ridge1.mirror = true;
      setRotation(ridge1, 0F, 0F, 0F);
      ridge2 = new ModelRenderer(this, 20, 0);
      ridge2.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge2.setRotationPoint(-4F, 16F, -3F);
      ridge2.setTextureSize(128, 64);
      ridge2.mirror = true;
      setRotation(ridge2, 0F, 0F, 0F);
      ridge3 = new ModelRenderer(this, 20, 0);
      ridge3.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge3.setRotationPoint(-4F, 14F, -3F);
      ridge3.setTextureSize(128, 64);
      ridge3.mirror = true;
      setRotation(ridge3, 0F, 0F, 0F);
      ridge4 = new ModelRenderer(this, 20, 0);
      ridge4.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge4.setRotationPoint(-4F, 12F, -3F);
      ridge4.setTextureSize(128, 64);
      ridge4.mirror = true;
      setRotation(ridge4, 0F, 0F, 0F);
      ridge5 = new ModelRenderer(this, 20, 0);
      ridge5.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge5.setRotationPoint(-4F, 10F, -3F);
      ridge5.setTextureSize(128, 64);
      ridge5.mirror = true;
      setRotation(ridge5, 0F, 0F, 0F);
      ridge6 = new ModelRenderer(this, 20, 0);
      ridge6.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge6.setRotationPoint(-4F, 8F, -3F);
      ridge6.setTextureSize(128, 64);
      ridge6.mirror = true;
      setRotation(ridge6, 0F, 0F, 0F);
      ridge7 = new ModelRenderer(this, 20, 0);
      ridge7.addBox(0F, 0F, 0F, 8, 1, 6);
      ridge7.setRotationPoint(-4F, 6F, -3F);
      ridge7.setTextureSize(128, 64);
      ridge7.mirror = true;
      setRotation(ridge7, 0F, 0F, 0F);
      neck = new ModelRenderer(this, 22, 25);
      neck.addBox(-1.5F, -6F, -1.5F, 3, 6, 3);
      neck.setRotationPoint(0F, 6F, 1F);
      neck.setTextureSize(128, 64);
      neck.mirror = true;
      setRotation(neck, 0.7853982F, 0F, 0F);
      head = new ModelRenderer(this, 0, 25);
      head.addBox(-3F, -6F, -2.5F, 6, 6, 5);
      head.setRotationPoint(0F, 3F, -3F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      jawL = new ModelRenderer(this, 0, 36);
      jawL.addBox(2F, -1F, -5.5F, 1, 1, 3);
      jawL.setRotationPoint(0F, 3F, -3F);
      jawL.setTextureSize(128, 64);
      jawL.mirror = true;
      setRotation(jawL, 0F, 0F, 0F);
      jawR = new ModelRenderer(this, 0, 36);
      jawR.addBox(-3F, -1F, -5.5F, 1, 1, 3);
      jawR.setRotationPoint(0F, 3F, -3F);
      jawR.setTextureSize(128, 64);
      jawR.mirror = true;
      setRotation(jawR, 0F, 0F, 0F);
  }

  @Override
  public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
  //TODO - Termid limb swing
  }

  @Override
  public Iterable<ModelRenderer> getParts() {
    return ImmutableList.of(legR, legL, body, ridge1, ridge2, ridge3, ridge4, ridge5, ridge6, ridge7, neck, head, jawL, jawR);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }


}
