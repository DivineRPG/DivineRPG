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

public class UnderwaterRuinBigModifier extends LootModifier {
    public static final MapCodec<UnderwaterRuinBigModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).apply(builder, UnderwaterRuinBigModifier::new));
	protected UnderwaterRuinBigModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }
	@Override @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= .4F) generatedLoot.add(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "aquatic_coating_template")), 1));
        return generatedLoot;
    }
    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}