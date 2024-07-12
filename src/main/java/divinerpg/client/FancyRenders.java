package divinerpg.client;

import divinerpg.DivineRPG;
import divinerpg.client.renders.layer.PlayerHatRender;
import divinerpg.client.renders.tiles.*;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = DivineRPG.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class FancyRenders {
    @SubscribeEvent
    public static void onAddLayer(EntityRenderersEvent.AddLayers event) {
        PlayerRenderer render = (PlayerRenderer) event.getSkin("default");
        render.addLayer(new PlayerHatRender<>(render, event.getEntityModels()));
        render = (PlayerRenderer) event.getSkin("slim");
        render.addLayer(new PlayerHatRender<>(render, event.getEntityModels()));

    }
    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(BlockEntityRegistry.ALTAR_OF_CORRUPTION.get(), RenderAltarOfCorruption::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.NIGHTMARE_BED.get(), RenderNightmareBed::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.STATUE.get(), RenderStatue::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.BONE_CHEST.get(), RenderBoneChest::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.DEMON_FURNACE.get(), RenderDemonFurnace::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.ARCANIUM_EXTRACTOR.get(), RenderArcaniumExtractor::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.EDEN_CHEST.get(), RenderEdenChest::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.DRAMIX_ALTAR.get(), RenderDramixAltar::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.PARASECTA_ALTAR.get(), RenderParasectaAltar::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.AYERACO_BEAM.get(), RenderAyeracoBeam::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.PRESENT_BOX.get(), RenderPresentBox::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.FROSTED_CHEST.get(), RenderFrostedChest::new);

    }
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
    	DivineRPG.LOGGER.info("registering block color handlers");
    	event.register((state, getter, pos, index) -> {
            return getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.getDefaultColor();
        }, BlockRegistry.frozenGrass.get());
	}
}