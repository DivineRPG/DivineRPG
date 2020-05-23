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
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.bowTemplate, 4, new ItemStack(ModWeapons.teakerBow));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.bowTemplate, 5, new ItemStack(ModWeapons.amthirmisBow));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.bowTemplate, 6, new ItemStack(ModWeapons.darvenBow));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.bowTemplate, 8, new ItemStack(ModWeapons.cermileBow));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.bowTemplate, 11, new ItemStack(ModWeapons.pardimalBow));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.bowTemplate, 13, new ItemStack(ModWeapons.quadroticBow));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.bowTemplate, 18, new ItemStack(ModWeapons.karosBow));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.bowTemplate, 20, new ItemStack(ModWeapons.heliosisBow));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.bowTemplate, 24, new ItemStack(ModWeapons.arksianeBow));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.staffTemplate, 2, new ItemStack(ModWeapons.teakerStaff));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.staffTemplate, 3, new ItemStack(ModWeapons.amthirmisStaff));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.staffTemplate, 4, new ItemStack(ModWeapons.darvenStaff));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.staffTemplate, 6, new ItemStack(ModWeapons.cermileStaff));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.staffTemplate, 8, new ItemStack(ModWeapons.pardimalStaff));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.staffTemplate, 10, new ItemStack(ModWeapons.quadroticStaff));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.staffTemplate, 16, new ItemStack(ModWeapons.karosStaff));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.staffTemplate, 17, new ItemStack(ModWeapons.heliosisStaff));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.staffTemplate, 21, new ItemStack(ModWeapons.arksianeStaff));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.backswordTemplate, 4, new ItemStack(ModWeapons.teakerBacksword));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.backswordTemplate, 5, new ItemStack(ModWeapons.amthirmisBacksword));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.backswordTemplate, 6, new ItemStack(ModWeapons.darvenBacksword));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.backswordTemplate, 8, new ItemStack(ModWeapons.cermileBacksword));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.backswordTemplate, 11, new ItemStack(ModWeapons.pardimalBacksword));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.backswordTemplate, 13, new ItemStack(ModWeapons.quadroticBacksword));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.backswordTemplate, 18, new ItemStack(ModWeapons.karosBacksword));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.backswordTemplate, 20, new ItemStack(ModWeapons.heliosisBacksword));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.backswordTemplate, 24, new ItemStack(ModWeapons.arksianeBacksword));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.clawTemplate, 2, new ItemStack(ModWeapons.teakerClaw));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.clawTemplate, 3, new ItemStack(ModWeapons.amthirmisClaw));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.clawTemplate, 4, new ItemStack(ModWeapons.darvenClaw));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.clawTemplate, 6, new ItemStack(ModWeapons.cermileClaw));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.clawTemplate, 8, new ItemStack(ModWeapons.pardimalClaw));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.clawTemplate, 10, new ItemStack(ModWeapons.quadroticClaw));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.clawTemplate, 16, new ItemStack(ModWeapons.karosClaw));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.clawTemplate, 17, new ItemStack(ModWeapons.heliosisClaw));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.clawTemplate, 21, new ItemStack(ModWeapons.arksianeClaw));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.hammerTemplate, 7, new ItemStack(ModWeapons.teakerHammer));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.hammerTemplate, 9, new ItemStack(ModWeapons.amthirmisHammer));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.hammerTemplate, 11, new ItemStack(ModWeapons.darvenHammer));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.hammerTemplate, 14, new ItemStack(ModWeapons.cermileHammer));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.hammerTemplate, 17, new ItemStack(ModWeapons.pardimalHammer));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.hammerTemplate, 19, new ItemStack(ModWeapons.quadroticHammer));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.hammerTemplate, 22, new ItemStack(ModWeapons.karosHammer));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.hammerTemplate, 27, new ItemStack(ModWeapons.heliosisHammer));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.hammerTemplate, 31, new ItemStack(ModWeapons.arksianeHammer));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.cannonTemplate, 7, new ItemStack(ModWeapons.teakerCannon));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.cannonTemplate, 9, new ItemStack(ModWeapons.amthirmisCannon));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.cannonTemplate, 11, new ItemStack(ModWeapons.darvenCannon));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.cannonTemplate, 14, new ItemStack(ModWeapons.cermileCannon));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.cannonTemplate, 17, new ItemStack(ModWeapons.pardimalCannon));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.cannonTemplate, 19, new ItemStack(ModWeapons.quadroticCannon));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.cannonTemplate, 22, new ItemStack(ModWeapons.karosCannon));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.cannonTemplate, 27, new ItemStack(ModWeapons.heliosisCannon));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.cannonTemplate, 31, new ItemStack(ModWeapons.arksianeCannon));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.diskTemplate, 4, new ItemStack(ModWeapons.teakerDisk));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.diskTemplate, 5, new ItemStack(ModWeapons.amthirmisDisk));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.diskTemplate, 6, new ItemStack(ModWeapons.darvenDisk));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.diskTemplate, 8, new ItemStack(ModWeapons.cermileDisk));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.diskTemplate, 11, new ItemStack(ModWeapons.pardimalDisk));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.diskTemplate, 13, new ItemStack(ModWeapons.quadroticDisk));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.diskTemplate, 18, new ItemStack(ModWeapons.karosDisk));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.diskTemplate, 20, new ItemStack(ModWeapons.heliosisDisk));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.diskTemplate, 24, new ItemStack(ModWeapons.arksianeDisk));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 7, new ItemStack(ModArmor.degradedHelmet));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 8, new ItemStack(ModArmor.degradedHood));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 6, new ItemStack(ModArmor.degradedMask));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 5, new ItemStack(ModArmor.degradedBoots));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 9, new ItemStack(ModArmor.degradedLeggings));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 10, new ItemStack(ModArmor.degradedChestplate));

        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 10, new ItemStack(ModArmor.finishedHelmet));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 11, new ItemStack(ModArmor.finishedHood));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 9, new ItemStack(ModArmor.finishedMask));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 8, new ItemStack(ModArmor.finishedBoots));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 12, new ItemStack(ModArmor.finishedLeggings));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 14, new ItemStack(ModArmor.finishedChestplate));

        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 10, new ItemStack(ModArmor.glisteningHelmet));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 11, new ItemStack(ModArmor.glisteningHood));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 9, new ItemStack(ModArmor.glisteningMask));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 8, new ItemStack(ModArmor.glisteningBoots));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 12, new ItemStack(ModArmor.glisteningLeggings));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 14, new ItemStack(ModArmor.glisteningChestplate));

        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 10, new ItemStack(ModArmor.demonizedHelmet));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 11, new ItemStack(ModArmor.demonizedHood));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 9, new ItemStack(ModArmor.demonizedMask));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 8, new ItemStack(ModArmor.demonizedBoots));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 12, new ItemStack(ModArmor.demonizedLeggings));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 14, new ItemStack(ModArmor.demonizedChestplate));

        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 10, new ItemStack(ModArmor.tormentedHelmet));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 11, new ItemStack(ModArmor.tormentedHood));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 9, new ItemStack(ModArmor.tormentedMask));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 8, new ItemStack(ModArmor.tormentedBoots));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 12, new ItemStack(ModArmor.tormentedLeggings));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 14, new ItemStack(ModArmor.tormentedChestplate));
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