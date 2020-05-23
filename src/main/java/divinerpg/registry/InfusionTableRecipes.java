package divinerpg.registry;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class InfusionTableRecipes {

    public static HashMap<InfusionRecipe, Item> recipes = new HashMap<InfusionRecipe, Item>();
    public static InfusionTableRecipes instance = new InfusionTableRecipes();

    private InfusionTableRecipes() {
        this.addRecipes();
    }

    private void addRecipes() {
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.bowTemplate, 4, new ItemStack(WeaponRegistry.teakerBow));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.bowTemplate, 5, new ItemStack(WeaponRegistry.amthirmisBow));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.bowTemplate, 6, new ItemStack(WeaponRegistry.darvenBow));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.bowTemplate, 8, new ItemStack(WeaponRegistry.cermileBow));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.bowTemplate, 11, new ItemStack(WeaponRegistry.pardimalBow));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.bowTemplate, 13, new ItemStack(WeaponRegistry.quadroticBow));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.bowTemplate, 18, new ItemStack(WeaponRegistry.karosBow));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.bowTemplate, 20, new ItemStack(WeaponRegistry.heliosisBow));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.bowTemplate, 24, new ItemStack(WeaponRegistry.arksianeBow));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.staffTemplate, 2, new ItemStack(WeaponRegistry.teakerStaff));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.staffTemplate, 3, new ItemStack(WeaponRegistry.amthirmisStaff));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.staffTemplate, 4, new ItemStack(WeaponRegistry.darvenStaff));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.staffTemplate, 6, new ItemStack(WeaponRegistry.cermileStaff));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.staffTemplate, 8, new ItemStack(WeaponRegistry.pardimalStaff));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.staffTemplate, 10, new ItemStack(WeaponRegistry.quadroticStaff));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.staffTemplate, 16, new ItemStack(WeaponRegistry.karosStaff));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.staffTemplate, 17, new ItemStack(WeaponRegistry.heliosisStaff));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.staffTemplate, 21, new ItemStack(WeaponRegistry.arksianeStaff));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.backswordTemplate, 4, new ItemStack(WeaponRegistry.teakerBacksword));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.backswordTemplate, 5, new ItemStack(WeaponRegistry.amthirmisBacksword));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.backswordTemplate, 6, new ItemStack(WeaponRegistry.darvenBacksword));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.backswordTemplate, 8, new ItemStack(WeaponRegistry.cermileBacksword));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.backswordTemplate, 11, new ItemStack(WeaponRegistry.pardimalBacksword));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.backswordTemplate, 13, new ItemStack(WeaponRegistry.quadroticBacksword));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.backswordTemplate, 18, new ItemStack(WeaponRegistry.karosBacksword));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.backswordTemplate, 20, new ItemStack(WeaponRegistry.heliosisBacksword));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.backswordTemplate, 24, new ItemStack(WeaponRegistry.arksianeBacksword));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.clawTemplate, 2, new ItemStack(WeaponRegistry.teakerClaw));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.clawTemplate, 3, new ItemStack(WeaponRegistry.amthirmisClaw));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.clawTemplate, 4, new ItemStack(WeaponRegistry.darvenClaw));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.clawTemplate, 6, new ItemStack(WeaponRegistry.cermileClaw));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.clawTemplate, 8, new ItemStack(WeaponRegistry.pardimalClaw));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.clawTemplate, 10, new ItemStack(WeaponRegistry.quadroticClaw));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.clawTemplate, 16, new ItemStack(WeaponRegistry.karosClaw));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.clawTemplate, 17, new ItemStack(WeaponRegistry.heliosisClaw));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.clawTemplate, 21, new ItemStack(WeaponRegistry.arksianeClaw));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.hammerTemplate, 7, new ItemStack(WeaponRegistry.teakerHammer));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.hammerTemplate, 9, new ItemStack(WeaponRegistry.amthirmisHammer));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.hammerTemplate, 11, new ItemStack(WeaponRegistry.darvenHammer));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.hammerTemplate, 14, new ItemStack(WeaponRegistry.cermileHammer));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.hammerTemplate, 17, new ItemStack(WeaponRegistry.pardimalHammer));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.hammerTemplate, 19, new ItemStack(WeaponRegistry.quadroticHammer));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.hammerTemplate, 22, new ItemStack(WeaponRegistry.karosHammer));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.hammerTemplate, 27, new ItemStack(WeaponRegistry.heliosisHammer));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.hammerTemplate, 31, new ItemStack(WeaponRegistry.arksianeHammer));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.cannonTemplate, 7, new ItemStack(WeaponRegistry.teakerCannon));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.cannonTemplate, 9, new ItemStack(WeaponRegistry.amthirmisCannon));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.cannonTemplate, 11, new ItemStack(WeaponRegistry.darvenCannon));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.cannonTemplate, 14, new ItemStack(WeaponRegistry.cermileCannon));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.cannonTemplate, 17, new ItemStack(WeaponRegistry.pardimalCannon));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.cannonTemplate, 19, new ItemStack(WeaponRegistry.quadroticCannon));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.cannonTemplate, 22, new ItemStack(WeaponRegistry.karosCannon));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.cannonTemplate, 27, new ItemStack(WeaponRegistry.heliosisCannon));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.cannonTemplate, 31, new ItemStack(WeaponRegistry.arksianeCannon));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.diskTemplate, 4, new ItemStack(WeaponRegistry.teakerDisk));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.diskTemplate, 5, new ItemStack(WeaponRegistry.amthirmisDisk));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.diskTemplate, 6, new ItemStack(WeaponRegistry.darvenDisk));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.diskTemplate, 8, new ItemStack(WeaponRegistry.cermileDisk));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.diskTemplate, 11, new ItemStack(WeaponRegistry.pardimalDisk));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.diskTemplate, 13, new ItemStack(WeaponRegistry.quadroticDisk));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.diskTemplate, 18, new ItemStack(WeaponRegistry.karosDisk));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.diskTemplate, 20, new ItemStack(WeaponRegistry.heliosisDisk));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.diskTemplate, 24, new ItemStack(WeaponRegistry.arksianeDisk));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 7, new ItemStack(ArmorRegistry.degradedHelmet));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 8, new ItemStack(ArmorRegistry.degradedHood));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 6, new ItemStack(ArmorRegistry.degradedMask));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 5, new ItemStack(ArmorRegistry.degradedBoots));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 9, new ItemStack(ArmorRegistry.degradedLeggings));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 10, new ItemStack(ArmorRegistry.degradedChestplate));

        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 10, new ItemStack(ArmorRegistry.finishedHelmet));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 11, new ItemStack(ArmorRegistry.finishedHood));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 9, new ItemStack(ArmorRegistry.finishedMask));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 8, new ItemStack(ArmorRegistry.finishedBoots));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 12, new ItemStack(ArmorRegistry.finishedLeggings));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 14, new ItemStack(ArmorRegistry.finishedChestplate));

        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 10, new ItemStack(ArmorRegistry.glisteningHelmet));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 11, new ItemStack(ArmorRegistry.glisteningHood));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 9, new ItemStack(ArmorRegistry.glisteningMask));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 8, new ItemStack(ArmorRegistry.glisteningBoots));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 12, new ItemStack(ArmorRegistry.glisteningLeggings));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 14, new ItemStack(ArmorRegistry.glisteningChestplate));

        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 10, new ItemStack(ArmorRegistry.demonizedHelmet));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 11, new ItemStack(ArmorRegistry.demonizedHood));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 9, new ItemStack(ArmorRegistry.demonizedMask));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 8, new ItemStack(ArmorRegistry.demonizedBoots));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 12, new ItemStack(ArmorRegistry.demonizedLeggings));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 14, new ItemStack(ArmorRegistry.demonizedChestplate));

        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 10, new ItemStack(ArmorRegistry.tormentedHelmet));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 11, new ItemStack(ArmorRegistry.tormentedHood));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 9, new ItemStack(ArmorRegistry.tormentedMask));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 8, new ItemStack(ArmorRegistry.tormentedBoots));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 12, new ItemStack(ArmorRegistry.tormentedLeggings));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 14, new ItemStack(ArmorRegistry.tormentedChestplate));
    }

    private void addRecipe(Item lump, Item template, int count, ItemStack res) {
        recipes.put(new InfusionRecipe(lump, template, count), res.getItem());
    }

    public Item getOutput(Item lump, Item template, int count) {
        if(recipes.containsKey(new InfusionRecipe(lump, template, count))) {
            return recipes.get(new InfusionRecipe(lump, template, count));
        }
        else {
            return null;
        }
    }

    private static class InfusionRecipe {
        public final Item template;
        public final Item lump;
        private final int lumpCount;

        public InfusionRecipe(Item lump, Item template, int lumpCount) {
            this.lump = lump;
            this.template = template;
            this.lumpCount = lumpCount;
        }

        @Override
        public int hashCode() {
            return Item.getIdFromItem(template) * 200 + Item.getIdFromItem(lump) + lumpCount;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof InfusionRecipe && ((InfusionRecipe)o).template == this.template && ((InfusionRecipe)o).lump == this.lump && ((InfusionRecipe)o).lumpCount == this.lumpCount;
        }
    }
}