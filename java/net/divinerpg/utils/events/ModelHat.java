package net.divinerpg.utils.events;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHat extends ModelBase
{
    public ModelRenderer top;
    public ModelRenderer bottom;

    public ModelHat()
    {
    	this.top = new ModelRenderer(this, 0, 0).setTextureSize(128, 128);
        this.top.addBox(4f, 1f, 4f, 8, 8, 8, 0.0F);
        this.bottom = new ModelRenderer(this, 32, 0).setTextureSize(128, 128);
        this.bottom.addBox(2F, 0F, 2F, 12, 2, 12, 0.0F);
    }

    public void renderAll()
    {
    	GL11.glPushMatrix();
    	GL11.glRotatef(180, 0, 0, 1);
    	GL11.glTranslatef(-1f, -0.6f, 0f);
        this.top.render(0.0625F);
    	GL11.glPopMatrix();
        this.bottom.render(0.0625F);
    }
}