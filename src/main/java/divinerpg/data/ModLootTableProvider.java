package divinerpg.data;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider() {
        super(Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(ModChestLootSubProvider::new, LootContextParamSets.CHEST), new SubProviderEntry(ModEntityLootSubProvider::new, LootContextParamSets.ENTITY)));
    }
}