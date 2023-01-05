package divinerpg.registries;

/*
import divinerpg.DivineRPG;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.*;
*/

import divinerpg.DivineRPG;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class DivineTab {
    public static ResourceLocation DIVINERPG_BLOCKS = new ResourceLocation(DivineRPG.MODID, "divinerpg_blocks");
    public static ResourceLocation DIVINERPG_RANGED_WEAPONS = new ResourceLocation(DivineRPG.MODID, "divinerpg_ranged_weapons");
    public static ResourceLocation DIVINERPG_MELEE_WEAPONS = new ResourceLocation(DivineRPG.MODID, "divinerpgblocks_melee_weapons");
    public static ResourceLocation DIVINERPG_TOOLS = new ResourceLocation(DivineRPG.MODID, "divinerpg_tools");
    public static ResourceLocation DIVINERPG_RAW_MATERIALS = new ResourceLocation(DivineRPG.MODID, "divinerpg_raw_materials");
    public static ResourceLocation DIVINERPG_ARMOR = new ResourceLocation(DivineRPG.MODID, "divinerpg_armor");
    public static ResourceLocation DIVINERPG_SPAWNER = new ResourceLocation(DivineRPG.MODID, "divinerpg_spawner");
    public static ResourceLocation DIVINERPG_UTILITY = new ResourceLocation(DivineRPG.MODID, "divinerpg_utility");
    public static ResourceLocation DIVINERPG_FOOD = new ResourceLocation(DivineRPG.MODID, "divinerpg_food");
    public static ResourceLocation DIVINERPG_VETHEA = new ResourceLocation(DivineRPG.MODID, "divinerpg_vethea");

    public static void registerTabs(CreativeModeTabEvent.Register event){

        // Blocks
        event.registerCreativeModeTab(DIVINERPG_BLOCKS, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_blocks"))
                .icon(() -> new ItemStack(BlockRegistry.edenLamp.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    // Torches
                    output.accept(new ItemStack(BlockRegistry.aquaTorch.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumTorch.get()));
                    output.accept(new ItemStack(BlockRegistry.edenTorch.get()));
                    output.accept(new ItemStack(BlockRegistry.skeletonTorch.get()));

                    // Ores
                    output.accept(new ItemStack(BlockRegistry.arlemiteOre.get()));
                    output.accept(new ItemStack(BlockRegistry.arlemiteOreDeepslate.get()));
                    output.accept(new ItemStack(BlockRegistry.realmiteOreDeepslate.get()));
                    output.accept(new ItemStack(BlockRegistry.realmiteOreDeepslate.get()));
                    output.accept(new ItemStack(BlockRegistry.rupeeOreDeepslate.get()));
                    output.accept(new ItemStack(BlockRegistry.rupeeOreDeepslate.get()));
                    output.accept(new ItemStack(BlockRegistry.bloodgemBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.torriditeBlock.get()));

                    // Storage Blocks
                    output.accept(new ItemStack(BlockRegistry.arlemiteBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.rawArlemiteBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.realmiteBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.rawRealmiteBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.rupeeBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.rawRupeeBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.bloodgemBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.torriditeBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.rawTorriditeBlock.get()));

                    // Boss Spawners
                    output.accept(new ItemStack(BlockRegistry.sunstormSpawner.get()));
                    output.accept(new ItemStack(BlockRegistry.termasectSpawner.get()));
                    output.accept(new ItemStack(BlockRegistry.eternalArcherSpawner.get()));
                    output.accept(new ItemStack(BlockRegistry.experiencedCoriSpawner.get()));

                    // Pumpkins
                    output.accept(new ItemStack(BlockRegistry.blazePumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.creeperPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.cyclopsPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.enderPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.enderWatcherPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.frostPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.ghastPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.glaconPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.hellspiderPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.jungleSpiderPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.skeletonPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.spiderPumpkin.get()));
                    output.accept(new ItemStack(BlockRegistry.zombiePumpkin.get()));

                    // Steel
                    output.accept(new ItemStack(BlockRegistry.blackSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.blueSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.brightRedSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.greenSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.orangeSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.purpleSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.redSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.whiteSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.yellowSteel.get()));
                    output.accept(new ItemStack(BlockRegistry.tealSteel.get()));

                    // Vane
                    output.accept(new ItemStack(BlockRegistry.blueVane.get()));
                    output.accept(new ItemStack(BlockRegistry.cyanVane.get()));
                    output.accept(new ItemStack(BlockRegistry.purpleVane.get()));
                    output.accept(new ItemStack(BlockRegistry.redVane.get()));
                    output.accept(new ItemStack(BlockRegistry.yellowVane.get()));

                    // Bricks
                    output.accept(new ItemStack(BlockRegistry.aquatonicBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.lavaBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.arlemiteBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.darkstoneBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.diamondBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.goldBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.greenBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.ironBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.lapisLazuliBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.milkStoneBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.torriditeBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.pinkBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.purpleBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.realmiteBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.redstoneBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.edenBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumBricks.get()));
                    // Minibricks
                    output.accept(new ItemStack(BlockRegistry.minibricks.get()));
                    output.accept(new ItemStack(BlockRegistry.arlemiteMinibricks.get()));
                    output.accept(new ItemStack(BlockRegistry.bedrockMinibricks.get()));
                    output.accept(new ItemStack(BlockRegistry.torriditeMinibricks.get()));
                    output.accept(new ItemStack(BlockRegistry.realmiteMinibricks.get()));
                    output.accept(new ItemStack(BlockRegistry.bloodgemMinibricks.get()));
                    output.accept(new ItemStack(BlockRegistry.rupeeMinibricks.get()));

                    // Lamps
                    output.accept(new ItemStack(BlockRegistry.aquaLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.arlemiteLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.blazeLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.bluefireLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.diamondLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.divineLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.drakenLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.edenLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.enderLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.enderStoneLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.goldLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.iceLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.jungleLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.krakenLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.lapisLazuliLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.lavaLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.milkyLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.moltenLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.torriditeLamp.get())); // <- Out of Alphabetical Order
                    output.accept(new ItemStack(BlockRegistry.realmiteLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.redstoneOreLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.rupeeLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.terranLamp.get()));

                    // Fences
                    output.accept(new ItemStack(BlockRegistry.blueFence.get()));
                    output.accept(new ItemStack(BlockRegistry.greenFence.get()));
                    output.accept(new ItemStack(BlockRegistry.redFence.get()));

                    // Asphalt
                    output.accept(new ItemStack(BlockRegistry.asphalt.get()));
                    output.accept(new ItemStack(BlockRegistry.asphaltStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.asphaltSlab.get()));

                    // Other Misc. Blocks
                    output.accept(new ItemStack(BlockRegistry.blueStone.get()));
                    output.accept(new ItemStack(BlockRegistry.checker.get()));
                    output.accept(new ItemStack(BlockRegistry.crate.get()));
                    output.accept(new ItemStack(BlockRegistry.darkstone.get()));
                    output.accept(new ItemStack(BlockRegistry.fancyWool.get()));
                    output.accept(new ItemStack(BlockRegistry.milkStone.get()));
                    output.accept(new ItemStack(BlockRegistry.plankDesign.get()));
                    output.accept(new ItemStack(BlockRegistry.rainbowWool.get()));
                    output.accept(new ItemStack(BlockRegistry.spikeBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.hotSpikeBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.altarOfCorruption.get()));
                    output.accept(new ItemStack(BlockRegistry.frostedAllure.get()));

                    // Divine Tree
                    output.accept(new ItemStack(BlockRegistry.divineSapling.get()));
                    output.accept(new ItemStack(BlockRegistry.divineLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedDivineLog.get()));
                    output.accept(new ItemStack(BlockRegistry.divineLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.divinePlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.divineStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.divineMossStone.get()));
                    output.accept(new ItemStack(BlockRegistry.divineRock.get()));

                    // These Were Just Here <----------------------------------------- Should Be Rearranged (Likely)
                    output.accept(new ItemStack(BlockRegistry.slimeLight.get()));
                    output.accept(new ItemStack(BlockRegistry.darkBridge.get()));

                    // Plants <----------------------------------------- Typically these aren't in the Creative Menu
                    output.accept(new ItemStack(BlockRegistry.tomatoPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.whiteMushroomPlant.get()));

                    // Boss Statues
                    output.accept(new ItemStack(BlockRegistry.ancientEntityStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.ayeracoStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.densosStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.dramixStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.eternalArcherStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.karotStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.kingOfScorchersStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.parasectaStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.reyvorStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.soulFiendStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.theWatcherStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.twilightDemonStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.vamacheronStatue.get()));
                    output.accept(new ItemStack(BlockRegistry.termasectStatue.get())); // <- Out of Alphabetical Order
                    output.accept(new ItemStack(BlockRegistry.sunstormStatue.get())); // <- Out of Alphabetical Order
                    output.accept(new ItemStack(BlockRegistry.experiencedCoriStatue.get()));  // <- Out of Alphabetical Order

                    // Iceika
                    output.accept(new ItemStack(BlockRegistry.frozenDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenStone.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedFrozenLog.get()));
                    output.accept(new ItemStack(BlockRegistry.brittleLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenPlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenSapling.get()));
                    output.accept(new ItemStack(BlockRegistry.icicle.get()));
                    output.accept(new ItemStack(BlockRegistry.thermalVent.get()));
                    output.accept(new ItemStack(BlockRegistry.brittleMoss.get()));
                    output.accept(new ItemStack(BlockRegistry.brittleGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.winterberryVinesHead.get()));
                    output.accept(new ItemStack(BlockRegistry.coalstone.get()));
                    output.accept(new ItemStack(BlockRegistry.coalstoneStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.coalstoneFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.frostedGlass.get()));
                    output.accept(new ItemStack(BlockRegistry.icyBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.snowBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.steelDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.workshopBookcase.get()));
                    output.accept(new ItemStack(BlockRegistry.workshopCarpet.get()));
                    output.accept(new ItemStack(BlockRegistry.workshopLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.blueCandyCane.get()));
                    output.accept(new ItemStack(BlockRegistry.greenCandyCane.get()));
                    output.accept(new ItemStack(BlockRegistry.pinkCandyCane.get()));
                    output.accept(new ItemStack(BlockRegistry.redCandyCane.get()));
                    output.accept(new ItemStack(BlockRegistry.yellowCandyCane.get()));
                    output.accept(new ItemStack(BlockRegistry.blueFairyLights.get()));
                    output.accept(new ItemStack(BlockRegistry.greenFairyLights.get()));
                    output.accept(new ItemStack(BlockRegistry.purpleFairyLights.get()));
                    output.accept(new ItemStack(BlockRegistry.redFairyLights.get()));
                    output.accept(new ItemStack(BlockRegistry.yellowFairyLights.get()));
                    output.accept(new ItemStack(BlockRegistry.winterberryBush.get()));
                    output.accept(new ItemStack(BlockRegistry.iceikaFire.get()));

                    /* Twilight Dimensions Sets */
                    // Dirt
                    output.accept(new ItemStack(BlockRegistry.edenDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumDirt.get()));
                    // Grass
                    output.accept(new ItemStack(BlockRegistry.edenGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumGrass.get()));
                    // Ores
                    output.accept(new ItemStack(BlockRegistry.edenOre.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodOre.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaOre.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernOre.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumOre.get()));
                    // Saplings
                    output.accept(new ItemStack(BlockRegistry.edenSapling.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodSapling.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaSapling.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernSapling.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumSapling.get()));
                    // Logs
                    output.accept(new ItemStack(BlockRegistry.edenLog.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaLog.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernLog.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumLog.get()));
                    // Stripped Logs
                    output.accept(new ItemStack(BlockRegistry.strippedEdenLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedWildwoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedApalachiaLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedSkythernLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedMortumLog.get()));
                    // Leaves
                    output.accept(new ItemStack(BlockRegistry.edenLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumLeaves.get()));
                    // Planks
                    output.accept(new ItemStack(BlockRegistry.edenPlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodPlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaPlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernPlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumPlanks.get()));
                    // Stairs
                    output.accept(new ItemStack(BlockRegistry.edenStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumStairs.get()));
                    // Doors (All Doors)
                    output.accept(new ItemStack(BlockRegistry.edenDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.divineDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusDoor.get()));
                    // Trapdoors (All Trapdoors)
                    output.accept(new ItemStack(BlockRegistry.edenTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.divineTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenTrapdoor.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusTrapdoor.get()));
                    // Buttons (All Buttons)
                    output.accept(new ItemStack(BlockRegistry.edenButton.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodButton.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaButton.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernButton.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumButton.get()));
                    output.accept(new ItemStack(BlockRegistry.divineButton.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenButton.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusButton.get()));
                    // Pressure Plates (All Pressure Plates)
                    output.accept(new ItemStack(BlockRegistry.edenPressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodPressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaPressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernPressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumPressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.divinePressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenPressurePlate.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusPressurePlate.get()));
                    // Fences (All Fences)
                    output.accept(new ItemStack(BlockRegistry.edenFence.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodFence.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaFence.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernFence.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumFence.get()));
                    output.accept(new ItemStack(BlockRegistry.divineFence.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenFence.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusFence.get()));
                    // Fence Gates (All Fence Gates)
                    output.accept(new ItemStack(BlockRegistry.edenFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.divineFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenFenceGate.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusFenceGate.get()));
                    // Blocks
                    output.accept(new ItemStack(BlockRegistry.edenBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumBlock.get()));
                    // Eden Foliage
                    output.accept(new ItemStack(BlockRegistry.sunBlossom.get()));
                    output.accept(new ItemStack(BlockRegistry.sunbloom.get()));
                    output.accept(new ItemStack(BlockRegistry.edenBrush.get()));
                    // Wildwood Foliage
                    output.accept(new ItemStack(BlockRegistry.moonBud.get()));
                    output.accept(new ItemStack(BlockRegistry.moonlightFern.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodTallgrass.get()));
                    // Apalachia Foliage
                    output.accept(new ItemStack(BlockRegistry.duskBloom.get()));
                    output.accept(new ItemStack(BlockRegistry.duskFlower.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaTallgrass.get()));
                    // Skythern Foliage
                    output.accept(new ItemStack(BlockRegistry.dustBrambles.get()));
                    output.accept(new ItemStack(BlockRegistry.dustLily.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernBrush.get()));
                    // Mortum Foliage
                    output.accept(new ItemStack(BlockRegistry.demonBrambles.get()));
                    output.accept(new ItemStack(BlockRegistry.eyePlant.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumBrush.get()));

                    // Plants <--------------------------------- Typically Plants Aren't In Creative Menu, Seeds Are
                    output.accept(new ItemStack(BlockRegistry.moonbulbPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.pinkGlowbonePlant.get()));
                    output.accept(new ItemStack(BlockRegistry.purpleGlowbonePlant.get()));
                    output.accept(new ItemStack(BlockRegistry.skyPlant.get()));

                    // Another Groupless Section
                    output.accept(new ItemStack(BlockRegistry.wildwoodVine.get())); // <--- Move Near Wildwood Stuff
                    output.accept(new ItemStack(BlockRegistry.blueFire.get()));
                    output.accept(new ItemStack(BlockRegistry.truffle.get()));

                    /* Arcana */
                    // Arcan-
                    output.accept(new ItemStack(BlockRegistry.arcaniteDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniteSand.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanicSand.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanium_rich_sand.get())); // <---- Item-Styled Name?
                    output.accept(new ItemStack(BlockRegistry.arcaniteGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniteMoss.get()));
                    output.accept(new ItemStack(BlockRegistry.rawArcanium.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumBlock.get()));

                    // Ancient
                    output.accept(new ItemStack(BlockRegistry.ancientBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientBrickStairs.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientStone.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientTile.get()));

                    // Back to Arcan-
                    output.accept(new ItemStack(BlockRegistry.arcaniteTubes.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniteLadder.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumMetal.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumPower.get()));

                    // Degraded Bricks
                    output.accept(new ItemStack(BlockRegistry.darkDegradedBrick.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickStairs.get()));

                    // Dungeon Blocks
                    output.accept(new ItemStack(BlockRegistry.dungeonBookshelf.get()));
                    output.accept(new ItemStack(BlockRegistry.dungeonLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.heatTrap.get()));

                    // Degraded Bricks (Cont.)
                    output.accept(new ItemStack(BlockRegistry.lightDegradedBrick.get()));

                    // Soul Blocks
                    output.accept(new ItemStack(BlockRegistry.soulSludge.get()));
                    output.accept(new ItemStack(BlockRegistry.soulStone.get()));

                    // Bricks <------------------------------------------------ Maybe Combine With Section Far Above
                    output.accept(new ItemStack(BlockRegistry.battleBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.gildedBricks.get()));

                    // Breakable versions of unbreakable blocks
                    output.accept(new ItemStack(BlockRegistry.ancientBricksBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientBrickStairsBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientBrickSlabBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientBrickWallBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientStoneBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.ancientTileBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumMetalBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumPowerBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickStairsBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickSlabBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickWallBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.dungeonLampBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.soulSludgeBreakable.get()));
                    output.accept(new ItemStack(BlockRegistry.soulStoneBreakable.get()));

                    output.accept(new ItemStack(BlockRegistry.arcaniteStone.get())); // <- Combine with other arcan-stuff

                    // Doors
                    output.accept(new ItemStack(BlockRegistry.ancientBrickDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.soulSludgeDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.soulStoneDoor.get()));

                    // Altars
                    output.accept(new ItemStack(BlockRegistry.dramixAltar.get()));
                    output.accept(new ItemStack(BlockRegistry.parasectaAltar.get()));

                    // Stained Glass
                    output.accept(new ItemStack(BlockRegistry.stainedGlass.get())); // <- Rename to stainedGlass1 for consistency
                    output.accept(new ItemStack(BlockRegistry.stainedGlass2.get()));
                    output.accept(new ItemStack(BlockRegistry.stainedGlass3.get()));
                    output.accept(new ItemStack(BlockRegistry.stainedGlass4.get()));
                    output.accept(new ItemStack(BlockRegistry.stainedGlass5.get()));
                    output.accept(new ItemStack(BlockRegistry.stainedGlass6.get()));
                    output.accept(new ItemStack(BlockRegistry.stainedGlass7.get()));
                    output.accept(new ItemStack(BlockRegistry.stainedGlass8.get()));

                    // Eucalyptus
                    output.accept(new ItemStack(BlockRegistry.eucalyptusLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedEucalyptusLog.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusPlanks.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusStairs.get()));

                    // More Plants
                    output.accept(new ItemStack(BlockRegistry.aquamarinePlant.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.firestockPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.hitchakPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.lamonaPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.marsinePlant.get()));
                    output.accept(new ItemStack(BlockRegistry.pinflyPlant.get()));
                    output.accept(new ItemStack(BlockRegistry.veiloPlant.get()));

                    // Arcan-Plants
                    output.accept(new ItemStack(BlockRegistry.arcaniteVinesHead.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanaBrush.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanaBush.get()));
                    output.accept(new ItemStack(BlockRegistry.gemOfTheDunes.get()));

                    // Random Block
                    output.accept(new ItemStack(BlockRegistry.starBridge.get()));

                    // Encaged Blocks
                    output.accept(new ItemStack(BlockRegistry.encagedCaptainMerik.get()));
                    output.accept(new ItemStack(BlockRegistry.encagedDatticon.get()));
                    output.accept(new ItemStack(BlockRegistry.encagedKazari.get()));
                    output.accept(new ItemStack(BlockRegistry.encagedLeorna.get()));
                    output.accept(new ItemStack(BlockRegistry.encagedLordVatticus.get()));
                    output.accept(new ItemStack(BlockRegistry.encagedWarGeneral.get()));
                    output.accept(new ItemStack(BlockRegistry.encagedZelus.get()));

                    // Portal Blocks
                    output.accept(new ItemStack(BlockRegistry.iceikaPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.edenPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.vetheaPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanaPortal.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanaPortalFrame.get()));
                    output.accept(new ItemStack(BlockRegistry.arcanaHardPortalFrame.get()));

                    // Wood Slabs (Should Be Moved Up By Woods)
                    output.accept(new ItemStack(BlockRegistry.edenSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.wildwoodSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.apalachiaSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.skythernSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.mortumSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.divineSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.frozenSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.eucalyptusSlab.get()));

                    // Brick Slabs (Should Be Moved Up By Same Blocks)
                    output.accept(new ItemStack(BlockRegistry.ancientBrickSlab.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickSlab.get()));

                    // Brick Walls (Should Be Moved Up By Same Blocks)
                    output.accept(new ItemStack(BlockRegistry.ancientBrickWall.get()));
                    output.accept(new ItemStack(BlockRegistry.degradedBrickWall.get()));
                }));

        // Ranged Weapons
        event.registerCreativeModeTab(DIVINERPG_RANGED_WEAPONS, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_ranged_weapons"))
                .icon(() -> new ItemStack(ItemRegistry.vile_storm.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    // Arrows
                    output.accept(new ItemStack(ItemRegistry.eden_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.fury_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_arrow.get()));

                    // Anchors
                    output.accept(new ItemStack(ItemRegistry.bowhead_anchor.get()));
                    output.accept(new ItemStack(ItemRegistry.crab_anchor.get()));
                    output.accept(new ItemStack(ItemRegistry.liopleurodon_anchor.get()));
                    output.accept(new ItemStack(ItemRegistry.shark_anchor.get()));

                    // Misc. Weapons
                    output.accept(new ItemStack(ItemRegistry.arcanite_blaster.get()));
                    output.accept(new ItemStack(ItemRegistry.captains_sparkler.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.firefly.get()));
                    output.accept(new ItemStack(ItemRegistry.generals_staff.get()));
                    output.accept(new ItemStack(ItemRegistry.grenade.get()));
                    output.accept(new ItemStack(ItemRegistry.la_vekor.get()));
                    output.accept(new ItemStack(ItemRegistry.meriks_missile.get()));
                    output.accept(new ItemStack(ItemRegistry.meteor_mash.get()));

                    // Sounds
                    output.accept(new ItemStack(ItemRegistry.sound_of_carols.get()));
                    output.accept(new ItemStack(ItemRegistry.sound_of_music.get()));

                    // Scythe
                    output.accept(new ItemStack(ItemRegistry.scythe.get()));

                    // Serenades
                    output.accept(new ItemStack(ItemRegistry.serenade_of_death.get()));
                    output.accept(new ItemStack(ItemRegistry.serenade_striker.get()));

                    // Starlight
                    output.accept(new ItemStack(ItemRegistry.staff_of_starlight.get()));
                    output.accept(new ItemStack(ItemRegistry.starlight.get()));

                    // Slicers
                    output.accept(new ItemStack(ItemRegistry.eden_slicer.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_slicer.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_slicer.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_slicer.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_slicer.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_slicer.get()));
                    output.accept(new ItemStack(ItemRegistry.shuriken.get()));
                    output.accept(new ItemStack(ItemRegistry.snowflake_shuriken.get()));

                    // Blitz
                    output.accept(new ItemStack(ItemRegistry.eden_blitz.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_blitz.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_blitz.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_blitz.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_blitz.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_blitz.get()));

                    // Vile Storm
                    output.accept(new ItemStack(ItemRegistry.vile_storm.get()));

                    // Bows
                    output.accept(new ItemStack(ItemRegistry.apalachia_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.bluefire_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.hunter_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.icicle_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.inferno_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.snowstorm_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.twilight_bow.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_bow.get()));

                    // Mix of Phasers & Canons (Needs Sorting)
                    output.accept(new ItemStack(ItemRegistry.apalachia_phaser.get()));
                    output.accept(new ItemStack(ItemRegistry.bowhead_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.crabclaw_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.cyclopsian_staff.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_phaser.get()));
                    output.accept(new ItemStack(ItemRegistry.fractite_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.frost_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.frostclaw_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.ghast_cannon.get()));
                    output.accept(new ItemStack(ItemRegistry.golden_fury.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_phaser.get()));
                    output.accept(new ItemStack(ItemRegistry.maelstrom.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_phaser.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_phaser.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_phaser.get()));
                }));

        // Melee Weapons
        event.registerCreativeModeTab(DIVINERPG_MELEE_WEAPONS, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_melee_weapons"))
                .icon(() -> new ItemStack(ItemRegistry.aquaton.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    // No Order? Organize?
                    output.accept(new ItemStack(ItemRegistry.arcanite_blade.get()));
                    output.accept(new ItemStack(ItemRegistry.arcanium_saber.get()));
                    output.accept(new ItemStack(ItemRegistry.flaming_fury.get()));
                    output.accept(new ItemStack(ItemRegistry.inferno_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.molten_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_scepter.get()));
                    output.accept(new ItemStack(ItemRegistry.frossivence.get()));
                    output.accept(new ItemStack(ItemRegistry.massivence.get()));
                    output.accept(new ItemStack(ItemRegistry.palavence.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_knife.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_rapier.get()));
                    output.accept(new ItemStack(ItemRegistry.poison_saber.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_saber.get()));
                    output.accept(new ItemStack(ItemRegistry.enderice.get()));
                    output.accept(new ItemStack(ItemRegistry.frost_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.frostking_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.frozen_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.glacier_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.icicle_bane.get()));
                    output.accept(new ItemStack(ItemRegistry.icine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.snowslash.get()));
                    output.accept(new ItemStack(ItemRegistry.storm_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_blade.get()));
                    output.accept(new ItemStack(ItemRegistry.aquatic_dagger.get()));
                    output.accept(new ItemStack(ItemRegistry.aquatic_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.aquatic_trident.get()));
                    output.accept(new ItemStack(ItemRegistry.aquaton.get()));
                    output.accept(new ItemStack(ItemRegistry.aquatooth_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.aquatooth_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_stabber.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.bloodgem_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.bluefire_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.crabclaw_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.cyclopsian_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.death_bringer.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_divine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_divine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.green_divine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.red_divine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_divine_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.dual_claw.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_blade.get()));
                    output.accept(new ItemStack(ItemRegistry.black_ender_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_ender_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.green_ender_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.red_ender_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_ender_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.fury_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_blade.get()));
                    output.accept(new ItemStack(ItemRegistry.livicia_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_blade.get()));
                    output.accept(new ItemStack(ItemRegistry.ocean_knife.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_rapier.get()));
                    output.accept(new ItemStack(ItemRegistry.sandslash.get()));
                    output.accept(new ItemStack(ItemRegistry.scorching_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_blade.get()));
                    output.accept(new ItemStack(ItemRegistry.slime_sword.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_dagger.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_knife.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_maul.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_blade.get()));
                }));

        // Tools
        event.registerCreativeModeTab(DIVINERPG_TOOLS, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_tools"))
                .icon(() -> new ItemStack(ItemRegistry.aquaton.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    output.accept(new ItemStack(ItemRegistry.staff_of_enrichment.get()));
                    // Axes
                    output.accept(new ItemStack(ItemRegistry.realmite_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_axe.get()));
                    // Hoes
                    output.accept(new ItemStack(ItemRegistry.apalachia_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_hoe.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_hoe.get()));
                    // Pickaxes
                    output.accept(new ItemStack(ItemRegistry.realmite_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_pickaxe.get()));
                    // Shovels
                    output.accept(new ItemStack(ItemRegistry.realmite_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_shovel.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_shovel.get()));
                    // Shickaxes
                    output.accept(new ItemStack(ItemRegistry.apalachia_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_shickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_shickaxe.get()));
                }));

        // Raw Materials
        event.registerCreativeModeTab(DIVINERPG_RAW_MATERIALS, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_raw_materials"))
                .icon(() -> new ItemStack(ItemRegistry.rupee_ingot.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    output.accept(new ItemStack(ItemRegistry.divine_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.dungeon_tokens.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_dust.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_fragments.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_gem.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_heart.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_soul.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_sparkles.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_shards.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.firestock.get()));
                    output.accept(new ItemStack(ItemRegistry.fury_fire.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_diamond_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.green_diamond_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.hellstone_ingot.get()));
                    output.accept(new ItemStack(ItemRegistry.ice_shards.get()));
                    output.accept(new ItemStack(ItemRegistry.ice_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_shards.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.kraken_scale.get()));
                    output.accept(new ItemStack(ItemRegistry.kraken_skin.get()));
                    output.accept(new ItemStack(ItemRegistry.lamona.get()));
                    output.accept(new ItemStack(ItemRegistry.legendary_ender_eye.get()));
                    output.accept(new ItemStack(ItemRegistry.liopleurodon_skull.get()));
                    output.accept(new ItemStack(ItemRegistry.liopleurodon_teeth.get()));
                    output.accept(new ItemStack(ItemRegistry.marsine.get()));
                    output.accept(new ItemStack(ItemRegistry.molten_shards.get()));
                    output.accept(new ItemStack(ItemRegistry.molten_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_dust.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_fragments.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_gem.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_heart.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_soul.get()));
                    output.accept(new ItemStack(ItemRegistry.orb_of_light.get()));
                    output.accept(new ItemStack(ItemRegistry.pure_aquatic_pellets.get()));
                    output.accept(new ItemStack(ItemRegistry.purple_blaze.get()));
                    output.accept(new ItemStack(ItemRegistry.raw_arlemite.get()));
                    output.accept(new ItemStack(ItemRegistry.raw_realmite.get()));
                    output.accept(new ItemStack(ItemRegistry.raw_rupee.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_ingot.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_nugget.get()));
                    output.accept(new ItemStack(ItemRegistry.red_diamond_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_ingot.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_nugget.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_bar.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_coins.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.shark_fin.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_dust.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_fragments.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_gem.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_heart.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_soul.get()));
                    output.accept(new ItemStack(ItemRegistry.snowflake.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_shards.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_stone.get()));
                    output.accept(new ItemStack(ItemRegistry.raw_torridite.get())); // <-- Out of Alphabetical Order
                    output.accept(new ItemStack(ItemRegistry.torridite_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.torridite_ingot.get()));
                    output.accept(new ItemStack(ItemRegistry.torridite_nugget.get()));
                    output.accept(new ItemStack(ItemRegistry.veilo.get()));
                    output.accept(new ItemStack(ItemRegistry.watching_eye.get()));
                    output.accept(new ItemStack(ItemRegistry.whale_fin.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_dust.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_fragments.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_gem.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_heart.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_soul.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_diamond_chunk.get()));
                    output.accept(new ItemStack(ItemRegistry.ancient_key.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_key.get()));
                    output.accept(new ItemStack(ItemRegistry.sludge_key.get()));
                    output.accept(new ItemStack(ItemRegistry.soul_key.get()));
                    output.accept(new ItemStack(ItemRegistry.collector.get()));
                    output.accept(new ItemStack(ItemRegistry.healing_stone.get()));
                    output.accept(new ItemStack(FluidRegistry.SMOLDERING_TAR_BUCKET.get()));
                }));

        // Armor
        event.registerCreativeModeTab(DIVINERPG_ARMOR, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_armor"))
                .icon(() -> new ItemStack(ItemRegistry.divine_helmet.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    // Shields
                    output.accept(new ItemStack(ItemRegistry.realmite_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_shield.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_shield.get()));
                    // Armor
                    output.accept(new ItemStack(ItemRegistry.angelic_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.angelic_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.angelic_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.angelic_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.apalachia_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.aquastrive_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.aquastrive_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.aquastrive_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.aquastrive_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.arlemite_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.awakened_halite_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.awakened_halite_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.awakened_halite_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.awakened_halite_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.bedrock_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_ender_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_ender_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_ender_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_ender_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_rupee_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_rupee_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_rupee_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_rupee_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.corrupted_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.eden_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.elite_realmite_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.elite_realmite_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.elite_realmite_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.elite_realmite_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.ender_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.frozen_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.frozen_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.frozen_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.frozen_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_ender_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_ender_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_ender_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_ender_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.rupee_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.green_ender_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.green_ender_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.green_ender_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.green_ender_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_rupee_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_rupee_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_rupee_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_rupee_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.green_rupee_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.green_rupee_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.green_rupee_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.green_rupee_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.halite_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.inferno_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.inferno_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.inferno_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.inferno_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.jack_o_man_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.jack_o_man_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.jack_o_man_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.jack_o_man_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.jungle_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.korma_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.korma_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.korma_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.korma_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.kraken_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.kraken_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.kraken_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.kraken_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.mortum_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.realmite_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.red_ender_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.red_ender_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.red_ender_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.red_ender_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.red_rupee_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.red_rupee_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.red_rupee_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.red_rupee_boots.get()));
                    // Santa armor goes here, but I think it was removed in the Iceika rework
                    output.accept(new ItemStack(ItemRegistry.shadow_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.shadow_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.skeleman_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.skeleman_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.skeleman_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.skeleman_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.skythern_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.terran_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.torridite_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.torridite_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.torridite_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.torridite_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.vemos_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.vemos_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.vemos_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.vemos_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.wildwood_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.wither_reaper_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.wither_reaper_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.wither_reaper_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.wither_reaper_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_rupee_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_rupee_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_rupee_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_rupee_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_hood.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_mask.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_hood.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_mask.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_hood.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_mask.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_hood.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_mask.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_boots.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_helmet.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_hood.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_mask.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_chestplate.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_leggings.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_boots.get()));
                }));

        // Spawner
        event.registerCreativeModeTab(DIVINERPG_SPAWNER, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_spawner"))
                .icon(() -> new ItemStack(ItemRegistry.call_of_the_watcher.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    output.accept(new ItemStack(ItemRegistry.call_of_the_watcher.get()));
                    output.accept(new ItemStack(ItemRegistry.densos_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.infernal_flame.get()));
                    output.accept(new ItemStack(ItemRegistry.karot_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.mysterious_clock.get()));
                    output.accept(new ItemStack(ItemRegistry.reyvor_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.soul_fiend_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.twilight_demon_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.vamacheron_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.wizards_book.get()));
                    output.accept(new ItemStack(ItemRegistry.ghostbane.get()));
                    output.accept(new ItemStack(ItemRegistry.horde_horn.get()));
                    output.accept(new ItemStack(ItemRegistry.brown_grizzle_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.ehu_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.fyracryx_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.golem_of_rejuvenation_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.husk_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.paratiku_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.seimer_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.smelter_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.snapper_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.stone_golem_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.white_grizzle_egg.get()));
                    // Do not know how to grab other spawn eggs
                        /* Aequorea
                           Arid Warrior
                           Cave Crawler
                           Caveclops
                           Crab
                           Cyclops
                           Desert Crawler
                           Diamond Dave
                           Enthralled Damacryx
                           Frost
                           Glacon
                           Jungle Bat
                           Jungle Dramacryx
                           Jungle Spider
                           King Crab
                           Kobblin
                           Liopleuraodon
                           Livestock Merchant
                           Miner
                           Pumpkin Spider
                           Rainbour
                           Rotatick
                           Saguaro Worm
                           Shark
                           The Eye
                           The Grue
                           Whale
                           Hell Bat
                           Hell Pig
                           Hell Spider
                           Scorcher
                           Wildfire
                           Ender Spider
                           Ender Scrounge
                           Ender Triplets
                           Ender Watcher
                           Alicanto
                           Fractite
                           Frost Archer
                           Frosty
                           Glacide
                           Hastreus
                           Rollum
                           Workshop Merchant
                           Workshop Tinkerer
                           Glinthop
                           Eden Cadillion
                           Eden Tomo
                           Greenfeet
                           Madivel
                           Sun Archer
                           Weak Cori
                           Behemoth
                           Epiphite
                           Mage
                           Moon Wolf
                           Termid
                           Verek
                           Wildwood Cadillion
                           Wildwood Golem
                           Wildwood Tomo
                           Apalachia Cadillion
                           Apalachia Golem
                           Apalachia Tomo
                           Enchanted Archer
                           Enchanted Warrior
                           Spellbinder
                           Advanced Cori
                           Megalith
                           Mystic
                           Samek
                           Skythern Archer
                           Skythern Fiend
                           Skythern Golem
                           Angry Glinthop
                           Basilisk
                           Demon of Darkness
                           Mortum Cadillion
                           Sorcerer
                           Soul Spider
                           Soul Stealer
                           Twilight Archer
                           Captain Merik
                           Datticon
                           Deathcryx
                           Death Hound
                           Dungeon Constructor
                           Dungeon Prisoner
                           Kazari
                           Leorna
                           Living Statue
                           Lord Vatticus
                           Razorback
                           Roamer
                           Skyre
                           War General
                           Wraith
                           Zelus
                           Acid Hag
                           Biphron
                           Bohemite
                           Crypt Keeper
                           Cymesoid
                           Dissiment
                           Dreamwrecker
                           Duo
                           Ent
                           Fake Vhraak
                           Galroid
                           Gorgosion
                           Helio
                           Hive Soldier
                           Hover Stinger
                           Kazrotic
                           Lhevia
                           Lorga
                           Lorga Flight
                           Mandragora
                           Mysterious Man Layer 1
                           Mysterious Man Layer 2
                           Mysterious Man Layer 3
                           Shadahier
                           The Hunger
                           Temple Guardian
                           Tocaxin
                           Twins
                           Vermenous
                           Vhraak
                           Zone
                           Zoragon
                        */
                }));

        // Utility
        event.registerCreativeModeTab(DIVINERPG_UTILITY, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_utility"))
                .icon(() -> new ItemStack(ItemRegistry.snow_globe.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    output.accept(new ItemStack(ItemRegistry.arcanium_attractor.get()));
                    output.accept(new ItemStack(ItemRegistry.arcanium_reflector.get()));
                    output.accept(new ItemStack(ItemRegistry.snow_globe.get()));
                    output.accept(new ItemStack(ItemRegistry.serenade_of_health.get()));
                    output.accept(new ItemStack(ItemRegistry.serenade_of_ice.get()));
                    output.accept(new ItemStack(ItemRegistry.serenade_of_infusion.get()));
                    output.accept(new ItemStack(ItemRegistry.teleportation_crystal.get()));
                    output.accept(new ItemStack(ItemRegistry.teleportation_star.get()));
                    output.accept(new ItemStack(ItemRegistry.aquamarine.get()));
                    output.accept(new ItemStack(ItemRegistry.strong_arcana_potion.get()));
                    output.accept(new ItemStack(ItemRegistry.weak_arcana_potion.get()));
                    output.accept(new ItemStack(ItemRegistry.divine_accumulator.get()));
                    output.accept(new ItemStack(ItemRegistry.twilight_clock.get()));
                    output.accept(new ItemStack(ItemRegistry.armor_pouch.get()));
                    output.accept(new ItemStack(ItemRegistry.blue_armor_pouch.get()));
                    output.accept(new ItemStack(ItemRegistry.gray_armor_pouch.get()));
                    output.accept(new ItemStack(ItemRegistry.green_armor_pouch.get()));
                    output.accept(new ItemStack(ItemRegistry.red_armor_pouch.get()));
                    output.accept(new ItemStack(ItemRegistry.yellow_armor_pouch.get()));
                    // Some Stuff That Should Be With Blocks
                    output.accept(new ItemStack(BlockRegistry.boneChest.get()));
                    output.accept(new ItemStack(BlockRegistry.frostedChest.get()));
                    output.accept(new ItemStack(BlockRegistry.presentBox.get()));
                    output.accept(new ItemStack(BlockRegistry.edenChest.get()));
                    output.accept(new ItemStack(BlockRegistry.arcaniumExtractor.get()));
                    output.accept(new ItemStack(BlockRegistry.greenlightFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.oceanfireFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.moltenFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.whitefireFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.moonlightFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.demonFurnace.get()));
                    output.accept(new ItemStack(BlockRegistry.acceleron.get()));
                    output.accept(new ItemStack(BlockRegistry.elevantium.get()));
                }));

        // Food
        event.registerCreativeModeTab(DIVINERPG_FOOD, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_food"))
                .icon(() -> new ItemStack(ItemRegistry.bacon.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    output.accept(new ItemStack(ItemRegistry.dream_sweets.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_sours.get()));
                    output.accept(new ItemStack(ItemRegistry.sky_flower.get()));
                    output.accept(new ItemStack(ItemRegistry.egg_nog.get()));
                    output.accept(new ItemStack(ItemRegistry.moonbulb.get()));
                    output.accept(new ItemStack(ItemRegistry.pink_glowbone.get()));
                    output.accept(new ItemStack(ItemRegistry.purple_glowbone.get()));
                    output.accept(new ItemStack(ItemRegistry.magic_meat.get()));
                    output.accept(new ItemStack(ItemRegistry.enriched_magic_meat.get()));
                    output.accept(new ItemStack(ItemRegistry.forbidden_fruit.get()));
                    output.accept(new ItemStack(ItemRegistry.white_mushroom.get()));
                    output.accept(new ItemStack(ItemRegistry.peppermints.get()));
                    output.accept(new ItemStack(ItemRegistry.cheese.get()));
                    output.accept(new ItemStack(ItemRegistry.pinfly.get()));
                    output.accept(new ItemStack(ItemRegistry.snow_cones.get()));
                    output.accept(new ItemStack(ItemRegistry.bacon.get()));
                    output.accept(new ItemStack(ItemRegistry.hitchak.get()));
                    output.accept(new ItemStack(ItemRegistry.tomato.get()));
                    output.accept(new ItemStack(ItemRegistry.boiled_egg.get()));
                    output.accept(new ItemStack(ItemRegistry.chocolate_log.get()));
                    output.accept(new ItemStack(ItemRegistry.winterberry.get()));
                    output.accept(new ItemStack(ItemRegistry.raw_empowered_meat.get()));
                    output.accept(new ItemStack(ItemRegistry.hot_pumpkin_pie.get()));
                    output.accept(new ItemStack(ItemRegistry.advanced_mushroom_stew.get()));
                    output.accept(new ItemStack(ItemRegistry.empowered_meat.get()));
                    output.accept(new ItemStack(ItemRegistry.fruit_cake.get()));
                    output.accept(new ItemStack(ItemRegistry.donut.get()));
                    output.accept(new ItemStack(ItemRegistry.chicken_dinner.get()));
                    output.accept(new ItemStack(ItemRegistry.aquamarine_seeds.get()));
                    output.accept(new ItemStack(ItemRegistry.eucalyptus_root_seeds.get()));
                    output.accept(new ItemStack(BlockRegistry.firestockPlant.get())); // Plants normally not in Creative Menu
                    output.accept(new ItemStack(ItemRegistry.hitchak_seeds.get()));
                    output.accept(new ItemStack(ItemRegistry.lamona_seeds.get()));
                    output.accept(new ItemStack(ItemRegistry.marsine_seeds.get()));
                    output.accept(new ItemStack(BlockRegistry.pinflyPlant.get())); // Plants normally not in Creative Menu
                    output.accept(new ItemStack(ItemRegistry.pink_glowbone_seeds.get()));
                    output.accept(new ItemStack(ItemRegistry.purple_glowbone_seeds.get()));
                    output.accept(new ItemStack(BlockRegistry.skyPlant.get())); // Plants normally not in Creative Menu
                    output.accept(new ItemStack(ItemRegistry.tomato_seeds.get()));
                    output.accept(new ItemStack(ItemRegistry.veilo_seeds.get()));
                    output.accept(new ItemStack(ItemRegistry.white_mushroom_seeds.get()));
                }));

        // Vethea
        event.registerCreativeModeTab(DIVINERPG_VETHEA, builder -> builder
                .title(Component.translatable("itemGroup.divinerpg_vethea"))
                .icon(() -> new ItemStack(ItemRegistry.dream_cake.get()))
                .withSearchBar()
                .displayItems((flags, output, isOp) -> {
                    output.accept(new ItemStack(ItemRegistry.dream_carrot.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_pie.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_melon.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_cake.get()));
                    output.accept(new ItemStack(ItemRegistry.acid.get()));
                    output.accept(new ItemStack(ItemRegistry.amthirmis_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.arksiane_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.backsword_template.get()));
                    output.accept(new ItemStack(ItemRegistry.band_of_heiva_hunting.get()));
                    output.accept(new ItemStack(ItemRegistry.bow_template.get()));
                    output.accept(new ItemStack(ItemRegistry.cannon_template.get()));
                    output.accept(new ItemStack(ItemRegistry.cermile_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.claw_template.get()));
                    output.accept(new ItemStack(ItemRegistry.clean_pearls.get()));
                    output.accept(new ItemStack(ItemRegistry.darven_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.darven_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.degraded_template.get()));
                    output.accept(new ItemStack(ItemRegistry.demonized_template.get()));
                    output.accept(new ItemStack(ItemRegistry.dirty_pearls.get()));
                    output.accept(new ItemStack(ItemRegistry.disk_template.get()));
                    output.accept(new ItemStack(ItemRegistry.dissipator_template.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_flint.get()));
                    output.accept(new ItemStack(ItemRegistry.ever_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.finished_template.get()));
                    output.accept(new ItemStack(ItemRegistry.glistening_template.get()));
                    output.accept(new ItemStack(ItemRegistry.hammer_template.get()));
                    output.accept(new ItemStack(ItemRegistry.heliosis_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.karos_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.karos_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.moon_clock.get()));
                    output.accept(new ItemStack(ItemRegistry.pardimal_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.pardimal_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.polished_pearls.get()));
                    output.accept(new ItemStack(ItemRegistry.quadrotic_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.rock_chunks.get()));
                    output.accept(new ItemStack(ItemRegistry.shiny_pearls.get()));
                    output.accept(new ItemStack(ItemRegistry.teaker_arrow.get()));
                    output.accept(new ItemStack(ItemRegistry.teaker_lump.get()));
                    output.accept(new ItemStack(ItemRegistry.tormented_template.get()));
                    output.accept(new ItemStack(ItemRegistry.nightmare_bed.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_axe.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_pickaxe.get()));
                    output.accept(new ItemStack(ItemRegistry.dream_shovel.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamDirt.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamStone.get()));
                    output.accept(new ItemStack(BlockRegistry.evergrass.get()));
                    output.accept(new ItemStack(BlockRegistry.flameGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.scorchedGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamwoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.firewoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.hyrewoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.mintwoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedDreamwoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedFirewoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedHyrewoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.strippedMintwoodLog.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamwoodLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.firewoodLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.hyrewoodLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.mintwoodLeaves.get()));
                    output.accept(new ItemStack(BlockRegistry.bulbatobe.get()));
                    output.accept(new ItemStack(BlockRegistry.cracklespike.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamglow.get()));
                    output.accept(new ItemStack(BlockRegistry.fernite.get()));
                    output.accept(new ItemStack(BlockRegistry.greenDulah.get()));
                    output.accept(new ItemStack(BlockRegistry.greenGemtop.get()));
                    output.accept(new ItemStack(BlockRegistry.purpleGemtop.get()));
                    output.accept(new ItemStack(BlockRegistry.shimmer.get()));
                    output.accept(new ItemStack(BlockRegistry.shineGrass.get()));
                    output.accept(new ItemStack(BlockRegistry.yellowDulah.get()));
                    output.accept(new ItemStack(BlockRegistry.weedwoodVine.get()));
                    output.accept(new ItemStack(BlockRegistry.blossomedWeedwoodVine.get()));
                    output.accept(new ItemStack(BlockRegistry.darkDreamBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.lightDreamBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.redDreamBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.smoothGlass.get()));
                    output.accept(new ItemStack(BlockRegistry.barredDoor.get()));
                    output.accept(new ItemStack(BlockRegistry.fireCrystal.get()));
                    output.accept(new ItemStack(BlockRegistry.firelight.get()));
                    output.accept(new ItemStack(BlockRegistry.dreamLamp.get()));
                    //output.accept(new ItemStack(BlockRegistry.greenEverstone.get())); // Guess this was removed?
                    output.accept(new ItemStack(BlockRegistry.darkEverstone.get()));
                    output.accept(new ItemStack(BlockRegistry.whiteEverstone.get()));
                    output.accept(new ItemStack(BlockRegistry.blackHungerstone.get()));
                    output.accept(new ItemStack(BlockRegistry.greenHungerstone.get()));
                    output.accept(new ItemStack(BlockRegistry.cryptFloor.get()));
                    output.accept(new ItemStack(BlockRegistry.cryptWall.get()));
                    output.accept(new ItemStack(BlockRegistry.metalCaging.get()));
                    output.accept(new ItemStack(BlockRegistry.villageLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.cellLamp.get()));
                    output.accept(new ItemStack(BlockRegistry.hiveWall.get()));
                    output.accept(new ItemStack(BlockRegistry.blackKarosBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.blueKarosBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.helioticBeam.get()));
                    output.accept(new ItemStack(BlockRegistry.karosDispenser.get()));
                    output.accept(new ItemStack(BlockRegistry.karosHeatTileGreen.get()));
                    output.accept(new ItemStack(BlockRegistry.karosHeatTileRed.get()));
                    output.accept(new ItemStack(BlockRegistry.lunaBricks.get()));
                    output.accept(new ItemStack(BlockRegistry.lunaStone.get()));
                    output.accept(new ItemStack(BlockRegistry.chamberWall.get()));
                    output.accept(new ItemStack(BlockRegistry.shiftedChamberWall.get()));
                    output.accept(new ItemStack(BlockRegistry.stackedChamberWall.get()));
                    output.accept(new ItemStack(BlockRegistry.hallWall.get()));
                    output.accept(new ItemStack(BlockRegistry.infusionTable.get()));
                    output.accept(new ItemStack(BlockRegistry.hiveEgg.get()));
                    output.accept(new ItemStack(BlockRegistry.karosAltar.get()));
                    output.accept(new ItemStack(BlockRegistry.lunicAltar.get()));
                    output.accept(new ItemStack(BlockRegistry.quadroticAltar.get()));
                    output.accept(new ItemStack(BlockRegistry.raglokAltar.get()));
                    output.accept(new ItemStack(BlockRegistry.wreckAltar.get()));
                    output.accept(new ItemStack(BlockRegistry.acidBlock.get()));
                    output.accept(new ItemStack(BlockRegistry.bacterialAcid.get()));
                    output.accept(new ItemStack(BlockRegistry.lunicAcid.get()));
                }));
    }
}