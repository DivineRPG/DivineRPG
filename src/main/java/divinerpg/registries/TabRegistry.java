package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class TabRegistry {
    public CreativeModeTab blocks = new CreativeModeTab(DivineRPG.MODID + "_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_lamp")));
        }
    };
    public CreativeModeTab ranged = new CreativeModeTab(DivineRPG.MODID + "_ranged_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vile_storm")));
        }
    };
    public CreativeModeTab melee = new CreativeModeTab(DivineRPG.MODID + "_melee_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquaton")));
        }
    };
    public CreativeModeTab tools = new CreativeModeTab(DivineRPG.MODID + "_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_shickaxe")));
        }
    };
    public CreativeModeTab materials = new CreativeModeTab(DivineRPG.MODID + "_materials") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_ingot")));
        }
    };
    public CreativeModeTab armor = new CreativeModeTab(DivineRPG.MODID + "_armor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_helmet")));
        }
    };
    public CreativeModeTab spawners = new CreativeModeTab(DivineRPG.MODID + "_spawners") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "call_of_the_watcher")));
        }
    };
    public CreativeModeTab utilities = new CreativeModeTab(DivineRPG.MODID + "_utility") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snow_globe")));
        }
    };
    public CreativeModeTab food = new CreativeModeTab(DivineRPG.MODID + "_food_and_agriculture") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bacon")));
        }
    };
    public CreativeModeTab vethea = new CreativeModeTab(DivineRPG.MODID + "_vethea") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_cake")));
        }
    };

    public void init() {

    }
}
