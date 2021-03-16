package divinerpg.client.models.iceika;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraftforge.api.distmarker.*;
import org.lwjgl.opengl.*;

@OnlyIn(Dist.CLIENT)
public class ModelFrosty<T extends Entity> extends SegmentedModel<T> {
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
    texWidth = 256;
    texHeight = 32;
    
      hatBase = new ModelRenderer(this, 105, 18);
      hatBase.addBox(0F, 0F, 0F, 12, 2, 12);
      hatBase.setPos(-6F, -10F, -6F);
      hatBase.setTexSize(256, 32);
      hatBase.mirror = true;
      setRotation(hatBase, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 0);
      bottom.addBox(0F, 0F, 0F, 16, 13, 16);
      bottom.setPos(-8F, 11F, -8F);
      bottom.setTexSize(256, 32);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      rightFinger1 = new ModelRenderer(this, 51, 0);
      rightFinger1.addBox(-1F, 7F, -16F, 1, 1, 5);
      rightFinger1.setPos(-5F, 2F, 3F);
      rightFinger1.setTexSize(256, 32);
      rightFinger1.mirror = true;
      setRotation(rightFinger1, -0.2093362F, 0.6578549F, 0F);
      middle = new ModelRenderer(this, 159, 0);
      middle.addBox(0F, 0F, 0F, 12, 13, 12);
      middle.setPos(-6F, 1F, -6F);
      middle.setTexSize(256, 32);
      middle.mirror = true;
      setRotation(middle, 0F, 0F, 0F);
      rightArm = new ModelRenderer(this, 66, 0);
      rightArm.addBox(0F, 0F, -12F, 2, 2, 12);
      rightArm.setPos(-6F, 2F, 2F);
      rightArm.setTexSize(256, 32);
      rightArm.mirror = true;
      setRotation(rightArm, 0.3490659F, 0.7853982F, 0F);
      leftArm = new ModelRenderer(this, 66, 0);
      leftArm.addBox(0F, 0F, -12F, 2, 2, 12);
      leftArm.setPos(5F, 2F, 2F);
      leftArm.setTexSize(256, 32);
      leftArm.mirror = true;
      setRotation(leftArm, 0.3490659F, -0.7853982F, 0F);
      rightFinger3 = new ModelRenderer(this, 51, 0);
      rightFinger3.addBox(4F, -2F, -15F, 1, 1, 5);
      rightFinger3.setPos(-5F, 2F, 3F);
      rightFinger3.setTexSize(256, 32);
      rightFinger3.mirror = true;
      setRotation(rightFinger3, 0.6457718F, 1.178355F, 0F);
      rightFinger2 = new ModelRenderer(this, 51, 0);
      rightFinger2.addBox(-5F, -6F, -17F, 1, 1, 5);
      rightFinger2.setPos(-5F, 2F, 3F);
      rightFinger2.setTexSize(256, 32);
      rightFinger2.mirror = true;
      setRotation(rightFinger2, 0.7944863F, 0.3232474F, 0F);
      leftFinger2 = new ModelRenderer(this, 51, 0);
      leftFinger2.addBox(-2F, -6F, -17F, 1, 1, 5);
      leftFinger2.setPos(4F, 2F, 3F);
      leftFinger2.setTexSize(256, 32);
      leftFinger2.mirror = true;
      setRotation(leftFinger2, 0.7944863F, -1.029641F, 0F);
      leftFinger3 = new ModelRenderer(this, 51, 0);
      leftFinger3.addBox(7F, -2F, -15F, 1, 1, 5);
      leftFinger3.setPos(4F, 2F, 3F);
      leftFinger3.setTexSize(256, 32);
      leftFinger3.mirror = true;
      setRotation(leftFinger3, 0.6457718F, -0.1745329F, 0F);
      leftFinger1 = new ModelRenderer(this, 51, 0);
      leftFinger1.addBox(2F, 7F, -16F, 1, 1, 5);
      leftFinger1.setPos(4F, 2F, 3F);
      leftFinger1.setTexSize(256, 32);
      leftFinger1.mirror = true;
      setRotation(leftFinger1, -0.2093362F, -0.6950335F, 0F);
      hatTop = new ModelRenderer(this, 65, 17);
      hatTop.addBox(0F, 0F, 0F, 8, 7, 8);
      hatTop.setPos(-4F, -17F, -4F);
      hatTop.setTexSize(256, 32);
      hatTop.mirror = true;
      setRotation(hatTop, 0F, 0F, 0F);
      head = new ModelRenderer(this, 96, 0);
      head.addBox(0F, 0F, 0F, 8, 9, 8);
      head.setPos(-4F, -8F, -4F);
      head.setTexSize(256, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
  }

  public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
    GL11.glPushMatrix();
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    GL11.glDepthMask(true);
    GL11.glEnable(GL11.GL_ALPHA_TEST);
    GL11.glDisable(GL11.GL_BLEND);
    GL11.glPopMatrix();
  }
  @Override
  public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

  }

  @Override
  public Iterable<ModelRenderer> parts() {
    return ImmutableList.of(hatBase, rightFinger1, bottom, middle, head, rightArm, leftArm, rightFinger3, rightFinger2, leftFinger2, leftFinger3, leftFinger1, hatTop);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.xRot = x;
    model.yRot = y;
    model.zRot = z;
  }

}
