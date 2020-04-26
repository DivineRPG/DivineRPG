package divinerpg.utils;

import divinerpg.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class RecipesInfusionTable {

    public static HashMap<InfusionRecipe, Item> recipes = new HashMap<InfusionRecipe, Item>();
    public static RecipesInfusionTable instance = new RecipesInfusionTable();

    private RecipesInfusionTable() {
        this.addRecipes();
    }

    public void addRecipes() {
        addRecipe(ModItems.teakerLump, ModItems.bowTemplate, 4, new ItemStack(ModItems.teakerBow));
        addRecipe(ModItems.amthirmisLump, ModItems.bowTemplate, 5, new ItemStack(ModItems.amthirmisBow));
        addRecipe(ModItems.darvenLump, ModItems.bowTemplate, 6, new ItemStack(ModItems.darvenBow));
        addRecipe(ModItems.cermileLump, ModItems.bowTemplate, 8, new ItemStack(ModItems.cermileBow));
        addRecipe(ModItems.pardimalLump, ModItems.bowTemplate, 11, new ItemStack(ModItems.pardimalBow));
        addRecipe(ModItems.quadroticLump, ModItems.bowTemplate, 13, new ItemStack(ModItems.quadroticBow));
        addRecipe(ModItems.karosLump, ModItems.bowTemplate, 18, new ItemStack(ModItems.karosBow));
        addRecipe(ModItems.heliosisLump, ModItems.bowTemplate, 20, new ItemStack(ModItems.heliosisBow));
        addRecipe(ModItems.arksianeLump, ModItems.bowTemplate, 24, new ItemStack(ModItems.arksianeBow));

        addRecipe(ModItems.teakerLump, ModItems.staffTemplate, 2, new ItemStack(ModItems.teakerStaff));
        addRecipe(ModItems.amthirmisLump, ModItems.staffTemplate, 3, new ItemStack(ModItems.amthirmisStaff));
        addRecipe(ModItems.darvenLump, ModItems.staffTemplate, 4, new ItemStack(ModItems.darvenStaff));
        addRecipe(ModItems.cermileLump, ModItems.staffTemplate, 6, new ItemStack(ModItems.cermileStaff));
        addRecipe(ModItems.pardimalLump, ModItems.staffTemplate, 8, new ItemStack(ModItems.pardimalStaff));
        addRecipe(ModItems.quadroticLump, ModItems.staffTemplate, 10, new ItemStack(ModItems.quadroticStaff));
        addRecipe(ModItems.karosLump, ModItems.staffTemplate, 16, new ItemStack(ModItems.karosStaff));
        addRecipe(ModItems.heliosisLump, ModItems.staffTemplate, 17, new ItemStack(ModItems.heliosisStaff));
        addRecipe(ModItems.arksianeLump, ModItems.staffTemplate, 21, new ItemStack(ModItems.arksianeStaff));

        addRecipe(ModItems.teakerLump, ModItems.backswordTemplate, 4, new ItemStack(ModItems.teakerBacksword));
        addRecipe(ModItems.amthirmisLump, ModItems.backswordTemplate, 5, new ItemStack(ModItems.amthirmisBacksword));
        addRecipe(ModItems.darvenLump, ModItems.backswordTemplate, 6, new ItemStack(ModItems.darvenBacksword));
        addRecipe(ModItems.cermileLump, ModItems.backswordTemplate, 8, new ItemStack(ModItems.cermileBacksword));
        addRecipe(ModItems.pardimalLump, ModItems.backswordTemplate, 11, new ItemStack(ModItems.pardimalBacksword));
        addRecipe(ModItems.quadroticLump, ModItems.backswordTemplate, 13, new ItemStack(ModItems.quadroticBacksword));
        addRecipe(ModItems.karosLump, ModItems.backswordTemplate, 18, new ItemStack(ModItems.karosBacksword));
        addRecipe(ModItems.heliosisLump, ModItems.backswordTemplate, 20, new ItemStack(ModItems.heliosisBacksword));
        addRecipe(ModItems.arksianeLump, ModItems.backswordTemplate, 24, new ItemStack(ModItems.arksianeBacksword));

        addRecipe(ModItems.teakerLump, ModItems.clawTemplate, 2, new ItemStack(ModItems.teakerClaw));
        addRecipe(ModItems.amthirmisLump, ModItems.clawTemplate, 3, new ItemStack(ModItems.amthirmisClaw));
        addRecipe(ModItems.darvenLump, ModItems.clawTemplate, 4, new ItemStack(ModItems.darvenClaw));
        addRecipe(ModItems.cermileLump, ModItems.clawTemplate, 6, new ItemStack(ModItems.cermileClaw));
        addRecipe(ModItems.pardimalLump, ModItems.clawTemplate, 8, new ItemStack(ModItems.pardimalClaw));
        addRecipe(ModItems.quadroticLump, ModItems.clawTemplate, 10, new ItemStack(ModItems.quadroticClaw));
        addRecipe(ModItems.karosLump, ModItems.clawTemplate, 16, new ItemStack(ModItems.karosClaw));
        addRecipe(ModItems.heliosisLump, ModItems.clawTemplate, 17, new ItemStack(ModItems.heliosisClaw));
        addRecipe(ModItems.arksianeLump, ModItems.clawTemplate, 21, new ItemStack(ModItems.arksianeClaw));

        addRecipe(ModItems.teakerLump, ModItems.hammerTemplate, 7, new ItemStack(ModItems.teakerHammer));
        addRecipe(ModItems.amthirmisLump, ModItems.hammerTemplate, 9, new ItemStack(ModItems.amthirmisHammer));
        addRecipe(ModItems.darvenLump, ModItems.hammerTemplate, 11, new ItemStack(ModItems.darvenHammer));
        addRecipe(ModItems.cermileLump, ModItems.hammerTemplate, 14, new ItemStack(ModItems.cermileHammer));
        addRecipe(ModItems.pardimalLump, ModItems.hammerTemplate, 17, new ItemStack(ModItems.pardimalHammer));
        addRecipe(ModItems.quadroticLump, ModItems.hammerTemplate, 19, new ItemStack(ModItems.quadroticHammer));
        addRecipe(ModItems.karosLump, ModItems.hammerTemplate, 22, new ItemStack(ModItems.karosHammer));
        addRecipe(ModItems.heliosisLump, ModItems.hammerTemplate, 27, new ItemStack(ModItems.heliosisHammer));
        addRecipe(ModItems.arksianeLump, ModItems.hammerTemplate, 31, new ItemStack(ModItems.arksianeHammer));

        addRecipe(ModItems.teakerLump, ModItems.cannonTemplate, 7, new ItemStack(ModItems.teakerCannon));
        addRecipe(ModItems.amthirmisLump, ModItems.cannonTemplate, 9, new ItemStack(ModItems.amthirmisCannon));
        addRecipe(ModItems.darvenLump, ModItems.cannonTemplate, 11, new ItemStack(ModItems.darvenCannon));
        addRecipe(ModItems.cermileLump, ModItems.cannonTemplate, 14, new ItemStack(ModItems.cermileCannon));
        addRecipe(ModItems.pardimalLump, ModItems.cannonTemplate, 17, new ItemStack(ModItems.pardimalCannon));
        addRecipe(ModItems.quadroticLump, ModItems.cannonTemplate, 19, new ItemStack(ModItems.quadroticCannon));
        addRecipe(ModItems.karosLump, ModItems.cannonTemplate, 22, new ItemStack(ModItems.karosCannon));
        addRecipe(ModItems.heliosisLump, ModItems.cannonTemplate, 27, new ItemStack(ModItems.heliosisCannon));
        addRecipe(ModItems.arksianeLump, ModItems.cannonTemplate, 31, new ItemStack(ModItems.arksianeCannon));

        addRecipe(ModItems.teakerLump, ModItems.diskTemplate, 4, new ItemStack(ModItems.teakerDisk));
        addRecipe(ModItems.amthirmisLump, ModItems.diskTemplate, 5, new ItemStack(ModItems.amthirmisDisk));
        addRecipe(ModItems.darvenLump, ModItems.diskTemplate, 6, new ItemStack(ModItems.darvenDisk));
        addRecipe(ModItems.cermileLump, ModItems.diskTemplate, 8, new ItemStack(ModItems.cermileDisk));
        addRecipe(ModItems.pardimalLump, ModItems.diskTemplate, 11, new ItemStack(ModItems.pardimalDisk));
        addRecipe(ModItems.quadroticLump, ModItems.diskTemplate, 13, new ItemStack(ModItems.quadroticDisk));
        addRecipe(ModItems.karosLump, ModItems.diskTemplate, 18, new ItemStack(ModItems.karosDisk));
        addRecipe(ModItems.heliosisLump, ModItems.diskTemplate, 20, new ItemStack(ModItems.heliosisDisk));
        addRecipe(ModItems.arksianeLump, ModItems.diskTemplate, 24, new ItemStack(ModItems.arksianeDisk));

        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 7, new ItemStack(ModItems.degradedHelmet));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 8, new ItemStack(ModItems.degradedHood));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 6, new ItemStack(ModItems.degradedMask));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 5, new ItemStack(ModItems.degradedBoots));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 9, new ItemStack(ModItems.degradedLeggings));
        addRecipe(ModItems.teakerLump, ModItems.degradedTemplate, 10, new ItemStack(ModItems.degradedChestplate));

        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 10, new ItemStack(ModItems.finishedHelmet));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 11, new ItemStack(ModItems.finishedHood));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 9, new ItemStack(ModItems.finishedMask));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 8, new ItemStack(ModItems.finishedBoots));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 12, new ItemStack(ModItems.finishedLeggings));
        addRecipe(ModItems.amthirmisLump, ModItems.finishedTemplate, 14, new ItemStack(ModItems.finishedChestplate));

        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 10, new ItemStack(ModItems.glisteningHelmet));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 11, new ItemStack(ModItems.glisteningHood));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 9, new ItemStack(ModItems.glisteningMask));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 8, new ItemStack(ModItems.glisteningBoots));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 12, new ItemStack(ModItems.glisteningLeggings));
        addRecipe(ModItems.darvenLump, ModItems.glisteningTemplate, 14, new ItemStack(ModItems.glisteningChestplate));

        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 10, new ItemStack(ModItems.demonizedHelmet));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 11, new ItemStack(ModItems.demonizedHood));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 9, new ItemStack(ModItems.demonizedMask));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 8, new ItemStack(ModItems.demonizedBoots));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 12, new ItemStack(ModItems.demonizedLeggings));
        addRecipe(ModItems.cermileLump, ModItems.demonizedTemplate, 14, new ItemStack(ModItems.demonizedChestplate));

        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 10, new ItemStack(ModItems.tormentedHelmet));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 11, new ItemStack(ModItems.tormentedHood));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 9, new ItemStack(ModItems.tormentedMask));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 8, new ItemStack(ModItems.tormentedBoots));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 12, new ItemStack(ModItems.tormentedLeggings));
        addRecipe(ModItems.pardimalLump, ModItems.tormentedTemplate, 14, new ItemStack(ModItems.tormentedChestplate));
    }

    public void addRecipe(Item lump, Item template, int count, ItemStack res) {
        recipes.put(new InfusionRecipe(lump, template, count), res.getItem());
    }

    public Item getOutput(Item lump, Item template, int count) {
        if(recipes.containsKey(new InfusionRecipe(lump, template, count)))return recipes.get(new InfusionRecipe(lump, template, count));
        return null;
    }

    private static class InfusionRecipe {
        public final Item template;
        public final Item lump;
        private final int lumpCount;

        public InfusionRecipe(Item lump, Item template, int lumpCount) {
            this.lump=lump;
            this.template=template;
            this.lumpCount=lumpCount;
        }

        @Override
        public int hashCode() {
            return Item.getIdFromItem(template)*200 + Item.getIdFromItem(lump) + lumpCount;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof InfusionRecipe && ((InfusionRecipe)o).template == this.template && ((InfusionRecipe)o).lump == this.lump && ((InfusionRecipe)o).lumpCount == this.lumpCount;
        }
    }
}