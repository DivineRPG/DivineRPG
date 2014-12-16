package net.divinerpg.client.render.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEdenChest extends ModelBase
{
    public ModelRenderer chestLid = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
    public ModelRenderer chestBelow;
    public ModelRenderer chestKnobLeft;
    public ModelRenderer chestKnobMiddle;
    public ModelRenderer chestKnobRight;

    public ModelEdenChest()
    {
        this.chestLid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.chestLid.rotationPointX = 1.0F;
        this.chestLid.rotationPointY = 7.0F;
        this.chestLid.rotationPointZ = 15.0F;
        this.chestKnobLeft = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        this.chestKnobLeft.addBox(-5.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobLeft.rotationPointX = 8.0F;
        this.chestKnobLeft.rotationPointY = 7.0F;
        this.chestKnobLeft.rotationPointZ = 15.0F;
        this.chestKnobMiddle = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        this.chestKnobMiddle.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobMiddle.rotationPointX = 8.0F;
        this.chestKnobMiddle.rotationPointY = 7.0F;
        this.chestKnobMiddle.rotationPointZ = 15.0F;
        this.chestKnobRight = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        this.chestKnobRight.addBox(3.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestKnobRight.rotationPointX = 8.0F;
        this.chestKnobRight.rotationPointY = 7.0F;
        this.chestKnobRight.rotationPointZ = 15.0F;
        this.chestBelow = (new ModelRenderer(this, 0, 19)).setTextureSize(64, 64);
        this.chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        this.chestBelow.rotationPointX = 1.0F;
        this.chestBelow.rotationPointY = 6.0F;
        this.chestBelow.rotationPointZ = 1.0F;
    }

    public void renderAll()
    {
    	this.chestKnobRight.rotateAngleX = this.chestKnobMiddle.rotateAngleX = this.chestKnobLeft.rotateAngleX = this.chestLid.rotateAngleX;
        this.chestLid.render(0.0625F);
        this.chestKnobLeft.render(0.0625F);
        this.chestKnobMiddle.render(0.0625F);
        this.chestKnobRight.render(0.0625F);
        this.chestBelow.render(0.0625F);
    }
}