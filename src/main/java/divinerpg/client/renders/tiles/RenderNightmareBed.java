package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.tiles.TileEntityNightmareBed;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderNightmareBed implements BlockEntityRenderer<TileEntityNightmareBed> {
    private final ModelPart headRoot;
    private final ModelPart footRoot;

        public static final ModelLayerLocation HEAD = new ModelLayerLocation(new ResourceLocation(DivineRPG.MODID, "head"), "main");
        public static final ModelLayerLocation FOOT = new ModelLayerLocation(new ResourceLocation(DivineRPG.MODID, "foot"), "main");
    public RenderNightmareBed(BlockEntityRendererProvider.Context context) {
        this.headRoot = context.bakeLayer(HEAD);
        this.footRoot = context.bakeLayer(FOOT);
    }

        public static LayerDefinition createHeadLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();
            partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
            partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, ((float)Math.PI / 2F)));
            partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 18).addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, (float)Math.PI));
            return LayerDefinition.create(meshdefinition, 64, 64);
        }

        public static LayerDefinition createFootLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();
            partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
            partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, 0.0F));
            partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 12).addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, ((float)Math.PI * 1.5F)));
            return LayerDefinition.create(meshdefinition, 64, 64);
        }

        public void render(TileEntityNightmareBed tile, float p_112206_, PoseStack poseStack, MultiBufferSource buffer, int light, int p_112210_) {
            Material material = new Material(Sheets.BED_SHEET, new ResourceLocation(DivineRPG.MODID, "textures/block/nightmare.png"));
            Level level = tile.getLevel();
            if (level != null) {
                BlockState blockstate = tile.getBlockState();
                DoubleBlockCombiner.NeighborCombineResult<? extends TileEntityNightmareBed> neighborcombineresult = DoubleBlockCombiner.combineWithNeigbour(BlockEntityRegistry.NIGHTMARE_BED.get(), BedBlock::getBlockType, BedBlock::getConnectedDirection, ChestBlock.FACING, blockstate, level, tile.getBlockPos(), (levelAccessor, pos) -> {
                    return false;
                });
                int i = neighborcombineresult.<Int2IntFunction>apply(new BrightnessCombiner<>()).get(light);
                this.renderPiece(poseStack, buffer, blockstate.getValue(BedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot, blockstate.getValue(BedBlock.FACING), material, i, p_112210_, false);
            } else {
                this.renderPiece(poseStack, buffer, this.headRoot, Direction.SOUTH, material, light, p_112210_, false);
                this.renderPiece(poseStack, buffer, this.footRoot, Direction.SOUTH, material, light, p_112210_, true);
            }

        }

        private void renderPiece(PoseStack stack, MultiBufferSource bufferSource, ModelPart part, Direction direction, Material material, int p_173547_, int p_173548_, boolean p_173549_) {
            stack.pushPose();
            stack.translate(0.0D, 0.5625D, p_173549_ ? -1.0D : 0.0D);
            stack.mulPose(Axis.XP.rotationDegrees(90.0F));
            stack.translate(0.5D, 0.5D, 0.5D);
            stack.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
            stack.translate(-0.5D, -0.5D, -0.5D);
            VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/block/nightmare.png")));
            part.render(stack, vertexconsumer, p_173547_, p_173548_);
            stack.popPose();
        }
}