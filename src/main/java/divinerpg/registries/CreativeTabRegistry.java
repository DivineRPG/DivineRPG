package divinerpg.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.*;

import java.util.ArrayList;

import static divinerpg.DivineRPG.MODID;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("blocks", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.blocks")).icon(() -> new ItemStack(BlockRegistry.edenLamp.get())).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS = CREATIVE_MODE_TABS.register("tools", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.tools")).icon(() -> new ItemStack(ItemRegistry.halite_blade.get())).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MISC = CREATIVE_MODE_TABS.register("misc", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.divinerpg.misc")).icon(() -> new ItemStack(ItemRegistry.divine_shards.get())).build());

    public static final ArrayList<DeferredItem<? extends Item>> tools = new ArrayList<>(), misc = new ArrayList<>();
    public static final ArrayList<DeferredBlock<? extends Block>> blocks = new ArrayList<>();
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == BLOCKS.get()) for(DeferredBlock<? extends Block> block : blocks) {
            Item item = block.asItem();
            if(item != Items.AIR) event.accept(item.getDefaultInstance());
        } else if(event.getTab() == TOOLS.get()) for(DeferredItem<? extends Item> item : tools) event.accept(item.get().getDefaultInstance());
        else if(event.getTab() == MISC.get()) for(DeferredItem<? extends Item> item : misc) event.accept(item.get().getDefaultInstance());
    }
}