package divinerpg.client;

import divinerpg.client.renders.PlayerHatRender;
import divinerpg.registries.FluidRegistry;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;

import static divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@EventBusSubscriber(modid = MODID, value = CLIENT)
public class FancyRenders {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerModelType modelType : event.getSkins()) {
            AvatarRenderer renderer = event.getPlayerRenderer(modelType);
            if (renderer != null) {
                renderer.addLayer(new PlayerHatRender(renderer, event.getEntityModels()));
            }
        }
    }

    @SubscribeEvent
    private static void registerFluidModels(RegisterFluidModelsEvent event) {
        event.register(new FluidModel.Unbaked(new Material(Identifier.fromNamespaceAndPath(MODID, "block/smoldering_tar")), new Material(Identifier.fromNamespaceAndPath(MODID, "block/flowing_smoldering_tar")), null, null, null), FluidRegistry.SMOLDERING_TAR_FLUID, FluidRegistry.SMOLDERING_TAR_FLUID_FLOWING);
    }
}