package net.divinerpg.client.render.entity.twilight;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.entity.twilight.model.ModelDensos;
import net.divinerpg.client.render.entity.twilight.model.ModelSunArcher;
import net.divinerpg.items.base.ItemModBow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

public class RenderSunArcher extends RenderLiving {
    
    private float scale;
    public int bossTextureID;
    
    public RenderSunArcher() {
        super(new ModelSunArcher(), 0.25f);
    }
    
    @Override
    protected void renderEquippedItems(EntityLivingBase var1, float var2) {
        super.renderEquippedItems(var1, var2);
        ItemStack var3 = var1.getHeldItem();

        if (var3 != null) {
            GL11.glPushMatrix();
            ((ModelSunArcher)this.mainModel).armRight.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            IItemRenderer var5 = MinecraftForgeClient.getItemRenderer(var3, IItemRenderer.ItemRenderType.EQUIPPED);
            boolean var6 = (var5 != null) && (var5.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, var3, IItemRenderer.ItemRendererHelper.BLOCK_3D));

            float var4 = 0.38F;
            GL11.glTranslatef(0.05F, 0.3F, -0.25F);
            GL11.glScalef(var4, -var4, var4);
            if(var3.getItem() instanceof ItemModBow)GL11.glRotatef(120.0F, -0.3F, 1.0F, -1.2F);
            else {
                GL11.glRotatef(-40.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.5f, -0.4f, 0f);
            }

            this.renderManager.itemRenderer.renderItem(var1, var3, 0);

            if (var3.getItem().requiresMultipleRenderPasses()) {
                for (int var7 = 1; var7 < var3.getItem().getRenderPasses(var3.getItemDamage()); var7++) {
                    this.renderManager.itemRenderer.renderItem(var1, var3, var7);
                }
            }

            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity e) {
        return EntityResourceLocation.sunArcher;
    }
}