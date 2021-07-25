package divinerpg.recipe;

import divinerpg.registries.*;
import net.minecraft.item.*;

import java.util.*;

public final class InfusionTableRecipes {

    public static HashMap<InfusionRecipe, Item> recipes = new HashMap<InfusionRecipe, Item>();
    public static InfusionTableRecipes instance = new InfusionTableRecipes();

    private InfusionTableRecipes() {
        this.addRecipes();
    }

    private void addRecipes() {
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.bowTemplate, 4, new ItemStack(ItemRegistry.teakerBow));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.bowTemplate, 5, new ItemStack(ItemRegistry.amthirmisBow));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.bowTemplate, 6, new ItemStack(ItemRegistry.darvenBow));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.bowTemplate, 8, new ItemStack(ItemRegistry.cermileBow));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.bowTemplate, 11, new ItemStack(ItemRegistry.pardimalBow));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.bowTemplate, 13, new ItemStack(ItemRegistry.quadroticBow));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.bowTemplate, 18, new ItemStack(ItemRegistry.karosBow));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.bowTemplate, 20, new ItemStack(ItemRegistry.heliosisBow));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.bowTemplate, 24, new ItemStack(ItemRegistry.arksianeBow));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.staffTemplate, 2, new ItemStack(ItemRegistry.teakerStaff));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.staffTemplate, 3, new ItemStack(ItemRegistry.amthirmisStaff));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.staffTemplate, 4, new ItemStack(ItemRegistry.darvenStaff));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.staffTemplate, 6, new ItemStack(ItemRegistry.cermileStaff));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.staffTemplate, 8, new ItemStack(ItemRegistry.pardimalStaff));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.staffTemplate, 10, new ItemStack(ItemRegistry.quadroticStaff));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.staffTemplate, 16, new ItemStack(ItemRegistry.karosStaff));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.staffTemplate, 17, new ItemStack(ItemRegistry.heliosisStaff));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.staffTemplate, 21, new ItemStack(ItemRegistry.arksianeStaff));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.backswordTemplate, 4, new ItemStack(ItemRegistry.teakerBacksword));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.backswordTemplate, 5, new ItemStack(ItemRegistry.amthirmisBacksword));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.backswordTemplate, 6, new ItemStack(ItemRegistry.darvenBacksword));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.backswordTemplate, 8, new ItemStack(ItemRegistry.cermileBacksword));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.backswordTemplate, 11, new ItemStack(ItemRegistry.pardimalBacksword));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.backswordTemplate, 13, new ItemStack(ItemRegistry.quadroticBacksword));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.backswordTemplate, 18, new ItemStack(ItemRegistry.karosBacksword));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.backswordTemplate, 20, new ItemStack(ItemRegistry.heliosisBacksword));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.backswordTemplate, 24, new ItemStack(ItemRegistry.arksianeBacksword));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.clawTemplate, 2, new ItemStack(ItemRegistry.teakerClaw));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.clawTemplate, 3, new ItemStack(ItemRegistry.amthirmisClaw));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.clawTemplate, 4, new ItemStack(ItemRegistry.darvenClaw));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.clawTemplate, 6, new ItemStack(ItemRegistry.cermileClaw));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.clawTemplate, 8, new ItemStack(ItemRegistry.pardimalClaw));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.clawTemplate, 10, new ItemStack(ItemRegistry.quadroticClaw));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.clawTemplate, 16, new ItemStack(ItemRegistry.karosClaw));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.clawTemplate, 17, new ItemStack(ItemRegistry.heliosisClaw));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.clawTemplate, 21, new ItemStack(ItemRegistry.arksianeClaw));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.hammerTemplate, 7, new ItemStack(ItemRegistry.teakerHammer));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.hammerTemplate, 9, new ItemStack(ItemRegistry.amthirmisHammer));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.hammerTemplate, 11, new ItemStack(ItemRegistry.darvenHammer));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.hammerTemplate, 14, new ItemStack(ItemRegistry.cermileHammer));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.hammerTemplate, 17, new ItemStack(ItemRegistry.pardimalHammer));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.hammerTemplate, 19, new ItemStack(ItemRegistry.quadroticHammer));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.hammerTemplate, 22, new ItemStack(ItemRegistry.karosHammer));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.hammerTemplate, 27, new ItemStack(ItemRegistry.heliosisHammer));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.hammerTemplate, 31, new ItemStack(ItemRegistry.arksianeHammer));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.cannonTemplate, 7, new ItemStack(ItemRegistry.teakerCannon));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.cannonTemplate, 9, new ItemStack(ItemRegistry.amthirmisCannon));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.cannonTemplate, 11, new ItemStack(ItemRegistry.darvenCannon));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.cannonTemplate, 14, new ItemStack(ItemRegistry.cermileCannon));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.cannonTemplate, 17, new ItemStack(ItemRegistry.pardimalCannon));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.cannonTemplate, 19, new ItemStack(ItemRegistry.quadroticCannon));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.cannonTemplate, 22, new ItemStack(ItemRegistry.karosCannon));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.cannonTemplate, 27, new ItemStack(ItemRegistry.heliosisCannon));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.cannonTemplate, 31, new ItemStack(ItemRegistry.arksianeCannon));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.diskTemplate, 4, new ItemStack(ItemRegistry.teakerDisk));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.diskTemplate, 5, new ItemStack(ItemRegistry.amthirmisDisk));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.diskTemplate, 6, new ItemStack(ItemRegistry.darvenDisk));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.diskTemplate, 8, new ItemStack(ItemRegistry.cermileDisk));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.diskTemplate, 11, new ItemStack(ItemRegistry.pardimalDisk));
        addRecipe(ItemRegistry.quadroticLump, ItemRegistry.diskTemplate, 13, new ItemStack(ItemRegistry.quadroticDisk));
        addRecipe(ItemRegistry.karosLump, ItemRegistry.diskTemplate, 18, new ItemStack(ItemRegistry.karosDisk));
        addRecipe(ItemRegistry.heliosisLump, ItemRegistry.diskTemplate, 20, new ItemStack(ItemRegistry.heliosisDisk));
        addRecipe(ItemRegistry.arksianeLump, ItemRegistry.diskTemplate, 24, new ItemStack(ItemRegistry.arksianeDisk));

        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 7, new ItemStack(ItemRegistry.degradedHelmet));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 8, new ItemStack(ItemRegistry.degradedHood));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 6, new ItemStack(ItemRegistry.degradedMask));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 5, new ItemStack(ItemRegistry.degradedBoots));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 9, new ItemStack(ItemRegistry.degradedLeggings));
        addRecipe(ItemRegistry.teakerLump, ItemRegistry.degradedTemplate, 10, new ItemStack(ItemRegistry.degradedChestplate));

        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 10, new ItemStack(ItemRegistry.finishedHelmet));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 11, new ItemStack(ItemRegistry.finishedHood));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 9, new ItemStack(ItemRegistry.finishedMask));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 8, new ItemStack(ItemRegistry.finishedBoots));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 12, new ItemStack(ItemRegistry.finishedLeggings));
        addRecipe(ItemRegistry.amthirmisLump, ItemRegistry.finishedTemplate, 14, new ItemStack(ItemRegistry.finishedChestplate));

        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 10, new ItemStack(ItemRegistry.glisteningHelmet));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 11, new ItemStack(ItemRegistry.glisteningHood));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 9, new ItemStack(ItemRegistry.glisteningMask));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 8, new ItemStack(ItemRegistry.glisteningBoots));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 12, new ItemStack(ItemRegistry.glisteningLeggings));
        addRecipe(ItemRegistry.darvenLump, ItemRegistry.glisteningTemplate, 14, new ItemStack(ItemRegistry.glisteningChestplate));

        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 10, new ItemStack(ItemRegistry.demonizedHelmet));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 11, new ItemStack(ItemRegistry.demonizedHood));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 9, new ItemStack(ItemRegistry.demonizedMask));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 8, new ItemStack(ItemRegistry.demonizedBoots));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 12, new ItemStack(ItemRegistry.demonizedLeggings));
        addRecipe(ItemRegistry.cermileLump, ItemRegistry.demonizedTemplate, 14, new ItemStack(ItemRegistry.demonizedChestplate));

        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 10, new ItemStack(ItemRegistry.tormentedHelmet));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 11, new ItemStack(ItemRegistry.tormentedHood));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 9, new ItemStack(ItemRegistry.tormentedMask));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 8, new ItemStack(ItemRegistry.tormentedBoots));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 12, new ItemStack(ItemRegistry.tormentedLeggings));
        addRecipe(ItemRegistry.pardimalLump, ItemRegistry.tormentedTemplate, 14, new ItemStack(ItemRegistry.tormentedChestplate));
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
            return Item.getId(template) * 200 + Item.getId(lump) + lumpCount;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof InfusionRecipe && ((InfusionRecipe)o).template == this.template && ((InfusionRecipe)o).lump == this.lump && ((InfusionRecipe)o).lumpCount == this.lumpCount;
        }
    }
}