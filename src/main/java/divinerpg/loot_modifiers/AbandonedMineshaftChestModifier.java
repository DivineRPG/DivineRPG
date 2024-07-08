package divinerpg.loot_modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class AbandonedMineshaftChestModifier extends LootModifier {
    public static final MapCodec<AbandonedMineshaftChestModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).apply(builder, AbandonedMineshaftChestModifier::new));

    protected AbandonedMineshaftChestModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() <= 0.5){
            ItemStack toAdd = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "realmite_pickaxe")), 1);
            generatedLoot.add(toAdd);
        }
        if (context.getRandom().nextFloat() <= 0.3){
            ItemStack toAdd = new ItemStack(BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "skeleton_torch")), 4 + context.getRandom().nextInt(4));
            generatedLoot.add(toAdd);
        }
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
