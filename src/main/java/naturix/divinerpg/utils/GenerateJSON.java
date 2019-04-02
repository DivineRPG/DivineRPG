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

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockDoorBase;
import naturix.divinerpg.objects.blocks.BlockModChest;
import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.objects.blocks.BlockModFence;
import naturix.divinerpg.objects.blocks.BlockModFire;
import naturix.divinerpg.objects.blocks.BlockModFurnace;
import naturix.divinerpg.objects.blocks.BlockModGrass;
import naturix.divinerpg.objects.blocks.BlockModLeaves;
import naturix.divinerpg.objects.blocks.BlockModLog;
import naturix.divinerpg.objects.blocks.BlockModPortal;
import naturix.divinerpg.objects.blocks.BlockModSlab;
import naturix.divinerpg.objects.blocks.BlockModSpawner;
import naturix.divinerpg.objects.blocks.BlockModStairs;
import naturix.divinerpg.objects.blocks.BlockModTorch;
import naturix.divinerpg.objects.blocks.BlockStatue;
import naturix.divinerpg.objects.blocks.eden.BlockSinglePlant;
import naturix.divinerpg.objects.blocks.iceika.BlockChristmasLights;
import naturix.divinerpg.objects.blocks.vanilla.BlockMobPumpkin;
import naturix.divinerpg.proxy.CommonProxy;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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

        if (Config.debug) {
            DivineRPG.logger.info("Generating Item Model JSONs");
        }
        ModItems.ITEMS.forEach((item) -> {
            String registryName = item.getRegistryName().getResourcePath();
            boolean isBow = registryName.endsWith("bow");
            boolean isEgg = registryName.endsWith("_egg") && !registryName.equals("boiled_egg");
            boolean isMeriks = registryName.equals("meriks_missile");

            Map<String, Object> json = new HashMap<>();
            if (item instanceof IHasModel) {
                json.put("parent", "item/generated");
                Map<String, Object> textures = new HashMap<>();
                if (isMeriks) {
                    textures.put("layer0", Reference.MODID + ":items/" + registryName + "_0");
                    json.put("textures", textures);
                } else if (isBow) {
                    textures.put("layer0", Reference.MODID + ":items/" + registryName + "_0");
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
                    pull_1.put("model", Reference.MODID + ":item/" + registryName + "_1");

                    Map<String, Object> pull_2 = new HashMap<>();
                    Map<String, Object> predicate_2 = new HashMap<>();
                    predicate_2.put("pulling", 1);
                    predicate_2.put("pull", 0.65);
                    pull_2.put("predicate", predicate_2);
                    pull_2.put("model", Reference.MODID + ":item/" + registryName + "_2");

                    Map<String, Object> pull_3 = new HashMap<>();
                    Map<String, Object> predicate_3 = new HashMap<>();
                    predicate_2.put("pulling", 1);
                    predicate_2.put("pull", 0.9);
                    pull_3.put("predicate", predicate_2);
                    pull_3.put("model", Reference.MODID + ":item/" + registryName + "_3");

                    List<Map<String, Object>> overrides = new ArrayList<>();
                    overrides.add(pull_1);
                    overrides.add(pull_2);
                    overrides.add(pull_3);
                    json.put("overrides", overrides);
                } else if (isEgg) {
                    textures.put("layer0", Reference.MODID + ":items/pet_spawn_egg");
                    json.put("textures", textures);
                } else {
                    textures.put("layer0", Reference.MODID + ":items/" + registryName);
                    json.put("textures", textures);
                }
            } else {
                Block block = ((ItemBlock) item).getBlock();
                if (block instanceof BlockModSpawner) {
                    json.put("parent", Reference.MODID + ":block/spawner");
                } else if (block instanceof BlockModFire) {
                    json.put("parent", Reference.MODID + ":block/blue_fire_0");
                } else if (block instanceof BlockModPortal) {
                    json.put("parent", Reference.MODID + ":block/" + registryName + "_ns");
                } else if (block instanceof BlockModFence) {
                    json.put("parent", Reference.MODID + ":block/" + registryName + "_inventory");
                } else if (block instanceof BlockModCrop) {
                    json.put("parent", Reference.MODID + ":block/" + registryName + "_stage_0");
                } else if (registryName.endsWith("_double_slab")) {
                    json.put("parent", Reference.MODID + ":block/" + registryName.replace("_double_slab", "_planks"));
                } else if (registryName.endsWith("_slab")) {
                    json.put("parent", Reference.MODID + ":block/" + registryName.replace("_slab", "_half_slab"));
                } else if (block instanceof BlockChristmasLights || block instanceof BlockSinglePlant) {
                    json.put("parent", "item/generated");
                    Map<String, Object> textures = new HashMap<>();
                    textures.put("layer0", Reference.MODID + ":blocks/" + registryName);
                    json.put("textures", textures);
                } else if (block instanceof BlockDoorBase) {
                    json.put("parent", "item/generated");
                    Map<String, Object> textures = new HashMap<>();
                    textures.put("layer0", Reference.MODID + ":items/" + registryName);
                    json.put("textures", textures);
                } else {
                    json.put("parent", Reference.MODID + ":block/" + registryName);
                }
            }

            File f = new File(MODEL_ITEM_DIR, registryName + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (isMeriks || isBow) {
                creatAdditionalModelItemJSONs(registryName);
            }
        });
    }

    private static void creatAdditionalModelItemJSONs(String registryName) {
        for (int i = 1; i < 4; i++) {
            Map<String, Object> json = new HashMap<>();
            json.put("parent", "item/generated");
            Map<String, Object> textures = new HashMap<>();
            textures.put("layer0", Reference.MODID + ":items/" + registryName + "_" + i);
            json.put("textures", textures);

            File f = new File(MODEL_ITEM_DIR, registryName + "_" + i + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateBlockstateJSONs() {
        setupBlockStatesDir();

        if (Config.debug) {
            DivineRPG.logger.info("Generating Blockstate JSONs");
        }
        ModBlocks.BLOCKS.forEach((block) -> {
            String registryName = block.getRegistryName().getResourcePath();
            if (block instanceof BlockModFurnace || block instanceof BlockMobPumpkin
                    || block instanceof BlockChristmasLights) {
                if (registryName.contains("demon")) {
                    generateIgnoreVariantBlockstate(registryName);
                } else {
                    generateFacingBlockstate(registryName);
                }
            } else if (block instanceof BlockModLog) {
                generateAxisBlockstate(registryName);
            } else if (block instanceof BlockModStairs) {
                generateStairsBlockstate(registryName);
            } else if (block instanceof BlockModSpawner) {
                generateSpawnerBlockstate(registryName);
            } else if (block instanceof BlockModLeaves) {
                generateIgnoreVariantBlockstate(registryName);
            } else if (block instanceof BlockModPortal) {
                generatePortalBlockstate(registryName);
            } else if (block instanceof BlockModFire) {
                generateFireBlockstate(registryName);
            } else if (block instanceof BlockModTorch) {
                generateTorchBlockstate(registryName);
            } else if (block instanceof BlockModFence) {
                generateFenceBlockstate(registryName);
            } else if (block instanceof BlockModCrop) {
                generateCropBlockstate(registryName, ((BlockModCrop) block).getMaxAge());
            } else if (block instanceof BlockModSlab) {
                generateSlabBlockstate(registryName, ((BlockModSlab) block).isDouble());
            } else if (block instanceof BlockModChest) {
                generateIgnoreVariantBlockstate(registryName);
            } else {
                generateCubeBlockstate(registryName);
            }
        });
    }

    private static void generateFacingBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        Map<String, Object> variants = new HashMap<>();
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
        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateIgnoreVariantBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> multipart = new ArrayList<>();

        Map<String, Object> normal = new HashMap<>();
        Map<String, Object> apply = new HashMap<>();
        apply.put("model", blockPath);
        normal.put("apply", apply);
        multipart.add(normal);
        json.put("multipart", multipart);

        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateAxisBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        Map<String, Object> variants = new HashMap<>();
        Map<String, Object> normal = new HashMap<>();
        normal.put("model", blockPath);
        variants.put("normal", normal);
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
        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateCubeBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        Map<String, Object> variants = new HashMap<>();
        Map<String, Object> normal = new HashMap<>();
        normal.put("model", blockPath);
        variants.put("normal", normal);
        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateStairsBlockstate(String registryName) {
        String stairs = Reference.MODID + ":" + registryName;
        String innerStairs = stairs.replace("_stairs", "_inner_stairs");
        String outerStairs = stairs.replace("_stairs", "_outer_stairs");

        Map<String, Object> json = new HashMap<>();
        Map<String, Object> variants = new HashMap<>();

        Map<String, Object> variant = new HashMap<>();
        variant.put("model", stairs);
        variants.put("facing=east,half=bottom,shape=straight", variant);
        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=west,half=bottom,shape=straight", variant);
        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=bottom,shape=straight", variant);
        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=north,half=bottom,shape=straight", variant);

        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variants.put("facing=east,half=bottom,shape=outer_right", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=west,half=bottom,shape=outer_right", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=bottom,shape=outer_right", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=north,half=bottom,shape=outer_right", variant);

        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=east,half=bottom,shape=outer_left", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=west,half=bottom,shape=outer_left", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=bottom,shape=outer_left", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variants.put("facing=north,half=bottom,shape=outer_left", variant);

        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variants.put("facing=east,half=bottom,shape=inner_right", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=west,half=bottom,shape=inner_right", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=bottom,shape=inner_right", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=north,half=bottom,shape=inner_right", variant);

        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=east,half=bottom,shape=inner_left", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=west,half=bottom,shape=inner_left", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variants.put("facing=south,half=bottom,shape=inner_left", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=north,half=bottom,shape=inner_left", variant);

        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("x", 180);
        variant.put("uvlock", true);
        variants.put("facing=east,half=top,shape=straight", variant);
        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("x", 180);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=west,half=top,shape=straight", variant);
        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("x", 180);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=top,shape=straight", variant);
        variant = new HashMap<>();
        variant.put("model", stairs);
        variant.put("x", 180);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=north,half=top,shape=straight", variant);

        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=east,half=top,shape=outer_right", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=west,half=top,shape=outer_right", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=south,half=top,shape=outer_right", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("uvlock", true);
        variants.put("facing=north,half=top,shape=outer_right", variant);

        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("uvlock", true);
        variants.put("facing=east,half=top,shape=outer_left", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=west,half=top,shape=outer_left", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=top,shape=outer_left", variant);
        variant = new HashMap<>();
        variant.put("model", outerStairs);
        variant.put("x", 180);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=north,half=top,shape=outer_left", variant);

        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=east,half=top,shape=inner_right", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=west,half=top,shape=inner_right", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=south,half=top,shape=inner_right", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("uvlock", true);
        variants.put("facing=north,half=top,shape=inner_right", variant);

        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("uvlock", true);
        variants.put("facing=east,half=top,shape=inner_left", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("y", 180);
        variant.put("uvlock", true);
        variants.put("facing=west,half=top,shape=inner_left", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("y", 90);
        variant.put("uvlock", true);
        variants.put("facing=south,half=top,shape=inner_left", variant);
        variant = new HashMap<>();
        variant.put("model", innerStairs);
        variant.put("x", 180);
        variant.put("y", 270);
        variant.put("uvlock", true);
        variants.put("facing=north,half=top,shape=inner_left", variant);

        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateSpawnerBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":spawner";

        Map<String, Object> json = new HashMap<>();
        json.put("forge_marker", 1);
        Map<String, Object> variants = new HashMap<>();
        Map<String, Object> normal = new HashMap<>();
        normal.put("model", blockPath);
        variants.put("normal", normal);
        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generatePortalBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        json.put("forge_marker", 1);
        Map<String, Object> variants = new HashMap<>();
        Map<String, Object> axisZ = new HashMap<>();
        axisZ.put("model", blockPath + "_ew");
        variants.put("axis=z", axisZ);
        Map<String, Object> axisX = new HashMap<>();
        axisX.put("model", blockPath + "_ns");
        variants.put("axis=x", axisX);
        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateFireBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> multipart = new ArrayList<>();
        Map<String, Object> floor = new HashMap<>();
        List<Map<String, Object>> apply = new ArrayList<>();
        Map<String, Object> texture = new HashMap<>();
        texture.put("model", "divinerpg:blue_fire_0");
        apply.add(texture);
        texture = new HashMap<>();
        texture.put("model", "divinerpg:blue_fire_1");
        apply.add(texture);
        floor.put("apply", apply);
        multipart.add(floor);
        json.put("multipart", multipart);

        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateTorchBlockstate(String registryName) {
        String floorModel = Reference.MODID + ":" + registryName;
        String wallModel = Reference.MODID + ":" + registryName + "_wall";

        Map<String, Object> json = new HashMap<>();
        Map<String, Object> variants = new HashMap<>();
        Map<String, Object> facingUp = new HashMap<>();
        facingUp.put("model", floorModel);
        variants.put("facing=up", facingUp);
        Map<String, Object> facingEast = new HashMap<>();
        facingEast.put("model", wallModel);
        Map<String, Object> facingSouth = new HashMap<>();
        facingSouth.put("y", 90);
        facingSouth.put("model", wallModel);
        Map<String, Object> facingWest = new HashMap<>();
        facingWest.put("y", 180);
        facingWest.put("model", wallModel);
        Map<String, Object> facingNorth = new HashMap<>();
        facingNorth.put("y", 270);
        facingNorth.put("model", wallModel);
        variants.put("facing=east", facingEast);
        variants.put("facing=south", facingSouth);
        variants.put("facing=west", facingWest);
        variants.put("facing=north", facingNorth);
        json.put("variants", variants);
        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateFenceBlockstate(String registryName) {
        String blockPath = Reference.MODID + ":" + registryName;
        String fencePost = blockPath + "_post";
        String fenceSide = blockPath + "_side";

        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> multipart = new ArrayList<>();
        Map<String, Object> side = new HashMap<>();
        Map<String, Object> post = new HashMap<>();
        Map<String, Object> apply = new HashMap<>();
        Map<String, Object> when = new HashMap<>();

        apply.put("model", fencePost);
        post.put("apply", apply);
        multipart.add(post);

        apply = new HashMap<>();
        when.put("north", "true");
        side.put("when", when);
        apply.put("model", fenceSide);
        apply.put("uvlock", true);
        side.put("apply", apply);
        multipart.add(side);

        when = new HashMap<>();
        apply = new HashMap<>();
        side = new HashMap<>();
        when.put("east", "true");
        side.put("when", when);
        apply.put("model", fenceSide);
        apply.put("y", 90);
        apply.put("uvlock", true);
        side.put("apply", apply);
        multipart.add(side);

        when = new HashMap<>();
        apply = new HashMap<>();
        side = new HashMap<>();
        when.put("south", "true");
        side.put("when", when);
        apply.put("model", fenceSide);
        apply.put("y", 180);
        apply.put("uvlock", true);
        side.put("apply", apply);
        multipart.add(side);

        when = new HashMap<>();
        apply = new HashMap<>();
        side = new HashMap<>();
        when.put("west", "true");
        side.put("when", when);
        apply.put("model", fenceSide);
        apply.put("y", 270);
        apply.put("uvlock", true);
        side.put("apply", apply);
        multipart.add(side);

        json.put("multipart", multipart);

        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateCropBlockstate(String registryName, int maxAge) {
        String blockPath = Reference.MODID + ":" + registryName;

        Map<String, Object> json = new HashMap<>();
        if (maxAge < 7) {
            List<Map<String, Object>> multipart = new ArrayList<>();

            for (int age = 0; age <= maxAge; age++) {
                Map<String, Object> ageNode = new HashMap<>();
                Map<String, Object> apply = new HashMap<>();
                Map<String, Object> when = new HashMap<>();
                apply.put("model", blockPath + "_stage_" + age);
                ageNode.put("apply", apply);
                when.put("age", "" + age);
                ageNode.put("when", when);
                multipart.add(ageNode);
            }

            json.put("multipart", multipart);
        } else {
            Map<String, Object> variants = new HashMap<>();

            for (int age = 0; age <= maxAge; age++) {
                Map<String, Object> ageNode = new HashMap<>();
                ageNode.put("model", blockPath + "_stage_" + age);
                variants.put("age=" + age, ageNode);
            }

            json.put("variants", variants);
        }

        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateSlabBlockstate(String registryName, boolean isDouble) {
        Map<String, Object> json = new HashMap<>();
        List<Map<String, Object>> multipart = new ArrayList<>();

        if (isDouble) {
            String baseName = registryName.replace("_double_slab", "");
            Map<String, Object> normal = new HashMap<>();
            Map<String, Object> apply = new HashMap<>();
            apply.put("model", Reference.MODID + ":" + baseName + "_planks");
            normal.put("apply", apply);
            multipart.add(normal);
        } else {
            String baseName = registryName.replace("_slab", "");
            Map<String, Object> halfBottom = new HashMap<>();
            Map<String, Object> apply = new HashMap<>();
            Map<String, Object> when = new HashMap<>();
            apply.put("model", Reference.MODID + ":" + baseName + "_half_slab");
            halfBottom.put("apply", apply);
            when.put("half", "bottom");
            halfBottom.put("when", when);

            Map<String, Object> halfTop = new HashMap<>();
            apply = new HashMap<>();
            when = new HashMap<>();
            apply.put("model", Reference.MODID + ":" + baseName + "_upper_slab");
            halfTop.put("apply", apply);
            when.put("half", "top");
            halfTop.put("when", when);
            multipart.add(halfBottom);
            multipart.add(halfTop);
        }

        json.put("multipart", multipart);

        File f = new File(BLOCKSTATES_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateModelBlockJSONs() {
        setupModelBlockDir();

        if (Config.debug) {
            DivineRPG.logger.info("Generating Block Model JSONs");
        }
        ModBlocks.BLOCKS.forEach((block) -> {
            String registryName = block.getRegistryName().getResourcePath();

            if (block instanceof BlockModGrass) {
                generateGrassModelBlock(registryName);
            } else if (block instanceof BlockModLog) {
                generateLogModelBlock(registryName);
            } else if (block instanceof BlockModFurnace) {
                if (registryName.contains("demon")) {
                    generateDummyModelBlock(registryName);
                } else {
                    generateFurnaceModelBlock(registryName);
                }
            } else if (block instanceof BlockMobPumpkin) {
                generatePumpkinModelBlock(registryName);
            } else if (block instanceof BlockModSpawner) {
                generateSpawnerModelBlock();
            } else if (block instanceof BlockModStairs) {
                generateStairsModelBlock(registryName);
            } else if (block instanceof BlockModPortal) {
                generatePortalModelBlock(registryName);
            } else if (block instanceof BlockModFire) {
                generateFireModelBlock();
            } else if (block instanceof BlockModTorch) {
                generateTorchModelBlock(registryName);
            } else if (block instanceof BlockModFence) {
                generateFenceModelBlock(registryName);
            } else if (block instanceof BlockModCrop) {
                generateCropModelBlock(registryName, ((BlockModCrop) block).getMaxAge());
            } else if (block instanceof BlockModSlab) {
                generateSlabModelBlock(registryName, ((BlockModSlab) block).isDouble());
            } else if (block instanceof BlockStatue || block instanceof BlockModChest) {
                generateDummyModelBlock(registryName);
            } else if (block instanceof BlockSinglePlant) {
                generateCrossModelBlock(registryName);
            } else if (block instanceof BlockChristmasLights) {
                generateLadderModelBlock(registryName);
            } else if (registryName.contains("workshop_bookcase")) {
                generateWorkshopBookcaseModelBlock(registryName);
            } else {
                generateBasicModelBlock(registryName);
            }
        });
    }

    private static void generateLogModelBlock(String registryName) {
        String blockPath = Reference.MODID + ":" + "blocks/" + registryName;
        String logTop = blockPath + "_top";
        String logSide = blockPath + "_side";

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        textures.put("particle", logTop);
        textures.put("down", logTop);
        textures.put("up", logTop);
        textures.put("east", logSide);
        textures.put("west", logSide);
        textures.put("north", logSide);
        textures.put("south", logSide);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateGrassModelBlock(String registryName) {
        String blockPath = Reference.MODID + ":" + "blocks/" + registryName;
        String dirt = blockPath.replace("_grass", "_dirt");
        String grassTop = blockPath + "_top";
        String grassSide = blockPath + "_side";

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        textures.put("particle", dirt);
        textures.put("down", dirt);
        textures.put("up", grassTop);
        textures.put("east", grassSide);
        textures.put("west", grassSide);
        textures.put("north", grassSide);
        textures.put("south", grassSide);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateFurnaceModelBlock(String registryName) {
        String blockPath = Reference.MODID + ":" + "blocks/" + registryName;
        String furnace = blockPath;
        String furnaceFront;

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        if (furnace.endsWith("_on")) {
            furnace = furnace.replace("_on", "");
            furnaceFront = furnace + "_front_on";
        } else {
            furnaceFront = furnace + "_front_off";
        }
        String furnaceTop = furnace + "_top";
        String furnaceSide = furnace + "_side";
        if (registryName.contains("coalstone_furnace")) {
            furnaceTop = furnaceTop.replace("_furnace_top", "");
            furnaceSide = furnaceSide.replace("_furnace_side", "");
        }
        textures.put("particle", furnaceFront);
        textures.put("down", furnaceTop);
        textures.put("up", furnaceTop);
        textures.put("east", furnaceSide);
        textures.put("west", furnaceSide);
        textures.put("south", furnaceSide);
        textures.put("north", furnaceFront);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generatePumpkinModelBlock(String registryName) {
        String blockPath = Reference.MODID + ":" + "blocks/" + registryName;
        String pumpkinTop = blockPath + "_top";
        String pumpkinSide = blockPath + "_side";
        String pumpkinFront = blockPath + "_front";

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        textures.put("particle", pumpkinSide);
        textures.put("down", pumpkinTop);
        textures.put("up", pumpkinTop);
        textures.put("east", pumpkinSide);
        textures.put("west", pumpkinSide);
        textures.put("north", pumpkinFront);
        textures.put("south", pumpkinSide);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateSpawnerModelBlock() {
        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        textures.put("all", Reference.MODID + ":" + "blocks/spawner");
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, "spawner.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateBasicModelBlock(String registryName) {
        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        textures.put("all", Reference.MODID + ":" + "blocks/" + registryName);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateWorkshopBookcaseModelBlock(String registryName) {
        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube");
        Map<String, Object> textures = new HashMap<>();
        textures.put("north", "divinerpg:blocks/workshop_bookcase");
        textures.put("east", "divinerpg:blocks/workshop_bookcase");
        textures.put("south", "divinerpg:blocks/workshop_bookcase");
        textures.put("west", "divinerpg:blocks/workshop_bookcase");
        textures.put("up", "divinerpg:blocks/coalstone");
        textures.put("down", "divinerpg:blocks/coalstone");
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateCrossModelBlock(String registryName) {
        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cross");
        Map<String, Object> textures = new HashMap<>();
        textures.put("cross", Reference.MODID + ":" + "blocks/" + registryName);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateDummyModelBlock(String registryName) {
        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/cube_all");
        Map<String, Object> textures = new HashMap<>();
        textures.put("all", "blocks/debug");
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateStairsModelBlock(String registryName) {
        String innerStairs = registryName.replace("_stairs", "_inner_stairs");
        String outerStairs = registryName.replace("_stairs", "_outer_stairs");
        String material;

        if (registryName.contains("coalstone_stairs")) {
            material = Reference.MODID + ":" + "blocks/coalstone";
        } else {
            material = Reference.MODID + ":" + "blocks/" + registryName.replace("_stairs", "_planks");
        }

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/stairs");
        Map<String, Object> textures = new HashMap<>();
        textures.put("bottom", material);
        textures.put("top", material);
        textures.put("side", material);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("parent", "block/inner_stairs");
        json.put("textures", textures);

        f = new File(MODEL_BLOCK_DIR, innerStairs + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("parent", "block/outer_stairs");
        json.put("textures", textures);

        f = new File(MODEL_BLOCK_DIR, outerStairs + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generatePortalModelBlock(String registryName) {
        String texturePath = Reference.MODID + ":blocks/" + registryName;

        Map<String, Object> json = new HashMap<>();
        Map<String, Object> textures = new HashMap<>();
        textures.put("particle", texturePath);
        textures.put("portal", texturePath);
        json.put("textures", textures);
        List<Map<String, Object>> elements = new ArrayList<>();
        Map<String, Object> element = new HashMap<>();
        element.put("from", new int[] { 6, 0, 0 });
        element.put("to", new int[] { 10, 16, 16 });
        Map<String, Object> faces = new HashMap<>();
        Map<String, Object> direction = new HashMap<>();
        direction.put("uv", new int[] { 0, 0, 16, 16 });
        direction.put("texture", "#portal");
        faces.put("east", direction);
        faces.put("west", direction);
        element.put("faces", faces);
        elements.add(element);
        json.put("elements", elements);

        File f = new File(MODEL_BLOCK_DIR, registryName + "_ew.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("textures", textures);
        elements = new ArrayList<>();
        element = new HashMap<>();
        element.put("from", new int[] { 0, 0, 6 });
        element.put("to", new int[] { 16, 16, 10 });
        faces = new HashMap<>();
        faces.put("north", direction);
        faces.put("south", direction);
        element.put("faces", faces);
        elements.add(element);
        json.put("elements", elements);

        f = new File(MODEL_BLOCK_DIR, registryName + "_ns.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateFireModelBlock() {
        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/fire_floor");
        Map<String, Object> textures = new HashMap<>();
        textures.put("particle", Reference.MODID + ":" + "blocks/blue_fire_0");
        textures.put("fire", Reference.MODID + ":" + "blocks/blue_fire_0");
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, "blue_fire_0.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("parent", "block/fire_floor");
        textures = new HashMap<>();
        textures.put("particle", Reference.MODID + ":" + "blocks/blue_fire_1");
        textures.put("fire", Reference.MODID + ":" + "blocks/blue_fire_1");
        json.put("textures", textures);

        f = new File(MODEL_BLOCK_DIR, "blue_fire_1.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateTorchModelBlock(String registryName) {
        String texturePath = Reference.MODID + ":blocks/" + registryName;

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/torch");
        Map<String, Object> textures = new HashMap<>();
        textures.put("torch", texturePath);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("parent", "block/torch_wall");
        json.put("textures", textures);

        f = new File(MODEL_BLOCK_DIR, registryName + "_wall.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateFenceModelBlock(String registryName) {
        String texturePath = Reference.MODID + ":blocks/" + registryName;

        Map<String, Object> json = new HashMap<>();
        json.put("parent", "block/fence_post");
        Map<String, Object> textures = new HashMap<>();
        textures.put("texture", texturePath);
        json.put("textures", textures);

        File f = new File(MODEL_BLOCK_DIR, registryName + "_post.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("parent", "block/fence_side");
        json.put("textures", textures);

        f = new File(MODEL_BLOCK_DIR, registryName + "_side.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = new HashMap<>();
        json.put("parent", "block/fence_inventory");
        json.put("textures", textures);

        f = new File(MODEL_BLOCK_DIR, registryName + "_inventory.json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateCropModelBlock(String registryName, int maxAge) {
        String texturePath = Reference.MODID + ":blocks/" + registryName;

        for (int age = 0; age <= maxAge; age++) {
            Map<String, Object> json = new HashMap<>();
            Map<String, Object> textures = new HashMap<>();

            json.put("parent", "block/crop");
            textures.put("crop", texturePath + "_" + age);
            json.put("textures", textures);
            File f = new File(MODEL_BLOCK_DIR, registryName + "_stage_" + age + ".json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateSlabModelBlock(String registryName, boolean isDouble) {
        if (!isDouble) {
            String baseName = registryName.replace("_slab", "");
            String texturePath = Reference.MODID + ":blocks/" + baseName + "_planks";

            Map<String, Object> json = new HashMap<>();
            json.put("parent", "block/half_slab");
            Map<String, Object> textures = new HashMap<>();
            textures.put("bottom", texturePath);
            textures.put("top", texturePath);
            textures.put("side", texturePath);
            json.put("textures", textures);

            File f = new File(MODEL_BLOCK_DIR, baseName + "_half_slab.json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }

            json = new HashMap<>();
            json.put("parent", "block/upper_slab");
            json.put("textures", textures);

            f = new File(MODEL_BLOCK_DIR, baseName + "_upper_slab.json");

            try (FileWriter w = new FileWriter(f)) {
                GSON.toJson(json, w);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateLadderModelBlock(String registryName) {
        String texturePath = Reference.MODID + ":blocks/" + registryName;

        Map<String, Object> json = new HashMap<>();
        json.put("ambientocclusion", false);
        Map<String, Object> textures = new HashMap<>();
        textures.put("particle", texturePath);
        textures.put("texture", texturePath);
        json.put("textures", textures);
        List<Map<String, Object>> elements = new ArrayList<>();
        Map<String, Object> element = new HashMap<>();
        element.put("from", new float[] { 0, 0, 15.2f });
        element.put("to", new float[] { 16, 16, 15.2f });
        element.put("shade", false);
        Map<String, Object> faces = new HashMap<>();
        Map<String, Object> direction = new HashMap<>();
        direction.put("uv", new int[] { 0, 0, 16, 16 });
        direction.put("texture", "#texture");
        faces.put("north", direction);
        faces.put("south", direction);
        element.put("faces", faces);
        elements.add(element);
        json.put("elements", elements);

        File f = new File(MODEL_BLOCK_DIR, registryName + ".json");

        try (FileWriter w = new FileWriter(f)) {
            GSON.toJson(json, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
