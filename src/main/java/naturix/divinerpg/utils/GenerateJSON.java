package naturix.divinerpg.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockModGrass;
import naturix.divinerpg.objects.blocks.BlockModLog;
import naturix.divinerpg.objects.blocks.FurnaceBase;
import naturix.divinerpg.objects.blocks.vanilla.BlockMobPumpkin;
import naturix.divinerpg.proxy.CommonProxy;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GenerateJSON {
    // You can include this in your mod/a pack/whatever you want, as long as that work follows the Mojang EULA.
    // The original source is viewable at https://gist.github.com/williewillus/a1a899ce5b0f0ba099078d46ae3dae6e

    // This is a janky JSON generator, for porting from below 1.12 to 1.12.
    // Simply replace calls to GameRegistry.addShapeless/ShapedRecipe with these methods, which will dump it to a json in RECIPE_DIR
    // Also works with OD, replace GameRegistry.addRecipe(new ShapedOreRecipe/ShapelessOreRecipe with the same calls
    // After you are done, call generateConstants()
    // Note that in many cases, you can combine multiple old recipes into one, since you can now specify multiple possibilities for an ingredient without using the OD. See vanilla for examples.

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static File RECIPE_DIR = null;
    private static File MODEL_DIR = null;
    private static File MODEL_ITEM_DIR = null;
    private static File MODEL_BLOCK_DIR = null;
    private static File BLOCKSTATES_DIR = null;
    private static final Set<String> USED_OD_NAMES = new TreeSet<>();

    private static void setupRecipeDir() {
        if (RECIPE_DIR == null) {
            RECIPE_DIR = CommonProxy.config.getConfigFile().toPath().resolve("../recipes/").toFile();
        }
        if (!RECIPE_DIR.exists()) {
            RECIPE_DIR.mkdir();
        }
    }

    private static void setupModelDir() {
        if (MODEL_DIR == null) {
            MODEL_DIR = CommonProxy.config.getConfigFile().toPath().resolve("../models/").toFile();
        }
        if (!MODEL_DIR.exists()) {
            MODEL_DIR.mkdir();
        }
    }

    private static void setupModelItemDir() {
        setupModelDir();
        if (MODEL_ITEM_DIR == null) {
            MODEL_ITEM_DIR = CommonProxy.config.getConfigFile().toPath().resolve("../models/item/").toFile();
        }
        if (!MODEL_ITEM_DIR.exists()) {
            MODEL_ITEM_DIR.mkdir();
        }
    }

    private static void setupModelBlockDir() {
        setupModelDir();
        if (MODEL_BLOCK_DIR == null) {
            MODEL_BLOCK_DIR = CommonProxy.config.getConfigFile().toPath().resolve("../models/block/").toFile();
        }
        if (!MODEL_BLOCK_DIR.exists()) {
            MODEL_BLOCK_DIR.mkdir();
        }
    }

    private static void setupBlockStatesDir() {
        if (BLOCKSTATES_DIR == null) {
            BLOCKSTATES_DIR = CommonProxy.config.getConfigFile().toPath().resolve("../blockstates/").toFile();
        }
        if (!BLOCKSTATES_DIR.exists()) {
            BLOCKSTATES_DIR.mkdir();
        }
    }

    public static void generateItemModelJSONs() {
        setupModelItemDir();

        DivineRPG.logger.info("Generating Item Model JSONs");
        ModItems.ITEMS.forEach((item) -> {
            String registeryName = item.getRegistryName().getResourcePath();
            boolean isBow = registeryName.endsWith("bow");
            boolean isEgg = registeryName.endsWith("_egg") && !registeryName.equals("boiled_egg");
            boolean isMeriks = registeryName.equals("meriks_missile");

            Map<String, Object> json = new HashMap<>();
            if (item instanceof IHasModel) {
                json.put("parent", "item/generated");
                Map<String, Object> textures = new HashMap<>();
                if (isMeriks) {
                    textures.put("layer0", Reference.MODID + ":items/" + registeryName + "_0");
                    json.put("textures", textures);
                } else if (isBow) {
                    textures.put("layer0", Reference.MODID + ":items/" + registeryName + "_0");
                    json.put("textures", textures);
                    Map<String, Object> display = new HashMap<>();

                    Map<String, Object> thirdperson_righthand = new HashMap<>();
                    thirdperson_righthand.put("rotation", new int[] { -80, 260, -40 });
                    thirdperson_righthand.put("translation", new double[] { -1, -2, 2.5 });
                    thirdperson_righthand.put("scale", new double[] { 0.9, 0.9, 0.9 });
                    display.put("thirdperson_righthand", thirdperson_righthand);

                    Map<String, Object> thirdperson_lefthand = new HashMap<>();
                    thirdperson_lefthand.put("rotation", new int[] { -80, -280, 40 });
                    thirdperson_lefthand.put("translation", new double[] { -1, -2, 2.5 });
                    thirdperson_lefthand.put("scale", new double[] { 0.9, 0.9, 0.9 });
                    display.put("thirdperson_lefthand", thirdperson_lefthand);

                    Map<String, Object> firstperson_righthand = new HashMap<>();
                    firstperson_righthand.put("rotation", new int[] { 0, -90, 25 });
                    firstperson_righthand.put("translation", new double[] { 1.13, 3.2, 1.13 });
                    firstperson_righthand.put("scale", new double[] { 0.68, 0.68, 0.68 });
                    display.put("firstperson_righthand", firstperson_righthand);

                    Map<String, Object> firstperson_lefthand = new HashMap<>();
                    firstperson_lefthand.put("rotation", new int[] { 0, 90, -25 });
                    firstperson_lefthand.put("translation", new double[] { 1.13, 3.2, 1.13 });
                    firstperson_lefthand.put("scale", new double[] { 0.68, 0.68, 0.68 });
                    display.put("firstperson_lefthand", firstperson_lefthand);

                    json.put("display", display);

                    Map<String, Object> pull_1 = new HashMap<>();
                    Map<String, Object> predicate_1 = new HashMap<>();
                    predicate_1.put("pulling", 1);
                    pull_1.put("predicate", predicate_1);
                    pull_1.put("model", Reference.MODID + ":item/" + registeryName + "_1");

                    Map<String, Object> pull_2 = new HashMap<>();
                    Map<String, Object> predicate_2 = new HashMap<>();
                    predicate_2.put("pulling", 1);
                    predicate_2.put("pull", 0.65);
                    pull_2.put("predicate", predicate_2);
                    pull_2.put("model", Reference.MODID + ":item/" + registeryName + "_2");

                    Map<String, Object> pull_3 = new HashMap<>();
                    Map<String, Object> predicate_3 = new HashMap<>();
                    predicate_2.put("pulling", 1);
                    predicate_2.put("pull", 0.9);
                    pull_3.put("predicate", predicate_2);
                    pull_3.put("model", Reference.MODID + ":item/" + registeryName + "_3");

                    List<Map<String, Object>> overrides = new ArrayList<>();
                    overrides.add(pull_1);
                    overrides.add(pull_2);
                    overrides.add(pull_3);
                    json.put("overrides", overrides);
                } else if (isEgg) {
                    textures.put("layer0", Reference.MODID + ":items/pet_spawn_egg");
                    json.put("textures", textures);
                } else {
                    textures.put("layer0", Reference.MODID + ":items/" + registeryName);
                    json.put("textures", textures);
                }
            } else {
                json.put("parent", Reference.MODID + ":" + "block/" + registeryName);
            }

            File f = new File(MODEL_ITEM_DIR, registeryName + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (isMeriks || isBow) {
                creatAdditionalModelItemJSONs(registeryName);
            }
        });
    }

    private static void creatAdditionalModelItemJSONs(String registeryName) {
        for (int i = 1; i < 4; i++) {
            Map<String, Object> json = new HashMap<>();
            json.put("parent", "item/generated");
            Map<String, Object> textures = new HashMap<>();
            textures.put("layer0", Reference.MODID + ":items/" + registeryName + "_" + i);
            json.put("textures", textures);

            File f = new File(MODEL_ITEM_DIR, registeryName + "_" + i + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateBlockstateJSONs() {
        setupBlockStatesDir();

        DivineRPG.logger.info("Generating Blockstate JSONs");
        ModBlocks.BLOCKS.forEach((block) -> {
            String registeryName = block.getRegistryName().getResourcePath();
            String blockPath = Reference.MODID + ":" + registeryName;

            Map<String, Object> json = new HashMap<>();
            json.put("forge_marker", 1);
            Map<String, Object> variants = new HashMap<>();
            Map<String, Object> normal = new HashMap<>();
            normal.put("model", blockPath);
            variants.put("normal", normal);
            if (block instanceof FurnaceBase || block instanceof BlockMobPumpkin) {
                Map<String, Object> facingNorth = new HashMap<>();
                facingNorth.put("model", blockPath);
                Map<String, Object> facingEast = new HashMap<>();
                facingEast.put("y", 90);
                facingEast.put("model", blockPath);
                Map<String, Object> facingSouth = new HashMap<>();
                facingSouth.put("y", 180);
                facingSouth.put("model", blockPath);
                Map<String, Object> facingWest = new HashMap<>();
                facingWest.put("y", 270);
                facingWest.put("model", blockPath);
                variants.put("facing=north", facingNorth);
                variants.put("facing=east", facingEast);
                variants.put("facing=south", facingSouth);
                variants.put("facing=west", facingWest);
            } else if (block instanceof BlockModLog) {
                Map<String, Object> axisNone = new HashMap<>();
                axisNone.put("model", blockPath);
                Map<String, Object> axisY = new HashMap<>();
                axisY.put("model", blockPath);
                Map<String, Object> axisX = new HashMap<>();
                axisX.put("x", 90);
                axisX.put("y", 90);
                axisX.put("model", blockPath);
                Map<String, Object> axisZ = new HashMap<>();
                axisZ.put("x", 90);
                axisZ.put("model", blockPath);
                variants.put("axis=none", axisNone);
                variants.put("axis=y", axisY);
                variants.put("axis=x", axisX);
                variants.put("axis=z", axisZ);
            }
            json.put("variants", variants);

            File f = new File(BLOCKSTATES_DIR, registeryName + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void generateModelBlockJSONs() {
        setupModelBlockDir();

        DivineRPG.logger.info("Generating Block Model JSONs");
        ModBlocks.BLOCKS.forEach((block) -> {
            String registeryName = block.getRegistryName().getResourcePath();

            Map<String, Object> json = new HashMap<>();
            json.put("parent", "block/cube_all");
            Map<String, Object> textures = new HashMap<>();
            String blockPath = Reference.MODID + ":" + "blocks/" + registeryName;
            if (block instanceof BlockModGrass) {
                String dirt = blockPath.replace("_grass", "_dirt");
                String grassTop = blockPath + "_top";
                String grassSide = blockPath + "_side";
                textures.put("particle", dirt);
                textures.put("down", dirt);
                textures.put("up", grassTop);
                textures.put("east", grassSide);
                textures.put("west", grassSide);
                textures.put("north", grassSide);
                textures.put("south", grassSide);
            } else if (block instanceof BlockModLog) {
                String logTop = blockPath + "_top";
                String logSide = blockPath + "_side";
                textures.put("particle", logTop);
                textures.put("down", logTop);
                textures.put("up", logTop);
                textures.put("east", logSide);
                textures.put("west", logSide);
                textures.put("north", logSide);
                textures.put("south", logSide);
            } else if (block instanceof FurnaceBase) {
                String furnace = blockPath;
                String furnaceFront;
                if (furnace.endsWith("_on")) {
                    furnace = furnace.replace("_on", "");
                    furnaceFront = furnace + "_front_on";
                } else {
                    furnaceFront = furnace + "_front_off";
                }
                String furnaceTop = furnace + "_top";
                String furnaceSide = furnace + "_side";
                textures.put("particle", furnaceFront);
                textures.put("down", furnaceTop);
                textures.put("up", furnaceTop);
                if (registeryName.equals("coalstone_furnace")) {
                    furnaceSide = furnaceSide.replace("_furnace_side", "");
                }
                textures.put("east", furnaceSide);
                textures.put("west", furnaceSide);
                textures.put("south", furnaceSide);
                textures.put("north", furnaceFront);
            } else if (block instanceof BlockMobPumpkin) {
                String pumpkinTop = blockPath + "_top";
                String pumpkinSide = blockPath + "_side";
                String pumpkinFront = blockPath + "_front";
                textures.put("particle", pumpkinSide);
                textures.put("down", pumpkinTop);
                textures.put("up", pumpkinTop);
                textures.put("east", pumpkinSide);
                textures.put("west", pumpkinSide);
                textures.put("north", pumpkinFront);
                textures.put("south", pumpkinSide);
            } else {
                textures.put("all", Reference.MODID + ":" + "blocks/" + registeryName);
            }
            json.put("textures", textures);

            File f = new File(MODEL_BLOCK_DIR, registeryName + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // EXPERIMENTAL: JSONs generated will definitely not work in 1.12.2 and below, and may not even work when 1.13 comes out
    // When Forge 1.13 is fully released, I will fix this to be correct
    // Usage: Replace calls to GameRegistry.addSmelting with this
    //public static void addSmelting(ItemStack in, ItemStack result, float xp) {
    //    addSmelting(in, result, xp, 200);
    //}
    public static void addSmelting(ItemStack in, ItemStack result, float xp) {
        GameRegistry.addSmelting(in, result, xp);
    }

    public static void addSmelting(ItemStack in, ItemStack result, float xp, int cookTime) {
        setupRecipeDir();

        // GameRegistry.addSmelting(in, out, xp);
        Map<String, Object> json = new HashMap<>();
        json.put("type", "minecraft:smelting");
        json.put("ingredient", serializeItem(in));
        json.put("result", serializeItem(result)); // vanilla jsons just have a string?
        json.put("experience", xp);
        json.put("cookingtime", cookTime);

        // names the json the same name as the output's registry name
        // repeatedly adds _alt if a file already exists
        // janky I know but it works
        String suffix = result.getItem().getHasSubtypes() ? "_" + result.getItemDamage() : "";
        File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");

        while (f.exists()) {
            suffix += "_alt";
            f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");
        }

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addRecipe(ItemStack result, Object... components) {
        setupRecipeDir();

        // GameRegistry.addShapedRecipe(result, components);

        Map<String, Object> json = new HashMap<>();

        List<String> pattern = new ArrayList<>();
        int i = 0;
        while (i < components.length && components[i] instanceof String) {
            pattern.add((String) components[i]);
            i++;
        }
        json.put("pattern", pattern);

        boolean isOreDict = false;
        Map<String, Map<String, Object>> key = new HashMap<>();
        Character curKey = null;
        for (; i < components.length; i++) {
            Object o = components[i];
            if (o instanceof Character) {
                if (curKey != null)
                    throw new IllegalArgumentException("Provided two char keys in a row");
                curKey = (Character) o;
            } else {
                if (curKey == null)
                    throw new IllegalArgumentException("Providing object without a char key");
                if (o instanceof String)
                    isOreDict = true;
                key.put(Character.toString(curKey), serializeItem(o));
                curKey = null;
            }
        }
        json.put("key", key);
        json.put("type", isOreDict ? "forge:ore_shaped" : "minecraft:crafting_shaped");
        json.put("result", serializeItem(result));

        // names the json the same name as the output's registry name
        // repeatedly adds _alt if a file already exists
        // janky I know but it works
        String suffix = result.getItem().getHasSubtypes() ? "_" + result.getItemDamage() : "";
        File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");

        while (f.exists()) {
            suffix += "_alt";
            f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");
        }

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addShapelessRecipe(ItemStack result, Object... components) {
        setupRecipeDir();

        // addShapelessRecipe(result, components);

        Map<String, Object> json = new HashMap<>();

        boolean isOreDict = false;
        List<Map<String, Object>> ingredients = new ArrayList<>();
        for (Object o : components) {
            if (o instanceof String)
                isOreDict = true;
            ingredients.add(serializeItem(o));
        }
        json.put("ingredients", ingredients);
        json.put("type", isOreDict ? "forge:ore_shapeless" : "minecraft:crafting_shapeless");
        json.put("result", serializeItem(result));

        // names the json the same name as the output's registry name
        // repeatedly adds _alt if a file already exists
        // janky I know but it works
        String suffix = result.getItem().getHasSubtypes() ? "_" + result.getItemDamage() : "";
        File f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");

        //while (f.exists()) {
        //    suffix += "_alt";
        //    f = new File(RECIPE_DIR, result.getItem().getRegistryName().getResourcePath() + suffix + ".json");
        //}

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object> serializeItem(Object thing) {
        if (thing instanceof Item) {
            return serializeItem(new ItemStack((Item) thing));
        }
        if (thing instanceof Block) {
            return serializeItem(new ItemStack((Block) thing));
        }
        if (thing instanceof ItemStack) {
            ItemStack stack = (ItemStack) thing;
            Map<String, Object> ret = new HashMap<>();
            ret.put("item", stack.getItem().getRegistryName().toString());
            if (stack.getItem().getHasSubtypes() || stack.getItemDamage() != 0) {
                ret.put("data", stack.getItemDamage());
            }
            if (stack.getCount() > 1) {
                ret.put("count", stack.getCount());
            }

            if (stack.hasTagCompound()) {
                ret.put("type", "minecraft:item_nbt");
                ret.put("nbt", stack.getTagCompound().toString());
            }

            return ret;
        }
        if (thing instanceof String) {
            Map<String, Object> ret = new HashMap<>();
            USED_OD_NAMES.add((String) thing);
            ret.put("item", "#" + ((String) thing).toUpperCase(Locale.ROOT));
            return ret;
        }

        throw new IllegalArgumentException("Not a block, item, stack, or od name");
    }

    // Call this after you are done generating
    public static void generateConstants() {
        List<Map<String, Object>> json = new ArrayList<>();
        for (String s : USED_OD_NAMES) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("name", s.toUpperCase(Locale.ROOT));
            entry.put("ingredient", ImmutableMap.of("type", "forge:ore_dict", "ore", s));
            json.add(entry);
        }

        try (FileWriter w = new FileWriter(new File(RECIPE_DIR, "_constants.json"))) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
