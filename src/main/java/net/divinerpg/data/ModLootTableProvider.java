package net.divinerpg.data;

import net.divinerpg.registries.LootTableRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.RandomSequence;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetComponentsFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static net.divinerpg.DivineRPG.MODID;

public class ModLootTableProvider implements LootTableSubProvider {
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK)), registries);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        //TODO - Patchouli isnt updated yet
//        output.accept(LootTableRegistry.PATCHOULI, LootTable.lootTable()
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1))
//                        .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("patchouli", "guide_book")).get().value())
//                                .apply(SetComponentsFunction.setComponent(DataComponentPatch.builder()
//                                        .set(PatchouliComponents.BOOK.get(), "divinerpg:divine") // Adjust based on your Patchouli mapping
//                                        .build()
//                                ))
//                        )
//                )
//                .apply(RandomSequence.seedForKey(Identifier.fromNamespaceAndPath(MODID, "patchouli")))
//        );
    }
}