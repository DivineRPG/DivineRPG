package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import divinerpg.DivineRPG;
import divinerpg.blocks.vethea.BlockNightmareBed;
import divinerpg.registries.TileRegistry;
import divinerpg.tiles.TileEntityNightmareBed;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.state.properties.BedPart;
import net.minecraft.tileentity.BedTileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderNightmareBed extends TileEntityRenderer<TileEntityNightmareBed> {
    private final ModelRenderer field_228843_a_;
    private final ModelRenderer field_228844_c_;
    private final ModelRenderer[] field_228845_d_ = new ModelRenderer[4];

    public RenderNightmareBed(TileEntityRendererDispatcher p_i226004_1_) {
        super(p_i226004_1_);
        this.field_228843_a_ = new ModelRenderer(64, 64, 0, 0);
        this.field_228843_a_.addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F, 0.0F);
        this.field_228844_c_ = new ModelRenderer(64, 64, 0, 22);
        this.field_228844_c_.addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F, 0.0F);
        this.field_228845_d_[0] = new ModelRenderer(64, 64, 50, 0);
        this.field_228845_d_[1] = new ModelRenderer(64, 64, 50, 6);
        this.field_228845_d_[2] = new ModelRenderer(64, 64, 50, 12);
        this.field_228845_d_[3] = new ModelRenderer(64, 64, 50, 18);
        this.field_228845_d_[0].addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F);
        this.field_228845_d_[1].addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F);
        this.field_228845_d_[2].addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F);
        this.field_228845_d_[3].addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F);
        this.field_228845_d_[0].rotateAngleX = ((float)Math.PI / 2F);
        this.field_228845_d_[1].rotateAngleX = ((float)Math.PI / 2F);
        this.field_228845_d_[2].rotateAngleX = ((float)Math.PI / 2F);
        this.field_228845_d_[3].rotateAngleX = ((float)Math.PI / 2F);
        this.field_228845_d_[0].rotateAngleZ = 0.0F;
        this.field_228845_d_[1].rotateAngleZ = ((float)Math.PI / 2F);
        this.field_228845_d_[2].rotateAngleZ = ((float)Math.PI * 1.5F);
        this.field_228845_d_[3].rotateAngleZ = (float)Math.PI;
    }

    public void render(TileEntityNightmareBed tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        //TODO - sort out texture
        RenderMaterial rendermaterial = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(DivineRPG.MODID, "textures/blocks/nightmare.png"));
        World world = tileEntityIn.getWorld();
        if (world != null) {
            BlockState blockstate = tileEntityIn.getBlockState();
            TileEntityMerger.ICallbackWrapper<? extends TileEntityNightmareBed> icallbackwrapper = TileEntityMerger.func_226924_a_(TileRegistry.NIGHTMARE_BED, BlockNightmareBed::getMergeType, BlockNightmareBed::getFootDirection, BlockNightmareBed.HORIZONTAL_FACING, blockstate, world, tileEntityIn.getPos(), (p_228846_0_, p_228846_1_) -> {
                return false;
            });
            int i = icallbackwrapper.<Int2IntFunction>apply(new DualBrightnessCallback<>()).get(combinedLightIn);
            this.setup(matrixStackIn, bufferIn, blockstate.get(BlockNightmareBed.PART) == BedPart.HEAD, blockstate.get(BlockNightmareBed.HORIZONTAL_FACING), rendermaterial, i, combinedOverlayIn, false);
        } else {
            this.setup(matrixStackIn, bufferIn, true, Direction.SOUTH, rendermaterial, combinedLightIn, combinedOverlayIn, false);
            this.setup(matrixStackIn, bufferIn, false, Direction.SOUTH, rendermaterial, combinedLightIn, combinedOverlayIn, true);
        }

    }

    private void setup(MatrixStack p_228847_1_, IRenderTypeBuffer p_228847_2_, boolean p_228847_3_, Direction p_228847_4_, RenderMaterial p_228847_5_, int p_228847_6_, int p_228847_7_, boolean p_228847_8_) {
        this.field_228843_a_.showModel = p_228847_3_;
        this.field_228844_c_.showModel = !p_228847_3_;
        this.field_228845_d_[0].showModel = !p_228847_3_;
        this.field_228845_d_[1].showModel = p_228847_3_;
        this.field_228845_d_[2].showModel = !p_228847_3_;
        this.field_228845_d_[3].showModel = p_228847_3_;
        p_228847_1_.push();
        p_228847_1_.translate(0.0D, 0.5625D, p_228847_8_ ? -1.0D : 0.0D);
        p_228847_1_.rotate(Vector3f.XP.rotationDegrees(90.0F));
        p_228847_1_.translate(0.5D, 0.5D, 0.5D);
        p_228847_1_.rotate(Vector3f.ZP.rotationDegrees(180.0F + p_228847_4_.getHorizontalAngle()));
        p_228847_1_.translate(-0.5D, -0.5D, -0.5D);
        IVertexBuilder ivertexbuilder = p_228847_5_.getBuffer(p_228847_2_, RenderType::getEntitySolid);
        this.field_228843_a_.render(p_228847_1_, ivertexbuilder, p_228847_6_, p_228847_7_);
        this.field_228844_c_.render(p_228847_1_, ivertexbuilder, p_228847_6_, p_228847_7_);
        this.field_228845_d_[0].render(p_228847_1_, ivertexbuilder, p_228847_6_, p_228847_7_);
        this.field_228845_d_[1].render(p_228847_1_, ivertexbuilder, p_228847_6_, p_228847_7_);
        this.field_228845_d_[2].render(p_228847_1_, ivertexbuilder, p_228847_6_, p_228847_7_);
        this.field_228845_d_[3].render(p_228847_1_, ivertexbuilder, p_228847_6_, p_228847_7_);
        p_228847_1_.pop();
    }
}
