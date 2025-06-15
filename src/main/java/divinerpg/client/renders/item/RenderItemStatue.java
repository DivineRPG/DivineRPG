package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStatue;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.vanilla.ModelWatcher;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.*;

import java.util.function.Supplier;

import static divinerpg.registries.BlockRegistry.*;

@OnlyIn(Dist.CLIENT)
public class RenderItemStatue extends BlockEntityWithoutLevelRenderer {
    EntityModelSet context;
    Supplier<Block> block;
    public RenderItemStatue(BlockEntityRenderDispatcher dispatcher, EntityModelSet set, Supplier<Block> block) {
        super(dispatcher, set);
        this.block = block;
        context = set;
    }
    @Override public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource renderType, int combinedLight, int combinedOverlay) {
        if(stack.getItem() instanceof BlockItem){
            Block block = ((BlockItem) stack.getItem()).getBlock();
            if(block instanceof BlockStatue){
                Model model = getModel(stack);
                matrixStack.pushPose();
                matrixStack.translate(.5, .8, .5);
                matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
                matrixStack.mulPose(Axis.XP.rotationDegrees(180));
                matrixStack.scale(.6F, .6F, .6F);
                if(stack.is(kitraStatue.get().asItem())){
                    matrixStack.scale(.25F, .25F, .25F);
                    matrixStack.translate(0, 3, 0);
                } if(texture(stack) != null) {
                    VertexConsumer builder = renderType.getBuffer(RenderType.entityCutout(texture(stack)));
                    model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay);
                } matrixStack.popPose();
            }
        }
    }
    private Model getModel(ItemStack stack){
        Item item = stack.getItem();
        //Overworld
        if(item == ancientEntityStatue.asItem()) return new ModelAncientEntity(context.bakeLayer(ModelAncientEntity.LAYER_LOCATION));
        //Nether
        if(item == theWatcherStatue.asItem()) return new ModelWatcher(context.bakeLayer(ModelWatcher.LAYER_LOCATION));
        if(item == kingOfScorchersStatue.asItem()) return new ModelKingOfScorchers(context.bakeLayer(ModelKingOfScorchers.LAYER_LOCATION));
        //Iceika
        if(item == kitraStatue.asItem()) return new ModelKitra(context.bakeLayer(ModelKitra.LAYER_LOCATION));
        //End
        if(item == ayeracoStatue.asItem()) return new ModelAyeraco(context.bakeLayer(ModelAyeraco.LAYER_LOCATION));
        //Arcana
        if(item == dramixStatue.asItem()) return new ModelDramix<>(context.bakeLayer(ModelDramix.LAYER_LOCATION));
        if(item == parasectaStatue.asItem()) return new ModelParasecta(context.bakeLayer(ModelParasecta.LAYER_LOCATION));
        //Eden-Skythern
        if(item == sunstormStatue.asItem()) return new ModelSunstorm<>(context.bakeLayer(ModelSunstorm.LAYER_LOCATION));
        if(item == termasectStatue.asItem()) return new ModelTermasect<>(context.bakeLayer(ModelTermasect.LAYER_LOCATION));
        if(item == eternalArcherStatue.asItem()) return new ModelEternalArcher<>(context.bakeLayer(ModelEternalArcher.LAYER_LOCATION));
        if(item == experiencedCoriStatue.asItem()) return new ModelExperiencedCori(context.bakeLayer(ModelExperiencedCori.LAYER_LOCATION));
        //Mortum
        if(item == vamacheronStatue.asItem()) return new ModelVamacheron(context.bakeLayer(ModelVamacheron.LAYER_LOCATION));
        if(item == karotStatue.asItem()) return new ModelKarot(context.bakeLayer(ModelKarot.LAYER_LOCATION));
        if(item == twilightDemonStatue.asItem()) return new ModelTwilightDemon(context.bakeLayer(ModelTwilightDemon.LAYER_LOCATION));
        if(item == densosStatue.asItem()) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(item == reyvorStatue.asItem()) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(item == soulFiendStatue.asItem()) return new ModelSoulFiend(context.bakeLayer(ModelSoulFiend.LAYER_LOCATION));
        //Book?
        return new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }
    private static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + path + ".png");
    }
    private ResourceLocation texture(ItemStack stack) {
        Item item = stack.getItem();
        //Overworld
        if(item == ancientEntityStatue.asItem()) return location("ancient_entity");
        //Nether
        if(item == kingOfScorchersStatue.asItem()) return location("king_of_scorchers");
        if(item == theWatcherStatue.asItem()) return location("the_watcher");
        //Iceika
        if(item == kitraStatue.asItem()) return location("kitra");
        //End
        if(item == ayeracoStatue.asItem()) return location("ayeraco_white");
        //Arcana
        if(item == dramixStatue.asItem()) return location("dramix");
        if(item == parasectaStatue.asItem()) return location("parasecta");
        //Eden-Skythern
        if(item == sunstormStatue.asItem()) return location("sunstorm");
        if(item == termasectStatue.asItem()) return location("termasect");
        if(item == eternalArcherStatue.asItem()) return location("eternal_archer");
        if(item == experiencedCoriStatue.asItem()) return location("experienced_cori");
        //Mortum
        if(item == vamacheronStatue.asItem()) return location("mortum_cadillion");
        if(item == karotStatue.asItem()) return location("karot");
        if(item == twilightDemonStatue.asItem()) return location("twilight_demon");
        if(item == densosStatue.asItem()) return location("densos");
        if(item == reyvorStatue.asItem()) return location("reyvor");
        if(item == soulFiendStatue.asItem()) return location("soul_fiend");
        //Default
        else return ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/block/black_hungerstone.png");
    }
}