package divinerpg.data;

import com.google.gson.*;
import com.mojang.math.Transformation;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModDoubleFlower;
import divinerpg.blocks.base.BlockModDoublePlant;
import divinerpg.blocks.base.BlockModFlower;
import divinerpg.blocks.base.BlockModGrass;
import divinerpg.blocks.twilight.BlockBrambles;
import divinerpg.client.renders.item.ArcaniumExtractorItemRenderer;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.SpecialModelWrapper;
import net.minecraft.client.resources.model.cuboid.ItemModelGenerator;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.joml.Matrix4f;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.client.data.models.BlockModelGenerators.*;
import static net.minecraft.client.data.models.model.ModelTemplates.*;

public class ModModelProvider extends ModelProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Set<Block> handledBlocks = new HashSet<>();
    private final Set<Item> registeredItems = new HashSet<>();
    private final PackOutput packOutput;

    public ModModelProvider(PackOutput output) {
        super(output, MODID);
        this.packOutput = output;
    }
    @Override
    protected void registerModels(BlockModelGenerators gen, ItemModelGenerators itemModels) {
        registerArcanaPortalFrame(gen, BlockRegistry.arcanaPortalFrame.get());
        registerArcanaPortal(gen, BlockRegistry.arcanaPortal.get());
        registerArcaniumExtractor(gen, BlockRegistry.arcaniumExtractor.get());
        registerStairs(gen, BlockRegistry.stairDesign.get(), BlockRegistry.plankDesign.get());
        registerSlab(gen, BlockRegistry.slabDesign.get(), BlockRegistry.plankDesign.get());
        registerSlab(gen, BlockRegistry.cobbledScorchaltSlab.get(), BlockRegistry.cobbledScorchalt.get());
        registerCarpet(gen, BlockRegistry.rainbowWoolCarpet.get(), BlockRegistry.rainbowWool.get());
        for (var entry : DivineRegistries.ITEMS.getEntries()) {
            Item item = entry.get();
            if (registeredItems.contains(item)) continue;
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            if (path.equals("winterberry")) {
                itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
                registeredItems.add(item);
                continue;
            }
            if (!(item instanceof BlockItem)) {
                if (isHandheldTool(path)) {
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
            String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
            try {
                if (block == BlockRegistry.arcanaPortalFrame.get()) {
                    registerArcanaPortalFrame(gen, block);
                }
                else if (block instanceof StairBlock stair) {
                    Block baseBlock = resolveBaseBlock(stair, "_stairs");
                    registerStairs(gen, stair, baseBlock);
                }
                else if (block instanceof SlabBlock slab) {
                    Block baseBlock = resolveBaseBlock(slab, "_slab");
                    registerSlab(gen, slab, baseBlock);
                }
                else if (block instanceof WallBlock wall) {
                    Block baseBlock = resolveBaseBlock(wall, path.endsWith("s") ? "_walls" : "_wall");
                    registerWall(gen, wall, baseBlock);
                }
                else if (path.endsWith("_wall") || path.endsWith("_walls")) {
                    registerStandardBlockWithBreakable(gen, block);
                }
                else if (block instanceof ButtonBlock button) {
                    Block baseBlock = resolveBaseBlock(button, "_button");
                    registerButton(gen, button, baseBlock);
                }
                else if (block instanceof PressurePlateBlock plate) {
                    Block baseBlock = resolveBaseBlock(plate, "_pressure_plate");
                    registerPressurePlate(gen, plate, baseBlock);
                }
                else if (block instanceof FenceBlock fence) {
                    Block baseBlock = resolveBaseBlock(fence, "_fence");
                    registerFence(gen, fence, baseBlock);
                }
                else if (block instanceof FenceGateBlock gate) {
                    Block baseBlock = resolveBaseBlock(gate, "_fence_gate");
                    registerFenceGate(gen, gate, baseBlock);
                }
                else if (block instanceof DoorBlock door) {
                    Block baseBlock = resolveBaseBlock(door, "_door");
                    registerDoor(gen, door, baseBlock);
                }
                else if (block instanceof TrapDoorBlock trapdoor) {
                    registerTrapdoor(gen, trapdoor);
                }
                else if (block instanceof LeavesBlock leaves) {
                    registerLeaves(gen, leaves);
                }
                else if (block instanceof SaplingBlock sapling) {
                    registerCrossBlock(gen, sapling);
                }
                else if (block instanceof BlockModFlower flower) {
                    registerCrossBlock(gen, flower);
                }
                else if (block instanceof BlockModGrass grass) {
                    registerCrossBlock(gen, grass);
                }
                else if (block instanceof BlockModDoublePlant plant) {
                    registerDoubleCrossBlock(gen, plant);
                }
                else if (block instanceof BlockModDoubleFlower flower) {
                    registerDoubleCrossBlock(gen, flower);
                }
                else if (block instanceof BlockBrambles brambles) {
                    registerDoubleCrossBlock(gen, brambles);
                }
                else if (block == BlockRegistry.arcaniteTubes.get()) {
                    registerArcaniteTubes(gen, BlockRegistry.arcaniteTubes.get());
                }
                else if (block == BlockRegistry.arcaniteLadder.get()) {
                    registerCustomStepBlock(gen, block, MODID + ":block/arcanite_ladder");
                }
                else if (block instanceof LadderBlock ladder) {
                    registerLadder(gen, ladder);
                }
                else if (block instanceof RotatedPillarBlock pillar) {
                    if (path.endsWith("_log") || path.endsWith("_wood") || path.endsWith("_stem") || path.endsWith("_hyphae")) {
                        if (path.startsWith("stripped_")) {
                            registerStrippedLog(gen, pillar);
                        } else if (path.endsWith("_wood") || path.endsWith("_hyphae")) {
                            String baseLogName = path.replace("_wood", "_log").replace("_hyphae", "_stem");
                            Optional<Holder.Reference<Block>> base = BuiltInRegistries.BLOCK.get(Identifier.fromNamespaceAndPath(MODID, baseLogName));
                            registerWood(gen, pillar, base.map(Holder.Reference::value).orElse(pillar));
                        } else {
                            registerLog(gen, pillar);
                        }
                    } else {
                        registerStandardBlockWithBreakable(gen, pillar);
                    }
                }
                else if (block instanceof TransparentBlock glass) {
                    registerGlassBlock(gen, glass);
                }
                else if (block instanceof GrassBlock grass) {
                    Block baseDirt = resolveBaseBlock(grass, "_grass");
                    registerGrass(gen, grass, baseDirt);
                }
                else if (block instanceof TallFlowerBlock || block instanceof FlowerBlock || block instanceof BushBlock) {
                    registerCrossBlock(gen, block);
                }
                else if (block == BlockRegistry.inserter.get()) {
                    registerInserter(gen, block);
                }
                else if (block instanceof BedBlock bedBlock) {
                    registerBed(gen, bedBlock);
                }
                else if (path.endsWith("_lamp") || path.endsWith("_furnace") || path.endsWith("_spawner") || path.endsWith("_portal") || path.endsWith("_rift")) {
                    gen.createTrivialCube(block);
                    handledBlocks.add(block);
                    if (block.asItem() != Items.AIR) {
                        gen.registerSimpleItemModel(block.asItem(), ModelLocationUtils.getModelLocation(block));
                        registeredItems.add(block.asItem());
                    }
                }
                else {
                    registerStandardBlockWithBreakable(gen, block);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed generating models for " + BuiltInRegistries.BLOCK.getKey(block), e);
            }
        }
    }

    private Block resolveBaseBlock(Block block, String variantSuffix) {
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        String cleanPath = path.replace(variantSuffix + "_breakable", "").replace("_breakable" + variantSuffix, "").replace(variantSuffix, "").replace("_breakable", "");
        if (block instanceof GrassBlock || path.endsWith("_grass")) {
            Identifier dirtId = Identifier.fromNamespaceAndPath(MODID, cleanPath + "_dirt");
            if (BuiltInRegistries.BLOCK.containsKey(dirtId)) {
                return BuiltInRegistries.BLOCK.get(dirtId).get().value();
            }
        }
        Identifier directId = Identifier.fromNamespaceAndPath(MODID, cleanPath);
        if (BuiltInRegistries.BLOCK.containsKey(directId)) {
            return BuiltInRegistries.BLOCK.get(directId).get().value();
        }
        Identifier plankId = Identifier.fromNamespaceAndPath(MODID, cleanPath + "_planks");
        if (BuiltInRegistries.BLOCK.containsKey(plankId)) {
            return BuiltInRegistries.BLOCK.get(plankId).get().value();
        }
        String[] commonSuffixes = {"s", "_bricks", "_stone", "_block"};
        for (String s : commonSuffixes) {
            Identifier variantId = Identifier.fromNamespaceAndPath(MODID, cleanPath + s);
            if (BuiltInRegistries.BLOCK.containsKey(variantId)) {
                return BuiltInRegistries.BLOCK.get(variantId).get().value();
            }
        }
        return block;
    }

    private TextureMapping getCleanTextureMapping(Block base) {
        String basepath = BuiltInRegistries.BLOCK.getKey(base).getPath();
        basepath = basepath.replace("_breakable", "").replace("_stairs", "").replace("_slab", "").replace("_wall", "");
        Identifier cleanId = Identifier.fromNamespaceAndPath(MODID, "block/" + basepath);
        Material material = new Material(cleanId);
        return new TextureMapping().put(TextureSlot.BOTTOM, material).put(TextureSlot.TOP, material).put(TextureSlot.SIDE, material).put(TextureSlot.TEXTURE, material).put(TextureSlot.WALL, material);
    }

    private Material getCleanTexture(Block block, String suffix) {
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        path = path.replace("_breakable", "");
        Identifier cleanId = Identifier.fromNamespaceAndPath(MODID, "block/" + path + suffix);
        return new Material(cleanId);
    }

    private Identifier getCleanTextureId(Block block, String suffix) {
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        path = path.replace("_breakable", "");
        return Identifier.fromNamespaceAndPath(MODID, "block/" + path + suffix);
    }

    private void registerStairs(BlockModelGenerators gen, Block stairs, Block base) {
        if (handledBlocks.contains(stairs)) return;
        handledBlocks.add(stairs);
        TextureMapping mapping = getCleanTextureMapping(base);
        Identifier inner = STAIRS_INNER.create(stairs, mapping, gen.modelOutput);
        Identifier straight = STAIRS_STRAIGHT.create(stairs, mapping, gen.modelOutput);
        Identifier outer = STAIRS_OUTER.create(stairs, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createStairs(stairs, plainVariant(inner), plainVariant(straight), plainVariant(outer)));
        gen.registerSimpleItemModel(stairs.asItem(), straight);
        registeredItems.add(stairs.asItem());
    }

    private void registerSlab(BlockModelGenerators gen, Block slab, Block base) {
        if (handledBlocks.contains(slab)) return;
        handledBlocks.add(slab);
        TextureMapping textures = getCleanTextureMapping(base);
        TextureMapping slabTextures = TextureMapping.column(textures.get(TextureSlot.SIDE), textures.get(TextureSlot.TOP));
        Identifier bottom = SLAB_BOTTOM.create(slab, slabTextures, gen.modelOutput);
        Identifier top = SLAB_TOP.create(slab, slabTextures, gen.modelOutput);
        Identifier doubleSlab = CUBE_COLUMN.createWithOverride(slab, "_double", slabTextures, gen.modelOutput);
        gen.blockStateOutput.accept(createSlab(slab, plainVariant(bottom), plainVariant(top), plainVariant(doubleSlab)));
        gen.registerSimpleItemModel(slab.asItem(), bottom);
        registeredItems.add(slab.asItem());
    }

    private void registerWall(BlockModelGenerators gen, Block wall, Block base) {
        if (handledBlocks.contains(wall)) return;
        handledBlocks.add(wall);
        TextureMapping mapping = getCleanTextureMapping(base);
        Identifier post = WALL_POST.create(wall, mapping, gen.modelOutput);
        Identifier low = WALL_LOW_SIDE.create(wall, mapping, gen.modelOutput);
        Identifier tall = WALL_TALL_SIDE.create(wall, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createWall(wall, plainVariant(post), plainVariant(low), plainVariant(tall)));
        Identifier inventoryModel = WALL_INVENTORY.create(wall, mapping, gen.modelOutput);
        gen.registerSimpleItemModel(wall.asItem(), inventoryModel);
        registeredItems.add(wall.asItem());
    }

    private void registerStandardBlockWithBreakable(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        Material texture = getCleanTexture(block, "");
        TextureMapping mapping = TextureMapping.cube(texture);
        Identifier modelId = ModelTemplates.CUBE_ALL.create(block, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(block, plainVariant(modelId)));
        gen.registerSimpleItemModel(block.asItem(), modelId);
        registeredItems.add(block.asItem());
    }

    private void registerButton(BlockModelGenerators gen, Block button, Block base) {
        if (handledBlocks.contains(button)) return;
        handledBlocks.add(button);
        TextureMapping mapping = getCleanTextureMapping(base);
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
        TextureMapping mapping = getCleanTextureMapping(base);
        Identifier off = PRESSURE_PLATE_UP.create(block, mapping, gen.modelOutput);
        Identifier on = PRESSURE_PLATE_DOWN.create(block, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createPressurePlate(block, plainVariant(off), plainVariant(on)));
        gen.registerSimpleItemModel(block.asItem(), off);
        registeredItems.add(block.asItem());
    }

    private void registerFence(BlockModelGenerators gen, Block fence, Block basePlanks) {
        if (handledBlocks.contains(fence)) return;
        handledBlocks.add(fence);
        TextureMapping mapping = getCleanTextureMapping(basePlanks);
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
        TextureMapping mapping = getCleanTextureMapping(basePlanks);
        Identifier open = FENCE_GATE_OPEN.create(fenceGate, mapping, gen.modelOutput);
        Identifier closed = FENCE_GATE_CLOSED.create(fenceGate, mapping, gen.modelOutput);
        Identifier openWall = FENCE_GATE_WALL_OPEN.create(fenceGate, mapping, gen.modelOutput);
        Identifier closedWall = FENCE_GATE_WALL_CLOSED.create(fenceGate, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createFenceGate(fenceGate, plainVariant(open), plainVariant(closed), plainVariant(openWall), plainVariant(closedWall), false));
        gen.registerSimpleItemModel(fenceGate.asItem(), closed);
        registeredItems.add(fenceGate.asItem());
    }

    private void registerDoor(BlockModelGenerators gen, Block door, Block basePlanks) {
        if (handledBlocks.contains(door)) return;
        handledBlocks.add(door);
        Material topMat = getCleanTexture(door, "_top");
        Material bottomMat = getCleanTexture(door, "_bottom");
        TextureMapping mapping = new TextureMapping().put(TextureSlot.TOP, topMat).put(TextureSlot.BOTTOM, bottomMat).put(TextureSlot.TEXTURE, topMat);
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

    private void registerTrapdoor(BlockModelGenerators gen, Block trapdoor) {
        if (handledBlocks.contains(trapdoor)) return;
        handledBlocks.add(trapdoor);
        TextureMapping mapping = new TextureMapping().put(TextureSlot.TEXTURE, getCleanTexture(trapdoor, ""));
        Identifier bottom = TRAPDOOR_BOTTOM.create(trapdoor, mapping, gen.modelOutput);
        Identifier top = TRAPDOOR_TOP.create(trapdoor, mapping, gen.modelOutput);
        Identifier open = TRAPDOOR_OPEN.create(trapdoor, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createTrapdoor(trapdoor, plainVariant(top), plainVariant(bottom), plainVariant(open)));
        gen.registerSimpleItemModel(trapdoor.asItem(), bottom);
        registeredItems.add(trapdoor.asItem());
    }

    private void registerGrass(BlockModelGenerators gen, Block block, Block baseDirt) {
        handledBlocks.add(block);
        TextureMapping mapping = new TextureMapping().put(TextureSlot.TOP, getCleanTexture(block, "_top")).put(TextureSlot.SIDE, getCleanTexture(block, "_side")).put(TextureSlot.BOTTOM, getCleanTexture(baseDirt, ""));
        Identifier modelId = CUBE_BOTTOM_TOP.create(block, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(block, plainVariant(modelId)));
        gen.registerSimpleItemModel(block.asItem(), modelId);
        registeredItems.add(block.asItem());
    }

    private void registerLeaves(BlockModelGenerators gen, Block leaves) {
        if (handledBlocks.contains(leaves)) return;
        handledBlocks.add(leaves);
        Material mat = getCleanTexture(leaves, "");
        TextureMapping mapping = new TextureMapping().put(TextureSlot.ALL, mat).put(TextureSlot.TEXTURE, mat);
        ModelTemplate template = ExtendedModelTemplateBuilder.of(ModelTemplates.LEAVES).build();
        Identifier modelId = template.create(leaves, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(leaves, plainVariant(modelId)));
        gen.registerSimpleItemModel(leaves.asItem(), modelId);
        registeredItems.add(leaves.asItem());
    }

    private void registerCrossBlock(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        TextureMapping mapping = TextureMapping.cross(block);
        Identifier modelId = CROSS.create(block, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(block, plainVariant(modelId)));
        Item item = block.asItem();
        if (item != Items.AIR) {
            TextureMapping itemMapping = TextureMapping.layer0(block);
            Identifier itemModelId = FLAT_ITEM.create(item, itemMapping, gen.modelOutput);
            gen.registerSimpleItemModel(item, itemModelId);
            registeredItems.add(item);
        }
    }

    private void registerGlassBlock(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        gen.createTrivialBlock(block, TexturedModel.CUBE.updateTexture((mapping) -> mapping.forceAllTranslucent()));
        gen.registerSimpleItemModel(block.asItem(), ModelLocationUtils.getModelLocation(block));
        registeredItems.add(block.asItem());
    }

    private void registerLog(BlockModelGenerators gen, Block log) {
        if (handledBlocks.contains(log)) return;
        handledBlocks.add(log);
        Material sideMat = getCleanTexture(log, "_side");
        Material topMat = getCleanTexture(log, "_top");
        TextureMapping mapping = new TextureMapping().put(TextureSlot.SIDE, sideMat).put(TextureSlot.TOP, topMat).put(TextureSlot.END, topMat);
        createRotatedPillarWithHorizontalVariant(log, gen, m -> ModelTemplates.CUBE_COLUMN.create(log, mapping, gen.modelOutput), m -> ModelTemplates.CUBE_COLUMN.createWithOverride(log, "_horizontal", mapping, gen.modelOutput));
        gen.registerSimpleItemModel(log.asItem(), ModelLocationUtils.getModelLocation(log));
        registeredItems.add(log.asItem());
    }

    private void registerStrippedLog(BlockModelGenerators gen, Block log) {
        if (handledBlocks.contains(log)) return;
        handledBlocks.add(log);
        Material sideMat = getCleanTexture(log, "_side");
        Material topMat = getCleanTexture(log, "_top");
        TextureMapping mapping = new TextureMapping().put(TextureSlot.SIDE, sideMat).put(TextureSlot.TOP, topMat).put(TextureSlot.END, topMat);
        Identifier vertical = ModelTemplates.CUBE_COLUMN.create(log, mapping, gen.modelOutput);
        Identifier horizontal = ModelTemplates.CUBE_COLUMN.createWithOverride(log, "_horizontal", mapping, gen.modelOutput);
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(log).with(PropertyDispatch.initial(BlockStateProperties.AXIS).select(Direction.Axis.Y, plainVariant(vertical)).select(Direction.Axis.Z, plainVariant(horizontal).with(X_ROT_90)).select(Direction.Axis.X, plainVariant(horizontal).with(X_ROT_90).with(Y_ROT_90))));
        gen.registerSimpleItemModel(log.asItem(), vertical);
        registeredItems.add(log.asItem());
    }

    private void registerWood(BlockModelGenerators gen, Block wood, Block logReference) {
        if (handledBlocks.contains(wood)) return;
        handledBlocks.add(wood);
        String logPath = BuiltInRegistries.BLOCK.getKey(logReference).getPath().replace("_breakable", "");
        Material barkTexture = new Material(Identifier.fromNamespaceAndPath(MODID, "block/" + logPath + "_side"));
        TextureMapping mapping = new TextureMapping().put(TextureSlot.SIDE, barkTexture).put(TextureSlot.END, barkTexture);
        Identifier vertical = ModelTemplates.CUBE_COLUMN.create(wood, mapping, gen.modelOutput);
        Identifier horizontal = ModelTemplates.CUBE_COLUMN.createWithOverride(wood, "_horizontal", mapping, gen.modelOutput);
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(wood).with(PropertyDispatch.initial(BlockStateProperties.AXIS).select(Direction.Axis.Y, plainVariant(vertical)).select(Direction.Axis.Z, plainVariant(horizontal).with(X_ROT_90)).select(Direction.Axis.X, plainVariant(horizontal).with(X_ROT_90).with(Y_ROT_90))));
        gen.registerSimpleItemModel(wood.asItem(), vertical);
        registeredItems.add(wood.asItem());
    }

    private void createRotatedPillarWithHorizontalVariant(Block block, BlockModelGenerators gen, Function<Block, Identifier> verticalModel, Function<Block, Identifier> horizontalModel) {
        MultiVariant model = plainVariant(verticalModel.apply(block));
        MultiVariant hModel = plainVariant(horizontalModel.apply(block));
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.AXIS).select(Direction.Axis.Y, model).select(Direction.Axis.Z, hModel.with(X_ROT_90)).select(Direction.Axis.X, hModel.with(X_ROT_90).with(Y_ROT_90))));
    }

    private void registerCarpet(BlockModelGenerators gen, Block carpet, Block baseWool) {
        if (handledBlocks.contains(carpet)) return;
        handledBlocks.add(carpet);
        TextureMapping mapping = TextureMapping.wool(baseWool);
        Identifier modelId = ModelTemplates.CARPET.create(carpet, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(createSimpleBlock(carpet, plainVariant(modelId)));
        gen.registerSimpleItemModel(carpet.asItem(), modelId);
        registeredItems.add(carpet.asItem());
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

        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(HorizontalDirectionalBlock.FACING).select(Direction.NORTH, plainVariant(modelId)).select(Direction.EAST, plainVariant(modelId).with(Y_ROT_90)).select(Direction.SOUTH, plainVariant(modelId).with(Y_ROT_180)).select(Direction.WEST, plainVariant(modelId).with(Y_ROT_270))));
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

    private boolean isHandheldTool(String path) {
        return path.contains("_sword") || path.contains("_pickaxe") || path.contains("_axe") || path.contains("_shovel") || path.contains("_hoe") || path.contains("_shickaxe") || path.contains("_maul") || path.contains("_backsword") || path.contains("_blade") || path.contains("_dagger") || path.contains("_saber") || path.contains("_hammer") || path.contains("_claw") || path.contains("_knife") || path.contains("_trident") || path.contains("aquaton") || path.contains("_stabber") || path.contains("_rapier") || path.contains("death_bringer") || path.contains("flaming_fury") || path.contains("_sabre") || path.contains("icicle_bane") || path.contains("enderice") || path.contains("_sandslash") || path.contains("_snowslash") || path.contains("everlight") || path.contains("_rockmaul") || path.contains("everbright") || path.contains("_anchor") || path.contains("sound_of_") || path.contains("_slicer") || path.contains("_disk") || path.contains("_dissipator") || path.contains("firefly") || path.contains("meriks_missile") || path.contains("scythe") || path.contains("_staff") || path.contains("captains_sparkler") || path.contains("starlight") || path.contains("meteor_mash") || path.contains("evernight") || path.contains("_phaser") || path.contains("_cannon") || path.contains("_blaster") || path.contains("eversight") || path.contains("palavence") || path.contains("massivence") || path.contains("frossivence") || path.contains("divine_accumulator") || path.contains("ender_scepter") || path.contains("staff_of_enrichment") || path.contains("arcanium_attractor") || path.contains("arcanium_reflector") || path.contains("terran_shifter");
    }

    private void registerInserter(BlockModelGenerators gen, Block inserter) {
        if (handledBlocks.contains(inserter)) return;
        handledBlocks.add(inserter);
        TextureMapping mapping = new TextureMapping().put(TextureSlot.BOTTOM, new Material(Identifier.fromNamespaceAndPath(MODID, "block/realmite_block"))).put(TextureSlot.PLATFORM, new Material(Identifier.fromNamespaceAndPath(MODID, "block/inserter_front"))).put(TextureSlot.SIDE, new Material(Identifier.fromNamespaceAndPath(MODID, "block/inserter_side")));
        ModelTemplate pistonTemplate = new ModelTemplate(Optional.of(Identifier.parse("minecraft:block/template_piston")),Optional.empty(), TextureSlot.BOTTOM, TextureSlot.PLATFORM, TextureSlot.SIDE);
        Identifier modelId = pistonTemplate.create(inserter, mapping, gen.modelOutput);
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(inserter).with(PropertyDispatch.initial(BlockStateProperties.FACING).select(Direction.NORTH, plainVariant(modelId)).select(Direction.EAST, plainVariant(modelId).with(Y_ROT_90)).select(Direction.SOUTH, plainVariant(modelId).with(Y_ROT_180)).select(Direction.WEST, plainVariant(modelId).with(Y_ROT_270)).select(Direction.UP, plainVariant(modelId).with(X_ROT_270)).select(Direction.DOWN, plainVariant(modelId).with(X_ROT_90))));
        gen.registerSimpleItemModel(inserter.asItem(), modelId);
        registeredItems.add(inserter.asItem());
    }

    private void registerBed(BlockModelGenerators gen, Block bed) {
        if (handledBlocks.contains(bed)) return;
        handledBlocks.add(bed);
        String path = BuiltInRegistries.BLOCK.getKey(bed).getPath();
        Identifier footModelLoc = Identifier.fromNamespaceAndPath(MODID, "block/" + path + "_foot");
        Identifier headModelLoc = Identifier.fromNamespaceAndPath(MODID, "block/" + path + "_head");
        gen.modelOutput.accept(footModelLoc, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "minecraft:block/template_bed_foot");
            JsonObject textures = new JsonObject();
            textures.addProperty("east", MODID + ":block/" + path + "_foot_east");
            textures.addProperty("south", MODID + ":block/" + path + "_foot_south");
            textures.addProperty("up", MODID + ":block/" + path + "_foot_up");
            textures.addProperty("west", MODID + ":block/" + path + "_foot_west");
            model.add("textures", textures);
            return model;
        });

        gen.modelOutput.accept(headModelLoc, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "minecraft:block/template_bed_head");
            JsonObject textures = new JsonObject();
            textures.addProperty("east", MODID + ":block/" + path + "_head_east");
            textures.addProperty("up", MODID + ":block/" + path + "_head_up");
            textures.addProperty("west", MODID + ":block/" + path + "_head_west");
            model.add("textures", textures);
            return model;
        });
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(bed).with(PropertyDispatch.initial(BedBlock.FACING, BedBlock.PART).select(Direction.NORTH, BedPart.FOOT, plainVariant(footModelLoc)).select(Direction.NORTH, BedPart.HEAD, plainVariant(headModelLoc)).select(Direction.EAST, BedPart.FOOT, plainVariant(footModelLoc).with(Y_ROT_90)).select(Direction.EAST, BedPart.HEAD, plainVariant(headModelLoc).with(Y_ROT_90)).select(Direction.SOUTH, BedPart.FOOT, plainVariant(footModelLoc).with(Y_ROT_180)).select(Direction.SOUTH, BedPart.HEAD, plainVariant(headModelLoc).with(Y_ROT_180)).select(Direction.WEST, BedPart.FOOT, plainVariant(footModelLoc).with(Y_ROT_270)).select(Direction.WEST, BedPart.HEAD, plainVariant(headModelLoc).with(Y_ROT_270))));
        gen.registerSimpleItemModel(bed.asItem(), footModelLoc);
        registeredItems.add(bed.asItem());
    }
    private void registerDoubleCrossBlock(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        Material bottomMat = getCleanTexture(block, "_bottom");
        Material topMat = getCleanTexture(block, "_top");
        TextureMapping bottomMapping = TextureMapping.cross(bottomMat);
        TextureMapping topMapping = TextureMapping.cross(topMat);
        Identifier lowerModel = ModelTemplates.CROSS.createWithOverride(block, "_lower", bottomMapping, gen.modelOutput);
        Identifier upperModel = ModelTemplates.CROSS.createWithOverride(block, "_upper", topMapping, gen.modelOutput);
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.DOUBLE_BLOCK_HALF).select(DoubleBlockHalf.LOWER, plainVariant(lowerModel)).select(DoubleBlockHalf.UPPER, plainVariant(upperModel))));
        Item item = block.asItem();
        if (item != Items.AIR) {
            TextureMapping itemMapping = new TextureMapping().put(TextureSlot.LAYER0, topMat);
            Identifier itemModelId = ModelTemplates.FLAT_ITEM.create(item, itemMapping, gen.modelOutput);
            gen.registerSimpleItemModel(item, itemModelId);
            registeredItems.add(item);
        }
    }
    private void registerArcaniteTubes(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        Identifier modelId = ModelLocationUtils.getModelLocation(block);
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "block/block");
            JsonObject textures = new JsonObject();
            textures.addProperty("0", "divinerpg:block/arcanite_tubes");
            textures.addProperty("particle", "divinerpg:block/arcanite_tubes");
            model.add("textures", textures);
            JsonArray elements = new JsonArray();
            elements.add(createTubeElement("1", 13, 0, 15, 15, 16, 16, 1, 3));
            elements.add(createTubeElement("2", 9, 0, 15, 11, 16, 16, 5, 7));
            elements.add(createTubeElement("3", 5, 0, 15, 7, 16, 16, 9, 11));
            elements.add(createTubeElement("4", 1, 0, 15, 3, 16, 16, 13, 15));
            model.add("elements", elements);
            return model;
        });
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING).select(Direction.NORTH, plainVariant(modelId)).select(Direction.EAST, plainVariant(modelId).with(Y_ROT_90)).select(Direction.SOUTH, plainVariant(modelId).with(Y_ROT_180)).select(Direction.WEST, plainVariant(modelId).with(Y_ROT_270))));
        if (block.asItem() != Items.AIR) {
            gen.registerSimpleItemModel(block.asItem(), modelId);
            registeredItems.add(block.asItem());
        }
    }

    private void registerArcaniteLadder(BlockModelGenerators gen, Block ladder) {
        if (handledBlocks.contains(ladder)) return;
        handledBlocks.add(ladder);
        Identifier modelId = ModelLocationUtils.getModelLocation(ladder);
        String texturePath = MODID + ":block/arcanite_ladder";
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("ambientocclusion", false);
            JsonObject textures = new JsonObject();
            textures.addProperty("particle", texturePath);
            textures.addProperty("texture", texturePath);
            model.add("textures", textures);
            JsonArray elements = new JsonArray();
            JsonObject element = new JsonObject();
            JsonArray from = new JsonArray(); from.add(0); from.add(0); from.add(15.2);
            JsonArray to = new JsonArray(); to.add(16); to.add(16); to.add(15.2);
            element.add("from", from);
            element.add("to", to);
            element.addProperty("shade_direction_override", "up");
            JsonObject faces = new JsonObject();
            JsonObject northFace = new JsonObject();
            JsonArray northUv = new JsonArray(); northUv.add(0); northUv.add(0); northUv.add(16); northUv.add(16);
            northFace.add("uv", northUv);
            northFace.addProperty("texture", "#texture");
            faces.add("north", northFace);
            JsonObject southFace = new JsonObject();
            JsonArray southUv = new JsonArray(); southUv.add(16); southUv.add(0); southUv.add(0); southUv.add(16);
            southFace.add("uv", southUv);
            southFace.addProperty("texture", "#texture");
            faces.add("south", southFace);
            element.add("faces", faces);
            elements.add(element);
            model.add("elements", elements);
            return model;
        });
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(ladder).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING).select(Direction.NORTH, plainVariant(modelId)).select(Direction.EAST, plainVariant(modelId).with(Y_ROT_90)).select(Direction.SOUTH, plainVariant(modelId).with(Y_ROT_180)).select(Direction.WEST, plainVariant(modelId).with(Y_ROT_270))));
        if (ladder.asItem() != Items.AIR) {
            gen.registerSimpleItemModel(ladder.asItem(), modelId);
            registeredItems.add(ladder.asItem());
        }
    }

    private JsonObject createTubeElement(String name, int x1, int y1, int z1, int x2, int y2, int z2, int uvMin, int uvMax) {
        JsonObject element = new JsonObject();
        element.addProperty("name", name);
        JsonArray from = new JsonArray(); from.add(x1); from.add(y1); from.add(z1);
        JsonArray to = new JsonArray(); to.add(x2); to.add(y2); to.add(z2);
        element.add("from", from);
        element.add("to", to);
        int uvMid = uvMin + 1;
        JsonObject faces = new JsonObject();
        faces.add("north", createFace(uvMin, 0, uvMax, 16, null, "#0"));
        faces.add("east", createFace(uvMid, 0, uvMin, 16, null, "#0"));
        faces.add("south", createFace(uvMax, 0, uvMin, 16, null, "#0"));
        faces.add("west", createFace(uvMax, 0, uvMid, 16, null, "#0"));
        faces.add("up", createFace(uvMax, 0, uvMin, 1, null, "#0"));
        faces.add("down", createFace(uvMax, 15, uvMin, 16, null, "#0"));
        element.add("faces", faces);
        return element;
    }
    private void registerCustomStepBlock(BlockModelGenerators gen, Block block, String texturePath) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        Identifier modelId = ModelLocationUtils.getModelLocation(block);
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "block/block");
            JsonObject textures = new JsonObject();
            textures.addProperty("0", texturePath);
            textures.addProperty("particle", texturePath);
            model.add("textures", textures);
            JsonArray elements = new JsonArray();
            elements.add(createStepBox("FirstStep", 1, 13, 15, 15, 15, 16, new int[]{1, 1, 15, 3}, new int[]{1, 1, 2, 3}, new int[]{15, 1, 1, 3}, new int[]{14, 1, 15, 3}, new int[]{15, 1, 1, 2}, new int[]{15, 2, 1, 3}));
            elements.add(createStepBox("LSideTop", 12, 15, 15, 14, 16, 16, new int[]{4, 0, 2, 1}, new int[]{3, 0, 4, 1}, new int[]{2, 0, 4, 1}, new int[]{2, 0, 3, 1}, new int[]{2, 0, 4, 1}, new int[]{2, 0, 4, 1}));
            elements.add(createStepBox("RSideTop", 2, 15, 15, 4, 16, 16, new int[]{14, 0, 12, 1}, new int[]{13, 0, 14, 1}, new int[]{12, 0, 14, 1}, new int[]{12, 0, 13, 1}, new int[]{12, 0, 14, 1}, new int[]{12, 0, 14, 1}));
            elements.add(createStepBox("SecondStep", 1, 9, 15, 15, 11, 16, new int[]{1, 5, 15, 7}, new int[]{1, 5, 2, 7}, new int[]{15, 5, 1, 7}, new int[]{14, 5, 15, 7}, new int[]{15, 5, 1, 6}, new int[]{15, 6, 1, 7}));
            elements.add(createStepBox("LSideTop", 12, 11, 15, 14, 13, 16, new int[]{4, 5, 2, 3}, new int[]{3, 5, 4, 3}, new int[]{2, 5, 4, 3}, new int[]{2, 5, 3, 3}, new int[]{2, 3, 4, 4}, new int[]{2, 4, 4, 5}));
            elements.add(createStepBox("RSideTop", 2, 11, 15, 4, 13, 16, new int[]{14, 5, 12, 3}, new int[]{13, 5, 14, 3}, new int[]{12, 5, 14, 3}, new int[]{12, 5, 13, 3}, new int[]{12, 3, 14, 4}, new int[]{12, 4, 14, 5}));
            elements.add(createStepBox("ThirdStep", 1, 5, 15, 15, 7, 16, new int[]{1, 9, 15, 11}, new int[]{1, 9, 2, 11}, new int[]{15, 9, 1, 11}, new int[]{14, 9, 15, 11}, new int[]{15, 9, 1, 10}, new int[]{15, 10, 1, 11}));
            elements.add(createStepBox("LSideTop", 12, 7, 15, 14, 9, 16, new int[]{4, 9, 2, 7}, new int[]{3, 9, 4, 7}, new int[]{2, 9, 4, 7}, new int[]{2, 9, 3, 7}, new int[]{2, 7, 4, 8}, new int[]{2, 8, 4, 9}));
            elements.add(createStepBox("RSideTop", 2, 7, 15, 4, 9, 16, new int[]{14, 9, 12, 7}, new int[]{13, 9, 14, 7}, new int[]{12, 9, 14, 7}, new int[]{12, 9, 13, 7}, new int[]{12, 7, 14, 8}, new int[]{12, 8, 14, 9}));
            elements.add(createStepBox("FourthStep", 1, 1, 15, 15, 3, 16, new int[]{1, 13, 15, 15}, new int[]{1, 13, 2, 15}, new int[]{15, 13, 1, 15}, new int[]{14, 13, 15, 15}, new int[]{15, 13, 1, 14}, new int[]{15, 14, 1, 15}));
            elements.add(createStepBox("LSideTop", 12, 3, 15, 14, 5, 16, new int[]{4, 13, 2, 11}, new int[]{3, 13, 4, 11}, new int[]{2, 13, 4, 11}, new int[]{2, 13, 3, 11}, new int[]{2, 11, 4, 12}, new int[]{2, 12, 4, 13}));
            elements.add(createStepBox("RSideTop", 2, 3, 15, 4, 5, 16, new int[]{14, 13, 12, 11}, new int[]{13, 13, 14, 11}, new int[]{12, 13, 14, 11}, new int[]{12, 13, 13, 11}, new int[]{12, 11, 14, 12}, new int[]{12, 12, 14, 13}));
            elements.add(createStepBox("LSideBottom", 12, 0, 15, 14, 1, 16, new int[]{4, 15, 2, 16}, new int[]{3, 15, 4, 16}, new int[]{2, 15, 4, 16}, new int[]{2, 15, 3, 16}, new int[]{2, 15, 4, 16}, new int[]{2, 15, 4, 16}));
            elements.add(createStepBox("RSideBottom", 2, 0, 15, 4, 1, 16, new int[]{14, 15, 12, 16}, new int[]{13, 15, 14, 16}, new int[]{12, 15, 14, 16}, new int[]{12, 15, 13, 16}, new int[]{12, 15, 14, 16}, new int[]{12, 15, 14, 16}));
            model.add("elements", elements);
            return model;
        });
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING).select(Direction.NORTH, plainVariant(modelId)).select(Direction.EAST, plainVariant(modelId).with(Y_ROT_90)).select(Direction.SOUTH, plainVariant(modelId).with(Y_ROT_180)).select(Direction.WEST, plainVariant(modelId).with(Y_ROT_270))));
        if (block.asItem() != Items.AIR) {
            gen.registerSimpleItemModel(block.asItem(), modelId);
            registeredItems.add(block.asItem());
        }
    }

    private JsonObject createStepBox(String name, int x1, int y1, int z1, int x2, int y2, int z2, int[] northUv, int[] eastUv, int[] southUv, int[] westUv, int[] upUv, int[] downUv) {
        JsonObject element = new JsonObject();
        element.addProperty("name", name);
        JsonArray from = new JsonArray();
        from.add(Math.min(x1, x2));
        from.add(Math.min(y1, y2));
        from.add(Math.min(z1, z2));
        JsonArray to = new JsonArray();
        to.add(Math.max(x1, x2));
        to.add(Math.max(y1, y2));
        to.add(Math.max(z1, z2));
        element.add("from", from);
        element.add("to", to);
        JsonObject faces = new JsonObject();
        faces.add("north", createFace(northUv[0], northUv[1], northUv[2], northUv[3], null, "#0"));
        faces.add("east", createFace(eastUv[0], eastUv[1], eastUv[2], eastUv[3], null, "#0"));
        faces.add("south", createFace(southUv[0], southUv[1], southUv[2], southUv[3], null, "#0"));
        faces.add("west", createFace(westUv[0], westUv[1], westUv[2], westUv[3], null, "#0"));
        faces.add("up", createFace(upUv[0], upUv[1], upUv[2], upUv[3], null, "#0"));
        faces.add("down", createFace(downUv[0], downUv[1], downUv[2], downUv[3], null, "#0"));
        element.add("faces", faces);
        return element;
    }

    private void registerLadder(BlockModelGenerators gen, Block ladder) {
        if (handledBlocks.contains(ladder)) return;
        handledBlocks.add(ladder);
        Identifier modelId = ModelLocationUtils.getModelLocation(ladder);
        String path = BuiltInRegistries.BLOCK.getKey(ladder).getPath().replace("_breakable", "");
        String texturePath = MODID + ":block/" + path;
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("ambientocclusion", false);
            JsonObject textures = new JsonObject();
            textures.addProperty("particle", texturePath);
            textures.addProperty("texture", texturePath);
            model.add("textures", textures);
            JsonArray elements = new JsonArray();
            JsonObject element = new JsonObject();
            JsonArray from = new JsonArray(); from.add(0); from.add(0); from.add(15.2);
            JsonArray to = new JsonArray(); to.add(16); to.add(16); to.add(15.2);
            element.add("from", from);
            element.add("to", to);
            element.addProperty("shade_direction_override", "up");
            JsonObject faces = new JsonObject();
            JsonObject northFace = new JsonObject();
            JsonArray northUv = new JsonArray(); northUv.add(0); northUv.add(0); northUv.add(16); northUv.add(16);
            northFace.add("uv", northUv);
            northFace.addProperty("texture", "#texture");
            faces.add("north", northFace);
            JsonObject southFace = new JsonObject();
            JsonArray southUv = new JsonArray(); southUv.add(16); southUv.add(0); southUv.add(0); southUv.add(16);
            southFace.add("uv", southUv);
            southFace.addProperty("texture", "#texture");
            faces.add("south", southFace);
            element.add("faces", faces);
            elements.add(element);
            model.add("elements", elements);
            return model;
        });
        gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(ladder).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING).select(Direction.NORTH, plainVariant(modelId)).select(Direction.EAST, plainVariant(modelId).with(Y_ROT_90)).select(Direction.SOUTH, plainVariant(modelId).with(Y_ROT_180)).select(Direction.WEST, plainVariant(modelId).with(Y_ROT_270))));
        gen.registerSimpleItemModel(ladder.asItem(), modelId);
        registeredItems.add(ladder.asItem());
    }
    private void registerArcanaPortal(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        Identifier modelId = ModelLocationUtils.getModelLocation(block);
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "block/block");
            JsonObject textures = new JsonObject();
            textures.addProperty("particle", "divinerpg:block/arcana_portal");
            textures.addProperty("portal", "divinerpg:block/arcana_portal");
            model.add("textures", textures);
            JsonArray elements = new JsonArray();
            JsonObject element = new JsonObject();
            JsonArray from = new JsonArray(); from.add(0); from.add(6); from.add(0);
            JsonArray to = new JsonArray(); to.add(16); to.add(12); to.add(16);
            element.add("from", from);
            element.add("to", to);
            JsonObject faces = new JsonObject();
            JsonObject up = new JsonObject();
            JsonArray uvUp = new JsonArray(); uvUp.add(0); uvUp.add(0); uvUp.add(16); uvUp.add(16);
            up.add("uv", uvUp);
            up.addProperty("texture", "#portal");
            faces.add("up", up);
            JsonObject down = new JsonObject();
            JsonArray uvDown = new JsonArray(); uvDown.add(0); uvDown.add(0); uvDown.add(16); uvDown.add(16);
            down.add("uv", uvDown);
            down.addProperty("cullface", "down");
            down.addProperty("texture", "#portal");
            faces.add("down", down);
            element.add("faces", faces);
            elements.add(element);
            model.add("elements", elements);
            return model;
        });
        gen.blockStateOutput.accept(createSimpleBlock(block, plainVariant(modelId)));
    }
    private void registerArcaniumExtractor(BlockModelGenerators gen, Block block) {
        if (handledBlocks.contains(block)) return;
        handledBlocks.add(block);
        Identifier modelId = ModelLocationUtils.getModelLocation(block);
        gen.modelOutput.accept(modelId, () -> {
            JsonObject model = new JsonObject();
            model.addProperty("parent", "block/block");
            JsonObject textures = new JsonObject();
            textures.addProperty("particle", "divinerpg:block/arcanium_extractor");
            textures.addProperty("all", "divinerpg:block/arcanium_extractor");
            model.add("textures", textures);
            return model;
        });
        gen.blockStateOutput.accept(MultiPartGenerator.multiPart(block).with(plainVariant(modelId)));
        gen.itemModelOutput.accept(block.asItem(), new SpecialModelWrapper.Unbaked(modelId, Optional.of(new Transformation(new Matrix4f().scale(0.75F))), new ArcaniumExtractorItemRenderer.Unbaked()));
        registeredItems.add(block.asItem());
    }
}