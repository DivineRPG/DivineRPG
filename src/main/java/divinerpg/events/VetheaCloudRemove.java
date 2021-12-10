package divinerpg.events;

import divinerpg.registries.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;

public class VetheaCloudRemove {
    @SubscribeEvent
    public void cloudRemover(TickEvent.PlayerTickEvent event) {
        PlayerEntity p = event.player;

        Biome biome = p.level.getBiome(p.blockPosition());

        GameSettings settings = Minecraft.getInstance().options;

        if (biome.getRegistryName().equals(KeyRegistry.VETHEA_BIOME.getRegistryName())) {
            settings.renderClouds = CloudOption.OFF;
        } else {
            settings.renderClouds = CloudOption.FANCY;
        }
    }
}
