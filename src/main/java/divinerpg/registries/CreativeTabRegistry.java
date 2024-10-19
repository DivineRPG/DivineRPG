package divinerpg.registries;

import divinerpg.items.arcana.*;
import divinerpg.items.base.*;
import divinerpg.items.vanilla.ItemArmorPouch;
import divinerpg.items.vethea.ItemNightmareBed;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static divinerpg.DivineRPG.MODID;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.blocks")).icon(() -> new ItemStack(BlockRegistry.edenLamp.get())).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS = CREATIVE_MODE_TABS.register("tools", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.tools")).icon(() -> new ItemStack(ItemRegistry.halite_blade.get())).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MISC = CREATIVE_MODE_TABS.register("misc", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.misc")).icon(() -> new ItemStack(ItemRegistry.divine_shards.get())).build());

    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == BLOCKS.get()) {
            for(DeferredHolder<Item, ?> item : BlockRegistry.BLOCK_ITEMS.getEntries()) {
                if(!item.getId().toLanguageKey().contains("plant") || item.getId().toLanguageKey().contains("eye_plant"))
                    event.accept(item.get());
            } for(DeferredHolder<Item, ?> item : ItemRegistry.ITEMS.getEntries()) {
                if(item.get() instanceof ItemNightmareBed || item.get() instanceof StandingAndWallBlockItem)
                    event.accept(item.get());
            }
        } if(event.getTab() == TOOLS.get()) {
            for(DeferredHolder<Item, ?> item : ItemRegistry.ITEMS.getEntries()) {
                if(item.get() instanceof ItemMeriksMissile || item.getId().toLanguageKey().contains("bullet") || item.getId().toLanguageKey().contains("bucket") || item.getId().toLanguageKey().contains("serenade") || item.get() instanceof ItemEnderScepter || item.get() instanceof ItemDivineAccumulator || item.get() instanceof ItemGhostbane || item.get() instanceof ItemStaffEnrichment || item.getId().toLanguageKey().contains("arrow") || item.get() instanceof DivineShield || item.get() instanceof ItemDivineArmor || item.get() instanceof ItemModAxe || item.get() instanceof ItemModBow || item.get() instanceof ItemModHoe || item.get() instanceof ItemModPickaxe || item.get() instanceof ItemModRanged || item.get() instanceof ItemModShovel || item.get() instanceof ItemModSword || item.get() instanceof ItemShickaxe || item.get() instanceof ItemArmorPouch) {
                    event.accept(item.get());
                }
            }
        } if(event.getTab() == MISC.get()) {
            for(DeferredHolder<Item, ?> item : ItemRegistry.ITEMS.getEntries()) {
                if(!(item.get() instanceof ItemMeriksMissile || item.getId().toLanguageKey().contains("bullet") || item.getId().toLanguageKey().contains("bucket") || item.getId().toLanguageKey().contains("serenade") || item.get() instanceof ItemEnderScepter || item.get() instanceof ItemDivineAccumulator || item.get() instanceof ItemGhostbane || item.get() instanceof ItemStaffEnrichment || item.getId().toLanguageKey().contains("arrow") || item.get() instanceof ItemNightmareBed || item.get() instanceof StandingAndWallBlockItem || item.get() instanceof DivineShield || item.get() instanceof ItemDivineArmor || item.get() instanceof ItemModAxe || item.get() instanceof ItemModBow || item.get() instanceof ItemModHoe || item.get() instanceof ItemModPickaxe || item.get() instanceof ItemModRanged || item.get() instanceof ItemModShovel || item.get() instanceof ItemModSword || item.get() instanceof ItemShickaxe || item.get() instanceof ItemArmorPouch)) {
                    event.accept(item.get());
                }
            }
        }
    }
}