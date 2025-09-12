package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.*;
import divinerpg.client.models.boss.*;
import divinerpg.block_entities.bosses.StatueBlockEntity;
import divinerpg.client.models.vanilla.ModelWatcher;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.neoforged.api.distmarker.*;

import static divinerpg.registries.BlockRegistry.*;

@OnlyIn(Dist.CLIENT)
public class RenderStatue implements BlockEntityRenderer<StatueBlockEntity> {
    BlockEntityRendererProvider.Context context;
    public RenderStatue(BlockEntityRendererProvider.Context context) {this.context = context;}
    @Override public void render(StatueBlockEntity te, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Model model = getModel(te);
        matrixStack.pushPose();
        if(te.getBlockState().is(sunstormStatue.get())) {
            matrixStack.translate(.5, .375, .5);
            matrixStack.scale(.25F, .25F, .25F);
        } else if(te.getBlockState().is(karotStatue.get()) || te.getBlockState().is(theWatcherStatue.get()) || te.getBlockState().is(experiencedCoriStatue.get())) {
            matrixStack.translate(.5, .9, .5);
            matrixStack.scale(.6F, .6F, .6F);
        } else {
            matrixStack.translate(.5, .6, .5);
            if(te.getBlockState().is(kitraStatue.get())) matrixStack.scale(.25F, .25F, .25F);
            else matrixStack.scale(.4F, .4F, .4F);
        } matrixStack.mulPose(Axis.YP.rotationDegrees(180 - RotationSegment.convertToDegrees(te.getBlockState().getValue(BlockStatue.ROTATION))));
        matrixStack.mulPose(Axis.XP.rotationDegrees(180));
        VertexConsumer builder;
        if(te.getBlockState().is(kitraStatue.get())) builder = buffer.getBuffer(RenderType.entityTranslucent(texture(te)));
        else builder = buffer.getBuffer(RenderType.entityCutout(texture(te)));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay);
        matrixStack.popPose();
    }
    private Model getModel(StatueBlockEntity tile) {
        Block block = tile.getBlockState().getBlock();
        //Overworld
        if(block == ancientEntityStatue.get()) return new ModelAncientEntity(context.bakeLayer(ModelAncientEntity.LAYER_LOCATION));
        //Nether
        if(block == theWatcherStatue.get()) return new ModelWatcher(context.bakeLayer(ModelWatcher.LAYER_LOCATION));
        if(block == kingOfScorchersStatue.get()) return new ModelKingOfScorchers(context.bakeLayer(ModelKingOfScorchers.LAYER_LOCATION));
        //Iceika
        if(block == kitraStatue.get()) return new ModelKitra(context.bakeLayer(ModelKitra.LAYER_LOCATION));
        //End
        if(block == ayeracoStatue.get()) return new ModelAyeraco(context.bakeLayer(ModelAyeraco.LAYER_LOCATION));
        //Arcana
        if(block == dramixStatue.get()) return new ModelDramix<>(context.bakeLayer(ModelDramix.LAYER_LOCATION));
        if(block == parasectaStatue.get()) return new ModelParasecta(context.bakeLayer(ModelParasecta.LAYER_LOCATION));
        //Eden-Skythern
        if(block == sunstormStatue.get()) return new ModelSunstorm<>(context.bakeLayer(ModelSunstorm.LAYER_LOCATION));
        if(block == termasectStatue.get()) return new ModelTermasect<>(context.bakeLayer(ModelTermasect.LAYER_LOCATION));
        if(block == eternalArcherStatue.get()) return new ModelEternalArcher<>(context.bakeLayer(ModelEternalArcher.LAYER_LOCATION));
        if(block == experiencedCoriStatue.get()) return new ModelExperiencedCori(context.bakeLayer(ModelExperiencedCori.LAYER_LOCATION));
        //Mortum
        if(block == vamacheronStatue.get()) return new ModelVamacheron(context.bakeLayer(ModelVamacheron.LAYER_LOCATION));
        if(block == karotStatue.get()) return new ModelKarot(context.bakeLayer(ModelKarot.LAYER_LOCATION));
        if(block == twilightDemonStatue.get()) return new ModelTwilightDemon(context.bakeLayer(ModelTwilightDemon.LAYER_LOCATION));
        if(block == densosStatue.get()) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(block == reyvorStatue.get()) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(block == soulFiendStatue.get()) return new ModelSoulFiend(context.bakeLayer(ModelSoulFiend.LAYER_LOCATION));
        //Book?
        return new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }
    private static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + path + ".png");
    }
    private ResourceLocation texture(StatueBlockEntity tile) {
        Block block = tile.getBlockState().getBlock();
        //Overworld
        if(block == ancientEntityStatue.get()) return location("ancient_entity");
        //Nether
        if(block == theWatcherStatue.get()) return location("the_watcher");
        if(block == kingOfScorchersStatue.get()) return location("king_of_scorchers");
        //Iceika
        if(block == kitraStatue.get()) return location("kitra");
        //End
        if(block == ayeracoStatue.get()){
            return switch(tile.getBlockState().getValue(BlockStatueColored.COLOR)) {
                case RED -> location("ayeraco_red");
                case YELLOW -> location("ayeraco_yellow");
                case GREEN -> location("ayeraco_green");
                case BLUE -> location("ayeraco_blue");
                case PURPLE -> location("ayeraco_purple");
                case PINK -> location("ayeraco_pink");
                default -> location("ayeraco_white");
            };
        } //Arcana
        if(block == dramixStatue.get()) return location("dramix");
        if(block == parasectaStatue.get()) return location("parasecta");
        //Eden-Skythern
        if(block == sunstormStatue.get()) return location("sunstorm");
        if(block == termasectStatue.get()) return location("termasect");
        if(block == eternalArcherStatue.get()) return location("eternal_archer");
        if(block == experiencedCoriStatue.get()) return location("experienced_cori");
        //Mortum
        if(block == vamacheronStatue.get()) return location("vamacheron");
        if(block == karotStatue.get()) return location("karot");
        if(block == twilightDemonStatue.get()) return location("twilight_demon");
        if(block == densosStatue.get()) return location("densos");
        if(block == reyvorStatue.get()) return location("reyvor");
        if(block == soulFiendStatue.get()) return location("soul_fiend");
        //Default
        return ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/block/black_hungerstone.png");
    }
}