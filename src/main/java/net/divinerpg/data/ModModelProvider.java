package net.divinerpg.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.divinerpg.registries.BlockRegistry;
import net.divinerpg.registries.DivineRegistries;
import net.divinerpg.registries.ItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static net.divinerpg.DivineRPG.MODID;
import static net.minecraft.client.data.models.BlockModelGenerators.*;
import static net.minecraft.client.data.models.model.ModelTemplates.*;

public class ModModelProvider extends ModelProvider {
    private final Set<Block> handledBlocks = new HashSet<>();
    private final Set<Item> registeredItems = new HashSet<>();
    public ModModelProvider(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators gen, ItemModelGenerators itemModels) {
        registerStairs(gen, BlockRegistry.cobbledFrozenStairs.get(), BlockRegistry.cobbledFrozenStone.get());
        registerStairs(gen, BlockRegistry.cobbledScorchaltStairs.get(), BlockRegistry.cobbledScorchalt.get());

        registerSlab(gen, BlockRegistry.cobbledFrozenSlab.get(), BlockRegistry.cobbledFrozenStone.get());
        registerSlab(gen, BlockRegistry.cobbledScorchaltSlab.get(), BlockRegistry.cobbledScorchalt.get());

        registerWall(gen, BlockRegistry.cobbledFrozenWall.get(), BlockRegistry.cobbledFrozenStone.get());
        registerWall(gen, BlockRegistry.cobbledScorchaltWall.get(), BlockRegistry.cobbledScorchalt.get());

        registerWoodSet(gen, BlockRegistry.shiverspineLog.get(), BlockRegistry.shiverspineWood.get(), BlockRegistry.strippedShiverspineLog.get(), BlockRegistry.strippedShiverspineWood.get(), BlockRegistry.shiverspinePlanks.get(), BlockRegistry.shiverspineFence.get(), BlockRegistry.shiverspineFenceGate.get(), BlockRegistry.shiverspineButton.get(), BlockRegistry.shiverspineStairs.get(), BlockRegistry.shiverspinePressurePlate.get(), BlockRegistry.shiverspineSlab.get(), BlockRegistry.shiverspineDoor.get(), BlockRegistry.shiverspineTrapdoor.get(), BlockRegistry.brittleLeaves.get(), BlockRegistry.shiverspineSapling.get());
        registerWoodSet(gen, BlockRegistry.auroraoakLog.get(), BlockRegistry.auroraoakWood.get(), BlockRegistry.strippedAuroraoakLog.get(), BlockRegistry.strippedAuroraoakWood.get(), BlockRegistry.auroraoakPlanks.get(), BlockRegistry.auroraoakFence.get(), BlockRegistry.auroraoakFenceGate.get(), BlockRegistry.auroraoakButton.get(), BlockRegistry.auroraoakStairs.get(), BlockRegistry.auroraoakPressurePlate.get(), BlockRegistry.auroraoakSlab.get(), BlockRegistry.auroraoakDoor.get(), BlockRegistry.auroraoakTrapdoor.get(), BlockRegistry.auroraoakLeaves.get(), BlockRegistry.auroraoakSapling.get());
        registerWoodSet(gen, BlockRegistry.cozybarkLog.get(), BlockRegistry.cozybarkWood.get(), BlockRegistry.strippedCozybarkLog.get(), BlockRegistry.strippedCozybarkWood.get(), BlockRegistry.cozybarkPlanks.get(), BlockRegistry.cozybarkFence.get(), BlockRegistry.cozybarkFenceGate.get(), BlockRegistry.cozybarkButton.get(), BlockRegistry.cozybarkStairs.get(), BlockRegistry.cozybarkPressurePlate.get(), BlockRegistry.cozybarkSlab.get(), BlockRegistry.cozybarkDoor.get(), BlockRegistry.cozybarkTrapdoor.get(), BlockRegistry.cozybarkLeaves.get(), BlockRegistry.cozybarkSapling.get());
        registerWoodSet(gen, BlockRegistry.streamleafLog.get(), BlockRegistry.streamleafWood.get(), BlockRegistry.strippedStreamleafLog.get(), BlockRegistry.strippedStreamleafWood.get(), BlockRegistry.streamleafPlanks.get(), BlockRegistry.streamleafFence.get(), BlockRegistry.streamleafFenceGate.get(), BlockRegistry.streamleafButton.get(), BlockRegistry.streamleafStairs.get(), BlockRegistry.streamleafPressurePlate.get(), BlockRegistry.streamleafSlab.get(), BlockRegistry.streamleafDoor.get(), BlockRegistry.streamleafTrapdoor.get(), BlockRegistry.streamleafLeaves.get(), BlockRegistry.streamleafSapling.get());
        registerWoodSet(gen, BlockRegistry.divineLog.get(), BlockRegistry.divineWood.get(), BlockRegistry.strippedDivineLog.get(), BlockRegistry.strippedDivineWood.get(), BlockRegistry.divinePlanks.get(), BlockRegistry.divineFence.get(), BlockRegistry.divineFenceGate.get(), BlockRegistry.divineButton.get(), BlockRegistry.divineStairs.get(), BlockRegistry.divinePressurePlate.get(), BlockRegistry.divineSlab.get(), BlockRegistry.divineDoor.get(), BlockRegistry.divineTrapdoor.get(), BlockRegistry.divineLeaves.get(), BlockRegistry.divineSapling.get());
        registerWoodSet(gen, null, null, null, null, BlockRegistry.plankDesign.get(), null, null, null, BlockRegistry.stairDesign.get(), null, BlockRegistry.slabDesign.get(), null, null, null, null);
        registerWoodSet(gen, BlockRegistry.eucalyptusLog.get(), BlockRegistry.eucalyptusWood.get(), BlockRegistry.strippedEucalyptusLog.get(), BlockRegistry.strippedEucalyptusWood.get(), BlockRegistry.eucalyptusPlanks.get(), BlockRegistry.eucalyptusFence.get(), BlockRegistry.eucalyptusFenceGate.get(), BlockRegistry.eucalyptusButton.get(), BlockRegistry.eucalyptusStairs.get(), BlockRegistry.eucalyptusPressurePlate.get(), BlockRegistry.eucalyptusSlab.get(), BlockRegistry.eucalyptusDoor.get(), BlockRegistry.eucalyptusTrapdoor.get(), null, null);

        registerStoneSet(gen, BlockRegistry.frozenStone.get(), BlockRegistry.frozenStairs.get(), BlockRegistry.frozenSlab.get(), null, BlockRegistry.frozenButton.get(), BlockRegistry.frozenPressurePlate.get(), BlockRegistry.frozenGrass.get(), BlockRegistry.frozenDirt.get());
        registerStoneSet(gen, BlockRegistry.cobaltite.get(), BlockRegistry.cobaltiteStairs.get(), BlockRegistry.cobaltiteSlab.get(), BlockRegistry.cobaltiteWall.get(), BlockRegistry.cobaltiteButton.get(), BlockRegistry.cobaltitePressurePlate.get(), null, null);
        registerStoneSet(gen, BlockRegistry.arcaniteStone.get(), BlockRegistry.arcaniteStairs.get(), BlockRegistry.arcaniteSlab.get(), BlockRegistry.arcaniteWall.get(), null, null, BlockRegistry.arcaniteGrass.get(), BlockRegistry.arcaniteDirt.get());
        registerStoneSet(gen, BlockRegistry.coalstone.get(), BlockRegistry.coalstoneStairs.get(), BlockRegistry.coalstoneSlab.get(), BlockRegistry.coalstoneWall.get(), null, null, null, null);
        registerStoneSet(gen, BlockRegistry.twilightStone.get(), BlockRegistry.twilightStairs.get(), BlockRegistry.twilightSlab.get(), BlockRegistry.twilightWall.get(), null, null, null, null);
        registerStoneSet(gen, BlockRegistry.scorchalt.get(), BlockRegistry.scorchaltStairs.get(), BlockRegistry.scorchaltSlab.get(), BlockRegistry.scorchaltWall.get(), null, null, BlockRegistry.scorchedGrass.get(), BlockRegistry.scorchedDirt.get());
        registerStoneSet(gen, BlockRegistry.rayStone.get(), BlockRegistry.rayStoneStairs.get(), BlockRegistry.rayStoneSlab.get(), BlockRegistry.rayStoneWall.get(), null, null, null, null);

        registerArcanaPortalFrame(gen, BlockRegistry.arcanaPortalFrame.get());

        for (var entry : DivineRegistries.ITEMS.getEntries()) {
            Item item = entry.get();
            if (registeredItems.contains(item)) continue;
            if (!(item instanceof BlockItem)) {
                String path = BuiltInRegistries.ITEM.getKey(item).getPath();
                if (path.contains("_sword") || path.contains("_pickaxe") || path.contains("_axe") || path.contains("_shovel") || path.contains("_hoe") || path.contains("_shickaxe") || path.contains("_maul") || path.contains("_backsword") || path.contains("_blade") || path.contains("_dagger") || path.contains("_saber") || path.contains("_hammer") || path.contains("_claw") || path.contains("_knife") || path.contains("_trident") || path.contains("aquaton") || path.contains("_stabber") || path.contains("_rapier") || path.contains("death_bringer") || path.contains("flaming_fury") || path.contains("_sabre") || path.contains("icicle_bane") || path.contains("enderice") || path.contains("_sandslash") || path.contains("_snowslash") || path.contains("everlight") || path.contains("_rockmaul") || path.contains("everbright") || path.contains("_anchor") || path.contains("sound_of_") || path.contains("_slicer") || path.contains("_disk") || path.contains("_dissipator") || path.contains("firefly") || path.contains("meriks_missile") || path.contains("scythe") || path.contains("_staff") || path.contains("captains_sparkler") || path.contains("starlight") || path.contains("meteor_mash") || path.contains("evernight") || path.contains("_phaser") || path.contains("_cannon") || path.contains("_blaster") || path.contains("eversight") || path.contains("palavence") || path.contains("massivence") || path.contains("frossivence") || path.contains("divine_accumulator") || path.contains("ender_scepter") || path.contains("staff_of_enrichment") || path.contains("arcanium_attractor") || path.contains("arcanium_reflector") || path.contains("terran_shifter")) {
                    itemModels.generateFlatItem(item, FLAT_HANDHELD_ITEM);
                } else {
                    itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
                }
                registeredItems.add(item);
            }
        }

        for (DeferredHolder<Block, ? extends Block> entry : DivineRegistries.BLOCKS.getEntries()) {
            Block block = entry.get();
            if (handledBlocks.contains(block)) continue;
            gen.createTrivialCube(block);
        }
    }

