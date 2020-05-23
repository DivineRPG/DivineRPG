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
        addRecipe(ModItems.teakerLump, ModItems.bowTemplate, 4, new ItemStack(ModWeapons.teakerBow));
        addRecipe(ModItems.amthirmisLump, ModItems.bowTemplate, 5, new ItemStack(ModWeapons.amthirmisBow));
        addRecipe(ModItems.darvenLump, ModItems.bowTemplate, 6, new ItemStack(ModWeapons.darvenBow));
        addRecipe(ModItems.cermileLump, ModItems.bowTemplate, 8, new ItemStack(ModWeapons.cermileBow));
        addRecipe(ModItems.pardimalLump, ModItems.bowTemplate, 11, new ItemStack(ModWeapons.pardimalBow));
        addRecipe(ModItems.quadroticLump, ModItems.bowTemplate, 13, new ItemStack(ModWeapons.quadroticBow));
        addRecipe(ModItems.karosLump, ModItems.bowTemplate, 18, new ItemStack(ModWeapons.karosBow));
        addRecipe(ModItems.heliosisLump, ModItems.bowTemplate, 20, new ItemStack(ModWeapons.heliosisBow));
        addRecipe(ModItems.arksianeLump, ModItems.bowTemplate, 24, new ItemStack(ModWeapons.arksianeBow));

        addRecipe(ModItems.teakerLump, ModItems.staffTemplate, 2, new ItemStack(ModWeapons.teakerStaff));
        addRecipe(ModItems.amthirmisLump, ModItems.staffTemplate, 3, new ItemStack(ModWeapons.amthirmisStaff));
        addRecipe(ModItems.darvenLump, ModItems.staffTemplate, 4, new ItemStack(ModWeapons.darvenStaff));
        addRecipe(ModItems.cermileLump, ModItems.staffTemplate, 6, new ItemStack(ModWeapons.cermileStaff));
        addRecipe(ModItems.pardimalLump, ModItems.staffTemplate, 8, new ItemStack(ModWeapons.pardimalStaff));
        addRecipe(ModItems.quadroticLump, ModItems.staffTemplate, 10, new ItemStack(ModWeapons.quadroticStaff));
        addRecipe(ModItems.karosLump, ModItems.staffTemplate, 16, new ItemStack(ModWeapons.karosStaff));
        addRecipe(ModItems.heliosisLump, ModItems.staffTemplate, 17, new ItemStack(ModWeapons.heliosisStaff));
        addRecipe(ModItems.arksianeLump, ModItems.staffTemplate, 21, new ItemStack(ModWeapons.arksianeStaff));

        addRecipe(ModItems.teakerLump, ModItems.backswordTemplate, 4, new ItemStack(ModWeapons.teakerBacksword));
        addRecipe(ModItems.amthirmisLump, ModItems.backswordTemplate, 5, new ItemStack(ModWeapons.amthirmisBacksword));
        addRecipe(ModItems.darvenLump, ModItems.backswordTemplate, 6, new ItemStack(ModWeapons.darvenBacksword));
        addRecipe(ModItems.cermileLump, ModItems.backswordTemplate, 8, new ItemStack(ModWeapons.cermileBacksword));
        addRecipe(ModItems.pardimalLump, ModItems.backswordTemplate, 11, new ItemStack(ModWeapons.pardimalBacksword));
        addRecipe(ModItems.quadroticLump, ModItems.backswordTemplate, 13, new ItemStack(ModWeapons.quadroticBacksword));
        addRecipe(ModItems.karosLump, ModItems.backswordTemplate, 18, new ItemStack(ModWeapons.karosBacksword));
        addRecipe(ModItems.heliosisLump, ModItems.backswordTemplate, 20, new ItemStack(ModWeapons.heliosisBacksword));
        addRecipe(ModItems.arksianeLump, ModItems.backswordTemplate, 24, new ItemStack(ModWeapons.arksianeBacksword));

        addRecipe(ModItems.teakerLump, ModItems.clawTemplate, 2, new ItemStack(ModWeapons.teakerClaw));
        addRecipe(ModItems.amthirmisLump, ModItems.clawTemplate, 3, new ItemStack(ModWeapons.amthirmisClaw));
        addRecipe(ModItems.darvenLump, ModItems.clawTemplate, 4, new ItemStack(ModWeapons.darvenClaw));
        addRecipe(ModItems.cermileLump, ModItems.clawTemplate, 6, new ItemStack(ModWeapons.cermileClaw));
        addRecipe(ModItems.pardimalLump, ModItems.clawTemplate, 8, new ItemStack(ModWeapons.pardimalClaw));
        addRecipe(ModItems.quadroticLump, ModItems.clawTemplate, 10, new ItemStack(ModWeapons.quadroticClaw));
        addRecipe(ModItems.karosLump, ModItems.clawTemplate, 16, new ItemStack(ModWeapons.karosClaw));
        addRecipe(ModItems.heliosisLump, ModItems.clawTemplate, 17, new ItemStack(ModWeapons.heliosisClaw));
        addRecipe(ModItems.arksianeLump, ModItems.clawTemplate, 21, new ItemStack(ModWeapons.arksianeClaw));

        addRecipe(ModItems.teakerLump, ModItems.hammerTemplate, 7, new ItemStack(ModWeapons.teakerHammer));
        addRecipe(ModItems.amthirmisLump, ModItems.hammerTemplate, 9, new ItemStack(ModWeapons.amthirmisHammer));
        addRecipe(ModItems.darvenLump, ModItems.hammerTemplate, 11, new ItemStack(ModWeapons.darvenHammer));
        addRecipe(ModItems.cermileLump, ModItems.hammerTemplate, 14, new ItemStack(ModWeapons.cermileHammer));
        addRecipe(ModItems.pardimalLump, ModItems.hammerTemplate, 17, new ItemStack(ModWeapons.pardimalHammer));
        addRecipe(ModItems.quadroticLump, ModItems.hammerTemplate, 19, new ItemStack(ModWeapons.quadroticHammer));
        addRecipe(ModItems.karosLump, ModItems.hammerTemplate, 22, new ItemStack(ModWeapons.karosHammer));
        addRecipe(ModItems.heliosisLump, ModItems.hammerTemplate, 27, new ItemStack(ModWeapons.heliosisHammer));
        addRecipe(ModItems.arksianeLump, ModItems.hammerTemplate, 31, new ItemStack(ModWeapons.arksianeHammer));

        addRecipe(ModItems.teakerLump, ModItems.cannonTemplate, 7, new ItemStack(ModWeapons.teakerCannon));
        addRecipe(ModItems.amthirmisLump, ModItems.cannonTemplate, 9, new ItemStack(ModWeapons.amthirmisCannon));
        addRecipe(ModItems.darvenLump, ModItems.cannonTemplate, 11, new ItemStack(ModWeapons.darvenCannon));
        addRecipe(ModItems.cermileLump, ModItems.cannonTemplate, 14, new ItemStack(ModWeapons.cermileCannon));
        addRecipe(ModItems.pardimalLump, ModItems.cannonTemplate, 17, new ItemStack(ModWeapons.pardimalCannon));
        addRecipe(ModItems.quadroticLump, ModItems.cannonTemplate, 19, new ItemStack(ModWeapons.quadroticCannon));
        addRecipe(ModItems.karosLump, ModItems.cannonTemplate, 22, new ItemStack(ModWeapons.karosCannon));
        addRecipe(ModItems.heliosisLump, ModItems.cannonTemplate, 27, new ItemStack(ModWeapons.heliosisCannon));
        addRecipe(ModItems.arksianeLump, ModItems.cannonTemplate, 31, new ItemStack(ModWeapons.arksianeCannon));

        addRecipe(ModItems.teakerLump, ModItems.diskTemplate, 4, new ItemStack(ModWeapons.teakerDisk));
        addRecipe(ModItems.amthirmisLump, ModItems.diskTemplate, 5, new ItemStack(ModWeapons.amthirmisDisk));
        addRecipe(ModItems.darvenLump, ModItems.diskTemplate, 6, new ItemStack(ModWeapons.darvenDisk));
        addRecipe(ModItems.cermileLump, ModItems.diskTemplate, 8, new ItemStack(ModWeapons.cermileDisk));
        addRecipe(ModItems.pardimalLump, ModItems.diskTemplate, 11, new ItemStack(ModWeapons.pardimalDisk));
        addRecipe(ModItems.quadroticLump, ModItems.diskTemplate, 13, new ItemStack(ModWeapons.quadroticDisk));
        addRecipe(ModItems.karosLump, ModItems.diskTemplate, 18, new ItemStack(ModWeapons.karosDisk));
        addRecipe(ModItems.heliosisLump, ModItems.diskTemplate, 20, new ItemStack(ModWeapons.heliosisDisk));
        addRecipe(ModItems.arksianeLump, ModItems.diskTemplate, 24, new ItemStack(ModWeapons.arksianeDisk));

        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 7, new ItemStack(ModArmor.degradedHelmet));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 8, new ItemStack(ModArmor.degradedHood));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 6, new ItemStack(ModArmor.degradedMask));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 5, new ItemStack(ModArmor.degradedBoots));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 9, new ItemStack(ModArmor.degradedLeggings));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 10, new ItemStack(ModArmor.degradedChestplate));

        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 10, new ItemStack(ModArmor.finishedHelmet));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 11, new ItemStack(ModArmor.finishedHood));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 9, new ItemStack(ModArmor.finishedMask));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 8, new ItemStack(ModArmor.finishedBoots));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 12, new ItemStack(ModArmor.finishedLeggings));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 14, new ItemStack(ModArmor.finishedChestplate));

        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 10, new ItemStack(ModArmor.glisteningHelmet));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 11, new ItemStack(ModArmor.glisteningHood));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 9, new ItemStack(ModArmor.glisteningMask));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 8, new ItemStack(ModArmor.glisteningBoots));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 12, new ItemStack(ModArmor.glisteningLeggings));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 14, new ItemStack(ModArmor.glisteningChestplate));

        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 10, new ItemStack(ModArmor.demonizedHelmet));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 11, new ItemStack(ModArmor.demonizedHood));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 9, new ItemStack(ModArmor.demonizedMask));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 8, new ItemStack(ModArmor.demonizedBoots));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 12, new ItemStack(ModArmor.demonizedLeggings));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 14, new ItemStack(ModArmor.demonizedChestplate));

        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 10, new ItemStack(ModArmor.tormentedHelmet));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 11, new ItemStack(ModArmor.tormentedHood));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 9, new ItemStack(ModArmor.tormentedMask));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 8, new ItemStack(ModArmor.tormentedBoots));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 12, new ItemStack(ModArmor.tormentedLeggings));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 14, new ItemStack(ModArmor.tormentedChestplate));
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