package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.item.*;

public class DRPGTab {
    public ItemGroup blocks = new ItemGroup(DivineRPG.MODID + "_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.divineShickaxe);
        }
    };
    public ItemGroup ranged = new ItemGroup(DivineRPG.MODID + "_ranged_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.vileStorm);
        }
    };
    public ItemGroup melee = new ItemGroup(DivineRPG.MODID + "_melee_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.aquaton);
        }
    };
    public ItemGroup tools = new ItemGroup(DivineRPG.MODID + "_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.rupeeShickaxe);
        }
    };
    public ItemGroup materials = new ItemGroup(DivineRPG.MODID + "_materials") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.rupeeIngot);
        }
    };
    public ItemGroup armor = new ItemGroup(DivineRPG.MODID + "_armor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.divineHelmet);
        }
    };
    public ItemGroup spawners = new ItemGroup(DivineRPG.MODID + "_spawners") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.callOfTheWatcher);
        }
    };
    public ItemGroup utilities = new ItemGroup(DivineRPG.MODID + "_utility") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.snowGlobe);
        }
    };
    public ItemGroup food = new ItemGroup(DivineRPG.MODID + "_food_and_agriculture") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.bacon);
        }
    };
    public ItemGroup vethea = new ItemGroup(DivineRPG.MODID + "_vethea") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.dreamCake);
        }
    };

    public void init() {

    }
}
