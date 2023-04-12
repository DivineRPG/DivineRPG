package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStatue;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.vanilla.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

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
        if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue")).asItem()){
            return new ModelAncientEntity(context.bakeLayer(ModelAncientEntity.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "densos_statue")).asItem()){
            return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_statue")).asItem()){
            return new ModelDramix<>(context.bakeLayer(ModelDramix.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue")).asItem()){
            return new ModelEternalArcher<>(context.bakeLayer(ModelEternalArcher.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karot_statue")).asItem()){
            return new ModelKarot(context.bakeLayer(ModelKarot.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue")).asItem()){
            return new ModelKingOfScorchers(context.bakeLayer(ModelKingOfScorchers.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue")).asItem()){
            return new ModelParasecta(context.bakeLayer(ModelParasecta.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "reyvor_statue")).asItem()){
            return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue")).asItem()){
            return new ModelSoulFiend(context.bakeLayer(ModelSoulFiend.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue")).asItem()){
            return new ModelWatcher(context.bakeLayer(ModelWatcher.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue")).asItem()){
            return new ModelTwilightDemon(context.bakeLayer(ModelTwilightDemon.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue")).asItem()){
            return new ModelVamacheron(context.bakeLayer(ModelVamacheron.LAYER_LOCATION));
        }

        else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")).asItem()) {
            return new ModelAyeraco(context.bakeLayer(ModelAyeraco.LAYER_LOCATION));
        }

        else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "termasect_statue")).asItem()){
            return new ModelTermasect<>(context.bakeLayer(ModelTermasect.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue")).asItem()){
            return new ModelSunstorm<>(context.bakeLayer(ModelSunstorm.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue")).asItem()){
            return new ModelExperiencedCori(context.bakeLayer(ModelExperiencedCori.LAYER_LOCATION));
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ghost_whale_statue")).asItem()){
            return new ModelWhale(context.bakeLayer(ModelWhale.LAYER_LOCATION));
        }

        else {
            return new BookModel(context.bakeLayer(ModelLayers.BOOK));
        }
    }

    private ResourceLocation texture(ItemStack stack) {
        Item item = stack.getItem();
        if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue")).asItem()) {
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "densos_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karot_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "reyvor_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/reyvor.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png");
        }

        else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_white.png");
        }

        else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "termasect_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png");
        } else if(item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ghost_whale_statue")).asItem()){
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/ghost_whale.png");
        }

        else {
            return new ResourceLocation("minecraft:textures/block/stone.png");
        }
    }
}