    private void registerShieldModel(ItemModelGenerators itemModels, Item shield) {
        registeredItems.add(shield);
        itemModels.generateShield(shield);
    }

    private void registerWoodSet(BlockModelGenerators gen, Block log, Block wood, Block strippedLog, Block strippedWood, Block planks, Block fence, Block fenceGate, Block btn, Block stairs, Block pressurePlate, Block slab, Block door, Block trapDoor, Block leaves, Block sapling) {

        if (log != null) registerLog(gen, log);
        if (wood != null && log != null) registerWood(gen, wood, log);
        if (strippedLog != null) registerStrippedLog(gen, strippedLog);
        if (strippedWood != null && strippedLog != null) registerWood(gen, strippedWood, strippedLog);
        if (fence != null) registerFence(gen, fence, planks);
        if (fenceGate != null) registerFenceGate(gen, fenceGate, planks);
        if (btn != null) registerButton(gen, btn, planks);
        if (stairs != null) registerStairs(gen, stairs, planks);
        if (pressurePlate != null) registerPressurePlate(gen, pressurePlate, planks);
        if (slab != null) registerSlab(gen, slab, planks);
        if (door != null) registerDoor(gen, door, planks);
        if (trapDoor != null) registerTrapdoor(gen, trapDoor, planks);
        if (leaves != null) registerLeaves(gen, leaves);
        if (sapling != null) registerSapling(gen, sapling);
    }

