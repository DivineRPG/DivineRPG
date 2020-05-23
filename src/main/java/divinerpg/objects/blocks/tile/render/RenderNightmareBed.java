package divinerpg.objects.blocks.tile.render;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityNightmareBed;
import net.minecraft.client.model.ModelBed;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class RenderNightmareBed extends TileEntitySpecialRenderer<TileEntityNightmareBed>
{
    private static final ResourceLocation[] TEXTURES;
    private ModelBed model = new ModelBed();
    private int version;

    public RenderNightmareBed()
    {
        this.version = this.model.getModelVersion();
    }

    public void render(TileEntityNightmareBed te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if (this.version != this.model.getModelVersion())
        {
            this.model = new ModelBed();
            this.version = this.model.getModelVersion();
        }

        boolean flag = te.getWorld() != null;
        boolean flag1 = !flag || te.isHeadPiece();
        int i = flag ? te.getBlockMetadata() & 3 : 0;

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            ResourceLocation resourcelocation = new ResourceLocation(DivineRPG.MODID, "textures/blocks/nightmare.png");
            

            if (resourcelocation != null)
            {
                this.bindTexture(resourcelocation);
            }
        }

        if (flag)
        {
            this.renderPiece(flag1, x, y, z, i, alpha);
        }
        else
        {
            GlStateManager.pushMatrix();
            this.renderPiece(true, x, y, z, i, alpha);
            this.renderPiece(false, x, y, z - 1.0D, i, alpha);
            GlStateManager.popMatrix();
        }

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }

    private void renderPiece(boolean p_193847_1_, double x, double y, double z, int p_193847_8_, float alpha)
    {
        this.model.preparePiece(p_193847_1_);
        GlStateManager.pushMatrix();
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;

        if (p_193847_8_ == EnumFacing.NORTH.getHorizontalIndex())
        {
            f = 0.0F;
        }
        else if (p_193847_8_ == EnumFacing.SOUTH.getHorizontalIndex())
        {
            f = 180.0F;
            f1 = 1.0F;
            f2 = 1.0F;
        }
        else if (p_193847_8_ == EnumFacing.WEST.getHorizontalIndex())
        {
            f = -90.0F;
            f2 = 1.0F;
        }
        else if (p_193847_8_ == EnumFacing.EAST.getHorizontalIndex())
        {
            f = 90.0F;
            f1 = 1.0F;
        }

        GlStateManager.translate((float)x + f1, (float)y + 0.5625F, (float)z + f2);
        GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, 0.0F, 1.0F);
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        this.model.render();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        GlStateManager.popMatrix();
    }

    static
    {
        EnumDyeColor[] aenumdyecolor = EnumDyeColor.values();
        TEXTURES = new ResourceLocation[aenumdyecolor.length];

        for (EnumDyeColor enumdyecolor : aenumdyecolor)
        {
            TEXTURES[enumdyecolor.getMetadata()] = new ResourceLocation(DivineRPG.MODID, "textures/entity/bed/nightmare.png");
        }
    }
}