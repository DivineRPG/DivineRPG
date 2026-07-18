package net.divinerpg.data;

import net.divinerpg.registries.BlockRegistry;
import net.divinerpg.registries.DivineRegistries;
import net.divinerpg.registries.ItemRegistry;
import net.divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static net.divinerpg.DivineRPG.MODID;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
            tag(commonTag("ingots/arlemite")).add(ItemRegistry.arlemite_ingot.getKey());
            tag(commonTag("ingots/rupee")).add(ItemRegistry.rupee_ingot.getKey());
            tag(commonTag("ingots/aquatic")).add(ItemRegistry.aquatic_ingot.getKey());
            tag(commonTag("ingots/hellstone")).add(ItemRegistry.hellstone_ingot.getKey());
            tag(commonTag("ingots/oxdrite")).add(ItemRegistry.oxdrite_ingot.getKey());
            tag(commonTag("ingots/realmite")).add(ItemRegistry.realmite_ingot.getKey());
            tag(commonTag("ingots/torridite")).add(ItemRegistry.torridite_ingot.getKey());
            tag(commonTag("ingots/hellstone")).add(ItemRegistry.hellstone_ingot.getKey());
            tag(commonTag("ingots")).addTags(commonTag("ingots/arlemite"), commonTag("ingots/rupee"), commonTag("ingots/aquatic"), commonTag("ingots/hellstone"), commonTag("ingots/oxdrite"), commonTag("ingots/realmite"), commonTag("ingots/torridite"), commonTag("ingots/hellstone"));

            tag(commonTag("storage_blocks/realmite")).add(BlockRegistry.realmiteBlock.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("storage_blocks/arlemite")).add(BlockRegistry.arlemiteBlock.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("storage_blocks/rupee")).add(BlockRegistry.rupeeBlock.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("storage_blocks/bloodgem")).add(BlockRegistry.bloodgemBlock.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("storage_blocks/torridite")).add(BlockRegistry.torriditeBlock.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("storage_blocks/olivine")).add(BlockRegistry.olivineBlock.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("storage_blocks")).addTags(commonTag("storage_blocks/realmite"), commonTag("storage_blocks/arlemite"), commonTag("storage_blocks/rupee"), commonTag("storage_blocks/bloodgem"), commonTag("storage_blocks/torridite"), commonTag("storage_blocks/olivine"));

            tag(commonTag("raw_materials/arlemite")).add(ItemRegistry.raw_arlemite.getKey());
            tag(commonTag("raw_materials/rupee")).add(ItemRegistry.raw_rupee.getKey());
            tag(commonTag("raw_materials/realmite")).add(ItemRegistry.raw_realmite.getKey());
            tag(commonTag("raw_materials/torridite")).add(ItemRegistry.raw_torridite.getKey());
            tag(commonTag("raw_materials/oxdrite")).add(ItemRegistry.raw_oxdrite.getKey());
            tag(commonTag("raw_materials")).addTags(commonTag("raw_materials/arlemite"), commonTag("raw_materials/rupee"), commonTag("raw_materials/realmite"), commonTag("raw_materials/torridite"), commonTag("raw_materials/oxdrite"));

            tag(commonTag("dust/arlemite")).add(ItemRegistry.arlemite_dust.getKey());
            tag(commonTag("dust/rupee")).add(ItemRegistry.rupee_dust.getKey());
            tag(commonTag("dust/realmite")).add(ItemRegistry.realmite_dust.getKey());
            tag(commonTag("dust/torridite")).add(ItemRegistry.torridite_dust.getKey());
            tag(commonTag("dust/oxdrite")).add(ItemRegistry.oxdrite_dust.getKey());
            tag(TagRegistry.DUST_SHADOW).add(ItemRegistry.shadow_dust.getKey());
            tag(commonTag("dust")).addTags(commonTag("dust/arlemite"), commonTag("dust/rupee"), commonTag("dust/realmite"), commonTag("dust/torridite"), commonTag("dust/oxdrite"), TagRegistry.DUST_SHADOW);


            tag(commonTag("ores/arlemite")).add(BlockRegistry.arlemiteOre.asItem().builtInRegistryHolder().getKey(), BlockRegistry.arlemiteOreDeepslate.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("ores/rupee")).add(BlockRegistry.rupeeOre.asItem().builtInRegistryHolder().getKey(), BlockRegistry.rupeeOreDeepslate.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("ores/realmite")).add(BlockRegistry.realmiteOre.asItem().builtInRegistryHolder().getKey(), BlockRegistry.realmiteOreDeepslate.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("ores/torridite")).add(BlockRegistry.torriditeOre.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("ores/bloodgem")).add(BlockRegistry.bloodgemOre.asItem().builtInRegistryHolder().getKey());
            tag(commonTag("ores")).addTags(commonTag("ores/arlemite"), commonTag("ores/rupee"), commonTag("ores/bloodgem"), commonTag("ores/realmite"), commonTag("ores/torridite"));

            tag(commonTag("foods")).addTags(commonTag("foods/white_mushroom"));
            tag(commonTag("foods/white_mushroom")).add(ItemRegistry.white_mushroom.getKey());

            tag(TagRegistry.REPAIR_REALMITE).add(ItemRegistry.realmite_ingot.getKey());
            tag(TagRegistry.REPAIR_ARLEMITE).add(ItemRegistry.arlemite_ingot.getKey());
            tag(TagRegistry.REPAIR_RUPEE).add(ItemRegistry.rupee_ingot.getKey());
            tag(TagRegistry.REPAIR_ICE).add(ItemRegistry.ice_shards.getKey());
            tag(TagRegistry.REPAIR_ENDER).add(ItemRegistry.ender_shards.getKey());
            tag(TagRegistry.DIVINE_SWORDS).add(ItemRegistry.divine_sword.getKey(), ItemRegistry.red_divine_sword.getKey(), ItemRegistry.yellow_divine_sword.getKey(), ItemRegistry.green_divine_sword.getKey(), ItemRegistry.gray_divine_sword.getKey(), ItemRegistry.blue_divine_sword.getKey());
            tag(TagRegistry.ARMOR_POUCHES).add(ItemRegistry.armor_pouch.getKey(), ItemRegistry.red_armor_pouch.getKey(), ItemRegistry.yellow_armor_pouch.getKey(), ItemRegistry.green_armor_pouch.getKey(), ItemRegistry.gray_armor_pouch.getKey(), ItemRegistry.blue_armor_pouch.getKey());
            tag(TagRegistry.SHADOW_COIN).add(ItemRegistry.shadow_coins.getKey());

            tag(TagRegistry.CHUNK_BEDROCK).add(ItemRegistry.bedrock_chunk.getKey());
            tag(TagRegistry.GEM_SHADOW).add(ItemRegistry.shadow_stone.getKey());
            tag(TagRegistry.GEM_SOULFIRE).add(ItemRegistry.soulfire_stone.getKey());
            tag(TagRegistry.TOOL_MAUL).add(ItemRegistry.aquatic_maul.getKey(), ItemRegistry.aquatooth_maul.getKey(), ItemRegistry.bedrock_maul.getKey(), ItemRegistry.corrupted_maul.getKey(), ItemRegistry.crabclaw_maul.getKey(), ItemRegistry.frozen_maul.getKey(), ItemRegistry.fury_maul.getKey(), ItemRegistry.realmite_maul.getKey(), ItemRegistry.terran_maul.getKey());
            tag(TagRegistry.METAL_SPIKE_BLOCK).add(ItemRegistry.soulfire_stone.getKey()/*placeholder item so i can test the advancement*/);

            tag(ItemTags.WALLS).add(BlockRegistry.cobaltiteWall.asItem().builtInRegistryHolder().key(), BlockRegistry.coalstoneWall.asItem().builtInRegistryHolder().key(), BlockRegistry.arcaniteWall.asItem().builtInRegistryHolder().key());


        for (var entry : DivineRegistries.BLOCKS.getEntries()) {
            Block b = entry.get();
            if (b.asItem() == net.minecraft.world.item.Items.AIR) continue;
            var itemKey = b.asItem().builtInRegistryHolder().key();
            String path = entry.getId().getPath();
            if (path.contains("_planks")) tag(ItemTags.PLANKS).add(itemKey);
            if (path.contains("_log")) tag(ItemTags.LOGS).add(itemKey);
            if (b instanceof FenceBlock) tag(ItemTags.WOODEN_FENCES).add(itemKey);
            if (b instanceof StairBlock) tag(ItemTags.WOODEN_STAIRS).add(itemKey);
            if (b instanceof SlabBlock) tag(ItemTags.WOODEN_SLABS).add(itemKey);
            if (b instanceof DoorBlock) tag(ItemTags.WOODEN_DOORS).add(itemKey);
            if (b instanceof TrapDoorBlock) tag(ItemTags.WOODEN_TRAPDOORS).add(itemKey);
            if (b instanceof ButtonBlock) tag(ItemTags.WOODEN_BUTTONS).add(itemKey);
        }

    }

    private TagKey<Item> commonTag(String name){
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", name));
    }
    private TagKey<Item> minecraftTag(String name){
        return TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace(name));
    }
    private TagKey<Item> customTag(String name){
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name));
    }
}