    private void registerStoneSet(BlockModelGenerators gen, Block base, Block stairs, Block slab, Block wall, Block btn, Block plate, Block grass, Block dirt) {
        if (stairs != null) registerStairs(gen, stairs, base);
        if (slab != null) registerSlab(gen, slab, base);
        if (wall != null) registerWall(gen, wall, base);
        if (btn != null) registerButton(gen, btn, base);
        if (plate != null) registerPressurePlate(gen, plate, base);
        if (grass != null && dirt != null) registerGrass(gen, grass, dirt);
    }

    private void registerStairs(BlockModelGenerators gen, Block stairs, Block base) {
        if (handledBlocks.contains(stairs)) return;
        handledBlocks.add(stairs);
        TextureMapping mapping = TextureMapping.cube(base);
        Identifier inner = STAIRS_INNER.create(stairs, mapping, gen.modelOutput);
        Identifier straight = STAIRS_STRAIGHT.create(stairs, mapping, gen.modelOutput);
        Identifier outer = STAIRS_OUTER.create(stairs, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createStairs(stairs, plainVariant(inner), plainVariant(straight), plainVariant(outer)));
        gen.registerSimpleItemModel(stairs.asItem(), straight);
        registeredItems.add(stairs.asItem());
    }

    private void registerGrass(BlockModelGenerators gen, Block block, Block baseDirt) {
        handledBlocks.add(block);
        TextureMapping mapping = new TextureMapping().put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseDirt));

        Identifier modelId = CUBE_BOTTOM_TOP.create(block, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(block, plainVariant(modelId)));

        gen.registerSimpleItemModel(block.asItem(), modelId);
        registeredItems.add(block.asItem());
    }

    private void registerSlab(BlockModelGenerators gen, Block slab, Block base) {
        if (handledBlocks.contains(slab)) return;
        handledBlocks.add(slab);
        TextureMapping textures = TextureMapping.cube(base);
        TextureMapping slabTextures = TextureMapping.column(TextureMapping.getBlockTexture(base, ""), textures.get(TextureSlot.TOP));
        Identifier bottom = SLAB_BOTTOM.create(slab, slabTextures, gen.modelOutput);
        Identifier top = SLAB_TOP.create(slab, slabTextures, gen.modelOutput);
        Identifier doubleSlab = CUBE_COLUMN.createWithOverride(slab, "_double", slabTextures, gen.modelOutput);
        gen.blockStateOutput.accept(createSlab(slab, plainVariant(bottom), plainVariant(top), plainVariant(doubleSlab)));
        gen.registerSimpleItemModel(slab.asItem(), bottom);
        registeredItems.add(slab.asItem());
    }

    private void registerSlabCustomSide(BlockModelGenerators gen, Block slab, Block base) {
        if (handledBlocks.contains(slab)) return;
        handledBlocks.add(slab);

        TextureMapping textures = TextureMapping.cube(base);
        TextureMapping slabTextures = TextureMapping.column(TextureMapping.getBlockTexture(slab, "_side"), textures.get(TextureSlot.TOP));
        var bottom = plainVariant(SLAB_BOTTOM.create(slab, slabTextures, gen.modelOutput));
        var top = plainVariant(SLAB_TOP.create(slab, slabTextures, gen.modelOutput));
        var doubleSlab = plainVariant(CUBE_COLUMN.createWithOverride(slab, "_double", slabTextures, gen.modelOutput));
        gen.blockStateOutput.accept(createSlab(slab, bottom, top, doubleSlab));
    }

    private void registerWall(BlockModelGenerators gen, Block wall, Block base) {
        handledBlocks.add(wall);

        TextureMapping mapping = TextureMapping.columnWithWall(base);
        Identifier post = WALL_POST.create(wall, mapping, gen.modelOutput);
        Identifier low = WALL_LOW_SIDE.create(wall, mapping, gen.modelOutput);
        Identifier tall = WALL_TALL_SIDE.create(wall, mapping, gen.modelOutput);

        gen.blockStateOutput.accept(createWall(wall, plainVariant(post), plainVariant(low), plainVariant(tall)));

        Identifier inventoryModel = WALL_INVENTORY.create(wall, mapping, gen.modelOutput);
        gen.registerSimpleItemModel(wall.asItem(), inventoryModel);
        registeredItems.add(wall.asItem());
    }

    private void registerButton(BlockModelGenerators gen, Block button, Block base) {
        if (handledBlocks.contains(button)) return;
        handledBlocks.add(button);
        TextureMapping mapping = TextureMapping.cube(base);
        var normalModel = BUTTON.create(button, mapping, gen.modelOutput);
        var pressedModel = BUTTON_PRESSED.create(button, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createButton(button, plainVariant(normalModel), plainVariant(pressedModel)));
        Identifier inventoryModel = BUTTON_INVENTORY.create(button, mapping, gen.modelOutput);
        gen.registerSimpleItemModel(button.asItem(), inventoryModel);
        registeredItems.add(button.asItem());
    }

    private void registerPressurePlate(BlockModelGenerators gen, Block block, Block base) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        TextureMapping mapping = TextureMapping.cube(base);
        Identifier off = PRESSURE_PLATE_UP.create(block, mapping, gen.modelOutput);
        Identifier on = PRESSURE_PLATE_DOWN.create(block, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createPressurePlate(block, plainVariant(off), plainVariant(on)));
        gen.registerSimpleItemModel(block.asItem(), off);
        registeredItems.add(block.asItem());
    }

    private void registerFence(BlockModelGenerators gen, Block fence, Block basePlanks) {
        if (handledBlocks.contains(fence)) return;
        handledBlocks.add(fence);
        TextureMapping mapping = TextureMapping.cube(basePlanks);
        var post = ModelTemplates.FENCE_POST.create(fence, mapping, gen.modelOutput);
        var side = ModelTemplates.FENCE_SIDE.create(fence, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createFence(fence, plainVariant(post), plainVariant(side)));
        Identifier inventoryModel = ModelTemplates.FENCE_INVENTORY.create(fence, mapping, gen.modelOutput);
        gen.registerSimpleItemModel(fence.asItem(), inventoryModel);
        registeredItems.add(fence.asItem());
    }

    private void registerFenceGate(BlockModelGenerators gen, Block fenceGate, Block basePlanks) {
        if (handledBlocks.contains(fenceGate)) return;
        handledBlocks.add(fenceGate);

        TextureMapping mapping = TextureMapping.cube(basePlanks);
        Identifier open = FENCE_GATE_OPEN.create(fenceGate, mapping, gen.modelOutput);
        Identifier closed = FENCE_GATE_CLOSED.create(fenceGate, mapping, gen.modelOutput);
        Identifier openWall = FENCE_GATE_WALL_OPEN.create(fenceGate, mapping, gen.modelOutput);
        Identifier closedWall = FENCE_GATE_WALL_CLOSED.create(fenceGate, mapping, gen.modelOutput);

        gen.blockStateOutput.accept(createFenceGate(fenceGate, plainVariant(open), plainVariant(closed), plainVariant(openWall), plainVariant(closedWall), false));

        gen.registerSimpleItemModel(fenceGate.asItem(), closed);
        registeredItems.add(fenceGate.asItem());
    }

    private void registerArcanaPortalFrame(BlockModelGenerators gen, Block block) {
        handledBlocks.add(block);
        Identifier modelId = ModelLocationUtils.getModelLocation(block);
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "block/block");

            JsonObject textures = new JsonObject();
            textures.addProperty("particle", "divinerpg:block/arcana_portal_frame_top");
            textures.addProperty("top", "divinerpg:block/arcana_portal_frame_top");
            textures.addProperty("side", "divinerpg:block/arcana_portal_frame_side");
            textures.addProperty("outer", "divinerpg:block/arcana_portal_frame_edge");
            model.add("textures", textures);
            JsonArray elements = new JsonArray();
            JsonObject element = new JsonObject();
            JsonArray from = new JsonArray(); from.add(0); from.add(0); from.add(0);
            JsonArray to = new JsonArray(); to.add(16); to.add(13); to.add(16);
            element.add("from", from);
            element.add("to", to);
            JsonObject faces = new JsonObject();
            faces.add("east", createFace(0, 3, 16, 16, "east", "#side"));
            faces.add("south", createFace(0, 3, 16, 16, "south", "#side"));
            faces.add("north", createFace(0, 3, 16, 16, "north", "#outer"));
            faces.add("west", createFace(0, 3, 16, 16, "west", "#side"));
            faces.add("up", createFace(0, 0, 16, 16, null, "#top"));
            faces.add("down", createFace(0, 0, 16, 16, "down", "#top"));
            element.add("faces", faces);
            elements.add(element);
            model.add("elements", elements);

            return model;
        });

        gen.blockStateOutput.accept(createSimpleBlock(block, plainVariant(modelId)));
        gen.registerSimpleItemModel(block.asItem(), modelId);
        registeredItems.add(block.asItem());
    }

    private JsonObject createFace(int x1, int y1, int x2, int y2, String cull, String tex) {
        JsonObject face = new JsonObject();
        JsonArray uv = new JsonArray(); uv.add(x1); uv.add(y1); uv.add(x2); uv.add(y2);
        face.add("uv", uv);
        if (cull != null) face.addProperty("cullface", cull);
        face.addProperty("texture", tex);
        return face;
    }

    private void registerLog(BlockModelGenerators gen, Block log) {
        if (handledBlocks.contains(log)) return;
        handledBlocks.add(log);
        TextureMapping mapping = TextureMapping.column(TextureMapping.getBlockTexture(log, "_side"), TextureMapping.getBlockTexture(log, "_top"));
        createRotatedPillarWithHorizontalVariant(log, gen, m -> ModelTemplates.CUBE_COLUMN.create(log, mapping, gen.modelOutput), m -> ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(log, mapping, gen.modelOutput));
        gen.registerSimpleItemModel(log.asItem(), ModelLocationUtils.getModelLocation(log));
        registeredItems.add(log.asItem());
    }

    public void createRotatedPillarWithHorizontalVariant(Block block, BlockModelGenerators gen, Function<Block, Identifier> verticalModel, Function<Block, Identifier> horizontalModel) {
        MultiVariant model = plainVariant(verticalModel.apply(block));
        MultiVariant hModel = plainVariant(horizontalModel.apply(block));
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.AXIS).select(Direction.Axis.Y, model).select(Direction.Axis.Z, hModel.with(X_ROT_90)).select(Direction.Axis.X, hModel.with(X_ROT_90).with(Y_ROT_90))));
    }

    public void createRotatedPillarWithHorizontalVariant(BlockModelGenerators gen, Block block , TextureMapping mapping) {
        Identifier verticalId = ModelTemplates.CUBE_COLUMN.create(block, mapping, gen.modelOutput);
        Identifier horizontalId = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, mapping, gen.modelOutput);

        MultiVariant model = plainVariant(verticalId);
        MultiVariant hModel = plainVariant(horizontalId);

        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.AXIS)
                        .select(Direction.Axis.Y, model)
                        .select(Direction.Axis.Z, hModel.with(X_ROT_90))
                        .select(Direction.Axis.X, hModel.with(X_ROT_90).with(Y_ROT_90))));
    }

    private void registerDoor(BlockModelGenerators gen, Block door, Block basePlanks) {
        if (handledBlocks.contains(door)) return;
        handledBlocks.add(door);
        Material topMat = new Material(Identifier.fromNamespaceAndPath(MODID, "block/" + BuiltInRegistries.BLOCK.getKey(door).getPath() + "_top"));
        Material bottomMat = new Material(Identifier.fromNamespaceAndPath(MODID, "block/" + BuiltInRegistries.BLOCK.getKey(door).getPath() + "_bottom"));
        TextureMapping mapping = new TextureMapping().put(TextureSlot.TOP, topMat).put(TextureSlot.BOTTOM, bottomMat);
        Identifier bLeft = DOOR_BOTTOM_LEFT.create(door, mapping, gen.modelOutput);
        Identifier bLeftOpen = DOOR_BOTTOM_LEFT_OPEN.create(door, mapping, gen.modelOutput);
        Identifier bRight = DOOR_BOTTOM_RIGHT.create(door, mapping, gen.modelOutput);
        Identifier bRightOpen = DOOR_BOTTOM_RIGHT_OPEN.create(door, mapping, gen.modelOutput);
        Identifier tLeft = DOOR_TOP_LEFT.create(door, mapping, gen.modelOutput);
        Identifier tLeftOpen = DOOR_TOP_LEFT_OPEN.create(door, mapping, gen.modelOutput);
        Identifier tRight = DOOR_TOP_RIGHT.create(door, mapping, gen.modelOutput);
        Identifier tRightOpen = DOOR_TOP_RIGHT_OPEN.create(door, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createDoor(door, plainVariant(bLeft), plainVariant(bLeftOpen), plainVariant(bRight), plainVariant(bRightOpen), plainVariant(tLeft), plainVariant(tLeftOpen), plainVariant(tRight), plainVariant(tRightOpen)));
        TextureMapping itemMapping = new TextureMapping().put(TextureSlot.LAYER0, TextureMapping.getItemTexture(door.asItem()));
        Identifier itemModel = ModelTemplates.FLAT_ITEM.create(door.asItem(), itemMapping, gen.modelOutput);
        gen.registerSimpleItemModel(door.asItem(), itemModel);
        registeredItems.add(door.asItem());
    }

    private void registerTrapdoor(BlockModelGenerators gen, Block trapdoor, Block basePlanks) {
        if (handledBlocks.contains(trapdoor)) return;
        handledBlocks.add(trapdoor);
        TextureMapping mapping = new TextureMapping().put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(trapdoor));
        Identifier bottom = TRAPDOOR_BOTTOM.create(trapdoor, mapping, gen.modelOutput);
        Identifier top = TRAPDOOR_TOP.create(trapdoor, mapping, gen.modelOutput);
        Identifier open = TRAPDOOR_OPEN.create(trapdoor, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createTrapdoor(trapdoor, plainVariant(top), plainVariant(bottom), plainVariant(open)));
        gen.registerSimpleItemModel(trapdoor.asItem(), bottom);
        registeredItems.add(trapdoor.asItem());
    }

    private void registerWood(BlockModelGenerators gen, Block wood, Block logReference) {
        if (handledBlocks.contains(wood)) return;
        handledBlocks.add(wood);
        Identifier logId = BuiltInRegistries.BLOCK.getKey(logReference);
        Material sideTexture = new Material(logId.withPath(path -> "block/" + path + "_side"));
        TextureMapping mapping = new TextureMapping().put(TextureSlot.ALL, sideTexture);
        Identifier modelId = ModelTemplates.CUBE_ALL.create(wood, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(wood, plainVariant(modelId)));
        gen.registerSimpleItemModel(wood.asItem(), modelId);
        registeredItems.add(wood.asItem());
    }

    private void registerStrippedLog(BlockModelGenerators gen, Block log) {
        if (handledBlocks.contains(log)) return;
        handledBlocks.add(log);
        TextureMapping mapping = TextureMapping.column(log);
        Identifier vertical = ModelTemplates.CUBE_COLUMN.create(log, mapping, gen.modelOutput);
        Identifier horizontal = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(log, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(log).with(PropertyDispatch.initial(BlockStateProperties.AXIS).select(Direction.Axis.Y, plainVariant(vertical)).select(Direction.Axis.Z, plainVariant(horizontal).with(X_ROT_90)).select(Direction.Axis.X, plainVariant(horizontal).with(X_ROT_90).with(Y_ROT_90))));
        gen.registerSimpleItemModel(log.asItem(), vertical);
        registeredItems.add(log.asItem());
    }

    private void registerLeaves(BlockModelGenerators gen, Block leaves) {
        if (handledBlocks.contains(leaves)) return;
        handledBlocks.add(leaves);
        TextureMapping mapping = TextureMapping.cube(leaves);
        Identifier modelId = ModelTemplates.LEAVES.create(leaves, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(leaves, plainVariant(modelId)));
        gen.registerSimpleItemModel(leaves.asItem(), modelId);
        registeredItems.add(leaves.asItem());
    }

    private void registerSapling(BlockModelGenerators gen, Block sapling) {
        if (handledBlocks.contains(sapling)) return;
        handledBlocks.add(sapling);
        TextureMapping mapping = TextureMapping.cross(sapling);
        Identifier modelId = ModelTemplates.CROSS.create(sapling, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(sapling, plainVariant(modelId)));
        TextureMapping itemMapping = TextureMapping.layer0(sapling);
        Identifier itemModelId = ModelTemplates.FLAT_ITEM.create(sapling.asItem(), itemMapping, gen.modelOutput);
        gen.registerSimpleItemModel(sapling.asItem(), itemModelId);
        registeredItems.add(sapling.asItem());
    }
}