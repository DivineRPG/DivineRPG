package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStatueColored;
import divinerpg.client.models.boss.*;
import divinerpg.block_entities.bosses.StatueBlockEntity;
import divinerpg.client.models.vanilla.ModelWatcher;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;

public class RenderStatue implements BlockEntityRenderer<StatueBlockEntity> {
    BlockEntityRendererProvider.Context context;
    public RenderStatue(BlockEntityRendererProvider.Context context) {this.context = context;}
    @Override public void render(StatueBlockEntity te, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Model model = getModel(te);
        matrixStack.pushPose();
        if(te.getBlockState().is(BlockRegistry.kitraStatue.get()) || te.getBlockState().is(BlockRegistry.sunstormStatue.get())) {
            matrixStack.translate(.5, .375, .5);
            matrixStack.scale(.25F, .25F, .25F);
        } else if(te.getBlockState().is(BlockRegistry.karotStatue.get()) || te.getBlockState().is(BlockRegistry.theWatcherStatue.get()) || te.getBlockState().is(BlockRegistry.experiencedCoriStatue.get())) {
            matrixStack.translate(.5, .9, .5);
            matrixStack.scale(.6F, .6F, .6F);
        } else {
            matrixStack.translate(.5, .6, .5);
            matrixStack.scale(.4F, .4F, .4F);
        } matrixStack.mulPose(Axis.YP.rotationDegrees(-te.getBlockState().getValue(AbstractFurnaceBlock.FACING).toYRot()));
        matrixStack.mulPose(Axis.XP.rotationDegrees(180));
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(texture(te)));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1, 1, 1, 1);
        matrixStack.popPose();
    }
    private Model getModel(StatueBlockEntity tile) {
        Block block = tile.getBlockState().getBlock();
        if(block == BlockRegistry.ancientEntityStatue.get()) return new ModelAncientEntity(context.bakeLayer(ModelAncientEntity.LAYER_LOCATION));
        if(block == BlockRegistry.densosStatue.get()) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(block == BlockRegistry.dramixStatue.get()) return new ModelDramix<>(context.bakeLayer(ModelDramix.LAYER_LOCATION));
        if(block == BlockRegistry.eternalArcherStatue.get()) return new ModelEternalArcher<>(context.bakeLayer(ModelEternalArcher.LAYER_LOCATION));
        if(block == BlockRegistry.karotStatue.get()) return new ModelKarot(context.bakeLayer(ModelKarot.LAYER_LOCATION));
        if(block == BlockRegistry.kingOfScorchersStatue.get()) return new ModelKingOfScorchers(context.bakeLayer(ModelKingOfScorchers.LAYER_LOCATION));
        if(block == BlockRegistry.parasectaStatue.get()) return new ModelParasecta(context.bakeLayer(ModelParasecta.LAYER_LOCATION));
        if(block == BlockRegistry.reyvorStatue.get()) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(block == BlockRegistry.soulFiendStatue.get()) return new ModelSoulFiend(context.bakeLayer(ModelSoulFiend.LAYER_LOCATION));
        if(block == BlockRegistry.theWatcherStatue.get()) return new ModelWatcher(context.bakeLayer(ModelWatcher.LAYER_LOCATION));
        if(block == BlockRegistry.twilightDemonStatue.get()) return new ModelTwilightDemon(context.bakeLayer(ModelTwilightDemon.LAYER_LOCATION));
        if(block == BlockRegistry.vamacheronStatue.get()) return new ModelVamacheron(context.bakeLayer(ModelVamacheron.LAYER_LOCATION));
        if(block == BlockRegistry.ayeracoStatue.get()) return new ModelAyeraco(context.bakeLayer(ModelAyeraco.LAYER_LOCATION));
        if(block == BlockRegistry.termasectStatue.get()) return new ModelTermasect<>(context.bakeLayer(ModelTermasect.LAYER_LOCATION));
        if(block == BlockRegistry.sunstormStatue.get()) return new ModelSunstorm<>(context.bakeLayer(ModelSunstorm.LAYER_LOCATION));
        if(block == BlockRegistry.experiencedCoriStatue.get()) return new ModelExperiencedCori(context.bakeLayer(ModelExperiencedCori.LAYER_LOCATION));
        if(block == BlockRegistry.kitraStatue.get()) return new ModelKitra(context.bakeLayer(ModelKitra.LAYER_LOCATION));
        return new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }
    private static ResourceLocation location(String path) {
        return new ResourceLocation(DivineRPG.MODID, "textures/entity/" + path + ".png");
    }
    public static final ResourceLocation
    	ancient_entity = location("ancient_entity"),
        the_watcher = location("the_watcher"),
        king_of_scorchers = location("king_of_scorchers"),
        kitra = location("kitra"),
        ayeraco_blue = location("ayeraco_blue"),
        ayeraco_green = location("ayeraco_green"),
        ayeraco_pink = location("ayeraco_pink"),
        ayeraco_purple = location("ayeraco_purple"),
        ayeraco_red = location("ayeraco_red"),
        ayeraco_yellow = location("ayeraco_yellow"),
        ayeraco_white = location("ayeraco_white"),
        parasecta = location("parasecta"),
    	dramix = location("dramix"),
        sunstorm = location("sunstorm"),
        termasect = location("termasect"),
        eternal_archer = location("eternal_archer"),
        experienced_cori = location("experienced_cori"),
    	karot = location("karot"),
        densos = location("densos"),
    	reyvor = location("reyvor"),
    	soul_fiend = location("soul_fiend"),
    	twilight_demon = location("twilight_demon"),
    	vamacheron = location("mortum_cadillion");
    private ResourceLocation texture(StatueBlockEntity tile) {
        Block block = tile.getBlockState().getBlock();
        if(block == BlockRegistry.ancientEntityStatue.get()) return ancient_entity;
        if(block == BlockRegistry.theWatcherStatue.get()) return the_watcher;
        if(block == BlockRegistry.kingOfScorchersStatue.get()) return king_of_scorchers;
        if(block == BlockRegistry.kitraStatue.get()) return kitra;
        if(block == BlockRegistry.ayeracoStatue.get()){
            return switch(tile.getBlockState().getValue(BlockStatueColored.COLOR)) {
                case BLUE -> ayeraco_blue;
                case GREEN -> ayeraco_green;
                case PINK -> ayeraco_pink;
                case PURPLE -> ayeraco_purple;
                case RED -> ayeraco_red;
                case YELLOW -> ayeraco_yellow;
                default -> ayeraco_white;
            };
        } if(block == BlockRegistry.parasectaStatue.get()) return parasecta;
        if(block == BlockRegistry.dramixStatue.get()) return dramix;
        if(block == BlockRegistry.sunstormStatue.get()) return sunstorm;
        if(block == BlockRegistry.termasectStatue.get()) return termasect;
        if(block == BlockRegistry.eternalArcherStatue.get()) return eternal_archer;
        if(block == BlockRegistry.experiencedCoriStatue.get()) return experienced_cori;
        if(block == BlockRegistry.densosStatue.get()) return densos;
        if(block == BlockRegistry.reyvorStatue.get()) return reyvor;
        if(block == BlockRegistry.karotStatue.get()) return karot;
        if(block == BlockRegistry.soulFiendStatue.get()) return soul_fiend;
        if(block == BlockRegistry.twilightDemonStatue.get()) return twilight_demon;
        if(block == BlockRegistry.vamacheronStatue.get()) return vamacheron;
        return new ResourceLocation(DivineRPG.MODID, "textures/block/black_hungerstone.png");
    }
}