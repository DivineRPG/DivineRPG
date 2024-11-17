package net.divinerpg.client.render.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModelPresentBox extends ModelBase {
    public ModelRenderer lid;
    public ModelRenderer base;
    public ModelRenderer knob;

    public ModelPresentBox() {
    	this.textureWidth = this.textureHeight = 128;
    	this.lid = (new ModelRenderer(this, 0, 0));
        this.lid.addBox(-1.0F, -8.0F, -33.0F, 32, 7, 32, 0.0F);
        this.lid.rotationPointX = 1.0F;
        this.lid.rotationPointY = 7.0F;
        this.lid.rotationPointZ = 33.0F;
        /*this.knob = (new ModelRenderer(this, 0, 0));
        this.knob.addBox(-2.0F, -4.0F, -30.0F, 4, 8, 2, 0.0F);
        this.knob.rotationPointX = 8.0F;
        this.knob.rotationPointY = 7.0F;
        this.knob.rotationPointZ = 15.0F;*/
        this.base = (new ModelRenderer(this, 0, 40));
        this.base.addBox(-1.0F, -1.0F, -1.0F, 32, 27, 32, 0.0F);
        this.base.rotationPointX = 1.0F;
        this.base.rotationPointY = 6.0F;
        this.base.rotationPointZ = 1.0F;
    }

    public void renderAll() {
        //this.knob.rotateAngleX = this.lid.rotateAngleX;
        this.lid.render(0.03125F);
        //this.knob.render(0.03125F);
        this.base.render(0.03125F);
    }
}