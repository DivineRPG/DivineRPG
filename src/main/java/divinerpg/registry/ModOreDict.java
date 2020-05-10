package divinerpg.registry;

import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict {
    public static void init() {
        OreDictionary.registerOre("logWood", ModBlocks.edenLog);
        OreDictionary.registerOre("logWood", ModBlocks.wildwoodLog);
        OreDictionary.registerOre("logWood", ModBlocks.apalachiaLog);
        OreDictionary.registerOre("logWood", ModBlocks.skythernLog);
        OreDictionary.registerOre("logWood", ModBlocks.mortumLog);
        OreDictionary.registerOre("logWood", ModBlocks.divineLog);
        OreDictionary.registerOre("logWood", ModBlocks.eucalyptusLog);
        OreDictionary.registerOre("logWood", ModBlocks.frozenLog);

        OreDictionary.registerOre("stone", ModBlocks.divineRock);
        OreDictionary.registerOre("stone", ModBlocks.frozenStone);
        OreDictionary.registerOre("stone", ModBlocks.twilightStone);
        OreDictionary.registerOre("stone", ModBlocks.milkStone);

        OreDictionary.registerOre("cobblestone", ModBlocks.coalstone);
        OreDictionary.registerOre("cobblestone", ModBlocks.icyStone);

        OreDictionary.registerOre("blockRupee", ModBlocks.rupeeBlock);
        OreDictionary.registerOre("ingotRupee", ModItems.rupeeIngot);
        OreDictionary.registerOre("blockArlemite", ModBlocks.arlemiteBlock);
        OreDictionary.registerOre("ingotArlemite", ModItems.arlemiteIngot);
        OreDictionary.registerOre("blockRealmite", ModBlocks.realmiteBlock);
        OreDictionary.registerOre("ingotRealmite", ModItems.realmiteIngot);
        OreDictionary.registerOre("blockBloodgem", ModBlocks.bloodgemBlock);
        OreDictionary.registerOre("gemBlood", ModItems.bloodgem);
        OreDictionary.registerOre("blockEden", ModBlocks.edenBlock);
        OreDictionary.registerOre("blockWildwood", ModBlocks.wildwoodBlock);
        OreDictionary.registerOre("blockApalachia", ModBlocks.apalachiaBlock);
        OreDictionary.registerOre("blockSkythern", ModBlocks.skythernBlock);
        OreDictionary.registerOre("blockMortum", ModBlocks.mortumBlock);
        OreDictionary.registerOre("blockNetherite", ModBlocks.netheriteBlock);
        OreDictionary.registerOre("ingotNetherite", ModItems.netheriteIngot);
        OreDictionary.registerOre("ingotAquatic", ModItems.aquaticIngot);

        OreDictionary.registerOre("torch", ModBlocks.aquaTorch);
        OreDictionary.registerOre("torch", ModBlocks.skeletonTorch);

        OreDictionary.registerOre("doorSteel", ModItems.steelDoor);
        OreDictionary.registerOre("door", ModItems.steelDoor);
        OreDictionary.registerOre("door", ModItems.ancientBrickDoor);
        OreDictionary.registerOre("door", ModItems.degradedBrickDoor);
        OreDictionary.registerOre("door", ModItems.soulSludgeDoor);
        OreDictionary.registerOre("door", ModItems.soulStoneDoor);

        OreDictionary.registerOre("treeLeaves", ModBlocks.apalachiaLeaves);
        OreDictionary.registerOre("treeLeaves", ModBlocks.brittleLeaves);
        OreDictionary.registerOre("treeLeaves", ModBlocks.divineLeaves);
        OreDictionary.registerOre("treeLeaves", ModBlocks.edenLeaves);
        OreDictionary.registerOre("treeLeaves", ModBlocks.mortumLeaves);
        OreDictionary.registerOre("treeLeaves", ModBlocks.skythernLeaves);
        OreDictionary.registerOre("treeLeaves", ModBlocks.wildwoodLeaves);

        OreDictionary.registerOre("vine", ModBlocks.wildwoodVine);
        OreDictionary.registerOre("vine", ModBlocks.weedwoodVine);
        OreDictionary.registerOre("vine", ModBlocks.blossomedWeedwoodVine);

        OreDictionary.registerOre("treeSapling", ModBlocks.divineSapling);
        OreDictionary.registerOre("treeSapling", ModBlocks.edenSapling);
        OreDictionary.registerOre("treeSapling", ModBlocks.apalachiaSapling);
        OreDictionary.registerOre("treeSapling", ModBlocks.skythernSapling);
        OreDictionary.registerOre("treeSapling", ModBlocks.mortumSapling);
        OreDictionary.registerOre("treeSapling", ModBlocks.wildwoodSapling);
        OreDictionary.registerOre("treeSapling", ModBlocks.frozenSapling);

        OreDictionary.registerOre("blockGlass", ModBlocks.frostedGlass);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass2);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass3);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass4);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass5);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass6);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass7);
        OreDictionary.registerOre("blockGlass", ModBlocks.stainedGlass8);

        OreDictionary.registerOre("dirt", ModBlocks.edenDirt);
        OreDictionary.registerOre("dirt", ModBlocks.wildwoodDirt);
        OreDictionary.registerOre("dirt", ModBlocks.apalachiaDirt);
        OreDictionary.registerOre("dirt", ModBlocks.skythernDirt);
        OreDictionary.registerOre("dirt", ModBlocks.mortumDirt);
        OreDictionary.registerOre("dirt", ModBlocks.frozenDirt);
        OreDictionary.registerOre("dirt", ModBlocks.dreamDirt);

        OreDictionary.registerOre("chunkEden", ModItems.edenChunk);
        OreDictionary.registerOre("chunkWildwood", ModItems.wildwoodChunk);
        OreDictionary.registerOre("chunkApalachia", ModItems.apalachiaChunk);
        OreDictionary.registerOre("chunkSkythern", ModItems.skythernChunk);
        OreDictionary.registerOre("chunkMortum", ModItems.mortumChunk);
        OreDictionary.registerOre("gemEden", ModItems.edenGem);
        OreDictionary.registerOre("gemWildwood", ModItems.wildwoodGem);
        OreDictionary.registerOre("gemApalachia", ModItems.apalachiaGem);
        OreDictionary.registerOre("gemSkythern", ModItems.skythernGem);
        OreDictionary.registerOre("gemMortum", ModItems.mortumGem);
        OreDictionary.registerOre("fragmentsEden", ModItems.edenFragments);
        OreDictionary.registerOre("fragmentsWildwood", ModItems.wildwoodFragments);
        OreDictionary.registerOre("fragmentsApalachia", ModItems.apalachiaFragments);
        OreDictionary.registerOre("fragmentsSkythern", ModItems.skythernFragments);
        OreDictionary.registerOre("fragmentsMortum", ModItems.mortumFragments);
        OreDictionary.registerOre("soulEden", ModItems.edenSoul);
        OreDictionary.registerOre("soulWildwood", ModItems.wildwoodSoul);
        OreDictionary.registerOre("soulApalachia", ModItems.apalachiaSoul);
        OreDictionary.registerOre("soulSkythern", ModItems.skythernSoul);
        OreDictionary.registerOre("soulMortum", ModItems.mortumSoul);
        OreDictionary.registerOre("dustEden", ModItems.edenDust);
        OreDictionary.registerOre("dustWildwood", ModItems.wildwoodDust);
        OreDictionary.registerOre("dustApalachia", ModItems.apalachiaDust);
        OreDictionary.registerOre("dustSkythern", ModItems.skythernDust);
        OreDictionary.registerOre("dustMortum", ModItems.mortumDust);

        OreDictionary.registerOre("shards", ModItems.corruptedShards);
        OreDictionary.registerOre("shards", ModItems.divineShards);
        OreDictionary.registerOre("shards", ModItems.enderShards);
        OreDictionary.registerOre("shards", ModItems.iceShards);
        OreDictionary.registerOre("shards", ModItems.jungleShards);
        OreDictionary.registerOre("shards", ModItems.moltenShards);
        OreDictionary.registerOre("shards", ModItems.terranShards);

        OreDictionary.registerOre("plankWood", ModBlocks.edenPlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.wildwoodPlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.apalachiaPlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.skythernPlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.mortumPlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.frozenPlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.divinePlanks);
        OreDictionary.registerOre("plankWood", ModBlocks.eucalyptusPlanks);

        OreDictionary.registerOre("slabWood", ModBlocks.edenSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.wildwoodSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.apalachiaSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.skythernSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.mortumSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.frozenSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.divineSlab);
        OreDictionary.registerOre("slabWood", ModBlocks.eucalyptusSlab);

    }
}
