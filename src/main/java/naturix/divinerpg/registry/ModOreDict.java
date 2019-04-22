package naturix.divinerpg.registry;

import naturix.divinerpg.objects.blocks.BlockModPlank;
import naturix.divinerpg.objects.blocks.BlockModSlab;
import naturix.divinerpg.objects.blocks.BlockModStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDict {
	public static void init() {
		OreDictionary.registerOre("logWood", ModBlocks.edenLogs);
		OreDictionary.registerOre("logWood", ModBlocks.wildwoodLogs);
		OreDictionary.registerOre("logWood", ModBlocks.apalachiaLogs);
		OreDictionary.registerOre("logWood", ModBlocks.skythernLogs);
		OreDictionary.registerOre("logWood", ModBlocks.mortumLogs);
		OreDictionary.registerOre("logWood", ModBlocks.divineLogs);
		OreDictionary.registerOre("logWood", ModBlocks.eucalyptusLogs);
		OreDictionary.registerOre("logWood", ModBlocks.frozenLogs);

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

		OreDictionary.registerOre("doorSteel", ModBlocks.steelDoor);

		OreDictionary.registerOre("treeLeaves", ModBlocks.apalachiaLeaves);
		OreDictionary.registerOre("treeLeaves", ModBlocks.brittleLeaves);
		OreDictionary.registerOre("treeLeaves", ModBlocks.divineLeaves);
		OreDictionary.registerOre("treeLeaves", ModBlocks.edenLeaves);
		OreDictionary.registerOre("treeLeaves", ModBlocks.mortumLeaves);
		OreDictionary.registerOre("treeLeaves", ModBlocks.skythernLeaves);
		OreDictionary.registerOre("treeLeaves", ModBlocks.wildwoodLeaves);

		OreDictionary.registerOre("vine", ModBlocks.wildwoodVine);

		OreDictionary.registerOre("treeSapling", ModBlocks.divineSapling);

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
		
		
		
		
		
		for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            if(block instanceof BlockModPlank) {
                OreDictionary.registerOre("plankWood", block);
            }
        }
		for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            if(block instanceof BlockModSlab) {
                OreDictionary.registerOre("slabWood", block);
            }
        }
        
		}
}
