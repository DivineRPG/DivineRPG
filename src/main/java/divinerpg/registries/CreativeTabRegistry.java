package divinerpg.registries;

import divinerpg.items.arcana.*;
import divinerpg.items.base.*;
import divinerpg.items.vanilla.ItemArmorPouch;
import divinerpg.items.vethea.ItemNightmareBed;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import static divinerpg.DivineRPG.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> BLOCKS = TAB.register("blocks", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.blocks")).icon(() -> new ItemStack(BlockRegistry.edenLamp.get())).build());
    public static final RegistryObject<CreativeModeTab> TOOLS = TAB.register("tools", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.tools")).icon(() -> new ItemStack(ItemRegistry.halite_blade.get())).build());
    public static final RegistryObject<CreativeModeTab> MISC = TAB.register("misc", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.misc")).icon(() -> new ItemStack(ItemRegistry.divine_shards.get())).build());
    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == BLOCKS.get()) {
            for(RegistryObject<Item> item : BlockRegistry.BLOCK_ITEMS.getEntries()) {
                if(!item.getId().toLanguageKey().contains("plant") || item.getId().toLanguageKey().contains("eye_plant"))
                    event.accept(item.get());
            } for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
                if(item.get() instanceof ItemNightmareBed || item.get() instanceof StandingAndWallBlockItem)
                    event.accept(item.get());
            }
        } if(event.getTab() == TOOLS.get()) {
            for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
                if(item.get() instanceof ItemMeriksMissile || item.getId().toLanguageKey().contains("bullet") || item.getId().toLanguageKey().contains("bucket") || item.getId().toLanguageKey().contains("serenade") || item.get() instanceof ItemEnderScepter || item.get() instanceof ItemDivineAccumulator || item.get() instanceof ItemGhostbane || item.get() instanceof ItemStaffEnrichment || item.getId().toLanguageKey().contains("arrow") || item.get() instanceof DivineShield || item.get() instanceof ItemDivineArmor || item.get() instanceof ItemModAxe || item.get() instanceof ItemModBow || item.get() instanceof ItemModHoe || item.get() instanceof ItemModPickaxe || item.get() instanceof ItemModRanged || item.get() instanceof ItemModShovel || item.get() instanceof ItemModSword || item.get() instanceof ItemShickaxe || item.get() instanceof ItemArmorPouch) {
                    event.accept(item.get());
                }
            }
        } if(event.getTab() == MISC.get()) {
            for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
                if(!(item.get() instanceof ItemMeriksMissile || item.getId().toLanguageKey().contains("bullet") || item.getId().toLanguageKey().contains("bucket") || item.getId().toLanguageKey().contains("serenade") || item.get() instanceof ItemEnderScepter || item.get() instanceof ItemDivineAccumulator || item.get() instanceof ItemGhostbane || item.get() instanceof ItemStaffEnrichment || item.getId().toLanguageKey().contains("arrow") || item.get() instanceof ItemNightmareBed || item.get() instanceof StandingAndWallBlockItem || item.get() instanceof DivineShield || item.get() instanceof ItemDivineArmor || item.get() instanceof ItemModAxe || item.get() instanceof ItemModBow || item.get() instanceof ItemModHoe || item.get() instanceof ItemModPickaxe || item.get() instanceof ItemModRanged || item.get() instanceof ItemModShovel || item.get() instanceof ItemModSword || item.get() instanceof ItemShickaxe || item.get() instanceof ItemArmorPouch)) {
                    event.accept(item.get());
                }
            }
        }
    }
}