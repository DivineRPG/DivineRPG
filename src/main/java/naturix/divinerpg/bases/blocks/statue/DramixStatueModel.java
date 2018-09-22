package naturix.divinerpg.bases.blocks.statue;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DramixStatueModel extends ModelBase
{
	ModelRenderer Leg_Right;
    ModelRenderer Leg_Left;
    ModelRenderer Arm_Right;
    ModelRenderer Arm_Left;
    ModelRenderer Head;
    ModelRenderer Chest;

    public DramixStatueModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        Leg_Right = new ModelRenderer(this, 0, 22);
        Leg_Right.addBox(-2F, -2F, -3F, 5, 15, 6);
        Leg_Right.setRotationPoint(-4F, 11F, 1F);
        Leg_Right.setTextureSize(64, 64);
        Leg_Right.mirror = true;
        setRotation(Leg_Right, 0F, 0F, 0F);
        Leg_Left = new ModelRenderer(this, 0, 22);
        Leg_Left.addBox(-3F, -2F, -3F, 5, 15, 6);
        Leg_Left.setRotationPoint(4F, 11F, 1F);
        Leg_Left.setTextureSize(64, 64);
        Leg_Left.mirror = true;
        setRotation(Leg_Left, -0.8922867F, 0F, 0F);
        Arm_Right = new ModelRenderer(this, 22, 22);
        Arm_Right.addBox(-2F, -2F, -3F, 4, 16, 6);
        Arm_Right.setRotationPoint(-8F, -5F, 1F);
        Arm_Right.setTextureSize(64, 64);
        Arm_Right.mirror = true;
        setRotation(Arm_Right, -2.342252F, 0F, 0F);
        Arm_Right.mirror = false;
        Arm_Left = new ModelRenderer(this, 22, 22);
        Arm_Left.addBox(-2F, -2F, -3F, 4, 16, 6);
        Arm_Left.setRotationPoint(8F, -5F, 1F);
        Arm_Left.setTextureSize(64, 64);
        Arm_Left.mirror = true;
        setRotation(Arm_Left, -2.342252F, 0F, 0F);
        Head = new ModelRenderer(this, 36, 0);
        Head.addBox(-3F, -5F, -3F, 6, 10, 6);
        Head.setRotationPoint(0F, -12F, 1F);
        Head.setTextureSize(64, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Chest = new ModelRenderer(this, 0, 0);
        Chest.addBox(-6F, -7F, -2F, 12, 16, 6);
        Chest.setRotationPoint(0F, 0F, 0F);
        Chest.setTextureSize(64, 64);
        Chest.mirror = true;
        setRotation(Chest, 0F, 0F, 0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        Leg_Right.render(var7);
        Leg_Left.render(var7);
        Arm_Right.render(var7);
        Arm_Left.render(var7);
        Head.render(var7);
        Chest.render(var7);
        
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}

