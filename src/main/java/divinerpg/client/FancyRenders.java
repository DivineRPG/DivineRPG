package divinerpg.client;

import divinerpg.client.renders.layer.*;
import divinerpg.client.renders.tiles.*;
import divinerpg.registries.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.*;

public class FancyRenders {
    public static void init() {
        RenderTypeLookup.setRenderLayer(BlockRegistry.apalachiaSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.divineSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.edenSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.frozenSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.mortumSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skythernSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.wildwoodSapling, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.sunbloom, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.sunBlossom, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.edenBrush, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.moonBud, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.moonlightFern, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.wildwoodTallgrass, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.duskBloom, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.duskFlower, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.apalachiaTallgrass, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.dustBrambles, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.dustLily, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skythernBrush, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.demonBrambles, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.eyePlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.mortumBrush, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.moonbulbPlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.pinkGlowbonePlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.purpleGlowbonePlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skyPlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.tomatoPlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.whiteMushroomPlant, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.aquaTorch, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skeletonTorch, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.sunstormSpawner, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.termasectSpawner, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.eternalArcherSpawner, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.experiencedCoriSpawner, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.edenTorch, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.ancientBrickStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.arcaniteTubes, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.arcaniteLadder, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.degradedBrickStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.ancientBrickStairsBreakable, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.ancientBrickWallBreakable, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.degradedBrickStairsBreakable, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.degradedBrickWallBreakable, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.arcanaHardPortalFrame, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.arcanaPortalFrame, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.eucalyptusStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.arcanaPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.arcaniumTorch, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.elevantium, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.iceikaPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.edenPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.wildwoodPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.apalachiaPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skythernPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.mortumPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.vetheaPortal, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.ancientBrickWall, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.degradedBrickWall, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.metalCaging, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.lunicAcid, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.bacterialAcid, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.acidBlock, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.hiveEgg, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.frostArcherSpawner, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.rollumSpawner, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.frostedGlass, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass2, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass3, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass4, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass5, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass6, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass7, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.stainedGlass8, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.edenStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.wildwoodStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.apalachiaStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skythernStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.mortumStairs, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.blueFence, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.blueFenceOn, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.greenFence, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.greenFenceOn, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.redFence, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.redFenceOn, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.steelDoor, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.barredDoor, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.divineLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.brittleLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.edenLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.wildwoodLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.apalachiaLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.skythernLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.mortumLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.dreamwoodLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.firewoodLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.hyrewoodLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.mintwoodLeaves, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.blossomedWeedwoodVine, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.weedwoodVine, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.wildwoodVine, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.degradedBrickWall, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.ancientBrickWall, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.degradedBrickWallBreakable, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.ancientBrickWallBreakable, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BlockRegistry.nightmareBed, RenderType.cutoutMipped());


        RenderTypeLookup.setRenderLayer(BlockRegistry.altarOfCorruption, RenderType.cutoutMipped());


        ClientRegistry.bindTileEntityRenderer(TileRegistry.ALTAR_OF_CORRUPTION, RenderAltarOfCorruption::new);
        ClientRegistry.bindTileEntityRenderer(TileRegistry.NIGHTMARE_BED, RenderNightmareBed::new);


        Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap();
        PlayerRenderer render;
        render = skinMap.get("default");
        render.addLayer(new PlayerHatRender<>(render));

        render = skinMap.get("slim");
        render.addLayer(new PlayerHatRender<>(render));
    }
}
