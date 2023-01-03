package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.*;

public class DivineTab {
    public static final ResourceLocation TAB = new ResourceLocation(DivineRPG.MODID, "divinerpg");

    private static ItemStack makeIcon() {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_blade")));
    }


    public static void registerTab(CreativeModeTabEvent.Register event){
        event.registerCreativeModeTab(TAB, builder -> builder.title(Component.translatable("itemGroup.divinerpg")).icon(DivineTab::makeIcon).withSearchBar().displayItems((flags, output, isOp) -> {
            for(RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()){
                output.accept(item.get());
            }

            for(RegistryObject<Item> item : BlockRegistry.BLOCK_ITEMS.getEntries()){
                output.accept(item.get());
            }

        }));

    }
}
