package divinerpg.loot_modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.*;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.*;
import org.jetbrains.annotations.NotNull;

public class SpawnBonusChestModifier extends LootModifier {
    public static final MapCodec<SpawnBonusChestModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).apply(builder, SpawnBonusChestModifier::new));
    protected SpawnBonusChestModifier(LootItemCondition[] conditionsIn) {super(conditionsIn);}
    @Override @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= .2){
            ItemStack toAdd = new ItemStack(BlockRegistry.divineLog.asItem(), 1 + context.getRandom().nextInt(3));
            generatedLoot.add(toAdd);
        } if(context.getRandom().nextFloat() <= .1){
            ItemStack toAdd = new ItemStack(ItemRegistry.tomato.get(), 1 + context.getRandom().nextInt(3));
            generatedLoot.add(toAdd);
        } if(context.getRandom().nextFloat() <= .4){
            ItemStack toAdd = new ItemStack(ItemRegistry.chicken_dinner.get(), 1);
            generatedLoot.add(toAdd);
        } return generatedLoot;
    }
    @Override public MapCodec<? extends IGlobalLootModifier> codec() {return CODEC;}
}