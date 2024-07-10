package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStatue;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.*;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class RenderItemStatue extends BlockEntityWithoutLevelRenderer {
    EntityModelSet context;
    Supplier<Block> block;

    public RenderItemStatue(BlockEntityRenderDispatcher dispatcher, EntityModelSet set, Supplier<Block> block) {
        super(dispatcher, set);
        this.block = block;
        context = set;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource renderType, int combinedLight, int combinedOverlay) {
            if(stack.getItem() instanceof BlockItem){
                Block block = ((BlockItem) stack.getItem()).getBlock();
                if(block instanceof BlockStatue){
                    Model model = getModel(stack);
                    matrixStack.pushPose();
                    matrixStack.translate(0.5, 0.8, 0.5);
                    matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
                    matrixStack.mulPose(Axis.XP.rotationDegrees(180));
                    matrixStack.scale(0.6F, 0.6F, 0.6F);
                    if(stack.is(BlockRegistry.kitraStatue.get().asItem())){
                        matrixStack.scale(0.25F, 0.25F, 0.25F);
                        matrixStack.translate(0F, 3F, 0F);
                    }
                    if(texture(stack) != null) {
                        VertexConsumer builder = renderType.getBuffer(RenderType.entityCutout(texture(stack)));
                        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
                    }
                    matrixStack.popPose();
                }
            }
    }

    private Model getModel(ItemStack stack){
        Item item = stack.getItem();
        if(item == BlockRegistry.ancientEntityStatue.asItem()){
            return new ModelAncientEntity(context.bakeLayer(ModelAncientEntity.LAYER_LOCATION));
        } else if(item == BlockRegistry.densosStatue.asItem()){
            return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        } else if(item == BlockRegistry.dramixStatue.asItem()){
            return new ModelDramix<>(context.bakeLayer(ModelDramix.LAYER_LOCATION));
        } else if(item == BlockRegistry.eternalArcherStatue.asItem()){
            return new ModelEternalArcher<>(context.bakeLayer(ModelEternalArcher.LAYER_LOCATION));
        } else if(item == BlockRegistry.karotStatue.asItem()){
            return new ModelKarot(context.bakeLayer(ModelKarot.LAYER_LOCATION));
        } else if(item == BlockRegistry.kingOfScorchersStatue.asItem()){
            return new ModelKingOfScorchers(context.bakeLayer(ModelKingOfScorchers.LAYER_LOCATION));
        } else if(item == BlockRegistry.parasectaStatue.asItem()){
            return new ModelParasecta(context.bakeLayer(ModelParasecta.LAYER_LOCATION));
        } else if(item == BlockRegistry.reyvorStatue.asItem()){
            return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        } else if(item == BlockRegistry.soulFiendStatue.asItem()){
            return new ModelSoulFiend(context.bakeLayer(ModelSoulFiend.LAYER_LOCATION));
        } else if(item == BlockRegistry.theWatcherStatue.asItem()){
            return new ModelWatcher(context.bakeLayer(ModelWatcher.LAYER_LOCATION));
        } else if(item == BlockRegistry.twilightDemonStatue.asItem()){
            return new ModelTwilightDemon(context.bakeLayer(ModelTwilightDemon.LAYER_LOCATION));
        } else if(item == BlockRegistry.vamacheronStatue.asItem()){
            return new ModelVamacheron(context.bakeLayer(ModelVamacheron.LAYER_LOCATION));
        }

        else if(item == BlockRegistry.ayeracoStatue.asItem()) {
            return new ModelAyeraco(context.bakeLayer(ModelAyeraco.LAYER_LOCATION));
        }

        else if(item == BlockRegistry.termasectStatue.asItem()){
            return new ModelTermasect<>(context.bakeLayer(ModelTermasect.LAYER_LOCATION));
        } else if(item == BlockRegistry.sunstormStatue.asItem()){
            return new ModelSunstorm<>(context.bakeLayer(ModelSunstorm.LAYER_LOCATION));
        } else if(item == BlockRegistry.experiencedCoriStatue.asItem()){
            return new ModelExperiencedCori(context.bakeLayer(ModelExperiencedCori.LAYER_LOCATION));
        } else if(item == BlockRegistry.kitraStatue.asItem()){
            return new ModelKitra(context.bakeLayer(ModelKitra.LAYER_LOCATION));
        }

        else {
            return new BookModel(context.bakeLayer(ModelLayers.BOOK));
        }
    }

    private ResourceLocation texture(ItemStack stack) {
        Item item = stack.getItem();
        if(item == BlockRegistry.ancientEntityStatue.asItem()) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png");
        } else if(item == BlockRegistry.densosStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png");
        } else if(item == BlockRegistry.dramixStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png");
        } else if(item == BlockRegistry.eternalArcherStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png");
        } else if(item == BlockRegistry.karotStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png");
        } else if(item == BlockRegistry.kingOfScorchersStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png");
        } else if(item == BlockRegistry.parasectaStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png");
        } else if(item == BlockRegistry.reyvorStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/reyvor.png");
        } else if(item == BlockRegistry.soulFiendStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png");
        } else if(item == BlockRegistry.theWatcherStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png");
        } else if(item == BlockRegistry.twilightDemonStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png");
        } else if(item == BlockRegistry.vamacheronStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png");
        }

        else if(item == BlockRegistry.ayeracoStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_white.png");
        }

        else if(item == BlockRegistry.termasectStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png");
        } else if(item == BlockRegistry.sunstormStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png");
        } else if(item == BlockRegistry.experiencedCoriStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png");
        } else if(item == BlockRegistry.kitraStatue.asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/kitra.png");
        }

        else {
            return new ResourceLocation("minecraft:textures/block/stone.png");
        }
    }
}
