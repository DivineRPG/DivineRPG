package divinerpg.util;

import divinerpg.DivineRPG;
import divinerpg.items.base.*;
import divinerpg.items.vanilla.ItemArmorPouch;
import divinerpg.items.vethea.ItemVetheanDisk;
import divinerpg.registries.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.*;

public class DivineTab {
    public static final ResourceLocation TOOLS = new ResourceLocation(DivineRPG.MODID, "tools");
    public static final ResourceLocation BLOCKS = new ResourceLocation(DivineRPG.MODID, "blocks");
    public static final ResourceLocation TAB = new ResourceLocation(DivineRPG.MODID, "misc");

    public static void registerTabs(CreativeModeTabEvent.Register event){
        event.registerCreativeModeTab(TOOLS, builder -> builder.title(Component.translatable("itemGroup.divinerpg.tools")).icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_blade")))).displayItems((flags, output, isOp) -> {
            for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
                if(item.get() instanceof DivineShield || item.get() instanceof ItemDivineArmor || item.get() instanceof ItemModAxe || item.get() instanceof ItemModBow || item.get() instanceof ItemModHoe || item.get() instanceof ItemModPickaxe || item.get() instanceof ItemModRanged || item.get() instanceof ItemModShotgun || item.get() instanceof ItemModShovel || item.get() instanceof ItemModSword || item.get() instanceof ItemModThrowable || item.get() instanceof ItemShickaxe || item.get() instanceof ItemArmorPouch || item.get() instanceof ItemVetheanDisk) {
                    output.accept(item.get());
                }
            }
        }));
        event.registerCreativeModeTab(BLOCKS, builder -> builder.title(Component.translatable("itemGroup.divinerpg.blocks")).icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_lamp")))).displayItems((flags, output, isOp) -> {
            for(RegistryObject<Item> item : BlockRegistry.BLOCK_ITEMS.getEntries()){
                if(!item.getId().toLanguageKey().contains("plant")){
                    output.accept(item.get());
                }
            }
        }));

        event.registerCreativeModeTab(TAB, builder -> builder.title(Component.translatable("itemGroup.divinerpg.misc")).icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_shards")))).withSearchBar().displayItems((flags, output, isOp) -> {
            for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
                if(item.get() instanceof DivineShield || item.get() instanceof ItemDivineArmor || item.get() instanceof ItemModAxe || item.get() instanceof ItemModBow || item.get() instanceof ItemModHoe || item.get() instanceof ItemModPickaxe || item.get() instanceof ItemModRanged || item.get() instanceof ItemModShotgun || item.get() instanceof ItemModShovel || item.get() instanceof ItemModSword || item.get() instanceof ItemModThrowable || item.get() instanceof ItemShickaxe || item.get() instanceof ItemArmorPouch || item.get() instanceof ItemVetheanDisk) {
                }else{
                    output.accept(item.get());
                }
            }
        }));



    }
}
