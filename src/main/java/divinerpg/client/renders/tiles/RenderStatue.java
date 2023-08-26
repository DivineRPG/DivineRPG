package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockStatue;
import divinerpg.client.models.boss.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.block_entities.bosses.StatueBlockEntity;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderStatue implements BlockEntityRenderer<StatueBlockEntity> {
    BlockEntityRendererProvider.Context context;
    public RenderStatue(BlockEntityRendererProvider.Context context) {
    this.context = context;
    }

    @Override
    public void render(StatueBlockEntity te, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Model model = getModel(te);
        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1.5D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-te.getBlockState().getValue(AbstractFurnaceBlock.FACING).toYRot()));
        matrixStack.mulPose(Axis.XP.rotationDegrees(180));
        if(te.getBlockState().is(BlockRegistry.kitraStatue.get())){
            matrixStack.scale(0.25F, 0.25F, 0.25F);
            matrixStack.translate(0F, 5F, 0F);
        }
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(texture(te)));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(StatueBlockEntity tile) {
        return true;
    }

    private Model getModel(StatueBlockEntity tile) {
        Block block = tile.getBlockState().getBlock();
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue"))) return new ModelAncientEntity(context.bakeLayer(ModelAncientEntity.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "densos_statue"))) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_statue"))) return new ModelDramix<>(context.bakeLayer(ModelDramix.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue"))) return new ModelEternalArcher<>(context.bakeLayer(ModelEternalArcher.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karot_statue"))) return new ModelKarot(context.bakeLayer(ModelKarot.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue"))) return new ModelKingOfScorchers(context.bakeLayer(ModelKingOfScorchers.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue"))) return new ModelParasecta(context.bakeLayer(ModelParasecta.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "reyvor_statue"))) return new ModelDensos<>(context.bakeLayer(ModelDensos.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue"))) return new ModelSoulFiend(context.bakeLayer(ModelSoulFiend.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue"))) return new ModelWatcher(context.bakeLayer(ModelWatcher.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue"))) return new ModelTwilightDemon(context.bakeLayer(ModelTwilightDemon.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue"))) return new ModelVamacheron(context.bakeLayer(ModelVamacheron.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue"))) return new ModelAyeraco(context.bakeLayer(ModelAyeraco.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "termasect_statue"))) return new ModelTermasect<>(context.bakeLayer(ModelTermasect.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue"))) return new ModelSunstorm<>(context.bakeLayer(ModelSunstorm.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue"))) return new ModelExperiencedCori(context.bakeLayer(ModelExperiencedCori.LAYER_LOCATION));
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "kitra_statue"))) return new ModelKitra(context.bakeLayer(ModelKitra.LAYER_LOCATION));
        return new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }
    public static final ResourceLocation
    	ancient_entity = new ResourceLocation(DivineRPG.MODID, "textures/entity/ancient_entity.png"),
    	densos = new ResourceLocation(DivineRPG.MODID, "textures/entity/densos.png"),
    	dramix = new ResourceLocation(DivineRPG.MODID, "textures/entity/dramix.png"),
    	eternal_archer = new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png"),
    	karot = new ResourceLocation(DivineRPG.MODID, "textures/entity/karot.png"),
    	king_of_scorchers = new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png"),
    	parasecta = new ResourceLocation(DivineRPG.MODID, "textures/entity/parasecta.png"),
    	reyvor = new ResourceLocation(DivineRPG.MODID, "textures/entity/reyvor.png"),
    	soul_fiend = new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png"),
    	the_watcher = new ResourceLocation(DivineRPG.MODID, "textures/entity/the_watcher.png"),
    	twilight_demon = new ResourceLocation(DivineRPG.MODID, "textures/entity/twilight_demon.png"),
    	vamacheron = new ResourceLocation(DivineRPG.MODID, "textures/entity/mortum_cadillion.png"),
    	ayeraco_blue = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_blue.png"),
		ayeraco_green = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_green.png"),
		ayeraco_pink = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_pink.png"),
		ayeraco_purple = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_purple.png"),
		ayeraco_red = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_red.png"),
		ayeraco_yellow = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_yellow.png"),
    	ayeraco_white = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_white.png"),
    	termasect = new ResourceLocation(DivineRPG.MODID, "textures/entity/termasect.png"),
    	sunstorm = new ResourceLocation(DivineRPG.MODID, "textures/entity/sunstorm.png"),
        experienced_cori = new ResourceLocation(DivineRPG.MODID, "textures/entity/experienced_cori.png"),
        kitra = new ResourceLocation(DivineRPG.MODID, "textures/entity/kitra.png");
    private ResourceLocation texture(StatueBlockEntity tile) {
        Block block = tile.getBlockState().getBlock();
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue"))) return ancient_entity;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "densos_statue"))) return densos;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_statue"))) return dramix;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue"))) return eternal_archer;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karot_statue"))) return karot;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue"))) return king_of_scorchers;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue"))) return parasecta;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "reyvor_statue"))) return reyvor;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue"))) return soul_fiend;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue"))) return the_watcher;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue"))) return twilight_demon;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue"))) return vamacheron;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue"))){
        	if(tile.getBlockState().getValue(BlockStatue.COLOR) == null) return ayeraco_white;
        	return switch(tile.getBlockState().getValue(BlockStatue.COLOR)) {
        	case BLUE -> ayeraco_blue;
        	case GREEN -> ayeraco_green;
        	case PINK -> ayeraco_pink;
        	case PURPLE -> ayeraco_purple;
        	case RED -> ayeraco_red;
        	case YELLOW -> ayeraco_yellow;
        	default -> ayeraco_white;
        	};
        }
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "termasect_statue"))) return termasect;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue"))) return sunstorm;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue"))) return experienced_cori;
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "kitra_statue"))) return kitra;
        return new ResourceLocation("minecraft:textures/block/stone.png");
    }
}