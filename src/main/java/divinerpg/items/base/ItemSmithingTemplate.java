package divinerpg.items.base;

import java.util.List;
import divinerpg.DivineRPG;
import net.minecraft.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

public class ItemSmithingTemplate {
	private static final Component
		BEDROCK_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.bedrock_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
		BEDROCK_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.bedrock_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
		BEDROCK_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(DivineRPG.MODID, "bedrock_upgrade"))).withStyle(ChatFormatting.GRAY),
		BEDROCK_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.bedrock_upgrade.base_slot_description"))),
		BEDROCK_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.bedrock_upgrade.additions_slot_description")));
	private static final Component
		AQUATIC_COATING_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.aquatic_coating.applies_to"))).withStyle(ChatFormatting.BLUE),
		AQUATIC_COATING_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.aquatic_coating.ingredients"))).withStyle(ChatFormatting.BLUE),
		AQUATIC_COATING = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(DivineRPG.MODID, "aquatic_coating"))).withStyle(ChatFormatting.GRAY),
		AQUATIC_COATING_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.aquatic_coating.base_slot_description"))),
		AQUATIC_COATING_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.aquatic_coating.additions_slot_description")));
	private static final Component
		COLOR_TEMPLATE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.color_template.applies_to"))).withStyle(ChatFormatting.BLUE),
		COLOR_TEMPLATE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.color_template.ingredients"))).withStyle(ChatFormatting.BLUE),
		COLOR_TEMPLATE = Component.translatable(Util.makeDescriptionId("trim_pattern", new ResourceLocation(DivineRPG.MODID, "color_template"))).withStyle(ChatFormatting.GRAY),
		COLOR_TEMPLATE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.color_template.base_slot_description"))),
		COLOR_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(DivineRPG.MODID, "smithing_template.color_template.additions_slot_description")));
	private static final ResourceLocation
		EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet"),
		EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate"),
		EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings"),
		EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots"),
		EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword"),
		EMPTY_SLOT_BEDROCK = new ResourceLocation(DivineRPG.MODID, "item/empty_slot_bedrock_chunk"),
		EMPTY_SLOT_KRAKEN_SKIN = new ResourceLocation(DivineRPG.MODID, "item/empty_slot_kraken_skin"),
		EMPTY_SLOT_DIAMOND_CHUNK = new ResourceLocation(DivineRPG.MODID, "item/empty_slot_diamond_chunk");
	public static SmithingTemplateItem createBedrockUpgrade() {
		return new SmithingTemplateItem(BEDROCK_UPGRADE_APPLIES_TO, BEDROCK_UPGRADE_INGREDIENTS, BEDROCK_UPGRADE, BEDROCK_UPGRADE_BASE_SLOT_DESCRIPTION, BEDROCK_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createBedrockUpgradeIconList(), createBedrockUpgradeMaterialList());
	}
	public static SmithingTemplateItem createAquaticCoating() {
		return new SmithingTemplateItem(AQUATIC_COATING_APPLIES_TO, AQUATIC_COATING_INGREDIENTS, AQUATIC_COATING, AQUATIC_COATING_BASE_SLOT_DESCRIPTION, AQUATIC_COATING_ADDITIONS_SLOT_DESCRIPTION, createAquaticCoatingIconList(), createAquaticCoatingMaterialList());
	}
	public static SmithingTemplateItem createColorTemplate() {
		return new SmithingTemplateItem(COLOR_TEMPLATE_APPLIES_TO, COLOR_TEMPLATE_INGREDIENTS, COLOR_TEMPLATE, COLOR_TEMPLATE_BASE_SLOT_DESCRIPTION, COLOR_TEMPLATE_ADDITIONS_SLOT_DESCRIPTION, createWeaponUpgradeIconList(), createColorTemplateMaterialList());
	}
	public static List<ResourceLocation> createAquaticCoatingIconList() {
		return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
	}
	public static List<ResourceLocation> createBedrockUpgradeIconList() {
		return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
	}
	public static List<ResourceLocation> createWeaponUpgradeIconList() {
		return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS, EMPTY_SLOT_SWORD);
	}
	public static List<ResourceLocation> createAquaticCoatingMaterialList() {
		return List.of(EMPTY_SLOT_KRAKEN_SKIN);
	}
	public static List<ResourceLocation> createBedrockUpgradeMaterialList() {
		return List.of(EMPTY_SLOT_BEDROCK);
	}
	public static List<ResourceLocation> createColorTemplateMaterialList() {
		return List.of(EMPTY_SLOT_DIAMOND_CHUNK);
	}
}