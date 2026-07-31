package divinerpg.items.base;

import java.util.List;

import divinerpg.DivineRPG;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

import static divinerpg.DivineRPG.MODID;

public class ItemSmithingTemplate {
    private static final Component
            BEDROCK_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.bedrock_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
            BEDROCK_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.bedrock_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
            BEDROCK_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", Identifier.fromNamespaceAndPath(MODID, "bedrock_upgrade"))).withStyle(ChatFormatting.GRAY),
            BEDROCK_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.bedrock_upgrade.base_slot_description"))),
            BEDROCK_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.bedrock_upgrade.additions_slot_description")));

    private static final Component
            AQUATIC_COATING_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.aquatic_coating.applies_to"))).withStyle(ChatFormatting.BLUE),
            AQUATIC_COATING_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.aquatic_coating.ingredients"))).withStyle(ChatFormatting.BLUE),
            AQUATIC_COATING = Component.translatable(Util.makeDescriptionId("upgrade", Identifier.fromNamespaceAndPath(MODID, "aquatic_coating"))).withStyle(ChatFormatting.GRAY),
            AQUATIC_COATING_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.aquatic_coating.base_slot_description"))),
            AQUATIC_COATING_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.aquatic_coating.additions_slot_description")));

    private static final Component
            COLOR_TEMPLATE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.color_template.applies_to"))).withStyle(ChatFormatting.BLUE),
            COLOR_TEMPLATE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.color_template.ingredients"))).withStyle(ChatFormatting.BLUE),
            COLOR_TEMPLATE = Component.translatable(Util.makeDescriptionId("trim_pattern", Identifier.fromNamespaceAndPath(MODID, "color_template"))).withStyle(ChatFormatting.GRAY),
            COLOR_TEMPLATE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.color_template.base_slot_description"))),
            COLOR_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(MODID, "smithing_template.color_template.additions_slot_description")));

    private static final Identifier
            EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("item/empty_armor_slot_helmet"),
            EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("item/empty_armor_slot_chestplate"),
            EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("item/empty_armor_slot_leggings"),
            EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("item/empty_armor_slot_boots"),
            EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("item/empty_slot_sword"),
            EMPTY_SLOT_BEDROCK = Identifier.fromNamespaceAndPath(MODID, "item/empty_slot_bedrock_chunk"),
            EMPTY_SLOT_KRAKEN_SKIN = Identifier.fromNamespaceAndPath(MODID, "item/empty_slot_kraken_skin"),
            EMPTY_SLOT_DIAMOND_CHUNK = Identifier.fromNamespaceAndPath(MODID, "item/empty_slot_diamond_chunk");

    public static SmithingTemplateItem createBedrockUpgrade() {
        return new SmithingTemplateItem(BEDROCK_UPGRADE_APPLIES_TO, BEDROCK_UPGRADE_INGREDIENTS, BEDROCK_UPGRADE_BASE_SLOT_DESCRIPTION, BEDROCK_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createArmorIconList(), createBedrockUpgradeMaterialList(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "bedrock_upgrade_template"))));
    }

    public static SmithingTemplateItem createAquaticCoating() {
        return new SmithingTemplateItem(AQUATIC_COATING_APPLIES_TO, AQUATIC_COATING_INGREDIENTS, AQUATIC_COATING_BASE_SLOT_DESCRIPTION, AQUATIC_COATING_ADDITIONS_SLOT_DESCRIPTION, createArmorIconList(), createAquaticCoatingMaterialList(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "aquatic_coating_template"))));
    }

    public static SmithingTemplateItem createColorTemplate() {
        return new SmithingTemplateItem(COLOR_TEMPLATE_APPLIES_TO, COLOR_TEMPLATE_INGREDIENTS, COLOR_TEMPLATE_BASE_SLOT_DESCRIPTION, COLOR_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION, createWeaponUpgradeIconList(), createColorTemplateMaterialList(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "color_template"))));
    }

    private static List<Identifier> createArmorIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<Identifier> createWeaponUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS, EMPTY_SLOT_SWORD);
    }

    private static List<Identifier> createBedrockUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_BEDROCK);
    }

    private static List<Identifier> createAquaticCoatingMaterialList() {
        return List.of(EMPTY_SLOT_KRAKEN_SKIN);
    }

    private static List<Identifier> createColorTemplateMaterialList() {
        return List.of(EMPTY_SLOT_DIAMOND_CHUNK);
    }
}