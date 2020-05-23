package divinerpg.registry;

import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict {
    public static void init() {
        OreDictionary.registerOre("logWood", BlockRegistry.edenLog);
        OreDictionary.registerOre("logWood", BlockRegistry.wildwoodLog);
        OreDictionary.registerOre("logWood", BlockRegistry.apalachiaLog);
        OreDictionary.registerOre("logWood", BlockRegistry.skythernLog);
        OreDictionary.registerOre("logWood", BlockRegistry.mortumLog);
        OreDictionary.registerOre("logWood", BlockRegistry.divineLog);
        OreDictionary.registerOre("logWood", BlockRegistry.eucalyptusLog);
        OreDictionary.registerOre("logWood", BlockRegistry.frozenLog);

        OreDictionary.registerOre("stone", BlockRegistry.divineRock);
        OreDictionary.registerOre("stone", BlockRegistry.frozenStone);
        OreDictionary.registerOre("stone", BlockRegistry.twilightStone);
        OreDictionary.registerOre("stone", BlockRegistry.milkStone);

        OreDictionary.registerOre("cobblestone", BlockRegistry.coalstone);
        OreDictionary.registerOre("cobblestone", BlockRegistry.icyStone);

        OreDictionary.registerOre("blockRupee", BlockRegistry.rupeeBlock);
        OreDictionary.registerOre("ingotRupee", ModItems.rupeeIngot);
        OreDictionary.registerOre("blockArlemite", BlockRegistry.arlemiteBlock);
        OreDictionary.registerOre("ingotArlemite", ModItems.arlemiteIngot);
        OreDictionary.registerOre("blockRealmite", BlockRegistry.realmiteBlock);
        OreDictionary.registerOre("ingotRealmite", ModItems.realmiteIngot);
        OreDictionary.registerOre("blockBloodgem", BlockRegistry.bloodgemBlock);
        OreDictionary.registerOre("gemBlood", ModItems.bloodgem);
        OreDictionary.registerOre("blockEden", BlockRegistry.edenBlock);
        OreDictionary.registerOre("blockWildwood", BlockRegistry.wildwoodBlock);
        OreDictionary.registerOre("blockApalachia", BlockRegistry.apalachiaBlock);
        OreDictionary.registerOre("blockSkythern", BlockRegistry.skythernBlock);
        OreDictionary.registerOre("blockMortum", BlockRegistry.mortumBlock);
        OreDictionary.registerOre("blockNetherite", BlockRegistry.netheriteBlock);
        OreDictionary.registerOre("ingotNetherite", ModItems.netheriteIngot);
        OreDictionary.registerOre("ingotAquatic", ModItems.aquaticIngot);

        OreDictionary.registerOre("torch", BlockRegistry.aquaTorch);
        OreDictionary.registerOre("torch", BlockRegistry.skeletonTorch);

        OreDictionary.registerOre("doorSteel", ModItems.steelDoor);
        OreDictionary.registerOre("door", ModItems.steelDoor);
        OreDictionary.registerOre("door", ModItems.ancientBrickDoor);
        OreDictionary.registerOre("door", ModItems.degradedBrickDoor);
        OreDictionary.registerOre("door", ModItems.soulSludgeDoor);
        OreDictionary.registerOre("door", ModItems.soulStoneDoor);

        OreDictionary.registerOre("treeLeaves", BlockRegistry.apalachiaLeaves);
        OreDictionary.registerOre("treeLeaves", BlockRegistry.brittleLeaves);
        OreDictionary.registerOre("treeLeaves", BlockRegistry.divineLeaves);
        OreDictionary.registerOre("treeLeaves", BlockRegistry.edenLeaves);
        OreDictionary.registerOre("treeLeaves", BlockRegistry.mortumLeaves);
        OreDictionary.registerOre("treeLeaves", BlockRegistry.skythernLeaves);
        OreDictionary.registerOre("treeLeaves", BlockRegistry.wildwoodLeaves);

        OreDictionary.registerOre("vine", BlockRegistry.wildwoodVine);
        OreDictionary.registerOre("vine", BlockRegistry.weedwoodVine);
        OreDictionary.registerOre("vine", BlockRegistry.blossomedWeedwoodVine);

        OreDictionary.registerOre("treeSapling", BlockRegistry.divineSapling);
        OreDictionary.registerOre("treeSapling", BlockRegistry.edenSapling);
        OreDictionary.registerOre("treeSapling", BlockRegistry.apalachiaSapling);
        OreDictionary.registerOre("treeSapling", BlockRegistry.skythernSapling);
        OreDictionary.registerOre("treeSapling", BlockRegistry.mortumSapling);
        OreDictionary.registerOre("treeSapling", BlockRegistry.wildwoodSapling);
        OreDictionary.registerOre("treeSapling", BlockRegistry.frozenSapling);

        OreDictionary.registerOre("blockGlass", BlockRegistry.frostedGlass);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass2);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass3);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass4);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass5);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass6);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass7);
        OreDictionary.registerOre("blockGlass", BlockRegistry.stainedGlass8);

        OreDictionary.registerOre("dirt", BlockRegistry.edenDirt);
        OreDictionary.registerOre("dirt", BlockRegistry.wildwoodDirt);
        OreDictionary.registerOre("dirt", BlockRegistry.apalachiaDirt);
        OreDictionary.registerOre("dirt", BlockRegistry.skythernDirt);
        OreDictionary.registerOre("dirt", BlockRegistry.mortumDirt);
        OreDictionary.registerOre("dirt", BlockRegistry.frozenDirt);
        OreDictionary.registerOre("dirt", BlockRegistry.dreamDirt);

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

        OreDictionary.registerOre("plankWood", BlockRegistry.edenPlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.wildwoodPlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.apalachiaPlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.skythernPlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.mortumPlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.frozenPlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.divinePlanks);
        OreDictionary.registerOre("plankWood", BlockRegistry.eucalyptusPlanks);

        OreDictionary.registerOre("slabWood", BlockRegistry.edenSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.wildwoodSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.apalachiaSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.skythernSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.mortumSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.frozenSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.divineSlab);
        OreDictionary.registerOre("slabWood", BlockRegistry.eucalyptusSlab);

    }
}
